package model;

import javax.swing.*;

public class Holder {
    private JLabel text = new JLabel();


    public void setHolder(JLabel s) {
        text = s;
    }

    public JLabel getT() {
        return text;
    }

    //EFFECTS: test method to set the text
    public JLabel setT(JLabel j) {
        text = j;
        return text;
    }
}
