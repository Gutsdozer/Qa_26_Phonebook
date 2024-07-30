package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Tony")
                .lastName("Pupov")
                .phone("6665557")
                .email("pupov@gmail.com")
                .address("TA")
                .description("Bobs")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("TonyReq")
                .lastName("Bobbins")
                .phone("123456789666")
                .email("pupov666@gmail.com")
                .address("NY")
                .build()});


        return list.iterator();
    }

}
