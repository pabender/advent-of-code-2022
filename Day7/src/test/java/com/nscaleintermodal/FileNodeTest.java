package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FileNodeTest {
    @Test
    public void getName(){
        assertThat(new FileNode("foo",25L).getName()).isEqualTo("foo");
    }

    @Test
    public void getSizeEmpty(){
        assertThat(new FileNode("foo",25L).getSize()).isEqualTo(25L);
    }
}
