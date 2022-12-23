package com.qaautomater.training;


import org.apache.http.HttpStatus;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class AuthWithJWT {

    private String requestBody = "{  \"password\": \"Dora the explorer\",  \"username\": \"QA Automater\"}";
    private String token = "";

    @Before
    public void setup() {
        // Register the user
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://jobapplicationjwt.herokuapp.com/users/sign-up")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

        //Token Generation For further use
        token = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://jobapplicationjwt.herokuapp.com/users/authenticate")
                .jsonPath()
                .get("token");

    }

    @Test
    public void testGetWithJwt() {
        //Creating the maps for Header values
        Map<String, String> headers = new HashMap<String, String>(){
            {
                put("Accept", "application/json");
                put("Authorization", "Bearer " + token);
            }
        };

        given()
                .headers(headers)
                .when()
                .get("https://jobapplicationjwt.herokuapp.com/auth/webapi/all")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testGetWithOutJwt() {
        //Creating the maps for Header values except the token
        Map<String, String> headers = new HashMap<String, String>(){
            {
                put("Accept", "application/json");
            }
        };

        given()
                .headers(headers)
                .when()
                .get("https://jobapplicationjwt.herokuapp.com/auth/webapi/all")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }
}
