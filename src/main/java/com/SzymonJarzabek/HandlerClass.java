package com.SzymonJarzabek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Created by Szymon on 2017-04-19.
 */

/**Klasa obsługująca akcje
 *
 */
public class HandlerClass implements ActionListener {
    private int rowAdd, stateRowID, row_id = -1;
    private Equipment salary;
    private Equipment sellData;
    private Car AutoAdd;
    private JButton button;
    private Table nTable;
    private String tabName;
    protected String name;
    private JTextPane textPanel = new JTextPane();
    protected JTextField textArea;
    private Car Auto;

    /**
     * Konstruktory
     * @param textPane Parametr konstruktora, w tym przypasku TextPane do którego zostaną dodane informacje
     */
    protected HandlerClass(JTextPane textPane) {
        this.textPanel = textPane;
        textPane = this.textPanel;
    }

    protected HandlerClass(JButton button) {
        this.button = button;
        button = this.button;
    }

    protected HandlerClass(Car Samochod) {
        this.Auto = Samochod;
    }

    protected HandlerClass(Car Samochod, int row_id) {
        this.Auto = Samochod;
        this.row_id = row_id;
    }

    protected HandlerClass(JButton button, int row_id) {
        this.button = button;
        button = this.button;
        this.row_id = row_id;
    }

    protected HandlerClass(int row, Car Auto) {
        this.rowAdd = row;
        this.AutoAdd = Auto;
    }

    protected HandlerClass(int row, Equipment salary) {
        this.rowAdd = row;
        this.salary = salary;
    }

    protected HandlerClass(int row, int stateID) {
        this.rowAdd = row;
        this.stateRowID = stateID;
    }

    protected HandlerClass(int row) {
        this.rowAdd = row;
    }

    protected HandlerClass(Equipment sellData, int stateID, int carRow) {
        this.sellData = sellData;
        sellData = this.sellData;
        this.stateRowID = stateID;
        this.rowAdd = carRow;
    }

    protected HandlerClass(String tabName) {
        this.tabName = tabName;
    }


    protected String getTabName() {
        return tabName;
    }

    /**
     * Metoda tworząca checkbox
     * @param text Tekst obok checkboxa
     * @param selected Czy jest zaznaczony czy nie
     * @param panel panel do którego ma być dodany
     * @param layout Layout
     * @param gridx Pozycja x w layoucie
     * @param gridy Pozycja y w layoucie
     * @param top Odsunięcie od krawędzi górnej
     * @param left Odsunięcie od krawędzi lewej
     * @param bottom Odsunięcie od krawędzi dolnej
     * @param right Odsunięcie od krawędzi prawej
     * @return
     */
    protected static JCheckBox createCheckBox(String text, boolean selected, JPanel panel, GridBagConstraints layout, int gridx, int gridy, int top, int left, int bottom, int right) {
        JLabel label = new JLabel(text);
        JCheckBox button = new JCheckBox();
        button.setMnemonic(KeyEvent.VK_B);
        button.setSelected(selected);
        Projekt.setLayoutAdd(panel, layout, gridx, gridy, top, left - 200, bottom, right, label, 1);
        Projekt.setLayoutAdd(panel, layout, gridx + 1, gridy, top, left + 20, bottom, right, button, 1);
        return button;
    }

    /**
     * Przeciążona metoda wyżej
     * @param text Tekst obok checkboxa
     * @param selected Czy jest zaznaczony czy nie
     * @param panel panel do którego ma być dodany
     * @param layout Layout
     * @param gridx Pozycja x w layoucie
     * @param gridy Pozycja y w layoucie
     * @param top Odsunięcie od krawędzi górnej
     * @param left Odsunięcie od krawędzi lewej
     * @param bottom Odsunięcie od krawędzi dolnej
     * @param right Odsunięcie od krawędzi prawej
     * @param x
     * @return
     */
    protected static JCheckBox createCheckBox(String text, boolean selected, JPanel panel, GridBagConstraints layout, int gridx, int gridy, int top, int left, int bottom, int right, int x) {
        JLabel label = new JLabel(text);
        JCheckBox button = new JCheckBox();
        button.setMnemonic(KeyEvent.VK_B);
        button.setSelected(selected);
        Projekt.setLayoutAdd(panel, layout, gridx, gridy, top, left - 100, bottom, right, label, 1);
        Projekt.setLayoutAdd(panel, layout, gridx + 1, gridy, top, left - 400, bottom, right, button, 1);
        return button;
    }

