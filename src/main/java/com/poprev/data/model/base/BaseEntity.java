package com.poprev.data.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

}
