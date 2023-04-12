package bg.softuni.armory.model.entity.user;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

public class DepositDTO {
    @Pattern(regexp = "^(0|[1-9][0-9]*)$", message = "Please enter valid number!")
    @Min(value = 1, message = "The amount must be larger than zero!")
    private String deposit;

    public DepositDTO() {
    }

    public String getDeposit() {
        return deposit;
    }

    public DepositDTO setDeposit(String deposit) {
        this.deposit = deposit;
        return this;
    }
}
