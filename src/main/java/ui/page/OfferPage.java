package ui.page;

import core.control.Button;
import core.control.TextLabel;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import ui.BasePage;
import ui.form.RightMenuPanel;
import util.RegExUtil;

public class OfferPage extends BasePage {

    private static final Logger log = Logger.getLogger(OfferPage.class);

    private final Button menuBtn = new Button(By.cssSelector("div[class='header-nav']"));
    private final TextLabel yourLoanAmountLbl = new TextLabel("userLoanAmount");
    private final TextLabel defaultMonthlyPaymentLbl = new TextLabel(By.xpath("//li/div[@data-auto='defaultMonthlyPayment']"));
    private final TextLabel defaultTermLbl = new TextLabel("defaultLoanTerm");
    private final TextLabel defaultInterestRateLbl = new TextLabel("defaultLoanInterestRate");
    private final TextLabel defaultAprLbl = new TextLabel("defaultAPR");

    public OfferPage() {
        super(By.xpath("//div[text()='Your Loan Amount']"));
        log.info("Offer page is opened");
    }

    public RightMenuPanel getRightMenuPanel() {
        return new RightMenuPanel();
    }

    public void openMenu() {
        menuBtn.press();
        log.info("Menu was opened");
    }

    public Integer getLoanAmount() {
        log.info("Getting loan amount");
        return Integer.parseInt(RegExUtil.getIntegerFromString(yourLoanAmountLbl.getText()));
    }

    public Double getDefaultMonthlyPayment() {
        log.info("Getting monthly payment");
        return Double.parseDouble(RegExUtil.getNumbersFromString(defaultMonthlyPaymentLbl.getText()));
    }

    public Integer getDefaultTerm() {
        log.info("Getting default term");
        return Integer.parseInt(RegExUtil.getNumbersFromString(defaultTermLbl.getText()));
    }

    public Double getDefaultInterestRate() {
        log.info("Getting default interest rate");
        return Double.parseDouble(RegExUtil.getNumbersFromString(defaultInterestRateLbl.getText()));
    }

    public Double getDefaultApr() {
        log.info("Getting default apr");
        return Double.parseDouble(RegExUtil.getNumbersFromString(defaultAprLbl.getText()));
    }
}
