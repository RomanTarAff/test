package api.model.response;

import lombok.Data;

@Data
public class LoanAppResumptionInfo {

    private Long loanAppId;
    private String loanAppUuid;
    private String referrer;
    private String status;
    private String productType;
    private String sourceSystem;
    private Double desiredAmount;
    private BorrowerResumptionInfo borrowerResumptionInfo;
    private CoBorrowerResumptionInfo coBorrowerResumptionInfo;
    private Boolean turnDown;
    private Boolean hasLogin;
    private String availableAppImprovements; // String???
    private String cashOutAmount; //String??
    private Boolean canAddCollateral;
    private String rewardProgramId; //String??
    private String rewardProgramCode; //String ??
    private String addon; //String ??
    private Boolean isMobileDiscountApplied; // Boolean ??
    private Boolean checkingDiscountAvailable;

}
