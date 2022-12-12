package com.nscaleintermodal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Part2Monkey implements Comparable{

    private List<BigDecimal> items;
    private BigInteger examined;
    private String operand;
    private String operator;

    private int monkeyID;
    private int tossToIfTrue;
    private int tossToIfFalse;

    private BigDecimal divisibilityTest;

    public Part2Monkey(int monkeyID){
        examined = BigInteger.ZERO;
        items = new ArrayList<>();
        this.monkeyID = monkeyID;
    }
    public int itemCount() {
        return items.size();
    }

    public void toss(BigDecimal i) {
        items.add(i);
    }

    public void examineAll(List<Part2Monkey> monkeys) {
        List<BigDecimal> keepList =new ArrayList();
        for(BigDecimal i:items){
            BigDecimal newWorryLevel = calculateNewWorryLevel(i);
            int tossTo = tossToMonkey(newWorryLevel);
            if(tossTo==monkeyID) {
                keepList.add(newWorryLevel);
            } else {
                if(!monkeys.isEmpty()){
                    monkeys.get(tossTo).toss(newWorryLevel);
                }
            }
            examined=examined.add(BigInteger.valueOf(1l));
        }
        items = keepList;

    }

    private int tossToMonkey(BigDecimal newWorryLevel) {
        BigDecimal result[]=newWorryLevel.divideAndRemainder(divisibilityTest);
        return (result[1].equals(BigInteger.valueOf(0)))?tossToIfTrue:tossToIfFalse;
    }

    private BigDecimal calculateNewWorryLevel(BigDecimal i) {
        switch(operator) {
            case "*": return multiply(i);
            case "+": return add(i);
        }
        return BigDecimal.valueOf(0);
    }

    private BigDecimal add(BigDecimal i) {
        return i.add(getOperand(i));
    }

    private BigDecimal getOperand(BigDecimal i) {
        if(operand.equals("old")){
            return i;
        }
        return BigDecimal.valueOf(Integer.parseInt(operand));
    }

    private BigDecimal multiply(BigDecimal i) {
        return i.multiply(getOperand(i));
    }

    public BigInteger getExamined() {
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
        return getExamined().compareTo(((Part2Monkey)o).getExamined());
    }

    public void setDivisibilityTest(int divTest) {
        this.divisibilityTest = BigDecimal.valueOf(divTest);
    }

    public void setTossToIfTrue(int tossToIfTrue) {
        this.tossToIfTrue = tossToIfTrue;
    }

    public void setTossToIfFalse(int tossToIfFalse) {
        this.tossToIfFalse = tossToIfFalse;
    }

}
