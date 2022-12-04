package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Part1Tests {

    @Test
    public void testOverLaps(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.overlaps()).isEqualTo(2);
    }

    @Test
    public void part1OverLapsTest(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.overlaps()).isEqualTo(599);
    }
}
