package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class elfGroupTest {

    @Test
    public void findCommonItem(){
        assertThat(new elfGroup("vJrwpWtwJgWrhcsFMMfFFhFp","jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL","PmmdzqPrVvPwwTWBwg").common()).isEqualTo('r');
    }

    @Test
    public void priorityTest(){
        assertThat(new elfGroup("vJrwpWtwJgWrhcsFMMfFFhFp","jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL","PmmdzqPrVvPwwTWBwg").priority('p')).isEqualTo(16);
        assertThat(new elfGroup("vJrwpWtwJgWrhcsFMMfFFhFp","jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL","PmmdzqPrVvPwwTWBwg").priority('L')).isEqualTo(38);
    }
}
