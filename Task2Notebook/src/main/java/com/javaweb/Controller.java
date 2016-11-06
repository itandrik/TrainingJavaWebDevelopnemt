package com.javaweb;

import com.javaweb.entity.Model;
import com.javaweb.entity.Record;
import com.javaweb.entity.Validator;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements Const {
    private Model model;
    private View view;
    private Validator validator;
    private Pattern pattern;
    private Scanner scanner;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        scanner = new Scanner(System.in);
        validator = Validator.getInstance();
    }

    public void processUser() {
        view.printlnMessage(View.HEADER);
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

    private int getMenuItem() {
        while (!scanner.hasNext(MENU_PATTERN)) {
            view.printError(View.ERROR_MENU);
            view.printMenu();
            scanner.next();
        }
        return Integer.parseInt(scanner.next());
    }

    public void addRecordToNotebook() {
        Record newRecord = createNewRecord();
        newRecord.setCreateDate();
        model.addRecord(newRecord);
    }

    public void changeRecordInNotebook() {
        if(model.getRecords().isEmpty()){
            view.printlnMessage(View.EMPTY_NOTEBOOK);
            return;
        }
        view.printMessage(View.INPUT_ID + model.getRecords().size() + " : ");
        int id = scanner.nextInt();
        while((!scanner.hasNextInt()) && (id <= 0) &&
                (id > model.getRecords().size())){
            view.printError(View.INPUT_ID + model.getRecords().size() + " : ");
            id = scanner.nextInt();
        }
        Record newRecord = createNewRecord();
        newRecord.setChangeDate();
        model.changeRecord(id,newRecord);
    }

    public void deleteRecordFormNotebook() {
        view.printMessage(View.INPUT_ID + model.getRecords().size() + " : ");
        int id = scanner.nextInt();
        while((!scanner.hasNextInt()) && (id <= 0) &&
                (id > model.getRecords().size())){
            view.printError(View.INPUT_ID + model.getRecords().size() + " : ");
            id = scanner.nextInt();
        }
        model.deleteRecord(id);
    }

    public void showRecordsFromNotebook(){
        List<Record> recordList = model.getRecords();
        if(recordList.isEmpty()){
            view.printlnMessage(View.EMPTY_NOTEBOOK);
            return;
        }
        int i = 0;
        int idRecord = 1;
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
            if(item.getMobilePhoneOptional() != null){
                view.printlnMessage(View.OUTPUT_FIELDS[i++] +
                        item.getMobilePhoneOptional());
            }else{
                i++;
            }
            view.printlnMessage(View.OUTPUT_FIELDS[i++] +
                    item.getEmailAddress());
            view.printlnMessage(View.OUTPUT_FIELDS[i++] +
                    item.getFullAddress());
            view.printlnMessage(View.OUTPUT_FIELDS[i++] + item.getComment());
            view.printlnMessage(View.OUTPUT_FIELDS[i++] +
                    item.getCreateDate());
            if(item.getChangeDate() != null) {
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

    private Record createNewRecord() {
        view.printlnMessage(View.EXIT_MESSAGE);
        Record record = new Record();
        int indexInputField = 0;
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

    private String validateInputString(int indexInputField) {
        view.printInputField(indexInputField);
        String resultString = scanner.next();
        Matcher matcher = pattern.matcher(resultString);
        while (!resultString.equals("q") && !validator.isValid(matcher.reset(resultString))) {
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

