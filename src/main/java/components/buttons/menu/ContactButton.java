package components.buttons.menu;

import org.openqa.selenium.WebDriver;

public class ContactButton extends MenuButton{

    public static final String CONTACTS_BUTTON_LABEL = "Contacts";

    public ContactButton(WebDriver driver) {
        super(driver, CONTACTS_BUTTON_LABEL);
    }
}
