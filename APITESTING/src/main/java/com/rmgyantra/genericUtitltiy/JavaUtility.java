package com.rmgyantra.genericUtitltiy;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/*
	 * author @vipin
	 */
	/**
	 * This method is used to genrate random number to avoid duplication
	 * @return
	 */
	public static String getRandomData()
	{
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ""+ran;
	}
	/**
	 * @vipin
	 * this method is used to generate current date
	 * @return
	 */
	public static String getCurrentDate()
	{

		Date d = new Date();
		String currentDate = d.toString();
		return currentDate;
	}
	public static String getSystemDate() {
		Date d = new Date();
		String curentDate = d.toString().replace(" ", "_").replace(":", "_");
		return curentDate;
	}
	
}