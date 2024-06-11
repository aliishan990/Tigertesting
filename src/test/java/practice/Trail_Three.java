package practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Trail_Three {


    public static void payload(String baseurl,String endpoint,int status,String requestBody){

        RestAssured.baseURI=baseurl;

        RequestSpecification request=given().header("content-type","application/json");

        if(requestBody != null){
            request.body(requestBody);
        }


        if(requestBody != null){
            request.when().post(endpoint);
        }
        Response response= (Response) request.then().statusCode(status);
    }

}
