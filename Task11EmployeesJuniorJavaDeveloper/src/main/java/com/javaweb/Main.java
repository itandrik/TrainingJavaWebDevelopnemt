package com.javaweb;

import com.javaweb.controller.Controller;
import com.javaweb.model.Model;
import com.javaweb.view.View;

/**
 * @author Andrii Chernysh;
 *         E-MAIL : itcherry97@gmail.com;
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model,view);
        controller.processUser();
    }
}
