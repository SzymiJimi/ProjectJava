package com.SzymonJarzabek;

import javax.swing.*;

/**
 * Created by Szymon on 2017-06-24.
 */
public class Equipment {

    String name;
    boolean check;
    String data;
    int workID;

    public Equipment()
    {

    }

    public Equipment(String name,boolean check )
    {
        this.name=name;
        this.check=check;
    }
    public Equipment(String name,String data )
    {
        this.name=name;
        this.data=data;
    }

}
