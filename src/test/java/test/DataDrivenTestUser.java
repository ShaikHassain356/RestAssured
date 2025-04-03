package test;

import endpoints.userendpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.User;
import utilities.DataProviders;


public class DataDrivenTestUser {

    @Test(priority = 1, dataProvider = "Data",dataProviderClass = DataProviders.class)
    public void datadrivensetup(String id, String userName, String firstName, String lastName, String mail, String pswd, String phone)
    {
        User userpayload=new User();
        userpayload.setId(Integer.parseInt(id));
        userpayload.setUsername(userName);
        userpayload.setFirstName(firstName);
        userpayload.setLastName(lastName);
        userpayload.setEmail(mail);
        userpayload.setPassword(pswd);

        Response res= userendpoints.createuser(userpayload);
        Assert.assertEquals(res.statusCode(),200);


    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void datadrivendelete(String userName)
    {

        Response res= userendpoints.deleteuser(userName);
        Assert.assertEquals(res.statusCode(),200);

    }
}
