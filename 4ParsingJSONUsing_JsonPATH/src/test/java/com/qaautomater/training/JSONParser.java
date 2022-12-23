package com.qaautomater.training;

import com.jayway.jsonpath.JsonPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JSONParser {

    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        String jsonData = jsonParser.readJsonFile("C:/Users/QAAut/IdeaProjects/RestAPI/ParsingJSONUsing_orgjson/src/test/resources/SampleJSON.json");

        System.out.println("JSON Data : " + jsonData);

        System.out.println("\n***********************************************************************************************************************\n");

        String pageName = JsonPath.read(jsonData, "$.pageInfo.pageName");
        System.out.println(pageName);

        Integer posts = JsonPath.read(jsonData, "$.posts.length()");

        for(int i=0; i < posts; i++) {
            String post_id = JsonPath.read(jsonData, "$.posts[" + i + "].post_id");
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
