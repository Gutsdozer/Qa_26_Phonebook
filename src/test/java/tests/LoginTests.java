package tests;

import manager.HelperBase;
import manager.HelperUser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("stepan@gmail.com", "Vomitgod666");
        app.getHelperUser().submitLogin();

       // Assert.assertEquals();
        //Assert.assertNotEquals();
       // Assert.assertTrue();
      //  Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogged());

    }

}
