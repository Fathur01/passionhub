package com.fwd.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fwd.ws.request.PageAuthRequest;
import com.fwd.ws.response.PageAccessResponse;
import com.fwd.ws.response.WebServiceResponse;


@RestController
public class PageAccessWebServiceWrapperImpl {

	@Autowired
	private WebServiceEndPointSetting setting;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/access/page", method=RequestMethod.POST, consumes="application/json")
	public WebServiceResponse MemberSearch(@RequestBody PageAuthRequest request)
	{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<PageAuthRequest> requestEntity = new HttpEntity<>(request, headers);

		try{
			// ResponseEntity<PageAccessResponse> response = restTemplate.exchange(setting.getUrl() + "/access/page", HttpMethod.POST, requestEntity, PageAccessResponse.class);
			
			Object response = restTemplate.exchange(setting.getUrl() + "/access/page", HttpMethod.POST, requestEntity, PageAccessResponse.class);
			ResponseEntity<PageAccessResponse> responseEntity = null;
			try {
				responseEntity = (ResponseEntity<PageAccessResponse>) response;
				//return responseEntity.getBody();
			} catch (Exception e) {
				ResponseEntity<WebServiceResponse> responseEntityError = (ResponseEntity<WebServiceResponse>) response;
				return responseEntityError.getBody();
			}
			
			return responseEntity.getBody();
		}catch(HttpClientErrorException ex){
			WebServiceResponse response = new WebServiceResponse();
			response.setStatus("error");
			response.setErrMsg(ex.getResponseBodyAsString());
			return response;
		}
	}
	
}