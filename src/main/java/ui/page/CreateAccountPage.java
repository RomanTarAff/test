package ui.page;

import core.control.Button;
import core.control.Checkbox;
import core.control.TextField;
import core.selenium.wait.DriverWait;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import ui.BasePage;

public class CreateAccountPage extends BasePage {

    private static final Logger log = Logger.getLogger(CreateAccountPage.class);

    private final TextField emailFld = new TextField(By.name("username"));
    private final TextField passwordFld = new TextField(By.name("password"));
    private final Checkbox agreements = new Checkbox(By.xpath("//label[.//input[@type='checkbox']]"));
    private final Button checkYourRateBtn = new Button("Check Your Rate");

    public CreateAccountPage() {
        super(By.xpath("//h1[text()='Last step before you get your rate']"));
        log.info("Create account page is opened");
    }

    public void setEmail(String email) {
        emailFld.setValue(email);
        log.info(String.format("Email is set %s", email));
    }

    public void setPassword(String password) {
        passwordFld.setValue(password);
        log.info(String.format("Password is set %s", password));
    }

    public void setStateForAgreements(boolean state) {
        agreements.setState(state);
        log.info(String.format("Agreements checkbox is set %s", state));
    }

    public OfferPage checkYourRate() {
        checkYourRateBtn.press();
        DriverWait.waitForPageLoaded();
        log.info("Check your rate btn clicked");
        return new OfferPage();
    }


}
