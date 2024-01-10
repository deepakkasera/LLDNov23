package org.example.designpatterns.adapter.thirdParty;

public class ICICIBank {
    public void sendMoney(double amount, String from, String to) {
        System.out.println("ICICI transferring money API");
    }

    public double getBalance(String accountNumber) {
        System.out.println("ICICI get Balance API");
        return 0.0;
    }

    public void registerAcc(String phone) {
        System.out.println("ICICI register account");
    }
}
