package com.detagenix.bank_management_system.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "savings_accounts")
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SavingsAccount extends Account {

    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal interestRate;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal withdrawalLimit;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal dailyTxnLimit;

    @Column(nullable = false)
    private Integer maxWithdrawals;

    private LocalDate lastInterestDate;
}