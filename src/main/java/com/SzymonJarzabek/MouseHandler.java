package com.SzymonJarzabek;

import jdk.nashorn.internal.runtime.ECMAErrors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;


import static jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType.NEWLINE;

/**
 * Created by Szymon on 2017-06-24.
 */
public class MouseHandler implements MouseListener{

    JTextArea textArea;
    JTable table;

    String sqlColNames="SELECT column_name FROM USER_TAB_COLUMNS WHERE table_name = '";


/*
    private Car getData()
    {
        Table.statement.executeQuery("");

    }

*/
    private void createAddCarPanel(JComponent panel)
    {
        JPanel mainPanel=new JPanel();
        mainPanel.setPreferredSize(new Dimension(1180,600));
        mainPanel.setMaximumSize(new Dimension(1180,600));
        mainPanel.setBounds(0,0,1180,600);
        JScrollPane modifyArea = Projekt.createTextArea(mainPanel,1180,580);
        modifyArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints layout =new GridBagConstraints();
        Car Samochod=new Car();


        Samochod.marka=HandlerClass.createTextField("Marka: ",20,50, 30,mainPanel, Color.cyan, layout,0,0,0,0,0,0);
        Samochod.model=HandlerClass.createTextField("Model: ",20,50, 30,mainPanel, Color.cyan, layout,0,1,0,0,0,0);
        String years[]={"1986","1987","1988","1989","1990","1991","1993","1994","1995","1996","1997","1998","1999","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017"};
        //Samochod.rok=createTextField("Rok produkcji: ",20,50, 30,mainPanel, Color.cyan, layout,0,2,0,0,0,0);
        Samochod.rok=HandlerClass.createComboBox("Rok produkcji: ",years,mainPanel ,layout,  0,2,0,0,0,0);
        Samochod.vin=HandlerClass.createTextField("VIN: ",20,50, 30,mainPanel, Color.cyan, layout,0,3,0,0,0,0);
        Samochod.przebieg=HandlerClass.createTextField("Przebieg: ",20,50, 30,mainPanel, Color.cyan, layout,0,4,0,0,0,0);
        Samochod.moc=HandlerClass.createTextField("Moc: ",20,50, 30,mainPanel, Color.cyan, layout,0,5,0,0,0,0);
        String engineTypes[]={"Diesel", "Benzyna", "Hubryda", "Elektryczny", "Benzyna+LPG"};
        Samochod.typSilnika=HandlerClass.createComboBox("Rodzaj paliwa: ",engineTypes,mainPanel, layout,0,6,0,0,0,0);
        String capacity[]={"0.8","0.9","1.0","1.1","1.2","1.3","1.4","1.5","1.6","1.7","1.8","1.9","2.0","2.1","2.2","2.3","2.4","2.5","2.6","2.7","2.8","2.9","3.0","3.1","3.2","3.3","3.4","3.5","3.6","3.7","3.8","3.9","4.0","4.1","4.2","4.3","4.4","4.5","4.6","4.7","4.8","4.9","5.0"};
        //Samochod.pojemnosc=createTextField("Pojemność: ",20,50, 30,mainPanel, Color.cyan, layout,0,7,0,0,0,0);
        Samochod.pojemnosc=HandlerClass.createComboBox("Pojemność: ",capacity,mainPanel ,layout,  0,7,0,0,0,0);
        String gearbox[]={"Manualna", "Automat"};
        Samochod.skrzynia=HandlerClass.createComboBox("Skrzynia biegów: ",gearbox,mainPanel, layout,0,8,0,0,0,0);
        String condition[]={"Nowy", "Używany", "Uszkodzony"};
        Samochod.stan=HandlerClass.createComboBox("Stan: ",condition,mainPanel, layout,0,9,0,0,0,0);
        String body[]={"Sedan", "Hatchback", "Kombi", "SUV", "Minivan", "Kabriolet", "Terenowy", "Coupe"};
        Samochod.nadwozie=HandlerClass.createComboBox("Nadwozie: ", body,mainPanel, layout,0,10,0,0,0,0);
        String origin[]={"Polska","Niemcy","Francja","Holandia","Włochy","Wielka Brytania", "Belgia", "Dania", "Ameryka", "Inny"};
        Samochod.krajPoch=HandlerClass.createComboBox("Pojemność: ",origin,mainPanel ,layout,  0,11,0,0,0,0);
        //Samochod.krajPoch=createTextField("Kraj pochodzenia: ",20,50, 30,mainPanel, Color.cyan, layout,0,11,0,0,0,0);
        Samochod.serwis= HandlerClass.createCheckBox("Serwisowany", false, mainPanel, layout,0,12,0,0,0,0,1);
        Samochod.opis=HandlerClass.createTextPane("Dodatkowy opis: ",400,150,mainPanel, layout,0,13,0,-50,0,0);

        //JCheckBox serwis= createCheckBox("Poduszki", false, mainPanel, layout,0,10,0,0,0,0);

        Samochod.abs= HandlerClass.createCheckBox("ABS: ", false, mainPanel, layout,2,0,0,0,0,0);
        Samochod.esp= HandlerClass.createCheckBox("ESP: " , false, mainPanel, layout,2,1,0,0,0,0);
        Samochod.wspKier= HandlerClass.createCheckBox("Wspomaganie kierownicy: ", false, mainPanel, layout,2,2,0,0,0,0);
        Samochod.bluetooth=HandlerClass. createCheckBox("Bluetooth: ", false, mainPanel, layout,2,3,0,0,0,0);
        Samochod.czZmierzchu= HandlerClass.createCheckBox("Czujnik zmierzchu: ", false, mainPanel, layout,2,4,0,0,0,0);
        Samochod.czParkowania= HandlerClass.createCheckBox("Czujniki parkowania: ", false, mainPanel, layout,2,5,0,0,0,0);
        Samochod.czDeszczu= HandlerClass.createCheckBox("Czujniki deszczu: ", false, mainPanel, layout,2,6,0,0,0,0);
        Samochod.elLusterka=HandlerClass. createCheckBox("Elektryczne lusterka: ", false, mainPanel, layout,2,7,0,0,0,0);
        Samochod.elSzybyP= HandlerClass.createCheckBox("Elektryczne szyby przednie: ", false, mainPanel, layout,2,8,0,0,0,0);
        Samochod.elSzybyT= HandlerClass.createCheckBox("Elektryczne szyby tylnie: ", false, mainPanel, layout,2,9,0,0,0,0);
        Samochod.podgrzLustBok= HandlerClass.createCheckBox("Podgrzewane lusterka boczne: ", false, mainPanel, layout,2,10,0,0,0,0);
        Samochod.podgrzSiedzP=HandlerClass. createCheckBox("Podgrzewane siedzenia przód: ", false, mainPanel, layout,2,11,0,0,0,0);
        Samochod.podgrzSiedzT= HandlerClass.createCheckBox("Podgrzewane siedzenia tył: ", false, mainPanel, layout,2,12,0,0,0,0);
        Samochod.podgrzKier= HandlerClass.createCheckBox("Podgrzewanie kierownicy: ", false, mainPanel, layout,2,13,-130,0,0,0);
        Samochod.immobilizer= HandlerClass.createCheckBox("Immobilizer: ", false, mainPanel, layout,2,14,-240,0,0,0);
        Samochod.alarm= HandlerClass.createCheckBox("Alarm: ", false, mainPanel, layout,2,15,-200,0,0,0);
        Samochod.centralnyZam=HandlerClass. createCheckBox("Centralny zamek: ", false, mainPanel, layout,2,16,-160,0,0,0);
        Samochod.pilot= HandlerClass.createCheckBox("Pilot: ", false, mainPanel, layout,4,0,0,0,0,0);
        Samochod.mp3= HandlerClass.createCheckBox("Radio mp3: ", false, mainPanel, layout,4,1,0,0,0,0);
        Samochod.gnAux= HandlerClass.createCheckBox("Gniazdo AUX: ", false, mainPanel, layout,4,2,0,0,0,0);
        Samochod.radioFabr= HandlerClass.createCheckBox("Radio fabryczne: ", false, mainPanel, layout,4,3,0,0,0,0);
        Samochod.cd=HandlerClass. createCheckBox("Odtwarzacz CD: ", false, mainPanel, layout,4,4,0,0,0,0);
        Samochod.kompPokl=HandlerClass. createCheckBox("Komputer pokładowy: ", false, mainPanel, layout,4,5,0,0,0,0);
        Samochod.gniazdo12V= HandlerClass.createCheckBox("Gniazdo 12V: ", false, mainPanel, layout,4,6,0,0,0,0);
        Samochod.tempomat=HandlerClass. createCheckBox("Tempomat: ", false, mainPanel, layout,4,7,0,0,0,0);
        Samochod.aktywTemp=HandlerClass. createCheckBox("Aktywny tempomat: ", false, mainPanel, layout,4,8,0,0,0,0);
        Samochod.lineAsist= HandlerClass.createCheckBox("Line asist: ", false, mainPanel, layout,4,9,0,0,0,0);
        Samochod.kurtynyPow= HandlerClass.createCheckBox("Kurtyny powietrzne: ", false, mainPanel, layout,4,10,0,0,0,0);
        Samochod.isofix= HandlerClass.createCheckBox("ISOFIX: ", false, mainPanel, layout,4,11,0,0,0,0);
        Samochod.ciemneSzyby= HandlerClass.createCheckBox("Przyciemniane szyby: ", false, mainPanel, layout,4,12,0,0,0,0);
        Samochod.alufelgi=HandlerClass. createCheckBox("Alufelgi: ", false, mainPanel, layout,4,13,-130,0,0,0);
        Samochod.relingi=HandlerClass. createCheckBox("Relingi dachowe: ", false, mainPanel, layout,4,14,-240,0,0,0);
        Samochod.swLED=HandlerClass. createCheckBox("Światła ledowe: ", false, mainPanel, layout,4,15,-200,0,0,0);
        Samochod.swXenon= HandlerClass.createCheckBox("Światła xenonowe: ", false, mainPanel, layout,4,16,-160,0,0,0);
        Samochod.swDzien= HandlerClass.createCheckBox("Światła do jazdy dziennej: ", false, mainPanel, layout,4,17,-120,0,0,0);



/*
        String markaTxt=marka.getText();
        String modelTxt=model.getText();
        String rokTxt=rok.getText();
        String vinTxt=vin.getText();
        String przebiegTxt=przebieg.getText();
        String mocTxt=moc.getText();
        String typSilnikaTxt=(String)typSilnika.getSelectedItem();
        String pojemnoscTxt=pojemnosc.getText();
        String skrzyniaTxt=(String)skrzynia.getSelectedItem();
        String stanTxt=(String)stan.getSelectedItem();
        String nadwozieTxt=(String)nadwozie.getSelectedItem();
        String krajPochTxt=krajPoch.getText();
        String serwisTxt=serwis.getText();
        String opisTxt=opis.getText();
*/
        JButton accept=new JButton("Akceptuj");
        Projekt.setLayoutAdd(mainPanel,layout,2,17,-20,-150,0,0,accept,1);

        accept.setActionCommand("acceptAddCar");
        HandlerClass handlerAdd=new HandlerClass(Samochod);
        accept.addActionListener(handlerAdd);


        panel.add(modifyArea);
        panel.updateUI();


    }

