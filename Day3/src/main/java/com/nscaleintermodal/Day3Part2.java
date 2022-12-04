package com.nscaleintermodal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day3Part2 {

    List<elfGroup> elfGroups;
    public Day3Part2(String fileName) {

        List<String> lines;

        File f = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            lines = reader.lines().collect(Collectors.toList());
        } catch (java.io.FileNotFoundException fnfe) {
            lines = new ArrayList<>();
        }

        elfGroups = new ArrayList<>();

        for(int i=0;i<lines.size();i+=3){
            elfGroups.add(new elfGroup(lines.get(i),lines.get(i+1),lines.get(i+2)));
        }
    }

    public int priorityTotal() {
        return elfGroups.stream().map(o -> o.priority(o.common())).reduce(0,Integer::sum);
    }
}
