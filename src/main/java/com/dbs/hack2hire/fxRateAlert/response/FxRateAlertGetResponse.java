package com.dbs.hack2hire.fxRateAlert.response;

import java.util.List;

import com.dbs.hack2hire.fxRateAlert.entity.FxRateAlertConfig;

public class FxRateAlertGetResponse {
	private List<FxRateAlertConfig> alertConfigs;
	
	private String message;
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<FxRateAlertConfig> getAlertConfigs() {
		return alertConfigs;
	}

	public void setAlertConfigs(List<FxRateAlertConfig> alertConfigs) {
		this.alertConfigs = alertConfigs;
	}

}
