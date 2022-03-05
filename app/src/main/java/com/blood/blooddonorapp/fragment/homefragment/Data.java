package com.blood.blooddonorapp.fragment.homefragment;

/**
 * Created by Android Dev on 05-Mar-22 Mar, 2022
 */
public class Data {

    private int imageProfile;
    private int imageMap;
    private int imageMore;
    private String donorName;
    private String donorDateTime;
    private String patientPb;
    private String bloodGp;
    private String bloodAmount;
    private String dateTimeDay;
    private String time;
    private String place;
    private String contact;


    public Data(int imageProfile, int imageMap, int imageMore, String donorName, String donorDateTime, String patientPb, String bloodGp, String bloodAmount,
                String dateTimeDay, String time, String place, String contact) {
        this.imageProfile = imageProfile;
        this.imageMap = imageMap;
        this.imageMore = imageMore;
        this.donorName = donorName;
        this.donorDateTime = donorDateTime;
        this.patientPb = patientPb;
        this.bloodGp = bloodGp;
        this.bloodAmount = bloodAmount;
        this.dateTimeDay = dateTimeDay;
        this.time = time;
        this.place = place;
        this.contact = contact;
    }

    public int getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(int imageProfile) {
        this.imageProfile = imageProfile;
    }

    public int getImageMap() {
        return imageMap;
    }

    public void setImageMap(int imageMap) {
        this.imageMap = imageMap;
    }

    public int getImageMore() {
        return imageMore;
    }

    public void setImageMore(int imageMore) {
        this.imageMore = imageMore;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorDateTime() {
        return donorDateTime;
    }

    public void setDonorDateTime(String donorDateTime) {
        this.donorDateTime = donorDateTime;
    }

    public String getPatientPb() {
        return patientPb;
    }

    public void setPatientPb(String patientPb) {
        this.patientPb = patientPb;
    }

    public String getBloodGp() {
        return bloodGp;
    }

    public void setBloodGp(String bloodGp) {
        this.bloodGp = bloodGp;
    }

    public String getBloodAmount() {
        return bloodAmount;
    }

    public void setBloodAmount(String bloodAmount) {
        this.bloodAmount = bloodAmount;
    }

    public String getDateTimeDay() {
        return dateTimeDay;
    }

    public void setDateTimeDay(String dateTimeDay) {
        this.dateTimeDay = dateTimeDay;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
