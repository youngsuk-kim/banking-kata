package me.bread.banking.banking.domain;

import java.time.ZonedDateTime;

public record History (
    ZonedDateTime date,
    Money credit,
    Money debit,
    Money balance
){}
