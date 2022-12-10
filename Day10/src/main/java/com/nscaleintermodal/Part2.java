package com.nscaleintermodal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Part2 {

    List<Integer> values;
    List<String> screen;

    public Part2(String fileName) {
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

        screen = new ArrayList<>();
    }

    private String getPixelValue(int currentPixel,int spriteCenter){
        if(currentPixel==spriteCenter || currentPixel+1 == spriteCenter || currentPixel-1 == spriteCenter){
            return "#";
        }
        return ".";
    }

    private void buildScreen() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <values.size() ; i++) {
            if(i!=0 && i%40==0){
                screen.add(builder.toString());
                builder = new StringBuilder();
            }
            builder.append(getPixelValue((i%40),values.get(i)));
        }
        screen.add(builder.toString());
    }

    public String solution(){
        buildScreen();
        StringBuilder outputBuilder = new StringBuilder();
        for(int i=0;i<6;i++){
            System.out.println(screen.get(i));
            outputBuilder.append(screen.get(i)).append("\n");
        }
        return outputBuilder.toString();
    }

}
