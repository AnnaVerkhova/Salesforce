package salesforce;


import model.ContactModel;
import org.testng.annotations.Test;
import utils.ContactModelUtils;

public class AddContactTest extends BaseTest {

    ContactModel testContact = ContactModelUtils.getDefaultContactModel();
    ContactModel testContact2 = ContactModelUtils.checkResults();



    @Test(description ="Тестирование нового контакта")
    public void addNewContactTest() {
        mainSteps
                .openSalesforceLoginPage()
                .loginWithValidCreds()
                .openContactPage()
                .createNewContact(testContact)
                .validateContactCreated(testContact2);
    }
}
