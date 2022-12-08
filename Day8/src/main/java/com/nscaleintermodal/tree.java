package com.nscaleintermodal;
public class tree {

    private int height;

    private int scenicScore;

    private boolean visible = false;
    public tree(int height) {
        this.height=height;
    }

    public int height() {
        return this.height;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getScenicScore() {
        return scenicScore;
    }

    public void setScenicScore(int scenicScore) {
        this.scenicScore = scenicScore;
    }
}
