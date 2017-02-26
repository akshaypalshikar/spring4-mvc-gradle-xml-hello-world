/**
 * 
 */
package com.mkyong.helloworld.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.helloworld.model.Gcm;
import com.mkyong.helloworld.service.GcmService;

@RestController
public class GcmRestController {
	
	@Autowired 
	GcmService gcmService;
	
	@RequestMapping(value = "/gcm", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public String sendGcm(@RequestBody Gcm gcm) {
		return gcmService.sendFcm(gcm);
	}

}
