package com.dbs.hack2hire.fxRateAlert.dto;

public class FxRateAlertNotificationDTO {
	private String  notificationMessage ;

	public String getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	public FxRateAlertNotificationDTO(String notificationMessage) {
		super();
		this.notificationMessage = notificationMessage;
	}
	
	
	
}
