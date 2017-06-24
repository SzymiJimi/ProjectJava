package com.SzymonJarzabek;

import javax.swing.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


/**
 * Created by Szymon on 2017-05-04.
 */
public class Table {
    static Statement statement;
    String colNames[],sqlQueryAllData;
    String rowCount= "SELECT COUNT(*) AS rowcount FROM ";
    String colCount="SELECT COUNT(*) FROM all_tab_cols WHERE table_name = '";
    String sqlColNames="SELECT column_name FROM USER_TAB_COLUMNS WHERE table_name = '";
    String sqlDeleteRow="DELETE FROM ";
    Object [][] dataX;
    int qRows, qColumns;
    int tableType=-1;
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


    public Table ( String name) throws Exception{

        tableName=name;
        rowCount=rowCount+name;
        colCount=colCount+name+"'";
        sqlColNames=sqlColNames+name+"'";
        getCount(name);
        getColumns();
        getColNames();
        createSQL(name);
        getOsoby();

    }
    public Table(Table tabela)
    {
        tableName=tabela.tableName;
        rowCount=tabela.rowCount;
        colCount=colCount;
        sqlColNames=sqlColNames;
        qRows=tabela.qRows;
        qColumns=tabela.qColumns;
        colNames=tabela.colNames;
        sqlQueryAllData=tabela.sqlQueryAllData;
        table=tabela.table;
    }

        private void setTableType (String name)
        {
            switch(name)
            {
                case "ADRESY": this.tableType=1;
                    break;
                case "OSOBY": this.tableType=2;
                    break;
                case "STANOWISKA": this.tableType=3;
                    break;
                case "KLIENCI": this.tableType=4;
                    break;
                case "WYPOSARZENIE": this.tableType=5;
                    break;
                case "NA_STANIE": this.tableType=6;
                    break;
                case "PRACOWNICY": this.tableType=7;
                    break;
                case "OPIS": this.tableType=8;
                    break;
                case "SPRZEDANE": this.tableType=9;
                    break;
                case "SAMOCHODY": this.tableType=10;
                    break;
            }
        }
    protected void getColNames () throws Exception
    {
        ResultSet rs = statement.executeQuery(sqlColNames);
        int i=0;
        int x= colNames.length;
        while(rs.next()) {
            colNames[i]=rs.getString("column_name");
            i++;
        }
    }

    public void deleteRow(String name, int row)
    {
        try {
            sqlDeleteRow = sqlDeleteRow + name + " WHERE " + colNames[0] + "=" + row;
            System.out.println("Zapytanie: "+sqlDeleteRow);
            statement.executeQuery(sqlDeleteRow);
            qRows -= 1;
            statement.executeQuery("COMMIT");
            sqlDeleteRow="DELETE FROM ";
        }catch( Exception a )
        {
            System.out.println("Blad w sql");
        }
    }




protected void createSQL(String name){
        sqlQueryAllData="Select ";
        for(int i=0;i<colNames.length;i++) {
            if(i!=colNames.length-1){
                sqlQueryAllData=sqlQueryAllData+colNames[i]+", ";
            }else{
                sqlQueryAllData=sqlQueryAllData+colNames[i]+" ";
            }
        }
        sqlQueryAllData=sqlQueryAllData+"FROM "+name;
        //System.out.println("Zapytanie: "+sqlQueryAllData);
    }

    protected void showObj(Object[][] obj)
    {
        for(int i=0;i<qRows;i++)
        {
            for(int j=0;j<qColumns;j++) //--------------------------------
            {
                System.out.print(" "+obj[i][j]+" ");
            }
            System.out.println("");
        }
    }

    protected void getOsoby() {
        try {
            System.out.println("Zapytanie: "+sqlQueryAllData);
            ResultSet rs = statement.executeQuery(sqlQueryAllData);
            this.dataX = new Object[qRows][qColumns];//---------------------------
            for (int j = 0; j < qColumns; j++)  //---------------------------------------
            {
                for (int k = 0; k < qRows; k++) {
                    dataX[k][j] = new Object();
                }
            }
            int l = 0;
            System.out.println("Ilosc kolumn: " + qColumns);
            while (rs.next()) {
                //Retrieve by column name
                for (int i = 0; i < qColumns; i++) {   //-------------------
                    dataX[l][i] = rs.getString(colNames[i]);
                }
                l++;
            }
            rs.close();
            creatDataTable(statement);
        }catch(Exception e)
        {
            System.out.println("Błąd w getosoby");
        }
    }

    protected void getCount(String name) throws Exception{
        ResultSet result = statement.executeQuery(rowCount);
       while (result.next()){
           qRows = result.getInt("rowcount");
        }


    }
    protected void getColumns() throws Exception {
        ResultSet result = statement.executeQuery(colCount);
        result.next();
        qColumns=result.getInt("count(*)");
        colNames=new String[qColumns];
    }
    public static Statement connectToDB () throws Exception
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String serverName = "localhost",portNumber = "1521", sid = "xe",  url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
        String username = "system", password = "sys";
        System.out.println("Connecting to a selected database...");
        Connection connect = DriverManager.getConnection(url, username, password);
        System.out.println("Connected database successfully...");
        Connection link= connect;
        Statement statement = link.createStatement();
        return statement;
    }


    public void setWidthColumn( int width, int index, Object [][] data,String columnNames[] )
    {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getColumnModel().getColumn(index).setMinWidth(width);
        table.getColumnModel().getColumn(index).setMaxWidth(width);
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {

            @Override
            public boolean isCellEditable(int row, int column) {

                //System.out.println("Zaznaczono: "+row+" wiersz i "+column+" kolumne!");
                return false;
            }
        };
        table.setModel(tableModel);
    }

    protected void creatDataTable(Statement stmt)
    {
        table = new JTable(this.dataX, colNames);
        for(int i=0;i<qColumns;i++){    //=--------------------------
            setWidthColumn(100,i,this.dataX,this.colNames);
        }

    }

}

