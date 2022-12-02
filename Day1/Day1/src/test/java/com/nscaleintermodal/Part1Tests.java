package com.nscaleintermodal;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
public class Part1Tests {

    @Test
    public void elf_sum(){

        elf testElf = new elf(1,new int[]{10,20,30});
        assertThat(testElf.cal_sum()).isEqualTo(60);
    }

    @Test
    public void elfCompare(){
        elf elf1 = new elf(1,new int[]{100,200});
        elf elf2 = new elf(2, new int[]{200,300});
        assertThat(elf1).isGreaterThan(elf2);
    }

    @Test
    public void elf_Number(){
        elf testElf = new elf(1,new int[]{10,20,30});
        assertThat(testElf.getElfNumber()).isEqualTo(1);
    }
    @Test
    public void TestElfs(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.elfCount()).isEqualTo(5);
    }

    @Test
    public void maxElf(){
        String dataFileName = this.getClass().getResource("testdata.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.maxElf()).isEqualTo(4);
    }

    @Test
    public void maxElfCalloriesWithInput(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.maxElfCalories()).isEqualTo(69795); // this is the answer to part 1
    }

    @Test
    public void top3CaloriesWithInput(){
        String dataFileName = this.getClass().getResource("input.txt").getFile();
        Part1 testObject = new Part1(dataFileName);
        assertThat(testObject.top3ElfCalories()).isEqualTo(208437); // this is the answer to part 2
    }


}
