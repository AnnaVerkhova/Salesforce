package steps;

import components.account.ContactDetailsComponent;
import components.forms.*;
import io.qameta.allure.Step;
import model.ContactModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ContactPage;

public class ContactStep extends AbstractStep {

    ContactPage contactPage = new ContactPage(driver);

    public ContactStep(WebDriver driver) {
        super(driver);
    }

    @Step("Создание нового контакта")
    public ContactStep createNewContact(ContactModel contactModel) {
        contactPage.openNewContactForm();
        CreateContactFormComponent form = new CreateContactFormComponent(driver);
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed")
        );
        fillContactForm(contactModel);
        form.save();
        validatePageIsLoaded(contactPage);
        return new ContactStep(driver);
    }

    @Step("Заполнение данными созданного контакта")
    public void fillContactForm(ContactModel contactModel) {
        new InputContact(driver, "First Name").insert(contactModel.getFirstName());
        new InputContact(driver, "Last Name").insert(contactModel.getLastName());
        new InputContact(driver, "Phone").insert(contactModel.getPhone());
        new InputContact(driver, "Mobile").insert(contactModel.getMobile());
        new InputContact(driver, "Title").insert(contactModel.getTitle());
        new InputContact(driver, "Email").insert(contactModel.getEmail());
        new DropdownContact(driver, "Salutation").selectOptionDropdown(DropdownContact.DROPDOWN_CONTACT_SALUTATION_LOCATOR_PATTERN, contactModel.getSalutation());
        new DropdownContact(driver, "AccountName").selectOptionDropdown(DropdownContact.DROPDOWN_ACCOUNT_NAME_LOCATOR_PATTERN, contactModel.getAccountName());
    }

    @Step("Проверка созданного контакта")
    public void validateContactCreated(ContactModel expectedModel) {
        contactPage.openDetails();
        ContactModel actualModel = getActualContact();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("Contact is not valid: %s", actualModel)
        );
    }


    private ContactModel getActualContact() {
        ContactModel actualModel = new ContactModel();
        actualModel.setName(new ContactDetailsComponent(driver, "Name").getValueName());
        actualModel.setAccountName(new ContactDetailsComponent(driver, "Account Name").getValueContactAccountName());
        actualModel.setTitle(new ContactDetailsComponent(driver, "Title").getValue());
        actualModel.setPhone(new ContactDetailsComponent(driver, "Phone").getValue());
        actualModel.setMobile(new ContactDetailsComponent(driver, "Mobile").getValue());
        actualModel.setEmail(new ContactDetailsComponent(driver, "Email").getValue());
        return new ContactModel();
    }
}





