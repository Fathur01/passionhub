package com.fwd.connector;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fwd.util.XmlUtils;
import com.fwd.ws.request.MemberLoginRequest;
import com.fwd.ws.request.MemberValidateRequest;
import com.fwd.ws.response.*;

@Component
public class PassionHubConnector {
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(PassionHubConnector.class);

	@SuppressWarnings("unused")
	private static final String RESPONSE_ENCODING = "UTF-8";
	
	@SuppressWarnings("unused")
	private String wsUrl;
	
	RestTemplate restTemplate = new RestTemplate();
	
	
	@Value("#{prop['ws.url']}")
	public void setWsUrl(String wsUrl) {
		this.wsUrl = wsUrl;
	}
	public MemberValidateResponse validateMemberInfo(MemberValidateRequest requestBody, HttpHeaders headers, WebServiceResponse error){		
		MemberValidateResponse response;
		response = new MemberValidateResponse();
		response.setErrMsg("");
		response.setSessionToken(requestBody.getSessionToken());
		response.setStatus("ok");
		response.setUserName(requestBody.getUserName());
		// validate return
		return response;
	}
	public MemberLoginResponse loginMember(MemberLoginRequest requestBody, HttpHeaders headers, WebServiceResponse error){		
		MemberLoginResponse response = new MemberLoginResponse();
        try {
        	URL url = new URL("http://10.17.50.248/ldaplogin/ldaplogin.aspx?userid="+requestBody.getUserName()+"&password="+requestBody.getPassword());  
                // marshal object to file input stream
                LoginLdap st = XmlUtils.readXml(url, LoginLdap.class);
                if(st.getErr_code()==0){
                	response.setErrMsg("");        		
                	response.setStatus("ok");
                	response.setSessionToken(st.getSessionID());
                	response.setUserName(requestBody.getUserName());
                }
        		else{
        			response=null;
        		}
                // prints        		
        } catch (Exception e1) {

            e1.printStackTrace();
        }
		// validate return
		return response;
	}		
		
}
