package in.co.gorest.userinfo;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import in.co.gorest.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser extends TestBase {
    static String name = "Kapil";
    static String email = TestUtils.getRandomValue() + "kapilPatel@.gmail.com";
    static String gender = "Male";
    static String status = "active";

    @Test
    public void createUser(){
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);

        Response response = given().log().all()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer 99bebebc3e4183aca9ee084b6651172497154c8e9041c12f166d99c58438929e")
                .when()
                .body(userPojo)
                .post();
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
