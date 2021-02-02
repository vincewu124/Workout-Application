package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WorkoutHolderTest {
    private WorkoutHolder hold;
    private Exercise exer;

    @BeforeEach
    public void runBefore() {
        hold = new WorkoutHolder();
        exer = new Exercise("Chest");
    }

    @Test
    public void testGetBody() {
        hold.setBody("Body");
        assertEquals(hold.getBody(), "Body");
    }

    @Test
    public void testSetBody() {
        hold.setBody("Chest");
        assertEquals(hold.getBody(), "Chest");
    }

    @Test
    public void testAddExer(){
        hold.setBody("CHest");
        hold.addExercise("Chest");
        ArrayList<Exercise> s = new ArrayList<>();
        s.add(exer);
        assertEquals(hold.getBodyWorkouts(), s);
    }

    @Test
    public void equalsTest(){
    WorkoutHolder holder = new WorkoutHolder();
    holder.setBody("1");
    hold.setBody("1");
    assertTrue(hold.equals(holder));
    }

    @Test
    public void equalsNull(){
        hold.setBody("1");
        assertFalse(hold.equals(null));
    }

    @Test
    public void equalsDiff(){
        WorkoutHolder holder = new WorkoutHolder();
        holder.setBody("2");
        hold.setBody("1");
        assertFalse(hold.equals(holder));
    }

    @Test
    public void equalsInt(){
        hold.setBody("1");
        assertFalse(hold.equals(1));
    }

    @Test
    public void equalsSame(){
        hold.setBody("1");
        assertTrue(hold.equals(hold));
    }

    @Test
    public void hasCodeTest(){
        WorkoutHolder holders = new WorkoutHolder();
        assertEquals(holders.hashCode(),hold.hashCode());
    }

}
