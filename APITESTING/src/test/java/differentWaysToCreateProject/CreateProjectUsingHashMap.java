package differentWaysToCreateProject;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashMap {
@Test
public void createProject()
{
	Random r = new Random();
	int rNo = r.nextInt(1000);
	
	HashMap map = new HashMap();
	map.put("createdBy", "Deepak");
	map.put("projectName", "TYSSjkskbbs" + rNo);
	map.put("status", "Started");
	map.put("teamSize", 40);
	
	given()
		.contentType(ContentType.JSON)
		.body(map)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
}
}
