package me.bread.banking.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class AccountTest {

    private Account account;
    private final BigDecimal initialBalance = new BigDecimal("1000.00");

    @BeforeEach
    public void setUp() {
        account = new Account(initialBalance);
    }

    @Test
    public void accountInitializationTest() {
        assertNotNull(account.getAccountId());
        assertEquals(new Money(initialBalance, Currency.getInstance(Locale.US)), account.getBalance());
        assertFalse(account.getHistory().isEmpty());
    }

    @Test
    public void depositTest() {
        BigDecimal depositAmount = new BigDecimal("200.00");
        account.deposit(depositAmount);
        Money expectedBalance = new Money(initialBalance.add(depositAmount), Currency.getInstance(Locale.US));

        assertEquals(expectedBalance, account.getBalance());
        assertEquals(2, account.getHistory().size()); // Includes initial history
    }

    @Test
    public void withdrawTest() {
        BigDecimal withdrawAmount = new BigDecimal("150.00");
        account.withdraw(withdrawAmount);
        Money expectedBalance = new Money(initialBalance.subtract(withdrawAmount), Currency.getInstance(Locale.US));

        assertEquals(expectedBalance, account.getBalance());
        assertEquals(2, account.getHistory().size()); // Includes initial history
    }

    @Test
    public void withdrawInsufficientFundsTest() {
        BigDecimal withdrawAmount = new BigDecimal("1200.00"); // More than the initial balance
        account.withdraw(withdrawAmount);
        Money expectedBalance = new Money(initialBalance, Currency.getInstance(Locale.US)); // No change expected

        assertEquals(expectedBalance, account.getBalance()); // Balance remains the same
        assertEquals(2, account.getHistory().size()); // Includes initial history
    }
}