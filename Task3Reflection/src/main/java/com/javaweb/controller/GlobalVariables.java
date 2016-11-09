package com.javaweb.controller;

/**
 * Here are some intefface with constants for our
 * controller. Mostly here are only some matrix and
 * linear systems.
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 09 Nov 2016
 */
public interface GlobalVariables {
    double[][] ARRAY_MATRIX = {
            {14, 7, 18, 12},
            {3, 38, 20, 14},
            {0, 7, 19, 11},
            {1, 18, 6, 3}
    };

    double[] COLUMN_FREE_TERMS = {139, 222, 111, -83};
}