    protected  void getColNames (String tableName, String colNames[])
    {
        //System.out.println("Jestem w tworzeniu nazw kolumn dla: "+tableName);
        try {
            sqlColNames = sqlColNames + tableName + "'";
           // System.out.println(sqlColNames);
            ResultSet rs = Table.statement.executeQuery(sqlColNames);
            sqlColNames="SELECT column_name FROM USER_TAB_COLUMNS WHERE table_name = '";
            int i = 0;
            int x = colNames.length;
            while (rs.next()) {
                colNames[i] = rs.getString("column_name");
                i++;
            }
        }catch(Exception e)
        {
            System.out.print("Błąd w odczytywaniu nazw kolumn! \n");
        }
    }

    public void getDataDescr(String colNames[],Equipment descrips[], int row)
    {
       // System.out.println("Jestes w odczytywaniu opisów: ");
        String sqlQuery="Select ";
        String result;
        int k=0;
        int length= colNames.length;
        try {
            for (int i = 1; i < length; i++) {

                sqlQuery=sqlQuery+colNames[i]+" from OPIS WHERE opis_id="+row;

               // System.out.println(sqlQuery);
                ResultSet rs = Table.statement.executeQuery(sqlQuery);
                while (rs.next()) {
                    result  = rs.getString(colNames[i]);
                  // System.out.println("Wynik bezposredni: "+result);
                    if(result=="1") {
                        descrips[k].data ="Tak";
                    }else if(result=="0"){
                        descrips[k].data ="Nie";
                    }else{
                        descrips[k].data=result;
                    }
                  //  System.out.println("Przeszło warunki...");

                }

                 //System.out.print(descrips[k].name+descrips[k].data+"\n");
                k++;
                sqlQuery="Select ";
            }
        }catch(Exception e)
        {
            System.out.println("Błąd w odczytywaniu opisu...");
        }
    }

