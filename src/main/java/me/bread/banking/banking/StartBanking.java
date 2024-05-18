package me.bread.banking.banking;

import me.bread.banking.banking.domain.Bank;
import me.bread.banking.banking.domain.Name;
import me.bread.banking.banking.usecase.NewAccountUseCase;

import java.math.BigDecimal;

public class StartBanking {

    public static void main(String[] args) {
        new NewAccountUseCase().execute(new Name("영석", "김"), new BigDecimal(10000));

        Bank.getAccount(new Name("영석", "김"));
    }
}
