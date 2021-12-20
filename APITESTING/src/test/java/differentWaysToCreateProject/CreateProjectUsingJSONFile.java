package differentWaysToCreateProject;

import java.io.File;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJSONFile {
@Test
public void createProject()
{
	
	File file = new File("./src/test/resources/CreateProject.json" );
	given()
		.contentType(ContentType.JSON)
		.body(file)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
}
}
