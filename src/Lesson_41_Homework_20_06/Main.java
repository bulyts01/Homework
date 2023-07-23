package Lesson_41_Homework_20_06;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JsonFileReaderWriter.readJsonFile();
        JsonFileReaderWriter.writeJsonFile();


        /* code by Lesson 20.06
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader("resources/test.json");
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            String name = (String) jsonObject.get("name");
            Long age = (Long) jsonObject.get("age");
            String email = (String) jsonObject.get("email");
            Boolean isPremium = (Boolean) jsonObject.get("isPremium");
            JSONArray friendsArray = (JSONArray) jsonObject.get("friends");
            List<String> friends = new ArrayList<>();
            for (Object friend : friendsArray) {
                friends.add((String) friend);
            }
            System.out.println("name: " + name);
            System.out.println("age: " + age);
            System.out.println("email: " + email);
            System.out.println("isPremium: " + isPremium);
            System.out.println("friends: " + friends);
        } catch (IOException |ParseException ex) {
            ex.printStackTrace();
        }*/

    }

}