    public void getDataEq(String colNames[], Equipment equips[], int row)
    {
        String sqlQuery1="Select ";
        int result, k=0;
        int length= colNames.length;
        try {
            for (int i = 2; i < length; i++) {

                sqlQuery1=sqlQuery1+colNames[i]+" from WYPOSAZENIE WHERE wyposazenie_id="+row;

                //System.out.println(sqlQuery1);
                ResultSet rs = Table.statement.executeQuery(sqlQuery1);
                while (rs.next()) {
                    result  = rs.getInt(colNames[i]);
                    if(result==1) {
                        equips[k].check =true;
                    }else{
                        equips[k].check =false;
                    }
                    k++;
                }

               // System.out.print(equips[i-2].name+equips[i-2].check+"\n");
                sqlQuery1="Select ";
            }
        }catch(Exception e)
        {
            System.out.println("Błąd w odczytywaniu wyposazenia...");
        }
    }

    public void getDataCar(String colNames[], Equipment cars[], int row){

        String sqlQuery="Select ";
        String result;
        int workID=0;
        int personID=0;
        int k=0;
        int length= colNames.length;
        length-=3;
        //--------------Pobieranie samochodu oraz ID pracownika------------------
        try {
            for (int i = 1; i < length; i++) {
                sqlQuery=sqlQuery+colNames[i]+" from SAMOCHODY WHERE samochod_id="+row;
                ResultSet rs = Table.statement.executeQuery(sqlQuery);
                while (rs.next()) {
                    result  = rs.getString(colNames[i]);
                    cars[k].data=result;
                }
                k++;
                sqlQuery="Select ";
            }
            sqlQuery=sqlQuery+colNames[11]+" from SAMOCHODY WHERE samochod_id="+row;
            System.out.println("Zapytanie do pobierania ID pracownika: "+sqlQuery);
            ResultSet rs = Table.statement.executeQuery(sqlQuery);
            while (rs.next()) {
                workID  = rs.getInt(colNames[11]);
                  System.out.println("Wynik work ID: "+workID);

                // System.out.println("Przeszło warunki...");
            }

        }catch(Exception e)
        {
            System.out.println("Błąd w odczytywaniu samochodu...");
        }
        //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

        String getPersonSQL="Select OSOBA_ID from PRACOWNICY where pracownik_id="+workID;
        System.out.println("zapytanie do pobrania OSOBY ID: "+getPersonSQL);
        try{

                ResultSet rt = Table.statement.executeQuery(getPersonSQL);

                while (rt.next()) {
                    personID = rt.getInt("OSOBA_ID");
                    System.out.println("Wynik Osoba ID: "+personID);
                }
        }catch(Exception e )
        {
            System.out.println("Błąd w odczytywaniu workID...");
        }


        String nameQuery="Select IMIE from OSOBY where osoba_id="+personID;
        String surnameQuery="Select NAZWISKO from OSOBY where osoba_id="+personID;
        System.out.print("Zapytanie imie: "+nameQuery+" nazwisko: "+surnameQuery+"\n");

        try {
            ResultSet res = Table.statement.executeQuery(nameQuery);

            while (res.next()) {
                cars[8].data = res.getString("IMIE");
            }
        }catch (Exception e)
        {
            System.out.print("Błąd w pobieraniu imienia...\n");
        }
        try{
            ResultSet rs = Table.statement.executeQuery(surnameQuery);

            while (rs.next()) {
                cars[9].data = rs.getString("NAZWISKO");
            }
        }catch (Exception e)
        {
            System.out.print("Błąd w pobieraniu nazwiska..\n");
        }

        System.out.println(cars[8].name+cars[8].data);
        System.out.println(cars[9].name+cars[9].data);

    }


