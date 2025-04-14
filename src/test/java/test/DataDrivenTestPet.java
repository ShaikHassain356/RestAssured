package test;

import endpoints.petendpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.Pet;
import payload.User;
import utilities.DataProviders;

import java.util.Collections;

public class DataDrivenTestPet {

    Pet petpayload;
    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void createuser(String id, String name, String photoUrls, String status)
    {
        petpayload= new Pet();
        petpayload.setId(Integer.parseInt(id));
        petpayload.setName(name);
        petpayload.setPhotoUrls(Collections.singletonList(photoUrls));
        petpayload.setStatus(status);

        Response res= petendpoints.createpet(petpayload);
        res.then().log().all();

        Assert.assertEquals(res.statusCode(),200);
    }

    @Test(priority = 2)
    public void getuser()
    {

        Response res= petendpoints.getpet(this.petpayload.getId());
        res.then().log().all();

        Assert.assertEquals(res.statusCode(),200);
    }
}
