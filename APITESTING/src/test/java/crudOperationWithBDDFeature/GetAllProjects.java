package crudOperationWithBDDFeature;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllProjects {
	@Test
	public void getProject()
	{
		when()
			.get("http://localhost:8084/projects")
		.then()
			.assertThat().statusCode(200)
			.assertThat().contentType(ContentType.JSON)
			.assertThat().log().all();
	}
}
