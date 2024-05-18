package me.bread.banking.banking.domain;

import java.math.BigDecimal;
import java.util.Currency;

public record Money(BigDecimal amount, Currency currency) {

    public Money add(final Money other) {
        checkCurrency(other);
        return new Money(amount.add(other.amount), currency);
    }

    public Money subtract(final Money other) {
        checkCurrency(other);
        return new Money(amount.subtract(other.amount), currency);
    }

    private void checkCurrency(final Money other) {
        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot combine money of different currencies");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", currency.getSymbol(), amount);
    }
}
