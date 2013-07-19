package com.test;

import java.io.File;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Enumeration;
import java.util.Scanner;

import org.apache.commons.lang3.time.StopWatch;

class dup {
	Integer a;
	Integer b;
	Integer c;
	String d;
	Long e;
	Float f;
	Double g;
	Byte h;
}

public class draw {

	Integer a;
	Integer b;
	Integer c;
	String d;
	Long e;
	Float f;
	Double g;
	Byte h;

	public draw() {

	}

	public static String getPojoLog(draw pojo) {

		Class c = pojo.getClass();
		StringBuffer out = new StringBuffer(c.getName() + ":   \n");
		for (Field field : c.getDeclaredFields()) {
			String name = field.getName();

			try {
				Object vo = field.get(pojo);
				String value = "";
				if (vo != null) {
					value = field.get(pojo).toString();
				}
				out.append("         " + name + "   =   " + value + "\n");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return out.toString();
	}

	public static void main(String[] args) throws Exception {

		draw dr = new draw();
		dr.a = 1;
		dr.b = 2;
		dr.c = 3;
		dr.d = "dr.d";
		dr.e = 987L;
		dr.f = 789F;
		dr.g = 879D;
		dr.h = 121;
		// System.out.println(getPojoLog(dr));
		// dup p = new dup();
		//
		// for (Field f : dr.getClass().getDeclaredFields()) {
		//
		// String name = f.getName();
		// Field pf = p.getClass().getDeclaredField(name);
		//
		// pf.set(p, f.get(dr));
		// }
		// for (Field f : p.getClass().getDeclaredFields()) {
		// System.out.println(f.get(p));
		// }
		Bdb_TFlightDynamic retVal = new Bdb_TFlightDynamic(11L, "cz", "cz",
				"pek", "北京", "PEKING", "GZ", "广州", "GuangZHou", "a320",
				new Date(), new Date(), new Date(), "cn", "en", "builging", 0L,
				0L, "a2", "4", new Date(), "54", "5", "1", "cz", "cz", 1L, 1L,
				new Date());
		TFlightDynamic tmp = new TFlightDynamic();

		for (Field f : retVal.getClass().getDeclaredFields()) {

			try {
				String name = f.getName();

				Method getMethod = retVal.getClass().getMethod(
						"get" + name.substring(0, 1).toUpperCase()
								+ name.substring(1));
				System.out.println(getMethod.getName() + " : "
						+ getMethod.invoke(retVal));

				Method setMethod = tmp.getClass().getMethod(
						"set" + name.substring(0, 1).toUpperCase()
								+ name.substring(1), getMethod.getReturnType());

				setMethod.invoke(tmp, getMethod.invoke(retVal));
			} catch (Exception e) {

			}

		}
		for (Field f : tmp.getClass().getDeclaredFields()) {
			String name = f.getName();
			Method getMethod = tmp.getClass().getMethod(
					"get" + name.substring(0, 1).toUpperCase()
							+ name.substring(1));
			System.out.println(getMethod.getName() + " : "
					+ getMethod.invoke(tmp));
		}
	}
}
