package co.unal.sm.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitApp implements ServletContextListener {
	
	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	 System.out.println("...........                          ........!!!");
    	 System.out.println("...........                          ........!!!");
    	 System.out.println("...........                          ........!!!");
         System.out.println("...........INICIANDO SMARTHOMESERVER ........!!!");
         System.out.println("...........                          ........!!!");
         System.out.println("...........                          ........!!!");
         System.out.println("...........                          ........!!!");
    }
	
}
