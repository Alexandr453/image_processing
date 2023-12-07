package ru.nikitin.search_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nikitin.FindObj;
import ru.nikitin.config.ImageType;
import ru.nikitin.models.Point;

public class Icons {

    private static final Logger LOG = LoggerFactory.getLogger(Icons.class);

    public static boolean findClose() {
        LOG.info("Finding close button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.SHOP_CLOSE)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of close button")
                .handleTimeout(true)
                .find();
    }

    public static boolean findCloseAlt() {
        LOG.info("Finding close button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.SHOP_CLOSE_ALT)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of close button")
                .handleTimeout(true)
                .find();
    }

    public static boolean findCharArena() {
        LOG.info("Finding character arena...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.CHARACTER_ARENA)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of character arena")
                .handleTimeout(true)
                .find();
    }

    public static boolean findFleetArena() {
        LOG.info("Finding fleet arena...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.FLEET_ARENA)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of fleet arena")
                .handleTimeout(true)
                .find();
    }

    public static boolean findChooseBattle() {
        LOG.info("Finding choose battle arena...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.CHOOSE_BATTLE)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of choose battle button")
                .handleTimeout(true)
                .find();
    }

    public static boolean findBattle() {
        LOG.info("Finding battle button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.BATTLE)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of battle button")
                .handleTimeout(true)
                .find();
    }

    public static boolean findSettings() {
        LOG.info("Finding settings button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.SETTINGS)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of settings button")
                .handleTimeout(true)
                .find();
    }

    public static boolean findGiveUp() {
        LOG.info("Finding give up button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.GIVE_UP)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of give up button")
                .handleTimeout(true)
                .find();
    }

    public static boolean findYes() {
        LOG.info("Finding yes button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.YES)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of yes button")
                .handleTimeout(true)
                .find();
    }

    public static boolean findChallenges() {
        LOG.info("Finding challenges table...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.CHALLENGES)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of challenges table")
                .handleTimeout(true)
                .setOffset(new Point(0, -140))
                .setTimeout(15)
                .find();
    }

    public static boolean findCoupons() {
        LOG.info("Finding coupons button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.COUPONS)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of coupons button")
                .handleTimeout(true)
                .find();
    }

    public static boolean findCouponsGW() {
        LOG.info("Finding coupons gw button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.COUPONS_GW)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of coupons gw button")
                .handleTimeout(true)
                .setTimeout(30)
                .find();
    }

    public static boolean findSpendCoupons() {
        LOG.info("Finding spend coupons button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.SPEND_COUPONS)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of spend coupons button")
                .handleTimeout(true)
                .find();
    }

    public static boolean findNext() {
        LOG.info("Finding next button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.NEXT)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of next button")
                .handleTimeout(true)
                .setTimeout(15)
                .find();
    }

    public static boolean findHome() {
        LOG.info("Finding home button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.HOME)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of home button")
                .handleTimeout(true)
                .setTimeout(30)
                .find();
    }

    public static boolean findShips() {
        LOG.info("Finding ships...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.SHIPS)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of ships")
                .handleTimeout(true)
                .setTimeout(15)
                .find();
    }

    public static boolean findFleetChallenges() {
        LOG.info("Finding fleet challenges...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.FLEET_CHALLENGES)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of fleet challenges")
                .handleTimeout(true)
                .setOffset(new Point(0, -100))
                .setTimeout(15)
                .find();
    }

    public static boolean findGalacticBattles() {
        LOG.info("Finding galactic battles...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.GALACTIC_BATTLES)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of galactic battles")
                .handleTimeout(true)
                .setTimeout(15)
                .find();
    }

    public static boolean findParticipateGW() {
        LOG.info("Finding participate in gw...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.PARTICIPATE_GW)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of participate in gw")
                .handleTimeout(true)
                .find();
    }

    public static boolean findReload() {
        LOG.info("Finding reload...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.RELOAD)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of reload")
                .handleTimeout(true)
                .setTimeout(30)
                .find();
    }

    public static boolean findGet() {
        LOG.info("Finding get button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.GET)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of get button")
                .handleTimeout(true)
                .setTimeout(10)
                .find();
    }

    public static boolean findBack() {
        LOG.info("Finding back button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.BACK)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of back button")
                .handleTimeout(true)
                .find();
    }

    public static boolean findSwgohIcon() {
        LOG.info("Finding swgoh icon...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.SWGOH_ICON)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of SWGOH icon")
                .handleTimeout(true)
                .setTimeout(3*60)
                .find();
    }

    public static boolean findObjectives() {
        LOG.info("Finding objectives button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.OBJECTIVES)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("This is objectives button!")
                .handleTimeout(true)
                .find();
    }

    public static boolean findArenaTable() {
        LOG.info("Finding arena table...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(ImageType.ARENA_TABLE)
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Arena table here")
                .handleTimeout(true)
                .setTimeout(30)
                .find();
    }
}
