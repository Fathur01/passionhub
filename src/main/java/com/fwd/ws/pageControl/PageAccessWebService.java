package com.fwd.ws.pageControl;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fwd.ws.InvalidTokenException;
import com.fwd.ws.WebServiceEndPointSetting;
import com.fwd.ws.request.PageAuthRequest;
import com.fwd.ws.response.PageAccessResponse;


@Controller    
public class PageAccessWebService  {  
	
	@Autowired
	private WebServiceEndPointSetting setting;
	
	@RequestMapping(value="/page/{viewPage}",method = RequestMethod.GET) 
	public String checkAccess(@PathVariable("viewPage") String viewPage, HttpSession session, ModelMap model) 
	{		
		
		// Check Token
		try {
			validatePageSessionToken(session);
		} catch (InvalidTokenException e) {
			model.addAttribute("errorMsg", "Invalid Token");
			return "ERROR";	
		}
		
		String strPage = viewPage;
		
		PageAccessResponse paResponse =	new PageAccessResponse();
		//dyo untuk menu baru bisa lolos authentikasi
		paResponse.setAccessRight(true);
			if (paResponse.isAccessRight()){
				return	strPage; //   strPage
			}
			else
			{
				//return "login.html";
				model.addAttribute("errorMsg", "Access denied");
				return "ACESSDENIED";	
			}
				
	}
	
	

	private int tokenDuration = 1800000;
	
	public void validatePageSessionToken (HttpSession session) throws InvalidTokenException {
		if (session.getAttribute("token") == null || session.getAttribute("token").toString().isEmpty() ) {
			throw new InvalidTokenException();
    	} else if (session.getAttribute("userName") == null || session.getAttribute("userName").toString().isEmpty() )  {
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
	
	public PageAccessResponse consumePageAccessWs(String groupCode,String menuURL, String systemCode)
	{
		PageAuthRequest request = new PageAuthRequest();
		request.setGroupCode(groupCode);
		request.setMenuURL(menuURL);
		request.setSystemCode(systemCode);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<PageAuthRequest> requestEntity = new HttpEntity<>(request, headers);

		try{
			ResponseEntity<PageAccessResponse> response = restTemplate.exchange(setting.getUrl() + "/access/page", HttpMethod.POST, requestEntity, PageAccessResponse.class);
			return response.getBody();
		}catch(HttpClientErrorException ex){
			return null;
		}
	}
}  