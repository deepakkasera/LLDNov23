package org.example.designpatterns.factory.components.button;

public class IOSButton implements Button {
    @Override
    public void click() {
        System.out.println("IOS Button");
    }
}
