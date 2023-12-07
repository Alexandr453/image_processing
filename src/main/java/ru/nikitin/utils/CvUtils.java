package ru.nikitin.utils;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import ru.nikitin.Screenshot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class CvUtils {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        BufferedImage screen = Screenshot.grabScreen();
        showImage(screen, "test");
    }

    public static void showImage(BufferedImage img, String title) {
        if (img == null) return;
        int w = 1000, h = 600;
        JFrame window = new JFrame(title);
        window.setSize(w, h);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon(img);
        JLabel label = new JLabel(imageIcon);
        JScrollPane pane = new JScrollPane(label);
        window.setContentPane(pane);
        if (img.getWidth() < w && img.getHeight() < h) {
            window.pack();
        }
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void writeImage(int[][] image, String path) throws IOException {
        int width = image[0].length;
        int height = image.length;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                bi.setRGB(j, i, image[i][j]);
            }
        }

        File outputFile = new File(path);
        ImageIO.write(bi, "png", outputFile);
    }

    public static int[][] get2DPixel(BufferedImage sampleImage) {
        boolean hasAlphaChannel = sampleImage.getAlphaRaster() != null;
        int width = sampleImage.getWidth();
        int height = sampleImage.getHeight();
        int[][] result = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                result[row][col] = sampleImage.getRGB(col, row);
            }
        }
        return result;
    }

    public static void showImage(Mat img, String title) {
        BufferedImage im = MatToBufferedImage(img);
        if (im == null) return;
        int w = 1000, h = 600;
        JFrame window = new JFrame(title);
        window.setSize(w, h);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon(im);
        JLabel label = new JLabel(imageIcon);
        JScrollPane pane = new JScrollPane(label);
        window.setContentPane(pane);
        if (im.getWidth() < w && im.getHeight() < h) {
            window.pack();
        }
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static BufferedImage MatToBufferedImage(Mat m) {
        if (m == null || m.empty()) return null;
        if (m.depth() == CvType.CV_8U) {}
        else if (m.depth() == CvType.CV_16U) { // CV_16U => CV_8U
            Mat m_16 = new Mat();
            m.convertTo(m_16, CvType.CV_8U, 255.0 / 65535);
            m = m_16;
        }
        else if (m.depth() == CvType.CV_32F) { // CV_32F => CV_8U
            Mat m_32 = new Mat();
            m.convertTo(m_32, CvType.CV_8U, 255);
            m = m_32;
        }

        else
            return null;
        int type = 0;
        if (m.channels() == 1)
            type = BufferedImage.TYPE_BYTE_GRAY;
        else if (m.channels() == 3)
            type = BufferedImage.TYPE_3BYTE_BGR;
        else if (m.channels() == 4)
            type = BufferedImage.TYPE_4BYTE_ABGR;
        else
            return null;
        byte[] buf = new byte[m.channels() * m.cols() * m.rows()];
        m.get(0, 0, buf);
        byte tmp = 0;
        if (m.channels() == 4) { // BGRA => ABGR
            for (int i = 0; i < buf.length; i += 4) {
                tmp = buf[i + 3];
                buf[i + 3] = buf[i + 2];
                buf[i + 2] = buf[i + 1];
                buf[i + 1] = buf[i];
                buf[i] = tmp;
            }
        }
        BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
        byte[] data =
                ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(buf, 0, data, 0, buf.length);
        return image;
    }

    public static Mat BufferedImageToMat(BufferedImage img) {

        DataBuffer dataBuffer = img.getRaster().getDataBuffer();
        byte[] imgPixels = null;
        Mat imgMat = null;

        int width = img.getWidth();
        int height = img.getHeight();

        if(dataBuffer instanceof DataBufferByte) {
            imgPixels = ((DataBufferByte)dataBuffer).getData();
        }

        if(dataBuffer instanceof DataBufferInt) {

            int byteSize = width * height;
            imgPixels = new byte[byteSize*3];

            int[] imgIntegerPixels = ((DataBufferInt)dataBuffer).getData();

            for(int p = 0; p < byteSize; p++) {
                imgPixels[p*3 + 0] = (byte) ((imgIntegerPixels[p] & 0x00FF0000) >> 16);
                imgPixels[p*3 + 1] = (byte) ((imgIntegerPixels[p] & 0x0000FF00) >> 8);
                imgPixels[p*3 + 2] = (byte) (imgIntegerPixels[p] & 0x000000FF);
            }
        }

        if(imgPixels != null) {
            imgMat = new Mat(height, width, CvType.CV_8UC3);
            imgMat.put(0, 0, imgPixels);
        }

        return imgMat;
    }
}
