package me.bread.banking.banking.usecase;

import me.bread.banking.banking.domain.Account;
import me.bread.banking.banking.domain.Money;

public class CheckBalanceUseCase {

    public Money execute(final Account account) {
        return account.getBalance();
    }
}
