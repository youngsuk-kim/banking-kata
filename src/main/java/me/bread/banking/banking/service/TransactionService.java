package me.bread.banking.banking.service;

import me.bread.banking.banking.domain.Account;
import me.bread.banking.banking.view.BodyView;
import me.bread.banking.banking.view.HeaderView;
import me.bread.banking.banking.view.model.BodyModel;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

public class TransactionService {

    public static void printRandomAccountHistories(Account account) {
        generateRandomTransactions(account);
        printHistories(account);
    }

    private static void generateRandomTransactions(Account account) {
        Random random = new Random();
        IntStream.range(0, 100).forEach(i -> {
            BigDecimal amount = BigDecimal.valueOf(random.nextInt(5000) + 100); // Random amount between 100 and 5100
            account.deposit(amount);
        });
    }

    private static void printHistories(Account account) {
        HeaderView.print();
        account.getHistory().forEach(history -> {
            BodyView.print(new BodyModel(
                    Optional.of(history.date().toString()),
                    Optional.ofNullable(history.credit()),
                    Optional.ofNullable(history.debit()),
                    Optional.ofNullable(history.balance())
            ));
        });
    }
}
