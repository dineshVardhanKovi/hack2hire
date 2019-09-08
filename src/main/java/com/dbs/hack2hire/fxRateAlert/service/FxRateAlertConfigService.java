package com.dbs.hack2hire.fxRateAlert.service;

import java.util.List;

import com.dbs.hack2hire.fxRateAlert.entity.FxRateAlertConfig;
import com.dbs.hack2hire.fxRateAlert.response.FxRateAlertConfigSaveResponse;
import com.dbs.hack2hire.fxRateAlert.response.FxRateAlertGetResponse;
import com.dbs.hack2hire.fxRateAlert.response.FxRateDeleteResponse;
import com.dbs.hack2hire.fxRateAlert.response.FxRateUpdateResponse;

public interface FxRateAlertConfigService {
	FxRateAlertConfigSaveResponse saveAlertConfig(List<FxRateAlertConfig> alertConfigList);
	
	FxRateAlertGetResponse getAlertConfig(Long userId);
	
	FxRateUpdateResponse updateAlertConfig(Long id,FxRateAlertConfig alertConfig);
	
	FxRateDeleteResponse deleteAlertConfig(Long id);
}
