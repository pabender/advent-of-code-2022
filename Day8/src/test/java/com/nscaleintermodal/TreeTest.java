package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TreeTest {

    @Test
    public void testTreeHeight(){
        assertThat((new tree(5)).height()).isEqualTo(5);
    }
}
