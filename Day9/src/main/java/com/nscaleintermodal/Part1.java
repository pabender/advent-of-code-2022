package com.nscaleintermodal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Part1 {

    private List<String> lines;
    private Position H;
    private Position T;

    Set<Position> positionSet;
    public Part1(String fileName) {

        File f = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            lines = reader.lines().collect(Collectors.toList());
        } catch (java.io.FileNotFoundException fnfe) {
            lines = new ArrayList<>();
        }

        H= new Position(0,0);
        T= new Position(0,0);
        positionSet = new HashSet<>();
        positionSet.add(new Position(T.getX(), T.getY()));

    }

    private void move(String movement){
        char direction=movement.charAt(0);
        int steps = Integer.parseInt(movement.substring(2));
        for(int i=0;i<steps;i++){
            singleMove(direction);
        }
    }

    private void singleMove(char direction) {
        switch(direction){
            case 'R':
                H.right();
                followMove(H,T);
                positionSet.add(new Position(T.getX(), T.getY()));
                break;
            case 'L':
                H.left();
                followMove(H,T);
                positionSet.add(new Position(T.getX(), T.getY()));
                break;
            case 'U':
                H.up();
                followMove(H,T);
                positionSet.add(new Position(T.getX(), T.getY()));
                break;
            case 'D':
                H.down();
                followMove(H,T);
                positionSet.add(new Position(T.getX(), T.getY()));
                break;
            default:
        }
    }

    private void followMove(Position head,Position tail){
        if(Math.abs(head.getX()-tail.getX())>1 || Math.abs(head.getY()-tail.getY())>1){
            if(head.getX()>tail.getX()){
                tail.right();
            } else if(head.getX()<tail.getX()){
                tail.left();
            }
            if(head.getY()>tail.getY()){
                tail.up();
            } else if(head.getY()<tail.getY()){
                tail.down();
            }
        }

    }

    public int solution() {
        for(String s:lines){
            move(s);
        }
        return positionSet.size();
    }

}
