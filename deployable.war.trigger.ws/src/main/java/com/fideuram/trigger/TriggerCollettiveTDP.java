package com.fideuram.trigger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fideuram.jobs.CollettiveTDP;
import com.fideuram.utils.LoggingUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created with
 * User: logan
 * Date: 14/05/13
 * Time: 17.25
 */
public class TriggerCollettiveTDP implements ServletContextListener {
    private static Scheduler scheduler;
    private static JobDetail job;
    private static Trigger trigger;

    public TriggerCollettiveTDP() throws SchedulerException {
        job = JobBuilder.newJob(CollettiveTDP.class).withIdentity("CollettiveTDP").build();
        job.getJobBuilder().storeDurably(false);
        trigger = TriggerBuilder.newTrigger()
                .withIdentity("CollettiveTDP")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(60).repeatForever()).build();
        scheduler = (new StdSchedulerFactory()).getScheduler();
    }


    public void runTdp() throws SchedulerException {
    	if(!scheduler.isStarted())
    		scheduler.start();
        scheduler.scheduleJob(job, trigger);
        LoggingUtils.info("SCHEDULER STARTED");
    }

    public void  pauseTdp() throws SchedulerException {
        LoggingUtils.info("RICHIESTA DI PAUSA DELLO SCHEDULER");
        LoggingUtils.info((new StringBuilder()).append("IS SCHEDULER ATTIVO?").append(scheduler.isStarted()).toString());
        if(scheduler.isStarted()){
            LoggingUtils.info("SCHEDULER PAUSED");
            scheduler.pauseJob(job.getKey());
        }
    }

    public void resumeTdp() throws SchedulerException {
        scheduler.resumeJob(job.getKey());
        LoggingUtils.info("JOB TDP RESUMED");
    }

    public void deleteTdp() throws SchedulerException{
        monitor();
        if(scheduler.checkExists(trigger.getKey()))
        {
            scheduler.unscheduleJob(trigger.getKey());
            scheduler.deleteJob(job.getKey());
            scheduler.clear();
            LoggingUtils.info("DELETED");
            monitor();
        } else
        {
            LoggingUtils.info("JOB 2 DELETE NOT FOUND");
        }
    }
    

    public void shutDown() throws SchedulerException{
        monitor();
        if(scheduler.checkExists(job.getKey()))
        {
            scheduler.shutdown();
            monitor();
        } else
        {
            LoggingUtils.info("SCHEDULER NOT FOUND");
        }
    }

    public void monitor()
    {
        try {
            LoggingUtils.info((new StringBuilder()).append("Ricerco il seguente job: ").append(job.getKey().getName()).toString());
            if(scheduler.checkExists(job.getKey()))
                LoggingUtils.info("JOB TROVATO");
            else
            	 LoggingUtils.info("JOB NON TROVATO");
        }
        catch(SchedulerException e) {
        	LoggingUtils.error("SchedulerException monitor method");
            e.printStackTrace();
        }
    }


    public static void main(String args[]) throws SchedulerException {
    	 LoggingUtils.info("thread CollettiveTDP inizio esecuzione");
            new TriggerCollettiveTDP().runTdp();
         LoggingUtils.info("thread CollettiveTDP fine esecuzione");
    }
    
    @Override
   	public void contextInitialized(ServletContextEvent sce) {
   		 LoggingUtils.info("MONITOR contextInitialized JOB");
   	}

   	@Override
   	public void contextDestroyed(ServletContextEvent sce) {
   		 LoggingUtils.info("contextDestroyed EXECUTING start");
   		 try{
   			 this.deleteTdp();
   			 LoggingUtils.info("contextDestroyed EXECUTING end");
   		 }
   		 catch(SchedulerException e){
   			 LoggingUtils.error("ERROR HANDLE JOB ["+e.getMessage()+"]");
   			 
   		 }
   		
   		
   	}

}
