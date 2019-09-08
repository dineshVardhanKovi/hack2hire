package com.dbs.hack2hire.fxRateAlert.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dbs.hack2hire.fxRateAlert.constants.FxRateAlertConstants;
import com.dbs.hack2hire.fxRateAlert.dto.FxRateAlertConfigRequestDTO;
import com.dbs.hack2hire.fxRateAlert.entity.FxRateAlertConfig;
import com.dbs.hack2hire.fxRateAlert.response.FxRateAlertConfigSaveResponse;
import com.dbs.hack2hire.fxRateAlert.response.FxRateAlertGetResponse;
import com.dbs.hack2hire.fxRateAlert.response.FxRateDeleteResponse;
import com.dbs.hack2hire.fxRateAlert.response.FxRateUpdateResponse;
import com.dbs.hack2hire.fxRateAlert.service.FxRateAlertConfigService;

@RestController
@RequestMapping(FxRateAlertConstants.basePath)
public class FxRateAlertConfigController {
	
	Logger logger = LoggerFactory.getLogger(FxRateAlertConfigController.class);

	@Autowired
	private FxRateAlertConfigService fxRateAlertConfigService;

	@CrossOrigin
	@RequestMapping(value = FxRateAlertConstants.alertConfigs,method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<FxRateAlertConfigSaveResponse> saveAlertConfigs(@RequestBody FxRateAlertConfigRequestDTO alertConfig) {
		logger.info("IN FxRateAlertConfigController.saveAlertConfigs");
		ResponseEntity<FxRateAlertConfigSaveResponse> responseEntity ;
		FxRateAlertConfigSaveResponse fxRateAlertConfigSaveResponse = new FxRateAlertConfigSaveResponse();
		try {
			fxRateAlertConfigSaveResponse = fxRateAlertConfigService.saveAlertConfig(alertConfig.getAlertConfigs());
			responseEntity = new ResponseEntity<FxRateAlertConfigSaveResponse>(fxRateAlertConfigSaveResponse,HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured"  + e.getMessage());
			fxRateAlertConfigSaveResponse.setMessage(FxRateAlertConstants.failureMessage);
			responseEntity = new ResponseEntity<FxRateAlertConfigSaveResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@CrossOrigin
	@RequestMapping(value = FxRateAlertConstants.alertConfigs + "/{userId}",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<FxRateAlertGetResponse> getAlertConfig(@PathVariable String userId) {
		logger.info("IN FxRateAlertConfigController.getAlertConfig");
		ResponseEntity<FxRateAlertGetResponse> responseEntity ;

		FxRateAlertGetResponse fxRateAlertGetResponse = new FxRateAlertGetResponse();
		try {
			fxRateAlertGetResponse = fxRateAlertConfigService.getAlertConfig(Long.valueOf(userId));
			responseEntity = new ResponseEntity<FxRateAlertGetResponse>(fxRateAlertGetResponse,HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured"  + e.getMessage());
			fxRateAlertGetResponse.setMessage(FxRateAlertConstants.failureMessage);
			responseEntity = new ResponseEntity<FxRateAlertGetResponse>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}

	@CrossOrigin
	@RequestMapping(value = FxRateAlertConstants.alertConfigs + "/{id}",method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public ResponseEntity<FxRateUpdateResponse> updateAlertConfig(@PathVariable String id,@RequestBody FxRateAlertConfig alertConfig) {
		logger.info("IN FxRateAlertConfigController.updateAlertConfig");
		ResponseEntity<FxRateUpdateResponse> responseEntity ;
		FxRateUpdateResponse fxRateUpdateResponse = new FxRateUpdateResponse();	
		try {
			fxRateUpdateResponse= fxRateAlertConfigService.updateAlertConfig(Long.valueOf(id),alertConfig);
			responseEntity = new ResponseEntity<FxRateUpdateResponse>(fxRateUpdateResponse,HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured"  + e.getMessage());
			fxRateUpdateResponse.setMessage(FxRateAlertConstants.failureMessage);
			responseEntity = new ResponseEntity<FxRateUpdateResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@CrossOrigin
	@RequestMapping(value = FxRateAlertConstants.alertConfigs + "/{id}",method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
	public ResponseEntity<FxRateDeleteResponse> deleteAlertConfig(@PathVariable String id,@RequestBody FxRateAlertConfig alertConfig) {
		logger.info("IN FxRateAlertConfigController.deleteAlertConfig");
		ResponseEntity<FxRateDeleteResponse> responseEntity ;
		FxRateDeleteResponse fxRateDeleteResponse = new FxRateDeleteResponse();
		try {
			fxRateDeleteResponse = fxRateAlertConfigService.deleteAlertConfig(Long.valueOf(id));
			responseEntity = new ResponseEntity<FxRateDeleteResponse>(fxRateDeleteResponse,HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occured"  + e.getMessage());
			fxRateDeleteResponse.setMessage(FxRateAlertConstants.failureMessage);
			responseEntity = new ResponseEntity<FxRateDeleteResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

}
