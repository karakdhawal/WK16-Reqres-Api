package in.reqres.usersInfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserGetTest extends TestBase {

    @Test
    public void getAllUsersList (){
        Response response = given()
                .when()
                .get("?page=2");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getSingleUser (){
        Response response = given()
                .pathParam("id", "7")
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void delSingleUserVerify (){
        Response response = given()
                .pathParam("id", "591")
                .when()
                .get("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();
    }
}
