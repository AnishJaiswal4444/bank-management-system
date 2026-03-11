package com.detagenix.bank_management_system.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountResponse {

    private Long accountId;

    private String accountNumber;

    private String accountType;

    private BigDecimal accountBalance;

    private BigDecimal minimumRequiredBalance;

    private String accountStatus;

    private LocalDateTime createdAt;
}