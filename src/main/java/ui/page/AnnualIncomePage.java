package ui.page;

import core.control.Button;
import core.control.TextField;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePage;

public class AnnualIncomePage extends BasePage {

    private static final Logger log = Logger.getLogger(AnnualIncomePage.class);

    @FindBy
    private WebElement individualAnnualIncomee;

    @FindBy
    private WebElement continueBtnn;


    private final TextField individualAnnualIncome = new TextField("borrowerIncome");
    private final TextField additionalAnnualIncome = new TextField("borrowerAdditionalIncome");
    private final Button continueBtn = new Button("Continue");

    public AnnualIncomePage() {
        super(By.xpath("//h1[text()='How much money do you make in a year?']"));
        log.info("Annual income page is opened");
    }

    public void setIndividualAnnualIncome(String income) {
        individualAnnualIncome.setValue(income);
        log.info(String.format("Individual annual income %s was set", income));
    }

    public void setAdditionalAnnualIncome(String income) {
        additionalAnnualIncome.setValueAndTab(income);
        log.info(String.format("Additional annual income %s was set", income));
    }

    public String getIndividualAnnualIncome() {
        return individualAnnualIncome.getText();
    }

    public String getAdditionalAnnualIncome() {
        return additionalAnnualIncome.getText();
    }

    public CreateAccountPage onContinue() {
        continueBtn.press();
        log.info("Annual income page - Continue btn clicked");
        return new CreateAccountPage();
    }


}
