package ui.page;

import core.control.Button;
import core.control.TextField;
import core.selenium.DriverManager;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ui.BasePage;
import util.RegExUtil;

public class DmFunnelPage extends BasePage {

    private static final Logger log = Logger.getLogger(DmFunnelPage.class);

    private final TextField loanAmount = new TextField(By.name("desiredAmount"));
    private final Select loanPurpose = new Select(DriverManager.getInstance()
            .getDriver().findElement(By.name("loan-purpose")));
    private final Button checkYourRateBtn = new Button("Check your rate");

    public DmFunnelPage() {
        super(By.xpath("//h1[text()='Personal Loans up to $50,000']"));
        log.info("Funnel page is opened");
    }
    
    @Step("Set loan amount value")
    public void setLoanAmount(String amount) {
        loanAmount.setValue(amount);
        log.info(String.format("Loan amount is set %s", amount));
    }

    public void setLoanPurpose(String purpose) {
        loanPurpose.selectByVisibleText(purpose);
        log.info(String.format("Loan purpose is set %s", purpose));
    }

    public BasicInformationPage checkYourRate() {
        checkYourRateBtn.press();
        log.info("Check your rate is clicked");
        return new BasicInformationPage();
    }

    public String getLoanAmount() {
        return RegExUtil.getIntegerFromString(loanAmount.getText());
    }

    public String getLoanPurpose() {
        return loanPurpose.getFirstSelectedOption().getText();
    }


}
