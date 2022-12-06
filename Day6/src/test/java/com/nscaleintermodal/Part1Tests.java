package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Part1Tests {


    @Test
    public void testStartOfPacket(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.startOfPacket()).isEqualTo(7);
    }
    @Test
    public void testStartOfPacket1(){
        String dataFileName = this.getClass().getResource("testdata1.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.startOfPacket()).isEqualTo(5);
    }

    @Test
    public void testStartOfPacket2(){
        String dataFileName = this.getClass().getResource("testdata2.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.startOfPacket()).isEqualTo(6);
    }

    @Test
    public void testStartOfPacket3(){
        String dataFileName = this.getClass().getResource("testdata3.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.startOfPacket()).isEqualTo(10);
    }
    @Test
    public void testStartOfPacket4(){
        String dataFileName = this.getClass().getResource("testdata4.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.startOfPacket()).isEqualTo(11);
    }


    @Test
    public void part1StartOfPacket(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.startOfPacket()).isEqualTo(1892);
    }
}
