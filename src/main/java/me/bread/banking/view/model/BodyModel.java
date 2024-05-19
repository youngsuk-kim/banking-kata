package me.bread.banking.view.model;


import me.bread.banking.domain.Money;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public record BodyModel(
        Optional<String> date,
        Optional<Money> credit,
        Optional<Money> debit,
        Optional<Money> balance
) {

    public String getDateString() {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(date().orElse(""));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return zonedDateTime.format(formatter);
    }
}