package com.dbs.hack2hire.fxRateAlert.response;

import java.sql.Date;
import java.util.List;


public class TrasferWiseExchangeRateResponse {
	private Double rate;
	private String source;
	private String target;
	private Date time;
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}



}
