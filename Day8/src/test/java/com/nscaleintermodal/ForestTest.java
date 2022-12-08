package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ForestTest {


    @Test
    public void testGetTree(){
        List<String> singleValueInput = new ArrayList<>();
        singleValueInput.add("1");
        Forest forest = new Forest(singleValueInput);
        assertThat(forest.getTree(0,0).height()).isEqualTo(1);
    }

    @Test
    public void testCountVisible(){
        List<String> singleValueInput = new ArrayList<>();
        singleValueInput.add("1");
        Forest forest = new Forest(singleValueInput);
        assertThat(forest.countVisible()).isEqualTo(1);
    }

    @Test
    public void testMaxScenicScore(){
        List<String> singleValueInput = new ArrayList<>();
        singleValueInput.add("1");
        Forest forest = new Forest(singleValueInput);
        assertThat(forest.maxScenicScore()).isEqualTo(0);
    }

}
