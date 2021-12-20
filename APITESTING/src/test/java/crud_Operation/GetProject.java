package crud_Operation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetProject {
	@Test
	public void getProjectTest()
	{
		Response resp = RestAssured.get("http://localhost:8084/projects");
		ValidatableResponse valirespo = resp.then();
		valirespo.assertThat().statusCode(200);
		valirespo.assertThat().contentType(ContentType.JSON);
		valirespo.log().all();
	}
}
