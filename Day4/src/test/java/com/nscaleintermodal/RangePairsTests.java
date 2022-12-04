package com.nscaleintermodal;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ranges.RangeException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RangePairsTests {

    @Test
    public void testContains(){
        assertThat(new RangePairs(1,4,5,6).subRange()).isFalse();
        assertThat(new RangePairs(1,4,2,3).subRange()).isTrue();
        assertThat(new RangePairs(2,3,1,4).subRange()).isTrue();
    }

    @Test
    public void testOverLap(){
        assertThat(new RangePairs(1,4,5,6).overLap()).isFalse();
        assertThat(new RangePairs(1,4,2,3).overLap()).isTrue();
        assertThat(new RangePairs(2,3,1,4).overLap()).isTrue();
        assertThat(new RangePairs(1,4,2,6).overLap()).isTrue();
        assertThat(new RangePairs(2,6,1,4).overLap()).isTrue();

    }

}
