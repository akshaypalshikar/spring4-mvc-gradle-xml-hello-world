/**
 * 
 */
package com.mkyong.helloworld.model;

/**
 * @author aksma
 *
 */

public class Gcm {

	String to;
	Notification notification;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Notification getNotification() {
		return notification;
	}
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	@Override
	public String toString() {
		return "Gcm [to=" + to + ", notification=" + notification + "]";
	}
	
}
