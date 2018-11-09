package com.example.utils;

import javax.servlet.http.HttpSession;

public class SessionUtils {

	private static SessionUtils sessionUtils = null;
	
	public static SessionUtils getSession() {
		if(sessionUtils == null) {
			sessionUtils = new SessionUtils();
		}
		return sessionUtils;
	}
	
	public void putValue(HttpSession session,String key,Object value) {
		session.setAttribute(key, value);
	}
	
	public Object getVlue(HttpSession session,String key) {
		return session.getAttribute(key);
	}
	 public void remove(HttpSession session, String key) {
		 session.removeAttribute(key);
	    }
}
