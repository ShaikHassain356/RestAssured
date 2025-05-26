package PracticeRESTAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingJson {

    @Test
    public void json()
    {
        Response res= given()

                .when().get("http://localhost:3000/store");

        String actualtitle= res.jsonPath().get("book[1].title").toString();

        Assert.assertEquals(actualtitle,"To Kill a Mockingbird");

        JSONObject jo=new JSONObject(res.asString());//converting response to json object

        for (int i=0;i<jo.getJSONArray("book").length();i++)
        {
            String title= jo.getJSONArray("book").getJSONObject(i).get("title").toString();
            System.out.println(title);
        }

    }
}
