package validation_Response;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DynamicValidateResponse {
@Test
public void validateResponse()
{
	String expectedProjectName = "Jasper";
	String actualProjectName = null;
	Response resp = when()
						.get("http://localhost:8084/projects");
	List<String> list = resp.jsonPath().get("projectName");
	for (String l : list)
	{
		if(expectedProjectName.equals(l))
		{
				actualProjectName = l;
		}
	}
	
	resp.then()
	.assertThat().statusCode(200).contentType(ContentType.JSON)
	.log().all();
	//TestNG Assertion
	Assert.assertEquals(expectedProjectName, actualProjectName);
}
}
