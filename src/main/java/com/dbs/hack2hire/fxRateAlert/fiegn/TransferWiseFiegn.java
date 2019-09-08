package com.dbs.hack2hire.fxRateAlert.fiegn;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbs.hack2hire.fxRateAlert.response.TrasferWiseExchangeRateResponse;


@Component
@FeignClient(value = "TransferWise",url ="https://api.sandbox.transferwise.tech/v1/rates")
public interface TransferWiseFiegn {

	@RequestMapping(method = RequestMethod.GET)
	List<TrasferWiseExchangeRateResponse> getExchangeRatesFromTransferFiegn(@RequestHeader(value = "Authorization") String token,@RequestParam("source")String baseCurrency,
	@RequestParam("target")String exchangeCurrency) ;
}
