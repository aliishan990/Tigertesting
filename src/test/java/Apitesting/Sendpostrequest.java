package Apitesting;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Sendpostrequest {

    public static void main(String[] args) {

        Response response=given().auth().basic("sk_test_51PBlcqSDjJzMNVJ6uBlXAHTLorffOQf2V79zRuVR1sOXm437N057hDXURIEMucJtyMRczH7tmzR5yAm3FNz59Pee00VZVRCp4P","")
                .formParam("name","Ishan").formParam("email","ishanali@gmail.com").formParam("description","This is my request")
                .post("https://api.stripe.com/v1/customers");

        //response.prettyPrint();

        System.out.println(response.getBody().asString());
    }
}
