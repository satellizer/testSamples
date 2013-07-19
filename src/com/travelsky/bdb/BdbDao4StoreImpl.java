package com.travelsky.bdb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sleepycat.persist.EntityCursor;
import com.sleepycat.persist.PrimaryIndex;
import com.sleepycat.persist.SecondaryIndex;
import com.travelsky.match.MatchingArea;
import com.travelsky.match.MatchingStore;

/**
 * 航班信息dao
 * 
 * @author Ever
 * 
 */
@Service("bdbDao4StoreImpl")
public class BdbDao4StoreImpl implements BdbDaoInf<MatchingStore> {

	@Resource(name = "bdbenv")
	private BdbEnv bdbEnv;

	private PrimaryIndex<Long, MatchingStore> pKey;
	private SecondaryIndex<String, Long, MatchingStore> statusKey;

	@PostConstruct
	public void init() {
		pKey = bdbEnv.getEntityStore().getPrimaryIndex(Long.class,
				MatchingStore.class);
		statusKey = bdbEnv.getEntityStore().getSecondaryIndex(pKey,
				String.class, "areaInAirport");
	}

	@Override
	public void save(MatchingStore matchingStore) {
		pKey.put(matchingStore);
	}

	@Override
	public boolean delete(Long key) {
		return pKey.delete(key);
	}

	public boolean deleteByStatus(String status) {
		return statusKey.delete(status);
	}

	@Override
	public MatchingStore getByPriKey(Long primaryKey) {
		return pKey.get(primaryKey);
	}

	public List<MatchingStore> getByStatus(String status) {
		EntityCursor<MatchingStore> es = statusKey.subIndex(status).entities();
		List<MatchingStore> mss = new ArrayList<MatchingStore>();
		for (MatchingStore ms : es) {
			mss.add(ms);
		}
		return mss;
	}

	public static void main(String[] args) {
	}

}
