package me.bread.banking.banking.domain;

import java.util.concurrent.ConcurrentHashMap;

public class Bank {
    public static final ConcurrentHashMap<Name, Account> accounts = new ConcurrentHashMap<>();

    public static Account getAccount(final Name name) {
        return accounts.get(name);
    }

    public static void putAccount(final Name name, final Account account) {
        accounts.put(name, account);
    }
}
