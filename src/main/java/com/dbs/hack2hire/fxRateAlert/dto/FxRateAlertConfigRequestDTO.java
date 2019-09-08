package com.dbs.hack2hire.fxRateAlert.dto;

import java.util.List;

import com.dbs.hack2hire.fxRateAlert.entity.FxRateAlertConfig;

public class FxRateAlertConfigRequestDTO {
	private List<FxRateAlertConfig> alertConfigs;

	public List<FxRateAlertConfig> getAlertConfigs() {
		return alertConfigs;
	}

	public void setAlertConfigs(List<FxRateAlertConfig> alertConfigs) {
		this.alertConfigs = alertConfigs;
	}
	
	
}
