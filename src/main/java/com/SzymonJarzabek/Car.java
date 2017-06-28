package com.SzymonJarzabek;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Szymon on 2017-06-23.
 */

/**
 * Klasa zawierająca pola i metody pomagające w obsłudze samochodów w komisie
 */
public class Car {


    public static int rowID;
    public JTextField cena = new JTextField();
    public JComboBox miasto = new JComboBox();

    public JTextField marka = new JTextField();
    public JTextField model = new JTextField();
    public JComboBox rok;
    public JTextField vin;
    public JTextField przebieg;
    public JTextField moc;
    public JComboBox typSilnika;
    public JComboBox pojemnosc;
    public JComboBox skrzynia;
    public JComboBox stan;
    public JComboBox nadwozie;
    public JComboBox krajPoch;
    public JCheckBox serwis;
    public JTextPane opis;

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

    /**
     * Metoda tworząca zakładke do wprowadzania nowej ceny auta
     * @param panel panel do którego zostaną dodane komponenty
     * @param row_id ID samochodu którego cena będzie zmodyfikowana
     * @param Auto Obiekt klasy Car zawierający wszystkie informacje o samochodzie
     */
    public static void createPriceWindow(JPanel panel, int row_id, Car Auto) {

        panel.setLayout(new GridBagLayout());
        GridBagConstraints layout = new GridBagConstraints();
        Auto.cena = HandlerClass.createTextField("Cena samochodu: ", 20, 50, 30, panel, Color.cyan, layout, 0, 0, 0, 0, 0, 0);
        String miejscowosci[] = {"Kielce", "Warszawa", "Wrocław", "Ostrowiec Świętokrzyski", "Masłów", "Brzeziny", "Opatów", "Końskie", "Kraków", "Bodzentyn", "Sandomierz", "Bałtów", "Chęciny", "Włoszczowa", "Busko Zdrój"};
        Auto.miasto = HandlerClass.createComboBox("Wybierz miejscowosc w której bedzie dodane auto: ", miejscowosci, panel, layout, 0, 1, 0, 0, 0, 0);
        JButton acceptAdd = new JButton("Akceptuj");
        Projekt.setLayoutAdd(panel, layout, 0, 2, 0, 0, 0, 0, acceptAdd, 1);

        acceptAdd.setActionCommand("addCarToBase");
        HandlerClass acceptHandler = new HandlerClass(row_id, Auto);
        acceptAdd.addActionListener(acceptHandler);

    }

    /**
     * Metoda pomagająca przekształcić 0 i 1 zapisane w bazie danych na prawda-fałsz
     * @param value vartość liczbowa która będzie zamieniana na logiczną
     * @return wartość logiczna
     */
    protected static int saveBool(boolean value) {

        int variable = 0;
        if (value) {
            variable = 1;
        }
        return variable;
    }

