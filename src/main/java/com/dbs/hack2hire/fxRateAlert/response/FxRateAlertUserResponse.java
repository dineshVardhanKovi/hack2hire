package com.dbs.hack2hire.fxRateAlert.response;

import java.util.List;

import com.dbs.hack2hire.fxRateAlert.dto.FxRateAlertNotificationDTO;

public class FxRateAlertUserResponse {
	private List<FxRateAlertNotificationDTO> exchangeRates;

	public List<FxRateAlertNotificationDTO> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(List<FxRateAlertNotificationDTO> exchangeRates) {
		this.exchangeRates = exchangeRates;
	}



	
}
