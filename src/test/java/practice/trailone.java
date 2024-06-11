package practice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class trailone {


    @Test
    public static void payload() throws IOException, ParseException {
        JSONParser parse = new JSONParser();
        FileReader reader;
        reader = new FileReader("src/main/resources/request/complex.json");
        JSONObject jsobj = (JSONObject) parse.parse(reader);
        JSONObject company=(JSONObject) jsobj.get("company");
        //System.out.println(company);

        JSONArray project=(JSONArray) company.get("projects");
        for(int i=0;i<project.size();i++){
          JSONObject value=(JSONObject) project.get(i);
          String name=(String)value.get("name");
          Object startdate=(Object) value.get("startDate");
          Object endDate=(Object) value.get("endDate");
          String manager=(String) value.get("manager");

            System.out.println("name = "+name);
            System.out.println("startdate = "+startdate);
            System.out.println("endDate = "+endDate);
            System.out.println("manager = "+manager);
            System.out.println("***********************************************");
        JSONArray team=(JSONArray) value.get("team");
        for(int j=0;j<team.size();j++){
            System.out.println(team.get(i));
        }

            System.out.println("*****************************************");
        JSONArray tasks=(JSONArray) value.get("tasks");
        for(int n=0;n<tasks.size();n++){
            JSONObject text=(JSONObject) tasks.get(i);
            Object id=(Object) text.get("id");
            String name1=(String) text.get("name");
            String assignedTo=(String) text.get("assignedTo");
            String priority=(String) text.get("priority");

            System.out.println("id ="+id);
            System.out.println("name1 ="+name1);
            System.out.println("assignedTo ="+assignedTo);
            System.out.println("priority ="+priority);

        }
            System.out.println("*****************************************");

        }
    }
}
