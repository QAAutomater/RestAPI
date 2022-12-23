package com.qaautomater.training;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class Demo2_POST {

    public static void main(String[] args) {
        //RestAssured POST call demo
        System.out.println("============================RestAssured POST call demo==============================");
        postExample();
        System.out.println("============================RestAssured POST call demo==============================");
    }

    public static void postExample() {

        RestAssured.baseURI = "https://reqres.in/api";

        String requestBody = "{\n"
                + "    \"name\": \"Sam\",\n"
                + "    \"job\": \"Project Leader\"\n"
                + "}";

        JSONObject obj = new JSONObject(requestBody);

        obj.put("name", "Mowgli");

        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(obj.toString())
                    .post("/users");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());

        System.out.println(response.getStatusCode());
        System.out.println(response.jsonPath().getString("name"));
        System.out.println(response.jsonPath().getString("job"));
    }
}