package com.poprev.service.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class PurchaseTokenDto {

    private Long tokenId;
    private BigDecimal amountPaid;
    private Long userId;
    private String transactionStatus;
    private String transactionReference;

}
