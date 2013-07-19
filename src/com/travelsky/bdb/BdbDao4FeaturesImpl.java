package com.travelsky.bdb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sleepycat.persist.PrimaryIndex;
import com.sleepycat.persist.SecondaryIndex;
import com.travelsky.match.MatchingArea;
import com.travelsky.match.MatchingFeatures;

/**
 * 航班信息dao
 * 
 * @author Ever
 * 
 */
@Service("bdbDao4FeatureImpl")
public class BdbDao4FeaturesImpl implements BdbDaoInf<MatchingFeatures> {

	@Resource(name = "bdbenv")
	private BdbEnv bdbEnv;

	private PrimaryIndex<Long, MatchingFeatures> pKey;
	private SecondaryIndex<String, Long, MatchingFeatures> statusKey;

	@PostConstruct
	public void init() {
		pKey = bdbEnv.getEntityStore().getPrimaryIndex(Long.class,
				MatchingFeatures.class);
		statusKey = bdbEnv.getEntityStore().getSecondaryIndex(pKey,
				String.class, "storeID");
	}

	@Override
	public void save(MatchingFeatures matchingFeatures) {
		pKey.put(matchingFeatures);
	}

	@Override
	public boolean delete(Long key) {
		return pKey.delete(key);
	}

	public boolean deleteByStatus(String status) {
		return statusKey.delete(status);
	}

	@Override
	public MatchingFeatures getByPriKey(Long primaryKey) {
		return pKey.get(primaryKey);
	}

	public MatchingFeatures getByStatus(String status) {
		return statusKey.get(status);
	}

	public static void main(String[] args) {
	}

}
