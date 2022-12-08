package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Part1Tests {


    @Test
    public void testSolution(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.solution()).isEqualTo(21);
    }

    @Test
    public void part1SolutionTest(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.solution()).isEqualTo(1829);
    }
}
