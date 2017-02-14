package com.fwd.ws;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.fwd.ws.response.WebServiceResponse;

public abstract class BaseWebServiceWrapperImpl {
	
	private int tokenDuration = 1800000;
	
	

	
	public void validateSessionToken (HttpSession session, String userName, String token) throws InvalidTokenException {
		if (session.getAttribute("token") == null || session.getAttribute("token").toString().isEmpty() || !session.getAttribute("token").equals(token)) {
			throw new InvalidTokenException();
    	} else if (session.getAttribute("userName") == null || session.getAttribute("userName").toString().isEmpty() || !session.getAttribute("userName").equals(userName))  {
    		throw new InvalidTokenException();
    	} else if (session.getAttribute("expiryTime") == null || session.getAttribute("expiryTime").toString().isEmpty() ) {
    		throw new InvalidTokenException();
    	} else {
			final Calendar calendar = Calendar.getInstance();
			Date expiryTime = (Date) session.getAttribute("expiryTime");
			final long diff = calendar.getTimeInMillis() - expiryTime.getTime();
			if(diff > tokenDuration){
				throw new InvalidTokenException();
			}
			
			calendar.add(Calendar.MILLISECOND, tokenDuration);
			session.setAttribute("expiryTime",calendar.getTime());
    	}
	}
	
	
	public void validateSessionToken (HttpServletRequest httpRequest) throws InvalidTokenException {
		String userName, token;
		userName = this.getHttpHeadersKeyValue(httpRequest, "userName");
		token = this.getHttpHeadersKeyValue(httpRequest, "token");
		
		this.validateSessionToken(httpRequest.getSession(), userName, token);
	}
	
	
	public <T> HttpEntity<T> prepareRequest(T request, HttpSession session) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("userName", session.getAttribute("userName").toString());
		headers.add("token", session.getAttribute("token").toString());
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<>(request, headers);
	}
	
	public <T> HttpEntity<T> prepareRequest(T request, HttpSession session, String language)  {
		HttpHeaders headers = new HttpHeaders();
		headers.add("userName", session.getAttribute("userName").toString());
		headers.add("token", session.getAttribute("token").toString());
		headers.add("language", language);
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<>(request, headers);
	}
	
	public <T> HttpEntity<T> prepareRegisterRequest(T request, HttpSession session, String language) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("language", language);
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<>(request, headers);
	}
	
	
    // Exception handling methods
    
    // Convert a predefined exception to an HTTP Status code
    //@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Client Error") 
    @ExceptionHandler(HttpClientErrorException.class)
    public WebServiceResponse handleHttpClientErrorExceptionError(HttpServletRequest req, HttpClientErrorException ex) {
		WebServiceResponse response = new WebServiceResponse();
		response.setStatus("error");
		response.setErrMsg(ex.getResponseBodyAsString());
		return response;
    }

    @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid Token") 
    @ExceptionHandler(InvalidTokenException.class)
    public WebServiceResponse InvalidTokenException(HttpServletRequest req, InvalidTokenException ex) {
		WebServiceResponse response = new WebServiceResponse();
		response.setStatus("error");
		response.setErrMsg(ex.getMessage());
		return response;
    }

    // Total control - setup a model and return the view name yourself. Or consider
    // subclassing ExceptionHandlerExceptionResolver (see below).
    //@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Error") 
    @ExceptionHandler(Exception.class)
    public WebServiceResponse handleError(HttpServletRequest req, Exception ex) {
		WebServiceResponse response = new WebServiceResponse();
		response.setStatus("error");
		response.setErrMsg(ex.getMessage());
		return response;
    }

    
    
    protected void updateSession(HttpSession session, String sessionToken, String userName){
		session.setAttribute("token", sessionToken);
		session.setAttribute("userName", userName);
		
		final Calendar calendar = Calendar.getInstance();
		session.setAttribute("expiryTime",calendar.getTime());
    }
    
    protected void updateRegisterSession (HttpSession session, String sessionToken, String clientCode, String userRole){
		session.setAttribute("validateToken", sessionToken);
		
		final Calendar calendar = Calendar.getInstance();
		session.setAttribute("expiryTime",calendar.getTime());
    }
    
    
    protected void clearSession(HttpSession session){
		session.setAttribute("token", null);
		session.setAttribute("userName", null);
		
		session.setAttribute("expiryTime", null);
    }
    
    
    protected HttpHeaders newHttpHeaders(HttpServletRequest httpRequest){
    	HttpHeaders headers = this.newHttpHeaders();
    	// exclude null when listing headers
		this.addHttpHeaders(headers, "userName", this.getHttpHeadersKeyValue(httpRequest, "userName"));
		this.addHttpHeaders(headers, "token", this.getHttpHeadersKeyValue(httpRequest, "token"));
		this.addHttpHeaders(headers, "language", this.getHttpHeadersKeyValue(httpRequest, "language"));
		
		return headers;
    }        
    protected HttpHeaders newHttpHeaders(HttpServletRequest httpRequest, String language){
    	HttpHeaders headers = this.newHttpHeaders();
    	// exclude null when listing headers
		this.addHttpHeaders(headers, "userName", this.getSessionAttribute(httpRequest.getSession(), "userName"));
		this.addHttpHeaders(headers, "token", this.getSessionAttribute(httpRequest.getSession(), "token"));
		this.addHttpHeaders(headers, "language", language);		
		
		return headers;
    }
    private void addHttpHeaders(HttpHeaders headers, String key, String value){
    	if(headers != null){
    		if(value != null && !StringUtils.isEmpty(value)){
    			headers.add(key, value);
    		}
    	}
    }   
    protected HttpHeaders newHttpHeaders(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept-Charset", "UTF-8");
		
		return headers;
    }
       
    protected String getSessionAttribute(HttpSession session, String attributeName ){
    	String rtn ; 
    	Object obj = session.getAttribute(attributeName);
    	rtn = obj == null ? null : obj.toString();
    	
    	return rtn;
    }
    protected String getHttpHeadersKeyValue(HttpServletRequest httpHeaders, String attributeName){
    	String rtn ; 
    	rtn = httpHeaders.getHeader(attributeName);
    	
    	return rtn;    	
    }
    protected String getHttpHeadersKeyValueUserName(HttpServletRequest httpHeaders){
    	return getHttpHeadersKeyValue(httpHeaders, "userName");
    }
}
