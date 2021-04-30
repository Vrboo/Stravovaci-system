/*
 * Created by JFormDesigner on Fri Apr 23 20:16:11 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.text.NumberFormatter;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import keeptoo.*;
import net.miginfocom.swing.*;
import sk.dominikvrbovsky.Breakfast;
import sk.dominikvrbovsky.User;
import sk.dominikvrbovsky.dao.impl.MealDao;
import sk.dominikvrbovsky.enums.Drink;
import sk.dominikvrbovsky.utilities.DateUtilities;

/**
 * @author Dominik Vrbovsky
 */
public class AdministratorInterface extends JFrame {
    private final EntityManager entityManager;
    private final User user;
    private final CardLayout cardLayout;
    private final CardLayout cardLayoutObjednavky;
    private final CardLayout cardLayoutJedalnyListok;
    
    
    public AdministratorInterface(EntityManager entityManager, User user) {
        this.entityManager = entityManager;
        this.user = user;

        this.setPreferredSize(new Dimension(1000, 600));
        
        initComponents();

        this.cardLayout = (CardLayout)(panelContent.getLayout());
        this.cardLayoutObjednavky = (CardLayout)(panelContentObjednavky.getLayout());
        this.cardLayoutJedalnyListok = (CardLayout)(panelJedalnyListok.getLayout());

        this.labelDatum.setText(DateUtilities.buildSlovakTimeString());

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

    private void setIntFormatters(JFormattedTextField formatter) {
        NumberFormat numFormat = new DecimalFormat("#0.00");
        NumberFormatter  numFormatter  = new NumberFormatter(numFormat);
        formatter = new JFormattedTextField(numFormatter);
    }

    private void btnRanajkyActionPerformed() {
        cardLayoutObjednavky.show(panelContentObjednavky, "ranajky");
    }

    private void btnObedActionPerformed() {
        cardLayoutObjednavky.show(panelContentObjednavky, "obed");
    }

    private void btnObjednavkyActionPerformed() {
        cardLayout.show(panelContent, "objednavky");
    }

    private void btnJedalnyListokActionPerformed() {
        cardLayout.show(panelContent, "jedalnyListok");
    }

    private void labelXMouseClicked() {
        entityManager.close();
        System.exit(0);
    }

    private void labelXMouseEntered() {
        labelX.setIcon(
                new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_x_18px_6.png"));
    }

    private void labelXMouseExited() {
        labelX.setIcon(new
                ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_x_18px.png"));
    }

    private void btnTransakcieActionPerformed() {
        cardLayout.show(panelContent,"transakcie");
    }

    private void kButton4ActionPerformed() {
//        Component[][] components = createCompomentArray(panelJedalnyListokRanajkyInside.getComponents());
//        MealDao mealDao = new MealDao(entityManager);
//        for (int i = 0; i < components.length; i++) {
//            String name = ((JTextField)components[i][0]).getText();
//            String drink = (String)((JComboBox<String>)components[i][1]).getSelectedItem();
//            String capacity = ((JTextField)components[i][2]).getText();
//            String price = ((JTextField)components[i][3]).getText();
//            mealDao.save(new Breakfast(name, Double.parseDouble(price), Integer.parseInt(capacity),Drink.getEnumFromString(drink)));
//        }

        cardLayoutJedalnyListok.show(panelJedalnyListok, "obed");
    }

    private Component[][] createCompomentArray(Component[] c) {
        Component[][] components = new Component[5][4];
        int index = 6;

        for (int i = 0; i < components.length; i++) {
            for (int j = 0; j < components[i].length; j++ ) {
                components[i][j] = c[index];
                index++;
                if (index % 5 == 0) index++;
            }
        }
        return components;
    }

    private void btnJedalnyListokSpatObedActionPerformed() {
        cardLayoutJedalnyListok.show(panelJedalnyListok, "ranajky");
    }

    private void btnJedalnyListokPokracovatObedActionPerformed() {
        cardLayoutJedalnyListok.show(panelJedalnyListok, "vytvorit");
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
        comBoxJedLisRanajkyNapoj1 = new JComboBox<>();
        txtJedLisRanakKapacita1 = new JTextField();
        txtJedLisRanakCena1 = new JTextField();
        label44 = new JLabel();
        txtJedLisRanajkyNazov2 = new JTextField();
        comBoxJedLisRanajkyNapoj2 = new JComboBox<>();
        txtJedLisRanakKapacita2 = new JTextField();
        txtJedLisRanakCena2 = new JTextField();
        label73 = new JLabel();
        txtJedLisRanajkyNazov3 = new JTextField();
        comBoxJedLisRanajkyNapoj3 = new JComboBox<>();
        txtJedLisRanakKapacita3 = new JTextField();
        txtJedLisRanakCena3 = new JTextField();
        label78 = new JLabel();
        txtJedLisRanajkyNazov4 = new JTextField();
        comBoxJedLisRanajkyNapoj4 = new JComboBox<>();
        txtJedLisRanakKapacita4 = new JTextField();
        txtJedLisRanakCena4 = new JTextField();
        label83 = new JLabel();
        txtJedLisRanajkyNazov5 = new JTextField();
        comBoxJedLisRanajkyNapoj5 = new JComboBox<>();
        txtJedLisRanakKapacita5 = new JTextField();
        txtJedLisRanakCena5 = new JTextField();
        labelWarningJedLisRanajky = new JLabel();
        kButton4 = new KButton();
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
        comboBox12 = new JComboBox<>();
        textField45 = new JTextField();
        textField46 = new JTextField();
        label81 = new JLabel();
        textField47 = new JTextField();
        comboBox13 = new JComboBox<>();
        textField48 = new JTextField();
        textField49 = new JTextField();
        label82 = new JLabel();
        textField50 = new JTextField();
        comboBox14 = new JComboBox<>();
        textField51 = new JTextField();
        textField52 = new JTextField();
        label85 = new JLabel();
        textField53 = new JTextField();
        comboBox15 = new JComboBox<>();
        textField54 = new JTextField();
        textField55 = new JTextField();
        label86 = new JLabel();
        textField56 = new JTextField();
        comboBox16 = new JComboBox<>();
        textField57 = new JTextField();
        textField58 = new JTextField();
        btnJedalnyListokSpatObed = new KButton();
        labelWarningJedLisObed = new JLabel();
        btnJedalnyListokPokracovatObed = new KButton();
        panelJedalnyListokVytvorit = new KGradientPanel();
        panelJedalnyListokInside = new KGradientPanel();
        labelJedalnyListokVytvoritInisde = new JLabel();
        btnJedalnyListokVytvoritInside = new KButton();
        btnJedalnyListokVytvoritInside2 = new KButton();
        label5 = new JLabel();
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
        label11 = new JLabel();
        label51 = new JLabel();
        label25 = new JLabel();
        label32 = new JLabel();
        label12 = new JLabel();
        label17 = new JLabel();
        label31 = new JLabel();
        label33 = new JLabel();
        label13 = new JLabel();
        label18 = new JLabel();
        label23 = new JLabel();
        label34 = new JLabel();
        label15 = new JLabel();
        label19 = new JLabel();
        label22 = new JLabel();
        label35 = new JLabel();
        label14 = new JLabel();
        label20 = new JLabel();
        label56 = new JLabel();
        label16 = new JLabel();
        panelObjednavkyObed = new KGradientPanel();
        panelTableObed = new KGradientPanel();
        label38 = new JLabel();
        label21 = new JLabel();
        label24 = new JLabel();
        label39 = new JLabel();
        label47 = new JLabel();
        label42 = new JLabel();
        label52 = new JLabel();
        label43 = new JLabel();
        label45 = new JLabel();
        label48 = new JLabel();
        label49 = new JLabel();
        label50 = new JLabel();
        label54 = new JLabel();
        label55 = new JLabel();
        label57 = new JLabel();
        label58 = new JLabel();
        label60 = new JLabel();
        label61 = new JLabel();
        label62 = new JLabel();
        label63 = new JLabel();
        label65 = new JLabel();
        label66 = new JLabel();
        label67 = new JLabel();
        label68 = new JLabel();
        label70 = new JLabel();
        panelTransakcie = new KGradientPanel();

        //======== this ========
        setUndecorated(true);
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
                .swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing
                .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
                Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt.Color.red
                ),panelMenu. getBorder()));panelMenu. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
                public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName(
                )))throw new RuntimeException();}});

                //---- labelIcon ----
                labelIcon.setHorizontalAlignment(SwingConstants.CENTER);
                labelIcon.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_user_shield_85px_5.png"));

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
                btnPouzivatel.setkHoverForeGround(Color.red);
                btnPouzivatel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnPouzivatel.setkSelectedColor(new Color(67, 67, 67));
                btnPouzivatel.setkAllowTab(true);
                btnPouzivatel.setkIndicatorColor(new Color(50, 187, 186));

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
                        labelX.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_x_18px.png"));
                        labelX.setHorizontalAlignment(SwingConstants.CENTER);
                        labelX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        labelX.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                labelXMouseClicked();
                            }
                            @Override
                            public void mouseEntered(MouseEvent e) {
                                labelXMouseEntered();
                            }
                            @Override
                            public void mouseExited(MouseEvent e) {
                                labelXMouseExited();
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
                                        .addComponent(labelDatum, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelStravovaciSystem, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE))
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
                                    .addContainerGap(21, Short.MAX_VALUE)
                                    .addGroup(panelStravovaciSystemLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelStravovaciSystem)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(labelDatum, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38))
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
                                    "[36:n,fill]"));

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
                                    label40.setText("s");
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
                                    label59.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label59, CC.xy(1, 2));

                                    //---- txtJedLisRanajkyNazov1 ----
                                    txtJedLisRanajkyNazov1.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanajkyNazov1.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanajkyNazov1.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanajkyNazov1.setText("Hovno1");
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanajkyNazov1, CC.xy(2, 2));

                                    //---- comBoxJedLisRanajkyNapoj1 ----
                                    comBoxJedLisRanajkyNapoj1.setBorder(null);
                                    comBoxJedLisRanajkyNapoj1.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "Cola",
                                        "Min. voda",
                                        "\u010caj",
                                        "D\u017e\u00fas"
                                    }));
                                    comBoxJedLisRanajkyNapoj1.setBackground(Color.lightGray);
                                    comBoxJedLisRanajkyNapoj1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comBoxJedLisRanajkyNapoj1.setSelectedIndex(-1);
                                    panelJedalnyListokRanajkyInside.add(comBoxJedLisRanajkyNapoj1, new CellConstraints(3, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- txtJedLisRanakKapacita1 ----
                                    txtJedLisRanakKapacita1.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanakKapacita1.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakKapacita1.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakKapacita1.setColumns(5);
                                    txtJedLisRanakKapacita1.setText("a");
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
                                    txtJedLisRanakCena1.setText("a");
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
                                    label44.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label44, CC.xy(1, 3));

                                    //---- txtJedLisRanajkyNazov2 ----
                                    txtJedLisRanajkyNazov2.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanajkyNazov2.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanajkyNazov2.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanajkyNazov2.setText("Hovno2");
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanajkyNazov2, CC.xy(2, 3));

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
                                    panelJedalnyListokRanajkyInside.add(comBoxJedLisRanajkyNapoj2, new CellConstraints(3, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- txtJedLisRanakKapacita2 ----
                                    txtJedLisRanakKapacita2.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanakKapacita2.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakKapacita2.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakKapacita2.setText("a");
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
                                    txtJedLisRanakCena2.setText("a");
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
                                    label73.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label73, CC.xy(1, 4));

                                    //---- txtJedLisRanajkyNazov3 ----
                                    txtJedLisRanajkyNazov3.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanajkyNazov3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanajkyNazov3.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanajkyNazov3.setText("Hovno3");
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanajkyNazov3, CC.xy(2, 4));

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
                                    panelJedalnyListokRanajkyInside.add(comBoxJedLisRanajkyNapoj3, new CellConstraints(3, 4, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- txtJedLisRanakKapacita3 ----
                                    txtJedLisRanakKapacita3.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanakKapacita3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakKapacita3.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakKapacita3.setText("a");
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
                                    txtJedLisRanakCena3.setText("a");
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
                                    label78.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label78, CC.xy(1, 5));

                                    //---- txtJedLisRanajkyNazov4 ----
                                    txtJedLisRanajkyNazov4.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanajkyNazov4.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanajkyNazov4.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanajkyNazov4.setText("Hovno4");
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanajkyNazov4, CC.xy(2, 5));

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
                                    panelJedalnyListokRanajkyInside.add(comBoxJedLisRanajkyNapoj4, new CellConstraints(3, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- txtJedLisRanakKapacita4 ----
                                    txtJedLisRanakKapacita4.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanakKapacita4.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakKapacita4.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakKapacita4.setText("a");
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
                                    txtJedLisRanakCena4.setText("a");
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
                                    label83.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label83, CC.xy(1, 6));

                                    //---- txtJedLisRanajkyNazov5 ----
                                    txtJedLisRanajkyNazov5.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanajkyNazov5.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanajkyNazov5.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanajkyNazov5.setText("Hovno5");
                                    panelJedalnyListokRanajkyInside.add(txtJedLisRanajkyNazov5, CC.xy(2, 6));

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
                                    panelJedalnyListokRanajkyInside.add(comBoxJedLisRanajkyNapoj5, new CellConstraints(3, 6, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- txtJedLisRanakKapacita5 ----
                                    txtJedLisRanakKapacita5.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    txtJedLisRanakKapacita5.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    txtJedLisRanakKapacita5.setHorizontalAlignment(SwingConstants.CENTER);
                                    txtJedLisRanakKapacita5.setText("a");
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
                                    txtJedLisRanakCena5.setText("a");
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
                                labelWarningJedLisRanajky.setText("Vypl\u0148te v\u0161etky polo\u017eky, pros\u00edm");
                                panelJedalnyListokRanajky.add(labelWarningJedLisRanajky, "cell 0 2");

                                //---- kButton4 ----
                                kButton4.setText("Pokra\u010dova\u0165");
                                kButton4.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                kButton4.setBorder(null);
                                kButton4.setkStartColor(new Color(73, 196, 174));
                                kButton4.setkEndColor(new Color(140, 219, 145));
                                kButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                kButton4.setkHoverEndColor(new Color(73, 196, 174));
                                kButton4.setkHoverStartColor(new Color(52, 188, 183));
                                kButton4.setkHoverForeGround(Color.white);
                                kButton4.setBackground(Color.white);
                                kButton4.setBorderPainted(false);
                                kButton4.addActionListener(e -> kButton4ActionPerformed());
                                panelJedalnyListokRanajky.add(kButton4, "cell 0 2,alignx right,growx 0,width 110,hmax 30,gapx null 0");
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
                                    "[36:n,fill]"));

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
                                    label80.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label80, CC.xy(1, 2));

                                    //---- textField8 ----
                                    textField8.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField8.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField8.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField8, CC.xy(2, 2));

                                    //---- comboBox12 ----
                                    comboBox12.setBorder(null);
                                    comboBox12.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "\u00c1no",
                                        "Nie"
                                    }));
                                    comboBox12.setBackground(Color.lightGray);
                                    comboBox12.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox12.setSelectedIndex(-1);
                                    panelJedalnyListokObedInside.add(comboBox12, new CellConstraints(3, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

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
                                    label81.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label81, CC.xy(1, 3));

                                    //---- textField47 ----
                                    textField47.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField47.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField47.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField47, CC.xy(2, 3));

                                    //---- comboBox13 ----
                                    comboBox13.setBorder(null);
                                    comboBox13.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "\u00c1no",
                                        "Nie"
                                    }));
                                    comboBox13.setBackground(Color.lightGray);
                                    comboBox13.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox13.setSelectedIndex(-1);
                                    panelJedalnyListokObedInside.add(comboBox13, new CellConstraints(3, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

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
                                    label82.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label82, CC.xy(1, 4));

                                    //---- textField50 ----
                                    textField50.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField50.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField50.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField50, CC.xy(2, 4));

                                    //---- comboBox14 ----
                                    comboBox14.setBorder(null);
                                    comboBox14.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "\u00c1no",
                                        "Nie"
                                    }));
                                    comboBox14.setBackground(Color.lightGray);
                                    comboBox14.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox14.setSelectedIndex(-1);
                                    panelJedalnyListokObedInside.add(comboBox14, new CellConstraints(3, 4, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

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
                                    label85.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label85, CC.xy(1, 5));

                                    //---- textField53 ----
                                    textField53.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField53.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField53.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField53, CC.xy(2, 5));

                                    //---- comboBox15 ----
                                    comboBox15.setBorder(null);
                                    comboBox15.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "\u00c1no",
                                        "Nie"
                                    }));
                                    comboBox15.setBackground(Color.lightGray);
                                    comboBox15.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox15.setSelectedIndex(-1);
                                    panelJedalnyListokObedInside.add(comboBox15, new CellConstraints(3, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

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
                                    label86.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label86, CC.xy(1, 6));

                                    //---- textField56 ----
                                    textField56.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField56.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField56.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField56, CC.xy(2, 6));

                                    //---- comboBox16 ----
                                    comboBox16.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
                                    comboBox16.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "\u00c1no",
                                        "Nie"
                                    }));
                                    comboBox16.setBackground(Color.lightGray);
                                    comboBox16.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox16.setSelectedIndex(-1);
                                    panelJedalnyListokObedInside.add(comboBox16, new CellConstraints(3, 6, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

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
                                btnJedalnyListokSpatObed.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                btnJedalnyListokSpatObed.setBorder(null);
                                btnJedalnyListokSpatObed.setkStartColor(new Color(255, 161, 117));
                                btnJedalnyListokSpatObed.setkEndColor(new Color(224, 31, 23));
                                btnJedalnyListokSpatObed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                btnJedalnyListokSpatObed.setkHoverEndColor(Color.white);
                                btnJedalnyListokSpatObed.setkHoverStartColor(new Color(52, 188, 183));
                                btnJedalnyListokSpatObed.setkHoverForeGround(Color.gray);
                                btnJedalnyListokSpatObed.setBackground(Color.white);
                                btnJedalnyListokSpatObed.setBorderPainted(false);
                                btnJedalnyListokSpatObed.addActionListener(e -> btnJedalnyListokSpatObedActionPerformed());
                                panelJedalnyListokObed.add(btnJedalnyListokSpatObed, "cell 0 2,alignx left,growx 0,width 110,hmax 30,gapx 0");

                                //---- labelWarningJedLisObed ----
                                labelWarningJedLisObed.setText("Vypl\u0148te v\u0161etky polo\u017eky, pros\u00edm");
                                labelWarningJedLisObed.setForeground(Color.red);
                                labelWarningJedLisObed.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                labelWarningJedLisObed.setHorizontalAlignment(SwingConstants.CENTER);
                                panelJedalnyListokObed.add(labelWarningJedLisObed, "cell 0 2");

                                //---- btnJedalnyListokPokracovatObed ----
                                btnJedalnyListokPokracovatObed.setText("Pokra\u010dova\u0165");
                                btnJedalnyListokPokracovatObed.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                btnJedalnyListokPokracovatObed.setBorder(null);
                                btnJedalnyListokPokracovatObed.setkStartColor(new Color(73, 196, 174));
                                btnJedalnyListokPokracovatObed.setkEndColor(new Color(140, 219, 145));
                                btnJedalnyListokPokracovatObed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                btnJedalnyListokPokracovatObed.setkHoverEndColor(new Color(73, 196, 174));
                                btnJedalnyListokPokracovatObed.setkHoverStartColor(new Color(52, 188, 183));
                                btnJedalnyListokPokracovatObed.setkHoverForeGround(Color.white);
                                btnJedalnyListokPokracovatObed.setBackground(Color.white);
                                btnJedalnyListokPokracovatObed.setBorderPainted(false);
                                btnJedalnyListokPokracovatObed.addActionListener(e -> btnJedalnyListokPokracovatObedActionPerformed());
                                panelJedalnyListokObed.add(btnJedalnyListokPokracovatObed, "cell 0 2,alignx right,growx 0,width 110,hmax 30,gapx null 0");
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
                                    btnJedalnyListokVytvoritInside.setkHoverEndColor(new Color(73, 196, 174));
                                    btnJedalnyListokVytvoritInside.setkHoverStartColor(new Color(52, 188, 183));
                                    btnJedalnyListokVytvoritInside.setkHoverForeGround(Color.white);
                                    btnJedalnyListokVytvoritInside.setBackground(Color.white);
                                    btnJedalnyListokVytvoritInside.setBorderPainted(false);
                                    btnJedalnyListokVytvoritInside.setMaximumSize(new Dimension(97, 24));
                                    btnJedalnyListokVytvoritInside.setMinimumSize(new Dimension(97, 24));
                                    btnJedalnyListokVytvoritInside.addActionListener(e -> btnJedalnyListokVytvoritInsideActionPerformed());
                                    panelJedalnyListokInside.add(btnJedalnyListokVytvoritInside, "cell 0 1,wmax 100,hmax 30,gapx 125");

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
                                    panelJedalnyListokInside.add(btnJedalnyListokVytvoritInside2, "pad 0,cell 0 1,aligny center,growy 0,wmax 100,hmax 30,gapx null 125");
                                }
                                panelJedalnyListokVytvorit.add(panelJedalnyListokInside, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                                    new Insets(0, 0, 5, 0), 0, 0));

                                //---- label5 ----
                                label5.setText("Nepodarilo sa vytvori\u0165 nov\u00fd jed\u00e1lny l\u00edstok. Sk\u00faste to znovu.");
                                label5.setHorizontalAlignment(SwingConstants.CENTER);
                                label5.setForeground(Color.red);
                                label5.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                panelJedalnyListokVytvorit.add(label5, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
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

                                        //======== panelTableRanajky ========
                                        {
                                            panelTableRanajky.setkEndColor(Color.white);
                                            panelTableRanajky.setkStartColor(Color.white);
                                            panelTableRanajky.setBorder(null);
                                            panelTableRanajky.setkBorderRadius(0);
                                            panelTableRanajky.setBackground(new Color(255, 255, 255, 145));
                                            panelTableRanajky.setLayout(new FormLayout(
                                                "27px, 306px, 134px, 200px",
                                                "fill:49px, 5*(fill:52px), $lgap, 11dlu"));

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

                                            //---- label11 ----
                                            label11.setText("Parky s hor\u010dicou a chlebom");
                                            label11.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label11.setHorizontalAlignment(SwingConstants.CENTER);
                                            label11.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label11, CC.xy(2, 2));

                                            //---- label51 ----
                                            label51.setText("Miner\u00e1lna voda");
                                            label51.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label51.setHorizontalAlignment(SwingConstants.CENTER);
                                            label51.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label51, CC.xy(3, 2));

                                            //---- label25 ----
                                            label25.setText("78x");
                                            label25.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label25.setHorizontalAlignment(SwingConstants.CENTER);
                                            label25.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label25, CC.xy(4, 2));

                                            //---- label32 ----
                                            label32.setText("2.");
                                            label32.setHorizontalAlignment(SwingConstants.CENTER);
                                            label32.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label32.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label32, CC.xy(1, 3));

                                            //---- label12 ----
                                            label12.setText("Pra\u017eenica s ro\u017ekom");
                                            label12.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label12.setHorizontalAlignment(SwingConstants.CENTER);
                                            label12.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label12, CC.xy(2, 3));

                                            //---- label17 ----
                                            label17.setText("Cola");
                                            label17.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label17.setHorizontalAlignment(SwingConstants.CENTER);
                                            label17.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label17, CC.xy(3, 3));

                                            //---- label31 ----
                                            label31.setText("45x");
                                            label31.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label31.setHorizontalAlignment(SwingConstants.CENTER);
                                            label31.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label31, CC.xy(4, 3));

                                            //---- label33 ----
                                            label33.setText("3.");
                                            label33.setHorizontalAlignment(SwingConstants.CENTER);
                                            label33.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label33.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label33, CC.xy(1, 4));

                                            //---- label13 ----
                                            label13.setText("Lievance s lekv\u00e1rom");
                                            label13.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label13.setHorizontalAlignment(SwingConstants.CENTER);
                                            label13.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label13, CC.xy(2, 4));

                                            //---- label18 ----
                                            label18.setText("\u010caj");
                                            label18.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label18.setHorizontalAlignment(SwingConstants.CENTER);
                                            label18.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label18, CC.xy(3, 4));

                                            //---- label23 ----
                                            label23.setText("78x");
                                            label23.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label23.setHorizontalAlignment(SwingConstants.CENTER);
                                            label23.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label23, CC.xy(4, 4));

                                            //---- label34 ----
                                            label34.setText("4.");
                                            label34.setHorizontalAlignment(SwingConstants.CENTER);
                                            label34.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label34.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label34, CC.xy(1, 5));

                                            //---- label15 ----
                                            label15.setText("Volsk\u00e9 oko s ke\u010dup a chlebom");
                                            label15.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label15.setHorizontalAlignment(SwingConstants.CENTER);
                                            label15.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label15, CC.xy(2, 5));

                                            //---- label19 ----
                                            label19.setText("Miner\u00e1lna voda");
                                            label19.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label19.setHorizontalAlignment(SwingConstants.CENTER);
                                            label19.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label19, CC.xy(3, 5));

                                            //---- label22 ----
                                            label22.setText("123x");
                                            label22.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label22.setHorizontalAlignment(SwingConstants.CENTER);
                                            label22.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label22, CC.xy(4, 5));

                                            //---- label35 ----
                                            label35.setText("5.");
                                            label35.setHorizontalAlignment(SwingConstants.CENTER);
                                            label35.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label35.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label35, CC.xy(1, 6));

                                            //---- label14 ----
                                            label14.setText("\u0160unkov\u00e1 bageta");
                                            label14.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label14.setHorizontalAlignment(SwingConstants.CENTER);
                                            label14.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label14, CC.xy(2, 6));

                                            //---- label20 ----
                                            label20.setText("\u010e\u017e\u00fas");
                                            label20.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label20.setHorizontalAlignment(SwingConstants.CENTER);
                                            label20.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label20, CC.xy(3, 6));

                                            //---- label56 ----
                                            label56.setText("63x");
                                            label56.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label56.setHorizontalAlignment(SwingConstants.CENTER);
                                            label56.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label56, CC.xy(4, 6));
                                            panelTableRanajky.add(label16, CC.xy(1, 8));
                                        }
                                        panelObjednavkyRanajky.add(panelTableRanajky, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
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

                                        //======== panelTableObed ========
                                        {
                                            panelTableObed.setkEndColor(Color.white);
                                            panelTableObed.setkStartColor(Color.white);
                                            panelTableObed.setBorder(null);
                                            panelTableObed.setkBorderRadius(0);
                                            panelTableObed.setBackground(new Color(255, 255, 255, 145));
                                            panelTableObed.setLayout(new FormLayout(
                                                "27px, 306px, 134px, 200px",
                                                "fill:49px, 5*(fill:52px), $lgap, 11dlu"));

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

                                            //---- label42 ----
                                            label42.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label42.setHorizontalAlignment(SwingConstants.CENTER);
                                            label42.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            label42.setText("Kurac\u00ed reze\u0148 + zemiakov\u00e1 ka\u0161a");
                                            panelTableObed.add(label42, CC.xy(2, 2));

                                            //---- label52 ----
                                            label52.setText("\u00c1no");
                                            label52.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label52.setHorizontalAlignment(SwingConstants.CENTER);
                                            label52.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label52, CC.xy(3, 2));

                                            //---- label43 ----
                                            label43.setText("78x");
                                            label43.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label43.setHorizontalAlignment(SwingConstants.CENTER);
                                            label43.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label43, CC.xy(4, 2));

                                            //---- label45 ----
                                            label45.setText("2.");
                                            label45.setHorizontalAlignment(SwingConstants.CENTER);
                                            label45.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label45.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label45, CC.xy(1, 3));

                                            //---- label48 ----
                                            label48.setText("Bryndzov\u00e9 halu\u0161ky");
                                            label48.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label48.setHorizontalAlignment(SwingConstants.CENTER);
                                            label48.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label48, CC.xy(2, 3));

                                            //---- label49 ----
                                            label49.setText("Nie");
                                            label49.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label49.setHorizontalAlignment(SwingConstants.CENTER);
                                            label49.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label49, CC.xy(3, 3));

                                            //---- label50 ----
                                            label50.setText("417x");
                                            label50.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label50.setHorizontalAlignment(SwingConstants.CENTER);
                                            label50.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label50, CC.xy(4, 3));

                                            //---- label54 ----
                                            label54.setText("3.");
                                            label54.setHorizontalAlignment(SwingConstants.CENTER);
                                            label54.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label54.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label54, CC.xy(1, 4));

                                            //---- label55 ----
                                            label55.setText("Palacinky s lekv\u00e1rom");
                                            label55.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label55.setHorizontalAlignment(SwingConstants.CENTER);
                                            label55.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label55, CC.xy(2, 4));

                                            //---- label57 ----
                                            label57.setText("\u00c1no");
                                            label57.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label57.setHorizontalAlignment(SwingConstants.CENTER);
                                            label57.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label57, CC.xy(3, 4));

                                            //---- label58 ----
                                            label58.setText("29x");
                                            label58.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label58.setHorizontalAlignment(SwingConstants.CENTER);
                                            label58.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label58, CC.xy(4, 4));

                                            //---- label60 ----
                                            label60.setText("4.");
                                            label60.setHorizontalAlignment(SwingConstants.CENTER);
                                            label60.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label60.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label60, CC.xy(1, 5));

                                            //---- label61 ----
                                            label61.setText("Pizza Hawai");
                                            label61.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label61.setHorizontalAlignment(SwingConstants.CENTER);
                                            label61.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label61, CC.xy(2, 5));

                                            //---- label62 ----
                                            label62.setText("\u00c1no");
                                            label62.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label62.setHorizontalAlignment(SwingConstants.CENTER);
                                            label62.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label62, CC.xy(3, 5));

                                            //---- label63 ----
                                            label63.setText("75x");
                                            label63.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label63.setHorizontalAlignment(SwingConstants.CENTER);
                                            label63.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label63, CC.xy(4, 5));

                                            //---- label65 ----
                                            label65.setText("5.");
                                            label65.setHorizontalAlignment(SwingConstants.CENTER);
                                            label65.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label65.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label65, CC.xy(1, 6));

                                            //---- label66 ----
                                            label66.setText("\u0160unkov\u00e1 bageta");
                                            label66.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label66.setHorizontalAlignment(SwingConstants.CENTER);
                                            label66.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label66, CC.xy(2, 6));

                                            //---- label67 ----
                                            label67.setText("Nie");
                                            label67.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label67.setHorizontalAlignment(SwingConstants.CENTER);
                                            label67.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label67, CC.xy(3, 6));

                                            //---- label68 ----
                                            label68.setText("0x");
                                            label68.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label68.setHorizontalAlignment(SwingConstants.CENTER);
                                            label68.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label68, CC.xy(4, 6));
                                            panelTableObed.add(label70, CC.xy(1, 8));
                                        }
                                        panelObjednavkyObed.add(panelTableObed, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
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
                            panelTransakcie.setkEndColor(Color.white);
                            panelTransakcie.setkStartColor(Color.white);
                            panelTransakcie.setLayout(new GridBagLayout());
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
    private JComboBox<String> comBoxJedLisRanajkyNapoj1;
    private JTextField txtJedLisRanakKapacita1;
    private JTextField txtJedLisRanakCena1;
    private JLabel label44;
    private JTextField txtJedLisRanajkyNazov2;
    private JComboBox<String> comBoxJedLisRanajkyNapoj2;
    private JTextField txtJedLisRanakKapacita2;
    private JTextField txtJedLisRanakCena2;
    private JLabel label73;
    private JTextField txtJedLisRanajkyNazov3;
    private JComboBox<String> comBoxJedLisRanajkyNapoj3;
    private JTextField txtJedLisRanakKapacita3;
    private JTextField txtJedLisRanakCena3;
    private JLabel label78;
    private JTextField txtJedLisRanajkyNazov4;
    private JComboBox<String> comBoxJedLisRanajkyNapoj4;
    private JTextField txtJedLisRanakKapacita4;
    private JTextField txtJedLisRanakCena4;
    private JLabel label83;
    private JTextField txtJedLisRanajkyNazov5;
    private JComboBox<String> comBoxJedLisRanajkyNapoj5;
    private JTextField txtJedLisRanakKapacita5;
    private JTextField txtJedLisRanakCena5;
    private JLabel labelWarningJedLisRanajky;
    private KButton kButton4;
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
    private JComboBox<String> comboBox12;
    private JTextField textField45;
    private JTextField textField46;
    private JLabel label81;
    private JTextField textField47;
    private JComboBox<String> comboBox13;
    private JTextField textField48;
    private JTextField textField49;
    private JLabel label82;
    private JTextField textField50;
    private JComboBox<String> comboBox14;
    private JTextField textField51;
    private JTextField textField52;
    private JLabel label85;
    private JTextField textField53;
    private JComboBox<String> comboBox15;
    private JTextField textField54;
    private JTextField textField55;
    private JLabel label86;
    private JTextField textField56;
    private JComboBox<String> comboBox16;
    private JTextField textField57;
    private JTextField textField58;
    private KButton btnJedalnyListokSpatObed;
    private JLabel labelWarningJedLisObed;
    private KButton btnJedalnyListokPokracovatObed;
    private KGradientPanel panelJedalnyListokVytvorit;
    private KGradientPanel panelJedalnyListokInside;
    private JLabel labelJedalnyListokVytvoritInisde;
    private KButton btnJedalnyListokVytvoritInside;
    private KButton btnJedalnyListokVytvoritInside2;
    private JLabel label5;
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
    private JLabel label11;
    private JLabel label51;
    private JLabel label25;
    private JLabel label32;
    private JLabel label12;
    private JLabel label17;
    private JLabel label31;
    private JLabel label33;
    private JLabel label13;
    private JLabel label18;
    private JLabel label23;
    private JLabel label34;
    private JLabel label15;
    private JLabel label19;
    private JLabel label22;
    private JLabel label35;
    private JLabel label14;
    private JLabel label20;
    private JLabel label56;
    private JLabel label16;
    private KGradientPanel panelObjednavkyObed;
    private KGradientPanel panelTableObed;
    private JLabel label38;
    private JLabel label21;
    private JLabel label24;
    private JLabel label39;
    private JLabel label47;
    private JLabel label42;
    private JLabel label52;
    private JLabel label43;
    private JLabel label45;
    private JLabel label48;
    private JLabel label49;
    private JLabel label50;
    private JLabel label54;
    private JLabel label55;
    private JLabel label57;
    private JLabel label58;
    private JLabel label60;
    private JLabel label61;
    private JLabel label62;
    private JLabel label63;
    private JLabel label65;
    private JLabel label66;
    private JLabel label67;
    private JLabel label68;
    private JLabel label70;
    private KGradientPanel panelTransakcie;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
