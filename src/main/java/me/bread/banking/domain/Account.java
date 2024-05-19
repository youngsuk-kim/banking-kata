package me.bread.banking.domain;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.Currency;
import java.util.Deque;
import java.util.Locale;

public class Account {
    private final AccountId accountId;
    private Money balance;
    private final Deque<Transaction> histories = new ArrayDeque<>();

    public Account(BigDecimal initialBalance) {
        this.accountId = new AccountId();
        this.balance = new Money(initialBalance, Currency.getInstance(Locale.US));
        recordHistory(null, balance);
    }

    public void deposit(BigDecimal amount) {
        Money depositAmount = new Money(amount, Currency.getInstance(Locale.US));
        this.balance = this.balance.add(depositAmount);
        recordHistory(depositAmount, null);
    }

    public void withdraw(BigDecimal amount) {
        Money withdrawAmount = new Money(amount, Currency.getInstance(Locale.US));
        this.balance = this.balance.subtract(withdrawAmount);
        recordHistory(null, withdrawAmount);
    }

    private void recordHistory(Money credit, Money debit) {
        final ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        Transaction transaction = new Transaction.HistoryBuilder()
                .date(now)
                .credit(credit)
                .debit(debit)
                .balance(this.balance)
                .build();

        histories.addFirst(transaction);
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public Money getBalance() {
        return this.balance;
    }

    public Deque<Transaction> getHistory() {
        return histories;
    }
}
