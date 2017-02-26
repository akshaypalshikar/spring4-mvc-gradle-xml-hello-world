/**
 * 
 */
package com.mkyong.helloworld.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;

import com.google.gson.Gson;
import com.mkyong.helloworld.model.Gcm;

/**
 * @author aksma
 *
 */
@Service
public class GcmService {

	private static final Logger logger = LoggerFactory.getLogger(GcmService.class);
	private String HTTP_URL = "https://fcm.googleapis.com/fcm/send";
	
	private String KEY=""; 
	@Autowired
	private RestTemplate rest;
	@Autowired
	private HttpHeaders headers;

	private HttpStatus status;
	
	
	@Autowired
	Gson gson;

	public String sendFcm(Gcm gcm) {
	
		headers.add("Authorization", KEY);
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//String jsonString = "{\"to\":\"fljeD55llmA:APA91bE7JdDKfPRY4lYtKs3InJJaEuHWEnQclwOOeZUBQds85JqkQCXfxuL0PjBsuXu87cijkuPdMD5_eSTultLAYXPM0sCxVT_6N05SLPGrCaVUSUSf6MxlZW7cathjVgvW58cbtW3v\",\"notification\" : {		\"body\":\"this is body\",\"title\":\"this is title\",		\"icon\":\"icon\"	}}";
		String jsonString = gson.toJson(gcm);
		logger.info(String.format("%s", jsonString));
		HttpEntity<String> requestEntity = new HttpEntity<String>(jsonString, headers);
		ResponseEntity<String> responseEntity = rest.exchange(HTTP_URL, HttpMethod.POST, requestEntity,
				String.class);
		this.setStatus(responseEntity.getStatusCode());
		String response = responseEntity.getBody();
		logger.info("response : "+response);
		return response ;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
