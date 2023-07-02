package com.poprev.data.model.investment;

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
@Table(name = "investments")
public class Investment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "investment_amount")
    private BigDecimal investmentAmount;

    @Column(name = "investment_date")
    private LocalDateTime investmentDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PoprevUser user;

    @ManyToOne
    @JoinColumn(name = "token_id")
    private Token token;
}
