package com.nscaleintermodal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RockPaperScissors {

    List<Hand> hands;
    public RockPaperScissors(String fileName) {
        List<String> lines;

        File f = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            lines = reader.lines().collect(Collectors.toList());
        } catch (java.io.FileNotFoundException fnfe) {
            lines = new ArrayList<>();
        }

        hands = new ArrayList<>();
        for(String s:lines){
            List<String> choices = Stream.of(s.split(" "))
                    .map (elem -> new String(elem))
                    .collect(Collectors.toList());
            hands.add(new Hand(choices.get(0),choices.get(1)));
        }

    }


    public int score() {
        return hands.stream().map(o -> o.score()).reduce(0,Integer::sum);
    }
    public int predict() {
        return hands.stream().map(o -> o.predict()).reduce(0,Integer::sum);
    }
}
