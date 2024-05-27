package api.model.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class LoanApplicationRequest {

    private String loanAppUuid;
    private boolean skipSideEffects;
}
