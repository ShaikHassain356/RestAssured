package PracticeRESTAssured;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Scanner;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetParticularUser {

    @Test
    @Parameters("userid")
    public void getparticularuser(String id) //this id will be provider by xml file in parameter section
    {

        given()

                .when().get("https://reqres.in/api/users/"+id)

                .then()
                .body("data.last_name",equalTo("Weaver"))
                .body("support.text",equalTo("Tired of writing endless social media content? Let Content Caddy generate it for you."))
                .statusCode(200)
                .log().all();
    }

}
