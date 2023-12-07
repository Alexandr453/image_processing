package ru.nikitin;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nikitin.config.ImageType;
import ru.nikitin.models.Point;
import ru.nikitin.utils.CvUtils;

import java.awt.*;

import static org.opencv.imgcodecs.Imgcodecs.*;

public class MatchTemplate {

//    private static ViewPort viewPort;



    private static final Logger LOG = LoggerFactory.getLogger(MatchTemplate.class);

    public static void main(String[] args) {
//        MatchTemplate m = new MatchTemplate(
//                ImageType.CURRENT_SCREEN,
//                ImageType.CHARACTER_ARENA,
//                false);

        MatchTemplate m = new MatchTemplate(
                new GaussianFilter(ImageType.CURRENT_SCREEN).getBlurredImage(),
                new GaussianFilter(ImageType.CHARACTER_ARENA).getBlurredImage()
        );
    }

    private Mat screen;
    private Mat img;
    private boolean isMatched = false;
    private Core.MinMaxLocResult data;
    private Size imgSize;
    private Point coord;
    private int scale;

    public static final double THRESHHOLD = 0.08;


    public MatchTemplate(ImageType screen, ImageType img, boolean isRGB) {
        if(isRGB) {
            this.screen = Imgcodecs.imread(screen.getPath(), IMREAD_REDUCED_COLOR_4);
            this.img = Imgcodecs.imread(img.getPath(), IMREAD_REDUCED_COLOR_4);
        }else {
            this.screen = Imgcodecs.imread(screen.getPath(), IMREAD_REDUCED_GRAYSCALE_4);
            this.img = Imgcodecs.imread(img.getPath(), IMREAD_REDUCED_GRAYSCALE_4);
        }

//        viewPort.show(Imgcodecs.imread(screen.getPath(), IMREAD_UNCHANGED));

        this.imgSize = this.img.size();
        this.scale = 4;

//        Imgcodecs.imwrite(screen.getPath(), this.screen);
//        Imgcodecs.imwrite(img.getPath(), this.img);

        this.findImg();
        this.formResultCoord();
    }

    public MatchTemplate(Mat screen, Mat img) {
        this.screen = screen;
        this.img = img;

//        Mat image = Imgcodecs.imread(ImageType.CURRENT_SCREEN.getPath(), IMREAD_UNCHANGED);

//        Imgproc.rectangle(
//                image,
//                new org.opencv.core.Point(50, 230),
//                new org.opencv.core.Point(250, 280),
//                new Scalar(100.0, 100.0, 100.0),
//                Core.FILLED);
//
//        viewPort.show(image);

        this.imgSize = this.img.size();
        this.scale = 4;

        this.findImg();
        this.formResultCoord();
    }

    private void findImg() {
        Mat result = new Mat();
        Imgproc.matchTemplate(this.screen, this.img, result, Imgproc.TM_SQDIFF_NORMED);
        this.data = Core.minMaxLoc(result);
        LOG.info("{} ({} {})", this.data.minVal, this.data.minLoc.x * this.scale, this.data.minLoc.y * this.scale);
        if(this.data.minVal < THRESHHOLD) {
            this.isMatched = true;
        }else {
            this.isMatched = false;
        }
    }

    private void formResultCoord() {
        if(this.isMatched) {
            this.coord = new Point((int)(this.data.minLoc.x * this.scale) + (int)this.imgSize.width*this.scale/2,
                    (int)(this.data.minLoc.y * this.scale) + (int)this.imgSize.height*this.scale/2);
        }else {
            this.coord = new Point(0,0);
        }
    }

    public Point getPoint() {
        return this.coord;
    }

    public boolean isMatched() {
        return isMatched;
    }
}
