package com.nscaleintermodal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 {

    List<elf> elves;
    public Part1(String fileName) {

        List<String> lines;

        File f = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            lines = reader.lines().collect(Collectors.toList());
        } catch (java.io.FileNotFoundException fnfe) {
            lines = new ArrayList<>();
        }

        elves = new ArrayList<>();

        List<Integer> snacks = new ArrayList<>();
        int elfCount=0;

        for (String line : lines) {
            if(line.isEmpty()){
                elves.add(new elf(++elfCount,snacks));
                snacks=new ArrayList<>();
            }
            else {
                snacks.add(Integer.parseInt(line));
            }
        }

        if(!snacks.isEmpty()){
            elves.add(new elf(++elfCount,snacks));
        }

    }

    int elfCount(){
        return elves.size();
    }

    int maxElf(){
        Collections.sort(elves);
        return elves.get(0).getElfNumber();
        //return elves.stream().sorted().findFirst().get().getElfNumber();
    }

    int maxElfCalories(){
        return elves.stream().sorted().findFirst().get().cal_sum();
    }

    int top3ElfCalories() {
        Collections.sort(elves);
        return elves.get(0).cal_sum() + elves.get(1).cal_sum() + elves.get(2).cal_sum();

    }
}
