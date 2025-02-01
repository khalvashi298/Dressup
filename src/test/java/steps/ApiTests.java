package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTests {

    @Test
    public void testGetUsers() {
        String endpoint = "https://reqres.in/api/users?page=2";

        Response response = RestAssured
                .given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();

        // ვამოწმებთ სტატუს კოდს
        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch");

        // ბეჭდავს პასუხის ბოდიას კონსოლში (დასაბეჭდად)
        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());
    }
}

