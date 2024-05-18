package me.bread.banking.view;

import me.bread.banking.model.BodyModel;

import static me.bread.banking.model.BodyModel.format;

public class BodyView {

    public static void print(BodyModel model) {
        System.out.printf(
                "%s || %s         || %s   || %s   ",
                model.date().orElse(""),
                format(model.credit()),
                format(model.debit()),
                format(model.balance()));
    }
}
