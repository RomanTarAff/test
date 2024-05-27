package ui.page;

import core.control.Button;
import core.control.TextField;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import ui.BasePage;

public class LoginPage extends BasePage {

    private static final Logger log = Logger.getLogger(LoginPage.class);

    private final TextField emailFld = new TextField("username");
    private final TextField passwordFld = new TextField("password");
    private final Button signInBtn = new Button("Sign in to your account");

    public LoginPage() {
        super(By.xpath("//h2[text()='Welcome Back!']"));
        log.info("Login page is opened");
    }

    public void setEmail(String email) {
        emailFld.setValue(email);
        log.info(String.format("Email is set %s", email));
    }

    public void setPassword(String password) {
        passwordFld.setValue(password);
        log.info(String.format("Password is set %s", password));
    }

    public OfferPage login() {
        signInBtn.press();
        log.info("Login btn is clicked");
        return new OfferPage();
    }
}
