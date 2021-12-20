package differentWaysToCreateProject;

import org.testng.annotations.Test;

import com.pojoClass.PojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectUsingPojoClass {
@Test
public void createProject()
{
	Random r = new Random();
	int rNO = r.nextInt(1000);
	PojoLibrary pl = new PojoLibrary("Vishal", "Amazon_"+rNO, "On Going", 52);
	given()
		.contentType(ContentType.JSON)
		.body(pl)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
}
}
