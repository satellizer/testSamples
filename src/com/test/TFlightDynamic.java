package com.test;

import java.util.Date;

/**
 * TFlightDynamicId entity. @author MyEclipse Persistence Tools
 */
public class TFlightDynamic implements java.io.Serializable {

	// Fields

	private Long flightId;
	private String airlineCode;
	private String flightNumber;
	private String cityCode;
	private String cityCn;
	private String cityEn;
	private String stopCityCode;
	private String stopCityCn;
	private String stopCityEn;
	private String planeType;
	private Date planTime;
	private Date predictTime;
	private Date actualTime;
	private String realtimeStatusCn;
	private String realtimeStatusEn;
	private String stopBuilding;
	private Long isDomestic;
	private Long isArrival;
	private String checkinCounter;
	private String gate;
	private Date boardingTime;
	private String sluiceGate;
	private String baggageBelt;
	private String flightType;
	private String airlineCn;
	private String airlineEn;
	private Long isNormal;
	private Long isPassengerPlane;
	private Date flightTime;

	// Constructors

	/** default constructor */
	public TFlightDynamic() {
	}

	/** minimal constructor */
	public TFlightDynamic(Long flightId) {
		this.flightId = flightId;
	}

	/** full constructor */
	public TFlightDynamic(Long flightId, String airlineCode,
			String flightNumber, String cityCode, String cityCn, String cityEn,
			String stopCityCode, String stopCityCn, String stopCityEn,
			String planeType, Date planTime, Date predictTime, Date actualTime,
			String realtimeStatusCn, String realtimeStatusEn,
			String stopBuilding, Long isDomestic, Long isArrival,
			String checkinCounter, String gate, Date boardingTime,
			String sluiceGate, String baggageBelt, String flightType,
			String airlineCn, String airlineEn, Long isNormal,
			Long isPassengerPlane, Date flightTime) {
		this.flightId = flightId;
		this.airlineCode = airlineCode;
		this.flightNumber = flightNumber;
		this.cityCode = cityCode;
		this.cityCn = cityCn;
		this.cityEn = cityEn;
		this.stopCityCode = stopCityCode;
		this.stopCityCn = stopCityCn;
		this.stopCityEn = stopCityEn;
		this.planeType = planeType;
		this.planTime = planTime;
		this.predictTime = predictTime;
		this.actualTime = actualTime;
		this.realtimeStatusCn = realtimeStatusCn;
		this.realtimeStatusEn = realtimeStatusEn;
		this.stopBuilding = stopBuilding;
		this.isDomestic = isDomestic;
		this.isArrival = isArrival;
		this.checkinCounter = checkinCounter;
		this.gate = gate;
		this.boardingTime = boardingTime;
		this.sluiceGate = sluiceGate;
		this.baggageBelt = baggageBelt;
		this.flightType = flightType;
		this.airlineCn = airlineCn;
		this.airlineEn = airlineEn;
		this.isNormal = isNormal;
		this.isPassengerPlane = isPassengerPlane;
		this.flightTime = flightTime;
	}

	// Property accessors
	public Long getFlightId() {
		return this.flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getAirlineCode() {
		return this.airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getFlightNumber() {
		return this.flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityCn() {
		return this.cityCn;
	}

	public void setCityCn(String cityCn) {
		this.cityCn = cityCn;
	}

	public String getCityEn() {
		return this.cityEn;
	}

	public void setCityEn(String cityEn) {
		this.cityEn = cityEn;
	}

	public String getStopCityCode() {
		return this.stopCityCode;
	}

	public void setStopCityCode(String stopCityCode) {
		this.stopCityCode = stopCityCode;
	}

	public String getStopCityCn() {
		return this.stopCityCn;
	}

	public void setStopCityCn(String stopCityCn) {
		this.stopCityCn = stopCityCn;
	}

	public String getStopCityEn() {
		return this.stopCityEn;
	}

	public void setStopCityEn(String stopCityEn) {
		this.stopCityEn = stopCityEn;
	}

	public String getPlaneType() {
		return this.planeType;
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}

	public Date getPlanTime() {
		return this.planTime;
	}

	public void setPlanTime(Date planTime) {
		this.planTime = planTime;
	}

	public Date getPredictTime() {
		return this.predictTime;
	}

	public void setPredictTime(Date predictTime) {
		this.predictTime = predictTime;
	}

	public Date getActualTime() {
		return this.actualTime;
	}

	public void setActualTime(Date actualTime) {
		this.actualTime = actualTime;
	}

	public String getRealtimeStatusCn() {
		return this.realtimeStatusCn;
	}

	public void setRealtimeStatusCn(String realtimeStatusCn) {
		this.realtimeStatusCn = realtimeStatusCn;
	}

	public String getRealtimeStatusEn() {
		return this.realtimeStatusEn;
	}

	public void setRealtimeStatusEn(String realtimeStatusEn) {
		this.realtimeStatusEn = realtimeStatusEn;
	}

	public String getStopBuilding() {
		return this.stopBuilding;
	}

	public void setStopBuilding(String stopBuilding) {
		this.stopBuilding = stopBuilding;
	}

	public Long getIsDomestic() {
		return this.isDomestic;
	}

	public void setIsDomestic(Long isDomestic) {
		this.isDomestic = isDomestic;
	}

	public Long getIsArrival() {
		return this.isArrival;
	}

	public void setIsArrival(Long isArrival) {
		this.isArrival = isArrival;
	}

	public String getCheckinCounter() {
		return this.checkinCounter;
	}

	public void setCheckinCounter(String checkinCounter) {
		this.checkinCounter = checkinCounter;
	}

	public String getGate() {
		return this.gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public Date getBoardingTime() {
		return this.boardingTime;
	}

	public void setBoardingTime(Date boardingTime) {
		this.boardingTime = boardingTime;
	}

	public String getSluiceGate() {
		return this.sluiceGate;
	}

	public void setSluiceGate(String sluiceGate) {
		this.sluiceGate = sluiceGate;
	}

	public String getBaggageBelt() {
		return this.baggageBelt;
	}

	public void setBaggageBelt(String baggageBelt) {
		this.baggageBelt = baggageBelt;
	}

	public String getFlightType() {
		return this.flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public String getAirlineCn() {
		return this.airlineCn;
	}

	public void setAirlineCn(String airlineCn) {
		this.airlineCn = airlineCn;
	}

	public String getAirlineEn() {
		return this.airlineEn;
	}

	public void setAirlineEn(String airlineEn) {
		this.airlineEn = airlineEn;
	}

	public Long getIsNormal() {
		return this.isNormal;
	}

	public void setIsNormal(Long isNormal) {
		this.isNormal = isNormal;
	}

	public Long getIsPassengerPlane() {
		return this.isPassengerPlane;
	}

	public void setIsPassengerPlane(Long isPassengerPlane) {
		this.isPassengerPlane = isPassengerPlane;
	}

	public Date getFlightTime() {
		return this.flightTime;
	}

	public void setFlightTime(Date flightTime) {
		this.flightTime = flightTime;
	}

}