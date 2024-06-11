package Interview;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class reterivevalue {

    @Test
    public static void valur_table() throws ParseException, IOException {

        JSONParser js = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/request/complex.json");
        JSONObject jb = (JSONObject) js.parse(reader);
        JSONObject company = (JSONObject) jb.get("company");

        JSONArray emp1 = (JSONArray) company.get("employees");
        for (int i = 0; i < emp1.size(); i++) {
            JSONObject val = (JSONObject) emp1.get(i);
            Object id = (Object) val.get("id");
            String name = (String) val.get("name");
            Object age = (Object) val.get("age");
            String department = (String) val.get("department");

            System.out.print(id + name + age + department);
        }
    }


    @Test
    public static void jsonformater() throws IOException, ParseException {
        JSONParser parse = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/request/complex.json");
        JSONObject obj = (JSONObject) parse.parse(reader);
        JSONObject company = (JSONObject) obj.get("company");

        JSONArray emp1 = (JSONArray) company.get("employees");
        JSONObject all = new JSONObject();

        for (int i = 0; i < emp1.size(); i++) {
            JSONObject value = (JSONObject) emp1.get(i);
            all.put("id", value.get("id"));
            all.put("name", value.get("name"));
            all.put("age", value.get("age"));
            all.put("department", value.get("department"));

            System.out.println(all.toJSONString());
        }
    }

    @Test
    public static void arrayinaarray() throws IOException, ParseException {
        JSONParser parse = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/request/complex.json");
        JSONObject obj = (JSONObject) parse.parse(reader);
        JSONObject company = (JSONObject) obj.get("company");

        JSONArray emp3 = (JSONArray) company.get("employees");
        for (int i = 0; i < emp3.size(); i++) {
            JSONObject value = (JSONObject) emp3.get(i);
            Object id = (Object) value.get("id");
            String name = (String) value.get("name");
            Object age = (Object) value.get("age");
            String department = (String) value.get("department");

            System.out.println(id + name + age + department);

            System.out.println("SKILL");

            JSONArray skillsArray = (JSONArray) value.get("skills");
            for (int j = 0; j < skillsArray.size(); j++) {
                try {
                    //JSONObject skill = (JSONObject) skillsArray.get(j);
                    System.out.println(skillsArray.get(j));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Address");

            JSONObject address = (JSONObject) value.get("address");
            Object street = (Object) address.get("street");
            String city = (String) address.get("city");
            String state = (String) address.get("state");
            Object zip = (Object) address.get("zipcode");

            System.out.println(street + city + state + zip);


            System.out.println();
        }
    }

    @Test
    public static void addvalue() throws IOException, ParseException {
        JSONObject js = new JSONObject();
        JSONParser parse = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/request/complex.json");
        JSONObject obj = (JSONObject) parse.parse(reader);

        JSONObject company = (JSONObject) obj.get("company");
        company.put("name", "OperaCorporation ");

        JSONArray employees = (JSONArray) company.get("employees");
        //JSONObject alter=new JSONObject();
        for (int i = 0; i < employees.size(); i++) {
            JSONObject value = (JSONObject) employees.get(i);
            if (i == 0) {
                value.put("id", "001");
                value.put("name", "Ishan");
                value.put("age", "35");
                value.put("department", "CIVIL");
                //continue;
            }
            JSONArray skills = (JSONArray) value.get("skills");
            skills.clear();
            if (i == 0) {
                skills.add("C++");
                skills.add(".NET");
                skills.add("PHP");
            } else if (i == 1) {
                skills.add("JavaScript");
                skills.add("React");
                skills.add("Node.js");
            }
        }
        System.out.println(obj.toJSONString());
    }
}

