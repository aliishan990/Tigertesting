package seriali_jsonparser;




import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;



public class json_withfile_retervingvalue {
    @Test
    public static void requestparsing() throws IOException, ParseException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/Request/batch.json");
        JSONObject obj = (JSONObject) jsonParser.parse(reader);

        JSONObject internal = (JSONObject) obj.get("internal");
        JSONObject poi = (JSONObject) internal.get("poi");

        String name = (String) poi.get("estateManagementId");
        System.out.println(name);

    }

    @Test
    public static void settlementparsing() throws IOException, ParseException, ParseException {

        JSONParser jsparse = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/Request/batch.json");
        JSONObject jsobj = (JSONObject) jsparse.parse(reader);
        JSONObject settlement = (JSONObject) jsobj.get("settlementData");
        //JSONObject merchant=(JSONObject)  settlement.get("merchantId");

        String mId = (String) settlement.get("merchantId");
        System.out.println(mId);

    }

    @Test
    public static void retriveele() throws IOException, ParseException {

        JSONParser jsparse = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/Request/complex.json");
        JSONObject jsobj = (JSONObject) jsparse.parse(reader);

        JSONObject company = (JSONObject) jsobj.get("company");
        JSONArray arr = (JSONArray) company.get("employees");
        /*JSONArray firstEmployee = (JSONArray) arr.get(0);
        JSONArray FN = (JSONArray) firstEmployee.get("name");*/

        //String FN=(String) firstEmployee.get("name");


        /*System.out.println("First Employee Details:");
        System.out.println("Name: " + firstEmployee.get("name"));
        System.out.println("Age: " + firstEmployee.get("age"));
        System.out.println("Department: " + firstEmployee.get("department"));
        System.out.println("Skills: " + firstEmployee.get("skills"));
        System.out.println("Address: " + firstEmployee.get("address"));*/
/*
        for (int i = 0; i < arr.size(); i++) {

            JSONObject val = (JSONObject) arr.get(1);
            int id = (int) val.get("id");
            String name = (String) val.get("name");
            int age = (int) val.get("age");

            System.out.println(id + name + age);
        }*/
    }


        @Test
        public static void retrieveEmployees1 () throws IOException, ParseException {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("src/main/resources/Request/complex.json");
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            JSONObject company = (JSONObject) jsonObject.get("company");
            //JSONArray employees;
            try {
                JSONArray employees = (JSONArray) company.get("employees");
                for (int i = 0; i < employees.size(); i++) {

                    JSONObject val = (JSONObject) employees.get(1);
                    Object id = (Object) val.get("id");
                    String name = (String) val.get("name");
                    //Integer age = (Integer) val.get("age");

                    System.out.println(id + name );
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }
