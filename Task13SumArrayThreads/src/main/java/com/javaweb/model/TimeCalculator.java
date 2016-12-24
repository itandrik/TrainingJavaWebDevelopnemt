package com.javaweb.model;

import java.util.logging.Logger;

/**
 * Class, that calculates time of some method execution
 *
 * @author Andrii Chernysh on 24-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class TimeCalculator {
    /**
     * Logger to show some errors with using this class
     */
    private static Logger log = Logger.getLogger(TimeCalculator.class.getName());
    /**
     * Time of starting algorithm execution
     */
    private long startExecutionTime = 0L;
    /**
     * Time of finishing algorithm execution
     */
    private long finishExecutionTime = 0L;
    /**
     * Is using for prevention errors.
     * E.g. Here have to be first {@link #start()}
     * method invocation after {@link #finish()}
     * method invocation
     */
    private boolean isStarted = false;
    /**
     * Is using for prevention errors.
     * E.g. Here have to be first {@link #start()}
     * method invocation after {@link #finish()}
     * method invocation
     */
    private boolean isFinished = false;
    private static final String START_WARNING =
            "Firstly you need to start time calculator";
    private static final String ALREADY_STARTED_WARNING =
            "Time calculator already started";
    private static final String FINISH_WARNING =
            "Firstly you need to finish time calculator";
    private static final String ALREADY_FINISHED_WARNING =
            "Time calculator already finished";

    /**
     * Save time of starting algorithm execution
     */
    public void start() {
        if (isFinished) {
            log.info("Your previous value was : " + getExecutionTime());
            isFinished = false;
        }
        if (!isStarted) {
            startExecutionTime = System.currentTimeMillis();
            isStarted = true;
            isFinished = false;
        } else {
            log.warning(ALREADY_STARTED_WARNING);
        }
    }

    /**
     * Save time of finishing algorithm execution
     */
    public void finish() {
        if (!isStarted) {
            log.warning(START_WARNING);
        } else if (isFinished) {
            log.warning(ALREADY_FINISHED_WARNING);
        } else {
            finishExecutionTime = System.currentTimeMillis();
            isStarted = false;
            isFinished = true;
        }
    }

    /**
     * @return time of execution some algorithm in milliseconds
     */
    public long getExecutionTime() {
        if (isFinished) {
            return finishExecutionTime - startExecutionTime;
        } else {
            log.warning(FINISH_WARNING);
        }
        return 0;
    }
}
