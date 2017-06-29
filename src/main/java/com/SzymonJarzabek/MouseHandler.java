package com.SzymonJarzabek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.JPanel;

import static jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType.NEWLINE;

/**
 * Created by Szymon on 2017-06-24.
 */
public class MouseHandler implements MouseListener {

    JTextArea textArea;
    JTable table;
    String sqlColNames = "SELECT column_name FROM USER_TAB_COLUMNS WHERE table_name = '";

    /**
     * Pobiera nazwy kolumn
     * @param tableName nazwa tabeli
     * @param colNames nazwy kolumn
     */
    protected void getColNames(String tableName, String colNames[]) {
        try {
            sqlColNames = sqlColNames + tableName + "'";
            ResultSet rs = Table.statement.executeQuery(sqlColNames);
            sqlColNames = "SELECT column_name FROM USER_TAB_COLUMNS WHERE table_name = '";
            int i = 0;
            int x = colNames.length;
            while (rs.next()) {
                colNames[i] = rs.getString("column_name");
                i++;
            }
        } catch (Exception e) {
            System.out.print("Błąd w odczytywaniu nazw kolumn! \n");
        }
    }

    /**
     * Pobiera dane z tabeli opis
     * @param colNames Nazwy kolumn
     * @param descrips Dane samochodu w obiekcie klasy
     * @param row ID auta
     */
    public void getDataDescr(String colNames[], Equipment descrips[], int row) {
        String sqlQuery = "Select ";
        String result;
        int k = 0;
        int length = colNames.length;
        try {
            for (int i = 1; i < length; i++) {
                sqlQuery = sqlQuery + colNames[i] + " from OPIS WHERE opis_id=" + row;
                ResultSet rs = Table.statement.executeQuery(sqlQuery);
                while (rs.next()) {
                    result = rs.getString(colNames[i]);
                    if (result == "1") {
                        descrips[k].data = "Tak";
                    } else if (result == "0") {
                        descrips[k].data = "Nie";
                    } else {
                        descrips[k].data = result;
                    }
                }
                k++;
                sqlQuery = "Select ";
            }
        } catch (Exception e) {
            System.out.println("Błąd w odczytywaniu opisu...");
        }
    }

    /**
     * Pobiera dane z wyposazenia
     * @param colNames nazwy kolumn
     * @param equips Dane wyposażenia w obiekcie klasy
     * @param row ID auta
     */
    public void getDataEq(String colNames[], Equipment equips[], int row) {
        String sqlQuery1 = "Select ";
        int result, k = 0;
        int length = colNames.length;
        try {
            for (int i = 2; i < length; i++) {
                sqlQuery1 = sqlQuery1 + colNames[i] + " from WYPOSAZENIE WHERE wyposazenie_id=" + row;
                ResultSet rs = Table.statement.executeQuery(sqlQuery1);
                while (rs.next()) {
                    result = rs.getInt(colNames[i]);
                    if (result == 1) {
                        equips[k].check = true;
                    } else {
                        equips[k].check = false;
                    }
                    k++;
                }
                sqlQuery1 = "Select ";
            }
        } catch (Exception e) {
            System.out.println("Błąd w odczytywaniu wyposazenia...");
        }
    }

