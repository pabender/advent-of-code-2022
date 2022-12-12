package com.nscaleintermodal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 {

    List<Monkey> monkeys;
    public Part1(String fileName) {
        List<String> lines;

        File f = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            lines = reader.lines().collect(Collectors.toList());
        } catch (java.io.FileNotFoundException fnfe) {
            lines = new ArrayList<>();
        }

        monkeys = new ArrayList<>();

        for(int i=0;i<lines.size();i=i+7){
            Monkey m = new Monkey(Integer.parseInt(lines.get(i).substring(7,8)));
            String[] parts = lines.get(i+1).split(":");
            String[] values = parts[1].split(",");
            for(int j=0;j<values.length;j++){
                m.toss(Integer.parseInt(values[j].substring(1)));
            }
            parts = lines.get(i+2).split(":");
            values = parts[1].split(" ");
            m.setOperator(values[values.length-2]);
            m.setOperand(values[values.length-1]);
            m.setDivisibilityTest(Integer.parseInt(lines.get(i+3).substring(lines.get(i+3).lastIndexOf(" ")+1)));
            m.setTossToIfTrue(Integer.parseInt(lines.get(i+4).substring(lines.get(i+4).lastIndexOf(" ")+1)));
            m.setTossToIfFalse(Integer.parseInt(lines.get(i+5).substring(lines.get(i+5).lastIndexOf(" ")+1)));
            monkeys.add(m);
        }

    }

    public void simulate(int itterations){
        for(int i=0;i<itterations;i++) {
            for (Monkey m : monkeys) {
                m.examineAll(monkeys);
            }
        }
    }

    public int solution(){
        Collections.sort(monkeys);
        return monkeys.get(monkeys.size()-2).getExamined()*monkeys.get(monkeys.size()-1).getExamined();
    }
}
