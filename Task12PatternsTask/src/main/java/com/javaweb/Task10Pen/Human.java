package com.javaweb.Task10Pen;

/**
 * @author Andrii Chernysh on 14-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class Human {
    private String name;
    private String birthDate;
    private String mobilePhone;
    private Gender gender;

    public enum Gender{
        MALE,FEMALE;
    }

    public Human(String name, String birthDate, String mobilePhone, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.mobilePhone = mobilePhone;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public Gender getGender() {
        return gender;
    }
}
