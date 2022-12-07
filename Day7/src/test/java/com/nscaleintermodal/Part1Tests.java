package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Part1Tests {

    @Test
    public void testTotalSize(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.getRootSize()).isEqualTo(48381165L);
    }

    @Test
    public void testSolution(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.getSolution()).isEqualTo(95437L);
    }

    @Test
    public void part1Solution(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.getSolution()).isEqualTo(1491614L);
    }
}
