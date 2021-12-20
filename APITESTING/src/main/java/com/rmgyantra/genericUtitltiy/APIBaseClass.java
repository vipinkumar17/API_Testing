package com.rmgyantra.genericUtitltiy;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class APIBaseClass {
	public DatabaseUtility dbLib = new DatabaseUtility();
	public JavaUtility jLib = new JavaUtility();
@BeforeSuite
public void configBeforeSuite() throws Throwable
{
	
	dbLib.connectDB();
}
@AfterSuite
public void configAfterSuite() throws Throwable
{
	dbLib.closeDb();
}
}