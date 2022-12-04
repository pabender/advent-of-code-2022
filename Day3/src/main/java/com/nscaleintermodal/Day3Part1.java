package com.nscaleintermodal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day3Part1 {

    List<ruckSack> ruckSacks;
    public Day3Part1(String fileName) {

        List<String> lines;

        File f = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            lines = reader.lines().collect(Collectors.toList());
        } catch (java.io.FileNotFoundException fnfe) {
            lines = new ArrayList<>();
        }

        ruckSacks = new ArrayList<>();

        for(String line:lines){
            ruckSacks.add(new ruckSack(line));
        }
    }

    public int priorityTotal() {
        return ruckSacks.stream().map(o -> o.priority(o.common())).reduce(0,Integer::sum);
    }
}
