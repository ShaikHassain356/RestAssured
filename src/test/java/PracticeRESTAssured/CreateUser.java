package PracticeRESTAssured;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class CreateUser {

    @Test
    public void createuser()
    {
        HashMap hp=new HashMap();

        hp.put("name","ShaikHassain");
        hp.put("job","QA");

        given().contentType("application/json")
                .body(hp)

                .when().post("https://reqres.in/api/users")

                .then()
                .statusCode(201)
                .log().all();


    }
}
