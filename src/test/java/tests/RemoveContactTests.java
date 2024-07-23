package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static tests.TestBase.app;

public class RemoveContactTests {
    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("mara@gmail.com").setPassword("Mmar123456$"));
        }
        // app.getHelperContact().provideContacts();//if list size<3 contacts-->add 3 contacts

    }

    @Test
    public void removeFirstContact() {
        //Assert list size less by one
    }

    @Test
    public void removeAllContacts() {
        //"No Contacts here!"
    }

}
