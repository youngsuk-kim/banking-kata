package me.bread.banking.model;


import java.util.Optional;

public record BodyModel(
        Optional<String> date,
        Optional<String> credit,
        Optional<String> debit,
        Optional<String> balance
) {

    public static String format(Optional<String> target) {
        return target.map(String::format).orElse("");
    }
}