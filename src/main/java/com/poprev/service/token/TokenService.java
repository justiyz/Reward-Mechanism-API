package com.poprev.service.token;

import com.poprev.data.model.transaction.Transaction;
import com.poprev.service.dto.PurchaseTokenDto;
import com.poprev.service.exception.PoprevException;
import com.poprev.service.response.TransactionResponse;

import java.util.List;

public interface TokenService {
    void buyToken(PurchaseTokenDto dto) throws PoprevException;
    TransactionResponse findAllTransactionsOfAToken(Long tokenId);
}
