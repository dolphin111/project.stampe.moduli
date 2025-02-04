package com.fideuram.servlet;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletContextEvent;
import javax.xml.ws.WebServiceContext;

import org.quartz.SchedulerException;

import com.fideuram.trigger.TriggerCollettiveTDP;
import com.fideuram.utils.LoggingUtils;

/**
 * Created with
 * User: logan
 * Date: 16/05/13
 * Time: 8.53
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Collettive{
	
    //http://localhost:8080/stampe-trigger/CollettiveService?WSDL
    private static TriggerCollettiveTDP triggerCollettiveTDP;

    public Collettive(){}
    
    @Resource
    private WebServiceContext context;

    @WebMethod
    public String testIntegration(){
        return "Modulo stampe-trigger - Presente";
    }

    @WebMethod
    public void startJobTDP(){
        LoggingUtils.info("Richiesto START COLLETTIVE TDP");
        try{
            getInstance().runTdp();
        } catch (SchedulerException e) {
            LoggingUtils.error("ECCEZIONE DURANTE LO START DEL JOB: TDP >> " +e.getMessage());
        }
    }

    @WebMethod
    public void pauseJobTDP(){
        LoggingUtils.info("Richiesto STOP COLLETTIVE TDP");
        try{
            getInstance().pauseTdp();
        } catch (SchedulerException e) {
            LoggingUtils.error("ECCEZIONE DURANTE LO  STOP  DEL JOB: TDP >> " + e.getMessage());
        }
    }

    @WebMethod
    public void resumeJobTDP(){
        LoggingUtils.info("Richiesto RESUME COLLETTIVE TDP");
        try{
            getInstance().resumeTdp();
        } catch (SchedulerException e) {
            LoggingUtils.error("ECCEZIONE DURANTE LA RESUME DEL JOB: TDP >> " +e.getMessage());
        }
    }

    @WebMethod
    public void deleteJobTDP(){
        LoggingUtils.info("DELETE DEL JOB TDP");
        try{
            getInstance().deleteTdp();
        } catch (SchedulerException e) {
            LoggingUtils.error("ECCEZIONE DURANTE LA  DELETE DEL JOB: TDP >> " +e.getMessage());
        }
    }

    @WebMethod
    public void shutDown(){
        LoggingUtils.info("SHUTDOWN EXECUTING JOB");
        try{
            getInstance().shutDown();
        }catch(SchedulerException e){
            LoggingUtils.error("ECCEZIONE DURANTE LO shutDown DEI PROCESSI >> " +e.getMessage());
        }
    }

    @WebMethod
    public void monitor(){
        LoggingUtils.info("MONNIOTR EXECUTING JOB");
        try{
            getInstance().monitor();
        }catch(SchedulerException e){
            LoggingUtils.error("ECCEZIONE DURANTE IL MONITORING DEI PROCESSI >> " +e.getMessage());
        }
    }
    
    private TriggerCollettiveTDP getInstance() throws SchedulerException {
        if (null==triggerCollettiveTDP)
            triggerCollettiveTDP=new TriggerCollettiveTDP();
        return triggerCollettiveTDP;
    }

}
