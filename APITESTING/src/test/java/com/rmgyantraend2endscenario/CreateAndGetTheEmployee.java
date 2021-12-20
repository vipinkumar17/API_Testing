package com.rmgyantraend2endscenario;

import org.testng.annotations.Test;

import com.pojoClass.EmployeePojo;
import com.rmgyantra.genericUtitltiy.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateAndGetTheEmployee {
@Test
public void createAndGet()
{
	String empName = "Shardul" +JavaUtility.getRandomData();
	EmployeePojo empPojo = new EmployeePojo("sdet", "12/12/1990", "deepak@gmail.com", empName, 15, "9886662262", "Tyss", "ROLE_ADMIN", "deepak_gowda"+JavaUtility.getRandomData());
	given()
		.contentType(ContentType.JSON)
		.body(empPojo);
	Response r = when()
		.post("http://localhost:8084/employees");
	String empId = r.jsonPath().get("empId");
	System.out.println(empId);
		r.then()
			.assertThat().statusCode(201).log().all();
	
	
}
}
