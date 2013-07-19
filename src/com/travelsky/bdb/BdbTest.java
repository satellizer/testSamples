package com.travelsky.bdb;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;

import com.travelsky.match.MatchingArea;
import com.travelsky.match.MatchingStore;

public class BdbTest {
	private static BdbDao4AreaImpl areaDao;
	private static BdbDao4StoreImpl storeDao;
	private static BdbDao4FeaturesImpl featureDao;
	private static BdbEnv bdbEnv;

	@Before
	public void setUp() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");
		areaDao = appContext.getBean(BdbDao4AreaImpl.class);
		storeDao = appContext.getBean(BdbDao4StoreImpl.class);
		featureDao = appContext.getBean(BdbDao4FeaturesImpl.class);
		bdbEnv = appContext.getBean(BdbEnv.class);
	}

	@Test
	public void bdb() {
		try {
			// putAreaDaoTest();
			// getAreaDaoTest();
			// putStoreDaoTest();
			getStoreDaoTest();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bdbEnv.close();
		}

	}

	public static void putAreaDaoTest() {
		int count = 10;
		StopWatch watch = new StopWatch();
		watch.start();

		while (count > 0) {
			count--;
			MatchingArea ms = new MatchingArea();
			ms.setAreaID(count);
			ms.setConjID1(count % 5 + 1);
			ms.setConjID2(count % 5 + 3);
			ms.setAirportWithArea("BaiYunA");
			areaDao.save(ms);
		}

		watch.stop();
		System.out.println("cost:" + watch.getTotalTimeSeconds());
	}

	public static void getAreaDaoTest() throws IllegalArgumentException,
			IllegalAccessException {
		StopWatch watch = new StopWatch();
		watch.start();
		MatchingArea ms = areaDao.getByPriKey((long) 2);
		if (null == ms)
			return;
		System.out.println(ms.getAreaID());
		System.out.println(ms.getConjID1());
		System.out.println(ms.getConjID2());
		System.out.println(ms.getAirportWithArea());

		watch.stop();
		System.out.println("cost:" + watch.getTotalTimeSeconds());
	}

	public static void putStoreDaoTest() {
		int count = 10;
		StopWatch watch = new StopWatch();
		watch.start();

		while (count > 0) {
			count--;
			MatchingStore ms = new MatchingStore();
			ms.setStoreID(count);
			ms.setAreaID(count);
			ms.setFloor(1);
			ms.setName(count + "");
			ms.setAreaInAirport("BaiYunA");
			storeDao.save(ms);
		}

		watch.stop();
		System.out.println("cost:" + watch.getTotalTimeSeconds());
	}

	public static void getStoreDaoTest() {
		StopWatch watch = new StopWatch();
		watch.start();
		MatchingStore ms = storeDao.getByPriKey((long) 2);
		if (null == ms)
			return;
		System.out.println(ms.getStoreID());
		System.out.println(ms.getAreaID());
		System.out.println(ms.getName());
		System.out.println(ms.getAreaInAirport());
		System.out.println(ms.getFloor());

		watch.stop();
		System.out.println("cost:" + watch.getTotalTimeSeconds());
	}
}
