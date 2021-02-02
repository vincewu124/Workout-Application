package model;


import exception.LoadingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LoadJLabelTest {
    private LoadJLabel load;

    @BeforeEach
    public void runBefore() {
        load = new LoadJLabel();
    }


    @Test
    public void getTextTest(){
        assertEquals(load.setText(new JLabel("1")), load.getText());
    }

    @Test
    public void getExerTest(){
        assertEquals(load.setExer(new JLabel("1")), load.getExer());

    }


    @Test
    public void stringListToALTest() {
        String[] list = {"1", "2", "3"};
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        assertEquals(load.stringListToAL(list), list2);
    }

    @Test
    public void makeLabelTest() throws IOException {
        JPanel p = load.getPanel();
        assertEquals(load.makeLabel("Arms1"), p);
    }

    @Test
    public void makeLabelTest1() throws IOException {
        load.makeLabel("Arms1");
        assertEquals(load.makeLabel("Arms1"), load.getPanel());
    }
}
