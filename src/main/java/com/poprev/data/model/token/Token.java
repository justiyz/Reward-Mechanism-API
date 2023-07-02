package com.poprev.data.model.token;

import com.poprev.data.model.base.BaseEntity;
import com.poprev.data.model.project.Project;
import com.poprev.data.model.user.PoprevUser;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tokens")
public class Token extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token_name")
    private String tokenName;

    @Column(name = "token_value")
    private BigDecimal tokenValue;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private PoprevUser user;
}
