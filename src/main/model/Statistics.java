package model;

import java.util.ArrayList;

public class Statistics {
    private int chestNum = 0;
    private int armNum = 0;
    private int shoulderNum = 0;
    private int fullBodyNum = 0;
    private int circuitNum = 0;

    public void addChest() {
        chestNum++;
    }

    public void addArms() {
        armNum++;
    }

    public void addShoulders() {
        shoulderNum++;
    }

    public void addFullBody() {
        fullBodyNum++;
    }

    public void addCircuit() {
        circuitNum++;
    }

    public int getChestNum() {
        return chestNum;
    }

    public int getArmNum() {
        return armNum;
    }

    public int getShoulderNum() {
        return shoulderNum;
    }

    public int getFullBodyNum() {
        return fullBodyNum;
    }

    public int getCircuitNum() {
        return circuitNum;
    }

    //EFFECTS: finds which body part is being added and calls the add method to the specific body part
    public void chooseAdd(String body) {
        switch (body) {
            case "Chest":
                addChest();
                break;
            case "Arms":
                addArms();
                break;
            case "Shoulders":
                addShoulders();
                break;
            case "Full body":
                addFullBody();
                break;
            case "Circuit":
                addCircuit();
                break;
            default:
        }
    }

    //MODIFIES: this
    //EFFECTS: finds which body part is being chosen and returns how many time that body part has been added
    public ArrayList<Integer> chooseBody() {
        ArrayList<Integer> total = new ArrayList<>();
        total.add(chestNum);
        total.add(armNum);
        total.add(shoulderNum);
        total.add(fullBodyNum);
        total.add(circuitNum);
        return total;
    }

}