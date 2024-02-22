package org.example;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class Main {
    static String prefix = "";
    static String path = "";
    static List<String> files = new ArrayList<>();
    static int typeStatistic = 0;
    static final int precision = 9;
    static boolean typeAdd = false;
    public static void main(String[] args) {
        int i = 0;
        while(i < args.length) {
            if(args[i].equals("-p")) {
                if(i+1 < args.length) {
                    prefix = args[i + 1];
                }
                i++;
                continue;
            }
            if(IsType.isTxt(args[i])) {
                files.add(args[i]);
            }
            if(args[i].equals("-s")) {
                typeStatistic = 1;
            }
            if(args[i].equals("-a")){
                typeAdd = true;
            }
            if(args[i].equals("-o")) {
                try {
                    if(i+1 < args.length ) {
                        path = args[i + 1];
                    }
                    else {
                        i++;
                        continue;
                    }
                    path = Paths.get(path).normalize().toString();
                    int j = 0, f = 0;
                    while (j < path.length() && path.charAt(j) == '\\') {
                        j++;
                    }
                    path = path.substring(j) + '\\';
                }
                catch (InvalidPathException e) {
                    // если путь написан "некорректно"
                }
                i++;
                continue;
            }
            i++;
        }

        List<Integer> cnt = Arrays.asList(0,0,0);
        List<BigInteger> integer_stat = Arrays.asList(null,null, new BigInteger("0")); // мин макс сумма
        List<BigDecimal> floats_stat = Arrays.asList(null,null, new BigDecimal("0")); // мин макс сумма
        List<Integer> string_stat = Arrays.asList(0,null,null); // количество, мин, макс


        new OutPut(files,path,prefix).outputToFiles(integer_stat,floats_stat,string_stat,cnt,typeAdd);
        new PrintStatistic(integer_stat,floats_stat,string_stat,cnt).printStatistic(typeStatistic,precision);



    }



}