    /**
     * Metoda tworząca pole tekstowe
     * @param text Tekst pojawiający się obok pola tekstowego
     * @param columns Ilość kolumn w polu tekstowym
     * @param width Szerokosć pola tekstowego
     * @param height Wysokosc pola tekstowego
     * @param panel Panel do którego zostanie dodane pole tekstowe i tekst
     * @param color kolor komponentu
     * @param layout Layout
     * @param gridx Pozycja x w layoucie
     * @param gridy Pozycja y w layoucie
     * @param top Odsunięcie od krawędzi górnej
     * @param left Odsunięcie od krawędzi lewej
     * @param bottom Odsunięcie od krawędzi dolnej
     * @param right Odsunięcie od krawędzi prawej
     * @return
     */
    protected static JTextField createTextField(String text, int columns, int width, int height, JPanel panel, Color color, GridBagConstraints layout, int gridx, int gridy, int top, int left, int bottom, int right) {
        JLabel label = new JLabel(text);
        JTextField textField = new JTextField(columns);
        textField.setBounds(0, 0, width, height);
        textField.setDocument(new JTextFieldLimit(columns));
        textField.setColumns((int) (columns - (columns * 0.25)));
        textField.setBorder(BorderFactory.createLoweredSoftBevelBorder());

        if (gridx > 0) {
            Projekt.setLayoutAdd(panel, layout, gridx, gridy, top, left, bottom, right, label, 1);
            Projekt.setLayoutAdd(panel, layout, gridx + 1, gridy, top, left, bottom, right, textField, 1);
        } else {
            Projekt.setLayoutAdd(panel, layout, gridx, gridy, top, left - 100, bottom, right, label, 1);
            Projekt.setLayoutAdd(panel, layout, gridx + 1, gridy, top, left - 400, bottom, right, textField, 1);
        }
        panel.setBackground(color);
        return textField;
    }

    /**
     * Metoda tworząca tablice z tekstem
     * @param text Tekst pojawiający się obok pola tekstowego
     * @param width Szerokosć pola tekstowego
     * @param height Wysokosc pola tekstowego
     * @param panel Panel do którego zostanie dodane pole tekstowe i tekst
     * @param layout Layout
     * @param gridx Pozycja x w layoucie
     * @param gridy Pozycja y w layoucie
     * @param top Odsunięcie od krawędzi górnej
     * @param left Odsunięcie od krawędzi lewej
     * @param bottom Odsunięcie od krawędzi dolnej
     * @param right Odsunięcie od krawędzi prawej
     * @return
     */
    protected static JTextPane createTextPane(String text, int width, int height, JPanel panel, GridBagConstraints layout, int gridx, int gridy, int top, int left, int bottom, int right) {
        JLabel label = new JLabel(text);
        JTextPane textPane = new JTextPane();
        textPane.setEditable(true);
        JScrollPane modifyArea = Projekt.createTextArea(textPane, width, height);
        Projekt.setLayoutAdd(panel, layout, gridx, gridy, top, left - 50, bottom, right, label, 1);
        Projekt.setLayoutAdd(panel, layout, gridx + 1, gridy, top, left - 150, bottom, right, modifyArea, 1, 2);

        return textPane;
    }

