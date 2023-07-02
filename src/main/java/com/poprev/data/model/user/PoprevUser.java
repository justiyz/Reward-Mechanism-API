package com.poprev.data.model.user;

import com.poprev.data.model.base.BaseEntity;
import com.poprev.data.model.token.Token;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
public class PoprevUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "email")
    private String email;



//    @OneToMany(mappedBy = "user")
//    private List<Token> tokens;
}
