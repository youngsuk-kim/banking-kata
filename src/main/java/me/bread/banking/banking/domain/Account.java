package me.bread.banking.banking.domain;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class Account {

    private Money balance;
    private final Deque<History> history = new ArrayDeque<>();

    public Account(final BigDecimal balance) {
        this.balance = new Money(balance, Currency.getInstance(Locale.US));
        addHistory();
    }

    public void addHistory() {
        final ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));

        final History history = new History.HistoryBuilder()
                .date(now)
                .credit(this.balance)
                .balance(this.balance)
                .build();

        this.history.addFirst(history);
    }

    public void addDebit(Money debit) {
        final ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));

        final History history = new History.HistoryBuilder()
                .date(now)
                .balance(this.balance)
                .debit(debit)
                .build();

        this.history.addFirst(history);
    }


    public void deposit(final BigDecimal target) {
       this.balance = this.balance.add(new Money(target, Currency.getInstance(Locale.US)));
        addHistory();
    }

    public void withdraw(final BigDecimal withdrawMoney) {
        this.balance = this.balance.subtract(new Money(withdrawMoney, Currency.getInstance(Locale.US)));
        addDebit(new Money(withdrawMoney, Currency.getInstance(Locale.US)));
    }

    public Money getBalance() {
        return this.balance;
    }

    public Queue<History> getHistory() {
        return history;
    }
}
