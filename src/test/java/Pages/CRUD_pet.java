package Pages;


import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class CRUD_pet {

    Response response;

    Faker faker = new Faker();

    String ID;
    String petName;
    String status;

    String newID;
    String newPetName;
    String newStatus;

    Map<String, Object> body;

    public void CreateNewPet() {



        ID = faker.number().digits(3);
        petName = faker.animal().name();
        status = "available";


        body = new HashMap<>();

        body.put("id", ID);
        body.put("name", petName);
        body.put("status", status);

        response = given().contentType(ContentType.JSON).body(body).
                when().post("https://petstore.swagger.io/v2/pet").prettyPeek();

        System.out.println("statuscode= " + response.statusCode());

        Assert.assertEquals("no match for status code",200,response.statusCode());

    }

    public void verifyCreatedPet() {

        Assert.assertEquals("no match for id", body.get("id"), response.jsonPath().getString("id"));
        Assert.assertEquals("no match for name", body.get("name"), response.jsonPath().getString("name"));
        Assert.assertEquals("no match for status", body.get("status"), response.jsonPath().getString("status"));

    }
    public void get_pet_ByID() {

        response = given().get("https://petstore.swagger.io/v2/pet/"+response.jsonPath().getString("id")).prettyPeek();

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println(response.getBody().asString());

        System.out.println("name = " + response.jsonPath().getString("name"));
        System.out.println("status = " + response.jsonPath().getString("status"));
    }
    public void update_pet(){

        newID=faker.number().digits(3);;
        newPetName= faker.animal().name();

        switch (status) {
            case "available":
                newStatus = "pending";
                body.put("status", newStatus);
                break;
            case "pending":
                newStatus = "sold";
                body.put("status", newStatus);
                break;
            case "sold":
                newStatus = "available";
                body.put("status", newStatus);
                break;
            default:
                body.put("status", "available");
                break;
        }

        body.put("id",newID);
        body.put("name",newPetName);

        response = given().contentType(ContentType.JSON).body(body).
                when().post("https://petstore.swagger.io/v2/pet").prettyPeek();

        System.out.println("statuscode= " + response.statusCode());

        Assert.assertEquals("no match for status code",200,response.statusCode());

        verifyCreatedPet();

    }
    public void delete_pet(){
        response = given().delete("https://petstore.swagger.io/v2/pet/"+newID).prettyPeek();

        Assert.assertEquals("deleting is not working",200,response.statusCode());
        Assert.assertEquals("deleting is not working","unknown",response.jsonPath().getString("type"));
        Assert.assertEquals("deleting is not working",newID,response.jsonPath().getString("message"));

    }

}
