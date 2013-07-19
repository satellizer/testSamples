package com.travelsky.bdb;

/**
 * berkeleyDb操作接口
 * 
 * @author Ever
 * 
 * @param <T>
 */
public interface BdbDaoInf<T> {
	/**
	 * save a entity
	 * 
	 * @param t
	 */
	void save(T t);

	/**
	 * delete a entity by the primaryKey
	 * 
	 * @param key
	 * @return
	 */
	boolean delete(Long key);

	T getByPriKey(Long primaryKey);
}
