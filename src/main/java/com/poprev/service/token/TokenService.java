package com.poprev.service.token;

import com.poprev.data.model.investment.Investment;
import com.poprev.service.dto.PurchaseTokenDto;
import com.poprev.service.exception.PoprevException;
import com.poprev.service.response.InvestmentResponse;
import com.poprev.service.response.TransactionResponse;


public interface TokenService {
    void buyToken(PurchaseTokenDto dto) throws PoprevException;
    TransactionResponse findAllTransactionsOfAToken(Long tokenId);
    InvestmentResponse findAllUserInvestmentInAToken(Long userId, Long tokenId);
    Investment findUserInvestmentDetails(Long investmentId, Long userId) throws PoprevException;

}
