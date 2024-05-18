package me.bread.banking.banking.view;

import me.bread.banking.banking.model.BodyModel;

import java.math.BigDecimal;
import java.util.Optional;


public class BodyView {

    public static void print(BodyModel model) {
        String dateStr = model.date().orElse("");
        String creditStr = format(model.credit());
        String debitStr = format(model.debit());
        String balanceStr = format(model.balance());

        System.out.printf(
                "%-10s || %-8s || %-8s || %-9s%n",
                dateStr, creditStr, debitStr, balanceStr
        );
    }

    private static String format(Optional<BigDecimal> value) {
        return value.map(v -> String.format("%.2f", v)).orElse("");
    }

}
