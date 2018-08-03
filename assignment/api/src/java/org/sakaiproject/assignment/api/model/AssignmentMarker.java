package org.sakaiproject.assignment.api.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * AssignmentMarker represents an assignment Marker.
 */

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "ASN_MARKER_T")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AssignmentMarker {

	@Id
	@Column(name = "MARKER_ID", length = 36, nullable = false)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column(name = "MARKER_USER_ID", nullable = false)
	private String markerUserId;

	@Column(name = "CONTEXT", length = 99, nullable = false)
	private String context;

	@ManyToOne
	@JoinColumn(name = "ASSIGNMENT_ID")
	private Assignment assignment;
	
    @Column(name = "QUOTA_PERCENTAGE")
    private Double quotaPercentage;

    @Column(name = "ORDER_NUM")
    private Integer orderNumber;

    @Column(name = "NUM_ALLOC")
    private Integer numberAllocated;

    @Column(name = "NUM_UPLOADED")
    private Integer numberUploaded;
    
    @Type(type = "org.sakaiproject.springframework.orm.hibernate.type.InstantType")
    @Column(name = "CREATED_DATE", nullable = false)
    private Instant dateCreated;

    @Type(type = "org.sakaiproject.springframework.orm.hibernate.type.InstantType")
    @Column(name = "MODIFIED_DATE")
    private Instant dateModified;

    @Column(name = "MODIFIER", length = 99)
    private String modifier;

    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "assignmentMarker", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AssignmentSubmissionMarker> submissionMarkers = new HashSet<>();
}
