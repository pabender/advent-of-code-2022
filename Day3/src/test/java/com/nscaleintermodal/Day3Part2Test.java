package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Day3Part2Test {

    @Test
    public void totalScoreTest(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Day3Part2 testObject = new Day3Part2(dataFileName);
        assertThat(testObject.priorityTotal()).isEqualTo(70);
    }

    @Test
    public void part1ScoreTest(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        Day3Part2 testObject = new Day3Part2(dataFileName);
        assertThat(testObject.priorityTotal()).isEqualTo(2817);
    }
}
