package me.bread.banking.banking.usecase;

import me.bread.banking.banking.domain.*;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Currency;

public class NewAccountUseCase {


    public void execute(final Name name, final BigDecimal initialAmount) {
        Money balance = new Money(initialAmount, Currency.getInstance("USD"));
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));

        History history = new History.HistoryBuilder()
                .date(now)
                .credit(balance)
                .balance(balance)
                .build();

        Bank.putAccount(name, new Account(initialAmount, history));
    }
}
