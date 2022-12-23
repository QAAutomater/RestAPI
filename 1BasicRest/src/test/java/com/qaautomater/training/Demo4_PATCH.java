package com.qaautomater.training;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Demo4_PATCH {

    public static void main(String[] args) {
        //RestAssured PATCH call demo
        System.out.println("============================RestAssured PATCH call demo==============================");
        patchExample();
        System.out.println("============================RestAssured PATCH call demo==============================");
    }

    public static void patchExample() {

        RestAssured.baseURI = "https://reqres.in/api";

        String requestBody = "{\n"
                + "    \"name\": \"Isha\"\n"
                + "}";

        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .patch("/users/2");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());

        System.out.println(response.getStatusCode());
        System.out.println(response.jsonPath().getString("name"));
    }
}
