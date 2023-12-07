package ru.nikitin;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nikitin.config.ImageType;
import ru.nikitin.models.Point;
import ru.nikitin.utils.CvUtils;
import ru.nikitin.utils.MathUtil;

import java.awt.image.BufferedImage;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FindObj {

    private static final Logger LOG = LoggerFactory.getLogger(FindObj.class);
    private static ViewPort viewPort;

    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        viewPort = ViewPort.getInstance(1000, 800);
    }

    public static void main(String[] args) {

        FindObj findObj = new FindObj();
        findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.BATTLE)
                .applyBlur(false)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of character arena")
                .handleTimeout(true)
                .find();
    }

    private ImageType screen;
    private List<ImageType> imgs;
    private ImageType img;
    private String msg;
    private boolean applyBlur = false;
    private boolean isOnce = false;
    private boolean doClick = false;
    private boolean handleTimeout = false;
    private Point defaultOffset = new Point(0, 0);
    private int defaultTimeOut = 1*60; // 1 минута - таймаут по умолчанию

    public FindObj() {

    }

    public FindObj setScr(ImageType screen) {
        this.screen = screen;
        return this;
    }

    public FindObj setImg(ImageType img) {
        this.img = img;
        return this;
    }

    public FindObj setImg(List<ImageType> imgs) {
        this.imgs = imgs;
        return this;
    }

    public FindObj applyBlur(boolean applyBlur) {
        this.applyBlur = applyBlur;
        return this;
    }

    public FindObj once(boolean isOnce) {
        this.isOnce = isOnce;
        return this;
    }

    public FindObj setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public FindObj setClick(boolean doClick) {
        this.doClick = doClick;
        return this;
    }

    public FindObj handleTimeout(boolean handleTimeout) {
        this.handleTimeout = handleTimeout;
        return this;
    }

    public FindObj setTimeout(int seconds) {
        this.defaultTimeOut = seconds;
        return this;
    }

    public FindObj setOffset(Point offset) {
        this.defaultOffset = offset;
        return this;
    }

    public boolean find() {
        MatchTemplate findImg = null;
        LocalTime startSearchTime = LocalTime.now();

        LocalTime timeoutThreshold = startSearchTime.plusSeconds(this.defaultTimeOut);
        while(true) {
            if(startSearchTime.compareTo(timeoutThreshold) > 0 && this.handleTimeout) {
                LOG.info("Timeout occurs!\n");
                return false;
            }

            LOG.info("Finding {}...", this.img.name());

            startSearchTime = LocalTime.now();

            BufferedImage bi = Screenshot.screenShot();

            Mat m = CvUtils.BufferedImageToMat(bi);
            Imgproc.rectangle(
                m,
                new org.opencv.core.Point(50, 50),
                new org.opencv.core.Point(500, 500),
                new Scalar(100.0, 100.0, 100.0),
                    Core.FILLED);

            viewPort.show(m);


            if(this.applyBlur) {
                findImg = new MatchTemplate(
                        new GaussianFilter(this.screen).getBlurredImage(),
                        new GaussianFilter(this.img).getBlurredImage()
                );
            }else {
                findImg = new MatchTemplate(
                        this.screen,
                        this.img,
                        true
                );
            }

            if(findImg.isMatched()) {
                LOG.info("Match occurs!\n");
                LOG.debug(this.msg + " :{}", findImg.getPoint());
                //для теста
                Point p = new Point(
                        findImg.getPoint().getX() + this.defaultOffset.getX(),
                        findImg.getPoint().getY() + this.defaultOffset.getY()
                );
                if(this.doClick) {
                    Mouse.moveAndClick(p);
                }else {
                    Mouse.move(p);
                }
                return true;
            }else {
                LOG.info("Match isn't occur, waiting...\n");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(this.isOnce) {
                return findImg.isMatched();
            }
        }
    }

    /*
    Поиск нескольких изображений на экране. Выход из функции при первом совпадении
     */
    public boolean findMOR() {
        if(this.imgs == null) {
            LOG.info("Не задан лист изображений");
            return false;
        }

        List<MatchTemplate> findImgs = new ArrayList<>();
        LocalTime startSearchTime = LocalTime.now();

        LocalTime timeoutThreshold = startSearchTime.plusSeconds(this.defaultTimeOut);
        while(true) {
            if(startSearchTime.compareTo(timeoutThreshold) > 0 && this.handleTimeout) {
                LOG.info("Timeout occurs!\n");
                return false;
            }

            startSearchTime = LocalTime.now();

            BufferedImage bi = Screenshot.screenShot();

            Mat mainScreen = new GaussianFilter(this.screen).getBlurredImage();
            for (int i = 0; i < this.imgs.size(); i++) {

                LOG.info("Finding {}...", this.imgs.get(i).name());

                MatchTemplate findImg = null;

                if(this.applyBlur) {
                    findImg = new MatchTemplate(
                            mainScreen,
                            new GaussianFilter(this.imgs.get(i)).getBlurredImage()
                    );
                }else {
                    findImg = new MatchTemplate(
                            this.screen,
                            this.imgs.get(i),
                            true
                    );
                }
                findImgs.add(findImg);

                if(findImg.isMatched()) {
                    LOG.info("Match occurs!\n");
                    LOG.info(this.msg + " :{}", findImg.getPoint());
                    //для теста
                    Point p = new Point(
                            findImg.getPoint().getX() + this.defaultOffset.getX(),
                            findImg.getPoint().getY() + this.defaultOffset.getY()
                    );
                    if(this.doClick) {
                        Mouse.moveAndClick(p);
                    }else {
                        Mouse.move(p);
                    }
                    return true;
                }else {
                    LOG.info("Match isn't occur, waiting...\n");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(this.isOnce) {
                    return findImgs.get(i).isMatched();
                }
            }
        }
    }

    public boolean findMAND() {
        if(this.imgs == null) {
            LOG.info("Не задан лист изображений");
            return false;
        }

        List<MatchTemplate> findImgs = new ArrayList<>();
        LocalTime startSearchTime = LocalTime.now();

        LocalTime timeoutThreshold = startSearchTime.plusSeconds(this.defaultTimeOut);
        while(true) {
            if(startSearchTime.compareTo(timeoutThreshold) > 0 && this.handleTimeout) {
                LOG.info("Timeout occurs!\n");
                return false;
            }

            startSearchTime = LocalTime.now();

            BufferedImage bi = Screenshot.screenShot();

            Mat mainScreen = new GaussianFilter(this.screen).getBlurredImage();
            boolean[] results = new boolean[this.imgs.size()];

            for (int i = 0; i < this.imgs.size(); i++) {

                LOG.info("Finding {}...", this.imgs.get(i).name());

                MatchTemplate findImg = null;

                if(this.applyBlur) {
                    findImg = new MatchTemplate(
                            mainScreen,
                            new GaussianFilter(this.imgs.get(i)).getBlurredImage()
                    );
                }else {
                    findImg = new MatchTemplate(
                            this.screen,
                            this.imgs.get(i),
                            true
                    );
                }
                findImgs.add(findImg);

                if(findImg.isMatched()) {
                    LOG.info("Match occurs!\n");
                    LOG.info(this.msg + " :{}", findImg.getPoint());
                    //для теста
                    Point p = new Point(
                            findImg.getPoint().getX() + this.defaultOffset.getX(),
                            findImg.getPoint().getY() + this.defaultOffset.getY()
                    );
                    results[i] = true;
                    if(this.doClick) {
                        Mouse.moveAndClick(p);
                    }else {
                        Mouse.move(p);
                    }
                }else {
                    LOG.info("Match isn't occur, waiting...\n");
                    results[i] = false;
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(this.isOnce) {
                    return findImgs.get(i).isMatched();
                }
            }
            if(MathUtil.isAllTrue(results)) {
                LOG.info("All marks are found\n");
                return true;
            }
        }
    }
}
