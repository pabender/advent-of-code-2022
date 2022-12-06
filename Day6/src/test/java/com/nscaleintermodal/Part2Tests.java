package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Part2Tests {

    @Test
    public void testStartOfMessage(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        assertThat(testObject.startOfMessage()).isEqualTo(19);
    }
    @Test
    public void testStartOfMessage1(){
        String dataFileName = this.getClass().getResource("testdata1.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        assertThat(testObject.startOfMessage()).isEqualTo(23);
    }

    @Test
    public void testStartOfMessage2(){
        String dataFileName = this.getClass().getResource("testdata2.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        assertThat(testObject.startOfMessage()).isEqualTo(23);
    }

    @Test
    public void testStartOfMessage3(){
        String dataFileName = this.getClass().getResource("testdata3.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        assertThat(testObject.startOfMessage()).isEqualTo(29);
    }
    @Test
    public void testStartOfMessage4(){
        String dataFileName = this.getClass().getResource("testdata4.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        assertThat(testObject.startOfMessage()).isEqualTo(26);
    }


    @Test
    public void part2StartOfMessage(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        Part2 testObject = new Part2(dataFileName);
        assertThat(testObject.startOfMessage()).isEqualTo(2313);
    }
}
