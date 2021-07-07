package com.shurankain.soaptest.springsoaptest.emendpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.shurankain.soaptest.springsoaptest.loaneligibility.Acknowledgement;
import com.shurankain.soaptest.springsoaptest.loaneligibility.CustomerRequest;
import com.shurankain.soaptest.springsoaptest.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {

    private static final String NAMESPACE = "http://www.shurankain.com/soaptest/springsoaptest/loanEligibility";

    private LoanEligibilityService service;

    @Autowired
    public LoanEligibilityIndicatorEndpoint(LoanEligibilityService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
        return service.checkLoanEligibility(request);
    }

}
