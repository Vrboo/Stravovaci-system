/*
 * Created by JFormDesigner on Fri Apr 23 20:16:11 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import java.awt.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import keeptoo.*;
import net.miginfocom.swing.*;
import sk.dominikvrbovsky.*;
import sk.dominikvrbovsky.dao.impl.MealDao;
import sk.dominikvrbovsky.dao.impl.TransactionDao;
import sk.dominikvrbovsky.dao.impl.UserDao;
import sk.dominikvrbovsky.utilities.DateUtilities;
import sk.dominikvrbovsky.utilities.FileUtilities;

/**
 * JFrame - User interface for administrators (Administration mode)
 */
public class AdministratorInterface extends JFrame {
    private final EntityManager entityManager;
    private final User user;
    private final CardLayout cardLayout;
    private final CardLayout cardLayoutObjednavky;
    private final CardLayout cardLayoutJedalnyListok;
    private String[][] breakfastMenu;
    private String[][] lunchMenu;
    private int counterForTransaction;
    private List<Transaction> transactions;
    private List<Transaction> transactionsForPrint;
    private final TransactionDao transactionDao;
    private final DateTimeFormatter timeFormatter;
    private final DateTimeFormatter dateFormatter;
    private JLabel[][] labelsInTransactionTable;

    public AdministratorInterface(EntityManager entityManager, User user) {
        this.entityManager = entityManager;
        this.user = user;
        this.breakfastMenu = null;
        this.lunchMenu = null;
        this.counterForTransaction = 0;
        this.transactions = null;
        this.transactionsForPrint = null;
        this.transactionDao = new TransactionDao(entityManager);
        timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        dateFormatter = DateTimeFormatter.ofPattern("dd.M.yyyy");

        this.setPreferredSize(new Dimension(1000, 600));

        initComponents();
        labelsInTransactionTable = getTransakcieArray55(panelTableTrans.getComponents());

        this.cardLayout = (CardLayout)(panelContent.getLayout());
        this.cardLayoutObjednavky = (CardLayout)(panelContentObjednavky.getLayout());
        this.cardLayoutJedalnyListok = (CardLayout)(panelJedalnyListok.getLayout());

        this.labelDatum.setText(DateUtilities.createSlovakDateString());

        btnJedalnyListok.setSelected(true);
        btnJedalnyListok.setBorder(new MatteBorder(0,5,0,0, new Color(50, 187, 186)));

        btnRanajky.setBorder(new MatteBorder(0, 0, 4, 0, new Color(52, 188, 183)));
        btnRanajky.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnRanajky.isSelected()) {
                    btnRanajky.setBorder(new MatteBorder(0, 0, 4, 0, new Color(52, 188, 183)));
                } else {
                    btnRanajky.setBorder(null);
                }
            }
        });

        btnObed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnObed.isSelected()) {
                    btnObed.setBorder(new MatteBorder(0, 0, 4, 0, new Color(52, 188, 183)));
                } else {
                    btnObed.setBorder(null);
                }
            }
        });
    }

    private void btnRanajkyActionPerformed() {
        cardLayoutObjednavky.show(panelContentObjednavky, "ranajky");
    }

    private void btnObedActionPerformed() {
        cardLayoutObjednavky.show(panelContentObjednavky, "obed");
    }

    private void btnObjednavkyActionPerformed() {
        MealDao mealDao = new MealDao(entityManager);
        List<Breakfast> breakfasts;
        List<Lunch> lunches;

        try {
            breakfasts = mealDao.getAllBreakfast();
            lunches = mealDao.getAllLunch();
        } catch (Exception e) {
            labelWarningPocetObjednavkyRanajky.setText("Nepodarilo sa správne načítať objednávky");
            labelWarningPocetObjednavkyObed.setText("Nepodarilo sa správne načítať objednávky");
            cardLayout.show(panelContent, "objednavky");
            return;
        }

        JLabel[][] labelsRanajky = getObjednavkyArray(panelTableRanajky.getComponents());
        JLabel[][] labelsObed = getObjednavkyArray(panelTableObed.getComponents());

        int index = 0;
        for (Breakfast breakfast : breakfasts) {
            labelsRanajky[index][0].setText(breakfast.getName());
            labelsRanajky[index][1].setText(breakfast.getDrink().getDrink());
            labelsRanajky[index][2].setText(breakfast.getNumberOfOrder() + "x");

            index++;
        }

        index = 0;
        for (Lunch lunch : lunches) {
            labelsObed[index][0].setText(lunch.getName());
            labelsObed[index][1].setText(lunch.isTakeaway() ? "Áno" : "Nie");
            labelsObed[index][2].setText(lunch.getNumberOfOrder() + "x");

            index++;
        }

        cardLayout.show(panelContent, "objednavky");
    }

    private JLabel[][] getObjednavkyArray(Component[] labelsParam) {
        JLabel[][] labels = new JLabel[5][3];
        int index = 5;

        for (int i = 0; i < labels.length; i++) {
            for (int j = 0 ; j < labels[i].length; j++) {
                labels[i][j] = (JLabel) labelsParam[index];
                index++;
                if (index % 4 == 0) index++;
            }
        }

        return labels;
    }

    private void clearTxtFields(Component[] txtFieldsParam) {
        int index = 6;

        while (index < txtFieldsParam.length) {
            if (txtFieldsParam[index] instanceof JPanel) {
                ((JComboBox<String>)((JPanel)txtFieldsParam[index]).getComponent(0)).setSelectedIndex(-1);
            } else {
                ((JTextField) txtFieldsParam[index]).setText("");
            }
            index++;
            if (index % 5 == 0) index++;
        }

    }

    private void btnJedalnyListokActionPerformed() {
        labelWarningJedLisVytvorit.setText("");
        labelWarningJedLisRanajky.setText("");
        labelWarningJedLisObed.setText("");
        clearTxtFields(panelJedalnyListokRanajkyInside.getComponents());
        clearTxtFields(panelJedalnyListokObedInside.getComponents());
        cardLayout.show(panelContent, "jedalnyListok");
        cardLayoutJedalnyListok.show(panelJedalnyListok, "ranajky");
    }

    private void labelXMouseClicked() {
        entityManager.close();
        System.exit(0);
    }

    private void kButton4ActionPerformed() {

        this.breakfastMenu = createMenuArray(panelJedalnyListokRanajkyInside.getComponents());
        if (this.breakfastMenu != null) {
            cardLayoutJedalnyListok.show(panelJedalnyListok, "obed");
            labelWarningJedLisRanajky.setText("");
        } else {
            labelWarningJedLisRanajky.setText("Vyplňte všetky položky, prosím");
        }
    }

    private String[][] createMenuArray(Component[] c) {
        String[][] breakfastMenu = new String[5][4];
        int index = 6;

        for (int i = 0; i < breakfastMenu.length; i++) {
            for (int j = 0; j < breakfastMenu[i].length; j++ ) {
                if (c[index] instanceof JPanel) {

                    breakfastMenu[i][j] = (String)((JComboBox<String>)((JPanel)c[index]).getComponent(0)).getSelectedItem();
                } else {
                    breakfastMenu[i][j] = ((JTextField)c[index]).getText();
                }

                if (breakfastMenu[i][j] == null || breakfastMenu[i][j].equals("")) {
                    return null;
                }

                index++;
                if (index % 5 == 0) index++;
            }
        }
        return breakfastMenu;
    }

    private void btnJedalnyListokSpatObedActionPerformed() {
        cardLayoutJedalnyListok.show(panelJedalnyListok, "ranajky");
    }

    private void btnJedalnyListokPokracovatObedActionPerformed() {
        this.lunchMenu = createMenuArray(panelJedalnyListokObedInside.getComponents());
        if (this.lunchMenu != null) {
            cardLayoutJedalnyListok.show(panelJedalnyListok, "vytvorit");
            labelWarningJedLisObed.setText("");
        } else {
            labelWarningJedLisObed.setText("Vyplňte všetky položky, prosím");
        }
    }

    private void btnJedalnyListokVytvoritInsideActionPerformed() {
        cardLayoutJedalnyListok.show(panelJedalnyListok, "obed");
    }

    private void frmterJedLisRanakKapacita1KeyTyped(KeyEvent e) {
        if (!Character.isDigit(e.getKeyChar())) e.consume();
    }

    private void frmterJedLisRanakCena1KeyTyped(KeyEvent e) {
        JTextField jtxtFiled = (JTextField)e.getComponent();

        if (jtxtFiled.getText().contains(".") || jtxtFiled.getText().equals("")) {
            if (!Character.isDigit(e.getKeyChar()) )
                e.consume();
        } else {
            if (!Character.isDigit(e.getKeyChar()) && Character.valueOf(e.getKeyChar()) != Character.valueOf('.'))
                e.consume();
        }
    }

    private void frmterJedLisRanakCena1FocusLost(FocusEvent e) {
        JTextField jtxtFiled = (JTextField)e.getComponent();
        
        if (jtxtFiled.getText().endsWith(".")) jtxtFiled.setText(jtxtFiled.getText() + "00");
    }

    /**
     * Not ideal solution - I am going to fix it in the future.
     */
    private void btnJedalnyListokVytvoritInside2ActionPerformed(ActionEvent e) {
        MealDao mealDao = new MealDao(entityManager);
        UserDao userDao = new UserDao(entityManager);

        for (User user: userDao.getAll()) {
            user.getOrders().clear();
            userDao.update(user);
        }

        try {
            mealDao.deleteAllMealAndOrder();
        } catch (Exception e1) {
            labelWarningJedLisVytvorit.setText("Nepodarilo sa vytvoriť nový jedálny lístok. Skúste to znovu.");
            return;
        }


        List<Meal> meals = new ArrayList<>();

        for (int i = 0; i < this.breakfastMenu.length ; i++) {
            String name = breakfastMenu[i][0];
            String drink = breakfastMenu[i][1];
            int capacity = Integer.parseInt(breakfastMenu[i][2]);
            double price = Double.parseDouble(breakfastMenu[i][3]);
                meals.add(new Breakfast(name, price, capacity, drink));
        }

        for (int i = 0; i < this.lunchMenu.length ; i++) {
            String name = lunchMenu[i][0];
            String takeaway = lunchMenu[i][1];
            int capacity = Integer.parseInt(lunchMenu[i][2]);
            double price = Double.parseDouble(lunchMenu[i][3]);
            meals.add(new Lunch(name, price, capacity, takeaway));
        }
        
        try {
            mealDao.saveAll(meals);
            labelWarningJedLisVytvorit.setForeground(new Color(73, 196, 174));
            labelWarningJedLisVytvorit.setText("Nový jedálny lístok bol úspešne vytvorený.");
        } catch (Exception ee) {
            labelWarningJedLisVytvorit.setForeground(Color.RED);
            labelWarningJedLisVytvorit.setText("Nepodarilo sa vytvoriť nový jedálny lístok. Skúste to znovu.");
        }
        
    }

    private void btnPouzivatelActionPerformed(ActionEvent e) {
        JFrame jFrame = new UserInterface(entityManager, user);
        jFrame.setVisible(true);
        this.dispose();
    }

    private void btnTransakcieActionPerformed() {
        comboBoxZobrazitActionPerformed();
        cardLayout.show(panelContent,"transakcie");
    }

    private void comboBoxZobrazitActionPerformed() {
        boolean descending = true; // ordering of transactions from latest oldest; default value in comboBox
        if (comboBoxZoradit.getSelectedIndex() == 1) descending = false; // ordering of transacation from oldest to latest

        try {
            if (comboBoxZobrazit.getSelectedIndex() == 0) {
                transactions = transactionDao.getAllTransactionsByParameters(descending);
            } else if (comboBoxZobrazit.getSelectedIndex() == 1) {
                transactions = transactionDao.getAllTransactionsByParameters(descending, "Vklad");
            } else {
                transactions = transactionDao.getAllTransactionsByParameters(descending, "Výber");
            }
        } catch (Exception e) {
            transactions = null;
            getTransakcieArray55(panelTableTrans.getComponents());
            transakciaTyp1.setText("Transakcie sa nepodarilo načítať");
            btnExportovat.setVisible(false);
            btnDalsieTransakcie.setVisible(false);
            btnSpatTransakcie.setVisible(false);
            return;
        }
        this.counterForTransaction = 0;

        if (fielCeleMeno.getText().equals("Celé meno užívateľa")) {
            transactionsForPrint = transactions;
            btnDalsieTransakcieActionPerformed();
        } else {
            fielCeleMenoKeyReleased();
        }
    }

    private void fielCeleMenoKeyReleased() {
        if (transactions == null) return;
        transactionsForPrint = transactions.stream()
                .filter(transaction1 -> transaction1.getUser().getFullName().contains(fielCeleMeno.getText()))
                .collect(Collectors.toList());

        this.counterForTransaction = 0;
        btnDalsieTransakcieActionPerformed();
    }

    private void btnDalsieTransakcieActionPerformed() {
        this.labelsInTransactionTable = getTransakcieArray55(panelTableTrans.getComponents());
        labelZiadneTransakcie.setText("");
        int x = counterForTransaction + 5;
        int i = 0;

        if (transactionsForPrint.size() == 0) {
            transakciaTyp1.setText("Nenašli sa žiadne transakcie");
            btnExportovat.setVisible(false);
        } else {
            btnExportovat.setVisible(true);
        }

        while ((counterForTransaction < x) && (counterForTransaction != transactionsForPrint.size())) {
            labelsInTransactionTable[i][0].setText(transactionsForPrint.get(counterForTransaction).getUser().getFullName());
            labelsInTransactionTable[i][1].setText(transactionsForPrint.get(counterForTransaction).getTransactionType().getTransactionType());
            labelsInTransactionTable[i][2].setText(transactionsForPrint.get(counterForTransaction).getDateTime().toLocalDate().format(dateFormatter));
            labelsInTransactionTable[i][3].setText(transactionsForPrint.get(counterForTransaction).getDateTime().toLocalTime().format(timeFormatter));
            labelsInTransactionTable[i][4].setText(transactionsForPrint.get(counterForTransaction).getAmountString() + "€");
            for (int j = 0; j < 5; j++) labelsInTransactionTable[i][j].setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
            counterForTransaction++;
            i++;
        }

        btnDalsieTransakcie.setVisible(counterForTransaction != transactionsForPrint.size());
        btnSpatTransakcie.setVisible(counterForTransaction > 5);
    }

    private void btnSpatTransakcieActionPerformed() {
        if (counterForTransaction % 5 != 0) {
            this.counterForTransaction = counterForTransaction - (5 + (counterForTransaction % 5));
        } else {
            this.counterForTransaction -= 10;
        }

       btnDalsieTransakcieActionPerformed();
    }

    private JLabel[][] getTransakcieArray55(Component[] labelsParam) {
        JLabel[][] labels = new JLabel[5][5];
        int index = 5;

        for (int i = 0; i < labels.length; i++) {
            for (int j = 0 ; j < labels[i].length; j++) {
                labels[i][j] = (JLabel) labelsParam[index];
                labels[i][j].setBorder(null);
                labels[i][j].setText("");
                index++;
            }
        }
        return labels;
    }

    private void fielCeleMenoFocusGained() {
        if (fielCeleMeno.getText().equals("Celé meno užívateľa")) {
            fielCeleMeno.setForeground(Color.BLACK);
            fielCeleMeno.setText("");
        }
    }

    private void fielCeleMenoFocusLost() {
        if (fielCeleMeno.getText().equals("")) {
            fielCeleMeno.setForeground(new Color(192,192,192));
            fielCeleMeno.setText("Celé meno užívateľa");
        }
    }

    private void btnExportovatActionPerformed() {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Vyberte textový súbor (.txt)");
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter restrict = new FileNameExtensionFilter(".txt súbor", "txt");
        fileChooser.addChoosableFileFilter(restrict);

        int r = fileChooser.showSaveDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {
            try {
                FileUtilities.saveTransactionsInFileForAdmin(fileChooser.getSelectedFile(), transactionsForPrint);
                labelZiadneTransakcie.setForeground(new Color(0, 202, 197));
                labelZiadneTransakcie.setText("Export úspešný");
            } catch (Exception e) {
                labelZiadneTransakcie.setForeground(Color.red);
                labelZiadneTransakcie.setText("Export zlyhal ");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovský
        splitPane1 = new JSplitPane();
        panelMenu = new KGradientPanel();
        labelIcon = new JLabel();
        labelAdministrator = new JLabel();
        btnObjednavky = new KButton();
        btnJedalnyListok = new KButton();
        btnTransakcie = new KButton();
        btnPouzivatel = new KButton();
        panelRightSide = new KGradientPanel();
        splitPane2 = new JSplitPane();
        panelStravovaciSystem = new KGradientPanel();
        labelStravovaciSystem = new JLabel();
        labelDatum = new JLabel();
        labelX = new JLabel();
        label4 = new JLabel();
        panelContent = new KGradientPanel();
        panelJedalnyListok = new KGradientPanel();
        panelJedalnyListokRanajky = new KGradientPanel();
        label2 = new JLabel();
        panelJedalnyListokRanajkyInside = new KGradientPanel();
        label40 = new JLabel();
        label3 = new JLabel();
        label28 = new JLabel();
        label29 = new JLabel();
        label30 = new JLabel();
        label59 = new JLabel();
        txtJedLisRanajkyNazov1 = new JTextField();
        panel5 = new JPanel();
        comBoxJedLisRanajkyNapoj1 = new JComboBox<>();
        txtJedLisRanakKapacita1 = new JTextField();
        txtJedLisRanakCena1 = new JTextField();
        label44 = new JLabel();
        txtJedLisRanajkyNazov2 = new JTextField();
        panel4 = new JPanel();
        comBoxJedLisRanajkyNapoj2 = new JComboBox<>();
        txtJedLisRanakKapacita2 = new JTextField();
        txtJedLisRanakCena2 = new JTextField();
        label73 = new JLabel();
        txtJedLisRanajkyNazov3 = new JTextField();
        panel3 = new JPanel();
        comBoxJedLisRanajkyNapoj3 = new JComboBox<>();
        txtJedLisRanakKapacita3 = new JTextField();
        txtJedLisRanakCena3 = new JTextField();
        label78 = new JLabel();
        txtJedLisRanajkyNazov4 = new JTextField();
        panel2 = new JPanel();
        comBoxJedLisRanajkyNapoj4 = new JComboBox<>();
        txtJedLisRanakKapacita4 = new JTextField();
        txtJedLisRanakCena4 = new JTextField();
        label83 = new JLabel();
        txtJedLisRanajkyNazov5 = new JTextField();
        panel1 = new JPanel();
        comBoxJedLisRanajkyNapoj5 = new JComboBox<>();
        txtJedLisRanakKapacita5 = new JTextField();
        txtJedLisRanakCena5 = new JTextField();
        labelWarningJedLisRanajky = new JLabel();
        btnJedLisRanjakyPokracovat = new KButton();
        panelJedalnyListokObed = new KGradientPanel();
        label7 = new JLabel();
        panelJedalnyListokObedInside = new KGradientPanel();
        label72 = new JLabel();
        label10 = new JLabel();
        label75 = new JLabel();
        label76 = new JLabel();
        label77 = new JLabel();
        label80 = new JLabel();
        textField8 = new JTextField();
        panel6 = new JPanel();
        comboBox12 = new JComboBox<>();
        textField45 = new JTextField();
        textField46 = new JTextField();
        label81 = new JLabel();
        textField47 = new JTextField();
        panel7 = new JPanel();
        comboBox13 = new JComboBox<>();
        textField48 = new JTextField();
        textField49 = new JTextField();
        label82 = new JLabel();
        textField50 = new JTextField();
        panel8 = new JPanel();
        comboBox14 = new JComboBox<>();
        textField51 = new JTextField();
        textField52 = new JTextField();
        label85 = new JLabel();
        textField53 = new JTextField();
        panel9 = new JPanel();
        comboBox15 = new JComboBox<>();
        textField54 = new JTextField();
        textField55 = new JTextField();
        label86 = new JLabel();
        textField56 = new JTextField();
        panel10 = new JPanel();
        comboBox16 = new JComboBox<>();
        textField57 = new JTextField();
        textField58 = new JTextField();
        btnJedalnyListokSpatObed = new KButton();
        labelWarningJedLisObed = new JLabel();
        btnJedLisObedPokracovat = new KButton();
        panelJedalnyListokVytvorit = new KGradientPanel();
        panelJedalnyListokInside = new KGradientPanel();
        labelJedalnyListokVytvoritInisde = new JLabel();
        btnJedalnyListokVytvoritInside = new KButton();
        btnJedalnyListokVytvoritInside2 = new KButton();
        labelWarningJedLisVytvorit = new JLabel();
        panelObjednavky = new KGradientPanel();
        splitPane3 = new JSplitPane();
        panelMenuObjednavky = new KGradientPanel();
        btnRanajky = new KButton();
        btnObed = new KButton();
        panelContentObjednavky = new KGradientPanel();
        panelObjednavkyRanajky = new KGradientPanel();
        panelTableRanajky = new KGradientPanel();
        label36 = new JLabel();
        label1 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label46 = new JLabel();
        labelObjednavkyRanajkyNazov1 = new JLabel();
        labelObjednavkyRanajkyNapoj1 = new JLabel();
        labelObjednavkyRanajkyPocet1 = new JLabel();
        label32 = new JLabel();
        labelObjednavkyRanajkyNazov2 = new JLabel();
        labelObjednavkyRanajkyNapoj2 = new JLabel();
        labelObjednavkyRanajkyPocet2 = new JLabel();
        label33 = new JLabel();
        labelObjednavkyRanajkyNazov3 = new JLabel();
        labelObjednavkyRanajkyNapoj3 = new JLabel();
        labelObjednavkyRanajkyPocet3 = new JLabel();
        label34 = new JLabel();
        labelObjednavkyRanajkyNazov4 = new JLabel();
        labelObjednavkyRanajkyNapoj4 = new JLabel();
        labelObjednavkyRanajkyPocet4 = new JLabel();
        label35 = new JLabel();
        labelObjednavkyRanajkyNazov5 = new JLabel();
        labelObjednavkyRanajkyNapoj5 = new JLabel();
        labelObjednavkyRanajkyPocet5 = new JLabel();
        labelWarningPocetObjednavkyRanajky = new JLabel();
        panelObjednavkyObed = new KGradientPanel();
        panelTableObed = new KGradientPanel();
        label38 = new JLabel();
        label21 = new JLabel();
        label24 = new JLabel();
        label39 = new JLabel();
        label47 = new JLabel();
        labelObjednavkyObedNazov1 = new JLabel();
        labelObjednavkyObedTakeway1 = new JLabel();
        labelObjednavkyObedPocet1 = new JLabel();
        label45 = new JLabel();
        labelObjednavkyObedNazov2 = new JLabel();
        labelObjednavkyObedTakeway2 = new JLabel();
        labelObjednavkyObedPocet2 = new JLabel();
        label54 = new JLabel();
        labelObjednavkyObedNazov3 = new JLabel();
        labelObjednavkyObedTakeway3 = new JLabel();
        labelObjednavkyObedPocet3 = new JLabel();
        label60 = new JLabel();
        labelObjednavkyObedNazov4 = new JLabel();
        labelObjednavkyObedTakeway4 = new JLabel();
        labelObjednavkyObedPocet4 = new JLabel();
        label65 = new JLabel();
        labelObjednavkyObedNazov5 = new JLabel();
        labelObjednavkyObedTakeway5 = new JLabel();
        labelObjednavkyObedPocet5 = new JLabel();
        labelWarningPocetObjednavkyObed = new JLabel();
        panelTransakcie = new KGradientPanel();
        panelForCombosInTrans = new KGradientPanel();
        labelZobrazit2 = new JLabel();
        fielCeleMeno = new JTextField();
        labelZiadneTransakcie = new JLabel();
        labelZobrazit = new JLabel();
        comboBoxZobrazit = new JComboBox<>();
        labelZoradit = new JLabel();
        comboBoxZoradit = new JComboBox<>();
        panelTableTrans = new KGradientPanel();
        label13 = new JLabel();
        label6 = new JLabel();
        label5 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        transakciaPouzivatel1 = new JLabel();
        transakciaTyp1 = new JLabel();
        transakciaDatum1 = new JLabel();
        transakciaCas1 = new JLabel();
        transakciaSuma1 = new JLabel();
        transakciaPouzivatel2 = new JLabel();
        transakciaTyp2 = new JLabel();
        transakciaDatum2 = new JLabel();
        transakciaCas2 = new JLabel();
        transakciaSuma2 = new JLabel();
        transakciaPouzivatel3 = new JLabel();
        transakciaTyp3 = new JLabel();
        transakciaDatum3 = new JLabel();
        transakciaCas3 = new JLabel();
        transakciaSuma3 = new JLabel();
        transakciaPouzivatel4 = new JLabel();
        transakciaTyp4 = new JLabel();
        transakciaDatum4 = new JLabel();
        transakciaCas4 = new JLabel();
        transakciaSuma4 = new JLabel();
        transakciaPouzivatel5 = new JLabel();
        transakciaTyp5 = new JLabel();
        transakciaDatum5 = new JLabel();
        transakciaCas5 = new JLabel();
        transakciaSuma5 = new JLabel();
        kGradientPanel2 = new KGradientPanel();
        btnSpatTransakcie = new KButton();
        btnExportovat = new KButton();
        btnDalsieTransakcie = new KButton();

        //======== this ========
        setUndecorated(true);
        setTitle("Stravovac\u00ed syst\u00e9m");
        setIconImage(new ImageIcon(getClass().getResource("/icons/icons8_food_32px_1.png")).getImage());
        var contentPane = getContentPane();

        //======== splitPane1 ========
        {
            splitPane1.setDividerSize(0);
            splitPane1.setBorder(null);
            splitPane1.setDividerLocation(225);

            //======== panelMenu ========
            {
                panelMenu.setBorder(null);
                panelMenu.setkBorderRadius(0);
                panelMenu.setkStartColor(new Color(55, 55, 55));
                panelMenu.setkEndColor(new Color(55, 55, 55));
                panelMenu.setBackground(new Color(55, 55, 55));
                panelMenu.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
                .swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing
                .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
                Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red
                ),panelMenu. getBorder()));panelMenu. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
                public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName(
                )))throw new RuntimeException();}});

                //---- labelIcon ----
                labelIcon.setHorizontalAlignment(SwingConstants.CENTER);
                labelIcon.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_user_shield_85px_5.png")));

                //---- labelAdministrator ----
                labelAdministrator.setHorizontalAlignment(SwingConstants.CENTER);
                labelAdministrator.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                labelAdministrator.setForeground(new Color(50, 187, 186));
                labelAdministrator.setText("Administr\u00e1tor");

                //---- btnObjednavky ----
                btnObjednavky.setText("Po\u010det objedn\u00e1vok");
                btnObjednavky.setkBorderRadius(0);
                btnObjednavky.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnObjednavky.setkEndColor(new Color(55, 55, 55));
                btnObjednavky.setkStartColor(new Color(55, 55, 55));
                btnObjednavky.setBorder(null);
                btnObjednavky.setkHoverEndColor(Color.gray);
                btnObjednavky.setkHoverStartColor(new Color(55, 55, 55));
                btnObjednavky.setkHoverForeGround(Color.white);
                btnObjednavky.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnObjednavky.setkAllowTab(true);
                btnObjednavky.setkSelectedColor(new Color(67, 67, 67));
                btnObjednavky.setkIndicatorColor(new Color(50, 187, 186));
                btnObjednavky.setkIndicatorThickness(5);
                btnObjednavky.addActionListener(e -> btnObjednavkyActionPerformed());

                //---- btnJedalnyListok ----
                btnJedalnyListok.setText("Nov\u00fd jed\u00e1lny l\u00edstok");
                btnJedalnyListok.setkBorderRadius(0);
                btnJedalnyListok.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnJedalnyListok.setkEndColor(new Color(55, 55, 55));
                btnJedalnyListok.setkStartColor(new Color(55, 55, 55));
                btnJedalnyListok.setBorder(null);
                btnJedalnyListok.setkHoverEndColor(Color.gray);
                btnJedalnyListok.setkHoverStartColor(new Color(55, 55, 55));
                btnJedalnyListok.setkHoverForeGround(Color.white);
                btnJedalnyListok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnJedalnyListok.setkAllowTab(true);
                btnJedalnyListok.setkSelectedColor(new Color(67, 67, 67));
                btnJedalnyListok.setkIndicatorColor(new Color(50, 187, 186));
                btnJedalnyListok.setkIndicatorThickness(5);
                btnJedalnyListok.addActionListener(e -> btnJedalnyListokActionPerformed());

                //---- btnTransakcie ----
                btnTransakcie.setText("Transakcie");
                btnTransakcie.setkBorderRadius(0);
                btnTransakcie.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnTransakcie.setkEndColor(new Color(55, 55, 55));
                btnTransakcie.setkStartColor(new Color(55, 55, 55));
                btnTransakcie.setBorder(null);
                btnTransakcie.setkHoverEndColor(Color.gray);
                btnTransakcie.setkHoverStartColor(new Color(55, 55, 55));
                btnTransakcie.setkHoverForeGround(Color.white);
                btnTransakcie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnTransakcie.setkAllowTab(true);
                btnTransakcie.setkSelectedColor(new Color(67, 67, 67));
                btnTransakcie.setkIndicatorColor(new Color(50, 187, 186));
                btnTransakcie.setkIndicatorThickness(5);
                btnTransakcie.addActionListener(e -> btnTransakcieActionPerformed());

                //---- btnPouzivatel ----
                btnPouzivatel.setText("Pou\u017e\u00edvate\u013e");
                btnPouzivatel.setkBorderRadius(0);
                btnPouzivatel.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnPouzivatel.setkEndColor(new Color(55, 55, 55));
                btnPouzivatel.setkStartColor(new Color(55, 55, 55));
                btnPouzivatel.setBorder(null);
                btnPouzivatel.setkHoverEndColor(Color.gray);
                btnPouzivatel.setkHoverStartColor(new Color(55, 55, 55));
                btnPouzivatel.setkForeGround(Color.lightGray);
                btnPouzivatel.setkIndicatorThickness(5);
                btnPouzivatel.setkHoverForeGround(new Color(0, 202, 197));
                btnPouzivatel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnPouzivatel.setkSelectedColor(new Color(67, 67, 67));
                btnPouzivatel.setkAllowTab(true);
                btnPouzivatel.setkIndicatorColor(new Color(50, 187, 186));
                btnPouzivatel.addActionListener(e -> btnPouzivatelActionPerformed(e));

                GroupLayout panelMenuLayout = new GroupLayout(panelMenu);
                panelMenu.setLayout(panelMenuLayout);
                panelMenuLayout.setHorizontalGroup(
                    panelMenuLayout.createParallelGroup()
                        .addGroup(panelMenuLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelMenuLayout.createParallelGroup()
                                .addComponent(labelIcon, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelAdministrator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnTransakcie, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                .addComponent(btnObjednavky, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                .addComponent(btnJedalnyListok, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                .addComponent(btnPouzivatel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
                );
                panelMenuLayout.setVerticalGroup(
                    panelMenuLayout.createParallelGroup()
                        .addGroup(panelMenuLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(labelIcon)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelAdministrator)
                            .addGap(44, 44, 44)
                            .addComponent(btnJedalnyListok, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnObjednavky, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnTransakcie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                            .addComponent(btnPouzivatel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38))
                );
            }
            splitPane1.setLeftComponent(panelMenu);

            //======== panelRightSide ========
            {
                panelRightSide.setkEndColor(new Color(192, 248, 213));
                panelRightSide.setkStartColor(new Color(115, 224, 255));
                panelRightSide.setkBorderRadius(0);

                //======== splitPane2 ========
                {
                    splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
                    splitPane2.setBorder(null);
                    splitPane2.setDividerSize(0);
                    splitPane2.setDividerLocation(155);

                    //======== panelStravovaciSystem ========
                    {
                        panelStravovaciSystem.setBorder(null);
                        panelStravovaciSystem.setkBorderRadius(0);
                        panelStravovaciSystem.setkStartColor(new Color(38, 184, 190));
                        panelStravovaciSystem.setkEndColor(new Color(150, 223, 141));
                        panelStravovaciSystem.setkGradientFocus(600);
                        panelStravovaciSystem.setBackground(new Color(107, 209, 158));

                        //---- labelStravovaciSystem ----
                        labelStravovaciSystem.setText("Stravovac\u00ed syst\u00e9m");
                        labelStravovaciSystem.setFont(new Font("Yu Gothic UI", Font.BOLD, 45));
                        labelStravovaciSystem.setHorizontalAlignment(SwingConstants.LEFT);
                        labelStravovaciSystem.setForeground(new Color(70, 70, 70));

                        //---- labelDatum ----
                        labelDatum.setText("Utorok, 20. apr\u00edl 2021");
                        labelDatum.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
                        labelDatum.setForeground(new Color(70, 70, 70));
                        labelDatum.setHorizontalAlignment(SwingConstants.LEFT);

                        //---- labelX ----
                        labelX.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_x_18px.png")));
                        labelX.setHorizontalAlignment(SwingConstants.CENTER);
                        labelX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        labelX.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                labelXMouseClicked();
                            }
                        });

                        //---- label4 ----
                        label4.setText("created by Dominik Vrbovsk\u00fd");
                        label4.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 17));
                        label4.setForeground(new Color(70, 70, 70));

                        GroupLayout panelStravovaciSystemLayout = new GroupLayout(panelStravovaciSystem);
                        panelStravovaciSystem.setLayout(panelStravovaciSystemLayout);
                        panelStravovaciSystemLayout.setHorizontalGroup(
                            panelStravovaciSystemLayout.createParallelGroup()
                                .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addGroup(panelStravovaciSystemLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelStravovaciSystem, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelDatum, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelStravovaciSystemLayout.createParallelGroup()
                                        .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                            .addGap(0, 362, Short.MAX_VALUE)
                                            .addComponent(labelX, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 155, Short.MAX_VALUE))))
                        );
                        panelStravovaciSystemLayout.setVerticalGroup(
                            panelStravovaciSystemLayout.createParallelGroup()
                                .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                    .addComponent(labelX, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                    .addContainerGap(20, Short.MAX_VALUE)
                                    .addGroup(panelStravovaciSystemLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelStravovaciSystem)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(labelDatum)
                                    .addGap(32, 32, 32))
                        );
                    }
                    splitPane2.setTopComponent(panelStravovaciSystem);

                    //======== panelContent ========
                    {
                        panelContent.setLayout(new CardLayout());

                        //======== panelJedalnyListok ========
                        {
                            panelJedalnyListok.setBackground(new Color(55, 55, 55));
                            panelJedalnyListok.setLayout(new CardLayout());

                            //======== panelJedalnyListokRanajky ========
                            {
                                panelJedalnyListokRanajky.setkEndColor(Color.white);
                                panelJedalnyListokRanajky.setkStartColor(Color.white);
                                panelJedalnyListokRanajky.setkBorderRadius(0);
                                panelJedalnyListokRanajky.setkGradientFocus(600);
                                panelJedalnyListokRanajky.setBorder(null);
                                panelJedalnyListokRanajky.setBackground(Color.white);
                                panelJedalnyListokRanajky.setkFillBackground(false);
                                panelJedalnyListokRanajky.setLayout(new MigLayout(
                                    "insets 0,novisualpadding,hidemode 3,align center center,gapy 15",
                                    // columns
                                    "[fill]",
                                    // rows
                                    "[33:n,fill]" +
                                    "[fill]" +
                                    "[32,fill]"));

                                //---- label2 ----
                                label2.setText("Vytvorte ranajkov\u00e9 menu");
                                label2.setHorizontalAlignment(SwingConstants.CENTER);
                                label2.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
                                label2.setForeground(new Color(55, 55, 55));
                                label2.setBorder(null);
                                panelJedalnyListokRanajky.add(label2, "cell 0 0");

                                //======== panelJedalnyListokRanajkyInside ========
                                {
                                    panelJedalnyListokRanajkyInside.setkEndColor(Color.white);
                                    panelJedalnyListokRanajkyInside.setkStartColor(Color.white);
                                    panelJedalnyListokRanajkyInside.setBorder(null);
                                    panelJedalnyListokRanajkyInside.setkBorderRadius(0);
                                    panelJedalnyListokRanajkyInside.setBackground(new Color(255, 255, 255, 145));
                                    panelJedalnyListokRanajkyInside.setLayout(new FormLayout(
                                        "27px, 312px, 126px, 90px, 89px",
                                        "fill:49px, 5*(fill:52px)"));

                                    //---- label40 ----
                                    label40.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label40, CC.xy(1, 1));

                                    //---- label3 ----
                                    label3.setText("Ra\u0148ajky");
                                    label3.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label3.setHorizontalAlignment(SwingConstants.CENTER);
                                    label3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label3, CC.xy(2, 1));

                                    //---- label28 ----
                                    label28.setText("N\u00e1poj");
                                    label28.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label28.setHorizontalAlignment(SwingConstants.CENTER);
                                    label28.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label28, CC.xy(3, 1));

                                    //---- label29 ----
                                    label29.setText("Kapacita");
                                    label29.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label29.setHorizontalAlignment(SwingConstants.CENTER);
                                    label29.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    label29.setBackground(Color.white);
                                    panelJedalnyListokRanajkyInside.add(label29, CC.xy(4, 1));

                                    //---- label30 ----
                                    label30.setText("Cena");
                                    label30.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label30.setHorizontalAlignment(SwingConstants.CENTER);
                                    label30.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label30, CC.xy(5, 1));

                                    //---- label59 ----
                                    label59.setText("1.");
                                    label59.setHorizontalAlignment(SwingConstants.CENTER);
                                    label59.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label59.setBorder(new MatteBorder(0, 1, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label59, CC.xy(1, 2));

                                    //---- txtJedLisRanajkyNazov1 ----
                                    txtJedLisRanajkyNazov1.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanajkyNazov1.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanajkyNazov1.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanajkyNazov1, CC.xy(2, 2));

                                    //======== panel5 ========
                                    {
                                        panel5.setBackground(Color.white);
                                        panel5.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                        panel5.setLayout(new GridBagLayout());

                                        //---- comBoxJedLisRanajkyNapoj1 ----
                                        comBoxJedLisRanajkyNapoj1.setBorder(null);
                                        comBoxJedLisRanajkyNapoj1.setBackground(Color.lightGray);
                                        comBoxJedLisRanajkyNapoj1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                        comBoxJedLisRanajkyNapoj1.setModel(new DefaultComboBoxModel<>(new String[] {
                                            "Cola",
                                            "Min. voda",
                                            "\u010caj",
                                            "D\u017e\u00fas"
                                        }));
                                        comBoxJedLisRanajkyNapoj1.setSelectedIndex(-1);
                                        panel5.add(comBoxJedLisRanajkyNapoj1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(9, 10, 9, 10), 0, 0));
                                    }
                                    panelJedalnyListokRanajkyInside.add(panel5, CC.xy(3, 2));

                                    //---- txtJedLisRanakKapacita1 ----
                                    txtJedLisRanakKapacita1.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanakKapacita1.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakKapacita1.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakKapacita1.setColumns(5);
                                    txtJedLisRanakKapacita1.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakKapacita1KeyTyped(e);
                                        }
                                    });
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanakKapacita1, CC.xy(4, 2));

                                    //---- txtJedLisRanakCena1 ----
                                    txtJedLisRanakCena1.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    txtJedLisRanakCena1.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakCena1.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakCena1.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakCena1KeyTyped(e);
                                        }
                                    });
                                    txtJedLisRanakCena1.addFocusListener(new FocusAdapter() {
                                        @Override
                                        public void focusLost(FocusEvent e) {
                                            frmterJedLisRanakCena1FocusLost(e);
                                        }
                                    });
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanakCena1, CC.xy(5, 2));

                                    //---- label44 ----
                                    label44.setText("2.");
                                    label44.setHorizontalAlignment(SwingConstants.CENTER);
                                    label44.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label44.setBorder(new MatteBorder(0, 1, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label44, CC.xy(1, 3));

                                    //---- txtJedLisRanajkyNazov2 ----
                                    txtJedLisRanajkyNazov2.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanajkyNazov2.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanajkyNazov2.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanajkyNazov2, CC.xy(2, 3));

                                    //======== panel4 ========
                                    {
                                        panel4.setBackground(Color.white);
                                        panel4.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                        panel4.setLayout(new GridBagLayout());

                                        //---- comBoxJedLisRanajkyNapoj2 ----
                                        comBoxJedLisRanajkyNapoj2.setBorder(null);
                                        comBoxJedLisRanajkyNapoj2.setModel(new DefaultComboBoxModel<>(new String[] {
                                            "Cola",
                                            "Min. voda",
                                            "\u010caj",
                                            "D\u017e\u00fas"
                                        }));
                                        comBoxJedLisRanajkyNapoj2.setBackground(Color.lightGray);
                                        comBoxJedLisRanajkyNapoj2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                        comBoxJedLisRanajkyNapoj2.setSelectedIndex(-1);
                                        panel4.add(comBoxJedLisRanajkyNapoj2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(9, 10, 9, 10), 0, 0));
                                    }
                                    panelJedalnyListokRanajkyInside.add(panel4, CC.xy(3, 3));

                                    //---- txtJedLisRanakKapacita2 ----
                                    txtJedLisRanakKapacita2.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanakKapacita2.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakKapacita2.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakKapacita2.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakKapacita1KeyTyped(e);
                                        }
                                    });
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanakKapacita2, CC.xy(4, 3));

                                    //---- txtJedLisRanakCena2 ----
                                    txtJedLisRanakCena2.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    txtJedLisRanakCena2.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakCena2.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakCena2.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakCena1KeyTyped(e);
                                        }
                                    });
                                    txtJedLisRanakCena2.addFocusListener(new FocusAdapter() {
                                        @Override
                                        public void focusLost(FocusEvent e) {
                                            frmterJedLisRanakCena1FocusLost(e);
                                        }
                                    });
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanakCena2, CC.xy(5, 3));

                                    //---- label73 ----
                                    label73.setText("3.");
                                    label73.setHorizontalAlignment(SwingConstants.CENTER);
                                    label73.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label73.setBorder(new MatteBorder(0, 1, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label73, CC.xy(1, 4));

                                    //---- txtJedLisRanajkyNazov3 ----
                                    txtJedLisRanajkyNazov3.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanajkyNazov3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanajkyNazov3.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanajkyNazov3, CC.xy(2, 4));

                                    //======== panel3 ========
                                    {
                                        panel3.setBackground(Color.white);
                                        panel3.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                        panel3.setLayout(new GridBagLayout());

                                        //---- comBoxJedLisRanajkyNapoj3 ----
                                        comBoxJedLisRanajkyNapoj3.setBorder(null);
                                        comBoxJedLisRanajkyNapoj3.setModel(new DefaultComboBoxModel<>(new String[] {
                                            "Cola",
                                            "Min. voda",
                                            "\u010caj",
                                            "D\u017e\u00fas"
                                        }));
                                        comBoxJedLisRanajkyNapoj3.setBackground(Color.lightGray);
                                        comBoxJedLisRanajkyNapoj3.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                        comBoxJedLisRanajkyNapoj3.setSelectedIndex(-1);
                                        panel3.add(comBoxJedLisRanajkyNapoj3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(9, 10, 9, 10), 0, 0));
                                    }
                                    panelJedalnyListokRanajkyInside.add(panel3, CC.xy(3, 4));

                                    //---- txtJedLisRanakKapacita3 ----
                                    txtJedLisRanakKapacita3.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanakKapacita3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakKapacita3.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakKapacita3.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakKapacita1KeyTyped(e);
                                        }
                                    });
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanakKapacita3, CC.xy(4, 4));

                                    //---- txtJedLisRanakCena3 ----
                                    txtJedLisRanakCena3.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    txtJedLisRanakCena3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakCena3.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakCena3.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakCena1KeyTyped(e);
                                        }
                                    });
                                    txtJedLisRanakCena3.addFocusListener(new FocusAdapter() {
                                        @Override
                                        public void focusLost(FocusEvent e) {
                                            frmterJedLisRanakCena1FocusLost(e);
                                        }
                                    });
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanakCena3, CC.xy(5, 4));

                                    //---- label78 ----
                                    label78.setText("4.");
                                    label78.setHorizontalAlignment(SwingConstants.CENTER);
                                    label78.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label78.setBorder(new MatteBorder(0, 1, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label78, CC.xy(1, 5));

                                    //---- txtJedLisRanajkyNazov4 ----
                                    txtJedLisRanajkyNazov4.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanajkyNazov4.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanajkyNazov4.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanajkyNazov4, CC.xy(2, 5));

                                    //======== panel2 ========
                                    {
                                        panel2.setBackground(Color.white);
                                        panel2.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                        panel2.setLayout(new GridBagLayout());

                                        //---- comBoxJedLisRanajkyNapoj4 ----
                                        comBoxJedLisRanajkyNapoj4.setBorder(null);
                                        comBoxJedLisRanajkyNapoj4.setModel(new DefaultComboBoxModel<>(new String[] {
                                            "Cola",
                                            "Min. voda",
                                            "\u010caj",
                                            "D\u017e\u00fas"
                                        }));
                                        comBoxJedLisRanajkyNapoj4.setBackground(Color.lightGray);
                                        comBoxJedLisRanajkyNapoj4.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                        comBoxJedLisRanajkyNapoj4.setSelectedIndex(-1);
                                        panel2.add(comBoxJedLisRanajkyNapoj4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(9, 10, 9, 10), 0, 0));
                                    }
                                    panelJedalnyListokRanajkyInside.add(panel2, CC.xy(3, 5));

                                    //---- txtJedLisRanakKapacita4 ----
                                    txtJedLisRanakKapacita4.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanakKapacita4.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakKapacita4.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakKapacita4.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakKapacita1KeyTyped(e);
                                        }
                                    });
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanakKapacita4, CC.xy(4, 5));

                                    //---- txtJedLisRanakCena4 ----
                                    txtJedLisRanakCena4.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    txtJedLisRanakCena4.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakCena4.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakCena4.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakCena1KeyTyped(e);
                                        }
                                    });
                                    txtJedLisRanakCena4.addFocusListener(new FocusAdapter() {
                                        @Override
                                        public void focusLost(FocusEvent e) {
                                            frmterJedLisRanakCena1FocusLost(e);
                                        }
                                    });
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanakCena4, CC.xy(5, 5));

                                    //---- label83 ----
                                    label83.setText("5.");
                                    label83.setHorizontalAlignment(SwingConstants.CENTER);
                                    label83.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label83.setBorder(new MatteBorder(0, 1, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label83, CC.xy(1, 6));

                                    //---- txtJedLisRanajkyNazov5 ----
                                    txtJedLisRanajkyNazov5.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanajkyNazov5.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanajkyNazov5.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanajkyNazov5, CC.xy(2, 6));

                                    //======== panel1 ========
                                    {
                                        panel1.setBackground(Color.white);
                                        panel1.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                        panel1.setLayout(new GridBagLayout());

                                        //---- comBoxJedLisRanajkyNapoj5 ----
                                        comBoxJedLisRanajkyNapoj5.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
                                        comBoxJedLisRanajkyNapoj5.setModel(new DefaultComboBoxModel<>(new String[] {
                                            "Cola",
                                            "Min. voda",
                                            "\u010caj",
                                            "D\u017e\u00fas"
                                        }));
                                        comBoxJedLisRanajkyNapoj5.setBackground(Color.lightGray);
                                        comBoxJedLisRanajkyNapoj5.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                        comBoxJedLisRanajkyNapoj5.setSelectedIndex(-1);
                                        panel1.add(comBoxJedLisRanajkyNapoj5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(9, 10, 9, 10), 0, 0));
                                    }
                                    panelJedalnyListokRanajkyInside.add(panel1, CC.xy(3, 6));

                                    //---- txtJedLisRanakKapacita5 ----
                                    txtJedLisRanakKapacita5.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanakKapacita5.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakKapacita5.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakKapacita5.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakKapacita1KeyTyped(e);
                                        }
                                    });
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanakKapacita5, CC.xy(4, 6));

                                    //---- txtJedLisRanakCena5 ----
                                    txtJedLisRanakCena5.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    txtJedLisRanakCena5.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakCena5.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakCena5.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                                    txtJedLisRanakCena5.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakCena1KeyTyped(e);
                                        }
                                    });
                                    txtJedLisRanakCena5.addFocusListener(new FocusAdapter() {
                                        @Override
                                        public void focusLost(FocusEvent e) {
                                            frmterJedLisRanakCena1FocusLost(e);
                                        }
                                    });
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanakCena5, CC.xy(5, 6));
                                }
                                panelJedalnyListokRanajky.add(panelJedalnyListokRanajkyInside, "cell 0 1");

                                //---- labelWarningJedLisRanajky ----
                                labelWarningJedLisRanajky.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                labelWarningJedLisRanajky.setForeground(Color.red);
                                labelWarningJedLisRanajky.setHorizontalAlignment(SwingConstants.CENTER);
                                panelJedalnyListokRanajky.add(labelWarningJedLisRanajky, "cell 0 2");

                                //---- btnJedLisRanjakyPokracovat ----
                                btnJedLisRanjakyPokracovat.setText("Pokra\u010dova\u0165");
                                btnJedLisRanjakyPokracovat.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                btnJedLisRanjakyPokracovat.setBorder(null);
                                btnJedLisRanjakyPokracovat.setkStartColor(new Color(73, 196, 174));
                                btnJedLisRanjakyPokracovat.setkEndColor(new Color(140, 219, 145));
                                btnJedLisRanjakyPokracovat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                btnJedLisRanjakyPokracovat.setkHoverEndColor(new Color(73, 196, 174));
                                btnJedLisRanjakyPokracovat.setkHoverStartColor(new Color(52, 188, 183));
                                btnJedLisRanjakyPokracovat.setkHoverForeGround(Color.white);
                                btnJedLisRanjakyPokracovat.setBackground(Color.white);
                                btnJedLisRanjakyPokracovat.setBorderPainted(false);
                                btnJedLisRanjakyPokracovat.addActionListener(e -> kButton4ActionPerformed());
                                panelJedalnyListokRanajky.add(btnJedLisRanjakyPokracovat, "cell 0 2,alignx right,growx 0,width 120,hmax 36,gapx null 0");
                            }
                            panelJedalnyListok.add(panelJedalnyListokRanajky, "ranajky");

                            //======== panelJedalnyListokObed ========
                            {
                                panelJedalnyListokObed.setkEndColor(Color.white);
                                panelJedalnyListokObed.setkStartColor(Color.white);
                                panelJedalnyListokObed.setkBorderRadius(0);
                                panelJedalnyListokObed.setkGradientFocus(600);
                                panelJedalnyListokObed.setBorder(null);
                                panelJedalnyListokObed.setBackground(Color.white);
                                panelJedalnyListokObed.setkFillBackground(false);
                                panelJedalnyListokObed.setLayout(new MigLayout(
                                    "insets 0,novisualpadding,hidemode 3,align center center,gapy 15",
                                    // columns
                                    "[fill]",
                                    // rows
                                    "[33:n,fill]" +
                                    "[fill]" +
                                    "[32,fill]"));

                                //---- label7 ----
                                label7.setText("Vytvorte obedov\u00e9 menu");
                                label7.setHorizontalAlignment(SwingConstants.CENTER);
                                label7.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
                                label7.setForeground(new Color(55, 55, 55));
                                panelJedalnyListokObed.add(label7, "cell 0 0");

                                //======== panelJedalnyListokObedInside ========
                                {
                                    panelJedalnyListokObedInside.setkEndColor(Color.white);
                                    panelJedalnyListokObedInside.setkStartColor(Color.white);
                                    panelJedalnyListokObedInside.setBorder(null);
                                    panelJedalnyListokObedInside.setkBorderRadius(0);
                                    panelJedalnyListokObedInside.setBackground(new Color(255, 255, 255, 145));
                                    panelJedalnyListokObedInside.setLayout(new FormLayout(
                                        "27px, 312px, 126px, 90px, 89px",
                                        "fill:49px, 5*(fill:52px)"));

                                    //---- label72 ----
                                    label72.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label72, CC.xy(1, 1));

                                    //---- label10 ----
                                    label10.setText("Obed");
                                    label10.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label10.setHorizontalAlignment(SwingConstants.CENTER);
                                    label10.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label10, CC.xy(2, 1));

                                    //---- label75 ----
                                    label75.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label75.setHorizontalAlignment(SwingConstants.CENTER);
                                    label75.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    label75.setText("Takeaway");
                                    panelJedalnyListokObedInside.add(label75, CC.xy(3, 1));

                                    //---- label76 ----
                                    label76.setText("Kapacita");
                                    label76.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label76.setHorizontalAlignment(SwingConstants.CENTER);
                                    label76.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    label76.setBackground(Color.white);
                                    panelJedalnyListokObedInside.add(label76, CC.xy(4, 1));

                                    //---- label77 ----
                                    label77.setText("Cena");
                                    label77.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label77.setHorizontalAlignment(SwingConstants.CENTER);
                                    label77.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label77, CC.xy(5, 1));

                                    //---- label80 ----
                                    label80.setText("1.");
                                    label80.setHorizontalAlignment(SwingConstants.CENTER);
                                    label80.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label80.setBorder(new MatteBorder(0, 1, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label80, CC.xy(1, 2));

                                    //---- textField8 ----
                                    textField8.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField8.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField8.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField8, CC.xy(2, 2));

                                    //======== panel6 ========
                                    {
                                        panel6.setBackground(Color.white);
                                        panel6.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                        panel6.setLayout(new GridBagLayout());
                                        ((GridBagLayout)panel6.getLayout()).columnWidths = new int[] {70};

                                        //---- comboBox12 ----
                                        comboBox12.setBorder(null);
                                        comboBox12.setModel(new DefaultComboBoxModel<>(new String[] {
                                            "\u00c1no",
                                            "Nie"
                                        }));
                                        comboBox12.setBackground(Color.lightGray);
                                        comboBox12.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                        comboBox12.setSelectedIndex(-1);
                                        panel6.add(comboBox12, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelJedalnyListokObedInside.add(panel6, CC.xy(3, 2));

                                    //---- textField45 ----
                                    textField45.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField45.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField45.setHorizontalAlignment(SwingConstants.CENTER);
                                    textField45.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakKapacita1KeyTyped(e);
                                        }
                                    });
                                    panelJedalnyListokObedInside.add(textField45, CC.xy(4, 2));

                                    //---- textField46 ----
                                    textField46.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField46.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField46.setHorizontalAlignment(SwingConstants.CENTER);
                                    textField46.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakCena1KeyTyped(e);
                                        }
                                    });
                                    textField46.addFocusListener(new FocusAdapter() {
                                        @Override
                                        public void focusLost(FocusEvent e) {
                                            frmterJedLisRanakCena1FocusLost(e);
                                        }
                                    });
                                    panelJedalnyListokObedInside.add(textField46, CC.xy(5, 2));

                                    //---- label81 ----
                                    label81.setText("2.");
                                    label81.setHorizontalAlignment(SwingConstants.CENTER);
                                    label81.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label81.setBorder(new MatteBorder(0, 1, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label81, CC.xy(1, 3));

                                    //---- textField47 ----
                                    textField47.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField47.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField47.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField47, CC.xy(2, 3));

                                    //======== panel7 ========
                                    {
                                        panel7.setBackground(Color.white);
                                        panel7.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                        panel7.setLayout(new GridBagLayout());
                                        ((GridBagLayout)panel7.getLayout()).columnWidths = new int[] {70};

                                        //---- comboBox13 ----
                                        comboBox13.setBorder(null);
                                        comboBox13.setModel(new DefaultComboBoxModel<>(new String[] {
                                            "\u00c1no",
                                            "Nie"
                                        }));
                                        comboBox13.setBackground(Color.lightGray);
                                        comboBox13.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                        comboBox13.setSelectedIndex(-1);
                                        panel7.add(comboBox13, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelJedalnyListokObedInside.add(panel7, CC.xy(3, 3));

                                    //---- textField48 ----
                                    textField48.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField48.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField48.setHorizontalAlignment(SwingConstants.CENTER);
                                    textField48.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakKapacita1KeyTyped(e);
                                        }
                                    });
                                    panelJedalnyListokObedInside.add(textField48, CC.xy(4, 3));

                                    //---- textField49 ----
                                    textField49.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField49.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField49.setHorizontalAlignment(SwingConstants.CENTER);
                                    textField49.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakCena1KeyTyped(e);
                                        }
                                    });
                                    textField49.addFocusListener(new FocusAdapter() {
                                        @Override
                                        public void focusLost(FocusEvent e) {
                                            frmterJedLisRanakCena1FocusLost(e);
                                        }
                                    });
                                    panelJedalnyListokObedInside.add(textField49, CC.xy(5, 3));

                                    //---- label82 ----
                                    label82.setText("3.");
                                    label82.setHorizontalAlignment(SwingConstants.CENTER);
                                    label82.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label82.setBorder(new MatteBorder(0, 1, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label82, CC.xy(1, 4));

                                    //---- textField50 ----
                                    textField50.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField50.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField50.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField50, CC.xy(2, 4));

                                    //======== panel8 ========
                                    {
                                        panel8.setBackground(Color.white);
                                        panel8.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                        panel8.setLayout(new GridBagLayout());
                                        ((GridBagLayout)panel8.getLayout()).columnWidths = new int[] {70};

                                        //---- comboBox14 ----
                                        comboBox14.setBorder(null);
                                        comboBox14.setModel(new DefaultComboBoxModel<>(new String[] {
                                            "\u00c1no",
                                            "Nie"
                                        }));
                                        comboBox14.setBackground(Color.lightGray);
                                        comboBox14.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                        comboBox14.setSelectedIndex(-1);
                                        panel8.add(comboBox14, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelJedalnyListokObedInside.add(panel8, CC.xy(3, 4));

                                    //---- textField51 ----
                                    textField51.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField51.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField51.setHorizontalAlignment(SwingConstants.CENTER);
                                    textField51.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakKapacita1KeyTyped(e);
                                        }
                                    });
                                    panelJedalnyListokObedInside.add(textField51, CC.xy(4, 4));

                                    //---- textField52 ----
                                    textField52.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField52.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField52.setHorizontalAlignment(SwingConstants.CENTER);
                                    textField52.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakCena1KeyTyped(e);
                                        }
                                    });
                                    textField52.addFocusListener(new FocusAdapter() {
                                        @Override
                                        public void focusLost(FocusEvent e) {
                                            frmterJedLisRanakCena1FocusLost(e);
                                        }
                                    });
                                    panelJedalnyListokObedInside.add(textField52, CC.xy(5, 4));

                                    //---- label85 ----
                                    label85.setText("4.");
                                    label85.setHorizontalAlignment(SwingConstants.CENTER);
                                    label85.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label85.setBorder(new MatteBorder(0, 1, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label85, CC.xy(1, 5));

                                    //---- textField53 ----
                                    textField53.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField53.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField53.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField53, CC.xy(2, 5));

                                    //======== panel9 ========
                                    {
                                        panel9.setBackground(Color.white);
                                        panel9.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                        panel9.setLayout(new GridBagLayout());
                                        ((GridBagLayout)panel9.getLayout()).columnWidths = new int[] {70};

                                        //---- comboBox15 ----
                                        comboBox15.setBorder(null);
                                        comboBox15.setModel(new DefaultComboBoxModel<>(new String[] {
                                            "\u00c1no",
                                            "Nie"
                                        }));
                                        comboBox15.setBackground(Color.lightGray);
                                        comboBox15.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                        comboBox15.setSelectedIndex(-1);
                                        panel9.add(comboBox15, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelJedalnyListokObedInside.add(panel9, CC.xy(3, 5));

                                    //---- textField54 ----
                                    textField54.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField54.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField54.setHorizontalAlignment(SwingConstants.CENTER);
                                    textField54.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakKapacita1KeyTyped(e);
                                        }
                                    });
                                    panelJedalnyListokObedInside.add(textField54, CC.xy(4, 5));

                                    //---- textField55 ----
                                    textField55.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField55.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField55.setHorizontalAlignment(SwingConstants.CENTER);
                                    textField55.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakCena1KeyTyped(e);
                                        }
                                    });
                                    textField55.addFocusListener(new FocusAdapter() {
                                        @Override
                                        public void focusLost(FocusEvent e) {
                                            frmterJedLisRanakCena1FocusLost(e);
                                        }
                                    });
                                    panelJedalnyListokObedInside.add(textField55, CC.xy(5, 5));

                                    //---- label86 ----
                                    label86.setText("5.");
                                    label86.setHorizontalAlignment(SwingConstants.CENTER);
                                    label86.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label86.setBorder(new MatteBorder(0, 1, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label86, CC.xy(1, 6));

                                    //---- textField56 ----
                                    textField56.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField56.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField56.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField56, CC.xy(2, 6));

                                    //======== panel10 ========
                                    {
                                        panel10.setBackground(Color.white);
                                        panel10.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                        panel10.setLayout(new GridBagLayout());
                                        ((GridBagLayout)panel10.getLayout()).columnWidths = new int[] {70};

                                        //---- comboBox16 ----
                                        comboBox16.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
                                        comboBox16.setModel(new DefaultComboBoxModel<>(new String[] {
                                            "\u00c1no",
                                            "Nie"
                                        }));
                                        comboBox16.setBackground(Color.lightGray);
                                        comboBox16.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                        comboBox16.setSelectedIndex(-1);
                                        panel10.add(comboBox16, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelJedalnyListokObedInside.add(panel10, CC.xy(3, 6));

                                    //---- textField57 ----
                                    textField57.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField57.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField57.setHorizontalAlignment(SwingConstants.CENTER);
                                    textField57.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakKapacita1KeyTyped(e);
                                        }
                                    });
                                    panelJedalnyListokObedInside.add(textField57, CC.xy(4, 6));

                                    //---- textField58 ----
                                    textField58.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField58.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField58.setHorizontalAlignment(SwingConstants.CENTER);
                                    textField58.addKeyListener(new KeyAdapter() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {
                                            frmterJedLisRanakCena1KeyTyped(e);
                                        }
                                    });
                                    textField58.addFocusListener(new FocusAdapter() {
                                        @Override
                                        public void focusLost(FocusEvent e) {
                                            frmterJedLisRanakCena1FocusLost(e);
                                        }
                                    });
                                    panelJedalnyListokObedInside.add(textField58, CC.xy(5, 6));
                                }
                                panelJedalnyListokObed.add(panelJedalnyListokObedInside, "cell 0 1");

                                //---- btnJedalnyListokSpatObed ----
                                btnJedalnyListokSpatObed.setText("Sp\u00e4\u0165");
                                btnJedalnyListokSpatObed.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                btnJedalnyListokSpatObed.setBorder(null);
                                btnJedalnyListokSpatObed.setkStartColor(new Color(255, 161, 117));
                                btnJedalnyListokSpatObed.setkEndColor(new Color(224, 31, 23));
                                btnJedalnyListokSpatObed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                btnJedalnyListokSpatObed.setkHoverEndColor(new Color(255, 161, 117));
                                btnJedalnyListokSpatObed.setkHoverStartColor(new Color(244, 115, 84));
                                btnJedalnyListokSpatObed.setkHoverForeGround(Color.white);
                                btnJedalnyListokSpatObed.setBackground(Color.white);
                                btnJedalnyListokSpatObed.setBorderPainted(false);
                                btnJedalnyListokSpatObed.addActionListener(e -> btnJedalnyListokSpatObedActionPerformed());
                                panelJedalnyListokObed.add(btnJedalnyListokSpatObed, "cell 0 2,alignx left,growx 0,width 110,hmax 30,gapx 0");

                                //---- labelWarningJedLisObed ----
                                labelWarningJedLisObed.setForeground(Color.red);
                                labelWarningJedLisObed.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                labelWarningJedLisObed.setHorizontalAlignment(SwingConstants.CENTER);
                                panelJedalnyListokObed.add(labelWarningJedLisObed, "cell 0 2");

                                //---- btnJedLisObedPokracovat ----
                                btnJedLisObedPokracovat.setText("Pokra\u010dova\u0165");
                                btnJedLisObedPokracovat.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                btnJedLisObedPokracovat.setBorder(null);
                                btnJedLisObedPokracovat.setkStartColor(new Color(73, 196, 174));
                                btnJedLisObedPokracovat.setkEndColor(new Color(140, 219, 145));
                                btnJedLisObedPokracovat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                btnJedLisObedPokracovat.setkHoverEndColor(new Color(73, 196, 174));
                                btnJedLisObedPokracovat.setkHoverStartColor(new Color(52, 188, 183));
                                btnJedLisObedPokracovat.setkHoverForeGround(Color.white);
                                btnJedLisObedPokracovat.setBackground(Color.white);
                                btnJedLisObedPokracovat.setBorderPainted(false);
                                btnJedLisObedPokracovat.addActionListener(e -> btnJedalnyListokPokracovatObedActionPerformed());
                                panelJedalnyListokObed.add(btnJedLisObedPokracovat, "cell 0 2,alignx right,growx 0,width 120,hmax 30,gapx null 0");
                            }
                            panelJedalnyListok.add(panelJedalnyListokObed, "obed");

                            //======== panelJedalnyListokVytvorit ========
                            {
                                panelJedalnyListokVytvorit.setkEndColor(Color.white);
                                panelJedalnyListokVytvorit.setkStartColor(Color.white);
                                panelJedalnyListokVytvorit.setLayout(new GridBagLayout());
                                ((GridBagLayout)panelJedalnyListokVytvorit.getLayout()).rowHeights = new int[] {0, 23};

                                //======== panelJedalnyListokInside ========
                                {
                                    panelJedalnyListokInside.setkStartColor(Color.white);
                                    panelJedalnyListokInside.setkEndColor(Color.white);
                                    panelJedalnyListokInside.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));
                                    panelJedalnyListokInside.setkBorderRadius(0);
                                    panelJedalnyListokInside.setLayout(new MigLayout(
                                        "insets 0,hidemode 3,gap 0 0",
                                        // columns
                                        "[516:n,fill]",
                                        // rows
                                        "[58:n,fill]" +
                                        "[55:n,fill]" +
                                        "[8]"));

                                    //---- labelJedalnyListokVytvoritInisde ----
                                    labelJedalnyListokVytvoritInisde.setText("Naozaj chcete vytvori\u0165 nov\u00fd jed\u00e1lny l\u00edstok?");
                                    labelJedalnyListokVytvoritInisde.setHorizontalAlignment(SwingConstants.CENTER);
                                    labelJedalnyListokVytvoritInisde.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
                                    panelJedalnyListokInside.add(labelJedalnyListokVytvoritInisde, "cell 0 0");

                                    //---- btnJedalnyListokVytvoritInside ----
                                    btnJedalnyListokVytvoritInside.setText("Sp\u00e4\u0165");
                                    btnJedalnyListokVytvoritInside.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                    btnJedalnyListokVytvoritInside.setBorder(null);
                                    btnJedalnyListokVytvoritInside.setkStartColor(new Color(255, 161, 117));
                                    btnJedalnyListokVytvoritInside.setkEndColor(new Color(224, 31, 23));
                                    btnJedalnyListokVytvoritInside.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                    btnJedalnyListokVytvoritInside.setkHoverEndColor(new Color(255, 161, 117));
                                    btnJedalnyListokVytvoritInside.setkHoverStartColor(new Color(244, 115, 84));
                                    btnJedalnyListokVytvoritInside.setkHoverForeGround(Color.white);
                                    btnJedalnyListokVytvoritInside.setBackground(Color.white);
                                    btnJedalnyListokVytvoritInside.setBorderPainted(false);
                                    btnJedalnyListokVytvoritInside.setMaximumSize(new Dimension(97, 24));
                                    btnJedalnyListokVytvoritInside.setMinimumSize(new Dimension(97, 24));
                                    btnJedalnyListokVytvoritInside.addActionListener(e -> btnJedalnyListokVytvoritInsideActionPerformed());
                                    panelJedalnyListokInside.add(btnJedalnyListokVytvoritInside, "cell 0 1,wmax 100,hmax 32,gapx 125");

                                    //---- btnJedalnyListokVytvoritInside2 ----
                                    btnJedalnyListokVytvoritInside2.setText("Vytvori\u0165");
                                    btnJedalnyListokVytvoritInside2.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                    btnJedalnyListokVytvoritInside2.setBorder(null);
                                    btnJedalnyListokVytvoritInside2.setkStartColor(new Color(73, 196, 174));
                                    btnJedalnyListokVytvoritInside2.setkEndColor(new Color(140, 219, 145));
                                    btnJedalnyListokVytvoritInside2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                    btnJedalnyListokVytvoritInside2.setkHoverEndColor(new Color(73, 196, 174));
                                    btnJedalnyListokVytvoritInside2.setkHoverStartColor(new Color(52, 188, 183));
                                    btnJedalnyListokVytvoritInside2.setkHoverForeGround(Color.white);
                                    btnJedalnyListokVytvoritInside2.setBackground(Color.white);
                                    btnJedalnyListokVytvoritInside2.setBorderPainted(false);
                                    btnJedalnyListokVytvoritInside2.setMaximumSize(new Dimension(97, 24));
                                    btnJedalnyListokVytvoritInside2.setMinimumSize(new Dimension(97, 24));
                                    btnJedalnyListokVytvoritInside2.addActionListener(e -> btnJedalnyListokVytvoritInside2ActionPerformed(e));
                                    panelJedalnyListokInside.add(btnJedalnyListokVytvoritInside2, "pad 0,cell 0 1,aligny center,growy 0,wmax 100,hmax 32,gapx null 125");
                                }
                                panelJedalnyListokVytvorit.add(panelJedalnyListokInside, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                                    new Insets(0, 0, 5, 0), 0, 0));

                                //---- labelWarningJedLisVytvorit ----
                                labelWarningJedLisVytvorit.setHorizontalAlignment(SwingConstants.CENTER);
                                labelWarningJedLisVytvorit.setForeground(Color.red);
                                labelWarningJedLisVytvorit.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                panelJedalnyListokVytvorit.add(labelWarningJedLisVytvorit, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                    new Insets(0, 0, 0, 0), 0, 0));
                            }
                            panelJedalnyListok.add(panelJedalnyListokVytvorit, "vytvorit");
                        }
                        panelContent.add(panelJedalnyListok, "jedalnyListok");

                        //======== panelObjednavky ========
                        {
                            panelObjednavky.setkEndColor(Color.white);
                            panelObjednavky.setkStartColor(Color.white);

                            //======== splitPane3 ========
                            {
                                splitPane3.setBorder(null);
                                splitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);
                                splitPane3.setDividerSize(0);
                                splitPane3.setDividerLocation(40);
                                splitPane3.setBackground(new Color(55, 55, 55));

                                //======== panelMenuObjednavky ========
                                {
                                    panelMenuObjednavky.setkStartColor(new Color(55, 55, 55));
                                    panelMenuObjednavky.setkEndColor(new Color(55, 55, 55));
                                    panelMenuObjednavky.setkBorderRadius(0);
                                    panelMenuObjednavky.setBackground(new Color(55, 55, 55));
                                    panelMenuObjednavky.setkGradientFocus(700);
                                    panelMenuObjednavky.setForeground(new Color(55, 55, 55));
                                    panelMenuObjednavky.setBorder(null);
                                    panelMenuObjednavky.setLayout(new FormLayout(
                                        "default, $lcgap, default",
                                        "fill:default"));

                                    //---- btnRanajky ----
                                    btnRanajky.setText("Ranajky");
                                    btnRanajky.setBorder(null);
                                    btnRanajky.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                    btnRanajky.setkStartColor(Color.darkGray);
                                    btnRanajky.setkEndColor(Color.darkGray);
                                    btnRanajky.setkBorderRadius(0);
                                    btnRanajky.setkAllowTab(true);
                                    btnRanajky.setkHoverEndColor(new Color(70, 70, 70));
                                    btnRanajky.setkHoverStartColor(new Color(70, 70, 70));
                                    btnRanajky.setkIndicatorColor(new Color(38, 184, 190));
                                    btnRanajky.setkIndicatorThickness(0);
                                    btnRanajky.setkBackGroundColor(Color.white);
                                    btnRanajky.setkSelectedColor(new Color(67, 67, 67));
                                    btnRanajky.setkHoverForeGround(Color.white);
                                    btnRanajky.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                    btnRanajky.setVerticalAlignment(SwingConstants.TOP);
                                    btnRanajky.addActionListener(e -> {
			btnRanajkyActionPerformed();
			btnRanajkyActionPerformed();
		});
                                    panelMenuObjednavky.add(btnRanajky, CC.xy(1, 1));

                                    //---- btnObed ----
                                    btnObed.setText("Obed");
                                    btnObed.setBorder(null);
                                    btnObed.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                    btnObed.setkStartColor(Color.darkGray);
                                    btnObed.setkEndColor(Color.darkGray);
                                    btnObed.setkBorderRadius(0);
                                    btnObed.setkAllowTab(true);
                                    btnObed.setkHoverEndColor(new Color(70, 70, 70));
                                    btnObed.setkHoverStartColor(new Color(70, 70, 70));
                                    btnObed.setkIndicatorColor(new Color(38, 184, 190));
                                    btnObed.setkIndicatorThickness(0);
                                    btnObed.setkBackGroundColor(Color.white);
                                    btnObed.setkSelectedColor(new Color(67, 67, 67));
                                    btnObed.setkHoverForeGround(Color.white);
                                    btnObed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                    btnObed.setVerticalAlignment(SwingConstants.TOP);
                                    btnObed.addActionListener(e -> btnObedActionPerformed());
                                    panelMenuObjednavky.add(btnObed, CC.xy(3, 1));
                                }
                                splitPane3.setTopComponent(panelMenuObjednavky);

                                //======== panelContentObjednavky ========
                                {
                                    panelContentObjednavky.setBackground(new Color(55, 55, 55));
                                    panelContentObjednavky.setLayout(new CardLayout());

                                    //======== panelObjednavkyRanajky ========
                                    {
                                        panelObjednavkyRanajky.setkEndColor(new Color(38, 184, 190, 24));
                                        panelObjednavkyRanajky.setkStartColor(new Color(38, 184, 190, 24));
                                        panelObjednavkyRanajky.setkBorderRadius(0);
                                        panelObjednavkyRanajky.setkGradientFocus(600);
                                        panelObjednavkyRanajky.setBorder(null);
                                        panelObjednavkyRanajky.setBackground(Color.white);
                                        panelObjednavkyRanajky.setkFillBackground(false);
                                        panelObjednavkyRanajky.setLayout(new GridBagLayout());
                                        ((GridBagLayout)panelObjednavkyRanajky.getLayout()).rowHeights = new int[] {0, 22};

                                        //======== panelTableRanajky ========
                                        {
                                            panelTableRanajky.setkEndColor(Color.white);
                                            panelTableRanajky.setkStartColor(Color.white);
                                            panelTableRanajky.setBorder(null);
                                            panelTableRanajky.setkBorderRadius(0);
                                            panelTableRanajky.setBackground(new Color(255, 255, 255, 145));
                                            panelTableRanajky.setLayout(new FormLayout(
                                                "27px, 306px, 134px, 200px",
                                                "fill:49px, 5*(fill:52px)"));

                                            //---- label36 ----
                                            label36.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label36, CC.xy(1, 1));

                                            //---- label1 ----
                                            label1.setText("Ra\u0148ajky");
                                            label1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label1.setHorizontalAlignment(SwingConstants.CENTER);
                                            label1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label1, CC.xy(2, 1));

                                            //---- label8 ----
                                            label8.setText("N\u00e1poj");
                                            label8.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label8.setHorizontalAlignment(SwingConstants.CENTER);
                                            label8.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label8, CC.xy(3, 1));

                                            //---- label9 ----
                                            label9.setText("Po\u010det objedn\u00e1vok");
                                            label9.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label9.setHorizontalAlignment(SwingConstants.CENTER);
                                            label9.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            label9.setBackground(Color.white);
                                            panelTableRanajky.add(label9, CC.xy(4, 1));

                                            //---- label46 ----
                                            label46.setText("1.");
                                            label46.setHorizontalAlignment(SwingConstants.CENTER);
                                            label46.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label46.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label46, CC.xy(1, 2));

                                            //---- labelObjednavkyRanajkyNazov1 ----
                                            labelObjednavkyRanajkyNazov1.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            labelObjednavkyRanajkyNazov1.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyNazov1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyNazov1, CC.xy(2, 2));

                                            //---- labelObjednavkyRanajkyNapoj1 ----
                                            labelObjednavkyRanajkyNapoj1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednavkyRanajkyNapoj1.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyNapoj1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyNapoj1, CC.xy(3, 2));

                                            //---- labelObjednavkyRanajkyPocet1 ----
                                            labelObjednavkyRanajkyPocet1.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            labelObjednavkyRanajkyPocet1.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyPocet1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyPocet1, CC.xy(4, 2));

                                            //---- label32 ----
                                            label32.setText("2.");
                                            label32.setHorizontalAlignment(SwingConstants.CENTER);
                                            label32.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label32.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label32, CC.xy(1, 3));

                                            //---- labelObjednavkyRanajkyNazov2 ----
                                            labelObjednavkyRanajkyNazov2.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednavkyRanajkyNazov2.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyNazov2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyNazov2, CC.xy(2, 3));

                                            //---- labelObjednavkyRanajkyNapoj2 ----
                                            labelObjednavkyRanajkyNapoj2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednavkyRanajkyNapoj2.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyNapoj2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyNapoj2, CC.xy(3, 3));

                                            //---- labelObjednavkyRanajkyPocet2 ----
                                            labelObjednavkyRanajkyPocet2.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            labelObjednavkyRanajkyPocet2.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyPocet2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyPocet2, CC.xy(4, 3));

                                            //---- label33 ----
                                            label33.setText("3.");
                                            label33.setHorizontalAlignment(SwingConstants.CENTER);
                                            label33.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label33.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label33, CC.xy(1, 4));

                                            //---- labelObjednavkyRanajkyNazov3 ----
                                            labelObjednavkyRanajkyNazov3.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednavkyRanajkyNazov3.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyNazov3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyNazov3, CC.xy(2, 4));

                                            //---- labelObjednavkyRanajkyNapoj3 ----
                                            labelObjednavkyRanajkyNapoj3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednavkyRanajkyNapoj3.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyNapoj3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyNapoj3, CC.xy(3, 4));

                                            //---- labelObjednavkyRanajkyPocet3 ----
                                            labelObjednavkyRanajkyPocet3.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            labelObjednavkyRanajkyPocet3.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyPocet3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyPocet3, CC.xy(4, 4));

                                            //---- label34 ----
                                            label34.setText("4.");
                                            label34.setHorizontalAlignment(SwingConstants.CENTER);
                                            label34.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label34.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label34, CC.xy(1, 5));

                                            //---- labelObjednavkyRanajkyNazov4 ----
                                            labelObjednavkyRanajkyNazov4.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednavkyRanajkyNazov4.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyNazov4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyNazov4, CC.xy(2, 5));

                                            //---- labelObjednavkyRanajkyNapoj4 ----
                                            labelObjednavkyRanajkyNapoj4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednavkyRanajkyNapoj4.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyNapoj4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyNapoj4, CC.xy(3, 5));

                                            //---- labelObjednavkyRanajkyPocet4 ----
                                            labelObjednavkyRanajkyPocet4.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            labelObjednavkyRanajkyPocet4.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyPocet4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyPocet4, CC.xy(4, 5));

                                            //---- label35 ----
                                            label35.setText("5.");
                                            label35.setHorizontalAlignment(SwingConstants.CENTER);
                                            label35.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label35.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label35, CC.xy(1, 6));

                                            //---- labelObjednavkyRanajkyNazov5 ----
                                            labelObjednavkyRanajkyNazov5.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednavkyRanajkyNazov5.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyNazov5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyNazov5, CC.xy(2, 6));

                                            //---- labelObjednavkyRanajkyNapoj5 ----
                                            labelObjednavkyRanajkyNapoj5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednavkyRanajkyNapoj5.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyNapoj5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyNapoj5, CC.xy(3, 6));

                                            //---- labelObjednavkyRanajkyPocet5 ----
                                            labelObjednavkyRanajkyPocet5.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            labelObjednavkyRanajkyPocet5.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyRanajkyPocet5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednavkyRanajkyPocet5, CC.xy(4, 6));
                                        }
                                        panelObjednavkyRanajky.add(panelTableRanajky, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 5, 0), 0, 0));

                                        //---- labelWarningPocetObjednavkyRanajky ----
                                        labelWarningPocetObjednavkyRanajky.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
                                        labelWarningPocetObjednavkyRanajky.setForeground(Color.red);
                                        labelWarningPocetObjednavkyRanajky.setHorizontalAlignment(SwingConstants.CENTER);
                                        panelObjednavkyRanajky.add(labelWarningPocetObjednavkyRanajky, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelContentObjednavky.add(panelObjednavkyRanajky, "ranajky");

                                    //======== panelObjednavkyObed ========
                                    {
                                        panelObjednavkyObed.setkBorderRadius(0);
                                        panelObjednavkyObed.setkEndColor(Color.white);
                                        panelObjednavkyObed.setkStartColor(Color.white);
                                        panelObjednavkyObed.setLayout(new GridBagLayout());
                                        ((GridBagLayout)panelObjednavkyObed.getLayout()).rowHeights = new int[] {0, 22};

                                        //======== panelTableObed ========
                                        {
                                            panelTableObed.setkEndColor(Color.white);
                                            panelTableObed.setkStartColor(Color.white);
                                            panelTableObed.setBorder(null);
                                            panelTableObed.setkBorderRadius(0);
                                            panelTableObed.setBackground(new Color(255, 255, 255, 145));
                                            panelTableObed.setLayout(new FormLayout(
                                                "27px, 306px, 134px, 200px",
                                                "fill:49px, 5*(fill:52px)"));

                                            //---- label38 ----
                                            label38.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label38, CC.xy(1, 1));

                                            //---- label21 ----
                                            label21.setText("Obed");
                                            label21.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label21.setHorizontalAlignment(SwingConstants.CENTER);
                                            label21.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label21, CC.xy(2, 1));

                                            //---- label24 ----
                                            label24.setText("Takeaway");
                                            label24.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label24.setHorizontalAlignment(SwingConstants.CENTER);
                                            label24.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label24, CC.xy(3, 1));

                                            //---- label39 ----
                                            label39.setText("Po\u010det objedn\u00e1vok ");
                                            label39.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label39.setHorizontalAlignment(SwingConstants.CENTER);
                                            label39.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            label39.setBackground(Color.white);
                                            panelTableObed.add(label39, CC.xy(4, 1));

                                            //---- label47 ----
                                            label47.setText("1.");
                                            label47.setHorizontalAlignment(SwingConstants.CENTER);
                                            label47.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label47.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label47, CC.xy(1, 2));

                                            //---- labelObjednavkyObedNazov1 ----
                                            labelObjednavkyObedNazov1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednavkyObedNazov1.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedNazov1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedNazov1, CC.xy(2, 2));

                                            //---- labelObjednavkyObedTakeway1 ----
                                            labelObjednavkyObedTakeway1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednavkyObedTakeway1.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedTakeway1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedTakeway1, CC.xy(3, 2));

                                            //---- labelObjednavkyObedPocet1 ----
                                            labelObjednavkyObedPocet1.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            labelObjednavkyObedPocet1.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedPocet1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedPocet1, CC.xy(4, 2));

                                            //---- label45 ----
                                            label45.setText("2.");
                                            label45.setHorizontalAlignment(SwingConstants.CENTER);
                                            label45.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label45.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label45, CC.xy(1, 3));

                                            //---- labelObjednavkyObedNazov2 ----
                                            labelObjednavkyObedNazov2.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednavkyObedNazov2.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedNazov2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedNazov2, CC.xy(2, 3));

                                            //---- labelObjednavkyObedTakeway2 ----
                                            labelObjednavkyObedTakeway2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednavkyObedTakeway2.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedTakeway2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedTakeway2, CC.xy(3, 3));

                                            //---- labelObjednavkyObedPocet2 ----
                                            labelObjednavkyObedPocet2.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            labelObjednavkyObedPocet2.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedPocet2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedPocet2, CC.xy(4, 3));

                                            //---- label54 ----
                                            label54.setText("3.");
                                            label54.setHorizontalAlignment(SwingConstants.CENTER);
                                            label54.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label54.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label54, CC.xy(1, 4));

                                            //---- labelObjednavkyObedNazov3 ----
                                            labelObjednavkyObedNazov3.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednavkyObedNazov3.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedNazov3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedNazov3, CC.xy(2, 4));

                                            //---- labelObjednavkyObedTakeway3 ----
                                            labelObjednavkyObedTakeway3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednavkyObedTakeway3.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedTakeway3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedTakeway3, CC.xy(3, 4));

                                            //---- labelObjednavkyObedPocet3 ----
                                            labelObjednavkyObedPocet3.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            labelObjednavkyObedPocet3.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedPocet3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedPocet3, CC.xy(4, 4));

                                            //---- label60 ----
                                            label60.setText("4.");
                                            label60.setHorizontalAlignment(SwingConstants.CENTER);
                                            label60.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label60.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label60, CC.xy(1, 5));

                                            //---- labelObjednavkyObedNazov4 ----
                                            labelObjednavkyObedNazov4.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednavkyObedNazov4.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedNazov4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedNazov4, CC.xy(2, 5));

                                            //---- labelObjednavkyObedTakeway4 ----
                                            labelObjednavkyObedTakeway4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednavkyObedTakeway4.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedTakeway4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedTakeway4, CC.xy(3, 5));

                                            //---- labelObjednavkyObedPocet4 ----
                                            labelObjednavkyObedPocet4.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            labelObjednavkyObedPocet4.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedPocet4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedPocet4, CC.xy(4, 5));

                                            //---- label65 ----
                                            label65.setText("5.");
                                            label65.setHorizontalAlignment(SwingConstants.CENTER);
                                            label65.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label65.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label65, CC.xy(1, 6));

                                            //---- labelObjednavkyObedNazov5 ----
                                            labelObjednavkyObedNazov5.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednavkyObedNazov5.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedNazov5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedNazov5, CC.xy(2, 6));

                                            //---- labelObjednavkyObedTakeway5 ----
                                            labelObjednavkyObedTakeway5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednavkyObedTakeway5.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedTakeway5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedTakeway5, CC.xy(3, 6));

                                            //---- labelObjednavkyObedPocet5 ----
                                            labelObjednavkyObedPocet5.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            labelObjednavkyObedPocet5.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednavkyObedPocet5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednavkyObedPocet5, CC.xy(4, 6));
                                        }
                                        panelObjednavkyObed.add(panelTableObed, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 5, 0), 0, 0));

                                        //---- labelWarningPocetObjednavkyObed ----
                                        labelWarningPocetObjednavkyObed.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
                                        labelWarningPocetObjednavkyObed.setForeground(Color.red);
                                        labelWarningPocetObjednavkyObed.setHorizontalAlignment(SwingConstants.CENTER);
                                        panelObjednavkyObed.add(labelWarningPocetObjednavkyObed, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelContentObjednavky.add(panelObjednavkyObed, "obed");
                                }
                                splitPane3.setBottomComponent(panelContentObjednavky);
                            }

                            GroupLayout panelObjednavkyLayout = new GroupLayout(panelObjednavky);
                            panelObjednavky.setLayout(panelObjednavkyLayout);
                            panelObjednavkyLayout.setHorizontalGroup(
                                panelObjednavkyLayout.createParallelGroup()
                                    .addComponent(splitPane3)
                            );
                            panelObjednavkyLayout.setVerticalGroup(
                                panelObjednavkyLayout.createParallelGroup()
                                    .addComponent(splitPane3, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                            );
                        }
                        panelContent.add(panelObjednavky, "objednavky");

                        //======== panelTransakcie ========
                        {
                            panelTransakcie.setkEndColor(new Color(38, 184, 190, 24));
                            panelTransakcie.setkStartColor(new Color(38, 184, 190, 24));
                            panelTransakcie.setkBorderRadius(0);
                            panelTransakcie.setkGradientFocus(600);
                            panelTransakcie.setBorder(null);
                            panelTransakcie.setBackground(Color.white);
                            panelTransakcie.setkFillBackground(false);
                            panelTransakcie.setLayout(new GridBagLayout());
                            ((GridBagLayout)panelTransakcie.getLayout()).rowHeights = new int[] {120, 0, 32};

                            //======== panelForCombosInTrans ========
                            {
                                panelForCombosInTrans.setkEndColor(Color.white);
                                panelForCombosInTrans.setkStartColor(Color.white);
                                panelForCombosInTrans.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));
                                panelForCombosInTrans.setLayout(new MigLayout(
                                    "insets 0,hidemode 3",
                                    // columns
                                    "[67,fill]0" +
                                    "[100,fill]0" +
                                    "[10,fill]0" +
                                    "[100,fill]0" +
                                    "[17,fill]0" +
                                    "[100,fill]0" +
                                    "[10,fill]0" +
                                    "[170,fill]",
                                    // rows
                                    "10[35,fill]15" +
                                    "[20,center]10"));

                                //---- labelZobrazit2 ----
                                labelZobrazit2.setText("Pou\u017e\u00edvate\u013e:");
                                labelZobrazit2.setHorizontalAlignment(SwingConstants.CENTER);
                                labelZobrazit2.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                panelForCombosInTrans.add(labelZobrazit2, "cell 1 0 2 1");

                                //---- fielCeleMeno ----
                                fielCeleMeno.setText("Cel\u00e9 meno u\u017e\u00edvate\u013ea");
                                fielCeleMeno.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                                fielCeleMeno.setHorizontalAlignment(SwingConstants.CENTER);
                                fielCeleMeno.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                fielCeleMeno.setForeground(Color.lightGray);
                                fielCeleMeno.setPreferredSize(new Dimension(49, 29));
                                fielCeleMeno.setCaretPosition(9);
                                fielCeleMeno.addFocusListener(new FocusAdapter() {
                                    @Override
                                    public void focusGained(FocusEvent e) {
                                        fielCeleMenoFocusGained();
                                    }
                                    @Override
                                    public void focusLost(FocusEvent e) {
                                        fielCeleMenoFocusLost();
                                    }
                                });
                                fielCeleMeno.addKeyListener(new KeyAdapter() {
                                    @Override
                                    public void keyReleased(KeyEvent e) {
                                        fielCeleMenoKeyReleased();
                                    }
                                });
                                panelForCombosInTrans.add(fielCeleMeno, "cell 3 0 4 1,gapx 0 0");

                                //---- labelZiadneTransakcie ----
                                labelZiadneTransakcie.setHorizontalAlignment(SwingConstants.CENTER);
                                labelZiadneTransakcie.setForeground(Color.red);
                                labelZiadneTransakcie.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                panelForCombosInTrans.add(labelZiadneTransakcie, "cell 7 0");

                                //---- labelZobrazit ----
                                labelZobrazit.setText("Zobrazi\u0165:");
                                labelZobrazit.setHorizontalAlignment(SwingConstants.CENTER);
                                labelZobrazit.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                panelForCombosInTrans.add(labelZobrazit, "cell 1 1");

                                //---- comboBoxZobrazit ----
                                comboBoxZobrazit.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                comboBoxZobrazit.setModel(new DefaultComboBoxModel<>(new String[] {
                                    "V\u0161etky",
                                    "Vklady",
                                    "V\u00fdbery"
                                }));
                                comboBoxZobrazit.addActionListener(e -> comboBoxZobrazitActionPerformed());
                                panelForCombosInTrans.add(comboBoxZobrazit, "cell 3 1");

                                //---- labelZoradit ----
                                labelZoradit.setText("Zoradi\u0165:");
                                labelZoradit.setHorizontalAlignment(SwingConstants.CENTER);
                                labelZoradit.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                panelForCombosInTrans.add(labelZoradit, "cell 5 1");

                                //---- comboBoxZoradit ----
                                comboBoxZoradit.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                comboBoxZoradit.setModel(new DefaultComboBoxModel<>(new String[] {
                                    "Od najnov\u0161\u00edch",
                                    "Od najstar\u0161\u00edch"
                                }));
                                comboBoxZoradit.addActionListener(e -> comboBoxZobrazitActionPerformed());
                                panelForCombosInTrans.add(comboBoxZoradit, "cell 7 1");
                            }
                            panelTransakcie.add(panelForCombosInTrans, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 15, 0), 0, 0));

                            //======== panelTableTrans ========
                            {
                                panelTableTrans.setkEndColor(Color.white);
                                panelTableTrans.setkStartColor(Color.white);
                                panelTableTrans.setBorder(null);
                                panelTableTrans.setkBorderRadius(0);
                                panelTableTrans.setBackground(new Color(255, 255, 255, 145));
                                panelTableTrans.setLayout(new MigLayout(
                                    "insets 0,hidemode 3,gap 0 0",
                                    // columns
                                    "[200:n,fill]" +
                                    "[110:n,sizegroup 1,fill]" +
                                    "[110:n,sizegroup 1,fill]" +
                                    "[110:n,fill]" +
                                    "[110:n,sizegroup 0,fill]",
                                    // rows
                                    "[40:n,fill]" +
                                    "[40:n,fill]" +
                                    "[40:n,fill]" +
                                    "[40:n,fill]" +
                                    "[40:n,fill]" +
                                    "[40:n,fill]"));

                                //---- label13 ----
                                label13.setText("Pou\u017e\u00edvate\u013e");
                                label13.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
                                label13.setHorizontalAlignment(SwingConstants.CENTER);
                                label13.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(label13, "cell 0 0");

                                //---- label6 ----
                                label6.setText("Typ");
                                label6.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
                                label6.setHorizontalAlignment(SwingConstants.CENTER);
                                label6.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(label6, "cell 1 0");

                                //---- label5 ----
                                label5.setText("D\u00e1tum");
                                label5.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
                                label5.setHorizontalAlignment(SwingConstants.CENTER);
                                label5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(label5, "cell 2 0");

                                //---- label11 ----
                                label11.setText("\u010cas");
                                label11.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
                                label11.setHorizontalAlignment(SwingConstants.CENTER);
                                label11.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(label11, "cell 3 0");

                                //---- label12 ----
                                label12.setText("Suma");
                                label12.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
                                label12.setHorizontalAlignment(SwingConstants.CENTER);
                                label12.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                label12.setBackground(Color.white);
                                panelTableTrans.add(label12, "cell 4 0");

                                //---- transakciaPouzivatel1 ----
                                transakciaPouzivatel1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaPouzivatel1.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaPouzivatel1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaPouzivatel1, "cell 0 1");

                                //---- transakciaTyp1 ----
                                transakciaTyp1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaTyp1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                transakciaTyp1.setHorizontalAlignment(SwingConstants.CENTER);
                                panelTableTrans.add(transakciaTyp1, "cell 1 1");

                                //---- transakciaDatum1 ----
                                transakciaDatum1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaDatum1.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaDatum1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaDatum1, "cell 2 1");

                                //---- transakciaCas1 ----
                                transakciaCas1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaCas1.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaCas1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaCas1, "cell 3 1");

                                //---- transakciaSuma1 ----
                                transakciaSuma1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaSuma1.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaSuma1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaSuma1, "cell 4 1");

                                //---- transakciaPouzivatel2 ----
                                transakciaPouzivatel2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaPouzivatel2.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaPouzivatel2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaPouzivatel2, "cell 0 2");

                                //---- transakciaTyp2 ----
                                transakciaTyp2.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaTyp2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaTyp2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaTyp2, "cell 1 2");

                                //---- transakciaDatum2 ----
                                transakciaDatum2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaDatum2.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaDatum2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaDatum2, "cell 2 2");

                                //---- transakciaCas2 ----
                                transakciaCas2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaCas2.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaCas2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaCas2, "cell 3 2");

                                //---- transakciaSuma2 ----
                                transakciaSuma2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaSuma2.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaSuma2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaSuma2, "cell 4 2");

                                //---- transakciaPouzivatel3 ----
                                transakciaPouzivatel3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaPouzivatel3.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaPouzivatel3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaPouzivatel3, "cell 0 3");

                                //---- transakciaTyp3 ----
                                transakciaTyp3.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaTyp3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaTyp3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaTyp3, "cell 1 3");

                                //---- transakciaDatum3 ----
                                transakciaDatum3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaDatum3.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaDatum3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaDatum3, "cell 2 3");

                                //---- transakciaCas3 ----
                                transakciaCas3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaCas3.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaCas3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaCas3, "cell 3 3");

                                //---- transakciaSuma3 ----
                                transakciaSuma3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaSuma3.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaSuma3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaSuma3, "cell 4 3");

                                //---- transakciaPouzivatel4 ----
                                transakciaPouzivatel4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaPouzivatel4.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaPouzivatel4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaPouzivatel4, "cell 0 4");

                                //---- transakciaTyp4 ----
                                transakciaTyp4.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaTyp4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaTyp4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaTyp4, "cell 1 4");

                                //---- transakciaDatum4 ----
                                transakciaDatum4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaDatum4.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaDatum4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaDatum4, "cell 2 4");

                                //---- transakciaCas4 ----
                                transakciaCas4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaCas4.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaCas4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaCas4, "cell 3 4");

                                //---- transakciaSuma4 ----
                                transakciaSuma4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaSuma4.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaSuma4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaSuma4, "cell 4 4");

                                //---- transakciaPouzivatel5 ----
                                transakciaPouzivatel5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaPouzivatel5.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaPouzivatel5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaPouzivatel5, "cell 0 5");

                                //---- transakciaTyp5 ----
                                transakciaTyp5.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaTyp5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaTyp5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaTyp5, "cell 1 5");

                                //---- transakciaDatum5 ----
                                transakciaDatum5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaDatum5.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaDatum5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaDatum5, "cell 2 5");

                                //---- transakciaCas5 ----
                                transakciaCas5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaCas5.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaCas5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaCas5, "cell 3 5");

                                //---- transakciaSuma5 ----
                                transakciaSuma5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                transakciaSuma5.setHorizontalAlignment(SwingConstants.CENTER);
                                transakciaSuma5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableTrans.add(transakciaSuma5, "cell 4 5");
                            }
                            panelTransakcie.add(panelTableTrans, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 15, 0), 0, 0));

                            //======== kGradientPanel2 ========
                            {
                                kGradientPanel2.setkEndColor(Color.white);
                                kGradientPanel2.setkStartColor(Color.white);
                                kGradientPanel2.setBackground(Color.white);
                                kGradientPanel2.setkBorderRadius(0);
                                kGradientPanel2.setLayout(new FormLayout(
                                    "71dlu, 290dlu, 71dlu",
                                    "21dlu"));

                                //---- btnSpatTransakcie ----
                                btnSpatTransakcie.setText("Sp\u00e4\u0165");
                                btnSpatTransakcie.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                btnSpatTransakcie.setBorder(null);
                                btnSpatTransakcie.setkStartColor(new Color(73, 196, 174));
                                btnSpatTransakcie.setkEndColor(new Color(140, 219, 145));
                                btnSpatTransakcie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                btnSpatTransakcie.setkHoverEndColor(new Color(73, 196, 174));
                                btnSpatTransakcie.setkHoverStartColor(new Color(52, 188, 183));
                                btnSpatTransakcie.setkHoverForeGround(Color.white);
                                btnSpatTransakcie.setBackground(Color.white);
                                btnSpatTransakcie.setBorderPainted(false);
                                btnSpatTransakcie.addActionListener(e -> btnSpatTransakcieActionPerformed());
                                kGradientPanel2.add(btnSpatTransakcie, CC.xy(1, 1, CC.LEFT, CC.DEFAULT));

                                //---- btnExportovat ----
                                btnExportovat.setText("Exportova\u0165 do s\u00faboru");
                                btnExportovat.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                btnExportovat.setBorder(null);
                                btnExportovat.setkStartColor(new Color(255, 161, 117));
                                btnExportovat.setkEndColor(new Color(239, 102, 96));
                                btnExportovat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                btnExportovat.setkHoverEndColor(new Color(255, 161, 117));
                                btnExportovat.setkHoverStartColor(new Color(239, 102, 96));
                                btnExportovat.setkHoverForeGround(Color.white);
                                btnExportovat.setBackground(Color.white);
                                btnExportovat.setBorderPainted(false);
                                btnExportovat.setMaximumSize(new Dimension(97, 24));
                                btnExportovat.setMinimumSize(new Dimension(97, 24));
                                btnExportovat.addActionListener(e -> btnExportovatActionPerformed());
                                kGradientPanel2.add(btnExportovat, new CellConstraints(2, 1, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 120, 0, 120)));

                                //---- btnDalsieTransakcie ----
                                btnDalsieTransakcie.setText("\u010eal\u0161ie");
                                btnDalsieTransakcie.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                btnDalsieTransakcie.setBorder(null);
                                btnDalsieTransakcie.setkStartColor(new Color(73, 196, 174));
                                btnDalsieTransakcie.setkEndColor(new Color(140, 219, 145));
                                btnDalsieTransakcie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                btnDalsieTransakcie.setkHoverEndColor(new Color(73, 196, 174));
                                btnDalsieTransakcie.setkHoverStartColor(new Color(52, 188, 183));
                                btnDalsieTransakcie.setkHoverForeGround(Color.white);
                                btnDalsieTransakcie.setBackground(Color.white);
                                btnDalsieTransakcie.setBorderPainted(false);
                                btnDalsieTransakcie.setMaximumSize(new Dimension(97, 24));
                                btnDalsieTransakcie.setMinimumSize(new Dimension(97, 24));
                                btnDalsieTransakcie.addActionListener(e -> btnDalsieTransakcieActionPerformed());
                                kGradientPanel2.add(btnDalsieTransakcie, CC.xy(3, 1));
                            }
                            panelTransakcie.add(kGradientPanel2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                        }
                        panelContent.add(panelTransakcie, "transakcie");
                    }
                    splitPane2.setBottomComponent(panelContent);
                }

                GroupLayout panelRightSideLayout = new GroupLayout(panelRightSide);
                panelRightSide.setLayout(panelRightSideLayout);
                panelRightSideLayout.setHorizontalGroup(
                    panelRightSideLayout.createParallelGroup()
                        .addComponent(splitPane2, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                );
                panelRightSideLayout.setVerticalGroup(
                    panelRightSideLayout.createParallelGroup()
                        .addComponent(splitPane2, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                );
            }
            splitPane1.setRightComponent(panelRightSide);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addComponent(splitPane1, GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE))
                .addGap(0, 1018, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addComponent(splitPane1))
                .addGap(0, 600, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik Vrbovský
    private JSplitPane splitPane1;
    private KGradientPanel panelMenu;
    private JLabel labelIcon;
    private JLabel labelAdministrator;
    private KButton btnObjednavky;
    private KButton btnJedalnyListok;
    private KButton btnTransakcie;
    private KButton btnPouzivatel;
    private KGradientPanel panelRightSide;
    private JSplitPane splitPane2;
    private KGradientPanel panelStravovaciSystem;
    private JLabel labelStravovaciSystem;
    private JLabel labelDatum;
    private JLabel labelX;
    private JLabel label4;
    private KGradientPanel panelContent;
    private KGradientPanel panelJedalnyListok;
    private KGradientPanel panelJedalnyListokRanajky;
    private JLabel label2;
    private KGradientPanel panelJedalnyListokRanajkyInside;
    private JLabel label40;
    private JLabel label3;
    private JLabel label28;
    private JLabel label29;
    private JLabel label30;
    private JLabel label59;
    private JTextField txtJedLisRanajkyNazov1;
    private JPanel panel5;
    private JComboBox<String> comBoxJedLisRanajkyNapoj1;
    private JTextField txtJedLisRanakKapacita1;
    private JTextField txtJedLisRanakCena1;
    private JLabel label44;
    private JTextField txtJedLisRanajkyNazov2;
    private JPanel panel4;
    private JComboBox<String> comBoxJedLisRanajkyNapoj2;
    private JTextField txtJedLisRanakKapacita2;
    private JTextField txtJedLisRanakCena2;
    private JLabel label73;
    private JTextField txtJedLisRanajkyNazov3;
    private JPanel panel3;
    private JComboBox<String> comBoxJedLisRanajkyNapoj3;
    private JTextField txtJedLisRanakKapacita3;
    private JTextField txtJedLisRanakCena3;
    private JLabel label78;
    private JTextField txtJedLisRanajkyNazov4;
    private JPanel panel2;
    private JComboBox<String> comBoxJedLisRanajkyNapoj4;
    private JTextField txtJedLisRanakKapacita4;
    private JTextField txtJedLisRanakCena4;
    private JLabel label83;
    private JTextField txtJedLisRanajkyNazov5;
    private JPanel panel1;
    private JComboBox<String> comBoxJedLisRanajkyNapoj5;
    private JTextField txtJedLisRanakKapacita5;
    private JTextField txtJedLisRanakCena5;
    private JLabel labelWarningJedLisRanajky;
    private KButton btnJedLisRanjakyPokracovat;
    private KGradientPanel panelJedalnyListokObed;
    private JLabel label7;
    private KGradientPanel panelJedalnyListokObedInside;
    private JLabel label72;
    private JLabel label10;
    private JLabel label75;
    private JLabel label76;
    private JLabel label77;
    private JLabel label80;
    private JTextField textField8;
    private JPanel panel6;
    private JComboBox<String> comboBox12;
    private JTextField textField45;
    private JTextField textField46;
    private JLabel label81;
    private JTextField textField47;
    private JPanel panel7;
    private JComboBox<String> comboBox13;
    private JTextField textField48;
    private JTextField textField49;
    private JLabel label82;
    private JTextField textField50;
    private JPanel panel8;
    private JComboBox<String> comboBox14;
    private JTextField textField51;
    private JTextField textField52;
    private JLabel label85;
    private JTextField textField53;
    private JPanel panel9;
    private JComboBox<String> comboBox15;
    private JTextField textField54;
    private JTextField textField55;
    private JLabel label86;
    private JTextField textField56;
    private JPanel panel10;
    private JComboBox<String> comboBox16;
    private JTextField textField57;
    private JTextField textField58;
    private KButton btnJedalnyListokSpatObed;
    private JLabel labelWarningJedLisObed;
    private KButton btnJedLisObedPokracovat;
    private KGradientPanel panelJedalnyListokVytvorit;
    private KGradientPanel panelJedalnyListokInside;
    private JLabel labelJedalnyListokVytvoritInisde;
    private KButton btnJedalnyListokVytvoritInside;
    private KButton btnJedalnyListokVytvoritInside2;
    private JLabel labelWarningJedLisVytvorit;
    private KGradientPanel panelObjednavky;
    private JSplitPane splitPane3;
    private KGradientPanel panelMenuObjednavky;
    private KButton btnRanajky;
    private KButton btnObed;
    private KGradientPanel panelContentObjednavky;
    private KGradientPanel panelObjednavkyRanajky;
    private KGradientPanel panelTableRanajky;
    private JLabel label36;
    private JLabel label1;
    private JLabel label8;
    private JLabel label9;
    private JLabel label46;
    private JLabel labelObjednavkyRanajkyNazov1;
    private JLabel labelObjednavkyRanajkyNapoj1;
    private JLabel labelObjednavkyRanajkyPocet1;
    private JLabel label32;
    private JLabel labelObjednavkyRanajkyNazov2;
    private JLabel labelObjednavkyRanajkyNapoj2;
    private JLabel labelObjednavkyRanajkyPocet2;
    private JLabel label33;
    private JLabel labelObjednavkyRanajkyNazov3;
    private JLabel labelObjednavkyRanajkyNapoj3;
    private JLabel labelObjednavkyRanajkyPocet3;
    private JLabel label34;
    private JLabel labelObjednavkyRanajkyNazov4;
    private JLabel labelObjednavkyRanajkyNapoj4;
    private JLabel labelObjednavkyRanajkyPocet4;
    private JLabel label35;
    private JLabel labelObjednavkyRanajkyNazov5;
    private JLabel labelObjednavkyRanajkyNapoj5;
    private JLabel labelObjednavkyRanajkyPocet5;
    private JLabel labelWarningPocetObjednavkyRanajky;
    private KGradientPanel panelObjednavkyObed;
    private KGradientPanel panelTableObed;
    private JLabel label38;
    private JLabel label21;
    private JLabel label24;
    private JLabel label39;
    private JLabel label47;
    private JLabel labelObjednavkyObedNazov1;
    private JLabel labelObjednavkyObedTakeway1;
    private JLabel labelObjednavkyObedPocet1;
    private JLabel label45;
    private JLabel labelObjednavkyObedNazov2;
    private JLabel labelObjednavkyObedTakeway2;
    private JLabel labelObjednavkyObedPocet2;
    private JLabel label54;
    private JLabel labelObjednavkyObedNazov3;
    private JLabel labelObjednavkyObedTakeway3;
    private JLabel labelObjednavkyObedPocet3;
    private JLabel label60;
    private JLabel labelObjednavkyObedNazov4;
    private JLabel labelObjednavkyObedTakeway4;
    private JLabel labelObjednavkyObedPocet4;
    private JLabel label65;
    private JLabel labelObjednavkyObedNazov5;
    private JLabel labelObjednavkyObedTakeway5;
    private JLabel labelObjednavkyObedPocet5;
    private JLabel labelWarningPocetObjednavkyObed;
    private KGradientPanel panelTransakcie;
    private KGradientPanel panelForCombosInTrans;
    private JLabel labelZobrazit2;
    private JTextField fielCeleMeno;
    private JLabel labelZiadneTransakcie;
    private JLabel labelZobrazit;
    private JComboBox<String> comboBoxZobrazit;
    private JLabel labelZoradit;
    private JComboBox<String> comboBoxZoradit;
    private KGradientPanel panelTableTrans;
    private JLabel label13;
    private JLabel label6;
    private JLabel label5;
    private JLabel label11;
    private JLabel label12;
    private JLabel transakciaPouzivatel1;
    private JLabel transakciaTyp1;
    private JLabel transakciaDatum1;
    private JLabel transakciaCas1;
    private JLabel transakciaSuma1;
    private JLabel transakciaPouzivatel2;
    private JLabel transakciaTyp2;
    private JLabel transakciaDatum2;
    private JLabel transakciaCas2;
    private JLabel transakciaSuma2;
    private JLabel transakciaPouzivatel3;
    private JLabel transakciaTyp3;
    private JLabel transakciaDatum3;
    private JLabel transakciaCas3;
    private JLabel transakciaSuma3;
    private JLabel transakciaPouzivatel4;
    private JLabel transakciaTyp4;
    private JLabel transakciaDatum4;
    private JLabel transakciaCas4;
    private JLabel transakciaSuma4;
    private JLabel transakciaPouzivatel5;
    private JLabel transakciaTyp5;
    private JLabel transakciaDatum5;
    private JLabel transakciaCas5;
    private JLabel transakciaSuma5;
    private KGradientPanel kGradientPanel2;
    private KButton btnSpatTransakcie;
    private KButton btnExportovat;
    private KButton btnDalsieTransakcie;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
