package org.example.designpatterns.factory;

import org.example.designpatterns.factory.components.button.Button;
import org.example.designpatterns.factory.components.button.WindowsButton;
import org.example.designpatterns.factory.components.menu.Menu;
import org.example.designpatterns.factory.components.menu.WindowsMenu;

public class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }
}
