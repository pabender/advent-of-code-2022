package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Day3Part1Test {

    @Test
    public void totalScoreTest(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Day3Part1 testObject = new Day3Part1(dataFileName);
        assertThat(testObject.priorityTotal()).isEqualTo(157);
    }

    @Test
    public void part1ScoreTest(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        Day3Part1 testObject = new Day3Part1(dataFileName);
        assertThat(testObject.priorityTotal()).isEqualTo(8185);
    }
}
