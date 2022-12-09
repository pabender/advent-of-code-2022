package com.nscaleintermodal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Part2 {
    private List<String> lines;
    List<Position> knots;

    Set<Position> positionSet;
    public Part2(String fileName) {

        File f = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            lines = reader.lines().collect(Collectors.toList());
        } catch (java.io.FileNotFoundException fnfe) {
            lines = new ArrayList<>();
        }

        knots = new ArrayList<>();

        for(int i=0;i<10;i++) {
            knots.add(new Position(0,0));
        }

        positionSet = new HashSet<>();
        positionSet.add(new Position(knots.get(9).getX(), knots.get(9).getY()));


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
                knots.get(0).right();
                for(int i=0;i<9;i++) {
                    followMove(knots.get(i), knots.get(i+1));
                }
                positionSet.add(new Position(knots.get(9).getX(), knots.get(9).getY()));
                break;
            case 'L':
                knots.get(0).left();
                for(int i=0;i<9;i++) {
                    followMove(knots.get(i), knots.get(i+1));
                }
                positionSet.add(new Position(knots.get(9).getX(), knots.get(9).getY()));
                break;
            case 'U':
                knots.get(0).up();
                for(int i=0;i<9;i++) {
                    followMove(knots.get(i), knots.get(i+1));
                }
                positionSet.add(new Position(knots.get(9).getX(), knots.get(9).getY()));
                break;
            case 'D':
                knots.get(0).down();
                for(int i=0;i<9;i++) {
                    followMove(knots.get(i), knots.get(i+1));
                }
                positionSet.add(new Position(knots.get(9).getX(), knots.get(9).getY()));
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
