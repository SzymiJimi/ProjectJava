/**
 * Created by Szymon on 2017-05-28.
 */
package com.SzymonJarzabek;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import java.awt.Font;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Person {


    /*
    public final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty email;

    public Person(String fName, String lName, String email) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.email = new SimpleStringProperty(email);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String fName) {
        lastName.set(fName);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String fName) {
        email.set(fName);
    }

*/
    public static int getIntData(String tableName, String colName, String keyColumn, int row) {
        int result = 0;
        try {
            ResultSet queryRes = Table.statement.executeQuery("Select " + colName + " from " + tableName + " where " + keyColumn + "=" + row);
            while (queryRes.next()) {
                result = queryRes.getInt(colName);
            }
        } catch (Exception e) {
            System.out.println("Błąd w pobieraniu ID ...");
        }

        return result;
    }

    private static String getDataFromDB(String table, String keyColumn, String column, int row)
    {
        String text="";
        try {
            ResultSet queryRes = Table.statement.executeQuery("Select " + column + " from " + table + " where " + keyColumn + "=" + row);
            while (queryRes.next()) {
                text = queryRes.getString(column);
            }
        } catch (Exception e) {
            System.out.println("Błąd w pobieraniu tekstu w pracownikach ...");
        }
        return text;
    }

    protected static void showInfo(int osobaID, int stanowiskoID, int adresID, JPanel panel, int row) {

        panel.setPreferredSize(new Dimension(1180, 600));
        panel.setBackground(Color.cyan);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints layout= new GridBagConstraints();
        JButton release= new JButton("Zwolnij");
        release.setPreferredSize(new Dimension(200,25));
        JButton back=new JButton("Powrót");
        back.setPreferredSize(new Dimension(200,25));
        JButton salary=new JButton("Zmień wynagrodzenie");
        salary.setPreferredSize(new Dimension(200,25));

        Equipment data[] = new Equipment[11];
        String text = getDataFromDB("OSOBY", "OSOBA_ID", "IMIE", osobaID);
        data[0] = new Equipment("Imie: ", text);
        text = getDataFromDB("OSOBY", "OSOBA_ID", "NAZWISKO", osobaID);
        data[1] = new Equipment("Nazwisko: ", text);
        text = getDataFromDB("OSOBY", "OSOBA_ID", "NIP", osobaID);
        data[2] = new Equipment("Nip: ", text);
        text = getDataFromDB("OSOBY", "OSOBA_ID", "PESEL", osobaID);
        data[3] = new Equipment("Pesel: ", text);
        text = getDataFromDB("STANOWISKA", "STANOWISKO_ID", "NAZWA", stanowiskoID);
        data[4] = new Equipment("Stanowisko: ", text);
        text = getDataFromDB("PRACOWNICY", "PRACOWNIK_ID", "WYNAGRODZENIE", row);
        data[5] = new Equipment("Wynagrodzenie: ", text);
        text = getDataFromDB("PRACOWNICY", "PRACOWNIK_ID", "DATA_ZATRUDNIENIA", row);
        data[6] = new Equipment("Data zatrudnienia: ", text);
        text = getDataFromDB("ADRESY", "ADRES_ID", "MIEJSCOWOSC", adresID);
        data[7] = new Equipment("Miejscowość: ", text);
        text = getDataFromDB("ADRESY", "ADRES_ID", "NR_DOMU", adresID);
        data[8] = new Equipment("Nr domu: ", text);
        text = getDataFromDB("ADRESY", "ADRES_ID", "KOD_POCZTOWY", adresID);
        data[9] = new Equipment("Kod pocztowy: ", text);
        text = getDataFromDB("ADRESY", "ADRES_ID", "ULICA", adresID);
        data[10] = new Equipment("Ulica: ", text);

        JLabel labels[]=new JLabel[22];

        int it=0;
        for(int i=0;i<11;i++)
        {
            labels[i]=new JLabel(data[i].name);
            Font font=new Font("Meiryo UI", 1,16);
            labels[i].setFont(font);
        }

        for(int i=11;i<22;i++)
        {
            labels[i]=new JLabel(data[it].data);
            Font font=new Font("Gill Sans MT", 1,16);
            labels[i].setFont(font);
            it++;
        }
        it=0;
        for(int i=0;i<11;i++) {

            Projekt.setLayoutAdd(panel, layout, 0, it, 0, 0, 0, 0, labels[i], 1);
            it++;
        }
        it=0;
        for(int i=11;i<22;i++) {

            Projekt.setLayoutAdd(panel, layout, 1, it, 0, -200, 0, 0, labels[i], 1);
            it++;
        }

        salary.setActionCommand("changeSalary");
        HandlerClass salaryHandler=new HandlerClass(row);
        salary.addActionListener(salaryHandler);

        back.setActionCommand("backToStart");
        HandlerClass backHandler=new HandlerClass(back);
        back.addActionListener(backHandler);

        release.setActionCommand("releaseWorker");
        HandlerClass releaseHandler=new HandlerClass(row);
        release.addActionListener(releaseHandler);

        it=0;
        Projekt.setLayoutAdd(panel, layout, 2, it, 0, 0, 0, 0, salary, 1);
        it++;
        Projekt.setLayoutAdd(panel, layout, 2, it, 0, 0, 0, 0, back, 1);
        it++;
        Projekt.setLayoutAdd(panel, layout, 2, it, 0, 0, 0, 0, release, 1);


    }

    public static void createSalaryWindow(JPanel panel, int row_id) {

        Equipment salary=new Equipment("Zarobek",false);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints layout = new GridBagConstraints();
        salary.price = HandlerClass.createTextField("Nowe zarobki: ", 20, 50, 30, panel, Color.cyan, layout, 0, 0, 0, 0, 0, 0);

        JButton acceptAdd = new JButton("Akceptuj");
        Projekt.setLayoutAdd(panel, layout, 0, 1, 0, 0, 0, 0, acceptAdd, 1);

        acceptAdd.setActionCommand("acceptSalary");
        HandlerClass acceptHandler = new HandlerClass(row_id, salary);
        acceptAdd.addActionListener(acceptHandler);

    }

    public static void changeSalary(int salary,int  row_id){

        try {
            ResultSet queryRes = Table.statement.executeQuery("UPDATE PRACOWNICY set WYNAGRODZENIE="+salary+"WHERE PRACOWNIK_ID="+ row_id);

        } catch (Exception e) {
            System.out.println("Błąd w pobieraniu tekstu w pracownikach ...");
        }
    }

    public static void release(int row)
    {
        try {
            ResultSet queryRes = Table.statement.executeQuery("UPDATE PRACOWNICY set ZATRUDNIONY=0 WHERE PRACOWNIK_ID="+ row);

        } catch (Exception e) {
            System.out.println("Błąd w zwalnianiu pracownika ...");
        }
    }

    public static void backToStart()
    {
        String name="Informacje o pracowniku";
        int index;
        index = Projekt.tabbedPanel.indexOfTab(name);
        if (index >= 0) {
            Projekt.tabbedPanel.removeTabAt(index);
            Shelf.i--;
        }
        index = Projekt.tabbedPanel.indexOfTab("Pracownicy");
        Projekt.tabbedPanel.setSelectedIndex(index);
    }


    protected static void showWorker(int row) {
        int osobaID = getIntData("PRACOWNICY", "OSOBA_ID", "PRACOWNIK_ID", row);
        int stanowiskoID = getIntData("PRACOWNICY", "STANOWISKO_ID", "PRACOWNIK_ID", row);
        int adresID = getIntData("PRACOWNICY", "ADRES_ID", "PRACOWNIK_ID", row);

        String name = "Informacje o pracowniku";
        JComponent workInfoPanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Modyfikacja dodanego auta", "ikona1.gif");
        Projekt.tabbedPanel.updateUI();
        Projekt.addCloseButtonToPane(name);
        int index = Projekt.tabbedPanel.indexOfTab(name);
        Projekt.tabbedPanel.setSelectedIndex(index);
        //createAddCarPanel(modifyPanel);
        JPanel panel = new JPanel();
        workInfoPanel.add(panel);

        showInfo(osobaID, stanowiskoID, adresID, panel, row);

    }

}