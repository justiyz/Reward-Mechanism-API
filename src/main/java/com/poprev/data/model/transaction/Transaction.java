package com.poprev.data.model.transaction;

import com.poprev.data.model.base.BaseEntity;
import com.poprev.data.model.token.Token;
import com.poprev.data.model.user.PoprevUser;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_status")
    private TransactionStatus transactionStatus;

    @Column(name = "transaction_amount")
    private BigDecimal transactionAmount;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "transaction_ref")
    private String transactionReference;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PoprevUser user;

    @ManyToOne
    @JoinColumn(name = "token_id")
    private Token token;
}
