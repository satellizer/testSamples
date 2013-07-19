package com.travelsky.bdb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sleepycat.persist.PrimaryIndex;
import com.sleepycat.persist.SecondaryIndex;
import com.travelsky.match.MatchingArea;

/**
 * 航班信息dao
 * 
 * @author Ever
 * 
 */
@Service("bdbDao4AreaImpl")
public class BdbDao4AreaImpl implements BdbDaoInf<MatchingArea> {

    @Resource(name = "bdbenv")
    private BdbEnv bdbEnv;

    private PrimaryIndex<Long, MatchingArea> pKey;
    private SecondaryIndex<String, Long, MatchingArea> statusKey;

    @PostConstruct
    public void init() {
        pKey = bdbEnv.getEntityStore().getPrimaryIndex(Long.class, MatchingArea.class);
        statusKey = bdbEnv.getEntityStore().getSecondaryIndex(pKey, String.class, "areaInAirport");
    }

    @Override
    public void save(MatchingArea matchingArea) {
        pKey.put(matchingArea);
    }

    @Override
    public boolean delete(Long key) {
        return pKey.delete(key);
    }

    public boolean deleteByStatus(String status) {
        return statusKey.delete(status);
    }

    @Override
    public MatchingArea getByPriKey(Long primaryKey) {
        return pKey.get(primaryKey);
    }

    public MatchingArea getByStatus(String status) {
        return statusKey.get(status);
    }

    public static void main(String[] args) {
    }

}
