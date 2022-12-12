package com.nscaleintermodal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Monkey implements Comparable{

    private List<Integer> items;
    private int examined = 0;
    private String operand;
    private String operator;

    private int monkeyID;
    private int tossToIfTrue;
    private int tossToIfFalse;

    private int divisibilityTest;

    public Monkey(int monkeyID){
        items = new ArrayList<>();
        this.monkeyID = monkeyID;
    }
    public int itemCount() {
        return items.size();
    }

    public void toss(int i) {
        items.add(i);
    }

    public void examineAll(List<Monkey> monkeys) {
        List<Integer> keepList =new ArrayList();
        for(Integer i:items){
            Integer newWorryLevel = calculateNewWorryLevel(i);
            newWorryLevel = newWorryLevel/3;
            int tossTo = tossToMonkey(newWorryLevel);
            if(tossTo==monkeyID) {
                keepList.add(newWorryLevel);
            } else {
                if(!monkeys.isEmpty()){
                    monkeys.get(tossTo).toss(newWorryLevel);
                }
            }
            examined++;
        }
        items = keepList;

    }

    private int tossToMonkey(Integer newWorryLevel) {
        return (newWorryLevel % divisibilityTest == 0)?tossToIfTrue:tossToIfFalse;
    }

    private Integer calculateNewWorryLevel(Integer i) {
        switch(operator) {
            case "*": return multiply(i);
            case "+": return add(i);
        }
        return 0;
    }

    private Integer add(Integer i) {
        return i+getOperand(i);
    }

    private Integer getOperand(Integer i) {
        if(operand.equals("old")){
            return i;
        }
        return Integer.parseInt(operand);
    }

    private Integer multiply(Integer i) {
        return i*getOperand(i);
    }

    public int getExamined() {
        return examined;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monkey)) return false;
        Monkey monkey = (Monkey) o;
        return examined == monkey.examined;
    }

    @Override
    public int hashCode() {
        return Objects.hash(examined);
    }

    @Override
    public int compareTo(Object o) {
        if(! (o instanceof Monkey))
            return 0;
        return(getExamined() - ((Monkey)o).getExamined());
    }

    public void setDivisibilityTest(int divTest) {
        this.divisibilityTest = divTest;
    }

    public void setTossToIfTrue(int tossToIfTrue) {
        this.tossToIfTrue = tossToIfTrue;
    }

    public void setTossToIfFalse(int tossToIfFalse) {
        this.tossToIfFalse = tossToIfFalse;
    }

}