    /**
     * Metoda dodająca samochód do bazy
     * @param row_id ID samochody
     * @param Auto Dane o samochodzie
     */
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

        } else {
            sqlQueryWyp = "UPDATE WYPOSAZENIE SET abs_=" + absBool + ", esp=" + espBool + ", wsp_kier=" + wspKierBool + ", bluetooth=" + bluetoothBool + ", cz_zmierzch=" + czZmierzchuBool + ", cz_park=" + czParkowaniaBool + ", cz_deszcz=" + czDeszczuBool + ", el_lusterka=" + elLusterkaBool + ", el_szyby_p=" + elSzybyPBool + ", el_szyby_t=" + elSzybyTBool + ", podgrz_lust_bok=" + podgrzLustBokBool + ", podgrz_siedz_p=" + podgrzSiedzPBool + ",  podgrz_siedz_t=";
            sqlQueryWyp = sqlQueryWyp + podgrzSiedzTBool + ", podgrz_kier=" + podgrzKierBool + ", immobilizer=" + immobilizerBool + ", alarm=" + alarmBool + ", centralny_zam=" + centralnyZamBool + ", pilot=" + pilotBool + ", mp3=" + mp3Bool + ", gn_aux=" + gnAuxBool + ", radio_fabr=" + radioFabrBool + ", cd=" + cdBool + ", komp_poklad=" + kompPoklBool + ", gniazdo_12v=" + gniazdo12VBool + ", tempomat=" + tempomatBool + ", aktyw_tempomat=" + aktywTempBool + ", line_asist=";
            sqlQueryWyp = sqlQueryWyp + lineAsistBool + ", kurtyny_pow=" + kurtynyPowBool + ", isofix=" + isofixBool + ", ciemn_szyby=" + ciemneSzyby + ", alufelgi=" + alufelgiBool + ", relingi=" + relingiBool + ", sw_led=" + swLEDBool + ", sw_xenon=" + swXenonBool + ", sw_dzien=" + swDzienBool + " WHERE WYPOSAZENIE_ID=" + row_id;
            sqlQueryOpis = "UPDATE OPIS SET skrzynia_biegow='" + skrzyniaTxt + "', stan_pojazdu='" + stanTxt + "', nadwozie='" + nadwozieTxt + "', kraj_pochodzenia='" + krajPochTxt + "', serwisowany=" + serwisTxt + ", dod_opis='" + opisTxt + "' WHERE OPIS_ID=" + row_id;
            sqlQuerySam = "UPDATE SAMOCHODY SET marka='" + markaTxt + "', model_auta='" + modelTxt + "', rok_produkcji=" + rokTxt + ", vin='" + vinTxt + "', przebieg=" + przebiegTxt + ", moc=" + mocTxt + ", typ_silnika='" + typSilnikaTxt + "', pojemnosc=" + pojemnoscTxt + " WHERE SAMOCHOD_ID= " + row_id;
            sqlQueryStan = "Select imie from OSOBY";
        }
        int index;

        try {
            Table.statement.executeQuery(sqlQueryWyp);
            Table.statement.executeQuery("COMMIT");
            Table.statement.executeQuery(sqlQueryOpis);
            Table.statement.executeQuery("COMMIT");
            Table.statement.executeQuery(sqlQuerySam);
            Table.statement.executeQuery("COMMIT");
            if (row_id == -1) {
                Table.statement.executeQuery(sqlQueryStan);
                Table.statement.executeQuery("COMMIT");
            }
            JOptionPane.showMessageDialog(null, "Dodano samochód!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
            index = Projekt.tabbedPanel.indexOfTab("Dodatkowe parametry auta");
            if (index >= 0) {
                Projekt.tabbedPanel.removeTabAt(index);
                Shelf.i--;
            }
            index = Projekt.tabbedPanel.indexOfTab("Dodawanie auta");
            if (index >= 0) {
                Projekt.tabbedPanel.removeTabAt(index);
                Shelf.i--;
            }
            index = Projekt.tabbedPanel.indexOfTab("Modyfikacja auta");
            if (index >= 0) {
                Projekt.tabbedPanel.removeTabAt(index);
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

    /**
     * Stworzenie komponentów które bedą wyświetlane przy modyfikacji i dodawania auta
     * @param Samochod Obiekt w którym będą zapisane dane oa samochodzie
     * @param mainPanel Panel w którym bedą umieszczone komponenty
     * @param layout Layout
     */
    public static void createComponents(Car Samochod, JPanel mainPanel, GridBagConstraints layout) {
        Samochod.marka = HandlerClass.createTextField("Marka: ", 20, 50, 30, mainPanel, Color.cyan, layout, 0, 0, 0, 0, 0, 0);
        Samochod.model = HandlerClass.createTextField("Model: ", 20, 50, 30, mainPanel, Color.cyan, layout, 0, 1, 0, 0, 0, 0);
        String years[] = {"1986", "1987", "1988", "1989", "1990", "1991", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017"};
        Samochod.rok = HandlerClass.createComboBox("Rok produkcji: ", years, mainPanel, layout, 0, 2, 0, 0, 0, 0);
        Samochod.vin = HandlerClass.createTextField("VIN: ", 20, 50, 30, mainPanel, Color.cyan, layout, 0, 3, 0, 0, 0, 0);
        Samochod.przebieg = HandlerClass.createTextField("Przebieg: ", 20, 50, 30, mainPanel, Color.cyan, layout, 0, 4, 0, 0, 0, 0);
        Samochod.moc = HandlerClass.createTextField("Moc: ", 20, 50, 30, mainPanel, Color.cyan, layout, 0, 5, 0, 0, 0, 0);
        String engineTypes[] = {"Diesel", "Benzyna", "Hybrydowy", "Elektryczny", "Benzyna+LPG"};
        Samochod.typSilnika = HandlerClass.createComboBox("Rodzaj paliwa: ", engineTypes, mainPanel, layout, 0, 6, 0, 0, 0, 0);
        String capacity[] = {"0.8", "0.9", "1.0", "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2.0", "2.1", "2.2", "2.3", "2.4", "2.5", "2.6", "2.7", "2.8", "2.9", "3.0", "3.1", "3.2", "3.3", "3.4", "3.5", "3.6", "3.7", "3.8", "3.9", "4.0", "4.1", "4.2", "4.3", "4.4", "4.5", "4.6", "4.7", "4.8", "4.9", "5.0"};
        Samochod.pojemnosc = HandlerClass.createComboBox("Pojemność: ", capacity, mainPanel, layout, 0, 7, 0, 0, 0, 0);
        String gearbox[] = {"Manualna", "Automat"};
        Samochod.skrzynia = HandlerClass.createComboBox("Skrzynia biegów: ", gearbox, mainPanel, layout, 0, 8, 0, 0, 0, 0);
        String condition[] = {"Nowy", "Używany", "Uszkodzony"};
        Samochod.stan = HandlerClass.createComboBox("Stan: ", condition, mainPanel, layout, 0, 9, 0, 0, 0, 0);
        String body[] = {"Sedan", "Hatchback", "Kombi", "SUV", "Minivan", "Kabriolet", "Terenowy", "Coupe"};
        Samochod.nadwozie = HandlerClass.createComboBox("Nadwozie: ", body, mainPanel, layout, 0, 10, 0, 0, 0, 0);
        String origin[] = {"Polska", "Niemcy", "Francja", "Holandia", "Włochy", "Wielka Brytania", "Belgia", "Dania", "Ameryka", "Inny"};
        Samochod.krajPoch = HandlerClass.createComboBox("Kraj pochodzenia: ", origin, mainPanel, layout, 0, 11, 0, 0, 0, 0);
        Samochod.serwis = HandlerClass.createCheckBox("Serwisowany", false, mainPanel, layout, 0, 12, 0, 0, 0, 0, 1);
        Samochod.opis = HandlerClass.createTextPane("Dodatkowy opis: ", 400, 150, mainPanel, layout, 0, 13, 0, -50, 0, 0);

        Samochod.abs = HandlerClass.createCheckBox("ABS: ", false, mainPanel, layout, 2, 0, 0, 0, 0, 0);
        Samochod.esp = HandlerClass.createCheckBox("ESP: ", false, mainPanel, layout, 2, 1, 0, 0, 0, 0);
        Samochod.wspKier = HandlerClass.createCheckBox("Wspomaganie kierownicy: ", false, mainPanel, layout, 2, 2, 0, 0, 0, 0);
        Samochod.bluetooth = HandlerClass.createCheckBox("Bluetooth: ", false, mainPanel, layout, 2, 3, 0, 0, 0, 0);
        Samochod.czZmierzchu = HandlerClass.createCheckBox("Czujnik zmierzchu: ", false, mainPanel, layout, 2, 4, 0, 0, 0, 0);
        Samochod.czParkowania = HandlerClass.createCheckBox("Czujniki parkowania: ", false, mainPanel, layout, 2, 5, 0, 0, 0, 0);
        Samochod.czDeszczu = HandlerClass.createCheckBox("Czujniki deszczu: ", false, mainPanel, layout, 2, 6, 0, 0, 0, 0);
        Samochod.elLusterka = HandlerClass.createCheckBox("Elektryczne lusterka: ", false, mainPanel, layout, 2, 7, 0, 0, 0, 0);
        Samochod.elSzybyP = HandlerClass.createCheckBox("Elektryczne szyby przednie: ", false, mainPanel, layout, 2, 8, 0, 0, 0, 0);
        Samochod.elSzybyT = HandlerClass.createCheckBox("Elektryczne szyby tylnie: ", false, mainPanel, layout, 2, 9, 0, 0, 0, 0);
        Samochod.podgrzLustBok = HandlerClass.createCheckBox("Podgrzewane lusterka boczne: ", false, mainPanel, layout, 2, 10, 0, 0, 0, 0);
        Samochod.podgrzSiedzP = HandlerClass.createCheckBox("Podgrzewane siedzenia przód: ", false, mainPanel, layout, 2, 11, 0, 0, 0, 0);
        Samochod.podgrzSiedzT = HandlerClass.createCheckBox("Podgrzewane siedzenia tył: ", false, mainPanel, layout, 2, 12, 0, 0, 0, 0);
        Samochod.podgrzKier = HandlerClass.createCheckBox("Podgrzewanie kierownicy: ", false, mainPanel, layout, 2, 13, -130, 0, 0, 0);
        Samochod.immobilizer = HandlerClass.createCheckBox("Immobilizer: ", false, mainPanel, layout, 2, 14, -240, 0, 0, 0);
        Samochod.alarm = HandlerClass.createCheckBox("Alarm: ", false, mainPanel, layout, 2, 15, -200, 0, 0, 0);
        Samochod.centralnyZam = HandlerClass.createCheckBox("Centralny zamek: ", false, mainPanel, layout, 2, 16, -160, 0, 0, 0);
        Samochod.pilot = HandlerClass.createCheckBox("Pilot: ", false, mainPanel, layout, 4, 0, 0, 0, 0, 0);
        Samochod.mp3 = HandlerClass.createCheckBox("Radio mp3: ", false, mainPanel, layout, 4, 1, 0, 0, 0, 0);
        Samochod.gnAux = HandlerClass.createCheckBox("Gniazdo AUX: ", false, mainPanel, layout, 4, 2, 0, 0, 0, 0);
        Samochod.radioFabr = HandlerClass.createCheckBox("Radio fabryczne: ", false, mainPanel, layout, 4, 3, 0, 0, 0, 0);
        Samochod.cd = HandlerClass.createCheckBox("Odtwarzacz CD: ", false, mainPanel, layout, 4, 4, 0, 0, 0, 0);
        Samochod.kompPokl = HandlerClass.createCheckBox("Komputer pokładowy: ", false, mainPanel, layout, 4, 5, 0, 0, 0, 0);
        Samochod.gniazdo12V = HandlerClass.createCheckBox("Gniazdo 12V: ", false, mainPanel, layout, 4, 6, 0, 0, 0, 0);
        Samochod.tempomat = HandlerClass.createCheckBox("Tempomat: ", false, mainPanel, layout, 4, 7, 0, 0, 0, 0);
        Samochod.aktywTemp = HandlerClass.createCheckBox("Aktywny tempomat: ", false, mainPanel, layout, 4, 8, 0, 0, 0, 0);
        Samochod.lineAsist = HandlerClass.createCheckBox("Line asist: ", false, mainPanel, layout, 4, 9, 0, 0, 0, 0);
        Samochod.kurtynyPow = HandlerClass.createCheckBox("Kurtyny powietrzne: ", false, mainPanel, layout, 4, 10, 0, 0, 0, 0);
        Samochod.isofix = HandlerClass.createCheckBox("ISOFIX: ", false, mainPanel, layout, 4, 11, 0, 0, 0, 0);
        Samochod.ciemneSzyby = HandlerClass.createCheckBox("Przyciemniane szyby: ", false, mainPanel, layout, 4, 12, 0, 0, 0, 0);
        Samochod.alufelgi = HandlerClass.createCheckBox("Alufelgi: ", false, mainPanel, layout, 4, 13, -130, 0, 0, 0);
        Samochod.relingi = HandlerClass.createCheckBox("Relingi dachowe: ", false, mainPanel, layout, 4, 14, -240, 0, 0, 0);
        Samochod.swLED = HandlerClass.createCheckBox("Światła ledowe: ", false, mainPanel, layout, 4, 15, -200, 0, 0, 0);
        Samochod.swXenon = HandlerClass.createCheckBox("Światła xenonowe: ", false, mainPanel, layout, 4, 16, -160, 0, 0, 0);
        Samochod.swDzien = HandlerClass.createCheckBox("Światła do jazdy dziennej: ", false, mainPanel, layout, 4, 17, -120, 0, 0, 0);

    }

    /**
     * Stworzenie panelu do sprzedaży auta
     * @param panel Panel do którego zostaną dodane komponenty
     * @param stateRowID ID stanu samochodu aby przy sprzedaży można samochód usunąc z tabeli na stanie
     * @param carRow ID samochodu sprzedawanego
     */
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
        SellData.sex = HandlerClass.createComboBox("Płeć: ", plec, panel, layout, 0, 7, 0, 0, 0, 0);
        Projekt.setLayoutAdd(panel, layout, 0, 8, 0, -500, 0, 0, sell, 1);

        HandlerClass acceptHandler = new HandlerClass(SellData, stateRowID, carRow);
        sell.addActionListener(acceptHandler);

    }

    /**
     * Metoda wywołująca metode która stworzy panel sprzedaży
     * @param stateRowID ID Stanu
     * @param carRow ID samochodu
     */
    public static void sellCar(int stateRowID, int carRow) {

        JPanel panel = new JPanel();
        String name = "Sprzedaż auta";
        JComponent sellPanel = Shelf.createShelf(Projekt.tabbedPanel, name, "", "Wprowadzanie informacji o sprzedazy...", "ikona1.gif");
        Projekt.tabbedPanel.updateUI();
        Projekt.addCloseButtonToPane(name);
        int index = Projekt.tabbedPanel.indexOfTab(name);
        Projekt.tabbedPanel.setSelectedIndex(index);
        sellPanel.add(panel);
        createSellObj(panel, stateRowID, carRow);
    }

    /**
     * Stworzenie zapytań do sprzedaży samochodu
     * @param sqlQueries Tablica z zapytaniami
     * @param stateID ID stanu
     * @param carRowID ID samochodu
     * @param sellData Dane sprzedaży
     */
    public static void createSQL(String sqlQueries[], int stateID, int carRowID, Equipment sellData) {

        String name = sellData.clientName.getText();
        String surname = sellData.clientSurname.getText();
        String pesel = sellData.clientPESEL.getText();
        String price = sellData.price.getText();
        String workID = sellData.workerID.getText();

        String sex = (String) sellData.sex.getSelectedItem();
        if (sex == "Kobieta") {
            sex = "K";
        } else {
            sex = "M";
        }

        LocalDateTime date = LocalDateTime.now();
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        Date data = new Date();
        // data.;
        sqlQueries[0] = "Delete from NA_STANIE where ID_STANU=" + stateID;
        sqlQueries[1] = "Insert into OSOBY values(personseq.nextval, '" + name + "','" + surname + "','brak','" + pesel + "')";
        sqlQueries[2] = "Insert into KLIENCI values(clientseq.nextval, TO_DATE('" + day + "/" + month + "/" + year + "', 'DD/MM/YYYY'), '" + sex + "',personseq.currval, 150)";
        sqlQueries[3] = "Insert into SPRZEDANE values(sellseq.nextval, TO_DATE('" + day + "/" + month + "/" + year + "', 'DD/MM/YYYY'), " + price + "," + carRowID + ",clientseq.currval," + workID + ")";

    }

    /**
     * Metoda wykonująca zapytania przy sprzedaży samochodu
     * @param sqlQueries zapytania stworzone
     */
    public static void executeSQL(String sqlQueries[]) {
        System.out.println("Zapytania: " + sqlQueries[0] + "\n" + sqlQueries[1] + "\n" + sqlQueries[2] + "\n" + sqlQueries[3]);
        try {

            Table.statement.executeQuery(sqlQueries[0]);
            Table.statement.executeQuery(sqlQueries[1]);
            Table.statement.executeQuery(sqlQueries[2]);
            Table.statement.executeQuery(sqlQueries[3]);
            Table.statement.executeQuery("COMMIT");
        } catch (Exception e) {
            System.out.println("Błąd w sprzedazy auta");
        }
    }

    /**
     * Usuwanie zakładki
     */
    public static void deleteShelf() {
        String name = "Sprzedaż auta";
        int index = Projekt.tabbedPanel.indexOfTab(name);
        if (index >= 0) {
            Projekt.tabbedPanel.removeTabAt(index);
            Shelf.i--;
        }

        name = "Modyfikacja auta";
        index = Projekt.tabbedPanel.indexOfTab(name);
        if (index >= 0) {
            Projekt.tabbedPanel.removeTabAt(index);
            Shelf.i--;
        }
        name = "Auta na stanie";
        index = Projekt.tabbedPanel.indexOfTab(name);
        Projekt.tabbedPanel.setSelectedIndex(index);
    }

    /**
     * Akceptacja sprzedaży
     * @param stateID
     * @param carRowID
     * @param sellData
     */
    public static void acceptSell(int stateID, int carRowID, Equipment sellData) {
        String sqlQueries[] = new String[4];

        createSQL(sqlQueries, stateID, carRowID, sellData);
        executeSQL(sqlQueries);
        deleteShelf();
    }

}
