package ui;

import model.WorkoutList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JPanel implements ActionListener {
    private GuiMakeNewPanel gui = new GuiMakeNewPanel();
    private User user;
    private JFormattedTextField fieldWorkout;
    private JFormattedTextField fieldExer;
    private WorkoutList workoutList = new WorkoutList();


    //taken from: https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/ButtonDemoProject/src/components/ButtonDemo.java
    public Buttons(String name, String type, User user) {
        genericButton(name, type, user);
    }

    public Buttons(String name, String type, User user, WorkoutList w) {
        genericButton(name, type, user);
        workoutList = w;
    }

    public Buttons(String name, String type, User user, JFormattedTextField field) {
        genericButton(name, type, user);
        fieldWorkout = new JFormattedTextField();
        fieldWorkout = field;
    }

    //EFFECTS: creates a button for general use in this program
    public void genericButton(String name, String type, User user) {
        this.user = user;
        JButton b = new JButton(name);
        b.setVerticalTextPosition(AbstractButton.CENTER);
        b.setHorizontalTextPosition(AbstractButton.LEADING);
        b.setActionCommand(type);
        b.addActionListener(this);
        add(b);
    }

    //EFFECTS: checks which button is used and sends the corresponding method for it
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("gym".equals(e.getActionCommand())) {
            user.secondPanel();
        }
        if ("stretches".equals(e.getActionCommand())) {
            user.secondPanel();
        }
        if ("track".equals(e.getActionCommand())) {
            user.secondPanel();
        }
        if ("addBody".equals(e.getActionCommand())) {
            gui.makeBody(user);
        }
        if ("bodyName".equals(e.getActionCommand())) {
            user.makerThird(fieldWorkout);
        } else {
            moreActionPerformed(e);
        }
    }

    //EFFECTS: checks which button is used and sends the corresponding method for it
    public void moreActionPerformed(ActionEvent e) {
        if ("selectBody".equals(e.getActionCommand())) {
            user.thirdPanel();
        }
        if ("save".equals(e.getActionCommand())) {
            gui.savePanel(user);
        }
        if ("fileName".equals(e.getActionCommand())) {
            user.makeFile(fieldWorkout);
        }
        if ("load".equals(e.getActionCommand())) {
            gui.loadPanel(user);
        }
        if ("loadName".equals(e.getActionCommand())) {
            user.loadFile(fieldWorkout);
        } else {
            finalActionPerformed(e);
        }
    }

    //EFFECTS: checks which button is used and sends the corresponding method for it
    public void finalActionPerformed(ActionEvent e) {
        if ("exercise".equals(e.getActionCommand())) {
            gui.makeExer(user);
        }
        if ("addExer".equals(e.getActionCommand())) {
            user.makerSecond(fieldWorkout);
        }
        if ("stats".equals(e.getActionCommand())) {
            user.showStats();
        }
    }
}




