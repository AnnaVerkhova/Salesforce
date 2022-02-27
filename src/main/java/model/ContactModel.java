package model;

import java.util.Objects;

public class ContactModel {

    String Salutation;
    String FirstName;
    String LastName;
    String AccountName;
    String Title;
    String Phone;
    String Mobile;
    String Email;
    String Name;

    public ContactModel() {
    }

    public void setSalutation(String salutation) {
        Salutation = salutation;
    }

    public String getSalutation() {
        return Salutation;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactModel account = (ContactModel) o;
        return Salutation== account.Salutation &&
                Objects.equals(FirstName, account.FirstName) && Objects.equals(LastName, account.LastName) &&
                Objects.equals(AccountName, account.AccountName) && Objects.equals(Title, account.Title) &&
                Objects.equals(Phone, account.Phone) && Objects.equals(Mobile, account.Mobile)
                && Objects.equals(Email, account.Email) && Objects.equals(Name, account.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Salutation, FirstName, LastName, AccountName, Title, Phone, Mobile, Email, Name);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Salutation='" + Salutation + '\'' +
                ", FirstName='" + FirstName + '\'' +
               ", LastName='" + LastName + '\'' +
                ", AccountName='" + AccountName + '\'' +
                ", Title='" + Title + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Email='" + Email + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
