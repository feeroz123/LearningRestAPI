package basic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class GetRequest_Demo {
  
  @BeforeClass
  public void setup() {
	  RestAssured.baseURI = "https://maps.googleapis.com";
	  RestAssured.basePath = "/maps/api";
  }
  
  @Test (enabled = true)
  public void statusCodeVerification() {
		given()
			.param("units", "imperial")
			.param("origins", "Washington,DC")
			.param("destinations", "New+York+City,NY")
			.param("key", "")
		.when()
			.get("/distancematrix/json")
		.then()
			.statusCode(200);				// Checking if the Status code returned is 200
	}

  @Test (enabled = true)
  public void getResponse() {
	  Response res = 
		given()
			.param("units", "imperial")
			.param("origins", "Washington,DC")
			.param("destinations", "New+York+City,NY")
			.param("key", "")
		.when()
			.get("/distancematrix/json");
	  
	  System.out.println(res.getBody().asString());
	}
  
}
