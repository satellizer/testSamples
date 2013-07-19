package com.travelsky.match;

import java.util.List;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

/**
 * @author windheaven
 * 
 */
@Entity
public class MatchingFeatures {

	@PrimaryKey
	private long featureID;
	// 所属商铺ID
	@SecondaryKey(relate = Relationship.ONE_TO_MANY)
	private long storeID;
	// 图片的视角
	private byte perspective;
	// 商铺的名字
	private String name;
	// 商铺的矩阵
	private byte[] matrix;

	public byte[] getMatrix() {
		return matrix;
	}

	public void setMatrix(byte[] matrix) {
		this.matrix = matrix;
	}

	public long getFeatureID() {
		return featureID;
	}

	public void setFeatureID(long featureID) {
		this.featureID = featureID;
	}

	public long getStoreID() {
		return storeID;
	}

	public void setStoreID(long storeID) {
		this.storeID = storeID;
	}

	public byte getPerspective() {
		return perspective;
	}

	public void setPerspective(byte perspective) {
		this.perspective = perspective;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
