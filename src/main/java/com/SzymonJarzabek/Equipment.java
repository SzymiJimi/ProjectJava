package com.SzymonJarzabek;

import javax.swing.*;

/**
 * Created by Szymon on 2017-06-24.
 */

/**
 * Klasa przechowująca informacje o samochodzie
 */
public class Equipment {

    public String name;
    public boolean check;
    public String data;
    public int workID;
    public int salary;

    public JTextField clientName;
    public JTextField clientSurname;
    public JTextField workerID;
    public JTextField price;
    public JTextField clientPESEL;
    public JComboBox sex;

    public Equipment() {

    }

    public Equipment(String name, boolean check) {
        this.name = name;
        this.check = check;
    }

    public Equipment(String name, String data) {
        this.name = name;
        this.data = data;
    }

}
