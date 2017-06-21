package com.SzymonJarzabek;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.scene.control.TextInputDialog;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static javax.swing.ScrollPaneConstants.*;
import java.util.Optional;

/**
 * Created by Szymon on 2017-04-19.
 */
public class HandlerClass implements ActionListener{

    JButton button;
    Table nTable;
    String name;
    JComponent panel;
    JTextPane textPanel=new JTextPane();
    private String tabName;
    JTextField textArea;

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

    public HandlerClass(String tabName)
    {
        this.tabName=tabName;
    }

    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx


//------------------------------Metody--------------------------

    public String getTabName() {
        return tabName;
    }

    private JCheckBox createCheckBox(String text, boolean selected, JPanel panel, GridBagConstraints layout, int gridx, int gridy, int top,int left, int bottom, int right)
    {
        JLabel label=new JLabel(text);
        JCheckBox button= new JCheckBox();
        button.setMnemonic(KeyEvent.VK_B);
        button.setSelected(selected);
        Projekt.setLayoutAdd(panel,layout,gridx,gridy,top,left-50,bottom,right,label,1);
        Projekt.setLayoutAdd(panel,layout,gridx+1,gridy,top,left-200,bottom,right,button,1);
       // panel.add(button);

        return button;
    }
    private JLabel createLabel(String text, JPanel panel, GridBagConstraints layout, int gridx, int gridy, int top,int left, int bottom, int right)
    {
        JLabel label=new JLabel(text);
        Projekt.setLayoutAdd(panel,layout,gridx,gridy,top,left,bottom,right,label,0);
       // panel.add(label);
        return label;
    }
    private JTextField createTextField(String text, int columns, int width, int height, JPanel panel, Color color, GridBagConstraints layout, int gridx, int gridy, int top,int left, int bottom, int right)
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
            Projekt.setLayoutAdd(panel,layout,gridx,gridy,top,left-50,bottom,right,label,1);
            Projekt.setLayoutAdd(panel, layout, gridx + 1, gridy, top, left - 200, bottom, right, textField, 1);
        }

        panel.setBackground(color);
        return textField;

    }

    protected JTextPane createTextPane(String text, int width, int height, JPanel panel, GridBagConstraints layout, int gridx, int gridy, int top,int left, int bottom, int right)
    {
        JLabel label=new JLabel(text);
        JTextPane textPane = new JTextPane();
        textPane.setEditable(true);
        JScrollPane modifyArea = Projekt.createTextArea(textPane,width,height);
        Projekt.setLayoutAdd(panel,layout,gridx,gridy,top,left,bottom,right,label,1);
        Projekt.setLayoutAdd(panel,layout,gridx+1,gridy,top,left,bottom,right,modifyArea,1,2);

        return textPane;
    }

    private JComboBox createComboBox(String text,String [] names, JPanel panel, GridBagConstraints layout, int gridx, int gridy, int top,int left, int bottom, int right)
    {
        JLabel label=new JLabel(text);
        JComboBox comboBox =new JComboBox(names);
        comboBox.setPreferredSize(new Dimension(170,20));
        Projekt.setLayoutAdd(panel,layout,gridx,gridy,top,left-50,bottom,right,label,1);
        Projekt.setLayoutAdd(panel,layout,gridx+1,gridy,top,left-200,bottom,right,comboBox,1);
        return comboBox;
    }

    private void createAddCarPanel(JComponent panel)
    {
        JPanel mainPanel=new JPanel();
        mainPanel.setPreferredSize(new Dimension(1180,610));
        mainPanel.setMaximumSize(new Dimension(1180,610));
        mainPanel.setBounds(0,0,1180,550);
        JScrollPane modifyArea = Projekt.createTextArea(mainPanel,1180,610);
        modifyArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints layout =new GridBagConstraints();



        JTextField marka=createTextField("Marka: ",20,50, 30,mainPanel, Color.cyan, layout,0,0,0,0,0,0);
        JTextField model=createTextField("Model: ",20,50, 30,mainPanel, Color.cyan, layout,2,0,0,-400,0,0);
        JTextField rok=createTextField("Rok produkcji: ",20,50, 30,mainPanel, Color.cyan, layout,4,0,0,-100,0,0);
        JTextField vin=createTextField("VIN: ",20,50, 30,mainPanel, Color.cyan, layout,0,1,0,0,0,0);
        JTextField przebieg=createTextField("Przebieg: ",20,50, 30,mainPanel, Color.cyan, layout,0,2,0,0,0,0);
        JTextField moc=createTextField("Moc: ",20,50, 30,mainPanel, Color.cyan, layout,0,3,0,0,0,0);
        String engineTypes[]={"Diesel", "Benzyna", "Hubryda", "Elektryczny", "Benzyna+LPG"};
        JComboBox typSilnika=createComboBox("Rodzaj paliwa: ",engineTypes,mainPanel, layout,0,4,0,0,0,0);
        JTextField pojemnosc=createTextField("Pojemność: ",20,50, 30,mainPanel, Color.cyan, layout,0,5,0,0,0,0);
        String gearbox[]={"Manualna", "Automat"};
        JComboBox skrzynia=createComboBox("Skrzynia biegów: ",gearbox,mainPanel, layout,0,6,0,0,0,0);
        String condition[]={"Nowy", "Używany", "Uszkodzony"};
        JComboBox stan=createComboBox("Stan: ",condition,mainPanel, layout,0,7,0,0,0,0);
        String body[]={"Sedan", "Hatchback", "Kombi", "SUV", "Minivan", "Kabriolet", "Terenowy", "Coupe"};
        JComboBox nadwozie=createComboBox("Nadwozie: ", body,mainPanel, layout,0,8,0,0,0,0);
        JTextField krajPoch=createTextField("Kraj pochodzenia: ",20,50, 30,mainPanel, Color.cyan, layout,0,9,0,0,0,0);
        JCheckBox serwis= createCheckBox("Serwisowany", false, mainPanel, layout,0,10,0,0,0,0);
        JTextPane opis=createTextPane("Dodatkowy opis: ",450,150,mainPanel, layout,0,11,0,-50,0,0);


        panel.add(modifyArea);
        panel.updateUI();


    }

    private void setTable(Table table) throws Exception
    {
        this.nTable=new Table(name);
    }
    private void setCloseButton(JButton button)
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
        } else if (event.getActionCommand().equals("Modify")) {
            int index;
            String name = "Modyfikacja";
            int x = nTable.table.getSelectedRow();
            int y = nTable.table.getSelectedColumn();
            if (Projekt.tabbedPanel.indexOfTab(name) == -1) {

                //wykona się jeśli zaznaczono pierwszą kolumne
                if (y == 0) {
                    try {
                        //Wykorzystujemy swoją klase do stworzenia panelu
                        JComponent modifypanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Modyfikacja wiersza", "ikona1.gif");
                        Projekt.tabbedPanel.updateUI();
                        //Sprawdzamy jaki jest index ostatnio stworzonej tabeli aby można dodać akcje do przycisku.
                        index = Projekt.tabbedPanel.indexOfTab(name);
                        //System.out.println("Index wynosi: "+index);
                        // System.out.println("PrefIDX wynosi: "+preferedIdx);
                        JPanel pnlTab = new JPanel(new GridBagLayout());
                        pnlTab.setOpaque(false);
                        JLabel lblTitle = new JLabel(name);
                        //Obsługa przycisku do zamykania
                        JButton btnClose1 = new JButton("x");
                        setCloseButton(btnClose1);
                        //koniec obłsugi przycisku
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.gridx = 0;
                        gbc.gridy = 0;
                        gbc.weightx = 0.5;
                        pnlTab.add(lblTitle, gbc);
                        gbc.gridx += 3;
                        gbc.weightx = 0;
                        pnlTab.add(btnClose1, gbc);
                        Projekt.tabbedPanel.setTabComponentAt(index, pnlTab);
                        HandlerClass handlerClose = new HandlerClass(name);
                        btnClose1.addActionListener(handlerClose);
                        Projekt.tabbedPanel.setSelectedIndex(index);
                        System.out.println("Czesc");
                    } catch (Exception e) {
                        System.out.println("Błąd w fokusowaniu...");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Zaznaczono kolumne w której nie znajduje sie ID", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nie zakonczono rozpoczetej modyfikacji!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
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
                       // Table=new Workers()
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
                    createAddCarPanel(addCarPanel);

                } catch (Exception e) {
                    System.out.println("Błąd w fokusowaniu...");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Nie zakończyłeś dodawania innego samochodu!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }
}


