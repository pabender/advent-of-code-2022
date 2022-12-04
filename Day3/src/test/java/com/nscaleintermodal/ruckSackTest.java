package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ruckSackTest {

    @Test
    public void findCommonItem(){
        assertThat(new ruckSack("vJrwpWtwJgWrhcsFMMfFFhFp").common()).isEqualTo('p');
    }

    @Test
    public void priorityTest(){
        assertThat(new ruckSack("vJrwpWtwJgWrhcsFMMfFFhFp").priority('p')).isEqualTo(16);
        assertThat(new ruckSack("vJrwpWtwJgWrhcsFMMfFFhFp").priority('L')).isEqualTo(38);
    }
}
