package com.shurankain.spring.soap.ws.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shurankain.spring.soap.ws.server.loaneligibility.Acknowledgement;
import com.shurankain.spring.soap.ws.server.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityService {

    public Acknowledgement checkLoanEligibility(CustomerRequest request) {
        Acknowledgement acknowledgement = new Acknowledgement();
        List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();

        if (!(request.getAge() > 30 && request.getAge() <= 60)) {
            mismatchCriteriaList.add("Person age should in between 30 to 60");
        }
        if ((request.getYearlyIncome() <=  200000)) {
            mismatchCriteriaList.add("minimum income should be more than 200000");
        }
        if ((request.getCibilScore() <= 500)) {
            mismatchCriteriaList.add("Low CIBIL Score please try after 6 month");
        }

        if (!mismatchCriteriaList.isEmpty()) {
            acknowledgement.setApprovedAmount(0);
            acknowledgement.setIsEligible(false);
        } else {
            acknowledgement.setApprovedAmount(500000);
            acknowledgement.setIsEligible(true);
            mismatchCriteriaList.clear();
        }
        return acknowledgement;

    }

}
