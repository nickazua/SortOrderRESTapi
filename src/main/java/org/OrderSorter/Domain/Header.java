package org.OrderSorter.Domain;

import java.util.Random;

public class Header {

    private String orderNum;
    private String nameGen;
    private String numOfBoxes;

    public Header(){

    }
    public Header(String orderNum, String nameGen, String numOfBoxes) {
        this.orderNum = new String(orderNum);
        this.nameGen = new String(nameGen);
        this.numOfBoxes = new String(numOfBoxes);
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public void setNameGen(String nameGen) {
        this.nameGen = nameGen;
    }

    public void setNumOfBoxes(String numOfBoxes) {
        this.numOfBoxes = numOfBoxes;
    }

    public String getOrderNum() {
        return this.orderNum;
    }

    public String getNameGen() {
        return this.nameGen;
    }

    public String getNumOfBoxes() {
        return this.numOfBoxes;
    }

    public void generateOrderNum() {

        Random r = new Random();

        int orderNum = 100000000 + r.nextInt(99999999);
        this.orderNum = String.valueOf(orderNum);

    }

    public void generateCustomerName() {

        Random r = new Random();

        int nameGen = 1 + r.nextInt(30);

        switch(nameGen)
        {
            case 1: this.nameGen = "Luke Skywalker";
                break;
            case 2: this.nameGen = "Han Solo";
                break;
            case 3: this.nameGen = "Princess Leia";
                break;
            case 4: this.nameGen = "Chewbacca";
                    break;
            case 5: this.nameGen = "Darth Vader";
                break;
            case 6: this.nameGen = "Obi-Wan Kenobi";
                break;
            case 7: this.nameGen = "C-3PO";
                break;
            case 8: this.nameGen = "R2-D2";
                break;
            case 9: this.nameGen = "Yoda";
                break;
            case 10: this.nameGen = "Boba Fett";
                break;
            case 11: this.nameGen = "Jango Fett";
                break;
            case 12: this.nameGen = "Lando Calrissian";
                break;
            case 13: this.nameGen = "Qui-Gon Jinn";
                break;
            case 14: this.nameGen = "Darth Maul";
                break;
            case 15: this.nameGen = "Darth Sidious";
                break;
            case 16: this.nameGen = "Jabba The Hutt";
                break;
            case 17: this.nameGen = "Wicket";
                break;
            case 18: this.nameGen = "Count Dooku";
                break;
            case 19: this.nameGen = "General Grievous";
                break;
            case 20: this.nameGen = "Padme Amidala";
                break;
            case 21: this.nameGen = "Mace Windu";
                break;
            case 22: this.nameGen = "Admiral Ackbar";
                break;
            case 23: this.nameGen = "Greedo";
                break;
            case 24: this.nameGen = "Tuskan Raider";
                break;
            case 25: this.nameGen = "Anakin Skywalker";
                break;
            case 26: this.nameGen = "Salacious Crumb";
                break;
            case 27: this.nameGen = "TK-421";
                break;
            case 28: this.nameGen = "Watto";
                break;
            case 29: this.nameGen = "Wedge Antilles";
                break;
            case 30: this.nameGen = "Grand Moff Tarkin";
                break;
            default: this.nameGen = "error";
        }
        System.out.println(nameGen);

    }

    public void generateNumOfBoxes() {

        Random r = new Random();

        int numOfBoxes = 100000000 + r.nextInt(99999999);    //needs code to count boxes
        this.numOfBoxes = String.valueOf(numOfBoxes);

    }
}