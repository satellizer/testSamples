package com.travelskt.test.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testDatabase {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:gbiaps/gbiaps@10.123.82.227:1521:test11g",
				"gbiaps", "gbiaps");
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("select * from M_city");
		while (rs.next()) {
			System.out.println(rs.getString("name_cn"));
		}
	}

}
