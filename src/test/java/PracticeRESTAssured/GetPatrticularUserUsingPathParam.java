package PracticeRESTAssured;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetPatrticularUserUsingPathParam {

    @Test
    @Parameters("userid")
    public void getparticularuser(String userid) //this id will be provider by xml file in parameter section
    {

        given()
                .pathParam("userid",userid)

                .when().get("https://reqres.in/api/users/{userid}")

                .then()
                .body("data.last_name",equalTo("Weaver"))
                .body("support.text",equalTo("Tired of writing endless social media content? Let Content Caddy generate it for you."))
                .statusCode(200)
                .log().all();
    }
}
