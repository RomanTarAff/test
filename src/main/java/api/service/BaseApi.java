package api.service;

import api.util.RequestSpecHelper;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

import static core.config.ConfigurationManager.configuration;

public class BaseApi {

    public BaseApi() {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.requestSpecification = RequestSpecHelper.getDefaultRequestSpec();
        RestAssured.requestSpecification.given().baseUri(configuration().apiUrl());
    }
}
