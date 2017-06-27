package com.SzymonJarzabek;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Szymon on 2017-06-23.
 */
public class Car {


    public static int rowID;
    public JTextField cena = new JTextField();
    public JComboBox miasto = new JComboBox();

    public JTextField marka = new JTextField();
    public JTextField model = new JTextField();
    public JComboBox rok;
    // public JTextField rok;
    public JTextField vin;
    public JTextField przebieg;
    public JTextField moc;
    // String engineTypes[]={"Diesel", "Benzyna", "Hubryda", "Elektryczny", "Benzyna+LPG"};
    public JComboBox typSilnika;
    //public JTextField pojemnosc;
    public JComboBox pojemnosc;
    // String gearbox[]={"Manualna", "Automat"};
    public JComboBox skrzynia;
    //String condition[]={"Nowy", "Używany", "Uszkodzony"};
    public JComboBox stan;
    // String body[]={"Sedan", "Hatchback", "Kombi", "SUV", "Minivan", "Kabriolet", "Terenowy", "Coupe"};
    public JComboBox nadwozie;
    public JComboBox krajPoch;
    public JCheckBox serwis;
    public JTextPane opis;

    //JCheckBox serwis= createCheckBox("Poduszki", false, mainPanel, layout,0,10,0,0,0,0);

    public JCheckBox abs;
    public JCheckBox esp;
    public JCheckBox wspKier;
    public JCheckBox bluetooth;
    public JCheckBox czZmierzchu;
    public JCheckBox czParkowania;
    public JCheckBox czDeszczu;
    public JCheckBox elLusterka;
    public JCheckBox elSzybyP;
    public JCheckBox elSzybyT;
    public JCheckBox podgrzLustBok;
    public JCheckBox podgrzSiedzP;
    public JCheckBox podgrzSiedzT;
    public JCheckBox podgrzKier;
    public JCheckBox immobilizer;
    public JCheckBox alarm;
    public JCheckBox centralnyZam;
    public JCheckBox pilot;
    public JCheckBox mp3;
    public JCheckBox gnAux;
    public JCheckBox radioFabr;
    public JCheckBox cd;
    public JCheckBox kompPokl;
    public JCheckBox gniazdo12V;
    public JCheckBox tempomat;
    public JCheckBox aktywTemp;
    public JCheckBox lineAsist;
    public JCheckBox kurtynyPow;
    public JCheckBox isofix;
    public JCheckBox ciemneSzyby;
    public JCheckBox alufelgi;
    public JCheckBox relingi;
    public JCheckBox swLED;
    public JCheckBox swXenon;
    public JCheckBox swDzien;


    public static void createPriceWindow(JPanel panel, int row_id, Car Auto) {

        panel.setLayout(new GridBagLayout());
        GridBagConstraints layout = new GridBagConstraints();
        Auto.cena = HandlerClass.createTextField("Cena samochodu: ", 20, 50, 30, panel, Color.cyan, layout, 0, 0, 0, 0, 0, 0);
        String miejscowosci[] = {"Kielce", "Warszawa", "Wrocław", "Ostrowiec Świętokrzyski", "Masłów", "Brzeziny", "Opatów", "Końskie", "Kraków", "Bodzentyn", "Sandomierz", "Bałtów", "Chęciny", " Włoszczowa", "Busko Zdrój"};
        Auto.miasto = HandlerClass.createComboBox("Wybierz miejscowosc w której bedzie dodane auto: ", miejscowosci, panel, layout, 0, 1, 0, 0, 0, 0);
        JButton acceptAdd = new JButton("Akceptuj");
        Projekt.setLayoutAdd(panel, layout, 0, 2, 0, 0, 0, 0, acceptAdd, 1);

        acceptAdd.setActionCommand("addCarToBase");
        HandlerClass acceptHandler = new HandlerClass(row_id, Auto);
        acceptAdd.addActionListener(acceptHandler);

    }

    protected static int saveBool(boolean value) {

        int variable = 0;
        if (value) {
            variable = 1;
        }
        return variable;
    }

