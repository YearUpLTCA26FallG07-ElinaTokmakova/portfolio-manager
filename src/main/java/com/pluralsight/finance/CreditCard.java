package com.pluralsight.finance;

import com.pluralsight.Valuable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCard implements Valuable {
    private String name;
    private final String accountNumber;
    private BigDecimal balance;

    public CreditCard(String name, String accountNumber, BigDecimal balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance.setScale(2, RoundingMode.HALF_UP);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance.setScale(2, RoundingMode.HALF_UP);
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance.setScale(2, RoundingMode.HALF_UP);
    }

    // Adds money to balance
    public void charge(BigDecimal amount) {
        balance = balance.add(amount).setScale(2, RoundingMode.HALF_UP);
    }

    // Subtracts money from balance
    public void pay(BigDecimal amount) {
        balance = balance.subtract(amount).setScale(2, RoundingMode.HALF_UP);
    }

    // Returns balance value
    public BigDecimal getValue() {
        return balance.setScale(2, RoundingMode.HALF_UP);
    }
}
