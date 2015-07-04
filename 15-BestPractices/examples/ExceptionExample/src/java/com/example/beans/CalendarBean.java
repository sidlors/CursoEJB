package com.example.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UISelectOne;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author tmcginn
 */
@Named(value = "cal")
@RequestScoped
public class CalendarBean implements Serializable {

    protected String[] monthLabels = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December"};
    protected int[] maxNumDaysMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    protected SelectItem[] months;
    protected SelectItem[] years;
    protected SelectItem[] days;
    protected int currMaxDays = 31;
    // Bound fields
    // Right now, these are not bound, because of a bug in JSF that does not allow bound properties with the <f:ajax> tag
    // http://java.net/jira/browse/JAVASERVERFACES_SPEC_PUBLIC-535
    protected UISelectOne monthComp = new UISelectOne();
    protected UISelectOne dayComp = new UISelectOne();

    /**
     * Creates a new instance of CalendarBean
     */
    public CalendarBean() {
        // Create the SelectItem array of months
        createMonthsSelectOneMenu();

        // Create the initial SelectItem array of days for January
        createDaysSelectOneMenu(currMaxDays);

        // Create the SelectItem array of years from 1900 to this year
        int startYear = 1900;
        int thisYear = getCurrentDate()[2];
        createYearsSelectOneMenu(startYear, thisYear);
    }

    public SelectItem[] getDays() {
        return days;
    }

    public SelectItem[] getMonths() {
        return months;
    }

    public SelectItem[] getYears() {
        return years;
    }

    public UISelectOne getDayComp() {
        return dayComp;
    }

    public void setDayComp(UISelectOne dayComp) {
        this.dayComp = dayComp;
    }

    public UISelectOne getMonthComp() {
        return monthComp;
    }

    public void setMonthComp(UISelectOne monthComp) {
        this.monthComp = monthComp;
    }

    // When the month is selected, the number of days can be set
    public void monthSelected(ValueChangeEvent ve) {
        UISelectOne mnth = (UISelectOne) ve.getSource();
        if (mnth != null) {
            // Get the index of the selected month
            int currMonth = getMonthIndex((String) mnth.getValue());
            // Determine the number of days in this month
            int monthDays = maxNumDaysMonth[currMonth];
            // If the current maxDays is this number, do nothing
            if (currMaxDays != monthDays) {
                createDaysSelectOneMenu(monthDays);
                currMaxDays = monthDays;
            }
        }
    }

    public void createDaysSelectOneMenu(int maxDays) {
        // Create the SelectItem array for the maximum number of days
        List<SelectItem> dayList = new ArrayList<>();
        for (int day = 1; day <= maxDays; day++) {
            dayList.add(new SelectItem(day, (new Integer(day)).toString()));
        }
        days = dayList.toArray(new SelectItem[0]);
    }

    public void createMonthsSelectOneMenu() {
        // Create the SelectItem array of months
        int i = 0;
        List<SelectItem> monList = new ArrayList<>();
        for (String month : monthLabels) {
            monList.add(new SelectItem(month, month));
            i++;
        }
        months = monList.toArray(new SelectItem[0]);
    }

    public void createYearsSelectOneMenu(int start, int end) {
        List<SelectItem> yearList = new ArrayList<>();
        do {
            yearList.add(new SelectItem(start, (new Integer(start)).toString()));
            start++;
        } while (start <= end);
        years = yearList.toArray(new SelectItem[0]);
    }

    // Return an int array of the current month, day, year
    public int[] getCurrentDate() {
        int[] dateValue = new int[3];
        Calendar rightNow = Calendar.getInstance();
        dateValue[0] = rightNow.get(Calendar.MONTH);
        dateValue[1] = rightNow.get(Calendar.DAY_OF_MONTH);
        dateValue[2] = rightNow.get(Calendar.YEAR);
        return dateValue;
    }

    public int getMonthIndex(String month) {
        int i = 0;
        while (!monthLabels[i].equals(month)) {
            i++;
        }
        return i;
    }
}
