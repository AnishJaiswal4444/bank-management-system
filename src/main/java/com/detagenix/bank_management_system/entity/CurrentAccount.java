package com.detagenix.bank_management_system.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Table(name = "current_accounts")
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAccount extends Account {

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal overdraftLimit;

    @Column(length = 20)
    private String gstNumber;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal overdraftInterestRate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal monthlyServiceFee;

    @Column(nullable = false)
    @Builder.Default
    private Boolean overdraftUsed = false;

    @Column(nullable = false)
    private Integer freeTransLimit;
}