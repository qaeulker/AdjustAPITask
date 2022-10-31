package Pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Find_pet_status {

    static Response response;

    public void get_pet_ByStatus(String status) {
        response = given().get("https://petstore.swagger.io/v2/pet/findByStatus?status=" + status).prettyPeek();
        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println(response.getBody().asString());

        System.out.println("name = " + response.jsonPath().getString("name"));
        System.out.println("status = " + response.jsonPath().getString("status"));

    }
}
