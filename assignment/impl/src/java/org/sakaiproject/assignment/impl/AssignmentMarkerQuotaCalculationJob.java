package org.sakaiproject.assignment.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.sakaiproject.api.app.scheduler.SchedulerManager;
import org.sakaiproject.assignment.api.AssignmentService;
import org.sakaiproject.assignment.api.model.Assignment;
import org.sakaiproject.assignment.api.model.Assignment.SubmissionType;
import org.sakaiproject.assignment.api.model.AssignmentMarker;
import org.sakaiproject.assignment.api.model.AssignmentSubmission;
import org.sakaiproject.assignment.api.model.AssignmentSubmissionMarker;
import org.sakaiproject.component.api.ServerConfigurationService;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.site.api.SiteService;
import org.sakaiproject.site.api.SiteService.SelectionType;
import org.sakaiproject.site.api.SiteService.SortType;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AssignmentMarkerQuotaCalculationJob implements Job {

	private AssignmentService assignmentService;
	private ServerConfigurationService serverConfigurationService;
	private SchedulerManager schedulerManager;
	private SiteService siteService;
	private String[] types;

//	// Matches the bean id
//	final static String BEAN_ID = AssignmentMarkerQuotaCalculationJob.class.getName();
//
//	// Matches the jobName
//	final static String JOB_NAME = "Assignment Marker Quota Calculation Job";

	public void execute(JobExecutionContext jobInfo) throws JobExecutionException {
		serverConfigurationService = ComponentManager.get(ServerConfigurationService.class);
		if (serverConfigurationService.getBoolean("assignment.useMarker", false)) {
			assignmentService = ComponentManager.get(AssignmentService.class);
			siteService = ComponentManager.get(SiteService.class);
			types = new String[]{"Project", "Course"};
			List<String> siteIds = siteService.getSiteIds(SelectionType.ANY, types, null, null, SortType.NONE, null);
			Iterator<String> iter = siteIds.iterator();
			while (iter.hasNext()) {
				String siteId = iter.next();
				Collection <Assignment> siteAssignments = assignmentService.getAssignmentsForContext(siteId);
				for (Assignment assignment : siteAssignments) {
					Set<AssignmentSubmission> missingAssignmentSubmissions = new HashSet<>();
					if (assignment.getTypeOfSubmission() == SubmissionType.PDF_ONLY_SUBMISSION) {
						Set<AssignmentSubmission> submissionSet = assignment.getSubmissions();
						Set <AssignmentMarker> amSet = assignment.getMarkers();
						Iterator<AssignmentMarker> markers = amSet.iterator();
						while (markers.hasNext()) {
							AssignmentMarker am = markers.next();
							Set<AssignmentSubmissionMarker> asmSet = am.getSubmissionMarkers();
							Iterator<AssignmentSubmissionMarker> asmIter = asmSet.iterator();
							while (asmIter.hasNext()) {
								AssignmentSubmissionMarker asm = asmIter.next();
								AssignmentSubmission tempSubmission = asm.getAssignmentSubmission();
								if (missingAssignmentSubmissions.contains(tempSubmission)) {
									missingAssignmentSubmissions.remove(tempSubmission);
								}
								if (!submissionSet.contains(tempSubmission)) {
									missingAssignmentSubmissions.add(tempSubmission);
								}
							}
						}
					}
					if (CollectionUtils.isNotEmpty(missingAssignmentSubmissions)) {
						Iterator<AssignmentSubmission> asIter = missingAssignmentSubmissions.iterator();
						while (asIter.hasNext()) {
							AssignmentSubmission as = asIter.next();
							//assignmentService.markerQuotaCalculation(assignment, as);
						}
					}
				}
			}
		}
	}

	public void init() {
		log.debug("AssignmentMarkerQuotaCalculationJob - init()");
		Scheduler scheduler = schedulerManager.getScheduler(); 
		if (scheduler == null) {
			log.error("Scheduler is down!");
			return;
		}		
//		try {
//			JobBuilder jobBuilder = JobBuilder.newJob(AssignmentMarkerQuotaCalculationJob.class);
//			JobDetail jobDetail = jobBuilder.withIdentity(JOB_NAME, Scheduler.DEFAULT_GROUP).requestRecovery()
//					.storeDurably().build();		
//			
//			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("Asn Quota Calc Hourly Trigger", Scheduler.DEFAULT_GROUP)
//					.withSchedule(CronScheduleBuilder.cronSchedule(serverConfigurationService.getString("assignment.marker.quota.calc.cron.expression", "0 0 * ? * * *"))).forJob(jobDetail.getKey())
//					.build();		
//			scheduler.scheduleJob(jobDetail, trigger);
//		} catch (SchedulerException e) {
//			log.error("AssignmentMarkerQuotaCalculationJob could not be scheduled.", e);
//		}		
	}
	
	public AssignmentService getAssignmentService() {
		return assignmentService;
	}

	@Autowired
	public void setAssignmentService(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}

	/**
	 * @return the serverConfigurationService
	 */
	public ServerConfigurationService getServerConfigurationService() {
		return serverConfigurationService;
	}

	/**
	 * @param serverConfigurationService
	 *            the serverConfigurationService to set
	 */
	@Autowired
	public void setServerConfigurationService(ServerConfigurationService serverConfigurationService) {
		this.serverConfigurationService = serverConfigurationService;
	}

	public SchedulerManager getSchedulerManager() {
		return schedulerManager;
	}

	@Autowired
	public void setSchedulerManager(SchedulerManager schedulerManager) {
		this.schedulerManager = schedulerManager;
	}
}