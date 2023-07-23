package Lesson_41_Homework_20_06;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileReaderWriter {
    private static final String jsonFileTest = "resources/test1.json";
    public static void readJsonFile() throws IOException, ParseException, org.json.simple.parser.ParseException {
        FileReader reader = new FileReader(jsonFileTest);
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(reader);

        JSONObject jsonObject = (JSONObject) obj;

        String name = (String) jsonObject.get("name");
        Long age = (Long) jsonObject.get("age");
        String email = (String) jsonObject.get("email");
        Boolean companyMember = (Boolean) jsonObject.get("companyMember");
        JSONArray memberArray = (JSONArray) jsonObject.get("subordinateGroup");

        List<String> members = new ArrayList<>();
        for (Object member : memberArray) {
            members.add((String) member);
        }
        System.out.println("name: " + name + "\n" +
                "age: " + age + "\n" +
                "email: " + email + "\n" +
                "companyMember: " + companyMember + "\n" +
                "subordinateGroup: " + members);
    }

    public static void writeJsonFile() throws IOException, ParseException {
        String path = "resources/test2.json";
        JSONObject obj = new JSONObject();
        obj.put("name", "Андрей Дмитриков");
        obj.put("age", 27);
        obj.put("email", "a.dmitrikov@yandex.ru");
        obj.put("companyMember", true);

        JSONArray members = new JSONArray();
        members.add("Анна Котейникова");
        members.add("Дмитрий Антошин");
        members.add("Милена Романова");

        obj.put("subordinateGroup", members);
        try {
            FileWriter writer = new FileWriter(path);
            try {
                writer.write(obj.toJSONString());
            } finally {
                writer.flush();
                writer.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(obj);
    }
}
