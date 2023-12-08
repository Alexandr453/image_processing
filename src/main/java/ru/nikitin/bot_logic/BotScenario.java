package ru.nikitin.bot_logic;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nikitin.FindObj;
import ru.nikitin.Mouse;
import ru.nikitin.TimeoutedLoop;
import ru.nikitin.config.ImageType;
import ru.nikitin.search_service.Icons;
import ru.nikitin.search_service.Screens;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import static com.sun.jna.platform.win32.WinUser.SW_MAXIMIZE;

public class BotScenario {

    private static final Logger LOG = LoggerFactory.getLogger(BotScenario.class);

    public static boolean findBackRewards() {
        LOG.info("Finding back or next button...");
        FindObj findObj = new FindObj();
        return findObj.setScr(ImageType.CURRENT_SCREEN)
                .setImg(List.of(ImageType.BACK, ImageType.NEXT))
                .applyBlur(true)
                .once(false)
                .setClick(true)
                .setMsg("Coordinates of back or next button")
                .handleTimeout(true)
                .setTimeout(30)
                .findMOR();
    }

    public static boolean blueStacksStart() {
        LOG.info("Application is starting.");

        ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\BlueStacks_nxt\\HD-Player.exe");
        Process p = null;
        try {
            p = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long id = p.pid();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WinDef.HWND hwnd = User32.INSTANCE.FindWindow(null, blueStacksText);

        if (hwnd == null) {
            LOG.info("Application not found!");
            return false;
        }

        User32.INSTANCE.ShowWindow(hwnd, SW_MAXIMIZE );
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean getRewards() throws Exception {
        /*
        TODO: В случае, когда все награды собраны (таймаут поиска GET), ищется или кнопка далее или кнопка назад.
         Так вот, если была обнаружена кнопка далее, необходимо нажать на кнопку назад, если обнаружена кнопка назад,
          то ничего делать не надо
         */
        if(Screens.isMainScreen()) {
            boolean objectives = Icons.findObjectives();
            if(objectives) {
                if(Screens.isDailyScreen()) {
                    LocalTime startSearchTime = LocalTime.now();
                    LocalTime timeoutThreshold = startSearchTime.plusSeconds(60);
                    while(true) {
                        if(startSearchTime.compareTo(timeoutThreshold) > 0) {
//                    LOG.info("Timeout occurs!\n");
                            System.out.println("Timeout occurs in loop!");
                            break;
                        }
                        startSearchTime = LocalTime.now();
                        Icons.findGet();
                    }
                    boolean next = Icons.findNext();
                    Icons.findHome();
                }
            }else {

            }
        }else {

        }
        return true;
    }

    public static boolean doChallenges() throws Exception {
        if(Screens.isMainScreen()) {

            boolean findChallenges = new TimeoutedLoop(
                    () -> Icons.findChallenges(),
                    () -> {
                        Mouse.dragLeft();
                        Thread.sleep(2000);
                        return null;
                    }).start();

            if(findChallenges) {
                if(Screens.isChallengesScreen()) {
                    boolean coupons = Icons.findCoupons();
                    if(coupons) {
                        if(Screens.isBattleCouponsScreen()) {
                            Icons.findSpendCoupons();
                            Thread.sleep(2000);
                            Icons.findNext();
                            Thread.sleep(2000);
                            Icons.findBack();
                            Thread.sleep(2000);
                        }
                    }
                }
            }else {
                LOG.info("Challenges table not found");
                return false;
            }
        }else {
            return false;
        }
        return true;
    }

    public static boolean doGalacticBattles() throws Exception {
        if(Screens.isMainScreen()) {

            boolean findGalacticBattles = new TimeoutedLoop(
                    () -> Icons.findGalacticBattles(),
                    () -> {
                        Mouse.dragRight();
                        Thread.sleep(2000);
                        return null;
                    }).start();
            if(findGalacticBattles) {
                if(Screens.isGalacticBattlesScreen()) {
                    boolean participateGW = Icons.findParticipateGW();
                    if(participateGW) {
                        if(Screens.isGalacticBattlesScreen2()) {
                            Icons.findReload();
                            Thread.sleep(2000);
                            Icons.findCouponsGW();
                            Thread.sleep(2000);
                            if(Screens.isBattleCouponsScreen()) {
                                Icons.findSpendCoupons();
                                Thread.sleep(2000);
                                Icons.findNext();
                                Thread.sleep(2000);
                                Icons.findClose();
                                Thread.sleep(2000);
                            }
                        }
                    }
                }
            }else {
                LOG.info("Galactic battles not found");
                return false;
            }
        }else {
            return false;
        }
        return true;
    }

    public static boolean doShipChallenges() throws Exception {
        if(Screens.isMainScreen()) {

            boolean findShips = new TimeoutedLoop(
                    () -> Icons.findShips(),
                    () -> {
                        Mouse.dragRight();
                        Thread.sleep(2000);
                        return null;
                    }).start();
            if(findShips) {
                if(Screens.isShipsScreen()) {
                    boolean fleetChallenges = Icons.findFleetChallenges();
                    if(fleetChallenges) {
                        if(Screens.isFleetChallengesScreen()) {
                            boolean coupons = Icons.findCoupons();
                            if(coupons) {
                                if(Screens.isBattleCouponsScreen()) {
                                    Icons.findSpendCoupons();
                                    Thread.sleep(2000);
                                    Icons.findNext();
                                    Thread.sleep(2000);
                                    Icons.findBack();
                                    Thread.sleep(2000);
                                    Icons.findHome();
                                    Thread.sleep(2000);
                                }
                            }
                        }
                    }
                }
            }else {
                LOG.info("Ships screen not found");
                return false;
            }
        }else {
            return false;
        }
        return true;
    }

    public static boolean doCharArenaDaily() throws Exception {
        if(Screens.isMainScreen()) {

            boolean findArenaTable = Icons.findArenaTable();
            if(findArenaTable) {
                if(Screens.isArenaScreen()) {
                    Icons.findCharArena();
                    Thread.sleep(2000);
                    if(Screens.isCharArenaScreen()) {
                        Icons.findChooseBattle();
                        Thread.sleep(2000);
                        if(Screens.isSquadChoiceScreen()) {
                            Icons.findBattle();
                            Thread.sleep(2000);
                            if(Screens.isBattleScreen()) {
                                Icons.findSettings();
                                Thread.sleep(2000);
                                Icons.findGiveUp();
                                Thread.sleep(2000);
                                Icons.findYes();
                                Thread.sleep(2000);
                                if(Screens.isCharArenaScreen()) {
                                    Icons.findHome();
                                }
                            }
                        }
                    }
                }
            }else {
                LOG.info("Arena table not found");
                return false;
            }
        }else {
            return false;
        }
        return true;
    }

    public static boolean doFleetArenaDaily() throws Exception {
        if(Screens.isMainScreen()) {

            boolean findArenaTable = Icons.findArenaTable();
            if(findArenaTable) {
                if(Screens.isArenaScreen()) {
                    Icons.findFleetArena();
                    Thread.sleep(2000);
                    if(Screens.isFleetArenaScreen()) {
                        Icons.findChooseBattle();
                        Thread.sleep(2000);
                        if(Screens.isFleetSquadChoiceScreen()) {
                            Icons.findBattle();
                            Thread.sleep(2000);
                            if(Screens.isBattleScreen()) {
                                Icons.findSettings();
                                Thread.sleep(2000);
                                Icons.findGiveUp();
                                Thread.sleep(2000);
                                Icons.findYes();
                                Thread.sleep(2000);
                                if(Screens.isFleetArenaScreen()) {
                                    Icons.findHome();
                                }
                            }
                        }
                    }
                }
            }else {
                LOG.info("Arena table not found");
                return false;
            }
        }else {
            return false;
        }
        return true;
    }

    private static final String blueStacksClassName = "QT5154QWINDOWOWNDCICON";
    private static final String blueStacksText = "BlueStacks App Player";

    public static void main(String[] args) throws Exception {

        blueStacksStart();
        Icons.findSwgohIcon();

        doCharArenaDaily();
        doFleetArenaDaily();
//        doChallenges();
//        doGalacticBattles();
//        doShipChallenges();

//        getRewards();

        LOG.info("Application is stopping, may be ViewPort still working...");
    }
}