    public void getWyp(Equipment equips[], int row)
    {
        //Equipment equips[]=new Equipment[35];
        equips[0]=new Equipment("Wspomaganie ABS: ",false);
        equips[1]=new Equipment("Kontrola toru jazdy ESP: ",false);
        equips[2]=new Equipment("Wspomaganie kierownicy: ",false);
        equips[3]=new Equipment("Bluetooth: ",false);
        equips[4]=new Equipment("Czujnik zmierzchu: ",false);
        equips[5]=new Equipment("Czujnik parkowania: ",false);
        equips[6]=new Equipment("Czujnik deszczu: ",false);
        equips[7]=new Equipment("Elektryczne lusterka: ",false);
        equips[8]=new Equipment("Elektryczne szyby przód: ",false);
        equips[9]=new Equipment("Elektryczne szyby tył: ",false);
        equips[10]=new Equipment("Podgrzewane lusterka boczne: ",false);
        equips[11]=new Equipment("Podgrzewane siedzenia przód: ",false);
        equips[12]=new Equipment("Podgrzewane siedzenia tył: ",false);
        equips[13]=new Equipment("Podgrzewana kierownica: ",false);
        equips[14]=new Equipment("Immobilizer: ",false);
        equips[15]=new Equipment("Alarm: ",false);
        equips[16]=new Equipment("Centralny zamek: ",false);
        equips[17]=new Equipment("Pilot: ",false);
        equips[18]=new Equipment("Radio MP3: ",false);
        equips[19]=new Equipment("Gniazdo AUX: ",false);
        equips[20]=new Equipment("Radio fabryczne: ",false);
        equips[21]=new Equipment("Odtwarzacz CD: ",false);
        equips[22]=new Equipment("Komputer pokładowy: ",false);
        equips[23]=new Equipment("Gniazdo 12V: ",false);
        equips[24]=new Equipment("Tempomat: ",false);
        equips[25]=new Equipment("Aktywny tempomat: ",false);
        equips[26]=new Equipment("Line asist: ",false);
        equips[27]=new Equipment("Kurtyny powietrzne: ",false);
        equips[28]=new Equipment("ISOFIX: ",false);
        equips[29]=new Equipment("Przyciemniane szyby: ",false);
        equips[30]=new Equipment("Alufelgi: ",false);
        equips[31]=new Equipment("Relingi dachowe: ",false);
        equips[32]=new Equipment("Światła LED: ",false);
        equips[33]=new Equipment("Światła Xenonowe: ",false);
        equips[34]=new Equipment("Światła do jazdy dziennej: ",false);



        String colNames[]=new String[37];
        try {
            getColNames("WYPOSAZENIE", colNames);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Błąd w odczytywaniu nazw kolumn w tabeli WYPOSAZENIE!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
        }
        getDataEq(colNames, equips, row);
    }

