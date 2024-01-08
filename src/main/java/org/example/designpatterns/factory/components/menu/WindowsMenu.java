package org.example.designpatterns.factory.components.menu;

public class WindowsMenu implements Menu {
    @Override
    public void checkMenu() {
        System.out.println("Windows Menu");
    }
}
