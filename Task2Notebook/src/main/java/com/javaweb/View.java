package com.javaweb;

/**
 * Created by Dron on 05-Nov-16.
 */
public class View {

    public static final String HEADER =
            "\\-------------- Electronic Notebook --------------//\n";
    public static final String[] MENU = {
            "1. Add new record;",
            "2. Change record;",
            "3. Delete record;",
            "4. Show records;",
            "5. Exit;"
    };

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

    public static final String ADDRESS_STRING =
            "\tAddress parameters : ";
    public static final String EXIT_MESSAGE =
            "\tYou can always exit from program, just press q";
    public static final String INPUT_STRING = "Enter your ";

    public static final String ERROR_MENU =
            "Enter digit between 1 and 5!";
    public static final String INPUT_ID =
            "enter digit between 1 and ";
    public static final String ERROR_STRING =
            "ERROR :";
    public static final String REPEAT_STRING =
            "Repeat please!";
    public static final String EMPTY_NOTEBOOK =
            "Your notebook is empty!! Add some record";
    public static final String BLOCK_SEPARATOR =
            "___________________________________________";

    public void printMessage(String... message) {
        for (String str : message) {
            System.out.print(str);
        }
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printlnMessage(String... message) {
        for (String str : message) {
            System.out.println(str);
        }
    }

    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printMenu() {
        printlnMessage(MENU);
    }

    public void printError(String errorMessage) {
        printlnMessage(ERROR_STRING + errorMessage + REPEAT_STRING);
    }

    public void printInputField(int idx) {
        printMessage(INPUT_STRING + INPUT_FIELDS[idx]);
    }
}