    public void getOpis(Equipment descrips[], int row)
    {

       // Equipment descrips[]=new Equipment[6];
        descrips[0]=new Equipment("Skrzynia biegów: ","nic");
        descrips[1]=new Equipment("Stan pojazdu: ","nic");
        descrips[2]=new Equipment("Nadwozie: ","nic");
        descrips[3]=new Equipment("Kraj pochodzenia: ","nic");
        descrips[4]=new Equipment("Serwisowany: ","nic");
        descrips[5]=new Equipment("Dodatkowy opis: ","nic");

        String colNames[]=new String[7];
        try {
            getColNames("OPIS", colNames);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Błąd w odczytywaniu nazw kolumn w tabeli WYPOSAZENIE!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
        }
        getDataDescr(colNames, descrips,row);

    }
    public void getCar(Equipment cars[], int row)
    {
        cars[0]=new Equipment("Marka: ","nic");
        cars[1]=new Equipment("Model: ","nic");
        cars[2]=new Equipment("Rok produkcji: ","nic");
        cars[3]=new Equipment("VIN: ","nic");
        cars[4]=new Equipment("Przebieg: ","nic");
        cars[5]=new Equipment("Moc: ","nic");
        cars[6]=new Equipment("Typ silnika: ","nic");
        cars[7]=new Equipment("Pojemność: ","nic");
        cars[8]=new Equipment("Imie: ","nic");
        cars[9]=new Equipment("Nazwisko: ","nic");

        String colNames[]=new String[12];
        try {
            getColNames("SAMOCHODY", colNames);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Błąd w odczytywaniu nazw kolumn w tabeli WYPOSAZENIE!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
        }

        getDataCar(colNames, cars,row);

    }


