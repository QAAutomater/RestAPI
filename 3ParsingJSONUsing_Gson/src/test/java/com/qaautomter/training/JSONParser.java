package com.qaautomter.training;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JSONParser {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        String jsonData = jsonParser.readJsonFile("C:/Users/QAAut/IdeaProjects/RestAPI/ParsingJSONUsing_orgjson/src/test/resources/SampleJSON.json");

        System.out.println("JSON Data : " + jsonData);

        System.out.println("\n***********************************************************************************************************************\n");

        JsonObject jsonObject = new JsonParser().parse(jsonData).getAsJsonObject();

        String pageName = jsonObject.getAsJsonObject("pageInfo").get("pageName").getAsString();
        System.out.println(pageName);

        JsonArray arr = jsonObject.getAsJsonArray("posts");
        for (int i = 0; i < arr.size(); i++) {
            String post_id = arr.get(i).getAsJsonObject().get("post_id").getAsString();
            System.out.println("post_id : " + post_id);
        }
    }

    private String readJsonFile(String sFilePath){
        String jsonData = "";
        try {
            FileInputStream fis = new FileInputStream(sFilePath);
            //FileInputStream fis = new FileInputStream(String.valueOf(JSONParser.class.getClassLoader().getResource("SampleJSON.json")));
            Scanner scan = new Scanner(fis);

            while(scan.hasNext()){
                jsonData += scan.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("readJsonFile : File Not Found Exception");
            e.printStackTrace();
        }finally {
            return jsonData;
        }
    }
}
