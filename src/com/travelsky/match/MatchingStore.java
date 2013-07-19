package com.travelsky.match;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

/**
 * @author windheaven
 * 
 */
@Entity
public class MatchingStore {

	@PrimaryKey
	private long storeID;
	private String name;
	private long areaID;
	@SecondaryKey(relate = Relationship.MANY_TO_ONE)
	private String areaInAirport;
	// private String airport;
	private int floor;

	public long getStoreID() {
		return storeID;
	}

	public void setStoreID(long storeID) {
		this.storeID = storeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAreaID() {
		return areaID;
	}

	public void setAreaID(long areaID) {
		this.areaID = areaID;
	}

	public String getAreaInAirport() {
		return areaInAirport;
	}

	public void setAreaInAirport(String areaInAirport) {
		this.areaInAirport = areaInAirport;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

}
