package tests;

import manager.DataProviderContact;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {

    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("margo@gmail.com"));
        }
    }

    @Test(dataProvider = "contactSuccess", dataProviderClass = DataProviderContact.class)
    public void addContactSuccessAllFields(){

        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        Contact contact = Contact.builder()
        .name("Tony")
                .lastName("Pupov")
                .phone("666555")
                .email("pupov" + i + "@gmail.com")
                .address("TA")
                .description("Bobs")
                .build();
        logger.info("Tests run with data: --->" + contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test
    public void addNewContactSuccessReqFields(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Pupov")
                .phone("666555")
                .email("pupov" + i + "@gmail.com")
                .address("TA")
                .description("Bobs")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test
    public void addNewContactWrongName(){
        Contact contact = Contact.builder()
                .name("")
                .lastName("Pupov")
                .phone("6665551111")
                .email("pupov@gmail.com")
                .address("TA")
                .description("Bobs")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }
    @Test
    public void addNewContactWrongLastName(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("")
                .phone("6665551111")
                .email("pupov@gmail.com")
                .address("TA")
                .description("Bobs")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
       app.getHelperContact().getScreen("src/test/screenshots/screen.png");
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }
    @Test
    public void addNewContactWrongAddress(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Pupov")
                .phone("6665551111")
                .email("pupov@gmail.com")
                .address("")
                .description("Bobs")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }
    @Test
    public void addNewContactWrongPhone(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Pupov")
                .phone("1111")
                .email("pupov@gmail.com")
                .address("TA")
                .description("Bobs")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }

    @Test
    public void addNewContactWrongEmail(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Pupov")
                .phone("6665551111")
                .email("pupovgmail.com")
                .address("TA")
                .description("Bobs")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }


}
