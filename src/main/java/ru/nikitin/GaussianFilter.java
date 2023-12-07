package ru.nikitin;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import ru.nikitin.config.ImageType;
import ru.nikitin.utils.TextUtils;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_REDUCED_COLOR_4;

public class GaussianFilter {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        new GaussianFilter(ImageType.OBJECTIVES);
    }

    private Mat srcImage;
    private Mat blurredImage;
    private String pathName;

    public GaussianFilter(ImageType imageType) {
        this.srcImage = Imgcodecs.imread(imageType.getPath(), IMREAD_REDUCED_COLOR_4);
        this.pathName = imageType.getPath();
        // с серым
//        Mat gray = setGray();
//        setBlur(gray);

        // без серого
        setBlur(this.srcImage);
    }

    private Mat setGray() {
        Mat gray = new Mat();
        Imgproc.cvtColor(this.srcImage, gray, Imgproc.COLOR_BGR2GRAY);
        this.pathName = TextUtils.setPathSuffix(this.pathName, "gray");
        Imgcodecs.imwrite(this.pathName, gray);
        return gray;
    }

    private void setBlur(Mat m) {
        blurredImage = new Mat();
        Imgproc.GaussianBlur(m, this.blurredImage, new Size(3, 3), 0);
        this.pathName = TextUtils.setPathSuffix(this.pathName, "blur");
        Imgcodecs.imwrite(this.pathName, this.blurredImage);
    }

    public Mat getBlurredImage() {
        return blurredImage;
    }
}
