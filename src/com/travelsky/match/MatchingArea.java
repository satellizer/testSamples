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
public class MatchingArea {

	@PrimaryKey
	private long areaID;
	@SecondaryKey(relate = Relationship.MANY_TO_ONE)
	private String areaInAirport;
	// private String airport;
	private long conjID1;
	private long conjID2;

	public long getAreaID() {
		return areaID;
	}

	public void setAreaID(long areaID) {
		this.areaID = areaID;
	}

	public String getAirportWithArea() {
		return areaInAirport;
	}

	public void setAirportWithArea(String airportWithArea) {
		this.areaInAirport = airportWithArea;
	}

	public long getConjID1() {
		return conjID1;
	}

	public void setConjID1(long conjID1) {
		this.conjID1 = conjID1;
	}

	public long getConjID2() {
		return conjID2;
	}

	public void setConjID2(long conjID2) {
		this.conjID2 = conjID2;
	}

}
