package com.nscaleintermodal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 {

    List<Integer> values;
    public Part1(String fileName) {
        List<String> lines;

        File f = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            lines = reader.lines().collect(Collectors.toList());
        } catch (java.io.FileNotFoundException fnfe) {
            lines = new ArrayList<>();
        }

        values = new ArrayList<>();

        values.add(Integer.valueOf(1));

        for(String s:lines){
            values.add(values.get(values.size()-1)); // for both noop and addx, one cycle ends with the last value.
            if(s.startsWith("addx")){
                values.add(values.get(values.size()-1)+Integer.parseInt(s.substring(5)));
            }
        }

    }

    public int solution(){
        return values.get(19)*20 +
                values.get(59)*60 +
                values.get(99)*100 +
                values.get(139)*140 +
                values.get(179)*180 +
                values.get(219)*220;
    }
}
