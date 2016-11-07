package com.javaweb.entity;

import com.javaweb.controller.Const;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(Parameterized.class)
public class ValidatorTest {
    private Validator validator;
    private String inputString;

    public ValidatorTest(String inputString, Pattern pattern) {
        this.inputString = inputString;
        this.pattern = pattern;
    }

    private Pattern pattern;

    @Before
    public void setUp(){
        validator = Validator.getInstance();
    }
    @Test
    public void isValid() {
        Matcher matcher = pattern.matcher(inputString);
        Assert.assertTrue(validator.isValid(matcher));
    }

    @Test
    public void isValid1() {
        Assert.assertTrue(validator.isValid(inputString,pattern.pattern()));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestDataForRandom() {
        return Arrays.asList(new Object[][]{
                {"itcherry97@gmail.com", Const.EMAIL_PATTERN},
                {"privatbank@ukr.net", Const.EMAIL_PATTERN},
                {"it.cherry.97@yahoo.com", Const.EMAIL_PATTERN},
                {"java.training@gmail.com", Const.EMAIL_PATTERN},
                {"FAMILY", Const.GROUP_PATTERN},
                {"COLLEAGUES", Const.GROUP_PATTERN},
                {"FRIENDS", Const.GROUP_PATTERN},
                {"12", Const.BUILDING_FLAT_NUMBER_PATTERN},
                {"12-d", Const.BUILDING_FLAT_NUMBER_PATTERN},
                {"12-du", Const.BUILDING_FLAT_NUMBER_PATTERN},
                {"+380(3131)5-79-11", Const.HOME_PHONE_PATTERN},
                {"+380(44)123-12-12", Const.HOME_PHONE_PATTERN},
                {"+380(123)12-23-34", Const.HOME_PHONE_PATTERN},
                {"12345", Const.INDEX_PATTERN},
                {"1", Const.MENU_PATTERN},
                {"2", Const.MENU_PATTERN},
                {"3", Const.MENU_PATTERN},
                {"4", Const.MENU_PATTERN},
                {"5", Const.MENU_PATTERN},
                {"Andrii", Const.NAMES_PATTERN},
                {"abcdef12_-Afd", Const.NICKNAME_PATTERN}
        });
    }
}