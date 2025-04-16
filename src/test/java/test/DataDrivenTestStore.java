package test;

import com.github.javafaker.Faker;
import endpoints.storeendpoints;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import payload.Store;
import utilities.DataProviders;


public class DataDrivenTestStore {

    static Store storepayload;

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void CreateOrder(String id, String petid, String quantity, String shipdate, String status, String complete)
    {
        storepayload=new Store();

        storepayload.setId(Integer.parseInt(id));
        storepayload.setPetId(petid);
        storepayload.setQuantity(Integer.parseInt(quantity));
        storepayload.setShipDate(shipdate);
        storepayload.setStatus(status);
        storepayload.setComplete(String.valueOf(Boolean.parseBoolean(complete)));


        Response res= storeendpoints.createorder(storepayload);
        res.then().log().all();

    }

    @Test(priority = 2)
    public void GetOrder()
    {
        Response res = storeendpoints.getorder(String.valueOf(this.storepayload.getId()));
        res.then().log().all();
    }
}