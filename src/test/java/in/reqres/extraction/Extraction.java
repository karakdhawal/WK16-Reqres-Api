package in.reqres.extraction;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Extraction {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="/api/users";
        response = given()
                .when()
                .get("?page=2")
                .then().statusCode(200);
    }
    //5.list of data = 6
    @Test
    public void test001 (){
        List<Integer> list = response.extract().path("data");
        int sizeofList = list.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The list of data is : "+ sizeofList);
        System.out.println("------------------End of Test---------------------------");
    }
}
