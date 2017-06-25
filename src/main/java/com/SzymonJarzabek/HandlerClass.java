package com.SzymonJarzabek;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.scene.control.TextInputDialog;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static javax.swing.ScrollPaneConstants.*;
import java.util.Optional;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by Szymon on 2017-04-19.
 */
public class HandlerClass implements ActionListener{

    int row_id=-1;
    JButton button;
    Table nTable;
    String name;
    JComponent panel;
    JTextPane textPanel=new JTextPane();
    private String tabName;
    JTextField textArea;
    Car Auto;

    //-----------------Konstruktory----------------------------------------
    public HandlerClass(Table table, JTextField pole, String name, JComponent panel)
    {
        this.tabName=tabName;
        this.name=name;
        this.panel=panel;
        try {
            setTable(table);
        }catch(Exception e) {
        }
        nTable=table;
        this.textArea=pole;
    }
    public HandlerClass(JTextPane textPane)
    {
        this.textPanel=textPane;
        textPane=this.textPanel;
    }
    public HandlerClass(JButton button)
    {
        this.button=button;
        button=this.button;
    }

    public HandlerClass(Car Samochod)
    {
        this.Auto=Samochod;
    }

    public HandlerClass(Car Samochod,int row_id )
    {
        this.Auto=Samochod;
        this.row_id=row_id;
    }

    public HandlerClass(JButton button, int row_id)
    {
        this.button=button;
        button=this.button;
        this.row_id=row_id;
    }


    public HandlerClass(String tabName)
    {
        this.tabName=tabName;
    }

    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx


//------------------------------Metody--------------------------

    public String getTabName() {
        return tabName;
    }

    protected static JCheckBox createCheckBox(String text, boolean selected, JPanel panel, GridBagConstraints layout, int gridx, int gridy, int top,int left, int bottom, int right)
    {
        JLabel label=new JLabel(text);
        JCheckBox button= new JCheckBox();
        button.setMnemonic(KeyEvent.VK_B);
        button.setSelected(selected);
        Projekt.setLayoutAdd(panel,layout,gridx,gridy,top,left-200,bottom,right,label,1);
        Projekt.setLayoutAdd(panel,layout,gridx+1,gridy,top,left+20,bottom,right,button,1);
       // panel.add(button);

        return button;
    }

    protected static JCheckBox createCheckBox(String text, boolean selected, JPanel panel, GridBagConstraints layout, int gridx, int gridy, int top,int left, int bottom, int right, int x)
    {
        JLabel label=new JLabel(text);
        JCheckBox button= new JCheckBox();
        button.setMnemonic(KeyEvent.VK_B);
        button.setSelected(selected);
        Projekt.setLayoutAdd(panel,layout,gridx,gridy,top,left-100,bottom,right,label,1);
        Projekt.setLayoutAdd(panel,layout,gridx+1,gridy,top,left-400,bottom,right,button,1);
        // panel.add(button);

        return button;
    }
    protected static JLabel createLabel(String text, JPanel panel, GridBagConstraints layout, int gridx, int gridy, int top,int left, int bottom, int right)
    {
        JLabel label=new JLabel(text);
        Projekt.setLayoutAdd(panel,layout,gridx,gridy,top,left,bottom,right,label,0);
       // panel.add(label);
        return label;
    }
    protected static JTextField createTextField(String text, int columns, int width, int height, JPanel panel, Color color, GridBagConstraints layout, int gridx, int gridy, int top,int left, int bottom, int right)
    {
        JLabel label=new JLabel(text);

        JTextField textField = new JTextField(columns);
        textField.setBounds(0, 0, width, height);
        textField.setDocument(new JTextFieldLimit(columns));
        textField.setColumns((int)(columns-(columns*0.25)));
        textField.setBorder(BorderFactory.createLoweredSoftBevelBorder());

        if(gridx>0){
            Projekt.setLayoutAdd(panel,layout,gridx,gridy,top,left,bottom,right,label,1);
            Projekt.setLayoutAdd(panel,layout,gridx+1,gridy,top,left,bottom,right,textField,1);
        }else {
            Projekt.setLayoutAdd(panel,layout,gridx,gridy,top,left-100,bottom,right,label,1);
            Projekt.setLayoutAdd(panel, layout, gridx + 1, gridy, top, left - 400, bottom, right, textField, 1);
        }

        panel.setBackground(color);
        return textField;

    }

