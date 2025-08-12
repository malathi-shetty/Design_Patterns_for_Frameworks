package Behavioral_DesignPatterns_4_ChainOfResponsibilityPattern;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiPayloadValidator {
	  public static void main(String[] args) {
	        String title = "foo";
	        String body = "bar";
	        int userId = 1;

	        // Validation chain
	        Validator chain = new NotEmptyValidator()
	                .linkWith(new MinLengthValidator(3));

	        if (chain.check(title) && chain.check(body)) {
	            Response res = RestAssured
	                    .given()
	                    .header("Content-type", "application/json")
	                    .body("{\"title\":\"" + title + "\",\"body\":\"" + body + "\",\"userId\":" + userId + "}")
	                    .post("https://jsonplaceholder.typicode.com/posts");

	            System.out.println("Response: " + res.statusCode());
	            System.out.println(res.prettyPrint());
	        } else {
	            System.out.println("Payload validation failed");
	        }
	    }

}
