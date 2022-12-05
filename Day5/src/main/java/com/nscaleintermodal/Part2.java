package com.nscaleintermodal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Part2 {
    List<Stack<String>> stacks;
    List<String> moveList;

    public Part2(String fileName) {
        List<String> lines;

        File f = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            lines = reader.lines().collect(Collectors.toList());
        } catch (java.io.FileNotFoundException fnfe) {
            lines = new ArrayList<>();
        }

        int dividingLine=0;
        for(String s:lines){
            if(s.isEmpty()) {
                break;
            }
            dividingLine++;
        }

        int index = lines.get(dividingLine-1).lastIndexOf("  ")+2;
        int numStacks=Integer.parseInt(lines.get(dividingLine-1)
                .substring(index,index+1));
        stacks = new ArrayList<>();

        for(int i=0;i<numStacks;i++){
            stacks.add(new Stack());
        }

        for(int i=dividingLine-2;i>=0;i--){
            String line = lines.get(i);
            for(int j=0;j<numStacks;j++){
                int start=j*4;
                int end=start+2;
                if(start>line.length() || end > line.length()) continue;
                if(!(line.substring(start+1,end).isBlank())){
                    stacks.get(j).push(line.substring(start+1,end));
                }
            }
        }

        moveList = new ArrayList<>();
        for(int i=dividingLine+1;i<lines.size();i++){
            moveList.add(lines.get(i));
        }

    }

    public void moves() {
        for(String s:moveList){
            int count = Integer.parseInt(s.substring(s.indexOf("move ")+5,s.indexOf(" from ")));
            int fromStack = Integer.parseInt(s.substring(s.indexOf(" from ")+6,s.indexOf(" to ")));
            int toStack = Integer.parseInt(s.substring(s.lastIndexOf(" ")+1));

            Stack<String> temp = new Stack<>();

            for(int i=0;i<count;i++){
                temp.push(stacks.get(fromStack-1).pop());
            }

            for(int i=0;i<count;i++){
                stacks.get(toStack-1).push(temp.pop());
            }


        }
    }

    public String result(){
        StringBuilder sb = new StringBuilder();
        for(Stack s:stacks){
            sb.append((String) s.peek());
        }
        return sb.toString();
    }

}
