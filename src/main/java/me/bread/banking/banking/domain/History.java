package me.bread.banking.banking.domain;

import java.time.ZonedDateTime;

public record History (
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

        public History build() {
            return new History(date, credit, debit, balance);
        }
    }

}
