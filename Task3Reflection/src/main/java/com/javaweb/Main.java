package com.javaweb;

import com.javaweb.controller.Controller;
import com.javaweb.view.View;

/**
 * Starter of our program
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 09 Nov 2016
 */
public class Main
{
    public static void main( String[] args ) {
        /* Creating instance of View */
        View view = new View();
        /* Creating instance of Controller */
        Controller controller = new Controller(view);
        /* Run */
        controller.processUser();
    }
}
