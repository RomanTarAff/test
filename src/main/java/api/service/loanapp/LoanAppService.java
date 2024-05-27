package api.service.loanapp;

import api.service.BaseApi;
import api.util.RestRequestHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class LoanAppService extends BaseApi {

    public LoanAppService() {
        RestAssured.requestSpecification.given().basePath("brfunnelorch/v2/resume/");
    }

    public Response checkLoanApplication(Map<String, Object> headers, Object body) {
        return RestRequestHelper.postRequest(headers, LoanAppEndpoint.CHECK_LOAN_APPLICATION, body);
    }
}
