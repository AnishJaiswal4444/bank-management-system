package com.detagenix.bank_management_system.dto.request;

import com.detagenix.bank_management_system.util.Constants;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentDetails {

    @NotNull(message = Constants.MSG_OVERDRAFT_LIMIT_REQUIRED)
    @DecimalMin(value = "0.0", inclusive = false,
            message = Constants.MSG_INVALID_AMOUNT)
    private BigDecimal overdraftLimit;

    @NotNull(message = Constants.MSG_OVERDRAFT_INTEREST_REQUIRED)
    @DecimalMin(value = "0.0", inclusive = false,
            message = Constants.MSG_INVALID_INTEREST_RATE)
    private BigDecimal overdraftInterestRate;

    @NotNull(message = Constants.MSG_MONTHLY_FEE_REQUIRED)
    @DecimalMin(value = "0.0", inclusive = true,
            message = Constants.MSG_INVALID_AMOUNT)
    private BigDecimal monthlyServiceFee;

    @NotNull(message = Constants.MSG_FREE_TRANS_LIMIT_REQUIRED)
    @Min(value = 0, message = Constants.MSG_INVALID_FREE_TRANS_LIMIT)
    private Integer freeTransLimit;

    @Size(max = 20, message = Constants.MSG_INVALID_GST)
    private String gstNumber;
}