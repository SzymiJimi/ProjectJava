package com.SzymonJarzabek;

import javax.swing.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Szymon on 2017-05-04.
 */
public class Table {
    static Statement statement;
    String colNames[], sqlQueryAllData;
    String rowCount = "SELECT COUNT(*) AS rowcount FROM ";
    String colCount = "SELECT COUNT(*) FROM all_tab_cols WHERE table_name = '";
    String sqlColNames = "SELECT column_name FROM USER_TAB_COLUMNS WHERE table_name = '";
    String sqlDeleteRow = "DELETE FROM ";
    Object[][] dataX;
    int qRows, qColumns;
    int tableType = -1;
    JTable table;
    String tableName;

    // protected TableView<Person> table = new TableView();

    //1=ADRESY
    //2-OSOBY
    //3-STANOWISKA
    //4-KLIENCI
    //5-WYPOSARZENIE
    //6-NA_STANIE
    //7-PRACOWNICY
    //8-OPIS
    //9-SPRZEDANE
    //10-SAMOCHODY


    public Table(String name) throws Exception {

        tableName = name;
        rowCount = rowCount + name;
        colCount = colCount + name + "'";
        sqlColNames = sqlColNames + name + "'";
        getCount(name);

        if(name=="NA_STANIE")
        {
          colNamesStan();
          setSqlQuery();
          qColumns=10;

        }else if(name=="PRACOWNICY"){
            colNamesWork();
            setSqlWork();
            qColumns=6;
        } else if (name=="KLIENCI"){
            colNamesCli();
            setSqlCli();
            qColumns=9;

        }else {
            getColumns();
            getColNames();
            createSQL(name);
        }
        getOsoby();

    }

    public Table(Table tabela) {
        tableName = tabela.tableName;
        rowCount = tabela.rowCount;
        colCount = colCount;
        sqlColNames = sqlColNames;
        qRows = tabela.qRows;
        qColumns = tabela.qColumns;
        colNames = tabela.colNames;
        sqlQueryAllData = tabela.sqlQueryAllData;
        table = tabela.table;
    }

    private void colNamesStan()
    {
        String names[]={"MARKA", "MODEL_AUTA", "ROK_PRODUKCJI","PRZEBIEG","MOC","TYP_SILNIKA", "WARTOSC", "NR_GARAZU", "POZYCJA", "ID_STANU"};
        this.colNames=names;
    }

    private void colNamesWork()
    {
        String names[]={"IMIE", "NAZWISKO", "DATA_ZATRUDNIENIA","NIP","WYNAGRODZENIE", "PRACOWNIK_ID"};
        this.colNames=names;
    }

    private void colNamesCli()
    {
        String names[]={"IMIE", "NAZWISKO","NIP","PLEC","MIEJSCOWOSC","ULICA","NR_DOMU","NR_MIESZKANIA", "DATA_P_ZAKUP"};
        this.colNames=names;
    }
    private void setSqlQuery()
    {
        String query="Select SAMOCHODY.MARKA, SAMOCHODY.MODEL_AUTA, SAMOCHODY.ROK_PRODUKCJI, SAMOCHODY.PRZEBIEG, SAMOCHODY.MOC, SAMOCHODY.TYP_SILNIKA, NA_STANIE.WARTOSC, NA_STANIE.NR_GARAZU, NA_STANIE.POZYCJA, NA_STANIE.ID_STANU FROM NA_STANIE, SAMOCHODY WHERE NA_STANIE.SAMOCHOD_ID=SAMOCHODY.SAMOCHOD_ID ORDER BY SAMOCHODY.MARKA ASC, SAMOCHODY.MODEL_AUTA ASC";
        this.sqlQueryAllData=query;
    }

    private void setSqlWork()
    {
        String query="Select OSOBY.IMIE, OSOBY.NAZWISKO, PRACOWNICY.DATA_ZATRUDNIENIA, OSOBY.NIP, PRACOWNICY.WYNAGRODZENIE, PRACOWNICY.PRACOWNIK_ID FROM PRACOWNICY, OSOBY WHERE PRACOWNICY.OSOBA_ID=OSOBY.OSOBA_ID AND PRACOWNICY.ZATRUDNIONY=1";
        this.sqlQueryAllData=query;
    }

    private void setSqlCli()
    {
        String query="Select OSOBY.IMIE, OSOBY.NAZWISKO, OSOBY.NIP, KLIENCI.PLEC, ADRESY.MIEJSCOWOSC,  ADRESY.ULICA, ADRESY.NR_DOMU, ADRESY.NR_MIESZKANIA, KLIENCI.DATA_P_ZAKUP FROM KLIENCI,ADRESY, OSOBY WHERE KLIENCI.OSOBA_ID=OSOBY.OSOBA_ID AND KLIENCI.ADRES_ID=ADRESY.ADRES_ID";
        this.sqlQueryAllData=query;
    }

