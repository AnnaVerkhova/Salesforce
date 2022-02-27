package builders;

import model.ContactModel;

public class ContactBuilder {

    public ContactBuilder(ContactModel contactModel) {
        this.contactModel = contactModel;
    }

    ContactModel contactModel = new ContactModel();

    public static ContactBuilder newValues() {
        return new ContactBuilder();
    }

    public static ContactBuilder defaultContact() {
        ContactModel contactModel = new ContactModel();
        contactModel.setName("Ms. Anna Verkhova");
//        contactModel.setSalutation("Ms.");
//        contactModel.setFirstName("Anna");
//        contactModel.setLastName("Verkhova");
        contactModel.setAccountName("Anna");
        contactModel.setTitle("QA Engineer");
        contactModel.setPhone("+375336920790");
        contactModel.setMobile("+375334637942");
        contactModel.setEmail("av.ver@gmail.com");
        return new ContactBuilder(contactModel);
    }

    public ContactBuilder() {}

    public ContactBuilder setAccountName(String accountName){
        this.contactModel.setAccountName(accountName);
        return this;
    }
    public ContactBuilder setName(String name){
        this.contactModel.setName(name);
        return this;
    }

    public ContactBuilder setTitle(String title){
        this.contactModel.setTitle(title);
        return this;
    }
    public ContactBuilder setPhone(String phone){
        this.contactModel.setPhone(phone);
        return this;
    }
    public ContactBuilder setMobile(String mobile){
        this.contactModel.setMobile(mobile);
        return this;
    }
    public ContactBuilder setEmail(String email){
        this.contactModel.setEmail(email);
        return this;
    }
    public ContactModel build() {
        return contactModel;
    }
}


