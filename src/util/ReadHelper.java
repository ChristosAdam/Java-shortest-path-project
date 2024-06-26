/* ------------------------------------------------------------------------------------------------
 *  Computation 3
 * ------------------------------------------------------------------------------------------------
 * Package Util : Set of Helper classes.
 * Date Helper - Class used to facilitate date manipulation.
 * ------------------------------------------------------------------------------------------------
 * Useful information:
 *
 * (1) Exceptions: In Java is available many builtin Exceptions.
 * e.g. list: https://programming.guide/java/list-of-java-exceptions.html
 *
 * In this code is being used:
 *
 * public class InputMismatchException
 * -----------------------------------
 * Thrown by a Scanner to indicate that the token retrieved does not match the pattern for the expected
 * type, or that the token is out of range for the expected type.
 * https://docs.oracle.com/javase/8/docs/api/java/util/InputMismatchException.html
 * ------------------------------------------------------------------------------------------------ */
package util;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Read Helper is a class to simplify the console readings, protecting these readings to read the expected data type properly.
 * In this way, avoiding any exception error.
 * (!) STATIC CLASS
 ***********************************************************************************************************************/
public class ReadHelper {

    ////////////////////////////////////////////////////////////////////////
    // DATA = ATTRIBUTES
    // (!) STATIC
    ////////////////////////////////////////////////////////////////////////
    // None

    ////////////////////////////////////////////////////////////////////////
    // BEHAVIORS == METHODS
    // (!) STATIC
    ////////////////////////////////////////////////////////////////////////
    /**
     * readDoubleSafely - read a double from the console treating wrong or unexpected data input
     * @param errorMessage - the message used to inform the user, preferentially providing information about what the program expects to receive.
     * @return return the double number read.
     *******************************************************************************************************************/
    public static Double readDoubleSafely(String errorMessage){
        Scanner read = new Scanner(System.in);
        Double number  = 0.0;

        boolean reading =  true;
        while (reading){
            try {
                number = read.nextDouble();
                reading = false;    // If an error happens in the line above, this line will not be executed,
                                    // the execution will be directed to the catch statement below
            }
            catch(InputMismatchException e){
                System.out.println(errorMessage);
                read.next();
            }
        }

        return number;
    }

    /**
     * readIntegerSafely - read an int from the console treating wrong or unexpected data input
     * @return return the int number read.
     *******************************************************************************************************************/
    public static int readIntegerSafely(String errorMessage){
        Scanner read = new Scanner(System.in);
        int number  = 0;

        boolean reading =  true;
        while (reading){
            try {
                number = read.nextInt();
                reading = false;    // If an error happens in the line above, this line will not be executed,
                                    // the execution will be directed to the catch statement below
            }
            catch(InputMismatchException e) {
                System.out.println(errorMessage);
                read.next();
            }
        }

        return number;
    }

    /**
     * readStringSafely - read a String from the console treating wrong or unexpected data input
     * @param errorMessage - the message used to inform the user, preferentially providing information about what the program expects to receive.
     * @return return the string read.
     *******************************************************************************************************************/
    public static String readStringSafely(String errorMessage){
        Scanner read = new Scanner(System.in);
        String text  = "";

        boolean reading =  true;
        while (reading){
            try {
                text = read.next();
                reading = false;// If an error happens in the line above, this line will not be executed,
                                // the execution will be directed to the catch statement below
            }
            catch(InputMismatchException e){
                System.out.println(errorMessage);
                read.next();
            }
        }

        return text;
    }

    /**
     * readStringSafely - read a char from the console treating wrong or unexpected data input
     * @param errorMessage - the message used to inform the user, preferentially providing information about what the program expects to receive.
     * @return return the first read character.
     *******************************************************************************************************************/
    public static char readCharSafely(String errorMessage){
        Scanner read = new Scanner(System.in);
        char option = 'n';

        boolean reading =  true;
        while (reading){
            try {
                option = read.next().charAt(0);
                reading = false; // If an error happens in the line above, this line will not be executed,
                                 // the execution will be directed to the catch statement below
            }
            catch(InputMismatchException e){
                System.out.println(errorMessage);
                read.next();
            }
        }

        return option;
    }
}
