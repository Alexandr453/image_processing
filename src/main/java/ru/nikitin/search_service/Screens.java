package ru.nikitin.search_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nikitin.FindObj;
import ru.nikitin.config.ImageType;

import java.util.List;

public class Screens {

    private static final Logger LOG = LoggerFactory.getLogger(Screens.class);

    public static boolean isArenaScreen() {
        LOG.info("Finding arena screen marks...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg( List.of(ImageType.SHOP_CLOSE, ImageType.ARENA_MARK1, ImageType.ARENA_MARK2) )
                .applyBlur(true)
                .once(false)
                .setClick(false)
                .setMsg("This is the arena screen!")
                .handleTimeout(true)
                .setTimeout(30)
                .find(FindObj.MODE_AND);
    }

    public static boolean isCharArenaScreen() {
        LOG.info("Finding character arena screen marks...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg( List.of(ImageType.REFRESH, ImageType.POSITIONS, ImageType.CHAR_CURRENCY) )
                .applyBlur(true)
                .once(false)
                .setClick(false)
                .setMsg("This is the character arena screen!")
                .handleTimeout(true)
                .setTimeout(30)
                .find(FindObj.MODE_AND);
    }

    public static boolean isFleetArenaScreen() {
        LOG.info("Finding fleet arena screen marks...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg( List.of(ImageType.REFRESH, ImageType.POSITIONS, ImageType.FLEET_CURRENCY) )
                .applyBlur(true)
                .once(false)
                .setClick(false)
                .setMsg("This is the fleet arena screen!")
                .handleTimeout(true)
                .setTimeout(30)
                .find(FindObj.MODE_AND);
    }

    public static boolean isSquadChoiceScreen() {
        LOG.info("Finding squad choice screen marks...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg( List.of(ImageType.SQUAD_POWER, ImageType.AGAINST, ImageType.BACK) )
                .applyBlur(true)
                .once(false)
                .setClick(false)
                .setMsg("This is the squad choice screen!")
                .handleTimeout(true)
                .setTimeout(30)
                .find(FindObj.MODE_AND);
    }

    public static boolean isFleetSquadChoiceScreen() {
        LOG.info("Finding fleet squad choice screen marks...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg( List.of(ImageType.FLEET_SQUAD_POWER, ImageType.FLEET_SQUAD_MARK, ImageType.BACK) )
                .applyBlur(true)
                .once(false)
                .setClick(false)
                .setMsg("This is the fleet squad choice screen!")
                .handleTimeout(true)
                .setTimeout(30)
                .find(FindObj.MODE_AND);
    }

    public static boolean isBattleScreen() {
        LOG.info("Finding battle screen marks...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg( List.of(ImageType.CHOOSE, ImageType.EFFECTS_DISPLAY, ImageType.SETTINGS) )
                .applyBlur(true)
                .once(false)
                .setClick(false)
                .setMsg("This is the battle screen!")
                .handleTimeout(true)
                .setTimeout(30)
                .find(FindObj.MODE_AND);
    }

    public static boolean isShipsScreen() {
        LOG.info("Finding ships screen marks...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg( List.of(ImageType.BACK, ImageType.FLEET_BATTLES, ImageType.FLEET_ARENA_ALT) )
                .applyBlur(true)
                .once(false)
                .setClick(false)
                .setMsg("This is the ships screen!")
                .handleTimeout(true)
                .setTimeout(30)
                .find(FindObj.MODE_AND);
    }

    public static boolean isFleetChallengesScreen() {
        LOG.info("Finding fleet challenges screen marks...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg( List.of(ImageType.BACK, ImageType.SHIPS_ICON, ImageType.COUPONS) )
                .applyBlur(true)
                .once(false)
                .setClick(false)
                .setMsg("This is the fleet challenges screen!")
                .handleTimeout(true)
                .setTimeout(30)
                .find(FindObj.MODE_AND);
    }

    public static boolean isChallengesScreen() {
        LOG.info("Finding challenges screen marks...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg( List.of(ImageType.BACK, ImageType.CHALLENGES_ICON) )
                .applyBlur(true)
                .once(false)
                .setClick(false)
                .setMsg("This is the challenges screen!")
                .handleTimeout(true)
                .setTimeout(30)
                .find(FindObj.MODE_AND);
    }

    public static boolean isBattleCouponsScreen() {
        LOG.info("Finding battle coupons screen marks...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg( List.of(ImageType.SPEND_COUPONS, ImageType.SHOP_CLOSE) )
                .applyBlur(true)
                .once(false)
                .setClick(false)
                .setMsg("This is the battle coupons screen!")
                .handleTimeout(true)
                .setTimeout(30)
                .find(FindObj.MODE_AND);
    }

    public static boolean isGalacticBattlesScreen() {
        LOG.info("Finding galactic battles screen marks...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg( List.of(ImageType.SHOP_CLOSE, ImageType.GALACTIC_BATTLES_MARK) )
                .applyBlur(true)
                .once(false)
                .setClick(false)
                .setMsg("This is the galactic battles screen!")
                .handleTimeout(true)
                .setTimeout(30)
                .find(FindObj.MODE_AND);
    }

    public static boolean isGalacticBattlesScreen2() {
        LOG.info("Finding galactic battles screen 2 marks...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg( List.of(ImageType.HOME, ImageType.BACK, ImageType.RELOAD) )
                .applyBlur(true)
                .once(false)
                .setClick(false)
                .setMsg("This is the galactic battles screen 2!")
                .handleTimeout(true)
                .setTimeout(30)
                .find(FindObj.MODE_AND);
    }

    public static boolean isDailyScreen() {
        LOG.info("Finding daily screen marks...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg( List.of(ImageType.DAILY_SCREEN_MARK1, ImageType.DAILY_SCREEN_MARK2, ImageType.BACK) )
                .applyBlur(true)
                .once(false)
                .setClick(false)
                .setMsg("This is the daily screen!")
                .handleTimeout(true)
                .setTimeout(30)
                .find(FindObj.MODE_AND);
    }

    public static boolean isMainScreen() {
        LOG.info("Finding main screen marks...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg( List.of(ImageType.SETTINGS, ImageType.OBJECTIVES) )
                .applyBlur(true)
                .once(false)
                .setClick(false)
                .setMsg("This is the main screen!")
                .handleTimeout(true)
                .setTimeout(60*5)
                .find(FindObj.MODE_AND);
    }
}
