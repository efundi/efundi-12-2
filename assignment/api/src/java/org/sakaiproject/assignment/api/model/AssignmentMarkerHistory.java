package org.sakaiproject.assignment.api.model;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * AssignmentSubmissionMarkerHisotry represents a History of Markers for an Assignment submission.
 */

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "ASN_SUBMISSION_MARKER_HISTORY")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AssignmentMarkerHistory {
	
	@Id
	@Column(name = "HIST_ID", length = 36, nullable = false)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
    @ManyToOne
    @JoinColumn(name = "OLD_MARKER_ID")
    private AssignmentMarker oldAssignmentMarker;
    
    @ManyToOne
    @JoinColumn(name = "NEW_MARKER_ID")
    private AssignmentMarker newAssignmentMarker;
    
	@Column(name = "CONTEXT", length = 99, nullable = false)
	private String context;

	@ManyToOne
	@JoinColumn(name = "ASSIGNMENT_ID")
	private Assignment assignment;
   
    @Column(name="OLD_QUOTA")
    private Double oldQuotaPercentage;
    
    @Column(name="NEW_QUOTA")
    private Double newQuotaPercentage;
    
    @Type(type = "org.sakaiproject.springframework.orm.hibernate.type.InstantType")
    @Column(name = "MODIFIED_DATE")
    private Instant dateModified;

    @Column(name = "MODIFIER", length = 99)
    private String modifier;
}
