package ru.nikitin;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class TimeoutedLoop {

    private Callable conditionalFunc;
    private Callable doFunc;


    public TimeoutedLoop(Callable conditionalFunc, Callable doFunc) {
        this.conditionalFunc = conditionalFunc;
        this.doFunc = doFunc;
    }

    public boolean start() throws Exception {
        LocalTime startSearchTime = LocalTime.now();
        LocalTime timeoutThreshold = startSearchTime.plusSeconds(60);
        while(!(boolean) conditionalFunc.call()) {
            if(startSearchTime.compareTo(timeoutThreshold) > 0) {
//                    LOG.info("Timeout occurs!\n");
                System.out.println("Timeout occurs in loop!");
                return false;
            }
            startSearchTime = LocalTime.now();
            doFunc.call();
        }
        return true;
    }
}
