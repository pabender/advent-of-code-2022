package com.nscaleintermodal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Part2 {

    List<RangePairs> rangePairs;
    public Part2(String fileName) {
        List<String> lines;

        File f = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            lines = reader.lines().collect(Collectors.toList());
        } catch (java.io.FileNotFoundException fnfe) {
            lines = new ArrayList<>();
        }
        rangePairs = lines.stream().map(s -> parseRange(s)).collect(Collectors.toList());

    }

    private RangePairs parseRange(String line){
        int start1=Integer.parseInt(line.substring(0,line.indexOf('-')));
        int end1=Integer.parseInt(line.substring(line.indexOf('-')+1,line.indexOf(',')));
        int start2=Integer.parseInt(line.substring(line.indexOf(',')+1,line.lastIndexOf('-')));
        int end2=Integer.parseInt(line.substring(line.lastIndexOf('-')+1));

        return new RangePairs(start1,end1,start2,end2);
    }

    public long overlaps() {
        return rangePairs.stream().filter(o-> o.overLap()).count();
    }
}
