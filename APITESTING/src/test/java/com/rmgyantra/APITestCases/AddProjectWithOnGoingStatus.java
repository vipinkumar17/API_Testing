package com.rmgyantra.APITestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pojoClass.PojoLibrary;
import com.rmgyantra.genericUtitltiy.APIBaseClass;
import com.rmgyantra.genericUtitltiy.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AddProjectWithOnGoingStatus extends APIBaseClass {
	@Test
	public void addProjectWithCompletedStatusTest() throws Throwable
	{
		String projectName = "SDET_22" + JavaUtility.getRandomData();
		String status = "On Going";
		PojoLibrary pojo = new PojoLibrary("pradeep", projectName , status, 52);

		//execute API and get the data and verify
		Response res = given()
				.contentType(ContentType.JSON)
				.body(pojo)
				.when()
				.post("http://localhost:8084/addProject");
		res.then()
		.assertThat().statusCode(201)
		.log().all();
		String apiResponseProjectName = res.jsonPath().get("projectName");
		//	  String apiStatus = res.jsonPath().get("status");

		//connect to DB and get the data

		String dbProjectName = dbLib.executeQueryAndVerifyAndGetData("Select * from project", 4, apiResponseProjectName);
		String dbStatus = dbLib.executeQueryAndVerifyAndGetData("Select * from project", 5, status );			  
		Assert.assertEquals(dbProjectName, apiResponseProjectName);
	}
}
