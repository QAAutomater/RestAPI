package com.qaautomater.training;

/**
 * PUT Request
 * @author Deepak Verma
 */
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Demo3_PUT {

    public static void main(String[] args) {
        //RestAssured PUT call demo
        System.out.println("============================RestAssured PUT call demo==============================");
        putExample();
        System.out.println("============================RestAssured PUT call demo==============================");
    }

    public static void putExample() {

        RestAssured.baseURI = "https://reqres.in/api";

        String requestBody = "{\n"
                + "    \"name\": \"Adam\",\n"
                + "    \"job\": \"Software Engineer\"\n"
                + "}";


        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .put("/users/2");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());

        System.out.println(response.getStatusCode());
        System.out.println(response.jsonPath().getString("job"));
    }
}
