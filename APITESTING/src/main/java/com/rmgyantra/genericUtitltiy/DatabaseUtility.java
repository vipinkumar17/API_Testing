package com.rmgyantra.genericUtitltiy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DatabaseUtility {
	 Connection con=null;
	 ResultSet result=null;
	 Driver driverRef ;

	/**
	*connection with database is established
	* Author  Vipin
	* @throws Throwable
	*/
	public void connectDB() throws Throwable {
		driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}
	public String executeQueryAndVerifyAndGetData(String query,int columnName , String expectedData ) throws Throwable
	{
		boolean flag = false;
		 result =  con.createStatement().executeQuery(query);
		 while(result.next())
		 {
			 if(result.getString(columnName).equals(expectedData))
			 {
				 flag=true;
				 break;
			 }
		 }
		 if(flag)
		 {
			 System.out.println(expectedData+"==> data is verified in the database table");
			 return expectedData;
		 }
		 else
		 {
			 System.out.println(expectedData + "==> data is verified in the database table");
			 return expectedData;
		 }
		 
	}
	/**
	* DB connection is closed
	* @ throws Throwable
	*/
	public void closeDb() throws Throwable {
	con.close();
	}
}
