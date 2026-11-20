package com.pluralsight.finance;
import com.pluralsight.Valuable;
import java.math.BigDecimal;

public class CreditCard implements Valuable {
    private String name;
    private final String accountNumber;
    private BigDecimal balance;

    public CreditCard(String name, String accountNumber, BigDecimal balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
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
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    // Adds money to balance
    public void charge(BigDecimal amount) {
        balance = balance.add(amount);
    }

    // Subtracts money from balance
    public void pay(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    // Returns balance value
    public BigDecimal getValue() {
        return balance;
    }
}
