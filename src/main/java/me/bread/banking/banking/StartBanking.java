package me.bread.banking.banking;

import me.bread.banking.banking.domain.Account;
import me.bread.banking.banking.domain.Name;
import me.bread.banking.banking.facade.TransactionFacade;

import java.math.BigDecimal;

public class StartBanking {

    public static void main(String[] args) {
        Name name = new Name("영석", "김");
        Account account = new Account(new BigDecimal(10000));
        TransactionFacade.printRandomAccountHistories(account, name);
    }
}

