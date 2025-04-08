package endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;


import java.util.ResourceBundle;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class userendpoints_urlsfrompropertiesfile {

    static ResourceBundle geturl()
    {
        ResourceBundle routes=ResourceBundle.getBundle("routes"); //loads properties file
        return routes;

    }

    public static Response createuser(User payload)
    {

        String post_url= geturl().getString("post_url");
        Response res= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when().post(post_url);
        return res;

    }

    public static Response getuser(String UserName)
    {
        String get_url= geturl().getString("get_url");
        Response res= given()
                .pathParam("username",UserName)

                .when()
                .get(get_url);
        return res;
    }


    public static Response updateuser(User payload, String UserName)
    {
        String update_url= geturl().getString("update_url");
        Response res= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",UserName)
                .body(payload)

                .when().put(update_url);
        return res;
    }

    public static Response deleteuser(String UserName)
    {
        String delete_url= geturl().getString("delete_url");
        Response res= given()
                .pathParam("username",UserName)

                .when()
                .delete(delete_url);
        return res;
    }
}
