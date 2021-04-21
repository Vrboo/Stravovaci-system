/*
 * Created by JFormDesigner on Mon Apr 19 20:48:55 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import java.awt.event.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import info.clearthought.layout.*;

import keeptoo.*;
import net.miginfocom.swing.*;
import sk.dominikvrbovsky.User;
import sk.dominikvrbovsky.utilities.Utilities;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;

/**
 * @author Dominik Vrbovsky
 */
public class UserInterface extends JFrame {
    private final User user;
    private final EntityManager entityManager;
    private final CardLayout cardLayout;
    

    public UserInterface(EntityManager entityManager, User user) {
        this.entityManager = entityManager;
        this.user = user;

        String userAccount = String.format("%.2f", user.getAccount());

        this.setPreferredSize(new Dimension(1000, 600));
        
        initComponents();
        
        this.cardLayout = (CardLayout)(panelContent.getLayout());
        
        labelUsername.setText(user.getFullName());
        labelAccount.setText("Stav účtu: " + userAccount + "€");
        this.labelDatum.setText(Utilities.buildSlovakTimeString());
        
        btnObjednat.setSelected(true);
        
    }

    private void btnObjednatActionPerformed() {
        cardLayout.show(panelContent,"objednat");
    }

    private void btnMojeObjedActionPerformed() {
        cardLayout.show(panelContent, "mojeObjednavky");
    }

    private void btnBurzaActionPerformed() {
        cardLayout.show(panelContent,"burza");
    }

    private void btnUcetActionPerformed() {
        cardLayout.show(panelContent,"ucet");
    }

    private void btnZmenitCisloActionPerformed() {
        cardLayout.show(panelContent,"zmenitHeslo");
    }

    private void btnOdhlasitSaActionPerformed() {
        cardLayout.show(panelContent,"odhlasitSa");
    }

    private void btnAdminActionPerformed() {
        cardLayout.show(panelContent,"admin");
    }
    