    protected static JTextPane createTextPane(String text, int width, int height, JPanel panel, GridBagConstraints layout, int gridx, int gridy, int top,int left, int bottom, int right)
    {
        JLabel label=new JLabel(text);
        JTextPane textPane = new JTextPane();
        textPane.setEditable(true);
        JScrollPane modifyArea = Projekt.createTextArea(textPane,width,height);
        Projekt.setLayoutAdd(panel,layout,gridx,gridy,top,left-50,bottom,right,label,1);
        Projekt.setLayoutAdd(panel,layout,gridx+1,gridy,top,left-150,bottom,right,modifyArea,1,2);

        return textPane;
    }

    protected static JComboBox createComboBox(String text,String [] names, JPanel panel, GridBagConstraints layout, int gridx, int gridy, int top,int left, int bottom, int right)
    {
        JLabel label=new JLabel(text);
        JComboBox comboBox =new JComboBox(names);
        comboBox.setPreferredSize(new Dimension(170,20));
        Projekt.setLayoutAdd(panel,layout,gridx,gridy,top,left-100,bottom,right,label,1);
        Projekt.setLayoutAdd(panel,layout,gridx+1,gridy,top,left-400,bottom,right,comboBox,1);
        return comboBox;
    }

    private void createAddCarPanel(JComponent panel, int row_id)
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


        Samochod.marka=createTextField("Marka: ",20,50, 30,mainPanel, Color.cyan, layout,0,0,0,0,0,0);
        Samochod.model=createTextField("Model: ",20,50, 30,mainPanel, Color.cyan, layout,0,1,0,0,0,0);
        String years[]={"1986","1987","1988","1989","1990","1991","1993","1994","1995","1996","1997","1998","1999","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017"};
        //Samochod.rok=createTextField("Rok produkcji: ",20,50, 30,mainPanel, Color.cyan, layout,0,2,0,0,0,0);
        Samochod.rok=createComboBox("Rok produkcji: ",years,mainPanel ,layout,  0,2,0,0,0,0);
        Samochod.vin=createTextField("VIN: ",20,50, 30,mainPanel, Color.cyan, layout,0,3,0,0,0,0);
        Samochod.przebieg=createTextField("Przebieg: ",20,50, 30,mainPanel, Color.cyan, layout,0,4,0,0,0,0);
        Samochod.moc=createTextField("Moc: ",20,50, 30,mainPanel, Color.cyan, layout,0,5,0,0,0,0);
        String engineTypes[]={"Diesel", "Benzyna", "Hybrydowy", "Elektryczny", "Benzyna+LPG"};
        Samochod.typSilnika=createComboBox("Rodzaj paliwa: ",engineTypes,mainPanel, layout,0,6,0,0,0,0);
        String capacity[]={"0.8","0.9","1.0","1.1","1.2","1.3","1.4","1.5","1.6","1.7","1.8","1.9","2.0","2.1","2.2","2.3","2.4","2.5","2.6","2.7","2.8","2.9","3.0","3.1","3.2","3.3","3.4","3.5","3.6","3.7","3.8","3.9","4.0","4.1","4.2","4.3","4.4","4.5","4.6","4.7","4.8","4.9","5.0"};
        //Samochod.pojemnosc=createTextField("Pojemność: ",20,50, 30,mainPanel, Color.cyan, layout,0,7,0,0,0,0);
        Samochod.pojemnosc=createComboBox("Pojemność: ",capacity,mainPanel ,layout,  0,7,0,0,0,0);
        String gearbox[]={"Manualna", "Automat"};
        Samochod.skrzynia=createComboBox("Skrzynia biegów: ",gearbox,mainPanel, layout,0,8,0,0,0,0);
        String condition[]={"Nowy", "Używany", "Uszkodzony"};
        Samochod.stan=createComboBox("Stan: ",condition,mainPanel, layout,0,9,0,0,0,0);
        String body[]={"Sedan", "Hatchback", "Kombi", "SUV", "Minivan", "Kabriolet", "Terenowy", "Coupe"};
        Samochod.nadwozie=createComboBox("Nadwozie: ", body,mainPanel, layout,0,10,0,0,0,0);
        String origin[]={"Polska","Niemcy","Francja","Holandia","Włochy","Wielka Brytania", "Belgia", "Dania", "Ameryka", "Inny"};
        Samochod.krajPoch=createComboBox("Pojemność: ",origin,mainPanel ,layout,  0,11,0,0,0,0);
        //Samochod.krajPoch=createTextField("Kraj pochodzenia: ",20,50, 30,mainPanel, Color.cyan, layout,0,11,0,0,0,0);
        Samochod.serwis= createCheckBox("Serwisowany", false, mainPanel, layout,0,12,0,0,0,0,1);
        Samochod.opis=createTextPane("Dodatkowy opis: ",400,150,mainPanel, layout,0,13,0,-50,0,0);

