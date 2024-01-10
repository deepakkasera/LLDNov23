package org.example.designpatterns.adapter;

public class PhonePe {
    public static void main(String[] args) {
        BankApiAdapter bankApiAdapter = new ICICIAdapter();

        bankApiAdapter.sendMoney("Suraj", "Deepak", 1000);
        bankApiAdapter.checkBalance("10001235464564234324");
    }
}
