package com.shurankain.spring.soap.ws.server.emendpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.shurankain.spring.soap.ws.server.loaneligibility.Acknowledgement;
import com.shurankain.spring.soap.ws.server.loaneligibility.CustomerRequest;
import com.shurankain.spring.soap.ws.server.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {

    private static final String NAMESPACE = "http://www.shurankain.com/spring/soap/ws/server/loaneligibility";

    private final LoanEligibilityService service;

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
