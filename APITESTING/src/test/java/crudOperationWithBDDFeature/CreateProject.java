package crudOperationWithBDDFeature;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProject {
@Test
public void createProject()
{
	Random r = new Random();
	int rNo = r.nextInt(1000);
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "Deepak");
	jObj.put("projectName", "TYSSjkskbbs" + rNo);
	jObj.put("status", "Started");
	jObj.put("teamSize", 40);
	
	given()
		.contentType(ContentType.JSON)
		.body(jObj)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
	
}
}
