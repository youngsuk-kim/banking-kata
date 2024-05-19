package me.bread.banking.banking;

import me.bread.banking.banking.domain.Account;
import me.bread.banking.banking.domain.History;
import me.bread.banking.banking.domain.Name;
import me.bread.banking.banking.usecase.DepositUseCase;
import me.bread.banking.banking.usecase.NewAccountUseCase;
import me.bread.banking.banking.usecase.WithdrawUseCase;
import me.bread.banking.banking.view.BodyView;
import me.bread.banking.banking.view.HeaderView;
import me.bread.banking.banking.view.model.BodyModel;

import java.math.BigDecimal;
import java.util.Optional;

import java.util.Random;

public class StartBanking {

    public static void main(String[] args) {
        Name name = new Name("영석", "김");
        Account account = new NewAccountUseCase().execute(name, new BigDecimal(10000));

        printRandomAccountHistories(account, name);
    }

    private static void printRandomAccountHistories(Account account, Name name) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            BigDecimal amount = BigDecimal.valueOf(random.nextInt(5000) + 100);
            if (random.nextBoolean()) {
                new DepositUseCase().execute(account, amount);
            } else {
                new WithdrawUseCase().execute(account, amount);
            }
        }

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

