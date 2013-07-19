package com.travelsky.bdb;

import java.util.ResourceBundle;

public class DmpConstants {
	private static ResourceBundle bundle = ResourceBundle.getBundle("config");

	public static final String BDB_ENV_HOME = bundle.getString("bdb_env_home");

}
