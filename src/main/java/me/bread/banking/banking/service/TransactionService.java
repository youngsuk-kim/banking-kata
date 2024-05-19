package me.bread.banking.banking.service;

import me.bread.banking.banking.domain.Account;
import me.bread.banking.banking.domain.History;
import me.bread.banking.banking.domain.Name;
import me.bread.banking.banking.view.BodyView;
import me.bread.banking.banking.view.HeaderView;
import me.bread.banking.banking.view.model.BodyModel;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

public class TransactionService {
    public static void printRandomAccountHistories(Account account, Name name) {
        generateRandomTransactions(account);
        printHistories(account, name);
    }

    private static void generateRandomTransactions(Account account) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            BigDecimal amount = BigDecimal.valueOf(random.nextInt(5000) + 100);
            if (random.nextBoolean()) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
        }
    }

    private static void printHistories(Account account, Name name) {
        System.out.print(name.lastName());
        System.out.println(name.firstName() + "의 입출금 내역");
        HeaderView.print();
        for (History history : account.getHistory()) {
            BodyView.print(new BodyModel(
                    Optional.of(history.date().toString()),
                    Optional.ofNullable(history.credit()),
                    Optional.ofNullable(history.debit()),
                    Optional.ofNullable(history.balance())
            ));
        }
    }
}
