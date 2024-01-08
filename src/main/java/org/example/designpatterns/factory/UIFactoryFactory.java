package org.example.designpatterns.factory;

import org.example.designpatterns.factory.components.button.AndroidButton;
import org.example.designpatterns.factory.components.button.IOSButton;

public class UIFactoryFactory {
    public static UIFactory getUIFactoryForPlatform(SupportedPlatforms platform) {
        if (platform.equals(SupportedPlatforms.ANDROID)) {
            return new AndroidUIFactory();
        } else if (platform.equals(SupportedPlatforms.WINDOWS)) {
            return new WindowsUIFactory();
        } else if (platform.equals(SupportedPlatforms.IOS)) {
            return new IOSUIFactory();
        }
        return null;
    }
}
