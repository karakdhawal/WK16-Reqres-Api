package in.reqres.usersInfo;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPostTest extends TestBase {

    @Test
    public void createUser (){
        UserPojo userPojo = new UserPojo();
        userPojo.setEmail("lorduk@gmail.com");
        userPojo.setFirstName("Lord");
        userPojo.setLastName("uk");
        Response response = given()
                .header("Content-Type", "application/json") // get info from Postman Headers key and value
                .body(userPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }
}
