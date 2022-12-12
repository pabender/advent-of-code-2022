package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Part2Tests {

    @Test
    public void testSolution(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        testObject.simulate(10000);
        assertThat(testObject.solution()).isEqualTo(BigInteger.valueOf(2713310158l));
    }

    @Test
    public void part2Solution(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        testObject.simulate(10000);
        assertThat(testObject.solution()).isEqualTo(BigInteger.valueOf(0l));
    }
}
