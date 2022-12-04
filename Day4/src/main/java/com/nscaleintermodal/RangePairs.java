package com.nscaleintermodal;

public class RangePairs {

    int elf1Start;
    int elf1End;
    int elf2Start;
    int elf2End;

    public RangePairs(int elf1Start, int elf1End, int elf2Start, int elf2End) {
        this.elf1Start = elf1Start;
        this.elf1End = elf1End;
        this.elf2Start = elf2Start;
        this.elf2End = elf2End;
    }

    public boolean subRange(){
        if(elf1Start<=elf2Start && elf1End>=elf2End){
            return true;
        }
        if(elf2Start<=elf1Start && elf2End>=elf1End){
            return true;
        }
        return false;
    }

    public boolean overLap(){
        if(elf1Start<=elf2Start && elf1End>=elf2Start){
            return true;
        }
        if(elf1Start<=elf2End && elf1End>=elf2End){
            return true;
        }
        if(elf2Start<=elf1Start && elf2End>=elf1Start){
            return true;
        }
        if(elf2Start<=elf1End && elf2End>=elf1End){
            return true;
        }
        return false;

    }


}
