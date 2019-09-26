package basic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class ValidateResponse {

	@BeforeClass
	  public void setup() {
		  RestAssured.baseURI = "https://maps.googleapis.com";
		  RestAssured.basePath = "/maps/api";
	  }
	
	 @Test (enabled = true)
	  public void responseValidation() {
			given()
				.param("units", "imperial")
				.param("origins", "Washington,DC")
				.param("destinations", "New+York+City,NY")
				.param("key", "AIzaSyAiwRTkeB_i4vVaI2JOfzLHRggLRjUSvsM")
			.when()
				.get("/distancematrix/json")
			.then()
				.statusCode(200)			// Checking if the Status code returned is 200
				.and()
				.body("rows[0].elements[0].distance.text", equalTo("226 mi"))	// Checking if the distance text value returned matches to expected "226 mi"
				.contentType(ContentType.JSON);	   // Checking if the response type returned is in JSON format
		}
	
}
