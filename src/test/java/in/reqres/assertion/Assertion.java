package in.reqres.assertion;

import in.reqres.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Assertion extends TestBase {
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

    //Vetify the following data from response
    //1.page = 2
    @Test
    public void test001 (){ response.body("page", equalTo(2));}
    //2.per_page = 6
    @Test
    public void test002 (){ response.body("per_page", equalTo(6));}

    //3.data[1].id = 8
    @Test
    public void test003 (){ response.body("data[1].id", equalTo(8));}
    //4.data[3].first_name = Byron
    @Test
    public void test004 (){ response.body("data[3].first_name", equalTo("Byron"));}
    //5.list of data = 6
    @Test // extraction
    public void test005 (){
        List<Integer> list =response.extract().path("data");
        int sizeofList = list.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The list of data is : "+ sizeofList);
        System.out.println("------------------End of Test---------------------------");
    }
    //6.data[5].avatar="https://reqres.in/img/faces/11-image.jpg"
    @Test
    public void test006 (){response.body("data[5].avatar", equalTo("https://reqres.in/img/faces/12-image.jpg"));}
    //7. support.url = "https://reqres.in/#support-heading"
    @Test
    public void test007 (){ response.body("support.url", equalTo("https://reqres.in/#support-heading"));}
    //8. support.txt = "To keep ReqRes free, contributions towards server costs are appreciated!"
    @Test
    public void test008 (){response.body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));}

}
