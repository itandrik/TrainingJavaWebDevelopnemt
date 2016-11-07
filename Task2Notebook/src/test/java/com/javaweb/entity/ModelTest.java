package com.javaweb.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ModelTest {
    private Model modelTest;

    @Before
    public void setUp() throws Exception {
        modelTest = new Model();
    }

    @Test
    public void addRecordTest(){
        modelTest.addRecord(new Record());
        Assert.assertTrue(modelTest.getRecords().size() > 0);
    }

    @Test
    public void delRecordTest(){
        modelTest.addRecord(new Record());
        modelTest.deleteRecord(1);
        Assert.assertTrue(modelTest.getRecords().size() == 0);
    }

    @Test
    public void changeRecordTest(){
        modelTest.addRecord(new Record());
        Record record = modelTest.getRecords().get(0);
        modelTest.changeRecord(1,new Record());
        Assert.assertTrue(record != modelTest.getRecords().get(0));
    }

    @Test
    public void getRecordsTest(){
        modelTest.addRecord(new Record());
        Assert.assertTrue(modelTest.getRecords().get(0) != null);
    }
}