package test;

import com.github.javafaker.Faker;
import endpoints.petendpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import payload.Pet;

import java.util.ArrayList;
import java.util.List;


public class PetTests {

    static Faker faker;
    static Pet petpayload;

    @BeforeClass
    public static void petsetup() {
        faker = new Faker();
        petpayload = new Pet();

        petpayload.setId(faker.number().hashCode());
        petpayload.setName(faker.animal().name());

        List<String> photoUrls = new ArrayList<>();
        photoUrls.add(faker.internet().url());
        petpayload.setPhotoUrls(photoUrls);

        // Set status
        petpayload.setStatus("available");
    }

    @Test(priority = 1)
    public void CreatePet() {
        Response res = petendpoints.createpet(petpayload);
        res.then().log().all();
        Assert.assertEquals(res.statusCode(), 200);
    }

    @Test(priority = 2)
    public void GetPet() {
        Response res = petendpoints.getpet(this.petpayload.getId());
        res.then().log().all();
        Assert.assertEquals(res.statusCode(), 200);
    }

    @Test(priority = 3)
    public void UpdatePet() {
        petpayload.setName(faker.name().name());

        List<String> updatedUrls = new ArrayList<>();
        updatedUrls.add(faker.internet().url());
        petpayload.setPhotoUrls(updatedUrls);

        petpayload.setStatus("sold"); // setting valid enum status

        Response res = petendpoints.updatepet(petpayload, this.petpayload.getId());

        Response resafterupdate= petendpoints.getpet(this.petpayload.getId());
        resafterupdate.then().log().all();


    }

    @Test(priority = 4)
    public void DeletePet() {
        Response res = petendpoints.deletepet(this.petpayload.getId());
        res.then().log().all();
    }
}
