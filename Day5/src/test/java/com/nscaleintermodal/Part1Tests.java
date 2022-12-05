package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Part1Tests {


    @Test
    public void testMoves(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        testObject.moves();
        assertThat(testObject.result()).isEqualTo("CMZ");
    }

    @Test
    public void part1Moves(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        testObject.moves();
        assertThat(testObject.result()).isEqualTo("ZSQVCCJLL");
    }
}
