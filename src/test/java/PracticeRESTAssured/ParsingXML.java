package PracticeRESTAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.crypto.dsig.XMLObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ParsingXML {

    @Test
    public void xml()
    {
        Response res= given()

                .when().get("http://localhost:3000/agents.xml");
        String actualheader= res.getHeader("accept-ranges").toString();
        Assert.assertEquals(actualheader,"bytes");

        for (int i=0;i<res.xmlPath().getList("root.store.book").size();i++)
        {
            String title= res.xmlPath().getString("root.store.book["+i+"].author.text()");
            System.out.println(title);
        }

    }
}
