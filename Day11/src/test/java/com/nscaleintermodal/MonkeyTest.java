package com.nscaleintermodal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MonkeyTest {

    @Test
    public void testItemList(){
        Monkey testMonkey = new Monkey(1);
        assertThat(testMonkey.itemCount()).isEqualTo(0);
    }

    @Test
    public void testToss(){
        Monkey testMonkey = new Monkey(1);
        testMonkey.toss(5);
        assertThat(testMonkey.itemCount()).isEqualTo(1);
    }

    @Test
    public void testExamineCount(){
        Monkey testMonkey = new Monkey(1);
        testMonkey.toss(5);
        testMonkey.toss(10);
        testMonkey.toss(15);
        testMonkey.setOperator("+");
        testMonkey.setOperand("1");
        testMonkey.setTossToIfTrue(1);
        testMonkey.setTossToIfFalse(1);
        testMonkey.setDivisibilityTest(2);
        testMonkey.examineAll(List.of(testMonkey));
        assertThat(testMonkey.getExamined()).isEqualTo(3);
    }
    @Test
    public void monkeyCompare(){
        Monkey monkey1 = new Monkey(1);
        Monkey monkey2 = new Monkey(2);
        monkey1.toss(1);
        monkey2.toss(2);
        monkey2.toss(5);
        monkey1.setOperator("+");
        monkey1.setOperand("1");
        monkey1.setTossToIfTrue(1);
        monkey1.setTossToIfFalse(1);
        monkey1.setDivisibilityTest(2);
        monkey1.examineAll(List.of(monkey1,monkey2));
        monkey2.setTossToIfTrue(1);
        monkey2.setTossToIfFalse(1);
        monkey2.setDivisibilityTest(2);
        monkey2.setOperator("+");
        monkey2.setOperand("1");
        monkey2.examineAll(List.of(monkey1,monkey2));
        Assertions.assertThat(monkey2).isGreaterThan(monkey1);
    }


}
