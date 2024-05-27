package api.model.response;

import lombok.Data;

@Data
public class LoanAppResponse {

    private LoanAppResumptionInfo loanAppResumptionInfo;
    private Object[] offers; //todo disabled because of unknown fields of Offer object
    private String selectedOffer; //String??
    private String[] requiredAgreements; //String??
    private String[] resetOptions;
    private String originalLoanApp; //String??

}
