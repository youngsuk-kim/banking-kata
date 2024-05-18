package me.bread.banking.domain;

import me.bread.banking.banking.domain.Money;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    private final Currency USD = Currency.getInstance("USD");
    private final Currency EUR = Currency.getInstance("EUR");

    @Test
    public void addWithSameCurrencyTest() {
        // Given
        Money money1 = new Money(BigDecimal.valueOf(100), USD);
        Money money2 = new Money(BigDecimal.valueOf(150), USD);

        // When
        Money result = money1.add(money2);

        // Then
        assertEquals(new Money(BigDecimal.valueOf(250), USD), result);
    }

    @Test
    public void subtractWithSameCurrencyTest() {
        // Given
        Money money1 = new Money(BigDecimal.valueOf(200), USD);
        Money money2 = new Money(BigDecimal.valueOf(50), USD);

        // When
        Money result = money1.subtract(money2);

        // Then
        assertEquals(new Money(BigDecimal.valueOf(150), USD), result);
    }

    @Test
    public void currencyMismatchTest() {
        // Given
        Money money1 = new Money(BigDecimal.valueOf(100), USD);
        Money money2 = new Money(BigDecimal.valueOf(100), EUR);

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            money1.add(money2);
        });

        // Then
        assertEquals("Cannot combine money of different currencies", exception.getMessage());
    }

    @Test
    public void toStringTest() {
        // Given When
        Money money = new Money(BigDecimal.valueOf(123.45), USD);

        // Then
        assertTrue(money.toString().contains("US$"));
        assertTrue(money.toString().contains("123.45"));
    }
}