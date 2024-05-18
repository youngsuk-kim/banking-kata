package me.bread.banking.banking.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class Account {

    private Money balance;

    public Account(BigDecimal balance) {
        this.balance = new Money(balance, Currency.getInstance(Locale.US));
    }

    public void deposit(BigDecimal target) {
       this.balance = this.balance.add(new Money(target, Currency.getInstance(Locale.US)));
    }

    public Money getBalance() {
        return this.balance;
    }

    public void withdraw(BigDecimal withdrawMoney) {
        this.balance = this.balance.subtract(new Money(withdrawMoney, Currency.getInstance(Locale.US)));
    }
}
