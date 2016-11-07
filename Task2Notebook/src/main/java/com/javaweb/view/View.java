package com.javaweb.view;

/**
 * View.java
 * <p>
 * It is class, which contains String constants
 * in order to show tips for user in the console.
 * In the future we can change UI by simple steps.
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 06 Nov 2016
 */
public class View {
    /**
     * Greeting String
     */
    public static final String HEADER =
            "\\-------------- Electronic Notebook --------------//\n";

    /**
     * Menu array of string
     */
    public static final String[] MENU = {
            "1. Add new record;",
            "2. Change record;",
            "3. Delete record;",
            "4. Show records;",
            "5. Exit;"
    };

    /**
     * Here are strings, which we need to show to user,
     * when he will input his data.
     */
    public static final String[] INPUT_FIELDS = {
            "first name(First letter uppercase" +
                    " others lowercase(E.G : Maksym)) : ",
            "last name(First letter uppercase" +
                    " others lowercase(E.G : Lyashenko)) : ",
            "middle name(First letter uppercase" +
                    " others lowercase(E.G : Volodymyrovich)) : ",
            "nickname(Latin letters, digits, underscore \'_\'," +
                    " dash \'-\'. Length : 3-15 symbols) : ",
            "skype login(Latin letters, underscore \'_\'," +
                    " dash \'-\'. Length : 3-15 symbols) : ",
            "comment : ",
            "group(COLLEAGUES, FRIENDS, FAMILY) : ",
            "home phone(+380(3131)5-79-11 |" +
                    " +380(44)123-12-12 | +380(123)12-23-34) : ",
            "mobile phone(+380931234567 | 0661234567) : ",
            "mobile phone 2(optional) : ",
            "e-mail(example@gmail.com)",
            "index(5 digits) : ",
            "city(First letter uppercase, others lowercase(E.G : Kyiv)) : ",
            "street(First letter uppercase," +
                    " others lowercase(E.G : Polytehnichna)) : ",
            "home number(number or number dash letter(E.G 111,123-a)) : ",
            "flat number(number or number dash letter(E.G 111,123-a)) : ",
    };

    /**
     * Here are strings, which we need to show to user from our notebook
     */
    public static final String[] OUTPUT_FIELDS = {
            "ID : ",
            "Name : ",
            "Nickname : ",
            "Skype : ",
            "Group : ",
            "Home phone : ",
            "Mobile phone 1 : ",
            "Mobile phone 2 : ",
            "Email : ",
            "Address : ",
            "Commentary : ",
            "Date creating : ",
            "Date changing : ",
    };

    /**
     * When we ask to enter address. It is like visual separator.
     */
    public static final String ADDRESS_STRING =
            "\tAddress parameters : ";
    /**
     * Black exit for user from loops.
     */
    public static final String EXIT_MESSAGE =
            "\tYou can always exit from program, just press q";
    /**
     * When show input fields.
     */
    public static final String INPUT_STRING = "Enter your ";

    /**
     * If input number <=0 and > 5, show error
     */
    public static final String ERROR_MENU =
            "Enter digit between 1 and 5!";
    /**
     * When change and delete information,
     * we need to ask id of records
     */
    public static final String INPUT_ID =
            "enter digit between 1 and ";

    public static final String ERROR_STRING =
            "ERROR :";

    public static final String REPEAT_STRING =
            "Repeat please!";
    /**
     * When we hav no records in Notebook
     */
    public static final String EMPTY_NOTEBOOK =
            "Your notebook is empty!! Add some record";
    /**
     * Like delete method in databases. Pretty UI.
     */
    public static final String DELETE_ROW =
            " rows deleted!!!";
    public static final String BLOCK_SEPARATOR =
            "___________________________________________";

    /**
     *
     * @param message - array of strings for printing
     *                to console without next line symbol.
     */
    public void printMessage(String... message) {
        for (String str : message) {
            System.out.print(str);
        }
    }

    /**
     *
     * @param message message for printing
     *                to console without next line symbol.
     */
    public void printMessage(String message) {
        System.out.print(message);
    }

    /**
     *
     * @param message - array of strings for printing
     *                to console with next line symbol.
     */
    public void printlnMessage(String... message) {
        for (String str : message) {
            System.out.println(str);
        }
    }

    /**
     *
     * @param message - string for printing
     *                to console with next line symbol.
     */
    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printMenu() {
        printlnMessage(MENU);
    }

    /**
     * Show error in the console
     *
     * @param errorMessage - message with error context.
     */
    public void printError(String errorMessage) {
        printlnMessage(ERROR_STRING + errorMessage + REPEAT_STRING);
    }

    /**
     *
     * @param idx - index of field in INPUT_FIELDS array.
     */
    public void printInputField(int idx) {
        printMessage(INPUT_STRING + INPUT_FIELDS[idx]);
    }
}
