package org.example.designpatterns.factory.components.button;

public class WindowsButton implements Button {
    @Override
    public void click() {
        System.out.println("Windows Button");
    }
}
