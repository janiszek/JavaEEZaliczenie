package com.janiszewski;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ZaliczenieServlet")
public class ZaliczenieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter responseWriter = response.getWriter();
		HttpSession currentSession = request.getSession();
		
		responseWriter.write("<html><body><br>");		
		responseWriter.write("<h3>I have just served following request</h3>");
		responseWriter.write("<p>RequestURL: " + request.getRequestURL() + "</p>");
		//getParameterNames & getParameterValues - write into HTML file
		Enumeration<String> paramList = request.getParameterNames();
		while (paramList.hasMoreElements()) {
			responseWriter.write("<p>");
			String paramName = (String)paramList.nextElement();
			responseWriter.write(paramName+": ");
			for (String paramValues: request.getParameterValues(paramName)) {
				responseWriter.write(paramValues);
				//set cookies
				Cookie cookieParam = new Cookie(paramName, paramValues);
				cookieParam.setMaxAge(60);
				response.addCookie(cookieParam);
				//set session attribute
				currentSession.setAttribute(paramName, paramValues);
			}
			responseWriter.write("</p>");
		}
		responseWriter.write("<br>");
		
		//list the cookies associated with the request
		responseWriter.write("<h3>List of cookies set</h3>");
    	Cookie[] cookies = request.getCookies();    
    	if (cookies!=null)
    		for(Cookie cookie: cookies) {   		 
    			String cookieName = cookie.getName(); 
    			String cookieValue = cookie.getValue(); 
    			responseWriter.println("<p>"+cookieName+": "+cookieValue+"</p>");
    		}       
		responseWriter.write("<br>");

        //show all attributes stored in the session
		responseWriter.write("<h3>List of session attributes</h3>");
		Enumeration<String> attributeNames = currentSession.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            responseWriter.write("<p>" + attributeName + ": " + currentSession.getAttribute(attributeName) + "</p>");
        }
		responseWriter.write("<br>");

		responseWriter.write("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
