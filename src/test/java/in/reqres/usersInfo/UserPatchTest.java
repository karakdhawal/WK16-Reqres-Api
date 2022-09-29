package in.reqres.usersInfo;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPatchTest extends TestBase {

@Test
    public void patchUser (){
    UserPojo userPojo = new UserPojo();
    userPojo.setFirstName("Lord Patch");

    Response response = given()
            .header("Content-Type", "application/json") // get info from Postman Headers key and value
            .pathParam("id", "176")
            .body(userPojo)
            .when()
            .patch("/{id}");
    response.then().statusCode(200);
    response.prettyPrint();
}

}
