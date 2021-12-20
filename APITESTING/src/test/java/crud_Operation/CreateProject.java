package crud_Operation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
@Test
public void creatProject()
{
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "Deepak");
	jObj.put("projectName", "TYSS_012");
	jObj.put("status", "Started");
	jObj.put("teamSize", 40);
	RequestSpecification reqSpec = RestAssured.given();
	reqSpec.contentType(ContentType.JSON);
	reqSpec.body(jObj);
	
	Response resp = reqSpec.post("http://localhost:8084/addProject");
	ValidatableResponse valiresp = resp.then();
	valiresp.statusCode(201);
	valiresp.contentType(ContentType.JSON);
	valiresp.log().all();
}
}
