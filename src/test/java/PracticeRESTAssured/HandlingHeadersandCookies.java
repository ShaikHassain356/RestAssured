package PracticeRESTAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HandlingHeadersandCookies {

    @Test(priority = 1)
    public void headers()
    {
        Response res= given()

                .when().get("https://www.google.co.in/");

        //fetching single header from the request

        String oneheader= res.getHeader("Cache-Control");

        System.out.println("single header from the request is "+oneheader);

        //fetching all the headers from the request

        Headers allheaders= res.getHeaders();

        for (Header onebyoneheader: allheaders.asList())
        {
            System.out.println("key of the header is " +onebyoneheader.getName() +" and value of the header is "+onebyoneheader.getValue());
        }
    }

    @Test(priority = 2)
    public void cookies()
    {
        Response res= given()

                .when().get("https://www.google.co.in/");
        //fetching single cookie from the request

        String singlecookie= res.getCookie("AEC");

        System.out.println("single cookie from the request is "+singlecookie);

        //fetching all cookies from the request

        Map<String,String> cookie= res.getCookies();

        for (String key: cookie.keySet())
        {
            String keyvalue =res.getCookie(key);

            System.out.println(key+" and it's value is "+keyvalue);
        }


    }

}
