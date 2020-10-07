package ru.geekbrains.java_two.lesson_a.home;

import java.awt.*;


public class Background {
    public static Color color;
    public static void ChangeColor (){
        color = new Color(
                    (int) (Math.random() * 255), // R
                    (int) (Math.random() * 255), // G
                    (int) (Math.random() * 255)  // B
            );
    }

}
