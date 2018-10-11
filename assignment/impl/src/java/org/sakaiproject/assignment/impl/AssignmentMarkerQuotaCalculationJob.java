package org.sakaiproject.assignment.impl;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.sakaiproject.api.app.scheduler.SchedulerManager;
import org.sakaiproject.api.app.scheduler.TriggerWrapper;
import org.sakaiproject.assignment.api.AssignmentService;
import org.sakaiproject.component.api.ServerConfigurationService;
import org.sakaiproject.component.app.scheduler.TriggerWrapperImpl;
import org.sakaiproject.component.cover.ComponentManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AssignmentMarkerQuotaCalculationJob implements Job {

	private AssignmentService assignmentService = ComponentManager.get(AssignmentService.class);
	private ServerConfigurationService serverConfigurationService = ComponentManager
			.get(ServerConfigurationService.class);;
	private SchedulerManager schedulerManager;

	private String triggerExpression;
	private String triggerName;

	// Matches the bean id
	final static String BEAN_ID = AssignmentMarkerQuotaCalculationJob.class.getName();

	// Matches the jobName
	final static String JOB_NAME = "Assignment Marker: Do Quota Calculation Job";

	public void execute(JobExecutionContext jobInfo) throws JobExecutionException {
		// if for system property for the assignment marker setting, can be found in the
		// assignment action
		boolean isEnabledAssignmentMarker = serverConfigurationService.getBoolean("assignment.useMarker", false);
		if (isEnabledAssignmentMarker) {
			assignmentService.markerQuotaCalculation();
		}
	}

	public void init() {

		log.debug("AssignmentMarkerQuotaCalculationJob - init()");
		try {
			Scheduler sched = schedulerManager.getScheduler();
			if (sched == null) {
				log.error("Scheduler is down!");
				return;
			}
			JobBuilder jobBuilder = JobBuilder.newJob(AssignmentMarkerQuotaCalculationJob.class);
			JobDetail jobDetail = jobBuilder.withIdentity(JOB_NAME, Scheduler.DEFAULT_GROUP).requestRecovery()
					.storeDurably().build();
			jobDetail.getJobDataMap().put("org.sakaiproject.api.app.scheduler.JobBeanWrapper.bean", BEAN_ID);
			jobDetail.getJobDataMap().put("org.sakaiproject.api.app.scheduler.JobBeanWrapper.jobType", JOB_NAME);
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, Scheduler.DEFAULT_GROUP)
					.withSchedule(CronScheduleBuilder.cronSchedule(triggerExpression)).forJob(jobDetail.getKey())
					.build();
			TriggerWrapper tempTriggerWrapper = new TriggerWrapperImpl();
			tempTriggerWrapper.setTrigger(trigger);
		} catch (Exception e) {
			// This can probably just be a debug
			log.debug("Course Manager Add Participant job could not be scheduled.", e);
		}
	}

	public SchedulerManager getSchedulerManager() {
		return schedulerManager;
	}

	public void setSchedulerManager(SchedulerManager schedulerManager) {
		this.schedulerManager = schedulerManager;
	}

	/**
	 * @return Returns the triggerExpression.
	 */
	public String getTriggerExpression() {
		return triggerExpression;
	}

	/**
	 * @param triggerExpression
	 *            The triggerExpression to set.
	 */
	public void setTriggerExpression(String triggerExpression) {
		this.triggerExpression = triggerExpression;
	}

	/**
	 * @return Returns the triggerName.
	 */
	public String getTriggerName() {
		return triggerName;
	}

	/**
	 * @param triggerName
	 *            The triggerName to set.
	 */
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
}