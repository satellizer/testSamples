package com.travelsky.bdb;

import java.io.File;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentStats;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.StoreConfig;

@Service("bdbenv")
public class BdbEnv {

	private Environment myEnv;
	private EntityStore store;

	// Our constructor does nothing
	public BdbEnv() {
	}

	@PostConstruct
	public void setup() {

		try {
			EnvironmentConfig myEnvConfig = new EnvironmentConfig();
			StoreConfig storeConfig = new StoreConfig();

			myEnvConfig.setReadOnly(false);
			storeConfig.setReadOnly(false);

			// If the environment is opened for write, then we want to be
			// able to create the environment and entity store if
			// they do not exist.
			myEnvConfig.setAllowCreate(true);
			storeConfig.setAllowCreate(true);

			myEnvConfig.setSharedCache(true);

			// Just for test
			System.out.println(myEnvConfig.getCachePercent());
			// myEnvConfig.setTransactional(true);
			// myEnvConfig.setCachePercent(50);

			// Open the environment and entity store
			myEnv = new Environment(new File(DmpConstants.BDB_ENV_HOME),
					myEnvConfig);
			store = new EntityStore(myEnv, "EntityStore", storeConfig);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

	}

	// Return a handle to the entity store
	public EntityStore getEntityStore() {
		return store;
	}

	// Return a handle to the environment
	public Environment getEnv() {
		return myEnv;
	}

	public EnvironmentStats getStatus() {
		return myEnv.getStats(null);
	}

	// Close the store and environment.
	public void close() {
		if (store != null) {
			try {
				store.close();
			} catch (DatabaseException dbe) {
				System.err.println("Error closing store: " + dbe.toString());
				System.exit(-1);
			}
		}

		if (myEnv != null) {
			try {
				myEnv.cleanLog();
				// Finally, close the environment.
				myEnv.close();
			} catch (DatabaseException dbe) {
				System.err.println("Error closing MyDbEnv: " + dbe.toString());
				System.exit(-1);
			}
		}
	}
}