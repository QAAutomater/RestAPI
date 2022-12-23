package com.qaautomater.training;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Demo5_DELETE {

    public static void main(String[] args) {
        //RestAssured DELETE call demo
        System.out.println("============================RestAssured DELETE call demo==============================");
        deleteExample();
        System.out.println("============================RestAssured DELETE call demo==============================");
    }

    public static void deleteExample() {

        RestAssured.baseURI = "https://reqres.in/api";

        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .delete("/users/2");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(response.getStatusCode());
    }
}