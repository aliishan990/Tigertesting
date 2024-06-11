package closebatch;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class batchone {

    @Test
    public static void launch(){

        JSONObject jsobj=new JSONObject();
        jsobj.put("name","test");
        jsobj.put("salary","123");
        jsobj.put("age","23");

        Response result=given().body(jsobj.toString()).when().post("https://dummy.restapiexample.com/api/v1/create").then().extract().response();
        String response= result.getBody().asString();
        System.out.println(response);
        //System.out.println("Response body: " + result.getBody().asString());
        JsonPath jsnPath = result.jsonPath();
        String std=jsnPath.get("status");
        System.out.println(std);
    }

    @Test
    public static void require(){

        Response res=given().header("Content-Type","application/json").body("{\n" +
                "    \"title\": \"I am in love with someone.\",\n" +
                "    \"userId\": \"5\",\n" +
                "    \"name\":\"ishan\"\n" +
                "    }").when().post("https://dummyjson.com/posts/add");

        res.prettyPrint();
        System.out.println("title ="+res.jsonPath().get("title").toString());
    }
}