    /**
     * Pobiera informacje z tabeli samochody
     * @param colNames Tablica z nazwami kolumn
     * @param cars Informacje o samochodzie w obiekcie
     * @param row ID samochodu
     */
    public void getDataCar(String colNames[], Equipment cars[], int row) {

        String sqlQuery = "Select ";
        String result;
        int workID = 0;
        int personID = 0;
        int k = 0;
        int length = colNames.length;
        length -= 3;
        try {
            for (int i = 1; i < length; i++) {
                sqlQuery = sqlQuery + colNames[i] + " from SAMOCHODY WHERE samochod_id=" + row;
                ResultSet rs = Table.statement.executeQuery(sqlQuery);
                while (rs.next()) {
                    result = rs.getString(colNames[i]);
                    cars[k].data = result;
                }
                k++;
                sqlQuery = "Select ";
            }
            sqlQuery = sqlQuery + colNames[11] + " from SAMOCHODY WHERE samochod_id=" + row;
            System.out.println("Zapytanie do pobierania ID pracownika: " + sqlQuery);
            ResultSet rs = Table.statement.executeQuery(sqlQuery);
            while (rs.next()) {
                workID = rs.getInt(colNames[11]);
                System.out.println("Wynik work ID: " + workID);
            }

        } catch (Exception e) {
            System.out.println("Błąd w odczytywaniu samochodu...");
        }

        String getPersonSQL = "Select OSOBA_ID from PRACOWNICY where pracownik_id=" + workID;
        System.out.println("zapytanie do pobrania OSOBY ID: " + getPersonSQL);
        try {
            ResultSet rt = Table.statement.executeQuery(getPersonSQL);

            while (rt.next()) {
                personID = rt.getInt("OSOBA_ID");
                System.out.println("Wynik Osoba ID: " + personID);
            }
        } catch (Exception e) {
            System.out.println("Błąd w odczytywaniu workID...");
        }

        String nameQuery = "Select IMIE from OSOBY where osoba_id=" + personID;
        String surnameQuery = "Select NAZWISKO from OSOBY where osoba_id=" + personID;
        System.out.print("Zapytanie imie: " + nameQuery + " nazwisko: " + surnameQuery + "\n");

        try {
            ResultSet res = Table.statement.executeQuery(nameQuery);

            while (res.next()) {
                cars[8].data = res.getString("IMIE");
            }
        } catch (Exception e) {
            System.out.print("Błąd w pobieraniu imienia...\n");
        }
        try {
            ResultSet rs = Table.statement.executeQuery(surnameQuery);

            while (rs.next()) {
                cars[9].data = rs.getString("NAZWISKO");
            }
        } catch (Exception e) {
            System.out.print("Błąd w pobieraniu nazwiska..\n");
        }

        System.out.println(cars[8].name + cars[8].data);
        System.out.println(cars[9].name + cars[9].data);

    }

    /**
     * Metoda pobierająca wyposarzenie danego samochodu
     * @param equips Tablica obiektów gdzie zostaną zapisane dane
     * @param row Id auta
     */
    public void getWyp(Equipment equips[], int row) {

        equips[0] = new Equipment("Wspomaganie ABS: ", false);
        equips[1] = new Equipment("Kontrola toru jazdy ESP: ", false);
        equips[2] = new Equipment("Wspomaganie kierownicy: ", false);
        equips[3] = new Equipment("Bluetooth: ", false);
        equips[4] = new Equipment("Czujnik zmierzchu: ", false);
        equips[5] = new Equipment("Czujnik parkowania: ", false);
        equips[6] = new Equipment("Czujnik deszczu: ", false);
        equips[7] = new Equipment("Elektryczne lusterka: ", false);
        equips[8] = new Equipment("Elektryczne szyby przód: ", false);
        equips[9] = new Equipment("Elektryczne szyby tył: ", false);
        equips[10] = new Equipment("Podgrzewane lusterka boczne: ", false);
        equips[11] = new Equipment("Podgrzewane siedzenia przód: ", false);
        equips[12] = new Equipment("Podgrzewane siedzenia tył: ", false);
        equips[13] = new Equipment("Podgrzewana kierownica: ", false);
        equips[14] = new Equipment("Immobilizer: ", false);
        equips[15] = new Equipment("Alarm: ", false);
        equips[16] = new Equipment("Centralny zamek: ", false);
        equips[17] = new Equipment("Pilot: ", false);
        equips[18] = new Equipment("Radio MP3: ", false);
        equips[19] = new Equipment("Gniazdo AUX: ", false);
        equips[20] = new Equipment("Radio fabryczne: ", false);
        equips[21] = new Equipment("Odtwarzacz CD: ", false);
        equips[22] = new Equipment("Komputer pokładowy: ", false);
        equips[23] = new Equipment("Gniazdo 12V: ", false);
        equips[24] = new Equipment("Tempomat: ", false);
        equips[25] = new Equipment("Aktywny tempomat: ", false);
        equips[26] = new Equipment("Line asist: ", false);
        equips[27] = new Equipment("Kurtyny powietrzne: ", false);
        equips[28] = new Equipment("ISOFIX: ", false);
        equips[29] = new Equipment("Przyciemniane szyby: ", false);
        equips[30] = new Equipment("Alufelgi: ", false);
        equips[31] = new Equipment("Relingi dachowe: ", false);
        equips[32] = new Equipment("Światła LED: ", false);
        equips[33] = new Equipment("Światła Xenonowe: ", false);
        equips[34] = new Equipment("Światła do jazdy dziennej: ", false);

        String colNames[] = new String[37];
        try {
            getColNames("WYPOSAZENIE", colNames);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Błąd w odczytywaniu nazw kolumn w tabeli WYPOSAZENIE!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
        }
        getDataEq(colNames, equips, row);
    }

