package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class ExerciseTest {
    private Exercise exer;
    private ArrayList<WorkoutHolder> workouts;
    private WorkoutHolder workoutHold;
    private Exercise exerSame;
    private Exercise exer1;


    @BeforeEach
    public void runBefore(){
        exer = new Exercise("chest");
        workouts = new ArrayList<>();
        workoutHold = new WorkoutHolder();
        exerSame = new Exercise("chest");
        exer1 = new Exercise("arm");
    }

    @Test
    public void getNameTest(){
        assertEquals(exer.getName(), "chest");
    }


    @Test
    public void equalsSame(){
        assertTrue(exer.equals(exerSame));
    }

    @Test
    public void equalsNull(){
        assertFalse(exer.equals(null));
    }

    @Test
    public void equalsWrongClass(){
        assertFalse(exer.equals(1));
    }

    @Test
    public void equalsDiff(){
        assertFalse(exer.equals(exer1));
    }

    @Test
    public void hasCodeTest(){
        Exercise exers = new Exercise("chest");
        assertEquals(exers.hashCode(), exer.hashCode());
    }
}
