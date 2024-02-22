package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class PrintStatistic {
    private List<BigInteger> integer_stat;
    private List<BigDecimal> floats_stat;
    private List<Integer> string_stat;
    private List<Integer> cnt;

    public PrintStatistic(List<BigInteger> integer_stat, List<BigDecimal> floats_stat, List<Integer> string_stat, List<Integer> cnt) {
        this.integer_stat = integer_stat;
        this.floats_stat = floats_stat;
        this.string_stat = string_stat;
        this.cnt = cnt;
    }
    public void printStatistic(int typeStatistic, int precision) {
        System.out.println("Statistics:");

        if(typeStatistic == 0) {
            System.out.println("Minimum integer: " + integer_stat.get(0));
            System.out.println("Maximum integer: " + integer_stat.get(1));
            try {
                System.out.println("Average of integers " + new BigDecimal(integer_stat.get(2)).divide(new BigDecimal(cnt.get(0).toString()), precision, BigDecimal.ROUND_DOWN));
            }
            catch (ArithmeticException e) {
                System.out.println("Average of integers " + null);
            }

            System.out.println("Minimum float: " + floats_stat.get(0));
            System.out.println("Maximum float: " + floats_stat.get(1));
            try {
                System.out.println("Average of floats " + floats_stat.get(2).divide(new BigDecimal(cnt.get(1).toString()), precision, BigDecimal.ROUND_DOWN));
            }
            catch (ArithmeticException e) {
                System.out.println("Average of integers " + null);
            }
            System.out.println("Number of strings: " + string_stat.get(0));
            System.out.println("Min lenght of string: " + string_stat.get(1));
            System.out.println("Max lenght of string " + string_stat.get(2));
        }
        else {
            System.out.println("Number of integers: " + cnt.get(0));
            System.out.println("Number of floats: " + cnt.get(1));
            System.out.println("Number of strings: " + cnt.get(2));

        }
    }
}
