package com.nscaleintermodal;

import java.util.Objects;

public class node {

    private int x;
    private int y;

    int height=Integer.MAX_VALUE;

    public node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setHeight(char height){
        this.height=height-'a';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        node node = (node) o;
        return x == node.x &&
                y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "node{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double value() {
        return Double.valueOf(height);
    }
}