    /**
     * Tworzenie listy rozwijanej
     * @param text Tekst pojawiający się obok listy rozwijanej
     * @param names Lista obiektów w liście rozwijanej
     * @param panel Panel do którego zostanie dodane pole tekstowe i tekst
     * @param layout Layout
     * @param gridx Pozycja x w layoucie
     * @param gridy Pozycja y w layoucie
     * @param top Odsunięcie od krawędzi górnej
     * @param left Odsunięcie od krawędzi lewej
     * @param bottom Odsunięcie od krawędzi dolnej
     * @param right Odsunięcie od krawędzi prawej
     * @return
     */
    protected static JComboBox createComboBox(String text, String[] names, JPanel panel, GridBagConstraints layout, int gridx, int gridy, int top, int left, int bottom, int right) {
        JLabel label = new JLabel(text);
        JComboBox comboBox = new JComboBox(names);
        comboBox.setPreferredSize(new Dimension(170, 20));
        Projekt.setLayoutAdd(panel, layout, gridx, gridy, top, left - 100, bottom, right, label, 1);
        Projekt.setLayoutAdd(panel, layout, gridx + 1, gridy, top, left - 400, bottom, right, comboBox, 1);
        return comboBox;
    }

    /**
     * Tworzenie panelu do dodawania samochodu
     * @param panel Panel gdzie zostaną dodane komponenty
     * @param row_id ID samochodu
     */
    private void createAddCarPanel(JComponent panel, int row_id) {
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(1180, 680));
        mainPanel.setMaximumSize(new Dimension(1180, 600));
        mainPanel.setBounds(0, 0, 1200, 580);
        JScrollPane modifyArea = Projekt.createTextArea(mainPanel, 1180, 560);
        modifyArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints layout = new GridBagConstraints();
        Car Samochod = new Car();
        Car.createComponents(Samochod, mainPanel, layout);
        JButton accept = new JButton("Akceptuj");
        Projekt.setLayoutAdd(mainPanel, layout, 2, 17, -20, -150, 0, 0, accept, 1);
        if (row_id == -1) {
            accept.setActionCommand("acceptAddCar");
            HandlerClass handlerAdd = new HandlerClass(Samochod);
            accept.addActionListener(handlerAdd);
        } else {
            accept.setActionCommand("acceptAddCar");
            HandlerClass handlerAdd = new HandlerClass(Samochod, row_id);
            accept.addActionListener(handlerAdd);
        }
        panel.add(modifyArea);
        panel.updateUI();
    }

    /**
     * Metoda dla akcji, wywołuje się podczas akcji, np. kliknięcia przycisku
     * @param event Pararetr funkcji handlerClass
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Delete")) {
            int x = nTable.table.getSelectedRow();
            int y = nTable.table.getSelectedColumn();
            if (y == 0) {
                Object tmp = nTable.table.getValueAt(x, y);
                int value = tmp.hashCode() - 48;
                String titleBar = "Co tam";
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
            if (index >= 0) {
                Projekt.tabbedPanel.removeTabAt(index);
                Shelf.i--;
            }
        } else if (event.getActionCommand().equals("Workers")) {
            String name = "Pracownicy";
            if (Projekt.tabbedPanel.indexOfTab(name) == -1) {
                try {
                    JComponent workersPanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Lista wszystkich pracowników", "ikona1.gif");
                    Shelf.afterCreate(name);
                    JTable table = Projekt.createTable("PRACOWNICY", workersPanel);
                    table.setName("PRACOWNICY");
                    MouseHandler handler = new MouseHandler(table);
                    table.addMouseListener(handler);
                } catch (Exception e) {
                    System.out.println("Błąd w fokusowaniu...");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Panel z pracownikami został już otwarty!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (event.getActionCommand().equals("addCar")) {
            String name = "Dodawanie auta";
            if (Projekt.tabbedPanel.indexOfTab(name) == -1) {

                try {
                    JComponent addCarPanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Lista wszystkich pracowników", "ikona1.gif");
                    Shelf.afterCreate(name);
                    createAddCarPanel(addCarPanel, row_id);
                } catch (Exception e) {
                    System.out.println("Błąd w fokusowaniu...");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nie zakończyłeś dodawania innego samochodu!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (event.getActionCommand().equals("acceptAddCar")) {
            if (row_id == -1) {
                String name = "Dodatkowe parametry auta";
                JComponent pricePanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Lista aut na stanie...", "ikona1.gif");
                Shelf.afterCreate(name);
                JPanel winPanel = new JPanel();
                winPanel.setPreferredSize(new Dimension(1180, 600));
                pricePanel.add(winPanel);
                Car.createPriceWindow(winPanel, row_id, Auto);
            } else {
                Car.addCarToBase(rowAdd, Auto);
            }
        } else if (event.getActionCommand().equals("condition")) {
            String name = "Auta na stanie";
            if (Projekt.tabbedPanel.indexOfTab(name) == -1) {
                try {
                    JComponent conditionPanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Lista aut na stanie...", "ikona1.gif");
                    Shelf.afterCreate(name);
                    JTable table = Projekt.createTable("NA_STANIE", conditionPanel);
                    MouseHandler handler = new MouseHandler(table);
                    table.addMouseListener(handler);
                } catch (Exception e) {
                    System.out.println("Błąd w fokusowaniu...");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Panel z pracownikami został już otwarty!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (event.getActionCommand().equals("cancelModify")) {
            Shelf.deleteTab("Modyfikacja auta");
            int index = Projekt.tabbedPanel.indexOfTab("Auta na stanie");
            Projekt.tabbedPanel.setSelectedIndex(index);
        } else if (event.getActionCommand().equals("addCarToBase")) {
            Car.addCarToBase(rowAdd, AutoAdd);
        } else if (event.getActionCommand().equals("sellCar")) {
            Car.sellCar(stateRowID, rowAdd);
        } else if (event.getActionCommand().equals("acceptSell")) {
            Car.acceptSell(stateRowID, rowAdd, sellData);
        } else if (event.getActionCommand().equals("lastSelled")) {
            String name = "Sprzedane auta";
            if (Projekt.tabbedPanel.indexOfTab(name) == -1) {
                try {
                    JComponent conditionPanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Lista aut sprzedanych...", "ikona1.gif");
                    Shelf.afterCreate(name);
                    JTable table = Projekt.createTable("SPRZEDANE", conditionPanel);
                    MouseHandler handler = new MouseHandler(table);
                    table.addMouseListener(handler);
                } catch (Exception e) {
                    System.out.println("Błąd w fokusowaniu...");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Panel z pracownikami został już otwarty!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (event.getActionCommand().equals("changeSalary")) {
            String name = "Nowe wynagrodzenie";
            JComponent pricePanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Nowe wynagrodzenie dla pracownika...", "ikona1.gif");
            Shelf.afterCreate(name);
            JPanel winPanel = new JPanel();
            winPanel.setPreferredSize(new Dimension(1180, 600));
            pricePanel.add(winPanel);
            Person.createSalaryWindow(winPanel, rowAdd);
            pricePanel.setVisible(true);
        } else if (event.getActionCommand().equals("acceptSalary")) {

            int data = Integer.parseInt(salary.price.getText());
            Person.changeSalary(data, rowAdd);
            JOptionPane.showMessageDialog(null, "Zmieniono wynagrodzenie!", "Powodzenie!", JOptionPane.INFORMATION_MESSAGE);
            String name = "Nowe wynagrodzenie";
            int index;
            index = Projekt.tabbedPanel.indexOfTab(name);
            if (index >= 0) {
                Projekt.tabbedPanel.removeTabAt(index);
                Shelf.i--;
            }

            Person.backToStart();
        } else if (event.getActionCommand().equals("backToStart")) {

            Person.backToStart();
        } else if (event.getActionCommand().equals("releaseWorker")) {

            Person.release(rowAdd);
            JOptionPane.showMessageDialog(null, "Zwolniono pracownika!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
            Person.backToStart();
        } else if (event.getActionCommand().equals("Clients")) {
            String name = "Klienci";
            if (Projekt.tabbedPanel.indexOfTab(name) == -1) {

                try {
                    JComponent conditionPanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Lista aut sprzedanych...", "ikona1.gif");
                    Shelf.afterCreate(name);
                    JTable table = Projekt.createTable("KLIENCI", conditionPanel);
                    MouseHandler handler = new MouseHandler(table);
                    table.addMouseListener(handler);


                } catch (Exception e) {
                    System.out.println("Błąd w fokusowaniu...");
                }

            }
        }
    }
}


