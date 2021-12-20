package requestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class PostDeleteChaining {
@Test
public void postDeleteTest()
{
	JSONObject jobj = new JSONObject();
			jobj.put("createdBy", "Gkjdkd");
			jobj.put("projectName", "Okla");
			jobj.put("status", "Started");
			jobj.put("teamSize", 58);
	given()
		.contentType(ContentType.JSON)
		.body(jobj);
	Response resp = when()
		.post("http://localhost:8084/addProject");
	resp.then()
		.assertThat().statusCode(201).log().all();
		
	//resp.jsonPath().get("")
	}
}

