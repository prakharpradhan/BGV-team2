package com.cg.backgroundverification.exceptions;

import java.util.Date;

/**
 * pojo class for custom exception class
 * 
 * @author trainee
 *
 */
public class ErrorDetails {
	private String message;
	private String url;
	private Date timeStamp;

	public ErrorDetails(String message, String url, Date timeStamp) {

		this.message = message;
		this.url = url;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
