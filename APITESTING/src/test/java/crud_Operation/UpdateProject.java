package crud_Operation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
@Test
public void updateProject()
{
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "Deepak");
	jObj.put("projectName", "TYSS_");
	jObj.put("status", "On Going");
	jObj.put("teamSize", 40);
	RequestSpecification reqSpec = RestAssured.given();
	reqSpec.contentType(ContentType.JSON);
	reqSpec.body(jObj);
	
	Response resp = reqSpec.put("http://localhost:8084/projects/TY_PROJ_1608");
	ValidatableResponse valiresp = resp.then();
	valiresp.statusCode(200);
	valiresp.contentType(ContentType.JSON);
	valiresp.log().all();
	
}
}
