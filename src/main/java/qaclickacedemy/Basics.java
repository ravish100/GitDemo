package qaclickacedemy;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;

public class Basics {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("hello");
		//validate if add place api works as expected
		//Given:all input details
		//when:submit the api there..resource,http method
		//then:validate the response
		
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("Key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"ravish116 Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29r, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}").when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server",("Apache/2.4.41 (Ubuntu)"));
		
	}

}
