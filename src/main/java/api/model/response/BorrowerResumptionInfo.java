package api.model.response;

import lombok.Data;

@Data
public class BorrowerResumptionInfo {

    private String firstName;
    private String maskedEmail;
    private Boolean ssnRequired;
    private String state;
    private String email;

}
