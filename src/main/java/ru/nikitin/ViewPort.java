package ru.nikitin;

import org.opencv.core.Mat;
import ru.nikitin.utils.CvUtils;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ViewPort {

    public static void main(String[] args) throws InterruptedException {
        ViewPort viewPort = ViewPort.getInstance(1000, 800);
        while(true) {
            Thread.sleep(200);
            viewPort.show(Screenshot.grabScreen());
            System.out.println("Width - " + viewPort.getWidth());
            System.out.println("Height - " + viewPort.getHeight());
        }
    }

    private static ViewPort instance;
    private JFrame window;
    private int width;
    private int height;

    public static ViewPort getInstance(int w, int h) {
        if(instance == null) {
            instance = new ViewPort(w, h);
        }
        return instance;
    }

    private ViewPort(int width, int height) {
        this.width = width;
        this.height = height;
        this.init();
    }

    private void init() {
        this.window = new JFrame("");
        this.window.setSize(this.width, this.height);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setResizable(true);
    }

    public void show(BufferedImage image) {
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon);
        JPanel panel = new JPanel();
        panel.add(label);
        window.add(panel);
        window.setVisible(true);
    }

    public void show(Mat image) {
        BufferedImage bufferedImage = CvUtils.MatToBufferedImage(image);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JLabel label = new JLabel(imageIcon);
        JPanel panel = new JPanel();
        panel.add(label);
        window.add(panel);
        window.setVisible(true);
    }

    public int getWidth() {
        return this.window.getSize().width;
    }

    public int getHeight() {
        return this.window.getSize().height;
    }
}
