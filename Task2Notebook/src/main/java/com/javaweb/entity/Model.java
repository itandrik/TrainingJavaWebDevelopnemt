package com.javaweb.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Model.java
 * <p>
 * It is class, which contains all records.
 * It is really electronic notebook. It has standart
 * possibilities such add, delete, change and get.
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 06 Nov 2016
 */
public class Model {
    /**
     * Here is container for records.
     */
    private ArrayList<Record> recordsList;

    /**
     * Initializing of container for records.
     */
    public Model() {
        recordsList = new ArrayList<>();
    }

    /**
     * Create new record in our container and push
     * it io the end.
     *
     * @param record - {@link Record}.
     */
    public void addRecord(Record record) {
        recordsList.add(record);
    }

    /**
     * Changing record within container.
     *
     * @param id     - number of record to change.
     * @param record -  new record.
     */
    public void changeRecord(int id, Record record) {
        recordsList.set(id - 1, record);
    }

    /**
     * Deleting record from container.
     *
     * @param id - number of record to delete.
     * @return count of deleted rows from Notebook.
     */
    public int deleteRecord(int id) {
        recordsList.remove(id - 1);
        return 1;
    }

    /**
     * Get all records from model to show them
     * in the console for user.
     *
     * @return container with records
     */
    public List<Record> getRecords() {
        return recordsList;
    }
}
