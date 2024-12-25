package in.co.gorest.userinfo;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import in.co.gorest.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PatchUser extends TestBase {

    static String name = "user5";
    static String email = TestUtils.getRandomValue() + "prashant.gmail.com";
    static String gender = "female";
    static String status = "active";
    @Test
    public void verifyThatUsersUpdateSuccessfully(){

        int storeID = 7599479;
        String bearerTokon = "99bebebc3e4183aca9ee084b6651172497154c8e9041c12f166d99c58438929e";
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);

        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("id", storeID)
                .header("Authorization",bearerTokon)
                .header("Content-Type","application/json")
                .header("connection","keep-alive")
                .when()
                .body(userPojo)
                .put("/users/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
