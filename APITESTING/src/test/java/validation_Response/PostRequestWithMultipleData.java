package validation_Response;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pojoClass.PojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostRequestWithMultipleData {
	@Test(dataProvider = "provideData")
	public void multipleData(String createdBy, String projectName,String status, int teamSize)
	{
		PojoLibrary pl = new PojoLibrary(createdBy, projectName, status, teamSize);
		given()
		.contentType(ContentType.JSON)
		.body(pl)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}
	@DataProvider
	public Object[][] provideData()
	{
		Object[][] obj = new Object[2][4];
		obj[0][0] = "Biscuit";
		obj[0][1] = "Parle-G";
		obj[0][2] = "On going";
		obj[0][3] = 4;

		obj[1][0] = "Biscuit";
		obj[1][1] = "Parle-G11";
		obj[1][2] = "On going";
		obj[1][3] = 4;

		return obj;

	}
}
