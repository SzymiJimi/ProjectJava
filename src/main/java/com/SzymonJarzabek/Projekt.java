package com.SzymonJarzabek;

/**
 * Created by Szymon on 2017-04-18.
 */

/**
 * Created by Szymon on 2017-04-18.
 */

import jdk.nashorn.internal.runtime.ECMAException;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Projekt implements ActionListener{
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;


    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();
        if (action.equals("Workers")) {
            System.out.println("Button pressed!");
        }

    }

    // mainpanel ->tabbedPanel
    // panel1 ->mainPanel
    static JComponent mainPanel; //Zakładka "panel główny"
    static JComponent modifyPanel;
    static JPanel panel= new JPanel();  //jeszcze nie uzywany
    static JTabbedPane tabbedPanel=new JTabbedPane(); //Panel zakładkowy do którego są dodawane zakładki
    //static JComponent panel3;
    // static JButton btnClose = new JButton("x");
    //static JButton btnClose1 = new JButton("x");
    public static JTable createTable(String name, JComponent panel) throws Exception
    {
        panel.updateUI();
        Table Item=new Table(name);
        /*try {
            panel.remove(1);
        }catch(Exception e){
            System.out.println("Błąd");
        }*/



        JScrollPane tableArea = Projekt.createTextArea(Item.table,1180,580);
        //tableArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //tableArea.updateUI();
        panel.add(tableArea);
        panel.updateUI();
        return Item.table;

    }
    public final static MouseListener buttonMouseListener = new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
            Component component = e.getComponent();
            System.out.println("w przycisku close!");
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(true);
            }
        }

        public void mouseExited(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(false);
            }
        }
    };

    private static JFrame createWindow(int x, int y)
    {
        JFrame window= new JFrame("Komis samochodowy");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(x,y);
        return window;
    }

    public static void addCloseButtonToPane(String nameOfPane)
    {
        try {
            int index = tabbedPanel.indexOfTab(nameOfPane);
            JPanel pnlTab = new JPanel(new GridBagLayout());
            pnlTab.setOpaque(false);
            JLabel lblTitle = new JLabel(nameOfPane);
            JButton btnClose = new JButton("x");
            btnClose.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
            Dimension size = new Dimension(17, 17);
            btnClose.setPreferredSize(size);
            btnClose.setToolTipText("Zamknij zakładke");
            btnClose.setUI(new BasicButtonUI());
            btnClose.setActionCommand("removeTab");
            btnClose.setContentAreaFilled(false);
            btnClose.setFocusable(false);
            btnClose.setBorder(BorderFactory.createEtchedBorder());
            btnClose.setBorderPainted(false);
            btnClose.addMouseListener(buttonMouseListener);
            btnClose.setRolloverEnabled(true);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 0.5;

            pnlTab.add(lblTitle, gbc);

            gbc.gridx += 2;
            gbc.weightx = 0;
            pnlTab.add(btnClose, gbc);

            tabbedPanel.setTabComponentAt(index, pnlTab);
            HandlerClass handlerClose = new HandlerClass(nameOfPane);
            btnClose.addActionListener(handlerClose);
        }catch (Exception e )
        {
            System.out.println("Błąd w przycisku close");
        }
    }

    private static JButton createButton(String name, int x, int y, int width, int height)
    {
        JButton button = new JButton(name);
        if(x!=-1) {
            button.setBounds(x, y, width, height);
        }
        return button;
    }

    protected static void setLayoutAdd( JComponent panel, GridBagConstraints layout, int x, int y, int top, int left, int bottom, int right, JComponent component)
    {
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.ipady=0;
        // layout.weighty=1;
        layout.weightx = 0;
        layout.insets = new Insets(top,left,bottom,right);
        layout.gridx = x;
        layout.gridy = y;
        panel.add(component, layout);
    }

    protected static void setLayoutAdd( JComponent panel, GridBagConstraints layout, int x, int y, int top, int left, int bottom, int right, JComponent component, int weigthy)
    {
        layout.fill = GridBagConstraints.NONE;
        layout.ipady=0;
        layout.weighty=weigthy;
        layout.weightx = 0.5;
        layout.insets = new Insets(top,left,bottom,right);
        layout.gridx = x;
        layout.gridy = y;
        panel.add(component, layout);
    }

    protected static void setLayoutAdd( JComponent panel, GridBagConstraints layout, int x, int y, int top, int left, int bottom, int right, JComponent component, int weigthy, int widthx)
    {
        layout.fill = GridBagConstraints.NONE;
        layout.ipady=0;
        layout.weighty=weigthy;
        layout.weightx = 0.5;
        layout.gridwidth=widthx;
        layout.insets = new Insets(top,left,bottom,right);
        layout.gridx = x;
        layout.gridy = y;
        panel.add(component, layout);
    }

    protected static void setLayoutAdd( JComponent panel, GridBagConstraints layout, int x, int y, int top, int left, int bottom, int right, JComponent component, int weigthy, int widthy, int r)
    {
        layout.fill = GridBagConstraints.NONE;
        layout.ipady=0;
        layout.weighty=weigthy;
        layout.weightx = 0.5;
        layout.gridheight=widthy;
        layout.insets = new Insets(top,left,bottom,right);
        layout.gridx = x;
        layout.gridy = y;
        panel.add(component, layout);
    }

    protected static JScrollPane createTextArea(JComponent textPane, int sizex, int sizey)
    {

        Color paneColor = new Color(147, 205, 205);
        textPane.setBackground(paneColor);
        textPane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        JScrollPane editorScrollPane = new JScrollPane(textPane);
        editorScrollPane.setPreferredSize(new Dimension(sizex, sizey));
        editorScrollPane.setMinimumSize(new Dimension(sizex, sizey));

        return editorScrollPane;
    }


    /*
    private static void setLayoutAdd(JComponent panel, GridBagConstraints layout, int x, int y, int top, int left, int bottom, int right, JComponent component, int heigth)
    {
      //  if (shouldFill) {
            layout.fill = GridBagConstraints.HORIZONTAL;
      //  }
      //  if (shouldWeightX) {
            layout.weightx = 0.5;
        //}
        layout.insets = new Insets(top,left,bottom,right);
        layout.gridheight=heigth;
        layout.gridx = x;
        layout.gridy = y;
        panel.add(component, layout);
    }
*/

    public static void main(String[] args) throws Exception {

        //Połączenie z bazą danych

        Table.statement = Table.connectToDB();
        Table Osoby=new Table( "ADRESY");  //Stworzenie tabeli osoby
        JFrame okno = createWindow(1200,700); //Stworzenie okna
        okno.setResizable(false);
        JPanel primaWinPanel = new JPanel();// Panel zawierający wszystkie inne panele i on jest dodawany do okna
        //primaWinPanel.setLayout(new GridBagLayout());

        //Zakładki
        // tabbedPanel.setBounds(0,0,1200,800);
        mainPanel=Shelf.createShelf(tabbedPanel, "Panel główny", "Text", "Główny panel", "ikona1.gif"); //Utworzenie i dodanie zakładki "Panel Główny"



        //xxxxxxxx

        //Stworzenie przycisków
        JButton butPrac=createButton("Pracownicy", -1,0,0,0);
        JButton butAdd=createButton("Dodaj auta", -1,0,0,0);
        JButton butStan=createButton("Pokaż auta na stanie", -1,0,0,0);
        JButton butSprzed=createButton("Ostatnio sprzedane", -1,0,0,0);
        JButton butKli=createButton("Klienci", -1,0,0,0);
        JButton butGraf=createButton("Grafik", -1,0,0,0);
        JButton butModEvt=createButton("Modyfikuj...", -1,0,0,0);
        //xxxxxxxx
        butPrac.setBackground(new Color(197, 205, 125));
        butAdd.setBackground(new Color(197, 205, 125));
        butStan.setBackground(new Color(197, 205, 125));
        butSprzed.setBackground(new Color(197, 205, 125));
        butKli.setBackground(new Color(197, 205, 125));
        butGraf.setBackground(new Color(197, 205, 125));

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints layout = new GridBagConstraints();


        JLabel lastMod =new JLabel("Ostatnie modyfikacje:");
        JLabel upcomingEvt =new JLabel("Nadchodzące wydarzenia:");
        JLabel chooseOptn =new JLabel("Wybierz czynność z poniższych:");
        Font font= new Font("Corbel", Font.BOLD,20);
        chooseOptn.setFont(font);


        JTextPane textPaneMod = new JTextPane();
        textPaneMod.setEditable(false);
        textPaneMod.setText("Czesc sdfs\naaaa\naa\naa\naaa\naa\na\na\naaa\naa\na\na\na\naaa\naaa\naaaa\naaa\naas\ndfs\nfsdfsdf\n");
        JTextPane textPaneEvt = new JTextPane();
        textPaneEvt.setEditable(false);
        JScrollPane modifyArea = createTextArea(textPaneMod,450,300);
        JScrollPane eventsArea = createTextArea(textPaneEvt,450,200);

        //xxxxxxxx-TextPane-xxxxxxxxxxxx



        //Dodanie przycisków do panelu głównego
        setLayoutAdd(mainPanel,layout,0,0,-20,-200,0,20,chooseOptn);
        setLayoutAdd(mainPanel,layout,0,1,-300,-200,0,-150,butPrac);
        setLayoutAdd(mainPanel,layout,0,2,-440,-200,0,-150,butAdd);
        setLayoutAdd(mainPanel,layout,0,3,-480,-200,0,-150,butStan);
        setLayoutAdd(mainPanel,layout,0,4,-480,-200,0,-150,butSprzed);
        setLayoutAdd(mainPanel,layout,0,5,-280,-200,0,-150,butKli);
        setLayoutAdd(mainPanel,layout,0,6,-50,-200,20,-150,butGraf);
        setLayoutAdd(mainPanel,layout,1,0,100,400,0,-200,lastMod);
        setLayoutAdd(mainPanel,layout,1,1,0,400,0,-200,modifyArea);
        setLayoutAdd(mainPanel,layout,1,2,30,400,0,-200,upcomingEvt);
        setLayoutAdd(mainPanel,layout,1,3,0,400,0,-200,eventsArea);
        //xxxxxxxxxxx


        butPrac.setActionCommand("Workers");
        HandlerClass handlerWork=new HandlerClass(textPaneEvt);
        butPrac.addActionListener(handlerWork);

        butAdd.setActionCommand("addCar");
        HandlerClass handlerAdd=new HandlerClass(butAdd);
        butAdd.addActionListener(handlerAdd);

        butStan.setActionCommand("condition");
        HandlerClass handlerCondition=new HandlerClass(butStan);
        butStan.addActionListener(handlerCondition);

        butSprzed.setActionCommand("lastSelled");
        HandlerClass handlerSell=new HandlerClass(butSprzed);
        butSprzed.addActionListener(handlerSell);

        butKli.setActionCommand("Clients");
        HandlerClass handlerClients=new HandlerClass(butSprzed);
        butKli.addActionListener(handlerSell);


        JLabel logInfo=new JLabel("Zalogowano jako:");
        logInfo.setBounds(0,0,150,60);

        JPanel panelLogInfo= new JPanel();
        //  TableModel datePicker = new DatePickerTable("01011999","12302000");
        panelLogInfo.add(logInfo);


        primaWinPanel.setLayout(new GridBagLayout());
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.weightx = 0.5;
        //  layout.anchor=GridBagConstraints.PAGE_END;
        layout.insets = new Insets(100,0,0,10);
        layout.gridx = 0;
        layout.gridwidth = 2;
        layout.gridy = 1;
        //tabbedPanel.setBounds(0,0,1200,700);
        primaWinPanel.add(tabbedPanel, layout);


        //layout.fill = GridBagConstraints.HORIZONTAL;
        //  layout.anchor=GridBagConstraints.NORTH;
        layout.weightx = 0.5;
        layout.insets = new Insets(0,900,0,10);
        layout.gridx = 1;
        layout.gridwidth = 1;
        layout.gridy = 0;
        primaWinPanel.add(panelLogInfo, layout);


        okno.add(primaWinPanel);
        // okno.add(mainPanel);
        okno.setVisible(true);
        //xxx
    }

}
