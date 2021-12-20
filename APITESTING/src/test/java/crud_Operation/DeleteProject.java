package crud_Operation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProject {
@Test
public void deleteProject()
{
	Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1005");
	ValidatableResponse valiresp = resp.then();
	valiresp.statusCode(204);
	valiresp.contentType(ContentType.JSON);
	valiresp.log().all();
	
}
}
