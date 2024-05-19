package me.bread.banking.view;

import me.bread.banking.domain.Money;
import me.bread.banking.view.model.BodyModel;

import java.util.Optional;


public class BodyView {

    public static void print(BodyModel model) {
        String creditStr = format(model.credit());
        String debitStr = format(model.debit());
        String balanceStr = format(model.balance());

        System.out.printf(
                "%-10s || %-8s || %-8s || %-9s%n",
                model.getDateString(), creditStr, debitStr, balanceStr
        );
    }

    private static String format(Optional<Money> value) {
        return value.map(v -> String.format("%.2f", v.amount())).orElse("");
    }

}
