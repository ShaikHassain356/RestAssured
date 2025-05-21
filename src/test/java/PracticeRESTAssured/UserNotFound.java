package PracticeRESTAssured;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UserNotFound {


    @Test
    @Parameters("userid")
    public void usernotfound(String userid)
    {
        given().pathParam("userid", userid)

                .when().get("https://reqres.in/api/users/{userid}")

                .then().statusCode(404)
                .log().all();
    }
}
