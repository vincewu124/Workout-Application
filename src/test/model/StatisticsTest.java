package model;

import exception.LoadingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StatisticsTest {
    private Statistics stat;

    @BeforeEach
    public void runBefore(){
        stat = new Statistics();
    }

    @Test
    public void chooseAddTest1(){
        stat.chooseAdd("Circuit");
        assertEquals(stat.getCircuitNum(), 1);
    }

    @Test
    public void chooseAddTest2(){
        stat.chooseAdd("Chest");
        assertEquals(stat.getChestNum(), 1);
    }

    @Test
    public void chooseAddTest3(){
        stat.chooseAdd("Arms");
        assertEquals(stat.getArmNum(), 1);
    }

    @Test
    public void chooseAddTest4(){
        stat.chooseAdd("Full body");
        assertEquals(stat.getFullBodyNum(), 1);
    }

    @Test
    public void chooseAddTest5(){
        stat.chooseAdd("Shoulders");
        assertEquals(stat.getShoulderNum(), 1);
    }

    @Test
    public void chooseBodyTest(){
        stat.chooseAdd("Arms");
        ArrayList<Integer> i = new ArrayList<>();
        i.add(0);
        i.add(1);
        i.add(0);
        i.add(0);
        i.add(0);
        assertEquals(stat.chooseBody(), i);
    }
}
