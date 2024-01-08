package org.example.designpatterns.factory;

import org.example.designpatterns.factory.components.button.Button;
import org.example.designpatterns.factory.components.menu.Menu;

public class Client {
    public static void main(String[] args) {
        Flutter flutter = new Flutter();
        UIFactory uiFactory = flutter.getUIFactory(SupportedPlatforms.WINDOWS);

        Button button = uiFactory.createButton();
        Menu menu = uiFactory.createMenu();

        button.click();
        menu.checkMenu();
    }
}
