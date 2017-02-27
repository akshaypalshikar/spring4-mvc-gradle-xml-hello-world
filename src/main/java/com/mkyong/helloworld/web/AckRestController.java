/**
 * 
 */
package com.mkyong.helloworld.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mkyong.helloworld.model.Gcm;
import com.mkyong.helloworld.service.AckService;
import com.mkyong.helloworld.service.GcmService;

/**
 * @author aksma
 *
 */
@RestController
public class AckRestController {

	@Autowired 
	AckService ackService;
	
	@Autowired
	GcmService gcmService;
	
	@Autowired
	Gson gson;
	
	@RequestMapping(value = "/ack", method = RequestMethod.GET, produces={MediaType.TEXT_PLAIN_VALUE})
	public void ack() throws InterruptedException {
		ackService.acknowledge("ABC");
	}

}
