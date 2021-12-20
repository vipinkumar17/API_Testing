package typesOfParameter;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameter {
@Test
public void formParameterTest()
{
	given()
		.contentType(ContentType.JSON)
		.formParam("createdBy", "RMG")
		.formParam("projectName", "Reqres")
		.formParam("status", "Started")
		.formParam("teamSize", 57)
	.when()
		.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(500)
			.log().all();
}
}
