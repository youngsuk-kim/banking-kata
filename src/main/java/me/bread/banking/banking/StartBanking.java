package me.bread.banking.banking;

import me.bread.banking.banking.domain.Account;
import me.bread.banking.banking.domain.Bank;
import me.bread.banking.banking.domain.History;
import me.bread.banking.banking.domain.Name;
import me.bread.banking.banking.usecase.NewAccountUseCase;
import me.bread.banking.banking.view.BodyView;
import me.bread.banking.banking.view.HeaderView;
import me.bread.banking.banking.view.model.BodyModel;

import java.math.BigDecimal;
import java.util.Optional;

public class StartBanking {

    public static void main(String[] args) {
        new NewAccountUseCase().execute(new Name("영석", "김"), new BigDecimal(10000));

        Account account = Bank.getAccount(new Name("영석", "김"));
        History history = account.getHistory();

        HeaderView.print();
        BodyView.print(new BodyModel(
                Optional.of(history.date().toString()),
                Optional.ofNullable(history.credit()),
                Optional.ofNullable(history.debit()),
                Optional.ofNullable(history.balance())
        ));
    }
}
