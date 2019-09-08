package com.dbs.hack2hire.fxRateAlert.fiegn;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Component
@FeignClient(value = "TransferWise",url ="https://api.sandbox.transferwise.tech/v1/rates")
public interface TransferWiseFiegn {

	@RequestMapping(method = RequestMethod.GET)
	String getExchangeRatesFromTransferFiegn(@RequestHeader(value = "Authorization") String token,@RequestParam("source")String baseCurrency,
	@RequestParam("target")String exchangeCurrency) ;
}
