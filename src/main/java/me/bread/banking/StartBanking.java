package me.bread.banking;

import me.bread.banking.domain.Account;
import me.bread.banking.service.TransactionService;

import java.math.BigDecimal;

public class StartBanking {

    public static void main(String[] args) {
        Account account = new Account(new BigDecimal(10000));
        TransactionService.printRandomAccountHistories(account);
    }
}

