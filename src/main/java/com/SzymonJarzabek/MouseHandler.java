package com.SzymonJarzabek;

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
import javax.swing.JFrame;
import javax.swing.JPanel;


import static jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType.NEWLINE;

/**
 * Created by Szymon on 2017-06-24.
 */
public class MouseHandler implements MouseListener{

    JTextArea textArea;
    JTable table;

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
                    createAddCarPanel(addCarPanel);

                } catch (Exception a) {
                    System.out.println("Błąd w fokusowaniu...");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Nie zakończyłeś dodawania innego samochodu!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
            }
            //handle double click event.
        }
        //int count= e.getClickCount();
        //System.out.println("Kliknieto: "+count+" razy!");
    }
}
