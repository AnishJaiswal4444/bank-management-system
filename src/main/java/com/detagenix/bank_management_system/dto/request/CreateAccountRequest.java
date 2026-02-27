package com.detagenix.bank_management_system.dto.request;

import com.detagenix.bank_management_system.enums.AccountType;
import com.detagenix.bank_management_system.util.Constants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest {

    @NotNull(message = Constants.MSG_ACCOUNT_TYPE_REQUIRED)
    private AccountType accountType;

    @NotNull(message = Constants.MSG_BRANCH_ID_REQUIRED)
    private Long branchId;

    @NotNull(message = Constants.MSG_INITIAL_DEPOSIT_REQUIRED)
    @DecimalMin(value = "0.0", inclusive = false,
            message = Constants.MSG_INVALID_AMOUNT)
    private BigDecimal initialDeposit;

    @Valid
    private SavingDetails savingDetails;

    @Valid
    private CurrentDetails currentDetails;

}
