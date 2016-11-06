package com.javaweb.entity;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validator.java
 * <p>
 * It is class for validating rows of data using
 * Pattern and Matcher class.
 * This class has been created using Singleton pattern.
 * This is "On Demand Holder idiom" variant.
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 06 Nov 2016
 */
public class Validator {
    /**
     * Creating finalise instance inside inner static
     * holder class.
     */
    public static class ValidatorHolder {
        public static final Validator HOLDER_INSTANCE = new Validator();
    }

    /**
     * Getting instance of our class. it will be the only one.
     *
     * @return Validator instance.
     */
    public static Validator getInstance() {
        return ValidatorHolder.HOLDER_INSTANCE;
    }

    /**
     * @param matcher - instance of Matcher class with some Pattern
     * @return - logical value is our string valid or not
     */
    public boolean isValid(Matcher matcher) {
        return matcher.matches();
    }

    /**
     * It works longer. To be sure just look at this realisation.
     * I create Matcher instance not so many times.
     * But this variant also looks pretty.
     *
     * @param inputValue - string, that wee need to validate.
     * @param regexp     - regular expression for matching
     * @return - logical value is our string valid or not
     */
    public boolean isValid(String inputValue, String regexp) {
        return Pattern.matches(regexp, inputValue);
    }
}
