package test;

import com.github.javafaker.Faker;
import endpoints.userendpoints;
import io.opentelemetry.api.trace.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload.User;

public class UserTests {

    static Faker faker;
    static User userpayload;

    @BeforeClass
    public static void setup()
    {
        faker=new Faker();
        userpayload=new User();

        userpayload.setId(faker.idNumber().hashCode());
        userpayload.setUsername(faker.name().username());
        userpayload.setFirstName(faker.name().firstName());
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());
        userpayload.setPassword(faker.internet().password());
        userpayload.setPhone(faker.phoneNumber().cellPhone());


    }

    @Test(priority = 1)
    public void TestCreateUser()
    {

        Response res= userendpoints.createuser(userpayload);
        res.then().log().all();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("Response Body: " + res.getBody().asString());

    }

    @Test(priority = 2)
    public void TestGetUser()
    {
        Response res= userendpoints.getuser(this.userpayload.getUsername());
        res.then().log().all();
    }

    @Test(priority = 3)
    public void TestUpdateUser()
    {
        userpayload.setFirstName(faker.name().firstName());
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());
        Response res= userendpoints.updateuser(userpayload,this.userpayload.getUsername());

        //checking data after update
        Response resafterupdate= userendpoints.getuser(this.userpayload.getUsername());
        resafterupdate.then().log().all();

    }

    @Test(priority = 4)
    public void DeleteUser()
    {
        Response res= userendpoints.deleteuser(this.userpayload.getUsername());
        res.then().log().all();
    }
}
