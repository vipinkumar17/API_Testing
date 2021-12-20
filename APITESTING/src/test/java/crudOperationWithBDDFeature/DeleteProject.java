package crudOperationWithBDDFeature;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProject {
@Test
public void deleteProject()
{
	when()
		.delete("http://localhost:8084/projects/TY_PROJ_1404")
	.then()
		.assertThat().statusCode(204)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all();
}
}