    public static void addCarToBase(int row_id, Car Auto) {
        String markaTxt;
        markaTxt = Auto.marka.getText();

        System.out.println("Marka: " + markaTxt);

        String modelTxt = Auto.model.getText();
        String rokTxt = (String) Auto.rok.getSelectedItem();
        String vinTxt = Auto.vin.getText();
        String przebiegTxt = Auto.przebieg.getText();
        String mocTxt = Auto.moc.getText();
        String typSilnikaTxt = (String) Auto.typSilnika.getSelectedItem();
        String pojemnoscTxt = (String) Auto.pojemnosc.getSelectedItem();
        String skrzyniaTxt = (String) Auto.skrzynia.getSelectedItem();
        String stanTxt = (String) Auto.stan.getSelectedItem();
        String nadwozieTxt = (String) Auto.nadwozie.getSelectedItem();
        String krajPochTxt = (String) Auto.krajPoch.getSelectedItem();
        int serwisTxt = saveBool(Auto.serwis.isSelected());
        String opisTxt = Auto.opis.getText();
        String cena = Auto.cena.getText();
        String miasto = (String) Auto.miasto.getSelectedItem();


        int absBool = saveBool(Auto.abs.isSelected());
        int espBool = saveBool(Auto.esp.isSelected());
        int wspKierBool = saveBool(Auto.wspKier.isSelected());
        int bluetoothBool = saveBool(Auto.bluetooth.isSelected());
        int czZmierzchuBool = saveBool(Auto.czZmierzchu.isSelected());
        int czParkowaniaBool = saveBool(Auto.czParkowania.isSelected());
        int czDeszczuBool = saveBool(Auto.czDeszczu.isSelected());
        int elLusterkaBool = saveBool(Auto.elLusterka.isSelected());
        int elSzybyPBool = saveBool(Auto.elSzybyP.isSelected());
        int elSzybyTBool = saveBool(Auto.elSzybyT.isSelected());
        int podgrzLustBokBool = saveBool(Auto.podgrzLustBok.isSelected());
        int podgrzSiedzPBool = saveBool(Auto.podgrzSiedzP.isSelected());
        int podgrzSiedzTBool = saveBool(Auto.podgrzSiedzT.isSelected());
        int podgrzKierBool = saveBool(Auto.podgrzKier.isSelected());
        int immobilizerBool = saveBool(Auto.immobilizer.isSelected());
        int alarmBool = saveBool(Auto.alarm.isSelected());
        int centralnyZamBool = saveBool(Auto.centralnyZam.isSelected());
        int pilotBool = saveBool(Auto.pilot.isSelected());
        int mp3Bool = saveBool(Auto.mp3.isSelected());
        int gnAuxBool = saveBool(Auto.gnAux.isSelected());
        int radioFabrBool = saveBool(Auto.radioFabr.isSelected());
        int cdBool = saveBool(Auto.cd.isSelected());
        int kompPoklBool = saveBool(Auto.kompPokl.isSelected());
        int gniazdo12VBool = saveBool(Auto.gniazdo12V.isSelected());
        int tempomatBool = saveBool(Auto.tempomat.isSelected());
        int aktywTempBool = saveBool(Auto.aktywTemp.isSelected());
        int lineAsistBool = saveBool(Auto.lineAsist.isSelected());
        int kurtynyPowBool = saveBool(Auto.kurtynyPow.isSelected());
        int isofixBool = saveBool(Auto.isofix.isSelected());
        int ciemneSzyby = saveBool(Auto.ciemneSzyby.isSelected());
        int alufelgiBool = saveBool(Auto.alufelgi.isSelected());
        int relingiBool = saveBool(Auto.relingi.isSelected());
        int swLEDBool = saveBool(Auto.swLED.isSelected());
        int swXenonBool = saveBool(Auto.swXenon.isSelected());
        int swDzienBool = saveBool(Auto.swDzien.isSelected());

        String sqlQueryWyp;
        String sqlQueryOpis;
        String sqlQuerySam;

        String sqlQueryStan;

        if (row_id == -1) {
            sqlQueryWyp = "Insert into WYPOSAZENIE VALUES(wypseq.nextval, 10, " + absBool + ", " + espBool + ", " + wspKierBool + ", " + bluetoothBool + ", " + czZmierzchuBool + ", " + czParkowaniaBool + ", " + czDeszczuBool + ", " + elLusterkaBool + ", " + elSzybyPBool + ", " + elSzybyTBool + ", " + podgrzLustBokBool + ", " + podgrzSiedzPBool + ", ";
            sqlQueryWyp = sqlQueryWyp + podgrzSiedzTBool + ", " + podgrzKierBool + ", " + immobilizerBool + ", " + alarmBool + ", " + centralnyZamBool + ", " + pilotBool + ", " + mp3Bool + ", " + gnAuxBool + ", " + radioFabrBool + ", " + cdBool + ", " + kompPoklBool + ", " + gniazdo12VBool + ", " + tempomatBool + ", " + aktywTempBool + ", ";
            sqlQueryWyp = sqlQueryWyp + lineAsistBool + ", " + kurtynyPowBool + ", " + isofixBool + ", " + ciemneSzyby + ", " + alufelgiBool + ", " + relingiBool + ", " + swLEDBool + ", " + swXenonBool + ", " + swDzienBool + ")";

            sqlQueryOpis = "Insert into OPIS VALUES(opisseq.nextval, '" + skrzyniaTxt + "', '" + stanTxt + "', '" + nadwozieTxt + "', '" + krajPochTxt + "', " + serwisTxt + ", '" + opisTxt + "')";

            sqlQuerySam = "Insert into SAMOCHODY VALUES(samseq.nextval, '" + markaTxt + "', '" + modelTxt + "', " + rokTxt + ", '" + vinTxt + "', " + przebiegTxt + ", " + mocTxt + ", '" + typSilnikaTxt + "', " + pojemnoscTxt + ",wypseq.currval,opisseq.currval,10)";
            sqlQueryStan = "Insert into NA_STANIE VALUES(stanseq.nextval, " + cena + ",'" + miasto + "',2,4,samseq.currval)";

            System.out.println("Zapytanie z dodawania stanu: " + sqlQueryStan);
            System.out.println("Zapytanie z dodawania wyposarzenia: " + sqlQueryWyp);
            System.out.println("Zapytanie z dodawania opisu: " + sqlQueryOpis);
            System.out.println("Zapytanie z dodawania samochodu: " + sqlQuerySam);
        } else {
            sqlQueryWyp = "UPDATE WYPOSAZENIE SET abs_=" + absBool + ", esp=" + espBool + ", wsp_kier=" + wspKierBool + ", bluetooth=" + bluetoothBool + ", cz_zmierzch=" + czZmierzchuBool + ", cz_park=" + czParkowaniaBool + ", cz_deszcz=" + czDeszczuBool + ", el_lusterka=" + elLusterkaBool + ", el_szyby_p=" + elSzybyPBool + ", el_szyby_t=" + elSzybyTBool + ", podgrz_lust_bok=" + podgrzLustBokBool + ", podgrz_siedz_p=" + podgrzSiedzPBool + ",  podgrz_siedz_t=";
            sqlQueryWyp = sqlQueryWyp + podgrzSiedzTBool + ", podgrz_kier=" + podgrzKierBool + ", immobilizer=" + immobilizerBool + ", alarm=" + alarmBool + ", centralny_zam=" + centralnyZamBool + ", pilot=" + pilotBool + ", mp3=" + mp3Bool + ", gn_aux=" + gnAuxBool + ", radio_fabr=" + radioFabrBool + ", cd=" + cdBool + ", komp_poklad=" + kompPoklBool + ", gniazdo_12v=" + gniazdo12VBool + ", tempomat=" + tempomatBool + ", aktyw_tempomat=" + aktywTempBool + ", line_asist=";
            sqlQueryWyp = sqlQueryWyp + lineAsistBool + ", kurtyny_pow=" + kurtynyPowBool + ", isofix=" + isofixBool + ", ciemn_szyby=" + ciemneSzyby + ", alufelgi=" + alufelgiBool + ", relingi=" + relingiBool + ", sw_led=" + swLEDBool + ", sw_xenon=" + swXenonBool + ", sw_dzien=" + swDzienBool + " WHERE WYPOSAZENIE_ID=" + row_id;

            sqlQueryOpis = "UPDATE OPIS SET skrzynia_biegow='" + skrzyniaTxt + "', stan_pojazdu='" + stanTxt + "', nadwozie='" + nadwozieTxt + "', kraj_pochodzenia='" + krajPochTxt + "', serwisowany=" + serwisTxt + ", dod_opis='" + opisTxt + "' WHERE OPIS_ID=" + row_id;

            sqlQuerySam = "UPDATE SAMOCHODY SET marka='" + markaTxt + "', model_auta='" + modelTxt + "', rok_produkcji=" + rokTxt + ", vin='" + vinTxt + "', przebieg=" + przebiegTxt + ", moc=" + mocTxt + ", typ_silnika='" + typSilnikaTxt + "', pojemnosc=" + pojemnoscTxt + " WHERE SAMOCHOD_ID= " + row_id;
            sqlQueryStan = "Select imie from OSOBY";


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
            if (row_id != -1) {
                Table.statement.executeQuery(sqlQueryStan);
                Table.statement.executeQuery("COMMIT");
            }

            JOptionPane.showMessageDialog(null, "Dodano samochód!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
            //String name="Dodatkowe parametry auta";

            index = Projekt.tabbedPanel.indexOfTab("Dodatkowe parametry auta");
            // System.out.println("Index tabeli usuwanej: " + index);
            if (index >= 0) {

                Projekt.tabbedPanel.removeTabAt(index);
                //zmniejszanie indexu panelu aby później można było dodać znów
                Shelf.i--;
            }

            index = Projekt.tabbedPanel.indexOfTab("Dodawanie auta");
            // System.out.println("Index tabeli usuwanej: " + index);
            if (index >= 0) {

                Projekt.tabbedPanel.removeTabAt(index);
                //zmniejszanie indexu panelu aby później można było dodać znów
                Shelf.i--;
            }

            index = Projekt.tabbedPanel.indexOfTab("Modyfikacja auta");
            // System.out.println("Index tabeli usuwanej: " + index);
            if (index >= 0) {

                Projekt.tabbedPanel.removeTabAt(index);
                //zmniejszanie indexu panelu aby później można było dodać znów
                Shelf.i--;
            }

            if (row_id == -1) {
                index = Projekt.tabbedPanel.indexOfTab("Panel główny");
                Projekt.tabbedPanel.setSelectedIndex(index);
            } else {
                index = Projekt.tabbedPanel.indexOfTab("Auta na stanie");
                Projekt.tabbedPanel.setSelectedIndex(index);
            }

        } catch (Exception e) {
            System.out.println("Błąd w dodawaniu samochodu do bazy!");
        }
    }

    public static void createSellObj(JPanel panel, int stateRowID, int carRow) {

        panel.setPreferredSize(new Dimension(1180, 600));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints layout = new GridBagConstraints();
        Equipment SellData = new Equipment();
        JButton sell = new JButton("Sprzedaj");
        sell.setActionCommand("acceptSell");
        JLabel message = new JLabel("Sprzedaz samochodu");
        JLabel message1 = new JLabel("Informacje o kliencie");

        Projekt.setLayoutAdd(panel, layout, 0, 0, 0, -500, 0, 0, message, 1);
        Projekt.setLayoutAdd(panel, layout, 0, 3, 0, -500, 0, 0, message1, 1);

        SellData.clientName = HandlerClass.createTextField("Imie: ", 20, 50, 30, panel, Color.cyan, layout, 0, 4, 0, 0, 0, 0);
        SellData.clientSurname = HandlerClass.createTextField("Nazwisko: ", 20, 50, 30, panel, Color.cyan, layout, 0, 5, 0, 0, 0, 0);
        SellData.clientPESEL = HandlerClass.createTextField("Pesel: ", 20, 50, 30, panel, Color.cyan, layout, 0, 6, 0, 0, 0, 0);
        SellData.price = HandlerClass.createTextField("Cena samochodu: ", 20, 50, 30, panel, Color.cyan, layout, 0, 1, 0, 0, 0, 0);
        SellData.workerID = HandlerClass.createTextField("ID pracownika sprzedającego: ", 20, 50, 30, panel, Color.cyan, layout, 0, 2, 0, 0, 0, 0);
        String plec[] = {"Kobieta", "Mężczyzna"};
        SellData.sex = HandlerClass.createComboBox("Rok produkcji: ", plec, panel, layout, 0, 7, 0, 0, 0, 0);
        Projekt.setLayoutAdd(panel, layout, 0, 8, 0, -500, 0, 0, sell, 1);

        HandlerClass acceptHandler=new HandlerClass(SellData, stateRowID, carRow);
        sell.addActionListener(acceptHandler);

    }

    public static void sellCar(int stateRowID, int carRow) {

        JPanel panel = new JPanel();
        String name = "Sprzedaż auta";
        JComponent sellPanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Wprowadzanie informacji o sprzedazy...", "ikona1.gif");
        Projekt.tabbedPanel.updateUI();
        //Sprawdzamy jaki jest index ostatnio stworzonej tabeli aby można dodać akcje do przycisku.
        Projekt.addCloseButtonToPane(name);
        int index = Projekt.tabbedPanel.indexOfTab(name);
        Projekt.tabbedPanel.setSelectedIndex(index);
        sellPanel.add(panel);
        createSellObj(panel,stateRowID, carRow);
    }

    public static void createSQL(String sqlQueries[], int stateID, int carRowID, Equipment sellData)
    {

        String name=sellData.clientName.getText();
        String surname=sellData.clientSurname.getText();
        String pesel=sellData.clientPESEL.getText();
        String price=sellData.price.getText();
        String workID=sellData.workerID.getText();

        String sex= (String)sellData.sex.getSelectedItem();
        if(sex=="Kobieta")
        {
            sex="K";
        }else{
            sex="M";
        }

        LocalDateTime date=LocalDateTime.now();
        int year=date.getYear();
        int month=date.getMonthValue();
        int day=date.getDayOfMonth();
        Date data= new Date();
       // data.;
        sqlQueries[0]="Delete from NA_STANIE where ID_STANU="+stateID;
        sqlQueries[1]="Insert into OSOBY values(personseq.nextval, '"+name+"','"+surname+"','brak','"+pesel+"')";
        sqlQueries[2]="Insert into KLIENCI values(clientseq.nextval, TO_DATE('"+day+"/"+month+"/"+year+"', 'DD/MM/YYYY'), '"+sex+"',personseq.currval, 150)";
        sqlQueries[3]="Insert into SPRZEDANE values(sellseq.nextval, TO_DATE('"+day+"/"+month+"/"+year+"', 'DD/MM/YYYY'), "+price+","+carRowID+",clientseq.currval,"+workID+")";

    }

    public static void executeSQL(String sqlQueries[])
    {
        System.out.println("Zapytania: "+sqlQueries[0]+"\n"+sqlQueries[1]+"\n"+sqlQueries[2]+"\n"+sqlQueries[3]);
        try {

            Table.statement.executeQuery(sqlQueries[0]);
            Table.statement.executeQuery(sqlQueries[1]);
            Table.statement.executeQuery(sqlQueries[2]);
            Table.statement.executeQuery(sqlQueries[3]);
            Table.statement.executeQuery("COMMIT");
        }catch(Exception e)
        {
            System.out.println("Błąd w sprzedazy auta");
        }
    }

    public static void deleteShelf()
    {
        String name="Sprzedaż auta";
        int index = Projekt.tabbedPanel.indexOfTab(name);
        if (index >= 0) {
            Projekt.tabbedPanel.removeTabAt(index);
            Shelf.i--;
        }

         name="Modyfikacja auta";
        index = Projekt.tabbedPanel.indexOfTab(name);
        if (index >= 0) {
            Projekt.tabbedPanel.removeTabAt(index);
            Shelf.i--;
        }
         name="Auta na stanie";
        index = Projekt.tabbedPanel.indexOfTab(name);
            Projekt.tabbedPanel.setSelectedIndex(index);
    }
    public static void acceptSell(int stateID, int carRowID, Equipment sellData)
    {
        String sqlQueries[]=new String[4];

        createSQL(sqlQueries, stateID,carRowID,sellData);
        executeSQL(sqlQueries);
        deleteShelf();
    }

}
