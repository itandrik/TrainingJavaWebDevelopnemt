package com.javaweb;

import com.javaweb.controller.Controller;
import com.javaweb.view.View;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) {
        View view = new View();
        Controller controller = new Controller(view);
        controller.processUser();
    }
}
