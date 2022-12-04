package com.nscaleintermodal;

public class ruckSack {
    String compartment1;
    String compartment2;
    public ruckSack(String contents) {
        compartment1=contents.substring(0,contents.length()/2);
        compartment2=contents.substring(contents.length()/2);
    }


    public char common() {
        for (int i = 0; i < compartment1.length(); i++) {
            for( int j =0; j< compartment2.length();j++) {
                if(compartment1.charAt(i)==compartment2.charAt(j)){
                    return compartment1.charAt(i);
                }
            }
        }
        return '\0';
    }

    public int priority(char c){
         if( c >= 'a' && c <= 'z'){
             return c-'a'+1;
         }
         return c-'A'+27;
    }
}
