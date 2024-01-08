package org.example.designpatterns.factory;

import org.example.designpatterns.factory.components.button.Button;
import org.example.designpatterns.factory.components.button.IOSButton;
import org.example.designpatterns.factory.components.menu.IOSMenu;
import org.example.designpatterns.factory.components.menu.Menu;

public class IOSUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }
}
