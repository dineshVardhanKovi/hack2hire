package com.dbs.hack2hire.fxRateAlert.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.hack2hire.fxRateAlert.constants.FxRateAlertConstants;
import com.dbs.hack2hire.fxRateAlert.response.FxRateAlertNotificationResponse;
import com.dbs.hack2hire.fxRateAlert.service.FxRateAlertNotificationService;

@RestController
@RequestMapping(FxRateAlertConstants.basePath)
public class FxRateAlertNotificationController {
	Logger logger = LoggerFactory.getLogger(FxRateAlertConfigController.class);

	@Autowired
	private FxRateAlertNotificationService fxRateAlertNotificationService;
	
	@CrossOrigin
	@RequestMapping(value = FxRateAlertConstants.notifications + "/{userId}",method = RequestMethod.GET, produces = "application/json")
	public FxRateAlertNotificationResponse getNotifications(@PathVariable String userId) {
		logger.info("IN FxRateAlertNotificationController.getNotifications");
		FxRateAlertNotificationResponse fxRateAlertNotificationResponse = new FxRateAlertNotificationResponse();
		try {
			fxRateAlertNotificationResponse = fxRateAlertNotificationService.getNotifications(Long.valueOf(userId));
		} catch (Exception e) {
			logger.error("Exception occured"  + e.getMessage());
			fxRateAlertNotificationResponse.setMessage(FxRateAlertConstants.failureMessage);
		}
		return fxRateAlertNotificationResponse;
	}
	
	@Scheduled(cron = "${notification.cron}")
	//@RequestMapping(value =FxRateAlertConstants.notifications + "/fetchNotifications",method = RequestMethod.POST)
	public void sendNotifications() {
		logger.info("IN FxRateAlertNotificationResponse.sendNotifications");
		fxRateAlertNotificationService.sendNotifications();
	}

}
