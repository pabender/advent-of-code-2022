package com.nscaleintermodal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Part2Monkey implements Comparable{

    private List<Value> items;
    private int examined = 0;
    private String operand;
    private String operator;

    private int monkeyID;
    private int tossToIfTrue;
    private int tossToIfFalse;

    private int divisibilityTest;

    public Part2Monkey(int monkeyID){
        items = new ArrayList<>();
        this.monkeyID = monkeyID;
    }
    public int itemCount() {
        return items.size();
    }

    public void toss(int i) {
        items.add(new Value(i));
    }

    public void toss(Value i) {
        items.add(i);
    }

    public void examineAll(List<Part2Monkey> monkeys) {
        List<Value> keepList =new ArrayList();
        for(Value i:items){
            Value newWorryLevel = calculateNewWorryLevel(i);
            //newWorryLevel = newWorryLevel/3;
            int tossTo = tossToMonkey(newWorryLevel);
            if(tossTo==monkeyID) {
                if(newWorryLevel.divisibleBy(divisibilityTest)) {
                    newWorryLevel.divide(divisibilityTest);
                    keepList.add(newWorryLevel);
                } else {
                    keepList.add(newWorryLevel);
                }
            } else {
                if(!monkeys.isEmpty()){
                    if(newWorryLevel.divisibleBy(divisibilityTest)) {
                        newWorryLevel.divide(divisibilityTest);
                        monkeys.get(tossTo).toss(newWorryLevel);
                    } else {
                        monkeys.get(tossTo).toss(newWorryLevel);
                    }
                }
            }
            examined++;
        }
        items = keepList;

    }

    private int tossToMonkey(Value newWorryLevel) {
        return (newWorryLevel.divisibleBy(divisibilityTest )?tossToIfTrue:tossToIfFalse);
    }

    private Value calculateNewWorryLevel(Value i) {
        switch(operator) {
            case "*": return multiply(i);
            case "+": return add(i);
        }
        return new Value(0);
    }

    private Value add(Value i) {
        i.add(getOperand(i));
        return i;
    }

    private Value getOperand(Value i) {
        if(operand.equals("old")){
            return i;
        }
        return new Value(Integer.parseInt(operand));
    }

    private Value multiply(Value i) {
        i.multiply(getOperand(i));
        return i;
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
        if (!(o instanceof Part2Monkey)) return false;
        Part2Monkey monkey = (Part2Monkey) o;
        return examined == monkey.examined;
    }

    @Override
    public int hashCode() {
        return Objects.hash(examined);
    }

    @Override
    public int compareTo(Object o) {
        if(! (o instanceof Part2Monkey))
            return 0;
        return(getExamined() - ((Part2Monkey)o).getExamined());
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
