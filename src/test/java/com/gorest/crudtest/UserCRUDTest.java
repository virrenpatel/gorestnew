package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {
//776f75c7b8747aa50f4c8f23f1cedc266fdb3940865f1a5821385297ddf55956
    @Test
    public void verifyUserCreatedSuccessfully(){
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Manan Shah");
        userPojo.setEmail("1234test@gmail.com");
        userPojo.setGender("Male");
        userPojo.setStatus("Active");
        Response response =
                given().log().all()
                        .header("Content-Type","application/json")
                        .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                        .body(userPojo)
                        .when()
                        .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();


    }
    @Test
    public void getAllCustomersInfo() {
        Response response = given()
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void deleteUser() {
        Response response = given()

                .header("Content-Type","application/json")
                .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")

                .when()
                .delete("/users/5327");
        response.then().statusCode(204);
        response.prettyPrint();
    }


}
