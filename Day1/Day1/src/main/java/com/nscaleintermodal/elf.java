package com.nscaleintermodal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class elf implements Comparable{

    private int elfNumber;
    private List<Integer> snacks;
    public elf(int elf, int[] snacks) {
      List<Integer> snacksList = new ArrayList<>();
      for(int snack:snacks){
          snacksList.add(snack);
      }
      this.elfNumber=elf;
      this.snacks=snacksList;
    }

    public elf(int elf, List<Integer> snacks){
        this.elfNumber=elf;
        this.snacks=List.copyOf(snacks);
    }

    public int getElfNumber() {
        return elfNumber;
    }
    int cal_sum(){
        return snacks.stream().reduce(0,Integer::sum);
    }

    @Override
    public int compareTo(Object o) {
        if(! (o instanceof elf))
           return 0;
        return(((elf)o).cal_sum() - cal_sum());
    }
}
