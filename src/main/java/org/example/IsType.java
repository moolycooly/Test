package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;

public class IsType {
    static boolean isTxt(String a) {
        int n = a.length();
        if(n > 4 && a.substring(n-4).equals(".txt")){
            return true;
        }
        else {
            return false;
        }
    }
    static boolean isInt(String s) {
        try {
            new BigInteger(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    static boolean isFloat(String s) {
        try {
            new BigDecimal(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }
}
