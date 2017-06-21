package com.SzymonJarzabek;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Szymon on 2017-05-04.
 */
public class Shelf extends JPanel{
    //JTabbedPane mainPane;
    String text, tip, name,path;
    static ImageIcon icon;
    static int i=0;


    public static void createImageIcon(String path) {
        java.net.URL imgURL = Projekt.class.getResource(path);
        if (imgURL != null) {
            Shelf.icon =new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            Shelf.icon= null;
        }
    }
    protected static JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
    public Shelf(JTabbedPane mainPanel, String name, String text, String tip, String path){
        //this.mainPane=mainPanel;
        this.text=text;
        this.tip=tip;
        this.name=name;
        this.path=path;
    }

    public void modifyShelf(int rowID){
        //Table dbTable = new Table();
        Projekt.mainPanel.getComponent(3);
               // Projekt.panel1.getComponent(3);
        JTextField poleTekstowe = new JTextField(20);
        poleTekstowe.setBounds(20, 180, 200, 20);
        poleTekstowe.setDocument(new JTextFieldLimit(20));
        poleTekstowe.setColumns(20);
        poleTekstowe.setBorder(BorderFactory.createLoweredSoftBevelBorder());

    }

    public static JComponent createShelf(JTabbedPane mainPane, String name, String text, String tip, String path)
    {

        Image img;
        createImageIcon(path);
        img = new ImageIcon("tło.png").getImage();
        JComponent panel= new JPanel(){

            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, null);
            }
        };

       // panel.setBackground(img);
        mainPane.addTab(name, icon, panel,tip);
        mainPane.setMnemonicAt(i, KeyEvent.VK_3);
        i++;
        return panel;
    }
}
