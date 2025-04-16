package test;

import com.github.javafaker.Faker;
import endpoints.storeendpoints;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload.Store;


public class StoreTests {

    static Store storepayload;
    static Faker faker;

    @BeforeClass
    public static void setup()
    {
        storepayload=new Store();
        faker=new Faker();


        storepayload.setId(faker.number().randomDigitNotZero());
        storepayload.setPetId(String.valueOf(faker.idNumber().hashCode()));
        storepayload.setQuantity(faker.number().randomDigitNotZero());
        storepayload.setShipDate("2025-04-16T12:03:40.641Z");
        storepayload.setStatus("placed");
        storepayload.setComplete("true");


    }

    @Test(priority = 1)
    public void CreateOrder()
    {
        Response res= storeendpoints.createorder(storepayload);
        res.then().log().all();

    }
}
