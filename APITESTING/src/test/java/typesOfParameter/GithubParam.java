package typesOfParameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GithubParam {
	@Test
	public void git()
	{
		given()
		.pathParam("username", "vipinkumar17")
		.queryParam("sort", "created")
		.when()
		.get("https://api.github.com/users/{username}/repos")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}
