package test;

import com.github.javafaker.Faker;
import endpoints.userendpoints;
import endpoints.userendpoints_urlsfrompropertiesfile;
import io.opentelemetry.api.trace.StatusCode;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload.User;



public class UserTests2 {

    static Faker faker;
    static User userpayload;
    public static Logger logger;

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
        logger= LogManager.getLogger(UserTests.class);
        System.out.println("Working Dir: " + System.getProperty("user.dir"));





    }

    @Test(priority = 1)
    public void TestCreateUser()
    {

        logger.info("Started creating the user");
        Response res= userendpoints_urlsfrompropertiesfile.createuser(userpayload);
        res.then().log().all();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("Response Body: " + res.getBody().asString());


    }

    @Test(priority = 2)
    public void TestGetUser()
    {
        logger.info("Started getting the user");
        Response res= userendpoints_urlsfrompropertiesfile.getuser(this.userpayload.getUsername());
        res.then().log().all();
        logger.info("fetched the user");
    }

    @Test(priority = 3)
    public void TestUpdateUser()
    {
        userpayload.setFirstName(faker.name().firstName());
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());
        logger.info("Started updating the user");
        Response res= userendpoints_urlsfrompropertiesfile.updateuser(userpayload,this.userpayload.getUsername());

        //checking data after update
        Response resafterupdate= userendpoints_urlsfrompropertiesfile.getuser(this.userpayload.getUsername());
        resafterupdate.then().log().all();
        logger.info("updated the user");

    }

    @Test(priority = 4)
    public void DeleteUser()
    {
        logger.info("Started deleting the user");
        Response res= userendpoints_urlsfrompropertiesfile.deleteuser(this.userpayload.getUsername());
        res.then().log().all();
        logger.info("deleted the user");
    }
}
