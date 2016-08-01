package com.wego.tmaven.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {
	
	protected static ThreadLocal<HttpServletRequest> thread_local_request = new ThreadLocal<HttpServletRequest>();
	protected static ThreadLocal<HttpServletResponse> thread_local_response = new ThreadLocal<HttpServletResponse>();
	
	protected HttpSession getSession(){
		//获取缓存中的session
		return thread_local_request.get().getSession();
	}
	
	protected HttpServletRequest getRequest(){
		return thread_local_request.get();
	}
	
	protected HttpServletResponse getResponse() {
		return thread_local_response.get();
	}
	
	protected void set(String key,Object value){
		this.getRequest().setAttribute(key, value);
	}
	
	protected void sessionSet(String key,Object value) {
		this.getSession().removeAttribute(key);
		this.getSession().setAttribute(key, value);
	}
	
	public static void setRequest(HttpServletRequest request){
		thread_local_request.set(request);
	}
	
	public static void setResponse(HttpServletResponse response) {
		thread_local_response.set(response);
	}
	
	public static void removeRequest() {
		thread_local_request.remove();
	}
	
	public static void removeResponse(){
		thread_local_response.remove();
	}
	
	public void setResponseNoCache() {
		getResponse().setHeader("progma", "no-cache");
		getResponse().setHeader("Cache-Control", "no-cache");
		getResponse().setHeader("Cache-Control", "no-store");
		getResponse().setDateHeader("Expires", 0);
	}
	
}
