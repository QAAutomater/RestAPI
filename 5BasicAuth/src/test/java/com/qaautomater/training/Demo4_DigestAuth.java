package com.qaautomater.training;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo4_DigestAuth {
    public static void main(String[] args) {
        System.out.println("*********************************************************************************************************************");
        getData();
        System.out.println("*********************************************************************************************************************");
    }

    public static void getData() {
        RequestSpecification httpRequest = RestAssured.given().auth().digest("postman", "password");
        Response res = httpRequest.get("https://postman-echo.com/basic-auth");

        System.out.println("Data from the GET API- " + res.body().asString());
    }
}
