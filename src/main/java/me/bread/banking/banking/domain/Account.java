package me.bread.banking.banking.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class Account {

    private Money balance;
    private History history;

    public Account(final BigDecimal balance) {
        this.balance = new Money(balance, Currency.getInstance(Locale.US));
    }

    public Account(final BigDecimal balance, final History history) {
        this.balance = new Money(balance, Currency.getInstance(Locale.US));
        this.history = history;
    }

    public void deposit(final BigDecimal target) {
       this.balance = this.balance.add(new Money(target, Currency.getInstance(Locale.US)));
    }

    public void withdraw(final BigDecimal withdrawMoney) {
        this.balance = this.balance.subtract(new Money(withdrawMoney, Currency.getInstance(Locale.US)));
    }

    public Money getBalance() {
        return this.balance;
    }

    public History getHistory() {
        return history;
    }
}