    public void showCar (int rowek)
    {
        int row=0;
        rowek+=1;
        try {
            ResultSet result = Table.statement.executeQuery("Select SAMOCHOD_ID from NA_STANIE where ID_STANU=" + rowek);
            while (result.next()) {
                row = result.getInt("SAMOCHOD_ID");
            }
        }catch(Exception e)
        {
            System.out.println("Błąd w pobieraniu ID samochodu...");
        }
        System.out.println("Samochod id wynosi: "+row);

        JPanel mainPanel=new JPanel();
        mainPanel.setPreferredSize(new Dimension(1180,600));
        mainPanel.setMaximumSize(new Dimension(1180,600));
        mainPanel.setBounds(0,0,1180,600);
        JScrollPane modifyArea = Projekt.createTextArea(mainPanel,1180,580);
        modifyArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints layout =new GridBagConstraints();
        Car Samochod=new Car();

        //Integer workID=new Integer(0);

        Equipment equips[]=new Equipment[35];
        Equipment descrips[]=new Equipment[6];
        Equipment cars[]=new Equipment[10];;


        getWyp(equips,row);
        getOpis(descrips, row);
        getCar(cars, row);

        createPanel(equips,descrips,cars, row, rowek);
       // System.out.println("Dana z opisu(skrzynia): "+descrips[0].data+" ("+descrips[0].name+")");
    }

    public void createLabel(Equipment equipment, JComponent panel, GridBagConstraints layout,int gridx, int gridy )
    {
        JLabel label= new JLabel(equipment.name+ equipment.data+"\n");
        Projekt.setLayoutAdd(panel,layout,gridx,gridy,0,0,0,0,label,1);

    }

    public void createLabelCB(Equipment equipment, JComponent panel, GridBagConstraints layout,int gridx, int gridy)
    {
        String data;
        if(equipment.check)
        {
            data="Tak";
        }else{
            data="Brak";
        }
        JLabel label= new JLabel(equipment.name+ data+"\n");
        Projekt.setLayoutAdd(panel,layout,gridx,gridy,0,0,0,0,label,1);
    }

    public void showInfo(Equipment equips[], Equipment descrips[], Equipment cars[], JComponent panel, int rowID, int stateID)
    {
        JPanel mainPanel=new JPanel();
        //JScrollPane editorScrollPane = new JScrollPane(mainPanel);
        mainPanel.setPreferredSize(new Dimension(1180,600));
        mainPanel.setMaximumSize(new Dimension(1180,600));
        mainPanel.setBounds(0,0,1180,600);
        JScrollPane editorScrollPane = Projekt.createTextArea(mainPanel,1180,580);
        editorScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints layout =new GridBagConstraints();
        int counterX=0;
        int counterY=0;

        JButton modify=new JButton("Modyfikuj");
        JButton cancel=new JButton("Powrót");
        JButton sell=new JButton("Sprzedaj");


        for(int k=0;k<8;k++)
        {
            createLabel(cars[k], mainPanel, layout,counterX,counterY);
            counterY+=1;

        }
        JLabel label=new JLabel("___________________________________");
        Projekt.setLayoutAdd(mainPanel,layout,counterX,counterY,0,0,0,0,label,1);
        counterY+=1;

        for(int j=0;j<6;j++)
        {
            createLabel(descrips[j], mainPanel, layout,counterX,counterY);
            counterY+=1;

        }

        //JLabel labelDes=new JLabel(descrips[5].name+ descrips[5].data+"\n");
       // Projekt.setLayoutAdd(mainPanel,layout,counterX,counterY,0,0,0,0,labelDes,1, 2, 1);
       // counterY+=2;
        //if(counterY>=17)
        //{
            counterY=0;
            counterX+=1;
        //}

        for(int i=0;i<35;i++)
        {
            createLabelCB(equips[i], mainPanel, layout,counterX,counterY);
            counterY+=1;
             if(counterY==17){
                counterY=0;
                counterX+=1;
            }
        }

        JLabel label1=new JLabel("___________________________________");
        Projekt.setLayoutAdd(mainPanel,layout,counterX,counterY,0,0,0,0,label1,1);
        counterY+=1;
        JLabel labelInf=new JLabel("Dane osoby dodającej samochód: ");
        Projekt.setLayoutAdd(mainPanel,layout,counterX,counterY,0,0,0,0,labelInf,1);
        counterY+=1;
        createLabel(cars[8], mainPanel, layout,counterX,counterY);
        counterY+=1;
        createLabel(cars[9], mainPanel, layout,counterX,counterY);
        counterY+=1;

        Projekt.setLayoutAdd(mainPanel,layout,counterX,counterY,0,0,0,0,modify,1);
        counterY+=1;
        Projekt.setLayoutAdd(mainPanel,layout,counterX,counterY,0,0,0,0,cancel,1);
        counterY+=1;
        Projekt.setLayoutAdd(mainPanel,layout,counterX,counterY,0,0,0,0,sell,1);

        modify.setActionCommand("addCar");
        HandlerClass handlerCondition=new HandlerClass(modify, rowID);
        modify.addActionListener(handlerCondition);

        cancel.setActionCommand("cancelModify");
        HandlerClass handlerCancel=new HandlerClass(cancel);
        cancel.addActionListener(handlerCancel);


        System.out.println("ROW ID w mouse handler : "+rowID);
        sell.setActionCommand("sellCar");
        HandlerClass sellHandler=new HandlerClass(rowID, stateID);
        sell.addActionListener(sellHandler);


        panel.add(editorScrollPane);
        panel.updateUI();
    }

