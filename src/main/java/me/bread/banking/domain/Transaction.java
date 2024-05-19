package me.bread.banking.domain;

import java.time.ZonedDateTime;

public record Transaction(
    ZonedDateTime date,
    Money credit,
    Money debit,
    Money balance
){
    public static class HistoryBuilder {
        private ZonedDateTime date;
        private Money credit;
        private Money debit;
        private Money balance;

        public HistoryBuilder date(ZonedDateTime date) {
            this.date = date;
            return this;
        }

        public HistoryBuilder credit(Money credit) {
            this.credit = credit;
            return this;
        }

        public HistoryBuilder debit(Money debit) {
            this.debit = debit;
            return this;
        }

        public HistoryBuilder balance(Money balance) {
            this.balance = balance;
            return this;
        }

        public Transaction build() {
            return new Transaction(date, credit, debit, balance);
        }
    }

}
