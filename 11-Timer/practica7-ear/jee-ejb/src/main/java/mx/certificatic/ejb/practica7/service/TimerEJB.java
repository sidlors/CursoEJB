package mx.certificatic.ejb.practica7.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;



import javax.ejb.Timer;
import javax.ejb.TimerService;

import mx.certificatic.ejb.practica7.service.TimerEJBLocal;
import mx.certificatic.ejb.practica7.service.TimerEJBRemote;

/**
 * Session Bean implementation class PersonEJB
 */
@Stateless
@LocalBean
@Remote(TimerEJBRemote.class)
@Local(TimerEJBLocal.class)
public class TimerEJB{
	
//	To create a timer, 
//	we need to create TimerService object and use one of its createTimer() method. 
//	TimerService can be accessed in one of the following ways.
	
	  @Resource
	  TimerService service;
	  
	  @Resource
	  EJBContext ejbContext;
	  
	  public void startTimerEJBContext() {
	        service = ejbContext.getTimerService();
	    }
	  
	  
	  @Resource
	  SessionContext sessionContext;
	 
	    public void startTimerSessionContext() {
	         service = sessionContext.getTimerService();
	    }
	  
	    
	    public void startTimerSingleAction() {
	        Timer timer = service.createTimer(60*60*1000, null);
	        timer.
	        System.out.println("Timers set");
	    }
	    
	    public void startTimerInterval() {
	        Timer timer = service.createTimer(10000, 60*60*1000, null);
	        System.out.println("Timers set");
	    }
	    
	    public void startTimer() {
	        SimpleDateFormat dateFormat  = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	        String s = "29/07/2012 20:30:00";
	        try {
	            Date date = dateFormat.parse(s);
	            Timer timer = service.createTimer(date, null);
	            System.out.println("Timers set");
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    }

}
