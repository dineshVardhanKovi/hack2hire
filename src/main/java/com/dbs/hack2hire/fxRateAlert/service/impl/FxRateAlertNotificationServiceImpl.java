package com.dbs.hack2hire.fxRateAlert.service.impl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dbs.hack2hire.fxRateAlert.constants.FxRateAlertConstants;
import com.dbs.hack2hire.fxRateAlert.dto.FxRateAlertNotificationDTO;
import com.dbs.hack2hire.fxRateAlert.entity.FxRateAlertConfig;
import com.dbs.hack2hire.fxRateAlert.fiegn.TransferWiseFiegn;
import com.dbs.hack2hire.fxRateAlert.repository.FxRateAlertConfigRepository;
import com.dbs.hack2hire.fxRateAlert.response.FxRateAlertNotificationResponse;
import com.dbs.hack2hire.fxRateAlert.response.TrasferWiseExchangeRateResponse;
import com.dbs.hack2hire.fxRateAlert.service.FxRateAlertNotificationService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import oracle.sql.DATE;

@Service
public class FxRateAlertNotificationServiceImpl implements FxRateAlertNotificationService{

	Logger logger = LoggerFactory.getLogger(FxRateAlertNotificationServiceImpl.class);

	@Autowired
	private FxRateAlertConfigRepository fxRateAlertCofigRepository;

	@Autowired
	private TransferWiseFiegn transferWiseFiegn;
	
	@Value("${transferWise.token}")
	private String transferWireToken ;


	@Override
	public FxRateAlertNotificationResponse getNotifications(Long userId) {
		logger.info("IN FxRateAlertNotificationServiceImpl.getNotifications");
		FxRateAlertNotificationResponse fxRateAlertNotificationResponse = new FxRateAlertNotificationResponse();
		try {
			fxRateAlertNotificationResponse.setNotifications(createNotification(userId));
			fxRateAlertNotificationResponse.setMessage(FxRateAlertConstants.success);
		} catch (Exception e) {
			logger.error("Exception occured"  + e.getMessage());
			throw e;
		}
		return fxRateAlertNotificationResponse;
	}

	@Override
	public List<FxRateAlertNotificationDTO> createNotification(Long userId) {
		logger.info("IN FxRateAlertNotificationServiceImpl.createNotification");
		System.out.println(transferWireToken);
		List<FxRateAlertNotificationDTO> notifications =  new LinkedList<>();
		try {
			List<FxRateAlertConfig> alertConfigs =  fxRateAlertCofigRepository.findByUserId(userId);

			alertConfigs.forEach(alertConfig -> {
				notifications.add(new FxRateAlertNotificationDTO("Please note that the exhcange rate from " + alertConfig.getBaseCurrency() + " to "
						+ alertConfig.getExchangeCurrency() + " has reached you desired rate " + alertConfig.getDesiredExchangeRate()));
			});
		} catch (Exception e) {
			logger.error("Exception occured"  + e.getMessage());
			throw e;
		}
		return notifications;
	}

	@Override
	public void sendNotifications() {
		List<FxRateAlertConfig> alertConfigs =  fxRateAlertCofigRepository.findAlertConfigsForNotifications();
		alertConfigs.stream().forEach(alertConfig -> {
			List<TrasferWiseExchangeRateResponse> exchangeRateResponse = transferWiseFiegn.getExchangeRatesFromTransferFiegn(transferWireToken,alertConfig.getBaseCurrency(), alertConfig.getExchangeCurrency());
			try {
				//exchangeRateResponse = new ObjectMapper().readValue(jsonString, TrasferWiseExchangeRateResponse.class);
				if(exchangeRateResponse.get(0).getRate() >= alertConfig.getDesiredExchangeRate()) {
					if(alertConfig.getCount()==2) {
						alertConfig.setCount(0);			
					}else {
						alertConfig.setCount(alertConfig.getCount() + 1);
					}		
				}else {
					alertConfig.setCount(0);
				}
				fxRateAlertCofigRepository.save(alertConfig);
			} catch (Exception e) {
				logger.error("Exception occured"  + e.getMessage());
			}
		});
	}




}
