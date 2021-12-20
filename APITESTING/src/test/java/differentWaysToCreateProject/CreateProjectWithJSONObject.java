package differentWaysToCreateProject;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectWithJSONObject {
@Test
public void createProject()
{
	Random r = new Random();
	int rNo = r.nextInt(1000);
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "Deepak");
	jobj.put("projectName", "TYSSjkskbbs" + rNo);
	jobj.put("status", "Started");
	jobj.put("teamSize", 40);
	
	given()
		.contentType(ContentType.JSON)
		.body(jobj)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
}
}
