package endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class userendpoints {

    public static Response createuser(User payload)
    {

        Response res= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when().post(routes.create_url);
        return res;

    }

    public static Response getuser(String UserName)
    {
        Response res= given()
                .pathParam("username",UserName)

                .when()
                .get(routes.get_url);
        return res;
    }


    public static Response updateuser(User payload, String UserName)
    {
        Response res= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",UserName)
                .body(payload)

                .when().put(routes.update_url);
        return res;
    }

    public static Response deleteuser(String UserName)
    {
        Response res= given()
                .pathParam("username",UserName)

                .when()
                .delete(routes.delete_url);
        return res;
    }
}