        //JCheckBox serwis= createCheckBox("Poduszki", false, mainPanel, layout,0,10,0,0,0,0);

        Samochod.abs= createCheckBox("ABS: ", false, mainPanel, layout,2,0,0,0,0,0);
        Samochod.esp= createCheckBox("ESP: " , false, mainPanel, layout,2,1,0,0,0,0);
        Samochod.wspKier= createCheckBox("Wspomaganie kierownicy: ", false, mainPanel, layout,2,2,0,0,0,0);
        Samochod.bluetooth= createCheckBox("Bluetooth: ", false, mainPanel, layout,2,3,0,0,0,0);
        Samochod.czZmierzchu= createCheckBox("Czujnik zmierzchu: ", false, mainPanel, layout,2,4,0,0,0,0);
        Samochod.czParkowania= createCheckBox("Czujniki parkowania: ", false, mainPanel, layout,2,5,0,0,0,0);
        Samochod.czDeszczu= createCheckBox("Czujniki deszczu: ", false, mainPanel, layout,2,6,0,0,0,0);
        Samochod.elLusterka= createCheckBox("Elektryczne lusterka: ", false, mainPanel, layout,2,7,0,0,0,0);
        Samochod.elSzybyP= createCheckBox("Elektryczne szyby przednie: ", false, mainPanel, layout,2,8,0,0,0,0);
        Samochod.elSzybyT= createCheckBox("Elektryczne szyby tylnie: ", false, mainPanel, layout,2,9,0,0,0,0);
        Samochod.podgrzLustBok= createCheckBox("Podgrzewane lusterka boczne: ", false, mainPanel, layout,2,10,0,0,0,0);
        Samochod.podgrzSiedzP= createCheckBox("Podgrzewane siedzenia przód: ", false, mainPanel, layout,2,11,0,0,0,0);
        Samochod.podgrzSiedzT= createCheckBox("Podgrzewane siedzenia tył: ", false, mainPanel, layout,2,12,0,0,0,0);
        Samochod.podgrzKier= createCheckBox("Podgrzewanie kierownicy: ", false, mainPanel, layout,2,13,-130,0,0,0);
        Samochod.immobilizer= createCheckBox("Immobilizer: ", false, mainPanel, layout,2,14,-240,0,0,0);
        Samochod.alarm= createCheckBox("Alarm: ", false, mainPanel, layout,2,15,-200,0,0,0);
        Samochod.centralnyZam= createCheckBox("Centralny zamek: ", false, mainPanel, layout,2,16,-160,0,0,0);
        Samochod.pilot= createCheckBox("Pilot: ", false, mainPanel, layout,4,0,0,0,0,0);
        Samochod.mp3= createCheckBox("Radio mp3: ", false, mainPanel, layout,4,1,0,0,0,0);
        Samochod.gnAux= createCheckBox("Gniazdo AUX: ", false, mainPanel, layout,4,2,0,0,0,0);
        Samochod.radioFabr= createCheckBox("Radio fabryczne: ", false, mainPanel, layout,4,3,0,0,0,0);
        Samochod.cd= createCheckBox("Odtwarzacz CD: ", false, mainPanel, layout,4,4,0,0,0,0);
        Samochod.kompPokl= createCheckBox("Komputer pokładowy: ", false, mainPanel, layout,4,5,0,0,0,0);
        Samochod.gniazdo12V= createCheckBox("Gniazdo 12V: ", false, mainPanel, layout,4,6,0,0,0,0);
        Samochod.tempomat= createCheckBox("Tempomat: ", false, mainPanel, layout,4,7,0,0,0,0);
        Samochod.aktywTemp= createCheckBox("Aktywny tempomat: ", false, mainPanel, layout,4,8,0,0,0,0);
        Samochod.lineAsist= createCheckBox("Line asist: ", false, mainPanel, layout,4,9,0,0,0,0);
        Samochod.kurtynyPow= createCheckBox("Kurtyny powietrzne: ", false, mainPanel, layout,4,10,0,0,0,0);
        Samochod.isofix= createCheckBox("ISOFIX: ", false, mainPanel, layout,4,11,0,0,0,0);
        Samochod.ciemneSzyby= createCheckBox("Przyciemniane szyby: ", false, mainPanel, layout,4,12,0,0,0,0);
        Samochod.alufelgi= createCheckBox("Alufelgi: ", false, mainPanel, layout,4,13,-130,0,0,0);
        Samochod.relingi= createCheckBox("Relingi dachowe: ", false, mainPanel, layout,4,14,-240,0,0,0);
        Samochod.swLED= createCheckBox("Światła ledowe: ", false, mainPanel, layout,4,15,-200,0,0,0);
        Samochod.swXenon= createCheckBox("Światła xenonowe: ", false, mainPanel, layout,4,16,-160,0,0,0);
        Samochod.swDzien= createCheckBox("Światła do jazdy dziennej: ", false, mainPanel, layout,4,17,-120,0,0,0);


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

