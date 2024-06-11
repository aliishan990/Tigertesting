package closebatch;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class createbatch {

    @Test
    public static void sampleapi(){

        JSONObject payload=new JSONObject();
        payload.put("name","ishan");
        payload.put("surname","ali");
        payload.put("age","34");
        payload.put("occupation","engg");
        payload.put("Address","bangalore");

        Response result=given().header("Content-Type","application/json").body(payload).when().post("https://reqres.in/api/users");

        result.prettyPrint();

        String name=result.jsonPath().get("Address").toString();
        System.out.println(name);
        Assert.assertEquals("bangalore",name);
    }
}
