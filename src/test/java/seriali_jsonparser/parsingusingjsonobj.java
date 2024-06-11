package seriali_jsonparser;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class parsingusingjsonobj {

    @Test
    public static void dataTable() throws IOException, ParseException {

        JSONParser parse=new JSONParser();
        FileReader reader=new FileReader("src/main/resources/request/examp.json");
        JSONObject jsobj=(JSONObject) parse.parse(reader);

        jsobj.put("name","Sara");
        jsobj.put("age","3");

        try (FileWriter file = new FileWriter("src/main/resources/request/examp.json")) {
            file.write(jsobj.toJSONString());
            System.out.println("JSON file updated successfully!");
        } catch ( Exception  e) {
           e.printStackTrace();
       }

        System.out.println(jsobj);

    }


    @Test
    public static void payload_data() throws IOException, ParseException {

        JSONParser parse=new JSONParser();
        FileReader reader=new FileReader("src/main/resources/request/examp.json");
        JSONObject jobj=(JSONObject) parse.parse(reader);
        jobj.put("name","Alfiya");
        jobj.put("Address","Pune");

        Response rsult=given().header("Content-Type","application/json").body(jobj).when().post("https://reqres.in/api/users");

        rsult.prettyPrint();
        System.out.println(rsult.jsonPath().get("Address").toString());
    }
}
