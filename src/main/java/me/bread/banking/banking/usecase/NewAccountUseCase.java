package me.bread.banking.banking.usecase;

import me.bread.banking.banking.domain.*;

import java.math.BigDecimal;

public class NewAccountUseCase {


    public Account execute(final Name name, final BigDecimal initialAmount) {
        Bank.putAccount(name, new Account(initialAmount));

        return Bank.getAccount(name);
    }
}
