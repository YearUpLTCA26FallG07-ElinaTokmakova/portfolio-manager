package com.pluralsight;

import com.pluralsight.finance.BankAccount;
import com.pluralsight.finance.CreditCard;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinanceApplication {
    private static Portfolio portfolio;

    public static void main(String[] args) {
        // Welcome message
        displayWelcomeMessage();

        // User input
        String name = Console.promptForString("Enter portfolio name: "); // Get portfolio name
        String owner = Console.promptForString("Enter your name: "); // Get owner name

        // Create portfolio
        portfolio = new Portfolio(name, owner);

        // Display menu
        displayHomeScreen();
        BankAccount account1 = new BankAccount("Pam", "123", new BigDecimal("12500"));
        CreditCard account2 = new CreditCard("Gary", "456", new BigDecimal("1500"));

        account1.deposit(new BigDecimal(100));
        account2.charge(new BigDecimal(100));
    }

    // Displays welcome message
    public static void displayWelcomeMessage() {
        System.out.println("""
                ------------------------------
                 Welcome to portfolio manager
                ------------------------------""");
    }

    // Displays menu
    public static void displayHomeScreen() {
        System.out.println("""
                \n------------------------------
                             Home
                ------------------------------
                [1] Add bank account
                [2] Add credit card
                [3] Add house
                [4] Add gold
                [5] Add jewelry
                [6] View all assets
                [7] Exit
                """);
        int selectedOption = 0;

        // Repeat prompt until valid number
        while (selectedOption != 7) {
            selectedOption = Console.promptForInt("› Select [0-6]: ");
            switch (selectedOption) {
                case 1 -> addBankAccount();
                case 2 -> addCreditCard();
                case 3 -> addHouse();
                case 4 -> addGold();
                case 5 -> addJewelry();
                case 6 -> viewAllAssets();
                case 7 -> System.out.println("\nThanks for using our app!");
                default -> System.out.println("Number should be between 1 and 6.");
            }
        }
    }

    private static void addBankAccount() {
        String name = Console.promptForString("Enter account name: ");
        String accountNumber = Console.promptForString("Enter account number: ");
        BigDecimal balance = Console.promptForBigDecimal("Enter balance: ").setScale(2, RoundingMode.HALF_UP);
        BankAccount bankAccount = new BankAccount(name, accountNumber, balance); // Create bank account
        portfolio.add(bankAccount); // Add account to portfolio
        printAssetAddedMessage(bankAccount); // Success message
    }

    private static void addCreditCard() {
        String name = Console.promptForString("Enter account name: ");
        String accountNumber = Console.promptForString("Enter account number: ");
        BigDecimal balance = Console.promptForBigDecimal("Enter balance: ").setScale(2, RoundingMode.HALF_UP);
        CreditCard creditCard = new CreditCard(name, accountNumber, balance); // Create bank account
        portfolio.add(creditCard); // Add account to portfolio
        printAssetAddedMessage(creditCard); // Success message
    }

    private static void addHouse() {
    }

    private static void addGold() {
    }

    private static void addJewelry() {
    }

    private static void viewAllAssets() {
    }

    private static void printAssetAddedMessage(Valuable asset) {
        System.out.println("\nAsset successfully added to your portfolio!");
    }
}