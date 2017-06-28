package com.SzymonJarzabek;

/**
 * Created by Szymon on 2017-04-18.
 */

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.*;

/**
 * Główna klasa projektu
 */
public class Projekt {
    /**
     * Panel główny który przekierowuje do wykonywania innych akcji
     */
    static JComponent mainPanel;
    /**
     * Tabbed Pane panel z zakładkami, można do niego dodawać kolejne zakładki
     */
    static JTabbedPane tabbedPanel = new JTabbedPane();

    /**
     * @param name Nazwa Tabeli w bazie danych
     * @param panel panel do którego zostanie dodana tabela
     * @return Zwraca tabele która będzie wyświetlana i do której będą dodawane dane
     * @throws Exception
     */
    public static JTable createTable(String name, JComponent panel) throws Exception {
        panel.updateUI();
        Table Item = new Table(name);
        JScrollPane tableArea = Projekt.createTextArea(Item.table, 1180, 580);
        panel.add(tableArea);
        panel.updateUI();
        return Item.table;

    }

    /**
     * Klasa obsługująca mysz w przycisku do zamykania zakładek
     */
    public final static MouseListener buttonMouseListener = new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
            Component component = e.getComponent();
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

    /**
     *
     * @param x Szerokość okna
     * @param y Wysokość okna
     * @return Zwraca obiekt JFrame czyli okno
     */
    private static JFrame createWindow(int x, int y) {
        JFrame window = new JFrame("Komis samochodowy");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(x, y);
        return window;
    }

