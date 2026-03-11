package com.detagenix.bank_management_system.dto.request;

import com.detagenix.bank_management_system.util.Constants;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class SavingDetails {

    @NotNull(message = Constants.MSG_INTEREST_RATE_REQUIRED)
    @DecimalMin(value = "0.0", inclusive = false,
            message = Constants.MSG_INVALID_INTEREST_RATE)
    private BigDecimal interestRate;

    @NotNull(message = Constants.MSG_WITHDRAWAL_LIMIT_REQUIRED)
    @DecimalMin(value = "0.0", inclusive = false,
            message = Constants.MSG_INVALID_INTEREST_RATE)
    private BigDecimal withdrawalRate;

    @NotNull(message = Constants.MSG_DAILY_TXN_LIMIT_REQUIRED)
    @DecimalMin(value = "0.0", inclusive = false,
            message = Constants.MSG_INVALID_AMOUNT)
    private BigDecimal dailyTxnLimit;

    @NotNull(message = Constants.MSG_MAX_WITHDRAWALS_REQUIRED)
    @Min(value = 1, message = Constants.MSG_INVALID_MAX_WITHDRAWALS)
    private Integer maxWithdrawals;

}