    private void setTableType(String name) {
        switch (name) {
            case "ADRESY":
                this.tableType = 1;
                break;
            case "OSOBY":
                this.tableType = 2;
                break;
            case "STANOWISKA":
                this.tableType = 3;
                break;
            case "KLIENCI":
                this.tableType = 4;
                break;
            case "WYPOSARZENIE":
                this.tableType = 5;
                break;
            case "NA_STANIE":
                this.tableType = 6;
                break;
            case "PRACOWNICY":
                this.tableType = 7;
                break;
            case "OPIS":
                this.tableType = 8;
                break;
            case "SPRZEDANE":
                this.tableType = 9;
                break;
            case "SAMOCHODY":
                this.tableType = 10;
                break;
        }
    }

    protected void getColNames() throws Exception {
        ResultSet rs = statement.executeQuery(sqlColNames);
        int i = 0;
        int x = colNames.length;
        while (rs.next()) {
            colNames[i] = rs.getString("column_name");
            i++;
        }
    }

    public void deleteRow(String name, int row) {
        try {
            sqlDeleteRow = sqlDeleteRow + name + " WHERE " + colNames[0] + "=" + row;
            System.out.println("Zapytanie w delete: " + sqlDeleteRow);
            statement.executeQuery(sqlDeleteRow);
            qRows -= 1;
            statement.executeQuery("COMMIT");
            sqlDeleteRow = "DELETE FROM ";
        } catch (Exception a) {
            System.out.println("Blad w sql");
        }
    }


    protected void createSQL(String name) {
        sqlQueryAllData = "Select ";
        for (int i = 0; i < colNames.length; i++) {
            if (i != colNames.length - 1) {
                sqlQueryAllData = sqlQueryAllData + colNames[i] + ", ";
            } else {
                sqlQueryAllData = sqlQueryAllData + colNames[i] + " ";
            }
        }
        sqlQueryAllData = sqlQueryAllData + "FROM " + name;
    }

    protected void showObj(Object[][] obj) {
        for (int i = 0; i < qRows; i++) {
            for (int j = 0; j < qColumns; j++) //--------------------------------
            {
                System.out.print(" " + obj[i][j] + " ");
            }
            System.out.println("");
        }
    }

    protected void getOsoby() {
        try {
            System.out.println("Zapytanie w getOs: " + sqlQueryAllData);
            ResultSet rs = statement.executeQuery(sqlQueryAllData);
            this.dataX = new Object[qRows][qColumns];//---------------------------
            for (int j = 0; j < qColumns; j++)  //---------------------------------------
            {
                for (int k = 0; k < qRows; k++) {
                    dataX[k][j] = new Object();
                }
            }
            System.out.println("przeszło inicjowanie");
            int l = 0;
            System.out.println("Ilosc kolumn: " + qColumns);
            while (rs.next()) {
                //Retrieve by column name
                for (int i = 0; i < qColumns; i++) {

                        dataX[l][i] = rs.getString(colNames[i]);

                }
                l++;
            }
            rs.close();

            creatDataTable(statement);
        } catch (Exception e) {
            System.out.println("Błąd w getosoby");
        }
    }

    protected void getCount(String name) throws Exception {
        ResultSet result = statement.executeQuery(rowCount);
        while (result.next()) {
            qRows = result.getInt("rowcount");
        }


    }

    protected void getColumns() throws Exception {
        ResultSet result = statement.executeQuery(colCount);
        result.next();
        qColumns = result.getInt("count(*)");
        colNames = new String[qColumns];
    }

    public static Statement connectToDB() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String serverName = "localhost", portNumber = "1521", sid = "xe", url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
        String username = "system", password = "sys";
        System.out.println("Connecting to a selected database...");
        Connection connect = DriverManager.getConnection(url, username, password);
        System.out.println("Connected database successfully...");
        Connection link = connect;
        Statement statement = link.createStatement();
        return statement;
    }


    public void setWidthColumn(int width, int index) {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getColumnModel().getColumn(index).setMinWidth(width);
        table.getColumnModel().getColumn(index).setMaxWidth(width);
        DefaultTableModel tableModel = new DefaultTableModel(dataX, colNames) {

            @Override
            public boolean isCellEditable(int row, int column) {

                //System.out.println("Zaznaczono: "+row+" wiersz i "+column+" kolumne!");
                return false;
            }

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Integer.class;
                    case 3:
                        return Integer.class;
                    case 4:
                        return Integer.class;
                    case 5:
                        return String.class;
                    case 6:
                        return Integer.class;
                    case 7:
                        return Integer.class;
                    case 8:
                        return Integer.class;
                    case 9:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }
        };
        table.setModel(tableModel);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);

        //table.setAutoCreateRowSorter(true);

      /*  table.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(200);
        sortKeys.add(new RowSorter.SortKey(7, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        */

    }

    protected void creatDataTable(Statement stmt) {
        table = new JTable(this.dataX, colNames);
        for (int i = 0; i < qColumns; i++) {    //=--------------------------
            setWidthColumn(100, i);
        }

    }

}

