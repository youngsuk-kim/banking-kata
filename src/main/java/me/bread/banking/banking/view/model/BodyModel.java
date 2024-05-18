package me.bread.banking.banking.view.model;


import java.math.BigDecimal;
import java.util.Optional;

public record BodyModel(
        Optional<String> date,
        Optional<BigDecimal> credit,
        Optional<BigDecimal> debit,
        Optional<BigDecimal> balance
) { }