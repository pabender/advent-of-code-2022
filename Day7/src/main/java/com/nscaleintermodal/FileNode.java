package com.nscaleintermodal;

public class FileNode implements node {


    private String name;
    private long size;
    public FileNode(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }
}
