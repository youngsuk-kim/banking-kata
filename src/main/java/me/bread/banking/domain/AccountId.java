package me.bread.banking.domain;

import java.util.Objects;
import java.util.UUID;

public class AccountId {

    private final UUID id = UUID.randomUUID();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountId accountId = (AccountId) o;
        return Objects.equals(id, accountId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
