package com.poprev.service.response;

import com.poprev.data.model.investment.Investment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentResponse {

    private List<Investment> investments;
    private int totalNoOfInvestments;
}
