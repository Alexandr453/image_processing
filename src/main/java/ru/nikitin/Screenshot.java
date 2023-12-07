package ru.nikitin;

import ru.nikitin.config.ImageType;
import ru.nikitin.utils.CvUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Screenshot {

    public static BufferedImage grabScreen() {
        try {
            return new Robot().createScreenCapture(new Rectangle((Toolkit.getDefaultToolkit().getScreenSize().width),
                    (Toolkit.getDefaultToolkit().getScreenSize().height)));
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage screenShot() {
        BufferedImage bi = grabScreen();
        int [][] img = CvUtils.get2DPixel(bi);
        try {
            CvUtils.writeImage(img, ImageType.CURRENT_SCREEN.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }

    public static void main(String[] args) throws IOException {
//        screenShot();
    }
}
