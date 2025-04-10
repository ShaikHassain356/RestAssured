package endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.Pet;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class petendpoints {

    public static Response createpet(Pet payload )
    {
        Response res= given().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(routes.pet_create_url);
        return res;
    }

    public static Response getpet(int id)
    {
        Response res= given()
                .pathParam("petId",id)

                .when().get(routes.pet_get_url);
        return res;

    }

    public static Response updatepet(Pet payload, int id)
    {
        Response res= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("petId",id)
                .body(payload)


                .when().put(routes.pet_update_url);
        return res;
    }

    public static Response deletepet(int id)
    {
        Response res= given()
                .pathParam("petId",id)

                .when().delete(routes.pet_delete_url);
        return res;
    }
}
