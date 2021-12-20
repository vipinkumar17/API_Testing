package typesOfParameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	@Test
	public void pathParameter()
	{
		String proID ="TY_PROJ_803";
		given()
			.pathParam("projectId", proID)
		.when()
			.get("http://localhost:8084/projects/{projectId}")
		.then()
			.assertThat().statusCode(200).log().all();
	}
}
