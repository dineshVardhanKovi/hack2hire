package com.dbs.hack2hire.fxRateAlert.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ALERT_CONFIG")
public class FxRateAlertConfig {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO, generator="alert_config_seq")
	@SequenceGenerator(name="alert_config_seq", sequenceName="alert_config_seq",initialValue = 1, allocationSize = 1)
	private long id;
	
	@Column(name = "user_id")
	private long userId;

	@Column(name = "base_currency")
	private String baseCurrency;
	
	@Column(name = "base_currency_country")
	private String baseCurrencyCountry;

	@Column(name = "exchange_currency")
	private String exchangeCurrency;
	
	@Column(name = "exchange_currency_country")
	private String exchangeCurrencyCountry;

	@Column(name = "desired_exchange_rate")
	private Double desiredExchangeRate;
	
	@Column(name = "travel_date")
	private Date travelDate;
	
	@Column(name = "notifications_required")
	private String notificationsRequired;

	@Column(name = "count")
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getBaseCurrencyCountry() {
		return baseCurrencyCountry;
	}

	public void setBaseCurrencyCountry(String baseCurrencyCountry) {
		this.baseCurrencyCountry = baseCurrencyCountry;
	}

	public String getExchangeCurrencyCountry() {
		return exchangeCurrencyCountry;
	}

	public void setExchangeCurrencyCountry(String exchangeCurrencyCountry) {
		this.exchangeCurrencyCountry = exchangeCurrencyCountry;
	}

	public Double getDesiredExchangeRate() {
		return desiredExchangeRate;
	}

	public void setDesiredExchangeRate(Double desiredExchangeRate) {
		this.desiredExchangeRate = desiredExchangeRate;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getExchangeCurrency() {
		return exchangeCurrency;
	}

	public void setExchangeCurrency(String exchangeCurrency) {
		this.exchangeCurrency = exchangeCurrency;
	}

	public String getNotificationsRequired() {
		return notificationsRequired;
	}

	public void setNotificationsRequired(String notificationsRequired) {
		this.notificationsRequired = notificationsRequired;
	}



}
