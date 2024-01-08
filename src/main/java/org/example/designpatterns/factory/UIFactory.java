package org.example.designpatterns.factory;


import org.example.designpatterns.factory.components.button.Button;
import org.example.designpatterns.factory.components.menu.Menu;

public interface UIFactory {
    Button createButton(); //factory method

    Menu createMenu(); //factory method

    //createDropDown();
}
