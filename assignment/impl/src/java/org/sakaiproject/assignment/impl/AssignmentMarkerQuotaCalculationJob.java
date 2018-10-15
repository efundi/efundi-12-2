package org.sakaiproject.assignment.impl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.sakaiproject.api.app.scheduler.SchedulerManager;
import org.sakaiproject.assignment.api.AssignmentService;
import org.sakaiproject.component.api.ServerConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AssignmentMarkerQuotaCalculationJob implements Job {

	private AssignmentService assignmentService;
	private ServerConfigurationService serverConfigurationService;
	private SchedulerManager schedulerManager;

//	// Matches the bean id
//	final static String BEAN_ID = AssignmentMarkerQuotaCalculationJob.class.getName();
//
//	// Matches the jobName
//	final static String JOB_NAME = "Assignment Marker Quota Calculation Job";

	public void execute(JobExecutionContext jobInfo) throws JobExecutionException {
		if (serverConfigurationService.getBoolean("assignment.useMarker", false)) {
			assignmentService.markerQuotaCalculation();
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