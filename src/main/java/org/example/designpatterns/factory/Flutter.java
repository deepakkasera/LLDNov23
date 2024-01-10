package org.example.designpatterns.factory;

import javax.naming.spi.DirObjectFactory;

public class Flutter {
    //non factory methods.

    void refreshUI() {
        System.out.println("Refreshing UI");
    }

    void setTheme() {
        System.out.println("Setting theme");
    }


    //factory method to connect with UIFactory
    public UIFactory getUIFactory(SupportedPlatforms platform) {
//         if (platform.equals(SupportedPlatforms.ANDROID)) {
//            return new AndroidUIFactory();
//        } else if (platform.equals(SupportedPlatforms.WINDOWS)) {
//            return new WindowsUIFactory();
//        } else if (platform.equals(SupportedPlatforms.IOS)) {
//            return new IOSUIFactory();
//        }
        return UIFactoryFactory.getUIFactoryForPlatform(platform);
    }
}