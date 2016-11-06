package com.javaweb.entity;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Record.java
 * <p>
 * It is class, shows entity of record.
 * Here you can see all major parts of electronic
 * notebook.
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 06 Nov 2016
 */
public class Record {
    private enum GroupSet {COLLEAGUES, FRIENDS, FAMILY}

    private String lastName;
    private String firstName;
    private String middleName;
    private String changedFullName;
    private String nickName;
    private String comment;
    private GroupSet group;
    private String homePhone;
    private String mobilePhone;
    private String mobilePhoneOptional;
    private String emailAddress;
    private String skypeAccountName;
    private String fullAddress;
    private String createDate;
    private String changeDate;

    /**
     * @param lastName - setting new last name for current record
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param firstName - setting new first name for current record
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    /**
     * @param middleName - setting new middle name for current record
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Creating custom full name, which I got from technical task
     */
    public void setChangedFullName() {
        if (firstName != null && lastName != null) {
            this.changedFullName = String.format("%s %c",
                    lastName, firstName.charAt(0));
        }
    }

    /**
     * @param nickName- setting new nickname for current record
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @param comment - setting new commentary for current record
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Get group from {@link GroupSet}
     *
     * @param group - setting new group for current record
     */
    public void setGroup(String group) {
        this.group = GroupSet.valueOf(group);
    }

    /**
     * @param homePhone - setting new home phone for current record
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * @param mobilePhone - setting new mobile phone number
     *                    for current record.
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * @param mobilePhoneOptional - setting new second phone number
     *                            for current record.
     */
    public void setMobilePhoneOptional(String mobilePhoneOptional) {
        this.mobilePhoneOptional = mobilePhoneOptional;
    }

    /**
     * @param emailAddress - setting new e-mail address
     *                     for current record
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @param skypeAccountName - setting new skype login
     *                         for current record.
     */
    public void setSkypeAccountName(String skypeAccountName) {
        this.skypeAccountName = skypeAccountName;
    }

    /**
     * Creating full address in order to make pretty UI.
     *
     * @param index      - city(country) zip code;
     * @param city       - name of city;
     * @param street     - name of street;
     * @param homeNumber - number of building;
     * @param flatNumber - number of flat;
     */
    public void setFullAddress(String index, String city, String street,
                               String homeNumber, String flatNumber) {
        fullAddress = String.format("%1$s %2$s st., ap. %3$s, %4$s, %5$s",
                homeNumber, street, flatNumber, city, index);
    }

    /**
     * Setting date, when record was created.
     */
    public void setCreateDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        createDate = dateFormat.format(date.getTime());
    }

    /**
     * Setting date, when record was changed.
     */
    public void setChangeDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        changeDate = dateFormat.format(date.getTime());
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getChangedFullName() {
        return changedFullName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getComment() {
        return comment;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getMobilePhoneOptional() {
        return mobilePhoneOptional;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getSkypeAccountName() {
        return skypeAccountName;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public GroupSet getGroup() {
        return group;
    }
}
