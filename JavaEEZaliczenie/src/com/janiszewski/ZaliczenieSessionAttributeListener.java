package com.janiszewski;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class ZaliczenieSessionAttributeListener implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	//this will be fired when we added a new attribute to the session in ZaliczenieServlet.doGet
    	System.out.println("ZaliczenieSessionAttributeListener - Session attribute added: "+se);
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         //this will be fired when session is ending
    	System.out.println("ZaliczenieSessionAttributeListener - Session attribute removed: "+se);
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         //this will be fired during active session when updating session attributes in ZaliczenieServlet.doGet
    	System.out.println("ZaliczenieSessionAttributeListener - Session attribute replaced: "+se);
    }
	
}
