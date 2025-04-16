package endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.poi.sl.usermodel.ObjectMetaData;

import payload.Store;

import java.lang.annotation.Retention;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class storeendpoints {

    public static Response createorder(Store payload)
    {
        Response res= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when().post(routes.store_create_url);
        return res;
    }

    public static Response getorder(String Id)
    {
        Response res= given()
                .pathParam("orderId",Id)

                .when()
                .get(routes.store_get_url);
        return res;

    }

    public static Response deleteorder(String orderId)
    {
        Response res= given()
                .pathParam("orderId",orderId)

                .when().delete(routes.store_delete_url);
        return res;
    }
}
