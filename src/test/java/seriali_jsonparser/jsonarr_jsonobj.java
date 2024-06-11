package seriali_jsonparser;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class jsonarr_jsonobj {

    @Test
    public static void getvalues() throws IOException, ParseException {

        JSONParser jparse=new JSONParser();
        FileReader reader=new FileReader("src/main/resources/request/complex.json");
        JSONObject obj=(JSONObject) jparse.parse(reader);

        JSONObject company=(JSONObject) obj.get("company");


        JSONArray emp=(JSONArray) company.get("employees");
        JSONObject firstEmployee = (JSONObject) emp.get(0);
        System.out.println("First Employee Details:");
        System.out.println("ID: " + firstEmployee.get("id"));
        System.out.println("Name: " + firstEmployee.get("name"));

    }


    @Test
    public static void skilset() throws IOException, ParseException {

        JSONParser parse=new JSONParser();
        FileReader reader=new FileReader("src/main/resources/request/complex.json");
        JSONObject jsobj=(JSONObject) parse.parse(reader);

        JSONObject company=(JSONObject) jsobj.get("company");
        JSONArray emp=(JSONArray)company.get("employees");
        JSONObject skill = (JSONObject) emp.get(0);
        JSONArray skset=(JSONArray)skill.get("skills");
        System.out.println("language = " + skset.get(0));
    }


    @Test
    public static void address() throws IOException, ParseException {

        JSONParser parse=new JSONParser();
        FileReader reader=new FileReader("src/main/resources/request/complex.json");
        JSONObject jsobj=(JSONObject) parse.parse(reader);

        JSONObject company=(JSONObject) jsobj.get("company");
        JSONArray emp=(JSONArray)company.get("employees");
        JSONObject addloc=(JSONObject) emp.get(1);
        JSONObject location=(JSONObject) addloc.get("address");
        System.out.println("City name ="+ location.get("city"));

    }

    @Test
    public static void content() throws IOException, ParseException {

        JSONParser parser=new JSONParser();
        FileReader reader=new FileReader("src/main/resources/request/complex.json");
        JSONObject objcamp=(JSONObject) parser.parse(reader);
        System.out.println(objcamp.get("company"));

    }

    @Test
    public static void project() throws IOException, ParseException {

        JSONParser parse=new JSONParser();
        FileReader reader=new FileReader("src/main/resources/request/complex.json");
        JSONObject objpair=(JSONObject) parse.parse(reader);

        JSONObject company=(JSONObject) objpair.get("company");
        JSONArray team1=(JSONArray) company.get("projects");
        JSONObject same=(JSONObject) team1.get(0);
        JSONArray value=(JSONArray) same.get("team");
        System.out.println(value.get(1));
    }

    @Test
    public static void task() throws IOException, ParseException {
        JSONParser parse=new JSONParser();
        FileReader reader=new FileReader("src/main/resources/request/complex.json");
        JSONObject objsec=(JSONObject) parse.parse(reader);

        JSONObject company=(JSONObject) objsec.get("company");
        JSONArray project=(JSONArray) company.get("projects");
        JSONObject zero=(JSONObject) project.get(0);
        JSONArray task=(JSONArray) zero.get("tasks");
        JSONObject one=(JSONObject) task.get(1);
        System.out.println( "name = "+ one.get("name"));
    }


    @Test
    public static void priority() throws IOException, ParseException {

        JSONParser parse=new JSONParser();
        FileReader reader=new FileReader("src/main/resources/request/complex.json");
        JSONObject jobj=(JSONObject) parse.parse(reader);

        JSONObject company=(JSONObject) jobj.get("company");
        JSONArray project=(JSONArray) company.get("projects");
        JSONObject one=(JSONObject) project.get(1);
        JSONArray task=(JSONArray) one.get("tasks");
        JSONObject neo=(JSONObject) task.get(1);
        System.out.println("assignedTo = "+neo.get("assignedTo"));
    }
}
