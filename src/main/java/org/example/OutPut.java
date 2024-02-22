package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class OutPut {
    private List<String> files;
    private List<String> paths;
    private String path;
    private String prefix;
    public OutPut(List<String> files, String path, String prefix) {
        this.files = files;
        this.path = path;
        this.prefix = prefix;

        paths = Arrays.asList("integers.txt","floats.txt","strings.txt");
        for(int i = 0; i < 3; i++) {
            paths.set(i,path+prefix+paths.get(i));
        }
    }

    public void outputToFiles(List<BigInteger> integer_stat, List<BigDecimal> floats_stat, List<Integer> string_stat, List<Integer> cnt, boolean typeAdd) {
        List<FileWriter> writers = Arrays.asList(null,null,null);
        for(int i = 0; i < files.size(); i++) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(files.get(i), StandardCharsets.UTF_8));
                String line = reader.readLine();
                while(line != null) {
                    if(IsType.isInt(line)) {

                        if(writers.get(0) == null) {
                            try {
                                writers.set(0, new FileWriter(paths.get(0), typeAdd));
                            }
                            catch(IOException e) {

                            }
                        }
                        if(writers.get(0) != null) {
                            writers.get(0).write(line+'\n');
                            cnt.set(0,cnt.get(0)+1);

                            BigInteger tmp = new BigInteger(line);
                            if(integer_stat.get(0) == null ||  integer_stat.get(0).compareTo(tmp) == 1){
                                integer_stat.set(0,tmp);
                            }
                            if(integer_stat.get(1) == null ||  integer_stat.get(1).compareTo(tmp) == -1){
                                integer_stat.set(1,tmp);
                            }
                            integer_stat.set(2,integer_stat.get(2).add(tmp));
                        }
                    }
                    else if(IsType.isFloat(line)) {
                        if(writers.get(1) == null) {
                            try {
                                writers.set(1, new FileWriter(paths.get(1), typeAdd));
                            }
                            catch(IOException e) {

                            }
                        }
                        if(writers.get(1) != null) {
                            writers.get(1).write(line+'\n');
                            cnt.set(1,cnt.get(1)+1);

                            BigDecimal tmp = new BigDecimal(line);
                            if(floats_stat.get(0) == null ||  floats_stat.get(0).compareTo(tmp) == 1){
                                floats_stat.set(0,tmp);
                            }
                            if(floats_stat.get(1) == null ||  floats_stat.get(1).compareTo(tmp) == -1){
                                floats_stat.set(1,tmp);
                            }
                            floats_stat.set(2,floats_stat.get(2).add(tmp));
                        }
                    }
                    else {
                        if(writers.get(2) == null) {
                            try {
                                writers.set(2, new FileWriter(paths.get(2), typeAdd));
                            }
                            catch(IOException e) {

                            }
                        }
                        if(writers.get(2) != null) {
                            writers.get(2).write(line+'\n');
                            cnt.set(2,cnt.get(2)+1);

                            string_stat.set(0,cnt.get(2));
                            if(string_stat.get(1) == null || line.length() < string_stat.get(1)) {
                                string_stat.set(1,line.length());
                            }
                            if(string_stat.get(2) == null || line.length() > string_stat.get(2) ) {
                                string_stat.set(2,line.length());
                            }

                        }
                    }
                    line = reader.readLine();
                }
            }
            catch (IOException e) {

            }

        }
        for(int i = 0; i < 3; i++) {
            if(writers.get(i) != null) {
                try {
                    writers.get(i).close();
                }
                catch (IOException e) {

                }
            }
        }
    }
}
