package com.javaweb.controller;

import com.javaweb.entity.Model;
import com.javaweb.entity.Record;
import com.javaweb.entity.Validator;
import com.javaweb.view.View;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Controller.java
 * <p>
 * This is class, which works with {@link Model}
 * and {@link View} according to MVC pattern. Also
 * Here you can create records from class {@link Record}
 * in order to add or change some records in Electronic Notebook.
 * For data validation you will use {@link Validator} class or
 * basic validation methods in Scanner or String.
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 06 Nov 2016
 */
public class Controller implements Const {

    private Model model;
    private View view;
    private Validator validator;

    /**
     * Pattern instance. It is for optimizing
     * java machine resources.
     */
    private Pattern pattern;
    private Scanner scanner;

    /**
     * Initializing all private fields;
     *
     * @param model instance of model;
     * @param view instance of view;
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        scanner = new Scanner(System.in);
        validator = Validator.getInstance();
    }

    /**
     * Method, which make all program. Basically,
     * it is called by {@link com.javaweb.Main}.
     * Here processing all operations with Notebook
     * according to menu.
     */
    public void processUser() {
        view.printlnMessage(View.HEADER);       // Greeting message
        while (true) {
            view.printMenu();
            switch (getMenuItem()) {
                case ADD_MENU_ITEM:
                    addRecordToNotebook();
                    break;
                case CHANGE_MENU_ITEM:
                    changeRecordInNotebook();
                    break;
                case DELETE_MENU_ITEM:
                    deleteRecordFormNotebook();
                    break;
                case SHOW_MENU_ITEM:
                    showRecordsFromNotebook();
                    break;
                case EXIT_MENU_ITEM:
                    System.exit(0);
            }
        }
    }

    /**
     * Here is validating number from 1 to 5
     * (menu numbers). So here I use inner validator
     * within scanner. It is easy to understand this code.
     * Here {@link Scanner#hasNext(Pattern)} is used.
     *
     * @return number of menu item;
     */
    private int getMenuItem() {
        while (!scanner.hasNext(MENU_PATTERN)) {
            view.printError(View.ERROR_MENU);
            view.printMenu();
            scanner.next();
        }
        return Integer.parseInt(scanner.next());
    }

    /**
     * Firstly, create new record using method {@link #createNewRecord()},
     * after, add this object to model class. All fields will be valid
     */
    public void addRecordToNotebook() {
        Record newRecord = createNewRecord();
        newRecord.setCreateDate();
        model.addRecord(newRecord);
    }

    /**
     * Firstly, create new record using method {@link #createNewRecord()},
     * after, change this object with some id in the model class.
     * All fields will be valid.
     */
    public void changeRecordInNotebook() {
        if (model.getRecords().isEmpty()) {         // if Notebook is empty
            view.printlnMessage(View.EMPTY_NOTEBOOK);
            return;
        }

        /* Getting valid id from console.
         Here is used method in validator class,
          which create Pattern and Matcher a lot of time.
           I use this method here in order to show how it works*/
        view.printMessage(View.INPUT_ID + model.getRecords().size() + " : ");
        String id = scanner.next();
        while (!validator.isValid(id, String.format("[1-%d]+",
                model.getRecords().size()))) {
            view.printError(View.INPUT_ID + model.getRecords().size() + " : ");
            id = scanner.next();
        }

        Record newRecord = createNewRecord();
        newRecord.setChangeDate();      // Creating new date of changing
        /* Reset create date, because we have new Record instance. */
        newRecord.setCreateDate(model.getRecords().get(Integer.parseInt(id)).getCreateDate());
        model.changeRecord(Integer.parseInt(id), newRecord);
    }

