package com.javaweb;

import java.io.InputStream;

/**
 * Const.java
 * <p>
 * It is interface for constant values for the game.
 * Here are a lot of Strings, which we will put in external
 * file later. It is made for internationalization.
 * Also here are some integer values to reduce hardcoding.
 *
 * @author Andrii Chernysh {itcherry97@gmail.com}
 * @version 1.0 29 Oct 2016
 */
public interface Const {
    InputStream INPUT_STREAM = System.in;
    int RAND_MAX = 100; // Don't write here :
    int RAND_MIN = 0;   // RAND_MAX < RAND_MIN!!!

    /* Menu items */
    int FIRST_MENU_ITEM = 1;
    int SECOND_MENU_ITEM = 2;
    int THIRD_MENU_ITEM = 3;

    /* Items for statistic Array */
    int INPUT_NUMBER_STATISTIC = 0;
    int LEFT_LIMIT_STATISTIC = 1;
    int RIGHT_LIMIT_STATISTIC = 2;
}
