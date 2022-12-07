package com.nscaleintermodal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Part2 {

    DirectoryNode root;
    public Part2(String fileName) {
        List<String> lines;

        File f = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            lines = reader.lines().collect(Collectors.toList());
        } catch (java.io.FileNotFoundException fnfe) {
            lines = new ArrayList<>();
        }

        root = new DirectoryNode("/");

        parseInput(lines);

    }

    private void parseInput(List<String> lines) {
        DirectoryNode currentDirectory  = root;
        Stack<DirectoryNode> parents= new Stack();

        for(String s:lines){
            if(s.equals("$ cd /")){
                currentDirectory=root;
                parents = new Stack();
            } else if(s.equals("$ cd ..")){
                if(!parents.isEmpty()){
                    currentDirectory=parents.pop();
                }
            } else if(s.startsWith("$ cd ")) {
                parents.push(currentDirectory);
                String subDirectoryName = s.substring(4);
                currentDirectory = (DirectoryNode) (currentDirectory.getChildWithName(subDirectoryName));
            } else if(s.equals("$ ls")) {
                // no op for this purpose
            } else if(s.startsWith("dir ")){
                currentDirectory.add(new DirectoryNode(s.substring(3)));
            } else {
                Long size = Long.parseLong(s.substring(0, s.indexOf(" ")));
                String name = s.substring(s.indexOf(" ") + 1);
                currentDirectory.add(new FileNode(name, size));
            }
        }

    }

    public long getSolution(){
        return root.findSmallestOver(root.getSize()-(70000000L-30000000L));
    }


    public long getRootSize() {
        return root.getSize();
    }


}