    private void labelXObjednatMouseEntered() {
        labelX.setIcon(
                new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_x_18px_6.png"));
    }

    private void labelXObjednatMouseExited() {
        labelX.setIcon(new 
                ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_x_18px.png"));
    }

    private void labelXObjednatMouseClicked() {
        entityManager.close();
        System.exit(0);
    }
    

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
        splitPane1 = new JSplitPane();
        panelMenu = new KGradientPanel();
        labelIcon = new JLabel();
        labelUsername = new JLabel();
        btnObjednat = new KButton();
        btnMojeObjed = new KButton();
        btnBurza = new KButton();
        btnUcet = new KButton();
        btnZmenitHeslo = new KButton();
        btnOdhlasitSa = new KButton();
        labelAccount = new JLabel();
        btnAdmin = new KButton();
        panelRightSide = new KGradientPanel();
        splitPane2 = new JSplitPane();
        panelStravovaciSystem = new KGradientPanel();
        labelStravovaciSystem = new JLabel();
        labelDatum = new JLabel();
        labelX = new JLabel();
        panelContent = new KGradientPanel();
        panelObjednat = new KGradientPanel();
        splitPane3 = new JSplitPane();
        panelMenuObjednat = new KGradientPanel();
        kButton2 = new KButton();
        kButton1 = new KButton();
        panelContentObjednat = new KGradientPanel();
        panelRanajky = new KGradientPanel();
        panelTableRanajky = new KGradientPanel();
        label36 = new JLabel();
        label1 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label37 = new JLabel();
        label31 = new JLabel();
        label11 = new JLabel();
        label16 = new JLabel();
        label25 = new JLabel();
        label26 = new JLabel();
        kButton3 = new KButton();
        label32 = new JLabel();
        label12 = new JLabel();
        label17 = new JLabel();
        label24 = new JLabel();
        label27 = new JLabel();
        kButton4 = new KButton();
        label33 = new JLabel();
        label13 = new JLabel();
        label18 = new JLabel();
        label23 = new JLabel();
        label28 = new JLabel();
        kButton5 = new KButton();
        label34 = new JLabel();
        label15 = new JLabel();
        label19 = new JLabel();
        label22 = new JLabel();
        label29 = new JLabel();
        kButton6 = new KButton();
        label35 = new JLabel();
        label14 = new JLabel();
        label20 = new JLabel();
        label21 = new JLabel();
        label30 = new JLabel();
        kButton7 = new KButton();
        panelMojeObjednavky = new KGradientPanel();
        label2 = new JLabel();
        panelBurza = new KGradientPanel();
        label3 = new JLabel();
        panelUcet = new KGradientPanel();
        label4 = new JLabel();
        panelZmenitHeslo = new KGradientPanel();
        label5 = new JLabel();
        panelOdhlasitSa = new KGradientPanel();
        label6 = new JLabel();
        panelAdmin = new KGradientPanel();
        label7 = new JLabel();

        //======== this ========
        setUndecorated(true);
        setResizable(false);
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
                panelMenu.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
                (0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax.swing.border
                .TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
                .Color.red),panelMenu. getBorder()));panelMenu. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void
                propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException()
                ;}});

                //---- labelIcon ----
                labelIcon.setHorizontalAlignment(SwingConstants.CENTER);
                labelIcon.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_checked_user_male_85px_1.png"));

                //---- labelUsername ----
                labelUsername.setHorizontalAlignment(SwingConstants.CENTER);
                labelUsername.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                labelUsername.setForeground(new Color(50, 187, 186));
                labelUsername.setText("Dominik Vrbovsk\u00fd");

                //---- btnObjednat ----
                btnObjednat.setText("Objedna\u0165");
                btnObjednat.setkBorderRadius(0);
                btnObjednat.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnObjednat.setkEndColor(new Color(55, 55, 55));
                btnObjednat.setkStartColor(new Color(55, 55, 55));
                btnObjednat.setBorder(null);
                btnObjednat.setkHoverEndColor(Color.gray);
                btnObjednat.setkHoverStartColor(new Color(55, 55, 55));
                btnObjednat.setkHoverForeGround(Color.white);
                btnObjednat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnObjednat.setkAllowTab(true);
                btnObjednat.setkSelectedColor(new Color(67, 67, 67));
                btnObjednat.setkIndicatorColor(new Color(50, 187, 186));
                btnObjednat.setkIndicatorThickness(5);
                btnObjednat.addActionListener(e -> btnObjednatActionPerformed());

                //---- btnMojeObjed ----
                btnMojeObjed.setText("Moje objedn\u00e1vky");
                btnMojeObjed.setkBorderRadius(0);
                btnMojeObjed.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnMojeObjed.setkEndColor(new Color(55, 55, 55));
                btnMojeObjed.setkStartColor(new Color(55, 55, 55));
                btnMojeObjed.setBorder(null);
                btnMojeObjed.setkHoverEndColor(Color.gray);
                btnMojeObjed.setkHoverStartColor(new Color(55, 55, 55));
                btnMojeObjed.setkHoverForeGround(Color.white);
                btnMojeObjed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnMojeObjed.setkAllowTab(true);
                btnMojeObjed.setkSelectedColor(new Color(67, 67, 67));
                btnMojeObjed.setkIndicatorColor(new Color(50, 187, 186));
                btnMojeObjed.setkIndicatorThickness(5);
                btnMojeObjed.addActionListener(e -> btnMojeObjedActionPerformed());

                //---- btnBurza ----
                btnBurza.setText("Burza");
                btnBurza.setkBorderRadius(0);
                btnBurza.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnBurza.setkEndColor(new Color(55, 55, 55));
                btnBurza.setkStartColor(new Color(55, 55, 55));
                btnBurza.setBorder(null);
                btnBurza.setkHoverEndColor(Color.gray);
                btnBurza.setkHoverStartColor(new Color(55, 55, 55));
                btnBurza.setkHoverForeGround(Color.white);
                btnBurza.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnBurza.setkAllowTab(true);
                btnBurza.setkSelectedColor(new Color(67, 67, 67));
                btnBurza.setkIndicatorColor(new Color(50, 187, 186));
                btnBurza.setkIndicatorThickness(5);
                btnBurza.addActionListener(e -> btnBurzaActionPerformed());

                //---- btnUcet ----
                btnUcet.setText("\u00da\u010det");
                btnUcet.setkBorderRadius(0);
                btnUcet.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnUcet.setkEndColor(new Color(55, 55, 55));
                btnUcet.setkStartColor(new Color(55, 55, 55));
                btnUcet.setBorder(null);
                btnUcet.setkHoverEndColor(Color.gray);
                btnUcet.setkHoverStartColor(new Color(55, 55, 55));
                btnUcet.setkHoverForeGround(Color.white);
                btnUcet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnUcet.setkAllowTab(true);
                btnUcet.setkSelectedColor(new Color(67, 67, 67));
                btnUcet.setkIndicatorColor(new Color(50, 187, 186));
                btnUcet.setkIndicatorThickness(5);
                btnUcet.addActionListener(e -> btnUcetActionPerformed());

                //---- btnZmenitHeslo ----
                btnZmenitHeslo.setText("Zmeni\u0165 heslo");
                btnZmenitHeslo.setkBorderRadius(0);
                btnZmenitHeslo.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnZmenitHeslo.setkEndColor(new Color(55, 55, 55));
                btnZmenitHeslo.setkStartColor(new Color(55, 55, 55));
                btnZmenitHeslo.setBorder(null);
                btnZmenitHeslo.setkHoverEndColor(Color.gray);
                btnZmenitHeslo.setkHoverStartColor(new Color(55, 55, 55));
                btnZmenitHeslo.setkHoverForeGround(Color.white);
                btnZmenitHeslo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnZmenitHeslo.setkAllowTab(true);
                btnZmenitHeslo.setkSelectedColor(new Color(67, 67, 67));
                btnZmenitHeslo.setkIndicatorColor(new Color(50, 187, 186));
                btnZmenitHeslo.setkIndicatorThickness(5);
                btnZmenitHeslo.addActionListener(e -> btnZmenitCisloActionPerformed());

                //---- btnOdhlasitSa ----
                btnOdhlasitSa.setText("Odhl\u00e1si\u0165 sa");
                btnOdhlasitSa.setkBorderRadius(0);
                btnOdhlasitSa.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnOdhlasitSa.setkEndColor(new Color(55, 55, 55));
                btnOdhlasitSa.setkStartColor(new Color(55, 55, 55));
                btnOdhlasitSa.setBorder(null);
                btnOdhlasitSa.setkHoverEndColor(Color.gray);
                btnOdhlasitSa.setkHoverStartColor(new Color(55, 55, 55));
                btnOdhlasitSa.setkHoverForeGround(Color.white);
                btnOdhlasitSa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnOdhlasitSa.setkAllowTab(true);
                btnOdhlasitSa.setkSelectedColor(new Color(67, 67, 67));
                btnOdhlasitSa.setkIndicatorColor(new Color(50, 187, 186));
                btnOdhlasitSa.setkIndicatorThickness(5);
                btnOdhlasitSa.addActionListener(e -> btnOdhlasitSaActionPerformed());

                //---- labelAccount ----
                labelAccount.setText("Stav \u00fa\u010dtu: 5.45\u20ac");
                labelAccount.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                labelAccount.setHorizontalAlignment(SwingConstants.CENTER);
                labelAccount.setForeground(new Color(50, 187, 186));
                labelAccount.setVerticalAlignment(SwingConstants.TOP);

                //---- btnAdmin ----
                btnAdmin.setText("Administr\u00e1tor");
                btnAdmin.setkBorderRadius(0);
                btnAdmin.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnAdmin.setkEndColor(new Color(55, 55, 55));
                btnAdmin.setkStartColor(new Color(55, 55, 55));
                btnAdmin.setBorder(null);
                btnAdmin.setkHoverEndColor(Color.gray);
                btnAdmin.setkHoverStartColor(new Color(55, 55, 55));
                btnAdmin.setkForeGround(Color.lightGray);
                btnAdmin.setkIndicatorThickness(5);
                btnAdmin.setkHoverForeGround(Color.red);
                btnAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnAdmin.setkSelectedColor(new Color(67, 67, 67));
                btnAdmin.addActionListener(e -> btnAdminActionPerformed());

                GroupLayout panelMenuLayout = new GroupLayout(panelMenu);
                panelMenu.setLayout(panelMenuLayout);
                panelMenuLayout.setHorizontalGroup(
                    panelMenuLayout.createParallelGroup()
                        .addComponent(btnObjednat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMojeObjed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBurza, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUcet, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnZmenitHeslo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOdhlasitSa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdmin, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelMenuLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelMenuLayout.createParallelGroup()
                                .addComponent(labelUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelAccount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panelMenuLayout.setVerticalGroup(
                    panelMenuLayout.createParallelGroup()
                        .addGroup(panelMenuLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(labelIcon)
                            .addGap(0, 0, 0)
                            .addComponent(labelUsername)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelAccount)
                            .addGap(34, 34, 34)
                            .addComponent(btnObjednat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btnMojeObjed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btnBurza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btnUcet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btnZmenitHeslo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btnOdhlasitSa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                            .addComponent(btnAdmin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(17, 17, 17))
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
                    splitPane2.setDividerLocation(160);

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
                        labelDatum.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                        labelDatum.setForeground(new Color(70, 70, 70));
                        labelDatum.setHorizontalAlignment(SwingConstants.LEFT);

                        //---- labelX ----
                        labelX.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_x_18px.png"));
                        labelX.setHorizontalAlignment(SwingConstants.CENTER);
                        labelX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        labelX.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                labelXObjednatMouseClicked();
                            }
                            @Override
                            public void mouseEntered(MouseEvent e) {
                                labelXObjednatMouseEntered();
                            }
                            @Override
                            public void mouseExited(MouseEvent e) {
                                labelXObjednatMouseExited();
                            }
                        });

                        GroupLayout panelStravovaciSystemLayout = new GroupLayout(panelStravovaciSystem);
                        panelStravovaciSystem.setLayout(panelStravovaciSystemLayout);
                        panelStravovaciSystemLayout.setHorizontalGroup(
                            panelStravovaciSystemLayout.createParallelGroup()
                                .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(panelStravovaciSystemLayout.createParallelGroup()
                                        .addComponent(labelStravovaciSystem, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelDatum, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                                    .addComponent(labelX, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                        );
                        panelStravovaciSystemLayout.setVerticalGroup(
                            panelStravovaciSystemLayout.createParallelGroup()
                                .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                    .addComponent(labelX, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(labelStravovaciSystem, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(labelDatum, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(33, Short.MAX_VALUE))
                        );
                    }
                    splitPane2.setTopComponent(panelStravovaciSystem);

                    //======== panelContent ========
                    {
                        panelContent.setLayout(new CardLayout());

                        //======== panelObjednat ========
                        {
                            panelObjednat.setkEndColor(Color.white);
                            panelObjednat.setkStartColor(Color.white);

                            //======== splitPane3 ========
                            {
                                splitPane3.setBorder(null);
                                splitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);
                                splitPane3.setDividerSize(0);
                                splitPane3.setDividerLocation(36);
                                splitPane3.setBackground(new Color(55, 55, 55));

                                //======== panelMenuObjednat ========
                                {
                                    panelMenuObjednat.setkStartColor(new Color(55, 55, 55));
                                    panelMenuObjednat.setkEndColor(new Color(55, 55, 55));
                                    panelMenuObjednat.setkBorderRadius(0);
                                    panelMenuObjednat.setBackground(new Color(55, 55, 55));
                                    panelMenuObjednat.setkGradientFocus(700);
                                    panelMenuObjednat.setForeground(new Color(55, 55, 55));

                                    //---- kButton2 ----
                                    kButton2.setText("Obed");
                                    kButton2.setBorder(null);
                                    kButton2.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                    kButton2.setkStartColor(new Color(70, 70, 70));
                                    kButton2.setkEndColor(new Color(70, 70, 70));
                                    kButton2.setkForeGround(new Color(38, 184, 190));
                                    kButton2.setkBorderRadius(0);
                                    kButton2.setkAllowTab(true);

                                    //---- kButton1 ----
                                    kButton1.setText("Ranajky");
                                    kButton1.setBorder(null);
                                    kButton1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                    kButton1.setkStartColor(new Color(70, 70, 70));
                                    kButton1.setkEndColor(new Color(70, 70, 70));
                                    kButton1.setkForeGround(new Color(38, 184, 190));
                                    kButton1.setkBorderRadius(0);
                                    kButton1.setkAllowTab(true);

                                    GroupLayout panelMenuObjednatLayout = new GroupLayout(panelMenuObjednat);
                                    panelMenuObjednat.setLayout(panelMenuObjednatLayout);
                                    panelMenuObjednatLayout.setHorizontalGroup(
                                        panelMenuObjednatLayout.createParallelGroup()
                                            .addGroup(panelMenuObjednatLayout.createSequentialGroup()
                                                .addComponent(kButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(kButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    );
                                    panelMenuObjednatLayout.setVerticalGroup(
                                        panelMenuObjednatLayout.createParallelGroup()
                                            .addComponent(kButton2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(kButton1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                    );
                                }
                                splitPane3.setTopComponent(panelMenuObjednat);

                                //======== panelContentObjednat ========
                                {
                                    panelContentObjednat.setBackground(new Color(55, 55, 55));
                                    panelContentObjednat.setLayout(new CardLayout());

                                    //======== panelRanajky ========
                                    {
                                        panelRanajky.setkEndColor(Color.white);
                                        panelRanajky.setkStartColor(Color.white);
                                        panelRanajky.setkBorderRadius(0);
                                        panelRanajky.setkGradientFocus(600);
                                        panelRanajky.setBorder(null);

                                        //======== panelTableRanajky ========
                                        {
                                            panelTableRanajky.setkEndColor(Color.white);
                                            panelTableRanajky.setkStartColor(Color.white);
                                            panelTableRanajky.setBorder(null);
                                            panelTableRanajky.setkBorderRadius(0);
                                            panelTableRanajky.setBackground(Color.white);
                                            panelTableRanajky.setLayout(new TableLayout(new double[][] {
                                                {38, 239, 126, 92, 72, 101},
                                                {44, 40, 40, 40, 40, 40}}));

                                            //---- label36 ----
                                            label36.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label36, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label1 ----
                                            label1.setText("N\u00e1zov");
                                            label1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label1.setHorizontalAlignment(SwingConstants.CENTER);
                                            label1.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label1, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label8 ----
                                            label8.setText("N\u00e1poj");
                                            label8.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label8.setHorizontalAlignment(SwingConstants.CENTER);
                                            label8.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label8, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label9 ----
                                            label9.setText("Kapacita");
                                            label9.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label9.setHorizontalAlignment(SwingConstants.CENTER);
                                            label9.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label9, new TableLayoutConstraints(3, 0, 3, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label10 ----
                                            label10.setText("Cena");
                                            label10.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label10.setHorizontalAlignment(SwingConstants.CENTER);
                                            label10.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label10, new TableLayoutConstraints(4, 0, 4, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label37 ----
                                            label37.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label37, new TableLayoutConstraints(5, 0, 5, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label31 ----
                                            label31.setText("1.");
                                            label31.setHorizontalAlignment(SwingConstants.CENTER);
                                            label31.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label31.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label31, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label11 ----
                                            label11.setText("Parky s hor\u010dicou a chlebom");
                                            label11.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label11.setHorizontalAlignment(SwingConstants.CENTER);
                                            label11.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label11, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label16 ----
                                            label16.setText("Miner\u00e1lna voda");
                                            label16.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label16.setHorizontalAlignment(SwingConstants.CENTER);
                                            label16.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label16, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label25 ----
                                            label25.setText("78x");
                                            label25.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label25.setHorizontalAlignment(SwingConstants.CENTER);
                                            label25.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label25, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label26 ----
                                            label26.setText("4.87\u20ac");
                                            label26.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label26.setHorizontalAlignment(SwingConstants.CENTER);
                                            label26.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label26, new TableLayoutConstraints(4, 1, 4, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- kButton3 ----
                                            kButton3.setText("Objedna\u0165");
                                            kButton3.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                            kButton3.setBorder(null);
                                            kButton3.setkStartColor(new Color(253, 152, 119));
                                            kButton3.setkEndColor(new Color(251, 127, 123));
                                            panelTableRanajky.add(kButton3, new TableLayoutConstraints(5, 1, 5, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label32 ----
                                            label32.setText("2.");
                                            label32.setHorizontalAlignment(SwingConstants.CENTER);
                                            label32.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label32.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label32, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label12 ----
                                            label12.setText("Pra\u017eenica s ro\u017ekom");
                                            label12.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label12.setHorizontalAlignment(SwingConstants.CENTER);
                                            label12.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label12, new TableLayoutConstraints(1, 2, 1, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label17 ----
                                            label17.setText("Cola");
                                            label17.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label17.setHorizontalAlignment(SwingConstants.CENTER);
                                            label17.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label17, new TableLayoutConstraints(2, 2, 2, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label24 ----
                                            label24.setText("12x");
                                            label24.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label24.setHorizontalAlignment(SwingConstants.CENTER);
                                            label24.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label24, new TableLayoutConstraints(3, 2, 3, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label27 ----
                                            label27.setText("2.45\u20ac");
                                            label27.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label27.setHorizontalAlignment(SwingConstants.CENTER);
                                            label27.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label27, new TableLayoutConstraints(4, 2, 4, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- kButton4 ----
                                            kButton4.setText("Objedna\u0165");
                                            kButton4.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                            kButton4.setBorder(null);
                                            kButton4.setkStartColor(new Color(252, 146, 126));
                                            kButton4.setkEndColor(new Color(251, 127, 123));
                                            panelTableRanajky.add(kButton4, new TableLayoutConstraints(5, 2, 5, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label33 ----
                                            label33.setText("3.");
                                            label33.setHorizontalAlignment(SwingConstants.CENTER);
                                            label33.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label33.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label33, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label13 ----
                                            label13.setText("Lievance s lekv\u00e1rom");
                                            label13.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label13.setHorizontalAlignment(SwingConstants.CENTER);
                                            label13.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label13, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label18 ----
                                            label18.setText("\u010caj");
                                            label18.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label18.setHorizontalAlignment(SwingConstants.CENTER);
                                            label18.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label18, new TableLayoutConstraints(2, 3, 2, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label23 ----
                                            label23.setText("78x");
                                            label23.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label23.setHorizontalAlignment(SwingConstants.CENTER);
                                            label23.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label23, new TableLayoutConstraints(3, 3, 3, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label28 ----
                                            label28.setText("3.72\u20ac");
                                            label28.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label28.setHorizontalAlignment(SwingConstants.CENTER);
                                            label28.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label28, new TableLayoutConstraints(4, 3, 4, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- kButton5 ----
                                            kButton5.setText("Objedna\u0165");
                                            kButton5.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                            kButton5.setBorder(null);
                                            kButton5.setkStartColor(new Color(252, 146, 126));
                                            kButton5.setkEndColor(new Color(251, 127, 123));
                                            panelTableRanajky.add(kButton5, new TableLayoutConstraints(5, 3, 5, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label34 ----
                                            label34.setText("4.");
                                            label34.setHorizontalAlignment(SwingConstants.CENTER);
                                            label34.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label34.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label34, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label15 ----
                                            label15.setText("Volsk\u00e9 oko s ke\u010dup a chlebom");
                                            label15.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label15.setHorizontalAlignment(SwingConstants.CENTER);
                                            label15.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label15, new TableLayoutConstraints(1, 4, 1, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label19 ----
                                            label19.setText("Miner\u00e1lna voda");
                                            label19.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label19.setHorizontalAlignment(SwingConstants.CENTER);
                                            label19.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label19, new TableLayoutConstraints(2, 4, 2, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label22 ----
                                            label22.setText("123x");
                                            label22.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label22.setHorizontalAlignment(SwingConstants.CENTER);
                                            label22.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label22, new TableLayoutConstraints(3, 4, 3, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label29 ----
                                            label29.setText("7.00\u20ac");
                                            label29.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label29.setHorizontalAlignment(SwingConstants.CENTER);
                                            label29.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label29, new TableLayoutConstraints(4, 4, 4, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- kButton6 ----
                                            kButton6.setText("Objedna\u0165");
                                            kButton6.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                            kButton6.setBorder(null);
                                            kButton6.setkStartColor(new Color(252, 146, 126));
                                            kButton6.setkEndColor(new Color(251, 127, 123));
                                            panelTableRanajky.add(kButton6, new TableLayoutConstraints(5, 4, 5, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label35 ----
                                            label35.setText("5.");
                                            label35.setHorizontalAlignment(SwingConstants.CENTER);
                                            label35.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label35.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label35, new TableLayoutConstraints(0, 5, 0, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label14 ----
                                            label14.setText("\u0160unkov\u00e1 bageta");
                                            label14.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label14.setHorizontalAlignment(SwingConstants.CENTER);
                                            label14.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label14, new TableLayoutConstraints(1, 5, 1, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label20 ----
                                            label20.setText("\u010e\u017e\u00fas");
                                            label20.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label20.setHorizontalAlignment(SwingConstants.CENTER);
                                            label20.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label20, new TableLayoutConstraints(2, 5, 2, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label21 ----
                                            label21.setText("63x");
                                            label21.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label21.setHorizontalAlignment(SwingConstants.CENTER);
                                            label21.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label21, new TableLayoutConstraints(3, 5, 3, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- label30 ----
                                            label30.setText("3.49\u20ac");
                                            label30.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
                                            label30.setHorizontalAlignment(SwingConstants.CENTER);
                                            label30.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                            panelTableRanajky.add(label30, new TableLayoutConstraints(4, 5, 4, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                                            //---- kButton7 ----
                                            kButton7.setText("Objedna\u0165");
                                            kButton7.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                            kButton7.setBorder(null);
                                            kButton7.setkStartColor(new Color(252, 146, 126));
                                            kButton7.setkEndColor(new Color(251, 127, 123));
                                            panelTableRanajky.add(kButton7, new TableLayoutConstraints(5, 5, 5, 5, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                                        }

                                        GroupLayout panelRanajkyLayout = new GroupLayout(panelRanajky);
                                        panelRanajky.setLayout(panelRanajkyLayout);
                                        panelRanajkyLayout.setHorizontalGroup(
                                            panelRanajkyLayout.createParallelGroup()
                                                .addGroup(panelRanajkyLayout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(panelTableRanajky, GroupLayout.PREFERRED_SIZE, 689, GroupLayout.PREFERRED_SIZE)
                                                    .addContainerGap(16, Short.MAX_VALUE))
                                        );
                                        panelRanajkyLayout.setVerticalGroup(
                                            panelRanajkyLayout.createParallelGroup()
                                                .addGroup(panelRanajkyLayout.createSequentialGroup()
                                                    .addGap(26, 26, 26)
                                                    .addComponent(panelTableRanajky, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
                                                    .addContainerGap(30, Short.MAX_VALUE))
                                        );
                                    }
                                    panelContentObjednat.add(panelRanajky, "ranajky");
                                }
                                splitPane3.setBottomComponent(panelContentObjednat);
                            }

                            GroupLayout panelObjednatLayout = new GroupLayout(panelObjednat);
                            panelObjednat.setLayout(panelObjednatLayout);
                            panelObjednatLayout.setHorizontalGroup(
                                panelObjednatLayout.createParallelGroup()
                                    .addComponent(splitPane3)
                            );
                            panelObjednatLayout.setVerticalGroup(
                                panelObjednatLayout.createParallelGroup()
                                    .addComponent(splitPane3)
                            );
                        }
                        panelContent.add(panelObjednat, "objednat");

                        //======== panelMojeObjednavky ========
                        {
                            panelMojeObjednavky.setkEndColor(Color.white);
                            panelMojeObjednavky.setkStartColor(Color.white);

                            //---- label2 ----
                            label2.setText("Moje objednavkz");

                            GroupLayout panelMojeObjednavkyLayout = new GroupLayout(panelMojeObjednavky);
                            panelMojeObjednavky.setLayout(panelMojeObjednavkyLayout);
                            panelMojeObjednavkyLayout.setHorizontalGroup(
                                panelMojeObjednavkyLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panelMojeObjednavkyLayout.createSequentialGroup()
                                        .addContainerGap(396, Short.MAX_VALUE)
                                        .addComponent(label2)
                                        .addGap(236, 236, 236))
                            );
                            panelMojeObjednavkyLayout.setVerticalGroup(
                                panelMojeObjednavkyLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panelMojeObjednavkyLayout.createSequentialGroup()
                                        .addContainerGap(211, Short.MAX_VALUE)
                                        .addComponent(label2)
                                        .addGap(171, 171, 171))
                            );
                        }
                        panelContent.add(panelMojeObjednavky, "mojeObjednavky");

                        //======== panelBurza ========
                        {
                            panelBurza.setkEndColor(Color.white);
                            panelBurza.setkStartColor(Color.white);

                            //---- label3 ----
                            label3.setText("burza");

                            GroupLayout panelBurzaLayout = new GroupLayout(panelBurza);
                            panelBurza.setLayout(panelBurzaLayout);
                            panelBurzaLayout.setHorizontalGroup(
                                panelBurzaLayout.createParallelGroup()
                                    .addGroup(panelBurzaLayout.createSequentialGroup()
                                        .addGap(253, 253, 253)
                                        .addComponent(label3)
                                        .addContainerGap(440, Short.MAX_VALUE))
                            );
                            panelBurzaLayout.setVerticalGroup(
                                panelBurzaLayout.createParallelGroup()
                                    .addGroup(panelBurzaLayout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(label3)
                                        .addContainerGap(319, Short.MAX_VALUE))
                            );
                        }
                        panelContent.add(panelBurza, "burza");

                        //======== panelUcet ========
                        {
                            panelUcet.setkEndColor(Color.white);
                            panelUcet.setkStartColor(Color.white);

                            //---- label4 ----
                            label4.setText("ucet");

                            GroupLayout panelUcetLayout = new GroupLayout(panelUcet);
                            panelUcet.setLayout(panelUcetLayout);
                            panelUcetLayout.setHorizontalGroup(
                                panelUcetLayout.createParallelGroup()
                                    .addGroup(panelUcetLayout.createSequentialGroup()
                                        .addGap(280, 280, 280)
                                        .addComponent(label4)
                                        .addContainerGap(421, Short.MAX_VALUE))
                            );
                            panelUcetLayout.setVerticalGroup(
                                panelUcetLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panelUcetLayout.createSequentialGroup()
                                        .addContainerGap(214, Short.MAX_VALUE)
                                        .addComponent(label4)
                                        .addGap(168, 168, 168))
                            );
                        }
                        panelContent.add(panelUcet, "ucet");

                        //======== panelZmenitHeslo ========
                        {
                            panelZmenitHeslo.setkEndColor(Color.white);
                            panelZmenitHeslo.setkStartColor(Color.white);

                            //---- label5 ----
                            label5.setText("zmenit heslo");

                            GroupLayout panelZmenitHesloLayout = new GroupLayout(panelZmenitHeslo);
                            panelZmenitHeslo.setLayout(panelZmenitHesloLayout);
                            panelZmenitHesloLayout.setHorizontalGroup(
                                panelZmenitHesloLayout.createParallelGroup()
                                    .addGroup(panelZmenitHesloLayout.createSequentialGroup()
                                        .addGap(220, 220, 220)
                                        .addComponent(label5)
                                        .addContainerGap(436, Short.MAX_VALUE))
                            );
                            panelZmenitHesloLayout.setVerticalGroup(
                                panelZmenitHesloLayout.createParallelGroup()
                                    .addGroup(panelZmenitHesloLayout.createSequentialGroup()
                                        .addGap(120, 120, 120)
                                        .addComponent(label5)
                                        .addContainerGap(262, Short.MAX_VALUE))
                            );
                        }
                        panelContent.add(panelZmenitHeslo, "zmenitHeslo");

                        //======== panelOdhlasitSa ========
                        {
                            panelOdhlasitSa.setkEndColor(Color.white);
                            panelOdhlasitSa.setkStartColor(Color.white);

                            //---- label6 ----
                            label6.setText("odhlasit sa");

                            GroupLayout panelOdhlasitSaLayout = new GroupLayout(panelOdhlasitSa);
                            panelOdhlasitSa.setLayout(panelOdhlasitSaLayout);
                            panelOdhlasitSaLayout.setHorizontalGroup(
                                panelOdhlasitSaLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panelOdhlasitSaLayout.createSequentialGroup()
                                        .addContainerGap(390, Short.MAX_VALUE)
                                        .addComponent(label6)
                                        .addGap(276, 276, 276))
                            );
                            panelOdhlasitSaLayout.setVerticalGroup(
                                panelOdhlasitSaLayout.createParallelGroup()
                                    .addGroup(panelOdhlasitSaLayout.createSequentialGroup()
                                        .addGap(133, 133, 133)
                                        .addComponent(label6)
                                        .addContainerGap(249, Short.MAX_VALUE))
                            );
                        }
                        panelContent.add(panelOdhlasitSa, "odhlasitSa");

                        //======== panelAdmin ========
                        {
                            panelAdmin.setkEndColor(Color.white);
                            panelAdmin.setkStartColor(Color.white);

                            //---- label7 ----
                            label7.setText("Admin");

                            GroupLayout panelAdminLayout = new GroupLayout(panelAdmin);
                            panelAdmin.setLayout(panelAdminLayout);
                            panelAdminLayout.setHorizontalGroup(
                                panelAdminLayout.createParallelGroup()
                                    .addGroup(panelAdminLayout.createSequentialGroup()
                                        .addGap(269, 269, 269)
                                        .addComponent(label7)
                                        .addContainerGap(419, Short.MAX_VALUE))
                            );
                            panelAdminLayout.setVerticalGroup(
                                panelAdminLayout.createParallelGroup()
                                    .addGroup(panelAdminLayout.createSequentialGroup()
                                        .addGap(122, 122, 122)
                                        .addComponent(label7)
                                        .addContainerGap(260, Short.MAX_VALUE))
                            );
                        }
                        panelContent.add(panelAdmin, "admin");
                    }
                    splitPane2.setBottomComponent(panelContent);
                }

                GroupLayout panelRightSideLayout = new GroupLayout(panelRightSide);
                panelRightSide.setLayout(panelRightSideLayout);
                panelRightSideLayout.setHorizontalGroup(
                    panelRightSideLayout.createParallelGroup()
                        .addComponent(splitPane2)
                );
                panelRightSideLayout.setVerticalGroup(
                    panelRightSideLayout.createParallelGroup()
                        .addComponent(splitPane2)
                );
            }
            splitPane1.setRightComponent(panelRightSide);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(splitPane1)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(splitPane1)
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
    private JSplitPane splitPane1;
    private KGradientPanel panelMenu;
    private JLabel labelIcon;
    private JLabel labelUsername;
    private KButton btnObjednat;
    private KButton btnMojeObjed;
    private KButton btnBurza;
    private KButton btnUcet;
    private KButton btnZmenitHeslo;
    private KButton btnOdhlasitSa;
    private JLabel labelAccount;
    private KButton btnAdmin;
    private KGradientPanel panelRightSide;
    private JSplitPane splitPane2;
    private KGradientPanel panelStravovaciSystem;
    private JLabel labelStravovaciSystem;
    private JLabel labelDatum;
    private JLabel labelX;
    private KGradientPanel panelContent;
    private KGradientPanel panelObjednat;
    private JSplitPane splitPane3;
    private KGradientPanel panelMenuObjednat;
    private KButton kButton2;
    private KButton kButton1;
    private KGradientPanel panelContentObjednat;
    private KGradientPanel panelRanajky;
    private KGradientPanel panelTableRanajky;
    private JLabel label36;
    private JLabel label1;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label37;
    private JLabel label31;
    private JLabel label11;
    private JLabel label16;
    private JLabel label25;
    private JLabel label26;
    private KButton kButton3;
    private JLabel label32;
    private JLabel label12;
    private JLabel label17;
    private JLabel label24;
    private JLabel label27;
    private KButton kButton4;
    private JLabel label33;
    private JLabel label13;
    private JLabel label18;
    private JLabel label23;
    private JLabel label28;
    private KButton kButton5;
    private JLabel label34;
    private JLabel label15;
    private JLabel label19;
    private JLabel label22;
    private JLabel label29;
    private KButton kButton6;
    private JLabel label35;
    private JLabel label14;
    private JLabel label20;
    private JLabel label21;
    private JLabel label30;
    private KButton kButton7;
    private KGradientPanel panelMojeObjednavky;
    private JLabel label2;
    private KGradientPanel panelBurza;
    private JLabel label3;
    private KGradientPanel panelUcet;
    private JLabel label4;
    private KGradientPanel panelZmenitHeslo;
    private JLabel label5;
    private KGradientPanel panelOdhlasitSa;
    private JLabel label6;
    private KGradientPanel panelAdmin;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
