package basic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetRequest_Demo1 {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}

	@Test (enabled = false)
	public void verifyStatusCode() {
		given()
			.param("units", "imperial")
			.param("origins", "Bangalore")
			.param("destinations", "Lucknow")
			.param("key", "AIzaSyAiwRTkeB_i4vVaI2JOfzLHRggLRjUSvsM")
		.when()
			.get("/distancematrix/json")
		.then()
			.statusCode(200);
	}
	
	@Test
	public void getDistanceValue() {
		Response res = given()
				.param("units", "imperial")
				.param("origins", "Bangalore")
				.param("destinations", "Lucknow")
				.param("key", "AIzaSyAiwRTkeB_i4vVaI2JOfzLHRggLRjUSvsM")
			.when()
				.get("/distancematrix/json");
		
		System.out.println(res.prettyPrint());
		
	}
}
