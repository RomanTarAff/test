package ui.page;

import core.control.Button;
import core.control.TextField;
import core.selenium.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import ui.BasePage;

import java.util.NoSuchElementException;

public class BasicInformationPage extends BasePage {

    private static final Logger log = Logger.getLogger(BasicInformationPage.class);

    private final TextField firstNameFld = new TextField("borrowerFirstName");
    private final TextField lastNameFld = new TextField("borrowerLastName");
    private final TextField homeAddressFld = new TextField("borrowerStreet");
    private final TextField cityFld = new TextField("borrowerCity");
    private final TextField stateFld = new TextField("borrowerState");
    private final TextField zipCodeFld = new TextField("borrowerZipCode");
    private final TextField dateOfBirthFld = new TextField("borrowerDateOfBirth");
    private final Button continueBtn = new Button("Continue");

    public BasicInformationPage() {
        super(By.xpath("//h1[contains(text(),'get started with some basic information')]"));
        log.info("Basic information page is opened");
    }

    public void setFirstName(String firstName) {
        firstNameFld.setValue(firstName);
        log.info(String.format("First name was set %s", firstName));
    }

    public void setLastName(String lastName) {
        lastNameFld.setValue(lastName);
        log.info(String.format("Last name was set %s", lastName));
    }

    public void setHomeAddress(String homeAddress) {
        homeAddressFld.setAndConfirmValue(homeAddress);
        DriverManager.getInstance()
                .getDriver().findElements(By.cssSelector("b[class='geosuggest__item__matched-text']"))
                .stream().findFirst().orElseThrow(NoSuchElementException::new).click();
        log.info(String.format("Home address was set %s", homeAddress));
    }

    public void setCity(String city) {
        cityFld.setValue(city);
        log.info(String.format("City was set %s", city));
    }

    public void setState(String state) {
        stateFld.setValue(state);
        log.info(String.format("State was set %s", state));
    }

    public void setZipCode(String zipCode) {
        zipCodeFld.setValue(zipCode);
        log.info(String.format("Zip was set %s", zipCode));
    }

    public void setDateOfBirth(String dateOfBirth) {
        dateOfBirthFld.setValue(dateOfBirth);
        log.info(String.format("Date of birth was set %s", dateOfBirth));
    }

    public AnnualIncomePage onContinue() {
        continueBtn.press();
        log.info("Basic information page Continue click");
        return new AnnualIncomePage();
    }


}
