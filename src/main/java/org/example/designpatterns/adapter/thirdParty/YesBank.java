package org.example.designpatterns.adapter.thirdParty;

public class YesBank {
    public void transferMoney(String from, String to, double amount) {
        System.out.println("YB transferring money API");
    }

    public double getBalance(String accountNumber) {
        System.out.println("YB get Balance API");
        return 0.0;
    }

    public void registerAcc(String phone) {
        System.out.println("YB register account");
    }
}