    /**
     * Deleting record with valid id from Electronic Notebook.
     */
    public void deleteRecordFormNotebook() {
        view.printMessage(View.INPUT_ID + model.getRecords().size() + " : ");
        String id = scanner.next();
        while (!validator.isValid(id, String.format("[1-%d]+",
                model.getRecords().size()))) {
            view.printError(View.INPUT_ID + model.getRecords().size() + " : ");
            id = scanner.next();
        }
        view.printlnMessage(model.deleteRecord(Integer.parseInt(id)) + View.DELETE_ROW);
        /* Waiting for 'ENTER' pressing */
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Here is creating pretty UI in the console.
     * All rows from Electronic Notebook will be there
     */
    public void showRecordsFromNotebook() {
        List<Record> recordList = model.getRecords();
        if (recordList.isEmpty()) {
            view.printlnMessage(View.EMPTY_NOTEBOOK);
            return;
        }
        int i = 0;        // Iterator for OUTPUT_FIELDS array from View class.
        int idRecord = 1; //Iterator for records id(using in change and delete)
        for (Record item : recordList) {
            view.printlnMessage("\t" + View.OUTPUT_FIELDS[i++] + idRecord++);
            view.printlnMessage(View.OUTPUT_FIELDS[i++] +
                    item.getChangedFullName());
            view.printlnMessage(View.OUTPUT_FIELDS[i++] + item.getNickName());
            view.printlnMessage(View.OUTPUT_FIELDS[i++] +
                    item.getSkypeAccountName());
            view.printlnMessage(View.OUTPUT_FIELDS[i++] + item.getGroup());
            view.printlnMessage(View.OUTPUT_FIELDS[i++] + item.getHomePhone());
            view.printlnMessage(View.OUTPUT_FIELDS[i++] +
                    item.getMobilePhone());
            if (item.getMobilePhoneOptional() != null) {
                view.printlnMessage(View.OUTPUT_FIELDS[i++] +
                        item.getMobilePhoneOptional());
            } else {
                i++;
            }
            view.printlnMessage(View.OUTPUT_FIELDS[i++] +
                    item.getEmailAddress());
            view.printlnMessage(View.OUTPUT_FIELDS[i++] +
                    item.getFullAddress());
            view.printlnMessage(View.OUTPUT_FIELDS[i++] + item.getComment());
            view.printlnMessage(View.OUTPUT_FIELDS[i++] +
                    item.getCreateDate());
            if (item.getChangeDate() != null) {
                view.printlnMessage(View.OUTPUT_FIELDS[i] +
                        item.getChangeDate());
            }
            i = 0;
            view.printlnMessage(View.BLOCK_SEPARATOR);
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creating new record and validate all fields according to
     * our regular expressions. Here we call {@link #validateInputString(int)}
     * method for validating. There it use our {@link #pattern} for
     * validating data. Also here is writing some tips for user
     * (from {@link View#OUTPUT_FIELDS}).
     *
     * @return new record with all valid fields.
     */
    private Record createNewRecord() {
        view.printlnMessage(View.EXIT_MESSAGE);
        Record record = new Record();
        int indexInputField = 0;    // iterator for OUTPUT_FIELDS array.
        pattern = NAMES_PATTERN;
        record.setFirstName(validateInputString(indexInputField++));
        record.setLastName(validateInputString(indexInputField++));
        record.setMiddleName(validateInputString(indexInputField++));
        record.setChangedFullName();
        pattern = NICKNAME_PATTERN;
        record.setNickName(validateInputString(indexInputField++));
        record.setSkypeAccountName(validateInputString(indexInputField++));
        view.printInputField(indexInputField++);
        record.setComment(scanner.next());
        pattern = GROUP_PATTERN;
        record.setGroup(validateInputString(indexInputField++));
        pattern = HOME_PHONE_PATTERN;
        record.setHomePhone(validateInputString(indexInputField++));
        pattern = MOBILE_PHONE_PATTERN;
        record.setMobilePhone(validateInputString(indexInputField++));
        record.setMobilePhoneOptional(validateInputString(indexInputField++));
        pattern = EMAIL_PATTERN;
        record.setEmailAddress(validateInputString(indexInputField++));
        view.printlnMessage(View.ADDRESS_STRING);
        pattern = INDEX_PATTERN;
        String index = validateInputString(indexInputField++);
        pattern = NAMES_PATTERN;
        String city = validateInputString(indexInputField++);
        String street = validateInputString(indexInputField++);
        pattern = BUILDING_FLAT_NUMBER_PATTERN;
        String buildingNumber = validateInputString(indexInputField++);
        String flatNumber = validateInputString(indexInputField);
        record.setFullAddress(index, city, street, buildingNumber, flatNumber);
        return record;
    }

    /**
     * Creating Matcher here and not in {@link Validator} is better, because
     * we don't need to create a lot of instance of Matcher there.
     * In my opinion it is better to use {@link Scanner#hasNext(Pattern)},
     * because it is easier to read. But I use this algorithm to show how
     * working with Pattern and Matcher.
     *
     * @param indexInputField iterator for {@link View#OUTPUT_FIELDS} array.
     * @return valid string for our record.
     */
    private String validateInputString(int indexInputField) {
        view.printInputField(indexInputField);
        String resultString = scanner.next();
        Matcher matcher = pattern.matcher(resultString);
        while ((!resultString.equals("q")) &&   // 'q' - quit from loop;
                (!validator.isValid(matcher.reset(resultString)))) {
            view.printError("");
            view.printInputField(indexInputField);
            resultString = scanner.next();
        }
        if (resultString.equals("q")) {
            System.exit(0);
        }
        return resultString.trim();
    }
}

