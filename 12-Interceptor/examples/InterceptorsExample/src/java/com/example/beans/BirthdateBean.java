package com.example.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value="bBean")
@SessionScoped
public class BirthdateBean implements Serializable {

    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December"};
    private String year;
    private String month;
    private String day;
    

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Date getDate() {
        int yearValue = new Integer(year).intValue();
        int dayValue = new Integer(day).intValue();
        int monthValue = 0;
        for (; monthValue < months.length; monthValue++) {
            if (months[monthValue].equals(this.month)) {
                break;
            }
        }
        return new Date(new GregorianCalendar(yearValue, monthValue, dayValue).getTimeInMillis());
    }
}
