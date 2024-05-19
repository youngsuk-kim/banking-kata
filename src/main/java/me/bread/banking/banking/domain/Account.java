package me.bread.banking.banking.domain;

import java.math.BigDecimal;
import java.util.*;

public class Account {

    private Money balance;
    private final ArrayList<History> history = new ArrayList<>();

    public Account(final BigDecimal balance) {
        this.balance = new Money(balance, Currency.getInstance(Locale.US));
    }

    public Account(final BigDecimal balance, final History history) {
        this.balance = new Money(balance, Currency.getInstance(Locale.US));
        this.history.addFirst(history);
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

    public List<History> getHistory() {
        return history;
    }
}
