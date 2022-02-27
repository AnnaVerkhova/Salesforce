package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DropdownContact extends AbstractComponent {

    public static final By DROPDOWN_CONTACT_SALUTATION_LOCATOR_PATTERN = By.xpath("//label[text()='Salutation']/ancestor" +
            "::lightning-combobox//div//div[@class='slds-combobox__form-element " +
            "slds-input-has-icon slds-input-has-icon_right']//button/span");

    public static final By DROPDOWN_ACCOUNT_NAME_LOCATOR_PATTERN = By.xpath("//label[text()='Account Name']" +
            "/ancestor::lightning-grouped-combobox[contains(@class,'slds-form-element')]//input[@type='text']");

    private String label;
    public By dropdownLocator;
    public By Locator;
    private static final String CONTACT_OPTION_LIST_PATTERN = "//span[@class='slds-media__body']//span[@title='%s']";

    public DropdownContact(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.dropdownLocator= Locator;
    }
    public boolean isComponentDisplayed(By Locator) {
        return driver.findElement(Locator).isDisplayed();
    }

    private void openOptionsPopup (By Locator){
        driver.findElement(Locator).click();
    }

    public void selectOptionDropdown(By locator, String optionName) {
        openOptionsPopup(locator);
        By optionLocator = By.xpath(String.format(CONTACT_OPTION_LIST_PATTERN, optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        driver.findElement(optionLocator).click();
    }

    @Override
    public boolean isComponentDisplayed() {
        return false;
    }
}
