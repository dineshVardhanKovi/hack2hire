package com.dbs.hack2hire.fxRateAlert.response;

import java.util.List;

import com.dbs.hack2hire.fxRateAlert.dto.FxRateAlertNotificationDTO;

public class FxRateAlertNotificationResponse {
	private String message;
	
	private List<FxRateAlertNotificationDTO> notifications ;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<FxRateAlertNotificationDTO> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<FxRateAlertNotificationDTO> notifications) {
		this.notifications = notifications;
	}
	
	
}
