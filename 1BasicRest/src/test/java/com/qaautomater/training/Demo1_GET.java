package com.qaautomater.training;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class Demo1_GET {
    public static void main(String[] args) {
        //Basic Get demo
        System.out.println("============================Basic Get demo==============================");
        getExample();
        System.out.println("============================Basic Get demo==============================");

        System.out.println();

        //Get with Query Parameter demo
        System.out.println("============================Get with Query Parameter demo==============================");
        getQueryParamExample();
        System.out.println("============================Get with Query Parameter demo==============================");

        System.out.println();

        //Get with Path Parameter Demo
        System.out.println("============================Get with Path Parameter Demo==============================");
        getPathParamExample();
        System.out.println("============================Get with Path Parameter Demo==============================");
    }

    public static void getExample() {
        RestAssured.baseURI = "https://reqres.in/api";
        Response response = null;
        try {
            response = RestAssured.given()
                    .when()
                    .get("/users/2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Response :" + response.asString());
        System.out.println(response.getStatusCode());
        //"janet.weaver@reqres.in"
        System.out.println(response.jsonPath().getString("data.email"));
        System.out.println(response.jsonPath().getString("data.first_name"));
    }

    public static void getQueryParamExample() {

        RestAssured.baseURI = "https://reqres.in/api";

        Response response = null;

        try {
            response = RestAssured.given()
                    .when().queryParam("page", 2)
                    .get("/users");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());

        System.out.println(response.getStatusCode());
        System.out.println(response.jsonPath().getString("data[1].first_name"));
    }

    public static void getPathParamExample() {

        String id = "3";

        RestAssured.baseURI = "https://reqres.in/api/users";

        Response response = null;

        try {
            response = RestAssured.given()
                    .pathParam("id", id)
                    .when()
                    .get("/{id}");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.jsonPath().getString("data.last_name"));
    }
}
