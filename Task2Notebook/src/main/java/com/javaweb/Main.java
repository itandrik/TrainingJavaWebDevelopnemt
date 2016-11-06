package com.javaweb;

import com.javaweb.entity.Model;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        controller.processUser();
    }
}
