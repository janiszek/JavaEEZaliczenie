package com.janiszewski;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ZaliczenieSessionListener implements HttpSessionListener, ServletRequestListener {

    public void sessionCreated(HttpSessionEvent se)  { 
        //start of the session
    	System.out.println("ZaliczenieSessionListener - Session created: "+se.getSession().getId());
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
        //start of the HTTP request, like http://localhost:8080/JavaEEZaliczenie/ZaliczenieServlet?param1=pierwszy&param2=drugi
    	System.out.println("ZaliczenieSessionListener - Request Initialized: "+sre);
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	//end of the HTTP request
    	System.out.println("ZaliczenieSessionListener - Request destroyed: "+sre);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	//end of the session
    	System.out.println("ZaliczenieSessionListener - Session destroyed: "+se.getSession().getId());
    }
    
}
