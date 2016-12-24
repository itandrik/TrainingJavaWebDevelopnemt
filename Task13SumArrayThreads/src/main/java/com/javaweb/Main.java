package com.javaweb;


import com.javaweb.controller.Controller;
import com.javaweb.model.SumArray;
import com.javaweb.model.TimeCalculator;
import com.javaweb.view.View;

/**
 * Start point of the program
 *
 * @author Andrii Chernysh;
 *         E-MAIL : itcherry97@gmail.com;
 */
public class Main {
    public static void main( String[] args ) {
        View view = new View();
        SumArray model = new SumArray();
        TimeCalculator time = new TimeCalculator();

        Controller controller = new Controller(view,model,time);
        /* Run */
        controller.processUser();
    }
}
