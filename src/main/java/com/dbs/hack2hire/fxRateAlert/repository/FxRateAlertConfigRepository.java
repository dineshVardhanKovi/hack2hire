package com.dbs.hack2hire.fxRateAlert.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbs.hack2hire.fxRateAlert.entity.FxRateAlertConfig;

@Repository
public interface FxRateAlertConfigRepository extends JpaRepository<FxRateAlertConfig, Serializable>{
	List<FxRateAlertConfig> findByUserId(Long userId);
	
	@Query("update FxRateAlertConfig set baseCurrency = :baseCurrency , exchangeCurrency =:exchangeCurrency ,"
			+ " notificationsRequired =:notificationsRequired,desiredExchangeRate= :desiredExchangeRate where id =:id ")
	@Modifying
	void updateAlertConfig(@Param("baseCurrency") String baseCurrency,@Param("exchangeCurrency") String exchangeCurrency,
			@Param("notificationsRequired")String notificationsRequired,@Param("desiredExchangeRate") Double desiredExchangeRate, @Param("id") Long id);
	
	@Query("select ac from FxRateAlertConfig ac where  notificationsRequired = 'Y'")
	List<FxRateAlertConfig> findAlertConfigsForNotifications();
}
