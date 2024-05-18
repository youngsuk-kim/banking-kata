package me.bread.banking.banking.usecase;

import me.bread.banking.banking.domain.Account;

import java.math.BigDecimal;

public class WithdrawUseCase {

    public void execute(final Account account, final BigDecimal amount) {
        account.deposit(amount);
    }
}
