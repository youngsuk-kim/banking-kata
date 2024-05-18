package me.bread.banking.banking.usecase;

import me.bread.banking.banking.domain.Account;
import me.bread.banking.banking.domain.Bank;
import me.bread.banking.banking.domain.Name;

import java.math.BigDecimal;

public class NewAccountUseCase {

    public void execute(final Name name, final BigDecimal initialAmount) {
        Bank.putAccount(name, new Account(initialAmount));
    }
}
