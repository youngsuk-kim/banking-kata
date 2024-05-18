package me.bread.banking.domain;

import me.bread.banking.banking.domain.Account;
import me.bread.banking.banking.domain.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    @Test
    void depositTest() {
        // Given
        final Account account = new Account(new BigDecimal(10000));

        final BigDecimal depositMoney = new BigDecimal(1000);

        // When
        account.deposit(depositMoney);

        // Then
        Assertions.assertEquals(
                account.getBalance(),
                new Money(new BigDecimal(11000), Currency.getInstance(Locale.US))
        );
    }

    @Test
    void withdrawTest() {
        // Given
        final Account account = new Account(new BigDecimal(10000));
        final BigDecimal withdrawMoney = new BigDecimal(1000);

        // When
        account.withdraw(withdrawMoney);

        // Then
        assertEquals(
                account.getBalance(),
                new Money(new BigDecimal(9000), Currency.getInstance(Locale.US))
        );
    }
}