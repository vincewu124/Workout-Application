package model;

import exception.LoadingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class WorkoutListTest {
    private WorkoutList exer;
    private WorkoutHolder input;
    private LoadJLabel load;

    @BeforeEach
    public void runBefore() {
        input = new WorkoutHolder();
        exer = new WorkoutList();
        load = new LoadJLabel();
    }

    @Test
    public void testSettingBody() {
        String body = "Chest";
        exer.settingBody(body, input);
        input.setBody(body);
        assertEquals(input.getBody(), "Chest");
    }


    @Test
    public void saveMoreTest() throws IOException, LoadingException {
        exer.addBody(4, "Arms");
        exer.save("Arms", "Arms");
        List<String> test = new ArrayList<>();
        test.add("Legs/1/2/3/");
        assertEquals(exer.load("Legs"), test);
    }

    @Test
    void loadTest() throws IOException {
        try {
            exer.load("Legs123");
            fail("error");
        } catch (LoadingException e) {
        }
    }

    @Test
    public void loadMoreTest() throws IOException {
        try {
            exer.load("Arms1");
        } catch (LoadingException e) {
            fail("error");
        }
    }

    @Test
    public void compareLoad() throws IOException, LoadingException {
        ArrayList<String> test = new ArrayList<>();
        test.add("Arms/4/5/6/");
        assertEquals(exer.load("Arms1"), test);
    }

    @Test
    public void stringListToALTest() {
        String[] list = {"1", "2", "3"};
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        assertEquals(exer.stringListToAL(list), list2);
    }

    @Test
    public void userAddBodyTest1(){
        assertEquals(exer.userAddBody("Arms"), "Arms");
    }

    @Test
    public void userAddBodyTest2(){
        assertEquals(exer.userAddBody("Chest"), "Chest");
    }

    @Test
    public void userAddBodyTest3(){
        assertEquals(exer.userAddBody("Shoulders"), "Shoulders");
    }

    @Test
    public void userAddBodyTest4(){
        assertEquals(exer.userAddBody("Full body"), "none");
    }

    @Test
    public void userAddBodyTest5(){
        assertEquals(exer.userAddBody("Circuit"), "none");
    }

    @Test
    public void userAddBodyTest6(){
        assertEquals(exer.userAddBody("dewdew"), "none");
    }

    @Test
    public void getHolderTest(){
        JLabel j = new JLabel("1");
        assertEquals(exer.setHolder(j), exer.getHolderBack());
    }

}