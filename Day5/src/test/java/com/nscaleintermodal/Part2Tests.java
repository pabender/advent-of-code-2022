package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Part2Tests {

    @Test
    public void testMoves(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        testObject.moves();
        assertThat(testObject.result()).isEqualTo("MCD");
    }

    @Test
    public void par2Moves(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        testObject.moves();
        assertThat(testObject.result()).isEqualTo("QZFJRWHGS");
    }
}
