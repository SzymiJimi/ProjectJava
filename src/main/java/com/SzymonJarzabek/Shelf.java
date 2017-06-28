package com.SzymonJarzabek;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Szymon on 2017-05-04.
 */

/**
 * Klasa obsługująca zakładki
 */
public class Shelf extends JPanel {
    /**
     * Parametry klasy, wykorzystywane w metodach klasy lub przy tworzeniu obiektu
     */
    String text, tip, name, path;
    static ImageIcon icon;
    static int i = 0;

    /**
     * Funkcja tworząca ikone dla zakładki jeśli nie ma przycisku close
     * @param path ścieżka do obrazku
     */
    public static void createImageIcon(String path) {
        java.net.URL imgURL = Projekt.class.getResource(path);
        if (imgURL != null) {
            Shelf.icon = new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            Shelf.icon = null;
        }
    }

    /**
     * Konstruktor dla klasy
     * @param mainPanel Panel główny
     * @param name Nazwa panelu
     * @param text Text wyświetlający się w panelu
     * @param tip Podpowiedz po najechaniu w nazwę panelu
     * @param path ścieżka do obrazka
     */
    public Shelf(JTabbedPane mainPanel, String name, String text, String tip, String path) {
        this.text = text;
        this.tip = tip;
        this.name = name;
        this.path = path;
    }

    /**
     * Metoda wykorzystywana głównie w handlerClass przy tworzeniu nowej zakładki, metoda wywołuje potrzebne metody
     * do dodania przycisku do zamknięcia zakładki oraz inne metody
     * @param name nazwa zakładki utworzonej
     */
    public static void afterCreate(String name) {

        Projekt.tabbedPanel.updateUI();
        Projekt.addCloseButtonToPane(name);
        int index = Projekt.tabbedPanel.indexOfTab(name);
        Projekt.tabbedPanel.setSelectedIndex(index);
    }

    /**
     * Metoda która usuwa zakładke
     * @param name nazwa zakładki usuwanej
     */
    public static void deleteTab(String name) {
        int index;
        index = Projekt.tabbedPanel.indexOfTab(name);
        if (index >= 0) {
            Projekt.tabbedPanel.removeTabAt(index);
            Shelf.i--;
        }
    }

    /**
     * Fukcja tworząca zakładke
     * @param mainPane panel do którego będzie dodana
     * @param name nazwa zakładki
     * @param text tekst który opcjonalnie będzie wyświetlany w zakładce
     * @param tip Wskazówka pojawiająca się po najechaniu na nazwę zakładki
     * @param path ścieżka do obrazka
     * @return zwraca utworzony panel który jest w nowe zakładce
     */
    public static JComponent createShelf(JTabbedPane mainPane, String name, String text, String tip, String path) {
        Image img;
        createImageIcon(path);
        img = new ImageIcon("tło.png").getImage();
        JComponent panel = new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, null);
            }
        };

        mainPane.addTab(name, icon, panel, tip);
        mainPane.setMnemonicAt(i, KeyEvent.VK_3);
        i++;
        return panel;
    }
}
