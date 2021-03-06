/**
 * Copyright (c) 2003-2017 The Apereo Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *             http://opensource.org/licenses/ecl2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sakaiproject.assignment.entityproviders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.sakaiproject.assignment.api.AssignmentConstants;
import org.sakaiproject.assignment.api.AssignmentReferenceReckoner;
import org.sakaiproject.assignment.api.AssignmentService;
import org.sakaiproject.assignment.api.AssignmentServiceConstants;
import org.sakaiproject.assignment.api.model.Assignment;
import org.sakaiproject.assignment.api.model.Assignment.GradeType;
import org.sakaiproject.assignment.api.model.AssignmentAllPurposeItem;
import org.sakaiproject.assignment.api.model.AssignmentModelAnswerItem;
import org.sakaiproject.assignment.api.model.AssignmentNoteItem;
import org.sakaiproject.assignment.api.model.AssignmentSubmission;
import org.sakaiproject.assignment.api.model.AssignmentSupplementItemService;
import org.sakaiproject.authz.api.SecurityAdvisor;
import org.sakaiproject.authz.api.SecurityService;
import org.sakaiproject.component.api.ServerConfigurationService;
import org.sakaiproject.content.api.ContentHostingService;
import org.sakaiproject.content.api.ContentResource;
import org.sakaiproject.entity.api.Entity;
import org.sakaiproject.entity.api.EntityManager;
import org.sakaiproject.entity.api.Reference;
import org.sakaiproject.entity.api.ResourcePropertiesEdit;
import org.sakaiproject.entitybroker.EntityBroker;
import org.sakaiproject.entitybroker.EntityReference;
import org.sakaiproject.entitybroker.EntityView;
import org.sakaiproject.entitybroker.entityprovider.CoreEntityProvider;
import org.sakaiproject.entitybroker.entityprovider.EntityProvider;
import org.sakaiproject.entitybroker.entityprovider.annotations.EntityCustomAction;
import org.sakaiproject.entitybroker.entityprovider.capabilities.ActionsExecutable;
import org.sakaiproject.entitybroker.entityprovider.capabilities.AutoRegisterEntityProvider;
import org.sakaiproject.entitybroker.entityprovider.capabilities.Describeable;
import org.sakaiproject.entitybroker.entityprovider.capabilities.Inputable;
import org.sakaiproject.entitybroker.entityprovider.capabilities.Outputable;
import org.sakaiproject.entitybroker.entityprovider.capabilities.PropertyProvideable;
import org.sakaiproject.entitybroker.entityprovider.capabilities.Resolvable;
import org.sakaiproject.entitybroker.entityprovider.extension.ActionReturn;
import org.sakaiproject.entitybroker.entityprovider.extension.Formats;
import org.sakaiproject.entitybroker.exception.EntityException;
import org.sakaiproject.entitybroker.exception.EntityNotFoundException;
import org.sakaiproject.entitybroker.util.AbstractEntityProvider;
import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.exception.PermissionException;
import org.sakaiproject.service.gradebook.shared.GradebookExternalAssessmentService;
import org.sakaiproject.service.gradebook.shared.GradebookService;
import org.sakaiproject.site.api.Site;
import org.sakaiproject.site.api.SiteService;
import org.sakaiproject.site.api.ToolConfiguration;
import org.sakaiproject.tool.api.SessionManager;
import org.sakaiproject.user.api.User;
import org.sakaiproject.user.api.UserDirectoryService;
import org.sakaiproject.user.api.UserNotDefinedException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AssignmentEntityProvider extends AbstractEntityProvider implements EntityProvider,
CoreEntityProvider, Resolvable, ActionsExecutable, Describeable,
AutoRegisterEntityProvider, PropertyProvideable, Outputable, Inputable {

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ssZ" );
	public final static String ENTITY_PREFIX = "assignment";
	@Setter private AssignmentService assignmentService;
	@Setter private EntityBroker entityBroker;
	@Setter private SecurityService securityService;
	@Setter private SessionManager sessionManager;
	@Setter private SiteService siteService;
	@Setter private AssignmentSupplementItemService assignmentSupplementItemService;
	@Setter private GradebookService gradebookService;
	@Setter private GradebookExternalAssessmentService gradebookExternalService;
	@Setter private ServerConfigurationService serverConfigurationService;
	@Setter
	private UserDirectoryService userDirectoryService;
	@Setter
	private ContentHostingService contentHostingService;
	@Setter
	private EntityManager entityManager;

	// HTML is deliberately not handled here, so that it will be handled by RedirectingAssignmentEntityServlet
	public String[] getHandledOutputFormats() {
		return new String[]{Formats.XML, Formats.JSON, Formats.FORM};
	}

	public String[] getHandledInputFormats() {
		return new String[]{Formats.HTML, Formats.XML, Formats.JSON,
				Formats.FORM};
	}

	public Object getSampleEntity() {
		return new SimpleAssignment();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.sakaiproject.entitybroker.entityprovider.EntityProvider#getEntityPrefix
	 * ()
	 */
	public String getEntityPrefix() {
		return ENTITY_PREFIX;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.sakaiproject.entitybroker.entityprovider.CoreEntityProvider#entityExists
	 * (java.lang.String)
	 */
	public boolean entityExists(String id) {
		boolean rv = false;
		// This will look up the ref from the database, so if ref is not null,
		// that means it found one.
		String ref = assignmentService.assignmentReference(id);
		if (ref != null) {
			rv = true;
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.sakaiproject.entitybroker.entityprovider.capabilities.Resolvable#
	 * getEntity(org.sakaiproject.entitybroker.EntityReference)
	 */
	public Object getEntity(EntityReference ref) {
		if (ref == null || ref.getId() == null) {
			throw new IllegalArgumentException(
					"ref and id must be set for assignments");
		}
		SimpleAssignment assignment;
		try {
			assignment = new SimpleAssignment(
					assignmentService.getAssignment(ref.getId()));
		} catch (IdUnusedException e) {
			throw new EntityNotFoundException("No assignment found: " + ref,
					ref.toString(), e);
		} catch (PermissionException e) {
			throw new SecurityException(e);
		}
		return assignment;
	}

	@EntityCustomAction(action = "annc", viewKey = EntityView.VIEW_LIST)
	public Map<String, Object> getAssignDataForAnnouncement(EntityView view,
			Map<String, Object> params) {
		Map<String, Object> assignData = new HashMap<String, Object>();

		String context = view.getPathSegment(2);
		String assignmentId = view.getPathSegment(3);
		if (context == null || assignmentId == null) {
			// format of the view should be in a standard assignment reference
			throw new IllegalArgumentException(
					"Must include context and assignmentId in the path ("
							+ view
							+ "): e.g. /assignment/a/{context}/{assignmentId}");
		}

		SecurityAdvisor securityAdvisor = createSecurityAdvisor(
				sessionManager.getCurrentSessionUserId(),
				AssignmentServiceConstants.SECURE_ADD_ASSIGNMENT,
				assignmentService.assignmentReference(null, context)
				);

		try {
			// enable permission to view possible draft assignment
			securityService.pushAdvisor(securityAdvisor);

			Assignment a = assignmentService.getAssignment(assignmentService
					.assignmentReference(context, assignmentId));
			assignData.put("assignment", a);
			assignData.put("context", context);
			assignData.put("assignmentId", assignmentId);

			// This is for checking to see if there is a link to announcements
			// in the assignment
			String announcementCheck = a.getProperties().get("CHEF:assignment_opendate_announcement_message_id");

			// the message id passed in through parameters
			String messageId = (String) params.get("messageId");

			// Lots of checks to make absolutely sure this is the assignment we
			// are looking for
			if (announcementCheck != null && !"".equals(announcementCheck)
					&& messageId != null && !"".equals(messageId)
					&& announcementCheck.equals(messageId)) {
				assignData.put("assignmentTitle", a.getTitle());
				String assignmentContext = a.getContext(); // assignment context
				boolean allowReadAssignment = assignmentService
						.allowGetAssignment(assignmentContext);
				// check for read permission
				if (allowReadAssignment
						&& a.getOpenDate().isBefore(Instant.now())) {
					// this checks if we want to display an assignment link
					try {
						Site site = siteService.getSite(assignmentContext); // site id
						ToolConfiguration fromTool = site
								.getToolForCommonId("sakai.assignment.grades");
						boolean allowAddAssignment = assignmentService
								.allowAddAssignment(assignmentContext);
						// this checks for the asn.new permission and
						// determines the url we present the user
						boolean allowSubmitAssignment = assignmentService
								.allowAddSubmission(assignmentContext);
						// this checks for the asn.submit permission and
						// determines the url we present the user

						// Three different urls to be rendered depending on the
						// user's permission
						if (allowAddAssignment) {
							assignData
							.put("assignmentUrl",
									serverConfigurationService
									.getPortalUrl()
									+ "/directtool/"
									+ fromTool.getId()
									+ "?assignmentId="
									+ a.getId()
									+ "&panel=Main&sakai_action=doView_assignment");
						} else if (allowSubmitAssignment) {
							assignData
							.put("assignmentUrl",
									serverConfigurationService
									.getPortalUrl()
									+ "/directtool/"
									+ fromTool.getId()
									+ "?assignmentReference="
									+ AssignmentReferenceReckoner.reckoner().assignment(a).reckon().getReference()
									+ "&panel=Main&sakai_action=doView_submission");
						} else {
							// user can read the assignment, but not submit, so
							// render the appropriate url
							assignData
							.put("assignmentUrl",
									serverConfigurationService
									.getPortalUrl()
									+ "/directtool/"
									+ fromTool.getId()
									+ "?assignmentId="
									+ a.getId()
									+ "&panel=Main&sakai_action=doView_assignment_as_student");
						}
					} catch (IdUnusedException e) {
						// No site found
						assignData.remove("assignment");
						assignData.remove("context");
						assignData.remove("assignmentId");
						assignData.remove("assignmentTitle");
						assignData.remove("assignmentUrl");
						throw new IdUnusedException(
								"No site found while creating assignment url");
					}
				}
			}
		} catch (IdUnusedException e) {
			assignData.remove("assignment");
			assignData.remove("context");
			assignData.remove("assignmentId");
			assignData.remove("assignmentTitle");
			assignData.remove("assignmentUrl");
			throw new EntityNotFoundException("No assignment found",
					assignmentId, e);
		} catch (PermissionException e) {
			assignData.remove("assignment");
			assignData.remove("context");
			assignData.remove("assignmentId");
			assignData.remove("assignmentTitle");
			assignData.remove("assignmentUrl");
			throw new SecurityException(e);
		} finally {
			securityService.popAdvisor(securityAdvisor);
		}
		return assignData;
	}

	private SecurityAdvisor createSecurityAdvisor(String currentUserId, String requiredFunction, String requiredReference) {
		return (userId, function, reference) -> currentUserId.equals(userId) &&
				requiredFunction.equals(function) &&
				requiredReference.equals(reference)
				? SecurityAdvisor.SecurityAdvice.ALLOWED
						: SecurityAdvisor.SecurityAdvice.PASS
						;
	}

	@EntityCustomAction(action = "deepLinkWithPermissions", viewKey = EntityView.VIEW_LIST)
	public Map<String, String> getAssignmentDeepLinks(EntityView view,
			Map<String, Object> params) {

		String context = view.getPathSegment(2);
		String assignmentId = view.getPathSegment(3);
		if (context == null || assignmentId == null) {
			// format of the view should be in a standard assignment reference
			throw new IllegalArgumentException(
					"Must include context and assignmentId in the path ("
							+ view
							+ "): e.g. /direct/assignment/deepLinkWithPermissions/{context}/{assignmentId}");
		}

		Map<String, String> assignData = new HashMap<String, String>();

		try {
			Assignment a = assignmentService.getAssignment(assignmentId);
			assignData.put("assignmentId", assignmentId);
			assignData.put("assignmentTitle", a.getTitle());

			boolean allowReadAssignment = params.get("allowReadAssignment") != null ? ((Boolean) params
					.get("allowReadAssignment")).booleanValue() : false;
					boolean allowAddAssignment = params.get("allowAddAssignment") != null ? ((Boolean) params
							.get("allowAddAssignment")).booleanValue() : false;
							boolean allowSubmitAssignment = params.get("allowSubmitAssignment") != null ? ((Boolean) params
									.get("allowSubmitAssignment")).booleanValue() : false;

									assignData.put("assignmentUrl"
											, assignmentService.getDeepLinkWithPermissions(context, assignmentId
													, allowReadAssignment, allowAddAssignment, allowSubmitAssignment));
		} catch (IdUnusedException e) {
			throw new EntityNotFoundException("Assignment or site not found", assignmentId, e);
		} catch (PermissionException e) {
			throw new SecurityException(e);
		} catch (Exception e) {
			throw new EntityException(e.getMessage(), assignmentId);
		}
		return assignData;
	}

	@EntityCustomAction(action = "deepLink", viewKey = EntityView.VIEW_LIST)
	public Map<String, String> getAssignmentDeepLink(EntityView view,
			Map<String, Object> params) {

		String context = view.getPathSegment(2);
		String assignmentId = view.getPathSegment(3);
		if (context == null || assignmentId == null) {
			// format of the view should be in a standard assignment reference
			throw new IllegalArgumentException(
					"Must include context and assignmentId in the path ("
							+ view
							+ "): e.g. /direct/assignment/deepLink/{context}/{assignmentId}");
		}

		Map<String, String> assignData = new HashMap<String, String>();

		try {
			Assignment a = assignmentService.getAssignment(assignmentId);
			assignData.put("assignmentId", assignmentId);
			assignData.put("assignmentTitle", a.getTitle());
			assignData.put("assignmentUrl", assignmentService.getDeepLink(context, assignmentId));
		} catch (IdUnusedException e) {
			throw new EntityNotFoundException("Assignment or site not found", assignmentId, e);
		} catch (PermissionException e) {
			throw new SecurityException(e);
		} catch (Exception e) {
			throw new EntityException(e.getMessage(), assignmentId);
		}
		return assignData;
	}

	/**
	 * site/siteId
	 */
	@EntityCustomAction(action = "site", viewKey = EntityView.VIEW_LIST)
	public List<?> getAssignmentsForSite(EntityView view,
			Map<String, Object> params) {
		List<SimpleAssignment> rv = new ArrayList<SimpleAssignment>();
		String siteId = view.getPathSegment(2);

		// check user can access this site
		Site site;
		try {
			site = siteService.getSiteVisit(siteId);
		} catch (IdUnusedException e) {
			throw new EntityNotFoundException("Invalid siteId: " + siteId, siteId);
		} catch (PermissionException e) {
			throw new EntityNotFoundException("No access to site: " + siteId, siteId);
		}

		assignmentService.getAssignmentsForContext(siteId).stream().map(SimpleAssignment::new).forEach(rv::add);
		return rv;
	}

	/**
	 * my
	 */
	@EntityCustomAction(action = "my", viewKey = EntityView.VIEW_LIST)
	public List<?> getMyAssignmentsForAllSite(EntityView view,
			Map<String, Object> params) {
		List<SimpleAssignment> rv = new ArrayList<SimpleAssignment>();
		String userId = sessionManager.getCurrentSessionUserId();

		// get list of all sites
		List<Site> sites = siteService.getSites(SiteService.SelectionType.ACCESS, null, null, null, SiteService.SortType.TITLE_ASC, null);
		// no need to check user can access this site, as the get sites only returned accessible sites

		// get all assignments from each site
		for (Site site : sites) {
			String siteId = site.getId();
			assignmentService.getAssignmentsForContext(siteId).stream().map(SimpleAssignment::new).forEach(rv::add);
		}

		return rv;

	}

	@Data
	public class SimpleAssignmentSubmission {

		private String assignmentId;
		private String submissionId;
		private String submitterId;
		private String grade;
		private String status;
		private String submissionType;
		private List<Map<String, String>> attachmentList;

		public SimpleAssignmentSubmission() {
		}

		public SimpleAssignmentSubmission(String assignmentId, String submissionId, String submitterId, String grade,
				String status, String submissionType, List<Map<String, String>> attachmentList) {
			super();
			this.assignmentId = assignmentId;
			this.submissionId = submissionId;
			this.submitterId = submitterId;
			this.grade = grade;
			this.status = status;
			this.submissionType = submissionType;
			this.attachmentList = attachmentList;
		}
	}

	/**
	 * item/assignmentId
	 */
	@EntityCustomAction(action = "item", viewKey = EntityView.VIEW_LIST)
	public SimpleAssignment getAssignment(EntityView view,
			Map<String, Object> params) {
		String assignmentId = view.getPathSegment(2);

		// check user can access this assignment
		Assignment a;
		try {
			a = assignmentService.getAssignment(assignmentId);
		} catch (IdUnusedException e) {
			throw new EntityNotFoundException("Invalid assignment id: " + assignmentId, assignmentId);
		} catch (PermissionException e) {
			throw new EntityNotFoundException("No access to assignment: " + assignmentId, assignmentId);
		}
		return new SimpleAssignment(a);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.sakaiproject.entitybroker.entityprovider.extension.PropertiesProvider
	 * #findEntityRefs(java.lang.String[], java.lang.String[],
	 * java.lang.String[], boolean)
	 */
	public List<String> findEntityRefs(String[] prefixes, String[] name,
			String[] searchValue, boolean exactMatch) {
		String siteId = null;
		String userId = null;
		List<String> rv = new ArrayList<String>();

		if (ENTITY_PREFIX.equals(prefixes[0])) {

			for (int i = 0; i < name.length; i++) {
				if ("context".equalsIgnoreCase(name[i])
						|| "site".equalsIgnoreCase(name[i]))
					siteId = searchValue[i];
				else if ("user".equalsIgnoreCase(name[i])
						|| "userId".equalsIgnoreCase(name[i]))
					userId = searchValue[i];
			}

			if (siteId != null) {
				// filter to obtain only grade-able assignments
				for (Assignment assignment : assignmentService.getAssignmentsForContext(siteId)) {
					if (!assignment.getDraft() && assignmentService.allowGradeSubmission(AssignmentReferenceReckoner.reckoner().assignment(assignment).reckon().getReference())) {
						rv.add(Entity.SEPARATOR + ENTITY_PREFIX + Entity.SEPARATOR + assignment.getId());
					}
				}
			}
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.sakaiproject.entitybroker.entityprovider.extension.PropertiesProvider
	 * #getProperties(java.lang.String)
	 */
	public Map<String, String> getProperties(String reference) {
		Map<String, String> props = new HashMap<String, String>();
		String defaultView = "doView_submission";
		String[] refParts = reference.split(Entity.SEPARATOR);
		String submissionId = "null"; // setting to the string null
		String decWrapper = null;
		String decWrapperTag = "";
		String decSiteId = "";
		String decPageId = "";

		String assignmentId = refParts[2];
		if (refParts.length >= 4) {
			defaultView = refParts[3];
			if (refParts.length >= 5) {
				submissionId = refParts[4].replaceAll("_", Entity.SEPARATOR);
			}
			if (refParts.length >= 6) {
				decWrapper = refParts[5].replaceAll("_", Entity.SEPARATOR);
				if (decWrapper != null && !"".equals(decWrapper)) {
					String[] splitDec = decWrapper.split(Entity.SEPARATOR);
					if (splitDec.length == 3) {
						decWrapperTag = splitDec[0];
						decSiteId = splitDec[1];
						decPageId = splitDec[2];
					}
				}
			}
		}

		boolean canUserAccessWizardPageAndLinkedArtifcact = false;
		if (!"".equals(decSiteId) && !"".equals(decPageId)
				&& !"null".equals(submissionId)) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("siteId", decSiteId);
			params.put("pageId", decPageId);
			params.put("linkedArtifactId", submissionId);
			ActionReturn ret = entityBroker.executeCustomAction("/matrixcell/"
					+ decPageId, "canUserAccessWizardPageAndLinkedArtifcact",
					params, null);
			if (ret != null && ret.getEntityData() != null) {
				Object returnData = ret.getEntityData().getData();
				canUserAccessWizardPageAndLinkedArtifcact = (Boolean) returnData;
			}
		}

		try {
			Assignment assignment = assignmentService.getAssignment(assignmentId);
			Entity entity = assignmentService.createAssignmentEntity(assignment);
			props.put("title", assignment.getTitle());
			props.put("author", assignment.getAuthor());
			props.put("description", entity.getReference());
			props.put("draft", "" + assignment.getDraft());
			props.put("siteId", assignment.getContext());
			props.put("section", assignment.getSection());
			props.put("status", assignmentService.getAssignmentCannonicalStatus(assignmentId).toString());
			props.put("portalURL", entity.getUrl());
			if (assignment.getDateCreated() != null) {
				props.put("created_time", assignment.getDateCreated().toString());
			}
			if (assignment.getModifier() != null) {
				props.put("modified_by", assignment.getModifier());
			}
			if (assignment.getDateModified() != null) {
				props.put("modified_time", assignment.getDateModified().toString());
			}
			props.put("due_time", assignment.getDueDate().toString());
			props.put("open_time", assignment.getOpenDate().toString());
			if (assignment.getDropDeadDate() != null) {
				props.put("retract_time", assignment.getDropDeadDate().toString());
			}

			Site site = siteService.getSite(assignment.getContext());
			String placement = site.getToolForCommonId("sakai.assignment.grades").getId();

			props.put("security.user", sessionManager.getCurrentSessionUserId());
			props.put("security.site.function", SiteService.SITE_VISIT);
			props.put("security.site.ref", site.getReference());
			props.put("security.assignment.function", AssignmentServiceConstants.SECURE_ACCESS_ASSIGNMENT);
			props.put("security.assignment.grade.function", AssignmentServiceConstants.SECURE_GRADE_ASSIGNMENT_SUBMISSION);
			props.put("security.assignment.grade.ref", entity.getReference());
			props.put("url",
					"/portal/tool/" + placement
					+ "?assignmentId=" + assignment.getId()
					+ "&submissionId=" + submissionId
					+ "&assignmentReference=" + entity.getReference()
					+ "&panel=Main&sakai_action=" + defaultView);
		} catch (IdUnusedException e) {
			throw new EntityNotFoundException("No assignment found", reference, e);
		} catch (PermissionException e) {
			throw new SecurityException(e);
		}
		return props;
	}

	// PROPERTY STUFF

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.sakaiproject.entitybroker.entityprovider.extension.PropertiesProvider
	 * #getPropertyValue(java.lang.String, java.lang.String)
	 */
	public String getPropertyValue(String reference, String name) {
		String rv = null;
		// lazy code, if any of the parts of getProperties is found to be slow
		// this should be
		// changed.
		Map<String, String> props = getProperties(reference);
		if (props != null && props.containsKey(name)) {
			rv = props.get(name);
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.sakaiproject.entitybroker.entityprovider.extension.PropertiesProvider
	 * #setPropertyValue(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void setPropertyValue(String reference, String name, String value) {
		// TODO: add ability to set properties of an assignment
	}

	@AllArgsConstructor
	public class DecoratedAttachment implements Comparable<Object> {

		@Getter
		private String name;
		@Getter
		private String url;

		public int compareTo(Object other) {
			return this.getUrl().compareTo(
					((DecoratedAttachment) other).getUrl());
		}
	}

	@Data
	public class SimpleAssignment {
		/**
		 * the assignment id
		 */
		private String id;

		/**
		 * the AssignmentContent of this Assignment.
		 */
		private Assignment content;

		/**
		 * the first time at which the assignment can be viewed; may be null.
		 */
		private Instant openTime;

		/**
		 * the first time at which the assignment can be viewed; (String)
		 */
		private String openTimeString;

		/**
		 * the time at which the assignment is due; may be null.
		 */
		private Instant dueTime;

		/**
		 * the time at which the assignment is due; (String)
		 */
		private String dueTimeString;

		/**
		 * the drop dead time after which responses to this assignment are
		 * considered late; may be null.
		 */
		private Instant dropDeadTime;

		/**
		 * the drop dead time after which responses to this assignment are
		 * considered late; (String)
		 */
		private String dropDeadTimeString;

		/**
		 * the close time after which this assignment can no longer be viewed,
		 * and after which submissions will not be accepted. May be null.
		 */
		private Instant closeTime;

		/**
		 * the close time after which this assignment can no longer be viewed,
		 * and after which submissions will not be accepted. (String)
		 */
		private String closeTimeString;

		/**
		 * the section info.
		 */
		private String section;

		/**
		 * the context at the time of creation.
		 */
		private String context;

		/**
		 * Get whether this is a draft or final copy.
		 */
		private boolean draft;

		/**
		 * the creator of this object.
		 */
		private String creator;

		/**
		 * the time that this object was created.
		 */
		private Instant timeCreated;

		/**
		 * the list of authors.
		 */
		private String author;

		/**
		 * the assignment instructions.
		 */
		private String instructions;

		/**
		 * the time of last modificaiton.
		 */
		private Instant timeLastModified;

		/**
		 * the author of last modification
		 */
		private String authorLastModified;

		/**
		 * the title
		 */
		private String title;

		/**
		 * Return string representation of assignment status
		 */
		private String status;

		/**
		 * the position order field for the assignment.
		 */
		private int position;

		/**
		 * the groups defined for this assignment.
		 */
		private Collection groups;

		/**
		 * the access mode for the assignment - how we compute who has access to
		 * the assignment.
		 */
		private String access;

		/**
		 * the attachment list
		 */
		private List<DecoratedAttachment> attachments;

		/**
		 * Grade scale description.
		 */
		private String gradeScale;

		/**
		 * Max points used when grade scale = "Points"
		 */
		private String gradeScaleMaxPoints;

		/**
		 * Submission type description (e.g. inline only, inline and attachments)
		 */
		private String submissionType;

		/**
		 * Allow re-submission flag
		 */
		private boolean allowResubmission;

		/**
		 * Supplement items: model answer text
		 */
		private String modelAnswerText;

		/**
		 * Supplement items: private note text
		 */
		private String privateNoteText;


		/**
		 * Supplement items: all purpose item text
		 */
		private String allPurposeItemText;

		/**
		 * the linked gradebook item id and name
		 */
		private Long gradebookItemId;
		private String gradebookItemName;

		public SimpleAssignment() {
		}

		public SimpleAssignment(Assignment a) {
			super();
			if (a == null) {
				return;
			}
			this.id = a.getId();
			this.openTime = a.getOpenDate();
			this.openTimeString = a.getOpenDate().toString();
			this.dueTime = a.getDueDate();
			this.dueTimeString = a.getDueDate().toString();
			this.dropDeadTime = a.getDropDeadDate();
			this.dropDeadTimeString = a.getDropDeadDate().toString();
			this.closeTime = a.getCloseDate();
			this.closeTimeString = a.getCloseDate().toString();
			this.section = a.getSection();
			this.context = a.getContext();
			this.draft = a.getDraft();
			this.timeCreated = a.getDateCreated();
			this.author = a.getAuthor();
			this.timeLastModified = a.getDateModified();
			this.authorLastModified = a.getModifier();
			this.title = a.getTitle();
			try {
				this.status = assignmentService.getAssignmentCannonicalStatus(a.getId()).toString();
			} catch (IdUnusedException | PermissionException e) {
				log.warn("Couldn't get Assignment status, {}", e.getMessage());
			}
			this.position = (a.getPosition() != null) ? a.getPosition() : 0;
			this.groups = a.getGroups();
			this.access = a.getTypeOfAccess().toString();
			this.instructions = a.getInstructions();


			String gradebookAssignmentProp = a.getProperties().get(AssignmentServiceConstants.PROP_ASSIGNMENT_ASSOCIATE_GRADEBOOK_ASSIGNMENT);
			if (gradebookService.isGradebookDefined(a.getContext())) {
				if (StringUtils.isNotBlank(gradebookAssignmentProp)) {
					// try to get internal gradebook assignment first
					org.sakaiproject.service.gradebook.shared.Assignment gAssignment = gradebookService.getAssignment(a.getContext(), gradebookAssignmentProp);
					if (gAssignment != null) {
						// linked Gradebook item is internal
						this.gradebookItemId = gAssignment.getId();
						this.gradebookItemName = gAssignment.getName();
					} else {
						// If the linked assignment is not internal to Gradebook, try the external assignment service
						// However, there is no API available in GradebookExternalAssessmentService of getExternalAssignment()
						// We will first check whether the external assignment is defined, and then get it through GradebookService
						boolean isExternalAssignmentDefined = gradebookExternalService.isExternalAssignmentDefined(a.getContext(), gradebookAssignmentProp);
						if (isExternalAssignmentDefined) {
							// since the gradebook item is externally defined, the item is named after the external object's title
							gAssignment = gradebookService.getAssignment(a.getContext(), a.getTitle());
							if (gAssignment != null) {
								this.gradebookItemId = gAssignment.getId();
								this.gradebookItemName = gAssignment.getName();
							}
						}
					}
				} else {
					log.warn("The property \"prop_new_assignment_add_to_gradebook\" is null for the assignment feed");
				}
			}

			this.attachments = new ArrayList<>();
			Set<String> attachment_list = a.getAttachments();
			for (String attachment : attachment_list) {
				Entity entity = (Entity) entityBroker.fetchEntity(attachment);
				if (entity != null) {
					String url = entity.getUrl();
					String name = entity.getProperties().getPropertyFormatted(entity.getProperties().getNamePropDisplayName());
					DecoratedAttachment decoratedAttachment = new DecoratedAttachment(name, url);
					this.attachments.add(decoratedAttachment);
				} else {
					log.info("There was an attachment on assignment " + a.getId() + " that was invalid");
				}
			}
			// Translate grade scale from its numeric value to its description.
			this.gradeScale = a.getTypeOfGrade().toString();

			// If grade scale is "points" we also capture the maximum points allowed.
			if (a.getTypeOfGrade() == Assignment.GradeType.SCORE_GRADE_TYPE) {
				// TODO fix max grade display
				//	this.gradeScaleMaxPoints = a.getMaxGradePoint();
			}

			// Use the number of submissions allowed as an indicator that re-submission is permitted.
			if (a.getProperties().get(AssignmentConstants.ALLOW_RESUBMIT_NUMBER) != null && a.getTypeOfSubmission() != Assignment.SubmissionType.NON_ELECTRONIC_ASSIGNMENT_SUBMISSION) {
				this.allowResubmission = true;
			}
			this.submissionType = a.getTypeOfSubmission().toString();

			// Supplement Items
			AssignmentModelAnswerItem assignmentModelAnswerItem = assignmentSupplementItemService.getModelAnswer(a.getId());
			if (assignmentModelAnswerItem != null) {
				this.modelAnswerText = assignmentModelAnswerItem.getText();
			}
			AssignmentNoteItem assignmentNoteItem = assignmentSupplementItemService.getNoteItem(a.getId());
			if (assignmentNoteItem != null) {
				this.privateNoteText = assignmentNoteItem.getNote();
			}
			AssignmentAllPurposeItem assignmentAllPurposeItem = assignmentSupplementItemService.getAllPurposeItem(a.getId());
			if (assignmentAllPurposeItem != null) {
				this.allPurposeItemText = assignmentAllPurposeItem.getText();
			}
		}
	}

	/**
	 * submission/submittedUsers
	 */
	@EntityCustomAction(action = "submittedUsers", viewKey = "")
	public List<String> getUserSubmissions(EntityView view, Map<String, Object> params) {

		List<String> userSubmissionsList = new ArrayList<String>();
		String assignmentId = view.getPathSegment(2);
		//check user can access this assignment
		if (StringUtils.isBlank(assignmentId)) {
			throw new SecurityException("assignmentId must be present, via the URL /assignment/submittedUsers/assignmentId");
		}

		//get value from req
		String callingFunctionName = "/assignment/submission";

		// Assignment assignment = getAssignment(assignmentId,
		// callingFunctionName);
		String startDateParam = (String) params.get("startDate");
		String endDateParam = (String) params.get("endDate");
		Date startDate = null;
		Date endDate = null;

		if (!StringUtils.isBlank(startDateParam)){
			try {
				startDate = simpleDateFormat.parse(startDateParam);
			} catch (ParseException e) {
				throw new EntityNotFoundException("Date value parameter invalid format : startDate: " + startDateParam, assignmentId);
			}	
		} else {	

			Calendar calStart = new GregorianCalendar();
			calStart.setTime(new Date());
			calStart.set(Calendar.HOUR_OF_DAY, 0);
			calStart.set(Calendar.MINUTE, 0);
			calStart.set(Calendar.SECOND, 0);
			calStart.set(Calendar.MILLISECOND, 0);
			Date midnightYesterday = calStart.getTime();
			startDateParam = simpleDateFormat.format(midnightYesterday);			
			try {				
				startDate = simpleDateFormat.parse(startDateParam);
			} catch (ParseException e) {
				throw new EntityNotFoundException("Date value parameter invalid format : startDate: " + startDateParam, assignmentId);
			}	

		}

		if (!StringUtils.isBlank(endDateParam)){
			try {
				endDate = simpleDateFormat.parse(endDateParam);
			} catch (ParseException e) {
				throw new EntityNotFoundException("Date value parameter invalid format : endDate: " + startDateParam, assignmentId);
			}			
		} else {			
			Calendar calEnd = new GregorianCalendar();
			calEnd.setTime(new Date());
			calEnd.set(Calendar.DAY_OF_YEAR, calEnd.get(Calendar.DAY_OF_YEAR)+1);
			calEnd.set(Calendar.HOUR_OF_DAY, 0);
			calEnd.set(Calendar.MINUTE, 0);
			calEnd.set(Calendar.SECOND, 0);
			calEnd.set(Calendar.MILLISECOND, 0);
			Date midnightTonight = calEnd.getTime();
			endDateParam = simpleDateFormat.format(midnightTonight);		
			try {
				endDate = simpleDateFormat.parse(endDateParam);
			} catch (ParseException e) {
				throw new EntityNotFoundException("Date value parameter invalid format : endDate: " + endDateParam, assignmentId);
			}	
		}

		try {
			Assignment assignment = assignmentService.getAssignment(assignmentId);
			Entity entity = assignmentService.createAssignmentEntity(assignment);

			// If a single Student's submissions have been requested, otherwise return all submissions
			String studentUserId = (String) params.get("studentUserId");
			User user = null;
			if (!StringUtils.isBlank(studentUserId)){ // If userid param has a value, only return submissions for this user
				try {
					user = userDirectoryService.getUserByEid(studentUserId);
				} catch (UserNotDefinedException e) {
					throw new EntityNotFoundException("Can't find user: studentUserId: " + studentUserId, assignmentId);
				}
				AssignmentSubmission assignmentSubmission = assignmentService.getSubmission(entity.getReference(), user);		
				if(assignmentSubmission == null){
					return userSubmissionsList;
				}				
				if(allowAddSubmission(assignmentSubmission, startDate, endDate)){//If no submission exist, dont add
					userSubmissionsList.add(studentUserId);			
				}				
			} else { // If userid param not present, return all submissions
				Set<AssignmentSubmission> assignmentSubmissions = assignmentService.getSubmissions(assignment);
				for (AssignmentSubmission assignmentSubmission : assignmentSubmissions) {//If no submission exist, dont add
					if(allowAddSubmission(assignmentSubmission, startDate, endDate)){
						try {
							user = userDirectoryService.getUser(assignmentSubmission.getId());
						} catch (UserNotDefinedException e) {
							throw new EntityNotFoundException("Can't find user: studentUserId: " + assignmentSubmission.getId(), assignmentId);
						}
						if(user != null){
							userSubmissionsList.add(user.getEid());			
						}
					}
				}			
			}			
		} catch (IdUnusedException e) {
			throw new EntityNotFoundException("Invalid assignment id: " + assignmentId, assignmentId);
		} catch (PermissionException e) {
			throw new EntityNotFoundException("No access to assignment: " + assignmentId, assignmentId);
		} 
		//remove duplicates
		if(!userSubmissionsList.isEmpty()){
			//    		Set<String> set = new HashSet<String>(userSubmissionsList);  
			//            List<String> newlist = new ArrayList<String>(set); 
			userSubmissionsList = new ArrayList<String>(new LinkedHashSet<String>(userSubmissionsList));
		}
		return userSubmissionsList;
	}

	/**
	 * submission/assignmentId
	 */
	@EntityCustomAction(action = "submission", viewKey = "")
	public List<SimpleAssignmentSubmission> getAssignmentSubmission(EntityView view,
			Map<String, Object> params) {

		List<SimpleAssignmentSubmission> submissionList = new ArrayList<SimpleAssignmentSubmission>();
		String assignmentId = view.getPathSegment(2);
		//check user can access this assignment
		if (StringUtils.isBlank(assignmentId)) {
			throw new SecurityException("assignmentId must be present, via the URL /assignment/submission/assignmentId");
		}

		//get value from req
		String callingFunctionName = "/assignment/submission";

		// Assignment assignment = getAssignment(assignmentId,
		// callingFunctionName);
		String startDateParam = (String) params.get("startDate");
		String endDateParam = (String) params.get("endDate");
		Date startDate = null;
		Date endDate = null;

		if (!StringUtils.isBlank(startDateParam)){
			try {
				startDate = simpleDateFormat.parse(startDateParam);
			} catch (ParseException e) {
				throw new EntityNotFoundException("Date value parameter invalid format : startDate: " + startDateParam, assignmentId);
			}	
		} else {	

			Calendar calStart = new GregorianCalendar();
			calStart.setTime(new Date());
			calStart.set(Calendar.HOUR_OF_DAY, 0);
			calStart.set(Calendar.MINUTE, 0);
			calStart.set(Calendar.SECOND, 0);
			calStart.set(Calendar.MILLISECOND, 0);
			Date midnightYesterday = calStart.getTime();
			startDateParam = simpleDateFormat.format(midnightYesterday);			
			try {				
				startDate = simpleDateFormat.parse(startDateParam);
			} catch (ParseException e) {
				throw new EntityNotFoundException("Date value parameter invalid format : startDate: " + startDateParam, assignmentId);
			}	

		}

		if (!StringUtils.isBlank(endDateParam)){
			try {
				endDate = simpleDateFormat.parse(endDateParam);
			} catch (ParseException e) {
				throw new EntityNotFoundException("Date value parameter invalid format : endDate: " + startDateParam, assignmentId);
			}			
		} else {			
			Calendar calEnd = new GregorianCalendar();
			calEnd.setTime(new Date());
			calEnd.set(Calendar.DAY_OF_YEAR, calEnd.get(Calendar.DAY_OF_YEAR)+1);
			calEnd.set(Calendar.HOUR_OF_DAY, 0);
			calEnd.set(Calendar.MINUTE, 0);
			calEnd.set(Calendar.SECOND, 0);
			calEnd.set(Calendar.MILLISECOND, 0);
			Date midnightTonight = calEnd.getTime();
			endDateParam = simpleDateFormat.format(midnightTonight);		
			try {
				endDate = simpleDateFormat.parse(endDateParam);
			} catch (ParseException e) {
				throw new EntityNotFoundException("Date value parameter invalid format : endDate: " + endDateParam, assignmentId);
			}	
		}

		try {
			Assignment assignment = assignmentService.getAssignment(assignmentId);
			//Entity entity = assignmentService.createAssignmentEntity(assignment);

			// If a single Student's submissions have been requested, otherwise return all submissions
			String studentUserId = (String) params.get("studentUserId");
			User user = null;
			if (!StringUtils.isBlank(studentUserId)){ // If userid param has a value, only return submissions for this user
				try {
					user = userDirectoryService.getUserByEid(studentUserId);
				} catch (UserNotDefinedException e) {
					throw new EntityNotFoundException("Can't find user: studentUserId: " + studentUserId, assignmentId);
				}
				AssignmentSubmission assignmentSubmission = assignmentService.getSubmission(assignmentId, user);		
				if(assignmentSubmission == null){
					return submissionList;
				}				
				if(allowAddSubmission(assignmentSubmission, startDate, endDate)){//If no submission exist, dont add
					createSimpleAssignmentSubmission(submissionList, studentUserId, assignmentSubmission);					
				}				
			} else { // If userid param not present, return all submissions
				Set<AssignmentSubmission> assignmentSubmissions = assignmentService.getSubmissions(assignment);
				for (AssignmentSubmission assignmentSubmission : assignmentSubmissions) {//If no submission exist, dont add
					if(allowAddSubmission(assignmentSubmission, startDate, endDate)){
						try {
							user = userDirectoryService.getUser(assignmentSubmission.getId());
						} catch (UserNotDefinedException e) {
							throw new EntityNotFoundException("Can't find user: studentUserId: " + assignmentSubmission.getId(), assignmentId);
						}
						if(user != null){
							createSimpleAssignmentSubmission(submissionList, user.getEid(), assignmentSubmission);	
						}
					}
				}			
			}			
		} catch (IdUnusedException e) {
			throw new EntityNotFoundException("Invalid assignment id: " + assignmentId, assignmentId);
		} catch (PermissionException e) {
			throw new EntityNotFoundException("No access to assignment: " + assignmentId, assignmentId);
		} 
		return submissionList;
	}

	private void createSimpleAssignmentSubmission(List<SimpleAssignmentSubmission> submissionList, String studentUserId,
			AssignmentSubmission assignmentSubmission) {
		List submissionAttachments = new ArrayList(assignmentSubmission.getAttachments());
		List<Map<String, String>> attachmentList = new ArrayList<Map<String,String>>();
		for (int q = 0; q < submissionAttachments.size(); q++) {
			Map<String, String> attachmentMap = new HashMap<String, String>();
			Reference ref = (Reference) entityManager.newReference(submissionAttachments.get(q).toString());
			Entity ent = ref.getEntity();
			attachmentMap.put("attachmentId", ent.getId());
			attachmentMap.put("attachmentURL", ent.getUrl());			
			//			String encodedData = null;			
			//			ContentResource res;
			//			try {
			//				res = contentHostingService.getResource (ent.getId());
			//				byte[] data = res.getContent();
			//				encodedData = new String(Base64.encodeBase64(data));
			//				attachmentMap.put("attachmentEncodedData", encodedData);
			//			} catch (Exception e) {
			//				//If something goes wrong here, don't add to list
			//				return;
			//			}
			attachmentList.add(attachmentMap);
		}
		// use getGradeDisplay (Assignments grade is saved with value x 10)
		SimpleAssignmentSubmission submission = new SimpleAssignmentSubmission(assignmentSubmission.getAssignment().getId(), assignmentSubmission.getId(),
				studentUserId, assignmentSubmission.getGrade(), assignmentService.getSubmissionStatus(assignmentSubmission.getId()), "", attachmentList);
		submissionList.add(submission);
	}

	private boolean allowAddSubmission(AssignmentSubmission assignmentSubmission, Date startDate, Date endDate){

		Instant timeSubmitted = assignmentSubmission.getDateSubmitted();		

		//If no submission exist
		if(timeSubmitted == null){
			return false;
		}

		// If no start date, all submissions for that day
		//		if (startDate == null){
		//			return true;
		//		}

		// If only start date, all submissions after that date
		//		if (startDate != null && endDate == null){
		//
		//			//replace Sakai Time API once Assignments is updated with correct Date API (as stated in deprecated comments!) 
		//			Time now = TimeService.newTime();				
		//			if(timeSubmitted.after(now)){
		//				return true;
		//			}
		//			return false;
		//		}

		// If start & end date, submissions between those dates
		if (startDate != null && endDate != null){

			//replace Sakai Time API once Assignments is updated with correct Date API (as stated in deprecated comments!) 
			//Time startTime = TimeService.newTime(startDate.getTime());			
			//Time endTime = TimeService.newTime(endDate.getTime());			

			if(timeSubmitted.isAfter(startDate.toInstant()) && timeSubmitted.isBefore(endDate.toInstant())){
				return true;
			}
			return false;
		}
		return false;
	}	

	/**
	 * updateSubmission/assignmentId
	 */
	@EntityCustomAction(action = "updateSubmission", viewKey = "")
	public String updateSubmission(EntityView view, Map<String, Object> params) {
		String siteId = view.getPathSegment(2);
		// check user can access this site
		try {
			Site site = siteService.getSite(siteId);
		} catch (IdUnusedException e) {
			throw new EntityNotFoundException("Invalid siteId: " + siteId, siteId);
		}
		Assignment assignment = null;
		String assignmentId = (String) params.get("assignmentId");
		// check assignmentId supplied, mandatory value
		if (StringUtils.isBlank(assignmentId)) {
			throw new IllegalArgumentException(
					"assignmentId must be set in order to update the Assignment submission, via the URL /assignment/updateSubmission/assignmentId");
		} else {
			try {
				assignment = assignmentService.getAssignment(assignmentId);
			} catch (Exception e) {
				throw new EntityNotFoundException("Invalid assignment id: " + assignmentId, assignmentId);
			}
		}

		// check submissionId supplied, mandatory
		String submissionId = (String) params.get("submissionId");
		if (submissionId == null) {
			throw new IllegalArgumentException(
					"submissionId must be provided via the URL /assignment/updateSubmission/assignmentId");
		}

		// check studentId supplied, mandatory
		String studentId = (String) params.get("studentId");
		if (studentId == null) {
			throw new IllegalArgumentException(
					"studentId must be provided via the URL /assignment/updateSubmission/assignmentId");
		}

		// check studentId supplied, mandatory
		String grade = (String) params.get("grade");
		AssignmentSubmission assignmentSubmission = null;
		if (grade == null && grade.length() > 0 && !"0".equals(grade)) {
			throw new IllegalArgumentException(
					"grade must be provided via the URL /assignment/updateSubmission/assignmentId");
		} else {
			try {
				// make sure assignment grade scale is of type score/points
				GradeType typeOfGrade = assignment.getTypeOfGrade();//getContent().getTypeOfGrade();
				if (typeOfGrade != Assignment.GradeType.SCORE_GRADE_TYPE) {
					throw new IllegalArgumentException(
							"Can't update assignments that does not have point for grade scale, assignmentId: "
									+ assignmentId);
				}

				try {
					Integer.parseInt(grade);
				} catch (NumberFormatException e) {
					try {
						Float.parseFloat(grade);
					} catch (Exception e1) {
						throw new IllegalArgumentException(
								"grade value is invalid for points type via the URL /assignment/updateSubmission/assignmentId");
					}
				}
				// points grades must be multiple by 100 because of 2 decimal places
				grade = grade + "00";
				// update grade
				assignmentSubmission = assignmentService.getSubmission(submissionId);//editSubmission(submissionId);
				assignmentSubmission.setGrade(grade);
				assignmentSubmission.setGraded(true);
				assignmentSubmission.setGradedBy(AssignmentEntityProvider.class.getName());
				assignmentSubmission.setGradeReleased(true);

				// check resourceId supplied, mandatory
				String resourceId = (String) params.get("resourceId");
				if (resourceId == null) {
					throw new IllegalArgumentException(
							"resourceId must be provided via the URL /assignment/updateSubmission/assignmentId");
				}

				// check submissionAttachment supplied, mandatory
				DiskFileItem submissionAttachment = (DiskFileItem) params.get("submissionAttachment");
				if (submissionAttachment == null) {
					throw new IllegalArgumentException(
							"submissionAttachment must be set in order to update the Assignment submission, via the URL /assignment/updateSubmission/assignmentId");
				}

				ResourcePropertiesEdit rpe = contentHostingService.newResourceProperties();
				rpe.addProperty(rpe.PROP_DISPLAY_NAME, submissionAttachment.getName());

				ContentResource attachment = contentHostingService.addAttachmentResource(submissionAttachment.getName(),
						siteId, "Assignments", submissionAttachment.getContentType(),
						submissionAttachment.getInputStream(), rpe);

				Set<String> attachments = assignmentSubmission.getAttachments();
				Reference ref = entityManager.newReference(contentHostingService.getReference(attachment.getId()));
				attachments.add(ref.getReference());
				assignmentService.updateSubmission(assignmentSubmission);

			} catch (Exception e) {
				throw new EntityNotFoundException("Could not update Assignment with assignmentId: " + assignmentId
						+ ", submissionId: " + submissionId, assignmentId, e);
			}
		}
		return "SUCCESS";
	}
}
