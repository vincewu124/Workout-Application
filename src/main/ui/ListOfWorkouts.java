package ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ListOfWorkouts extends JPanel implements ListSelectionListener {
    private JList list;
    private DefaultListModel listModel;


    //Taken from: https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/ListDemoProject/src/components/ListDemo.java
    public ListOfWorkouts() {
        super(new BorderLayout());
        listModel = new DefaultListModel();
        list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(30);
        JScrollPane listScrollPane = new JScrollPane(list);
        add(listScrollPane, BorderLayout.PAGE_END);
    }

    //MODIFIES: this
    //EFFECTS: adds a string into the DefaultListModel then adds that into the JList
    public void adding(String adding) {
        listModel.addElement(adding);
        list.setModel(listModel);
    }

    //EFFECTS: gets the index of the JList
    public int getIndex() {
        return list.getSelectedIndex();
    }

    public String getValue(int index) {
        return (String) listModel.get(index);
    }


    //MODIFIES: this
    //EFFECTS: returns true if the listModel has exercise, false otherwise
    public boolean isIn(String exercise) {
        return listModel.contains(exercise);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
    }
}
