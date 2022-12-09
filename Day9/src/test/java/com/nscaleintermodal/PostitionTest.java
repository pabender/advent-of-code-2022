package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PostitionTest {

    @Test
    public void getPositionTest(){
        Position p = new Position(1,2);
        assertThat(p.getX()).isEqualTo(1);
        assertThat(p.getY()).isEqualTo(2);
    }

}