package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Part2Tests {

    @Test
    public void testSolution1(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        assertThat(testObject.solution()).isEqualTo(1);
    }

    @Test
    public void testSolution2(){
        String dataFileName = this.getClass().getResource("testdata2.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        assertThat(testObject.solution()).isEqualTo(36);
    }

    @Test
    public void part2SolutionTest(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        assertThat(testObject.solution()).isEqualTo(928);
    }
}
