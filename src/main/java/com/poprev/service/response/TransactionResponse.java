package com.poprev.service.response;

import com.poprev.data.model.transaction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private List<Transaction> transactions;
    private int totalNoOfTransactions;
}
