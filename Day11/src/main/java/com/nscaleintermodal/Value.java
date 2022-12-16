package com.nscaleintermodal;

import java.util.ArrayList;
import java.util.List;

public class Value {

    List<Long> factors;

    public Value(long val){
        factors = new ArrayList<>();
        factors.add(val);
    }

    void multiply(Value val){
        factors.addAll(val.factors);
    }

    void add(Value val){
        long value1 = 1;
        for(Long l: factors){
            value1 = value1 *l;
        }
        long value2 = 1;
        for(long l: val.factors){
             value2 = value2 *l;
        }
        factors = new ArrayList<>();
        factors.add(value1+value2);
    }

    boolean divisibleBy(long val){
        if(factors.stream().filter(o -> o == val).findAny().isPresent()){
            return true;
        }
        return factors.stream().filter(o -> o % val == 0).findAny().isPresent();
    }

    void divide(long val){
        if(factors.stream().filter(o->o%val == 0).findAny().isPresent()){
            Long found = factors.stream().filter(o -> o % val == 0).findAny().get();
            factors.remove(found);
            factors.add(val);
            factors.add(found/val);
        } else if( divisibleBy(val)){
            factors.add(val);
        }
    }

}
