package com.pluralsight;

import com.pluralsight.finance.BankAccount;
import com.pluralsight.finance.CreditCard;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

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
        // Repeat prompt until valid number
        int selectedOption = 0;
        while (selectedOption != 7) {
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
            selectedOption = Console.promptForInt("› Select [0-6]: ");
            switch (selectedOption) {
                case 1 -> addBankAccount();
                case 2 -> addCreditCard();
                case 3 -> addHouse();
                case 4 -> addGold();
                case 5 -> addJewelry();
                case 6 -> viewAssets();
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
        printAssetAddedMessage(); // Success message
    }

    private static void addCreditCard() {
        String name = Console.promptForString("Enter account name: ");
        String accountNumber = Console.promptForString("Enter account number: ");
        BigDecimal balance = Console.promptForBigDecimal("Enter balance: ").setScale(2, RoundingMode.HALF_UP);
        CreditCard creditCard = new CreditCard(name, accountNumber, balance); // Create credit card
        portfolio.add(creditCard); // Add credit card to portfolio
        printAssetAddedMessage(); // Success message
    }

    private static void addHouse() {
        String name = Console.promptForString("Enter house address: ");
        BigDecimal marketValue = Console.promptForBigDecimal("Enter market value: ").setScale(2, RoundingMode.HALF_UP);
        int yearBuilt = Console.promptForInt("Enter year when house was built: ");
        int squareFeet = Console.promptForInt("Enter total square feet: ");
        int bedrooms = Console.promptForInt("Enter number of bedrooms: ");
        House house = new House(name, marketValue, yearBuilt, squareFeet, bedrooms); // Create house asset
        portfolio.add(house); // Add house to portfolio
        printAssetAddedMessage(); // Success message
    }

    private static void addGold() {
        String name = Console.promptForString("Enter gold item name: ");
        BigDecimal marketValue = Console.promptForBigDecimal("Enter market value: ").setScale(2, RoundingMode.HALF_UP);
        double weight = Console.promptForDouble("Enter gold weight in grams: ");
        Gold gold = new Gold(name, marketValue, weight); // Create gold asset
        portfolio.add(gold); // Add gold to portfolio
        printAssetAddedMessage(); // Success message
    }

    private static void addJewelry() {
        String name = Console.promptForString("Enter jewelry item name: ");
        BigDecimal marketValue = Console.promptForBigDecimal("Enter market value: ").setScale(2, RoundingMode.HALF_UP);
        double karat = Console.promptForDouble("Enter number of karats: ");
        Jewelry jewelry = new Jewelry(name, marketValue, karat); // Create jewelry asset
        portfolio.add(jewelry); // Add gold to portfolio
        printAssetAddedMessage(); // Success message
    }

    private static void printAssetAddedMessage() {
        System.out.println("\nAsset successfully added to your portfolio!");
    }

    private static void viewAssets() {
        // Repeat prompt until valid number
        int selectedOption = 0;
        while (selectedOption != 4) {
            System.out.println("""
                    \n------------------------------
                                 Assets
                    ------------------------------
                    [1] View most valuable asset
                    [2] View least valuable asset
                    [3] View all assets
                    [4] Back to home screen
                    """);
            selectedOption = Console.promptForInt("› Select [1-4]: ");
            switch (selectedOption) {
                case 1 -> processMostValuableAsset(); // Print most valuable asset
                case 2 -> processLeastValuableAsset(); // Print least valuable asset
                case 3 -> portfolio.getAllAssets(); // View all aseets
                case 4 -> {
                } // Return to main menu
                default -> System.out.println("Number should be between 1 and 4.");
            }
        }
    }

    private static void processMostValuableAsset() {
        Valuable mostValuable = portfolio.getMostValuable();
        System.out.println("Most valuable asset: " + mostValuable.getName());
        System.out.println("Value: " + mostValuable.getValue());
    }

    private static void processLeastValuableAsset() {
        Valuable leastValuable = portfolio.getLeastValuable();
        System.out.println("Least valuable asset: " + leastValuable.getName());
        System.out.println("Value: " + leastValuable.getValue());
    }
}