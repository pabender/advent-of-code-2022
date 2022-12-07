package com.nscaleintermodal;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DirectoryNodeTest {

    @Test
    public void getName(){
        assertThat(new DirectoryNode("foo").getName()).isEqualTo("foo");
    }

    @Test
    public void getSizeEmpty(){
        assertThat(new DirectoryNode("foo").getSize()).isEqualTo(0L);
    }

    @Test
    public void getSizeWithChildren(){
        DirectoryNode directory = new DirectoryNode("/");
        directory.add(new FileNode("foo",5L));
        assertThat(directory.getSize()).isEqualTo(5L);
    }

    @Test
    public void getRecursiveSize(){
        DirectoryNode directory = new DirectoryNode("/");
        directory.add(new FileNode("foo",5L));
        DirectoryNode directory2 = new DirectoryNode("bar");
        directory2.add(new FileNode("hello",10L));
        directory.add(directory2);
        assertThat(directory.getSize()).isEqualTo(15L);
    }

    @Test
    public void getDirectoryList() {
        DirectoryNode directory = new DirectoryNode("/");
        directory.add(new FileNode("foo", 5L));
        DirectoryNode directory2 = new DirectoryNode("bar");
        directory2.add(new FileNode("hello", 10L));
        directory.add(directory2);
        List<node> directoryList = directory.getList();
        assertThat(directoryList).isNotNull();
        assertThat(directoryList.size()).isEqualTo(2);
    }

    @Test
    public void getCalculate100KSums() {
        DirectoryNode directory = new DirectoryNode("/");
        directory.add(new FileNode("foo", 5L));
        DirectoryNode directory2 = new DirectoryNode("bar");
        directory2.add(new FileNode("hello", 10L));
        directory.add(directory2);
        assertThat(directory.calculate100KSum()).isEqualTo(25L);
    }
    @Test
    public void getChildWithName() {
        DirectoryNode directory = new DirectoryNode("/");
        directory.add(new FileNode("foo", 5L));
        DirectoryNode directory2 = new DirectoryNode("bar");
        directory2.add(new FileNode("hello", 10L));
        directory.add(directory2);
        assertThat(directory.getChildWithName("bar")).isEqualTo(directory2);
    }

}
