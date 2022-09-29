package in.reqres.usersInfo;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {

@Test // list
    public void test001 (){
    Response response = given()
            .when()
            .get("?page=2");
    response.then().statusCode(200);
    response.prettyPrint();
   }
   @Test // get signle user
    public void test002 (){
    Response response = given()
            .pathParam("id", "8")
            .when()
            .get("/{id}");
    response.then().statusCode(200);
   }
   @Test // create user
    public void test003 (){

       UserPojo userPojo = new UserPojo();
       userPojo.setEmail("lorduk@gmail.com");
       userPojo.setFirstName("Lord");
       userPojo.setLastName("uk");

    Response response = given()
            .header("Content-Type", "application/json")
            .body(userPojo)
            .when()
            .post();
    response.then().statusCode(201);
    response.prettyPrint();
   }
    @Test // delete
    public void test004 (){
    Response response = given()
            .pathParam("id", "614")
            .when()
            .delete("/{id}");
    response.then().statusCode(204);
    response.prettyPrint();
    }
@Test //
    public void test005 (){
    Response response = given()
            .pathParam("id", "614")
            .when()
            .get("/{id}");
    response.then().statusCode(404);
    response.prettyPrint();
}
}
