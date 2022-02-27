package components.account;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ContactDetailsComponent extends AbstractComponent {

    public static final String CONTACT_TEXT_DATA_FIELD ="//span[text()='%s']/ancestor::div[@records-recordlayoutitem_recordlayoutitem]//div[@class='slds-form-element__control']//span[@class='test-id__field-value slds-form-element__static slds-grow word-break-ie11']";

    public static final By CONTACT_ACCOUNT_NAME_FIELD = By.xpath("//span[ text()='Account Name']/ancestor::div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'label-stacked')]//slot[@name='outputField']//span[@force-lookup_lookup]");

    public static final By CONTACT_NAME_FIELD  = By.xpath("//div[@records-recordlayoutitem_recordlayoutitem]//slot[@name='outputField']//lightning-formatted-name");

    String label;
    By textFieldLocator;

    public ContactDetailsComponent(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.textFieldLocator = By.xpath(String.format(CONTACT_TEXT_DATA_FIELD, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(textFieldLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public String getValue() {
        return driver.findElement(textFieldLocator).getText();
    }

    public String getValueName(){
        return driver.findElement((CONTACT_NAME_FIELD )).getText();
    }

    public String getValueContactAccountName(){
        return driver.findElement((CONTACT_ACCOUNT_NAME_FIELD )).getText();
    }
}

