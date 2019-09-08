package com.dbs.hack2hire.fxRateAlert.service;

import java.util.List;

import com.dbs.hack2hire.fxRateAlert.dto.FxRateAlertNotificationDTO;
import com.dbs.hack2hire.fxRateAlert.response.FxRateAlertNotificationResponse;

public interface FxRateAlertNotificationService {
	FxRateAlertNotificationResponse getNotifications(Long userId);
	
	List<FxRateAlertNotificationDTO> createNotification(Long userId);
	
	void sendNotifications();
}
