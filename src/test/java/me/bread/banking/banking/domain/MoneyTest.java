package me.bread.banking.banking.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    private final Currency USD = Currency.getInstance("USD");
    private final Currency EUR = Currency.getInstance("EUR");

    @Test
    public void addWithSameCurrencyTest() {
        Money money1 = new Money(BigDecimal.valueOf(100), USD);
        Money money2 = new Money(BigDecimal.valueOf(150), USD);

        Money result = money1.add(money2);

        assertEquals(new Money(BigDecimal.valueOf(250), USD), result);
    }

    @Test
    public void subtractWithSameCurrencyTest() {
        Money money1 = new Money(BigDecimal.valueOf(200), USD);
        Money money2 = new Money(BigDecimal.valueOf(50), USD);

        Money result = money1.subtract(money2);

        assertEquals(new Money(BigDecimal.valueOf(150), USD), result);
    }

    @Test
    public void currencyMismatchTest() {
        Money money1 = new Money(BigDecimal.valueOf(100), USD);
        Money money2 = new Money(BigDecimal.valueOf(100), EUR);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            money1.add(money2);
        });

        assertEquals("Cannot combine money of different currencies", exception.getMessage());
    }

    @Test
    public void toStringTest() {
        Money money = new Money(BigDecimal.valueOf(123.45), USD);
        assertTrue(money.toString().contains("US$"));
        assertTrue(money.toString().contains("123.45"));
    }
}