    public void createPanel(Equipment equips[], Equipment descrips[], Equipment cars[], int rowID, int stateID )
    {
        int index;
        String name = "Modyfikacja auta";
        if (Projekt.tabbedPanel.indexOfTab(name) == -1) {

            try {

                //Wykorzystujemy swoją klase do stworzenia panelu
                JComponent modifyPanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Modyfikacja dodanego auta", "ikona1.gif");
                Projekt.tabbedPanel.updateUI();
                //Sprawdzamy jaki jest index ostatnio stworzonej tabeli aby można dodać akcje do przycisku.
                Projekt.addCloseButtonToPane(name);
                index = Projekt.tabbedPanel.indexOfTab(name);
                Projekt.tabbedPanel.setSelectedIndex(index);
                //createAddCarPanel(modifyPanel);
                JPanel panel=new JPanel();
                //modifyPanel.add(panel);
                showInfo(equips,descrips,cars, modifyPanel, rowID, stateID);

            } catch (Exception a) {
                System.out.println("Błąd w fokusowaniu...");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nie zakończyłeś dodawania innego samochodu!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
        }
    }



    public MouseHandler(JTable tables)
    {
        textArea=new JTextArea();
        textArea.setEditable(false);
        this.table=tables;
        tables=this.table;
    }

    void eventOutput(String eventDescription, MouseEvent e) {
        textArea.append(eventDescription + " detected on "
                + e.getComponent().getClass().getName()
                + "." + NEWLINE);
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    public void mousePressed(MouseEvent e) {
        eventOutput("Mouse pressed (# of clicks: "
                + e.getClickCount() + ")", e);
      //  System.out.println("Press!");
    }

    public void mouseReleased(MouseEvent e) {
        eventOutput("Mouse released (# of clicks: "
                + e.getClickCount() + ")", e);
    }

    public void mouseEntered(MouseEvent e) {
        eventOutput("Mouse entered", e);
       // System.out.println("myszka!");
    }

    public void mouseExited(MouseEvent e) {
        eventOutput("Mouse exited", e);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();
            int count= e.getClickCount();
            System.out.println("Kliknieto: "+count+" razy!");
            int row, column;
            row=this.table.getSelectedRow();
            column=this.table.getSelectedColumn();
            System.out.println("Zaznaczono: "+row+" wiersz i "+column+" kolumne!");

/*
            int index;
            String name = "Modyfikacja auta";
            if (Projekt.tabbedPanel.indexOfTab(name) == -1) {

                try {

                    //Wykorzystujemy swoją klase do stworzenia panelu
                    JComponent addCarPanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Modyfikacja dodanego auta", "ikona1.gif");
                    Projekt.tabbedPanel.updateUI();
                    //Sprawdzamy jaki jest index ostatnio stworzonej tabeli aby można dodać akcje do przycisku.
                    Projekt.addCloseButtonToPane(name);
                    index = Projekt.tabbedPanel.indexOfTab(name);
                    // Table=new Workers()
                    Projekt.tabbedPanel.setSelectedIndex(index);
                    //this.button.setEnabled(false);
                    createAddCarPanel(addCarPanel); */
                    showCar(row);
    /*
                } catch (Exception a) {
                    System.out.println("Błąd w fokusowaniu...");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Nie zakończyłeś dodawania innego samochodu!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
             */
            //handle double click event.
        }
        //int count= e.getClickCount();
        //System.out.println("Kliknieto: "+count+" razy!");
    }
}
