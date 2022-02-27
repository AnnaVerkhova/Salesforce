package utils;

import builders.ContactBuilder;
import model.ContactModel;

public class ContactModelUtils {

    public static ContactModel getDefaultContactModel() {
        ContactModel contactModel = new ContactModel();
        contactModel.setSalutation("Ms.");
        contactModel.setFirstName("Anna");
        contactModel.setLastName("Verkhova");
        contactModel.setAccountName("Anna");
        contactModel.setTitle("QA Engineer");
        contactModel.setPhone("+375336920790");
        contactModel.setMobile("+375334637942");
        contactModel.setEmail("av.ver@gmail.com");
        return contactModel;
    }

    public static ContactModel checkResults(){
        ContactBuilder.newValues()
                .setName("Ms. Anna Verkhova")
                .setAccountName("Anna")
                .setPhone("+375336920790")
                .setEmail("av.ver@gmail.com")
                .setMobile("+375334637942")
                .setTitle("QA Engineer")
                .build();
        return new ContactModel();
    }
}