    /**
     * Funkcja dodająca przycisk zamykający do zakładki
     * @param nameOfPane nazwa zakładki
     */
    public static void addCloseButtonToPane(String nameOfPane) {
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
        } catch (Exception e) {
            System.out.println("Błąd w przycisku close");
        }
    }

    /**
     * Funkcja do tworzenia przycisku o podanych wymiarach
     * @return zwraca przycisk
     */
    private static JButton createButton(String name, int x, int y, int width, int height) {
        JButton button = new JButton(name);
        if (x != -1) {
            button.setBounds(x, y, width, height);
        }
        return button;
    }

    /**
     * Fukcja do dodawania komponentów do panelu w określonej przez layout pozycji
     * @param panel Panel do którego zostaną dodane komponenty
     * @param layout Layout który ustawia elementy w panelu
     * @param x pozycja x komórki na stronie
     * @param y pozycja y komórki na stronie
     * @param top przesunięcie względem góry komórki
     * @param left przesunięcie względem lewej krawędzi komórki
     * @param bottom przesunięcie względem dolnej krawędzi komórki
     * @param right przesunięcie względem prawej krawędzi komórki
     * @param component Komponent dodawany do panelu
     */
    protected static void setLayoutAdd(JComponent panel, GridBagConstraints layout, int x, int y, int top, int left, int bottom, int right, JComponent component) {
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.ipady = 0;
        // layout.weighty=1;
        layout.weightx = 0;
        layout.insets = new Insets(top, left, bottom, right);
        layout.gridx = x;
        layout.gridy = y;
        panel.add(component, layout);
    }

    protected static void setLayoutAdd(JComponent panel, GridBagConstraints layout, int x, int y, int top, int left, int bottom, int right, JComponent component, int weigthy) {
        layout.fill = GridBagConstraints.NONE;
        layout.ipady = 0;
        layout.weighty = weigthy;
        layout.weightx = 0.5;
        layout.insets = new Insets(top, left, bottom, right);
        layout.gridx = x;
        layout.gridy = y;
        panel.add(component, layout);
    }

    protected static void setLayoutAdd(JComponent panel, GridBagConstraints layout, int x, int y, int top, int left, int bottom, int right, JComponent component, int weigthy, int widthx) {
        layout.fill = GridBagConstraints.NONE;
        layout.ipady = 0;
        layout.weighty = weigthy;
        layout.weightx = 0.5;
        layout.gridwidth = widthx;
        layout.insets = new Insets(top, left, bottom, right);
        layout.gridx = x;
        layout.gridy = y;
        panel.add(component, layout);
    }

    /**
     * Ustawianie parametrów panelu tekstowego i dodawanie go do panelu skrolującego
     * @param textPane Panel tekstu
     * @param sizex rozmiar x panelu
     * @param sizey rozmiar y panelu
     * @return zwraca panel skrolujący
     */
    protected static JScrollPane createTextArea(JComponent textPane, int sizex, int sizey) {
        Color paneColor = new Color(147, 205, 205);
        textPane.setBackground(paneColor);
        textPane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        JScrollPane editorScrollPane = new JScrollPane(textPane);
        editorScrollPane.setPreferredSize(new Dimension(sizex, sizey));
        editorScrollPane.setMinimumSize(new Dimension(sizex, sizey));

        return editorScrollPane;
    }

    /**
     * Funckja main aplikacji
     * @param args
     * @throws Exception wyrzuca wyjątek w przypadku błędnego połączenia się z bazą danch
     */
    public static void main(String[] args) throws Exception {

        Table.statement = Table.connectToDB();
        Table Osoby = new Table("ADRESY");
        JFrame okno = createWindow(1200, 700);
        okno.setResizable(false);
        JPanel primaWinPanel = new JPanel();
        mainPanel = Shelf.createShelf(tabbedPanel, "Panel główny", "Text", "Główny panel", "ikona1.gif");

        JButton butPrac = createButton("Pracownicy", -1, 0, 0, 0);
        JButton butAdd = createButton("Dodaj auta", -1, 0, 0, 0);
        JButton butStan = createButton("Pokaż auta na stanie", -1, 0, 0, 0);
        JButton butSprzed = createButton("Ostatnio sprzedane", -1, 0, 0, 0);
        JButton butKli = createButton("Klienci", -1, 0, 0, 0);
        JButton butGraf = createButton("Grafik", -1, 0, 0, 0);
        JButton butModEvt = createButton("Modyfikuj...", -1, 0, 0, 0);

        butPrac.setBackground(new Color(197, 205, 125));
        butAdd.setBackground(new Color(197, 205, 125));
        butStan.setBackground(new Color(197, 205, 125));
        butSprzed.setBackground(new Color(197, 205, 125));
        butKli.setBackground(new Color(197, 205, 125));
        butGraf.setBackground(new Color(197, 205, 125));

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints layout = new GridBagConstraints();

        JLabel lastMod = new JLabel("Ostatnie modyfikacje:");
        JLabel upcomingEvt = new JLabel("Nadchodzące wydarzenia:");
        JLabel chooseOptn = new JLabel("Wybierz czynność z poniższych:");
        Font font = new Font("Corbel", Font.BOLD, 20);
        chooseOptn.setFont(font);

        JTextPane textPaneMod = new JTextPane();
        textPaneMod.setEditable(false);
        textPaneMod.setText("Czesc sdfs\naaaa\naa\naa\naaa\naa\na\na\naaa\naa\na\na\na\naaa\naaa\naaaa\naaa\naas\ndfs\nfsdfsdf\n");
        JTextPane textPaneEvt = new JTextPane();
        textPaneEvt.setEditable(false);
        JScrollPane modifyArea = createTextArea(textPaneMod, 450, 300);
        JScrollPane eventsArea = createTextArea(textPaneEvt, 450, 200);

        setLayoutAdd(mainPanel, layout, 0, 0, -20, -200, 0, 20, chooseOptn);
        setLayoutAdd(mainPanel, layout, 0, 1, -300, -200, 0, -150, butPrac);
        setLayoutAdd(mainPanel, layout, 0, 2, -440, -200, 0, -150, butAdd);
        setLayoutAdd(mainPanel, layout, 0, 3, -480, -200, 0, -150, butStan);
        setLayoutAdd(mainPanel, layout, 0, 4, -480, -200, 0, -150, butSprzed);
        setLayoutAdd(mainPanel, layout, 0, 5, -280, -200, 0, -150, butKli);
        setLayoutAdd(mainPanel, layout, 0, 6, -50, -200, 20, -150, butGraf);
        setLayoutAdd(mainPanel, layout, 1, 0, 100, 400, 0, -200, lastMod);
        setLayoutAdd(mainPanel, layout, 1, 1, 0, 400, 0, -200, modifyArea);
        setLayoutAdd(mainPanel, layout, 1, 2, 30, 400, 0, -200, upcomingEvt);
        setLayoutAdd(mainPanel, layout, 1, 3, 0, 400, 0, -200, eventsArea);

        butPrac.setActionCommand("Workers");
        HandlerClass handlerWork = new HandlerClass(textPaneEvt);
        butPrac.addActionListener(handlerWork);

        butAdd.setActionCommand("addCar");
        HandlerClass handlerAdd = new HandlerClass(butAdd);
        butAdd.addActionListener(handlerAdd);

        butStan.setActionCommand("condition");
        HandlerClass handlerCondition = new HandlerClass(butStan);
        butStan.addActionListener(handlerCondition);

        butSprzed.setActionCommand("lastSelled");
        HandlerClass handlerSell = new HandlerClass(butSprzed);
        butSprzed.addActionListener(handlerSell);

        butKli.setActionCommand("Clients");
        HandlerClass handlerClients = new HandlerClass(butSprzed);
        butKli.addActionListener(handlerSell);

        JLabel logInfo = new JLabel("Zalogowano jako:");
        logInfo.setBounds(0, 0, 150, 60);
        JPanel panelLogInfo = new JPanel();
        panelLogInfo.add(logInfo);

        primaWinPanel.setLayout(new GridBagLayout());
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.weightx = 0.5;
        ;
        layout.insets = new Insets(100, 0, 0, 10);
        layout.gridx = 0;
        layout.gridwidth = 2;
        layout.gridy = 1;
        primaWinPanel.add(tabbedPanel, layout);

        layout.weightx = 0.5;
        layout.insets = new Insets(0, 900, 0, 10);
        layout.gridx = 1;
        layout.gridwidth = 1;
        layout.gridy = 0;
        primaWinPanel.add(panelLogInfo, layout);

        okno.add(primaWinPanel);
        okno.setVisible(true);
    }

}
