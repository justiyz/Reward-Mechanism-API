package com.poprev.data.model.payment;

import com.poprev.data.model.base.BaseEntity;
import com.poprev.data.model.user.PoprevUser;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "payments")
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PoprevUser user;
}
