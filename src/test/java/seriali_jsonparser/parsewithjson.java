package seriali_jsonparser;



import org.json.JSONObject;


import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class parsewithjson {


@Test
    public static void requestparsing() throws IOException, ParseException, ParseException {

    JSONParser jsonParser=new JSONParser();
    FileReader reader=new FileReader("src/main/resources/Request/batch.json");
    JSONObject obj = (JSONObject) jsonParser.parse(reader);

    JSONObject internal= (JSONObject) obj.get("internal");
    JSONObject poi=(JSONObject) internal.get("poi");

    String name=(String) poi.get("estateManagementId");
    System.out.println(name);

}

}


