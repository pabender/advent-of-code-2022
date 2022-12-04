package com.nscaleintermodal;

public class elfGroup {
    String elf1;
    String elf2;
    String elf3;

    public elfGroup(String elf1,String elf2, String elf3) {
        this.elf1=elf1;
        this.elf2=elf2;
        this.elf3=elf3;
    }


    public char common() {
        String commonChars = new String();
        for (int i = 0; i < elf1.length(); i++) {
            for( int j =0; j< elf2.length();j++) {
                if(elf1.charAt(i)==elf2.charAt(j)){
                    commonChars = commonChars + elf1.charAt(i);
                }
            }
        }
        for (int i = 0; i < commonChars.length(); i++) {
            for( int j =0; j< elf3.length();j++) {
                if(commonChars.charAt(i)==elf3.charAt(j)){
                    return commonChars.charAt(i);
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
