package apiTests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class RestAssuredTests {

    @Test
    public void verifyStatusCode() {
        RestAssured
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page", equalTo(2));
    }
}
//import io.restassured.RestAssured;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class RestAssuredTest {
//    @Test
//    public void testGetUsersStatusCode() {
//        // API endpoint
//        String url = "https://reqres.in/api/users?page=2";
//
//        // გადმოწერეთ პასუხი და შეამოწმეთ სტატუს კოდი
//        int statusCode = RestAssured.get(url).getStatusCode();
//
//        // შეამოწმეთ, რომ სტატუს კოდი 200-ია
//        Assert.assertEquals(statusCode, 200, "Expected status code is 200, but got " + statusCode);
//    }
//}
