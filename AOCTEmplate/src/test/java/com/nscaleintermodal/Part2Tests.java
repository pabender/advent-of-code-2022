package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Part2Tests {

    @Test
    public void testOverLaps(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        assertThat(testObject.solution()).isEqualTo(4);
    }

    @Test
    public void part1OverLapsTest(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        assertThat(testObject.solution()).isEqualTo(928);
    }
}