    /**
     * Metoda pobierająca opis auta
     * @param descrips dane opisu w obiekcie
     * @param row ID auta
     */
    public void getOpis(Equipment descrips[], int row) {

        descrips[0] = new Equipment("Skrzynia biegów: ", "nic");
        descrips[1] = new Equipment("Stan pojazdu: ", "nic");
        descrips[2] = new Equipment("Nadwozie: ", "nic");
        descrips[3] = new Equipment("Kraj pochodzenia: ", "nic");
        descrips[4] = new Equipment("Serwisowany: ", "nic");
        descrips[5] = new Equipment("Dodatkowy opis: ", "nic");

        String colNames[] = new String[7];
        try {
            getColNames("OPIS", colNames);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Błąd w odczytywaniu nazw kolumn w tabeli WYPOSAZENIE!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
        }
        getDataDescr(colNames, descrips, row);

    }

    public void getCar(Equipment cars[], int row) {
        cars[0] = new Equipment("Marka: ", "nic");
        cars[1] = new Equipment("Model: ", "nic");
        cars[2] = new Equipment("Rok produkcji: ", "nic");
        cars[3] = new Equipment("VIN: ", "nic");
        cars[4] = new Equipment("Przebieg: ", "nic");
        cars[5] = new Equipment("Moc: ", "nic");
        cars[6] = new Equipment("Typ silnika: ", "nic");
        cars[7] = new Equipment("Pojemność: ", "nic");
        cars[8] = new Equipment("Imie: ", "nic");
        cars[9] = new Equipment("Nazwisko: ", "nic");

        String colNames[] = new String[12];
        try {
            getColNames("SAMOCHODY", colNames);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Błąd w odczytywaniu nazw kolumn w tabeli WYPOSAZENIE!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
        }

        getDataCar(colNames, cars, row);

    }

