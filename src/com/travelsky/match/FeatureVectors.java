package com.travelsky.match;

import com.sleepycat.persist.model.Persistent;

/**
 * 描述一个图片的特征矩阵
 * 
 * @author windheaven
 * 
 */
@Persistent
public class FeatureVectors {

	private String name;
	private float[][] matrix;
	private int row;
	private int column;

	public FeatureVectors(String name, float[][] matrix) {
		this.name = name;
		this.matrix = matrix;
		row = matrix.length;

		if (null != matrix)
			column = matrix[0].length;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(float[][] matrix) {
		this.matrix = matrix;
	}

}
