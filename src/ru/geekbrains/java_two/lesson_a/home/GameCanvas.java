package ru.geekbrains.java_two.lesson_a.home;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


public class GameCanvas extends JPanel {

    private MainCircles controller;
    long lastFrameTime;
    private static final int FPS_SLEEP_TIME = 17;

    private static final int timeChange = 1;    //время через которое меняется цвет в секундах

    GameCanvas(MainCircles controller) {
        this.controller = controller;
        lastFrameTime = System.nanoTime();

        TimerTask timer = new TimerTask() {
            @Override
            public void run() {
                Background.ChangeColor();
            }
        };
        Timer timer1 = new Timer(true);
        //запускается каждые timeChange секунд
        timer1.scheduleAtFixedRate(timer, 0, timeChange * 1000);

    }

    @Override
    protected void paintComponent(Graphics g) { // while (true) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();

        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = currentTime;



        try {
            Thread.sleep(FPS_SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();                              // }
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}
