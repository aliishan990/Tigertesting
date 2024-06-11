package practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class trailfoue {

    public static void payload(String baseurl,String endpoint,String requestBody,int statusCode){

        RestAssured.baseURI=baseurl;

        RequestSpecification request=given().header("Content-Type","application/json");

                if(requestBody !=null){
                    request.body(requestBody);
                }
        Response response;
                if(requestBody !=null){
                   response= request.when().post(endpoint);
                } else {
                    response= request.when().get(endpoint);
                }
        response.then().statusCode(statusCode);


                if(requestBody !=null){
                    response.then().body("Firstname",equalTo("Ishan"))
                            .body("LastName",equalTo("Ali"))
                            .body("Age",equalTo("33"));

                }

        System.out.println("BaseUrl ="+baseurl+endpoint);
                if(requestBody !=null){
                    System.out.println(requestBody);
                }
        System.out.println("responseStatuscode ="+response.getStatusCode());
        System.out.println("responseBody ="+response.getBody().asString());
    }


    @Test
    public static void apiAuto(){
        String baseurl="https://reqres.in/api/users";
        String endpoint="/posts/1";
        int Statuscode=201;
        String requestbody="{\n" +
                "    \"Firstname\":\"Ishan\",\n" +
                "    \"LastName\" :\"Ali\",\n" +
                "    \"Age\":\"33\"\n" +
                "}";

        payload(baseurl,endpoint,requestbody,Statuscode);

    }
}
