package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class HandTests {
    @Test
    public void handScore(){
        assertThat(new Hand("A","Y").score()).isEqualTo(8);
        assertThat(new Hand("B","X").score()).isEqualTo(1);
        assertThat(new Hand("C","Z").score()).isEqualTo(6);
    }

    @Test
    public void predictScore(){
        assertThat(new Hand("A","Y").predict()).isEqualTo(4);
        assertThat(new Hand("B","X").predict()).isEqualTo(1);
        assertThat(new Hand("C","Z").predict()).isEqualTo(7);
    }
}
