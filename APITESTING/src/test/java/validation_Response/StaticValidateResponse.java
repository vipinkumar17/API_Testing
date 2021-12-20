package validation_Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.protocol.x.XAuthenticationProvider;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticValidateResponse {
	@Test
	public void validateResponse()
	{
		String expectedProjectName = "Jasper";
		Response resp = when()
				.get("http://localhost:8084/projects");
		String actualProjectName = resp.jsonPath().get("[0].projectName")	;
		resp.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();
		//TestNG Assertion
		Assert.assertEquals(expectedProjectName,actualProjectName );

	}
}
