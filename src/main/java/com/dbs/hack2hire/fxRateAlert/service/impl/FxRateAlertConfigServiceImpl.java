package com.dbs.hack2hire.fxRateAlert.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbs.hack2hire.fxRateAlert.constants.FxRateAlertConstants;
import com.dbs.hack2hire.fxRateAlert.entity.FxRateAlertConfig;
import com.dbs.hack2hire.fxRateAlert.repository.FxRateAlertConfigRepository;
import com.dbs.hack2hire.fxRateAlert.response.FxRateAlertConfigSaveResponse;
import com.dbs.hack2hire.fxRateAlert.response.FxRateAlertGetResponse;
import com.dbs.hack2hire.fxRateAlert.response.FxRateDeleteResponse;
import com.dbs.hack2hire.fxRateAlert.response.FxRateUpdateResponse;
import com.dbs.hack2hire.fxRateAlert.service.FxRateAlertConfigService;

@Service
public class FxRateAlertConfigServiceImpl implements FxRateAlertConfigService{
	Logger logger = LoggerFactory.getLogger(FxRateAlertConfigServiceImpl.class);

	@Autowired
	FxRateAlertConfigRepository fxRateAlertCofigRepository;

	@Override
	public FxRateAlertConfigSaveResponse saveAlertConfig(List<FxRateAlertConfig> alertConfigList) {
		logger.info("In FxRateAlertConfigServiceImpl.saveAlertConfig");
		FxRateAlertConfigSaveResponse fxRateAlertConfigSaveResponse = new FxRateAlertConfigSaveResponse();
		try {
			fxRateAlertCofigRepository.saveAll(alertConfigList);
			fxRateAlertConfigSaveResponse.setMessage(FxRateAlertConstants.alertConfigSaveSuccess);
		} catch (Exception e) {
			logger.error("Exception occured"  + e.getMessage());
			throw e;
		}

		return fxRateAlertConfigSaveResponse;
	}

	@Override
	public FxRateAlertGetResponse getAlertConfig(Long userId) {
		logger.info("In FxRateAlertConfigServiceImpl.getAlertConfig");
		FxRateAlertGetResponse fxRateAlertGetResponse = new FxRateAlertGetResponse();
		try {
			List<FxRateAlertConfig> alertConfigs =  fxRateAlertCofigRepository.findByUserId(userId);
			fxRateAlertGetResponse.setMessage(FxRateAlertConstants.success);
			fxRateAlertGetResponse.setAlertConfigs(alertConfigs);
		} catch (Exception e) {
			logger.error("Exception occured"  + e.getMessage());
			throw e;
		}
		return fxRateAlertGetResponse;
	}

	@Override
	@Transactional
	public FxRateUpdateResponse updateAlertConfig(Long id,FxRateAlertConfig alertConfig) {
		logger.info("In FxRateAlertConfigServiceImpl.updateAlertConfig");
		FxRateUpdateResponse fxRateUpdateResponse = new FxRateUpdateResponse();	
		try {
			Optional<FxRateAlertConfig> alertConfigOptional = fxRateAlertCofigRepository.findById(id);
			if(alertConfigOptional.isPresent()) {
				fxRateAlertCofigRepository.updateAlertConfig(alertConfig.getBaseCurrency(),alertConfig.getExchangeCurrency(),
						alertConfig.getNotificationsRequired(),alertConfig.getDesiredExchangeRate(),alertConfig.getTravelDate(),alertConfig.getId());
				fxRateUpdateResponse.setMessage(FxRateAlertConstants.alertConfigUpdateSuccess);
			}
		} catch (Exception e) {
			logger.error("Exception occured"  + e.getMessage());
			throw e;
		}
		return fxRateUpdateResponse;
	}

	@Override
	public FxRateDeleteResponse deleteAlertConfig(Long id) {
		logger.info("In FxRateAlertConfigServiceImpl.deleteAlertConfig");
		FxRateDeleteResponse fxRateDeleteResponse = new FxRateDeleteResponse();
		try {
			fxRateAlertCofigRepository.deleteById(id);
			fxRateDeleteResponse.setMessage(FxRateAlertConstants.alertConfigDeleteSuccess);
		} catch (Exception e) {
			logger.error("Exception occured"  + e.getMessage());
			throw e;
		}
		return fxRateDeleteResponse;
	}





}
