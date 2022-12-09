package com.nscaleintermodal;

import java.util.Objects;

public class Position {

    private int X;
    private int Y;

    public Position(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return X == position.X && Y == position.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    public void right(){
        X+=1;
    }

    public void left(){
        X-=1;
    }

    public void up(){
        Y+=1;
    }

    public void down() {
        Y-=1;
    }


}
