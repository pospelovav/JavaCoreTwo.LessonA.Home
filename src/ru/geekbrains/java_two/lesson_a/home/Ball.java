package ru.geekbrains.java_two.lesson_a.home;

import java.awt.*;

public class Ball extends Sprite {
    //private final Color color;
    private final Color color;
    private float vX;
    private float vY;

    Ball() {
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;

        color = new Color(
                (int) (Math.random() * 255), // R
                (int) (Math.random() * 255), // G
                (int) (Math.random() * 255)  // B
        );
        vX = (float) (100f + (Math.random() * 200f));
        vY = (float) (100f + (Math.random() * 200f));
    }

    @Override
    void update(GameCanvas canvas, float deltaTime) {
        x += vX * deltaTime;//S = vt;
        y += vY * deltaTime;
        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
            //Background.ChangeColor();  //вызов статического метода класса Background смены цвета канвы
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
            //Background.ChangeColor();   //вызов статического метода класса Background смены цвета канвы
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
            //Background.ChangeColor();   //вызов статического метода класса Background смены цвета канвы
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
           //Background.ChangeColor();   //вызов статического метода класса Background смены цвета канвы
        }
    }

    @Override
    void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight()
        );
    }
}
