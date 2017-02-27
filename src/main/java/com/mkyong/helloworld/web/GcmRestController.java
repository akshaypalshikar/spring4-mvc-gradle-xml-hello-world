/**
 * 
 */
package com.mkyong.helloworld.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mkyong.helloworld.model.Gcm;
import com.mkyong.helloworld.service.AckService;
import com.mkyong.helloworld.service.GcmService;

@RestController
public class GcmRestController {
	
	@Autowired 
	GcmService gcmService;
	
	@Autowired
	AckService ackService; 
	
	@Autowired
	Gson gson;
	
	@RequestMapping(value = "/gcm", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public String sendGcm(@RequestBody Gcm gcm) {
		return gcmService.sendFcm(gcm);
	}
	
	
	@RequestMapping(value = "/gcm", method = RequestMethod.GET,  produces={MediaType.APPLICATION_JSON_VALUE})
	public String sendGcm() throws InterruptedException {
		String jsonString = "{\"to\":\"fljeD55llmA:APA91bE7JdDKfPRY4lYtKs3InJJaEuHWEnQclwOOeZUBQds85JqkQCXfxuL0PjBsuXu87cijkuPdMD5_eSTultLAYXPM0sCxVT_6N05SLPGrCaVUSUSf6MxlZW7cathjVgvW58cbtW3v\",\"notification\" : {		\"body\":\"this is body\",\"title\":\"this is title\",		\"icon\":\"icon\"	}}";
		Gcm gcm = gson.fromJson(jsonString, Gcm.class);
		gcmService.sendFcm(gcm);
		return  ackService.getAcknowledgement();
	}

}