    /**
     * Metoda wywoływana przy wyświetlaniu samochodu ona pobiera wszystkie potrzebne informacje do wyświetlenia
     * @param rowek
     */
    public void showCar(int rowek) {
        int row = 0;
        try {
            ResultSet result = Table.statement.executeQuery("Select SAMOCHOD_ID from NA_STANIE where ID_STANU=" + rowek);
            while (result.next()) {
                row = result.getInt("SAMOCHOD_ID");
            }
        } catch (Exception e) {
            System.out.println("Błąd w pobieraniu ID samochodu...");
        }
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(1180, 600));
        mainPanel.setMaximumSize(new Dimension(1180, 600));
        mainPanel.setBounds(0, 0, 1180, 600);
        JScrollPane modifyArea = Projekt.createTextArea(mainPanel, 1180, 560);
        modifyArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.setLayout(new GridBagLayout());
        Equipment equips[] = new Equipment[35];
        Equipment descrips[] = new Equipment[6];
        Equipment cars[] = new Equipment[10];
        getWyp(equips, row);
        getOpis(descrips, row);
        getCar(cars, row);
        createPanel(equips, descrips, cars, row, rowek);
    }

    /**
     * Metoda tworząca tekst label
     * @param equipment obiekt w którym jest zapisany tekst do wyświetlenia
     * @param panel Panel w którym zostanie tekst wyświetlony
     * @param layout Layout
     * @param gridx pozycja x na ekranie
     * @param gridy pozycja y na ekranie w layocie
     */
    public void createLabel(Equipment equipment, JComponent panel, GridBagConstraints layout, int gridx, int gridy) {
        JLabel label = new JLabel(equipment.name + equipment.data + "\n");
        Projekt.setLayoutAdd(panel, layout, gridx, gridy, 0, 0, 0, 0, label, 1);
    }

    /**
     * Tworzenie tekstu dla innych kolumn
     * @param equipment obiekt w którym jest zapisany tekst do wyświetlenia
     * @param panel Panel w którym zostanie tekst wyświetlony
     * @param layout Layout
     * @param gridx pozycja x na ekranie
     * @param gridy pozycja y na ekranie w layocie
     */
    public void createLabelCB(Equipment equipment, JComponent panel, GridBagConstraints layout, int gridx, int gridy) {
        String data;
        if (equipment.check) {
            data = "Tak";
        } else {
            data = "Brak";
        }
        JLabel label = new JLabel(equipment.name + data + "\n");
        Projekt.setLayoutAdd(panel, layout, gridx, gridy, 0, 0, 0, 0, label, 1);
    }

    /**
     * Metoda tworząca ekran który wyświetla informacje o samochodzie
     * @param equips dane o wyposazeniu samochodu z tabeli wyposazenie
     * @param descrips dane o opisie samochodu z tabeli opis
     * @param cars dane o samochodzie z tabeli samochody
     * @param panel panel do którego zostaną dodane wszystkie komponenty
     * @param rowID ID samochodu
     * @param stateID ID stanu
     */
    public void showInfo(Equipment equips[], Equipment descrips[], Equipment cars[], JComponent panel, int rowID, int stateID) {
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(1180, 600));
        mainPanel.setMaximumSize(new Dimension(1180, 600));
        mainPanel.setBounds(0, 0, 1180, 600);
        JScrollPane editorScrollPane = Projekt.createTextArea(mainPanel, 1180, 560);
        editorScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints layout = new GridBagConstraints();
        int counterX = 0;
        int counterY = 0;

        JButton modify = new JButton("Modyfikuj");
        JButton cancel = new JButton("Powrót");
        JButton sell = new JButton("Sprzedaj");

        for (int k = 0; k < 8; k++) {
            createLabel(cars[k], mainPanel, layout, counterX, counterY);
            counterY += 1;

        }
        JLabel label = new JLabel("___________________________________");
        Projekt.setLayoutAdd(mainPanel, layout, counterX, counterY, 0, 0, 0, 0, label, 1);
        counterY += 1;

        for (int j = 0; j < 6; j++) {
            createLabel(descrips[j], mainPanel, layout, counterX, counterY);
            counterY += 1;

        }
        counterY = 0;
        counterX += 1;

        for (int i = 0; i < 35; i++) {
            createLabelCB(equips[i], mainPanel, layout, counterX, counterY);
            counterY += 1;
            if (counterY == 17) {
                counterY = 0;
                counterX += 1;
            }
        }

        JLabel label1 = new JLabel("___________________________________");
        Projekt.setLayoutAdd(mainPanel, layout, counterX, counterY, 0, 0, 0, 0, label1, 1);
        counterY += 1;
        JLabel labelInf = new JLabel("Dane osoby dodającej samochód: ");
        Projekt.setLayoutAdd(mainPanel, layout, counterX, counterY, 0, 0, 0, 0, labelInf, 1);
        counterY += 1;
        createLabel(cars[8], mainPanel, layout, counterX, counterY);
        counterY += 1;
        createLabel(cars[9], mainPanel, layout, counterX, counterY);
        counterY += 1;

        Projekt.setLayoutAdd(mainPanel, layout, counterX, counterY, 0, 0, 0, 0, modify, 1);
        counterY += 1;
        Projekt.setLayoutAdd(mainPanel, layout, counterX, counterY, 0, 0, 0, 0, cancel, 1);
        counterY += 1;
        Projekt.setLayoutAdd(mainPanel, layout, counterX, counterY, 0, 0, 0, 0, sell, 1);

        modify.setActionCommand("addCar");
        HandlerClass handlerCondition = new HandlerClass(modify, rowID);
        modify.addActionListener(handlerCondition);

        cancel.setActionCommand("cancelModify");
        HandlerClass handlerCancel = new HandlerClass(cancel);
        cancel.addActionListener(handlerCancel);

        System.out.println("ROW ID w mouse handler : " + rowID);
        sell.setActionCommand("sellCar");
        HandlerClass sellHandler = new HandlerClass(rowID, stateID);
        sell.addActionListener(sellHandler);

        panel.add(editorScrollPane);
        panel.updateUI();
    }

    /**
     * Metoda wywołująca metode dodającą komponenty z informacjami o aucie, tworzy panel do którego będzie dodane wszystko
     * @param equips dane o wyposazeniu samochodu z tabeli wyposazenie
     * @param descrips dane o opisie samochodu z tabeli opis
     * @param cars dane o samochodzie z tabeli samochody
     * @param rowID ID samochodu
     * @param stateID ID stanu
     */
    public void createPanel(Equipment equips[], Equipment descrips[], Equipment cars[], int rowID, int stateID) {
        int index;
        String name = "Modyfikacja auta";
        if (Projekt.tabbedPanel.indexOfTab(name) == -1) {
            try {
                JComponent modifyPanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Modyfikacja dodanego auta", "ikona1.gif");
                Projekt.tabbedPanel.updateUI();
                Projekt.addCloseButtonToPane(name);
                index = Projekt.tabbedPanel.indexOfTab(name);
                Projekt.tabbedPanel.setSelectedIndex(index);
                JPanel panel = new JPanel();
                showInfo(equips, descrips, cars, modifyPanel, rowID, stateID);
            } catch (Exception a) {
                System.out.println("Błąd w fokusowaniu...");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nie zakończyłeś dodawania innego samochodu!", "Błąd!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public MouseHandler(JTable tables) {
        textArea = new JTextArea();
        textArea.setEditable(false);
        this.table = tables;
        tables = this.table;
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
    }

    public void mouseReleased(MouseEvent e) {
        eventOutput("Mouse released (# of clicks: "
                + e.getClickCount() + ")", e);
    }

    public void mouseEntered(MouseEvent e) {
        eventOutput("Mouse entered", e);
    }

    public void mouseExited(MouseEvent e) {
        eventOutput("Mouse exited", e);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();
            int rowek, column;
            if (this.table.getName() == "PRACOWNICY") {
                rowek = this.table.getSelectedRow();
                Object value = this.table.getValueAt(rowek, 5);
                String readed = (String) value;
                int row = Integer.parseInt(readed);
                Person.showWorker(row);
            } else {
                rowek = this.table.getSelectedRow();
                column = this.table.getSelectedColumn();
                Object value = this.table.getValueAt(rowek, 9);
                String readed = (String) value;
                int row = Integer.parseInt(readed);
                System.out.println("Zaznaczono: " + row + " wiersz i " + column + " kolumne!");
                showCar(row);
            }
        }
    }
}
