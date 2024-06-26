/* ------------------------------------------------------------------------------------------------
 *  Computation 3
 * ------------------------------------------------------------------------------------------------
 * Package Util : Set of Helper classes.
 * Date Helper - Class used to facilitate date manipulation.
 * ------------------------------------------------------------------------------------------------
 * Useful information:
 *
 * For more information about Date:
 *  - http://tutorials.jenkov.com/java-date-time/parsing-formatting-dates.html#simpledateformat-example
 *  - http://tutorials.jenkov.com/java-internationalization/simpledateformat.html
 * ------------------------------------------------------------------------------------------------ */

package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Data Helper: Static Class with some methods to facilitate date manipulation.
 * (!) STATIC CLASS
 ***********************************************************************************************************************/
public class DateHelper {

    ////////////////////////////////////////////////////////////////////////
    // DATA = ATTRIBUTES
    // (!) STATIC
    ////////////////////////////////////////////////////////////////////////
    private static String DATE_FORMAT = "dd-MM-yyyy";
    private static Object Years;

    ////////////////////////////////////////////////////////////////////////
    // BEHAVIORS == METHODS
    // (!) STATIC
    ////////////////////////////////////////////////////////////////////////
    public static Date getToday(){
        return new Date();
    }

    // Helper function: getDate

    /**
     * Create a date (object of Date Class) using a string that must follow a DATE_FORMAT (e.g. dd-MM-yyyy)
     * Where dd - day with two digits, MM - month with to digits, yyyy - year with four digits
     * @param dateStr a date as a string
     * @return Date object
     *******************************************************************************************************************/
    public static Date createDate(String dateStr) {


        Date aDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        String dateString = dateFormat.format(new Date());
        try {
            aDate = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return aDate;
    }

    /**
     * Format a date (select and change the order of date elements e.g. 31-01-2019
     * @param date - a date to be formatted to a specific format (e.g. dd-MM-yyyy)
     * Where dd - day with two digits, MM - month with to digits, yyyy - year with four digits
     * @return a date as string following the format e.g. 31-01-2019
     *******************************************************************************************************************/
    public static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(date);
    }

    /**
     *
     * @param birthday date object (Date Class) which identifies the birthday
     * @param reference date object (Date Class) which will be used to calulate the age.
     * @return the age in integer
     *******************************************************************************************************************/
    public static int calcAge(Date birthday, Date reference) {
        int age = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        int d1 = Integer.parseInt(dateFormat.format(birthday));
        int d2 = Integer.parseInt(dateFormat.format(reference));
        age = (d2 - d1) / 10000;

        return age;
    }

    /**
     * Get the year od a date object (Date Class)
     * @param aDate
     * @return the year of a date
     *******************************************************************************************************************/
    public static int getYear(Date aDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        return Integer.parseInt( dateFormat.format(aDate) );
    }


}
