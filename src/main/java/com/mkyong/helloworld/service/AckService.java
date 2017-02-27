/**
 * 
 */
package com.mkyong.helloworld.service;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author aksma
 *
 */
@Service
public class AckService {

	@Autowired
	LinkedBlockingQueue queue;
	
	public boolean acknowledge(String deviceToken){
		return queue.offer(deviceToken);
	}
	
	public String getAcknowledgement() throws InterruptedException{
		return (String) queue.poll(57, TimeUnit.SECONDS);
	}
	
}
