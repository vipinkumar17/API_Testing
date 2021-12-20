package crudOperationWithBDDFeature;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
@Test
public void updateProject()
{
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "Deepak Sir");
	jObj.put("projectName", "TYSS 01_");
	jObj.put("status", "Completed");
	jObj.put("teamSize", 44);
	
	given()
		.contentType(ContentType.JSON)
		.body(jObj)
	.when()
		.put("http://localhost:8084/projects/TY_PROJ_602")
	.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();
}
}
