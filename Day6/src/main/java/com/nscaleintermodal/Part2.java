package com.nscaleintermodal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Part2 {
    String byteStream;
    public Part2(String fileName) {
        List<String> lines;

        File f = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            lines = reader.lines().collect(Collectors.toList());
        } catch (java.io.FileNotFoundException fnfe) {
            lines = new ArrayList<>();
        }

        byteStream=lines.get(0);

    }

    public int startOfPacket() {
        int retval = 0;
        for(;retval<byteStream.length()-3;retval++){
            if(byteStream.charAt(retval)!=byteStream.charAt(retval+1) &&
                    byteStream.charAt(retval)!=byteStream.charAt(retval+2) &&
                    byteStream.charAt(retval)!=byteStream.charAt(retval+3) &&
                    byteStream.charAt(retval+1)!=byteStream.charAt(retval+2) &&
                    byteStream.charAt(retval+1)!=byteStream.charAt(retval+3) &&
                    byteStream.charAt(retval+2)!=byteStream.charAt(retval+3)){
                break;
            }
        }
        return retval+4;
    }

    public int startOfMessage() {
        int retval = 0;
        for(;retval<byteStream.length()-14;retval++){
            boolean found=true;
            for(int i=retval;i<retval+14;i++){
                for(int j=i+1;j<retval+14;j++){
                    found=found && (byteStream.charAt(i)!=byteStream.charAt(j));
                    if(!found)
                        break;
                }
            }
            if(found) {
                break;
            }
        }
        return retval+14;
    }
}
