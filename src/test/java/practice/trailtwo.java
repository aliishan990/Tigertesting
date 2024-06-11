package practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class trailtwo {

    public static void validateUrl(String baseUrl, String endpoint, int expectedStatusCode, String requestBody) {
        // Set the base URL
        RestAssured.baseURI = baseUrl;

        // Create the request
        RequestSpecification request = given()
                .header("Content-Type", "application/json");

        // Add request body if present
        if (requestBody != null && !requestBody.isEmpty()) {
            request.body(requestBody);
        }

        // Send the request and get the response
        Response response;
        if (requestBody != null && !requestBody.isEmpty()) {
            response = request.when().post(endpoint);
        } else {
            response = request.when().get(endpoint);
        }

        // Validate the status code
        response.then().statusCode(expectedStatusCode);

        // Validate the response body
        if (requestBody != null && !requestBody.isEmpty()) {
            response.then()
                    .body("name", equalTo("morpheus"))
                    .body("job", equalTo("leader"))
                    .body("id", notNullValue())
                    .body("createdAt", notNullValue());
        }

        // Print request and response details for debugging
        System.out.println("Request URL: " + baseUrl + endpoint);
        if (requestBody != null && !requestBody.isEmpty()) {
            System.out.println("Request Body: " + requestBody);
        }
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @Test
    public void genericPayloadGetRequest() {
        String baseUrl = "https://reqres.in/api";
        String endpoint = "/users/2";
        int expectedStatusCode = 200;
        String requestBody = null; // GET request, so no request body

        validateUrl(baseUrl, endpoint, expectedStatusCode, requestBody);
    }

    @Test
    public void genericPayloadPostRequest() {
        String baseUrl = "https://reqres.in/api";
        String endpoint = "/users";
        int expectedStatusCode = 201;
        String requestBody = "{\n" +
                "  \"name\": \"morpheus\",\n" +
                "  \"job\": \"leader\"\n" +
                "}";

        validateUrl(baseUrl, endpoint, expectedStatusCode, requestBody);
    }
}