        if(row_id==-1) {
            accept.setActionCommand("acceptAddCar");
            HandlerClass handlerAdd = new HandlerClass(Samochod);
            accept.addActionListener(handlerAdd);
        }else {
            accept.setActionCommand("acceptAddCar");
            HandlerClass handlerAdd = new HandlerClass(Samochod, row_id);
            accept.addActionListener(handlerAdd);
        }

        panel.add(modifyArea);
        panel.updateUI();


    }

    protected int saveBool(boolean value){

        int variable=0;
        if(value)
        {
            variable=1;
        }
        return variable;
    }
    private void setTable(Table table) throws Exception
    {
        this.nTable=new Table(name);
    }
    protected static void setCloseButton(JButton button)
    {
        button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
        Dimension size = new Dimension(17, 17);
        button.setPreferredSize(size);
        button.setToolTipText("close this tab");
        button.setUI(new BasicButtonUI());
        button.setActionCommand("removeTab");

        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setBorderPainted(false);
        button.addMouseListener(Projekt.buttonMouseListener);
        button.setRolloverEnabled(true);
    }

    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    //---------------------Metoda dla akcji----------------------------
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Delete")) {
            //sprawdzanie który wiersz i którą kolumne zaznaczylismy
            int x = nTable.table.getSelectedRow();
            int y = nTable.table.getSelectedColumn();
            //wykona się jeśli zaznaczono pierwszą kolumne
            if (y == 0) {
                //System.out.println("Wiersz: "+x+" Kolumna "+y+" Wartosc "+ nTable.table.getValueAt(x,y));
                Object tmp = nTable.table.getValueAt(x, y);
                int value = tmp.hashCode() - 48;
                // System.out.println("II wersja Wiersz: "+x+" Kolumna "+y+" Wartosc "+ value);
                String infoMessage = "Siemka", titleBar = "Co tam";
                try {
                    System.out.println(name + value);
                    nTable.deleteRow(name, value);
                    nTable.getOsoby();
                    try {
                        Projekt.mainPanel.remove(2);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Błąd w usuwaniu");
                    }
                    try {
                        Projekt.mainPanel.add(nTable.table);
                    } catch (NullPointerException e) {
                        System.out.println("Błąd w dodawaniu");
                    }
                    try {
                        Projekt.mainPanel.updateUI();
                    } catch (NullPointerException e) {
                        System.out.println("Błąd w updacie");
                    }

                    try {
                        JOptionPane.showMessageDialog(null, "Usunieto: " + y + " wiersz. Takst: " + textArea.getText(), titleBar, JOptionPane.INFORMATION_MESSAGE);
                    } catch (HeadlessException e) {
                        System.out.println("Błąd w okienku");
                    }

                } catch (Exception e) {
                    System.out.println("Błąd w przycisku");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Zaznaczono kolumne w której nie znajduje sie ID", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (event.getActionCommand().equals("removeTab")) {
            int index = Projekt.tabbedPanel.indexOfTab(getTabName());
           // System.out.println("Index tabeli usuwanej: " + index);
            if (index >= 0) {

                Projekt.tabbedPanel.removeTabAt(index);
                //zmniejszanie indexu panelu aby później można było dodać znów
                Shelf.i--;
                // It would probably be worthwhile getting the source
                // casting it back to a JButton and removing
                // the action handler reference ;)

            }
        } else if (event.getActionCommand().equals("Workers")) {
                int index;
                String name = "Pracownicy";
                if (Projekt.tabbedPanel.indexOfTab(name) == -1) {

                    try {
                        //Wykorzystujemy swoją klase do stworzenia panelu
                        JComponent workersPanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Lista wszystkich pracowników", "ikona1.gif");
                        Projekt.tabbedPanel.updateUI();
                        //Sprawdzamy jaki jest index ostatnio stworzonej tabeli aby można dodać akcje do przycisku.
                        Projekt.addCloseButtonToPane(name);
                        index = Projekt.tabbedPanel.indexOfTab(name);
                        Projekt.createTable("PRACOWNICY", workersPanel);
                        //Table workers=new Table("Pracownicy");

                        Projekt.tabbedPanel.setSelectedIndex(index);

                    } catch (Exception e) {
                        System.out.println("Błąd w fokusowaniu...");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Panel z pracownikami został już otwarty!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
                }
        } else if(event.getActionCommand().equals("addCar")){
            int index;
            String name = "Dodawanie auta";
            if (Projekt.tabbedPanel.indexOfTab(name) == -1) {

                try {

                    //Wykorzystujemy swoją klase do stworzenia panelu
                    JComponent addCarPanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Lista wszystkich pracowników", "ikona1.gif");
                    Projekt.tabbedPanel.updateUI();
                    //Sprawdzamy jaki jest index ostatnio stworzonej tabeli aby można dodać akcje do przycisku.
                    Projekt.addCloseButtonToPane(name);
                    index = Projekt.tabbedPanel.indexOfTab(name);
                    // Table=new Workers()
                    Projekt.tabbedPanel.setSelectedIndex(index);
                    //this.button.setEnabled(false);
                    createAddCarPanel(addCarPanel, -1);

                } catch (Exception e) {
                    System.out.println("Błąd w fokusowaniu...");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Nie zakończyłeś dodawania innego samochodu!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
            }

        }else if(event.getActionCommand().equals("acceptAddCar")){

            System.out.println("Wcisnieto!");
            String markaTxt;
            markaTxt=Auto.marka.getText();

            System.out.println("Marka: "+markaTxt);

            String modelTxt=Auto.model.getText();
            String rokTxt=(String)Auto.rok.getSelectedItem();
            String vinTxt=Auto.vin.getText();
            String przebiegTxt=Auto.przebieg.getText();
            String mocTxt=Auto.moc.getText();
            String typSilnikaTxt=(String)Auto.typSilnika.getSelectedItem();
            String pojemnoscTxt=(String)Auto.pojemnosc.getSelectedItem();
            String skrzyniaTxt=(String)Auto.skrzynia.getSelectedItem();
            String stanTxt=(String)Auto.stan.getSelectedItem();
            String nadwozieTxt=(String)Auto.nadwozie.getSelectedItem();
            String krajPochTxt=(String)Auto.krajPoch.getSelectedItem();
            int serwisTxt=saveBool(Auto.serwis.isSelected());
            String opisTxt=Auto.opis.getText();

            int absBool=saveBool(Auto.abs.isSelected());
            int espBool=saveBool(Auto.esp.isSelected());
            int wspKierBool=saveBool(Auto.wspKier.isSelected());
            int bluetoothBool=saveBool(Auto.bluetooth.isSelected());
            int czZmierzchuBool=saveBool(Auto.czZmierzchu.isSelected());
            int czParkowaniaBool=saveBool(Auto.czParkowania.isSelected());
            int czDeszczuBool=saveBool(Auto.czDeszczu.isSelected());
            int elLusterkaBool=saveBool(Auto.elLusterka.isSelected());
            int elSzybyPBool=saveBool(Auto.elSzybyP.isSelected());
            int elSzybyTBool=saveBool(Auto.elSzybyT.isSelected());
            int podgrzLustBokBool=saveBool(Auto.podgrzLustBok.isSelected());
            int podgrzSiedzPBool=saveBool(Auto.podgrzSiedzP.isSelected());
            int podgrzSiedzTBool=saveBool(Auto.podgrzSiedzT.isSelected());
            int podgrzKierBool=saveBool(Auto.podgrzKier.isSelected());
            int immobilizerBool=saveBool(Auto.immobilizer.isSelected());
            int alarmBool=saveBool(Auto.alarm.isSelected());
            int centralnyZamBool=saveBool(Auto.centralnyZam.isSelected());
            int pilotBool=saveBool(Auto.pilot.isSelected());
            int mp3Bool=saveBool(Auto.mp3.isSelected());
            int gnAuxBool=saveBool(Auto.gnAux.isSelected());
            int radioFabrBool=saveBool(Auto.radioFabr.isSelected());
            int cdBool=saveBool(Auto.cd.isSelected());
            int kompPoklBool=saveBool(Auto.kompPokl.isSelected());
            int gniazdo12VBool=saveBool(Auto.gniazdo12V.isSelected());
            int tempomatBool=saveBool(Auto.tempomat.isSelected());
            int aktywTempBool=saveBool(Auto.aktywTemp.isSelected());
            int lineAsistBool=saveBool(Auto.lineAsist.isSelected());
            int kurtynyPowBool=saveBool(Auto.kurtynyPow.isSelected());
            int isofixBool=saveBool(Auto.isofix.isSelected());
            int ciemneSzyby=saveBool(Auto.ciemneSzyby.isSelected());
            int alufelgiBool=saveBool(Auto.alufelgi.isSelected());
            int relingiBool=saveBool(Auto.relingi.isSelected());
            int swLEDBool=saveBool(Auto.swLED.isSelected());
            int swXenonBool=saveBool(Auto.swXenon.isSelected());
            int swDzienBool=saveBool(Auto.swDzien.isSelected());

            String sqlQueryWyp;
            String sqlQueryOpis;
            String sqlQuerySam;
            //int rokInt=Integer.parseInt(rokTxt);

            if(row_id==-1) {
                sqlQueryWyp = "Insert into WYPOSAZENIE VALUES(wypseq.nextval, 10, " + absBool + ", " + espBool + ", " + wspKierBool + ", " + bluetoothBool + ", " + czZmierzchuBool + ", " + czParkowaniaBool + ", " + czDeszczuBool + ", " + elLusterkaBool + ", " + elSzybyPBool + ", " + elSzybyTBool + ", " + podgrzLustBokBool + ", " + podgrzSiedzPBool + ", ";
                sqlQueryWyp = sqlQueryWyp + podgrzSiedzTBool + ", " + podgrzKierBool + ", " + immobilizerBool + ", " + alarmBool + ", " + centralnyZamBool + ", " + pilotBool + ", " + mp3Bool + ", " + gnAuxBool + ", " + radioFabrBool + ", " + cdBool + ", " + kompPoklBool + ", " + gniazdo12VBool + ", " + tempomatBool + ", " + aktywTempBool + ", ";
                sqlQueryWyp = sqlQueryWyp + lineAsistBool + ", " + kurtynyPowBool + ", " + isofixBool + ", " + ciemneSzyby + ", " + alufelgiBool + ", " + relingiBool + ", " + swLEDBool + ", " + swXenonBool + ", " + swDzienBool + ")";

                sqlQueryOpis = "Insert into OPIS VALUES(opisseq.nextval, '" + skrzyniaTxt + "', '" + stanTxt + "', '" + nadwozieTxt + "', '" + krajPochTxt + "', " + serwisTxt + ", '" + opisTxt + "')";

                sqlQuerySam = "Insert into SAMOCHODY VALUES(samseq.nextval, '" + markaTxt + "', '" + modelTxt + "', " + rokTxt + ", '" + vinTxt + "', " + przebiegTxt + ", " + mocTxt + ", '" + typSilnikaTxt + "', " + pojemnoscTxt + ",wypseq.currval,opisseq.currval,10)";

                System.out.println("Zapytanie z dodawania wyposarzenia: " + sqlQueryWyp);
                System.out.println("Zapytanie z dodawania opisu: " + sqlQueryOpis);
                System.out.println("Zapytanie z dodawania samochodu: " + sqlQuerySam);
            }else{
                sqlQueryWyp = "UPDATE WYPOSAZENIE SET("+row_id+", 10, " + absBool + ", " + espBool + ", " + wspKierBool + ", " + bluetoothBool + ", " + czZmierzchuBool + ", " + czParkowaniaBool + ", " + czDeszczuBool + ", " + elLusterkaBool + ", " + elSzybyPBool + ", " + elSzybyTBool + ", " + podgrzLustBokBool + ", " + podgrzSiedzPBool + ", ";
                sqlQueryWyp = sqlQueryWyp + podgrzSiedzTBool + ", " + podgrzKierBool + ", " + immobilizerBool + ", " + alarmBool + ", " + centralnyZamBool + ", " + pilotBool + ", " + mp3Bool + ", " + gnAuxBool + ", " + radioFabrBool + ", " + cdBool + ", " + kompPoklBool + ", " + gniazdo12VBool + ", " + tempomatBool + ", " + aktywTempBool + ", ";
                sqlQueryWyp = sqlQueryWyp + lineAsistBool + ", " + kurtynyPowBool + ", " + isofixBool + ", " + ciemneSzyby + ", " + alufelgiBool + ", " + relingiBool + ", " + swLEDBool + ", " + swXenonBool + ", " + swDzienBool + ") WHERE WYPOSAZENIE_ID="+row_id;

                sqlQueryOpis = "UPDATE OPIS SET("+row_id + skrzyniaTxt + "', '" + stanTxt + "', '" + nadwozieTxt + "', '" + krajPochTxt + "', " + serwisTxt + ", '" + opisTxt + "') WHERE OPIS_ID="+row_id;

                sqlQuerySam =  "UPDATE SAMOCHODY SET("+row_id + markaTxt + "', '" + modelTxt + "', " + rokTxt + ", '" + vinTxt + "', " + przebiegTxt + ", " + mocTxt + ", '" + typSilnikaTxt + "', " + pojemnoscTxt + ", "+row_id+", "+row_id+", 10) WHERE SAMOCHOD_ID= "+row_id;

                System.out.println("Zapytanie z modyfikowania wyposarzenia: " + sqlQueryWyp);
                System.out.println("Zapytanie z modyfikowania opisu: " + sqlQueryOpis);
                System.out.println("Zapytanie z modyfikowania samochodu: " + sqlQuerySam);
            }
            int index;

            try {
                Table.statement.executeQuery(sqlQueryWyp);
                Table.statement.executeQuery("COMMIT");
                Table.statement.executeQuery(sqlQueryOpis);
                Table.statement.executeQuery("COMMIT");
                Table.statement.executeQuery(sqlQuerySam);
                //qRows -= 1;
                Table.statement.executeQuery("COMMIT");
                JOptionPane.showMessageDialog(null, "Dodano samochód!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                index = Projekt.tabbedPanel.indexOfTab("Dodawanie auta");
                // System.out.println("Index tabeli usuwanej: " + index);
                if (index >= 0) {

                    Projekt.tabbedPanel.removeTabAt(index);
                    //zmniejszanie indexu panelu aby później można było dodać znów
                    Shelf.i--;
                }
                index = Projekt.tabbedPanel.indexOfTab("Panel główny");
                Projekt.tabbedPanel.setSelectedIndex(index);

            }catch(Exception e)
            {
                System.out.println("Błąd w dodawaniu samochodu do bazy!");
            }

        }else if(event.getActionCommand().equals("condition")){

            //JPanel panel=new JPanel();
            int index;
            String name = "Auta na stanie";
            if (Projekt.tabbedPanel.indexOfTab(name) == -1) {

                try {
                    //Wykorzystujemy swoją klase do stworzenia panelu
                    JComponent conditionPanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Lista aut na stanie...", "ikona1.gif");
                    Projekt.tabbedPanel.updateUI();
                    //Sprawdzamy jaki jest index ostatnio stworzonej tabeli aby można dodać akcje do przycisku.
                    Projekt.addCloseButtonToPane(name);
                    index = Projekt.tabbedPanel.indexOfTab(name);
                    JTable table=Projekt.createTable("NA_STANIE", conditionPanel);
                    int row=table.getSelectedRow();
                    //Table workers=new Table("Pracownicy");
                    Projekt.tabbedPanel.setSelectedIndex(index);

                    MouseHandler handler=new MouseHandler(table);
                    table.addMouseListener(handler);


                } catch (Exception e) {
                    System.out.println("Błąd w fokusowaniu...");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Panel z pracownikami został już otwarty!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}


