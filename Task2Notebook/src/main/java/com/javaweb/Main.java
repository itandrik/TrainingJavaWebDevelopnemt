package com.javaweb;

import com.javaweb.controller.Controller;
import com.javaweb.entity.Model;
import com.javaweb.view.View;

/**
 * Main.java
 * <p>
 * Start point of the Electronic Notebook.
 * Here we will start controller {@link Controller}
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 06 Nov 2016
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        controller.processUser();
    }
}
