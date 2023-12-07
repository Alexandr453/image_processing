package ru.nikitin;

import java.awt.*;
import java.awt.event.InputEvent;
import ru.nikitin.models.Point;

public class Mouse {

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static final Point CENTER = new Point(WIDTH/2, HEIGHT/2);

    public static Robot init() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return robot;
    }

    public static Robot move(Point p) {
        Robot robot = init();
        robot.mouseMove(p.getX(), p.getY());
        return robot;
    }

    public static Robot moveAndClick(Point p) {
        Robot robot = move(p);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        return robot;
    }

    public static Robot moveCenter(Robot robot) {
        robot.mouseMove(CENTER.getX(), CENTER.getY());
        return robot;
    }

    public static void dragLeft() {
        Robot robot = moveCenter(init());
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

        for (int i = 0; i < (WIDTH - 10) - WIDTH/2; i = i + 10) {

            robot.mouseMove(CENTER.getX() + i, CENTER.getY());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public static void dragRight() {
        Robot robot = moveCenter(init());
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

        for (int i = 0; i < (WIDTH - 10) - WIDTH/2; i = i + 10) {

            robot.mouseMove(CENTER.getX() - i, CENTER.getY());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
