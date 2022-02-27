package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputContact extends AbstractComponent {

    public static final String INPUT_CONTACT_LOCATOR_PATTERN ="//label[text()='%s']/ancestor::lightning-input//input";

    private String label;
    private By inputContactLocator;

    public InputContact(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.inputContactLocator = By.xpath(String.format(INPUT_CONTACT_LOCATOR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(inputContactLocator).isDisplayed();
    }

    public void insert(String text) {
        driver.findElement(inputContactLocator).sendKeys(text);
    }

}
