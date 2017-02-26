/**
 * 
 */
package com.mkyong.helloworld.model;

/**
 * @author aksma
 *
 */
public class Notification {
	String body;
	String title;
	String icon;
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "Notification [body=" + body + ", title=" + title + ", icon=" + icon + "]";
	}
}
