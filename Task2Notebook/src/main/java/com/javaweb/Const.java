package com.javaweb;

import java.util.regex.Pattern;


public interface Const {

    int ADD_MENU_ITEM = 1;
    int CHANGE_MENU_ITEM = 2;
    int DELETE_MENU_ITEM = 3;
    int SHOW_MENU_ITEM = 4;
    int EXIT_MENU_ITEM = 5;

    String MENU_REGEXP =
            "1|2|3|4|5";
    String NAMES_REGEXP =
            "[A-ZА-Я-][a-zа-я-]*";
    String HOME_PHONE_REGEXP =
            "\\+380(\\(\\d{2}\\)\\d{3}|\\(\\d{3}\\)\\d{2}|" +
                    "\\(\\d{4}\\)\\d)-\\d{2}-\\d{2}";
    String MOBILE_PHONE_REGEXP =
            "(\\+38)?0((50|63|66|67|68|73|89|91|92|93|94|95|96|97|98|99)\\d{7})";
    String NICKNAME_REGEXP =
            "^[A-Za-z0-9_-]{3,15}$";
    String GROUP_REGEXP =
            "COLLEAGUES|FRIENDS|FAMILY";
    String EMAIL_REGEXP = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]" +
            "+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    String INDEX_REGEXP = "\\d{5}";
    String BUILDING_FLAT_NUMBER_REGEXP =
            "(\\d+-\\w)|(\\d+)";

    Pattern HOME_PHONE_PATTERN = Pattern.compile(HOME_PHONE_REGEXP);
    Pattern MOBILE_PHONE_PATTERN = Pattern.compile(MOBILE_PHONE_REGEXP);
    Pattern NAMES_PATTERN = Pattern.compile(NAMES_REGEXP);
    Pattern MENU_PATTERN = Pattern.compile(MENU_REGEXP);
    Pattern NICKNAME_PATTERN = Pattern.compile(NICKNAME_REGEXP);
    Pattern GROUP_PATTERN = Pattern.compile(GROUP_REGEXP);
    Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEXP);
    Pattern INDEX_PATTERN = Pattern.compile(INDEX_REGEXP);
    Pattern BUILDING_FLAT_NUMBER_PATTERN =
            Pattern.compile(BUILDING_FLAT_NUMBER_REGEXP);
}
