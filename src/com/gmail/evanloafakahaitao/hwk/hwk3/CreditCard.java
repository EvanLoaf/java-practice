package com.gmail.evanloafakahaitao.hwk.hwk3;

public class CreditCard {

    private int cardNumber;
    private double currentBalance;

    public CreditCard(int cardNumber, double currentBalance) {
        this.cardNumber = cardNumber;
        this.currentBalance = currentBalance;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    protected void withdraw(double amount) {
        this.currentBalance -= amount;
    }

    protected void deposit(double amount) {
        this.currentBalance += amount;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumber=" + cardNumber +
                ", currentBalance=" + currentBalance +
                '}';
    }
}
