package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RockPaperScissorsTests {

    @Test
    public void totalScoreTest(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        RockPaperScissors testObject = new RockPaperScissors(dataFileName);
        assertThat(testObject.score()).isEqualTo(15);
    }

    @Test
    public void part1ScoreTest(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        RockPaperScissors testObject = new RockPaperScissors(dataFileName);
        assertThat(testObject.score()).isEqualTo(8392);
    }
    @Test
    public void totalPredictTest(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        RockPaperScissors testObject = new RockPaperScissors(dataFileName);
        assertThat(testObject.predict()).isEqualTo(12);
    }

    @Test
    public void part2PredictTest(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        RockPaperScissors testObject = new RockPaperScissors(dataFileName);
        assertThat(testObject.predict()).isEqualTo(8392);
    }

}
