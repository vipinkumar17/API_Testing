package requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;



public class GetDeleteChaining {
	@Test
	public void requestTest() {
		Response resp = when()
				.get("http://localhost:8084/projects");
		String proId =  resp.jsonPath().get("[1].projectId");
		given()
		.pathParam("projectId", proId)
		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}
}
