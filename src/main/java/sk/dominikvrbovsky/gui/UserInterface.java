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
    private final CardLayout cardLayoutObjednat;
    

    public UserInterface(EntityManager entityManager, User user) {
        this.entityManager = entityManager;
        this.user = user;

        String userAccount = String.format("%.2f", user.getAccount());

        this.setPreferredSize(new Dimension(1000, 600));
        
        initComponents();
        
        this.cardLayout = (CardLayout)(panelContent.getLayout());
        this.cardLayoutObjednat = (CardLayout)(panelContentObjednat.getLayout());
        
        labelUsername.setText(user.getFullName());
        labelAccount.setText("Stav účtu: " + userAccount + "€");
        this.labelDatum.setText(Utilities.buildSlovakTimeString());



        btnObjednat.setSelected(true);
        btnObjednat.setBorder(new MatteBorder(0,5,0,0, new Color(50, 187, 186)));


        btnRanajky.setSelected(true);
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
        btnRanajky.setSelected(true);
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

    private void btnRanajkyActionPerformed() {
        cardLayoutObjednat.show(panelContentObjednat, "ranajky");
    }

    private void btnObedActionPerformed() {
        cardLayoutObjednat.show(panelContentObjednat, "obed");
    }

    private void btnRanajkyFocusGained() {
        btnRanajky.setBorder(new MatteBorder(0, 0, 4, 0, new Color(52, 188, 183)));
    }

    private void btnRanajkyFocusLost() {
        btnRanajky.setBorder(null);
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
        btnRanajky = new KButton();
        btnObed = new KButton();
        panelContentObjednat = new KGradientPanel();
        panelRanajky = new KGradientPanel();
        panelTableRanajky = new KGradientPanel();
        label36 = new JLabel();
        label1 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label37 = new JLabel();
        label46 = new JLabel();
        label11 = new JLabel();
        label51 = new JLabel();
        label25 = new JLabel();
        label26 = new JLabel();
        kButton3 = new KButton();
        label32 = new JLabel();
        label12 = new JLabel();
        label17 = new JLabel();
        label31 = new JLabel();
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
        label56 = new JLabel();
        label30 = new JLabel();
        kButton7 = new KButton();
        label16 = new JLabel();
        panelObed = new KGradientPanel();
        panelTableObed = new KGradientPanel();
        label38 = new JLabel();
        label21 = new JLabel();
        label24 = new JLabel();
        label39 = new JLabel();
        label40 = new JLabel();
        label41 = new JLabel();
        label47 = new JLabel();
        label42 = new JLabel();
        label52 = new JLabel();
        label43 = new JLabel();
        label44 = new JLabel();
        kButton8 = new KButton();
        label45 = new JLabel();
        label48 = new JLabel();
        label49 = new JLabel();
        label50 = new JLabel();
        label53 = new JLabel();
        kButton9 = new KButton();
        label54 = new JLabel();
        label55 = new JLabel();
        label57 = new JLabel();
        label58 = new JLabel();
        label59 = new JLabel();
        kButton10 = new KButton();
        label60 = new JLabel();
        label61 = new JLabel();
        label62 = new JLabel();
        label63 = new JLabel();
        label64 = new JLabel();
        kButton11 = new KButton();
        label65 = new JLabel();
        label66 = new JLabel();
        label67 = new JLabel();
        label68 = new JLabel();
        label69 = new JLabel();
        kButton12 = new KButton();
        label70 = new JLabel();
        panelMojeObjednavky = new KGradientPanel();
        panelTableRanajky2 = new KGradientPanel();
        label71 = new JLabel();
        label73 = new JLabel();
        label2 = new JLabel();
        label74 = new JLabel();
        label75 = new JLabel();
        label76 = new JLabel();
        label79 = new JLabel();
        label77 = new JLabel();
        label80 = new JLabel();
        kButton13 = new KButton();
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
                panelMenu.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
                swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border
                .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog"
                ,java.awt.Font.BOLD,12),java.awt.Color.red),panelMenu. getBorder
                ()));panelMenu. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
                .beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException
                ();}});

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
                                    .addContainerGap(28, Short.MAX_VALUE))
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
                                splitPane3.setDividerLocation(40);
                                splitPane3.setBackground(new Color(55, 55, 55));

                                //======== panelMenuObjednat ========
                                {
                                    panelMenuObjednat.setkStartColor(new Color(55, 55, 55));
                                    panelMenuObjednat.setkEndColor(new Color(55, 55, 55));
                                    panelMenuObjednat.setkBorderRadius(0);
                                    panelMenuObjednat.setBackground(new Color(55, 55, 55));
                                    panelMenuObjednat.setkGradientFocus(700);
                                    panelMenuObjednat.setForeground(new Color(55, 55, 55));
                                    panelMenuObjednat.setLayout(new FormLayout(
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
                                    btnRanajky.addActionListener(e -> btnRanajkyActionPerformed());
                                    panelMenuObjednat.add(btnRanajky, CC.xy(1, 1));

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
                                    panelMenuObjednat.add(btnObed, CC.xy(3, 1));
                                }
                                splitPane3.setTopComponent(panelMenuObjednat);

                                //======== panelContentObjednat ========
                                {
                                    panelContentObjednat.setBackground(new Color(55, 55, 55));
                                    panelContentObjednat.setLayout(new CardLayout());

                                    //======== panelRanajky ========
                                    {
                                        panelRanajky.setkEndColor(new Color(38, 184, 190, 24));
                                        panelRanajky.setkStartColor(new Color(38, 184, 190, 24));
                                        panelRanajky.setkBorderRadius(0);
                                        panelRanajky.setkGradientFocus(600);
                                        panelRanajky.setBorder(null);
                                        panelRanajky.setBackground(Color.white);
                                        panelRanajky.setkFillBackground(false);
                                        panelRanajky.setLayout(new GridBagLayout());

                                        //======== panelTableRanajky ========
                                        {
                                            panelTableRanajky.setkEndColor(Color.white);
                                            panelTableRanajky.setkStartColor(Color.white);
                                            panelTableRanajky.setBorder(null);
                                            panelTableRanajky.setkBorderRadius(0);
                                            panelTableRanajky.setBackground(new Color(255, 255, 255, 145));
                                            panelTableRanajky.setLayout(new FormLayout(
                                                "27px, 280px, 126px, 92px, 72px, 107px",
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
                                            label9.setText("Vo\u013en\u00e9");
                                            label9.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label9.setHorizontalAlignment(SwingConstants.CENTER);
                                            label9.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            label9.setBackground(Color.white);
                                            panelTableRanajky.add(label9, CC.xy(4, 1));

                                            //---- label10 ----
                                            label10.setText("Cena");
                                            label10.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label10.setHorizontalAlignment(SwingConstants.CENTER);
                                            label10.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label10, CC.xy(5, 1));

                                            //---- label37 ----
                                            label37.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
                                            panelTableRanajky.add(label37, CC.xy(6, 1));

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
                                            label51.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label51.setHorizontalAlignment(SwingConstants.CENTER);
                                            label51.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label51, CC.xy(3, 2));

                                            //---- label25 ----
                                            label25.setText("78x");
                                            label25.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label25.setHorizontalAlignment(SwingConstants.CENTER);
                                            label25.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label25, CC.xy(4, 2));

                                            //---- label26 ----
                                            label26.setText("4.87\u20ac");
                                            label26.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label26.setHorizontalAlignment(SwingConstants.CENTER);
                                            label26.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label26, CC.xy(5, 2));

                                            //---- kButton3 ----
                                            kButton3.setText("Objedna\u0165");
                                            kButton3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            kButton3.setBorder(null);
                                            kButton3.setkStartColor(new Color(73, 196, 174));
                                            kButton3.setkEndColor(new Color(140, 219, 145));
                                            kButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            kButton3.setkHoverEndColor(new Color(73, 196, 174));
                                            kButton3.setkHoverStartColor(new Color(52, 188, 183));
                                            kButton3.setkHoverForeGround(Color.white);
                                            kButton3.setBackground(Color.white);
                                            kButton3.setBorderPainted(false);
                                            panelTableRanajky.add(kButton3, new CellConstraints(6, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 0)));

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
                                            label17.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label17.setHorizontalAlignment(SwingConstants.CENTER);
                                            label17.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label17, CC.xy(3, 3));

                                            //---- label31 ----
                                            label31.setText("45x");
                                            label31.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label31.setHorizontalAlignment(SwingConstants.CENTER);
                                            label31.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label31, CC.xy(4, 3));

                                            //---- label27 ----
                                            label27.setText("2.45\u20ac");
                                            label27.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label27.setHorizontalAlignment(SwingConstants.CENTER);
                                            label27.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label27, CC.xy(5, 3));

                                            //---- kButton4 ----
                                            kButton4.setText("Objedna\u0165");
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
                                            panelTableRanajky.add(kButton4, new CellConstraints(6, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 0)));

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
                                            label18.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label18.setHorizontalAlignment(SwingConstants.CENTER);
                                            label18.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label18, CC.xy(3, 4));

                                            //---- label23 ----
                                            label23.setText("78x");
                                            label23.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label23.setHorizontalAlignment(SwingConstants.CENTER);
                                            label23.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label23, CC.xy(4, 4));

                                            //---- label28 ----
                                            label28.setText("3.72\u20ac");
                                            label28.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label28.setHorizontalAlignment(SwingConstants.CENTER);
                                            label28.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label28, CC.xy(5, 4));

                                            //---- kButton5 ----
                                            kButton5.setText("Objedna\u0165");
                                            kButton5.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            kButton5.setBorder(null);
                                            kButton5.setkStartColor(new Color(73, 196, 174));
                                            kButton5.setkEndColor(new Color(140, 219, 145));
                                            kButton5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            kButton5.setkHoverEndColor(new Color(73, 196, 174));
                                            kButton5.setkHoverStartColor(new Color(52, 188, 183));
                                            kButton5.setkHoverForeGround(Color.white);
                                            kButton5.setBackground(Color.white);
                                            kButton5.setBorderPainted(false);
                                            panelTableRanajky.add(kButton5, new CellConstraints(6, 4, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 0)));

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
                                            label19.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label19.setHorizontalAlignment(SwingConstants.CENTER);
                                            label19.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label19, CC.xy(3, 5));

                                            //---- label22 ----
                                            label22.setText("123x");
                                            label22.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label22.setHorizontalAlignment(SwingConstants.CENTER);
                                            label22.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label22, CC.xy(4, 5));

                                            //---- label29 ----
                                            label29.setText("7.00\u20ac");
                                            label29.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label29.setHorizontalAlignment(SwingConstants.CENTER);
                                            label29.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label29, CC.xy(5, 5));

                                            //---- kButton6 ----
                                            kButton6.setText("Objedna\u0165");
                                            kButton6.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            kButton6.setBorder(null);
                                            kButton6.setkStartColor(new Color(73, 196, 174));
                                            kButton6.setkEndColor(new Color(140, 219, 145));
                                            kButton6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            kButton6.setkHoverEndColor(new Color(73, 196, 174));
                                            kButton6.setkHoverStartColor(new Color(52, 188, 183));
                                            kButton6.setkHoverForeGround(Color.white);
                                            kButton6.setBackground(Color.white);
                                            kButton6.setBorderPainted(false);
                                            panelTableRanajky.add(kButton6, new CellConstraints(6, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 0)));

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
                                            label20.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label20.setHorizontalAlignment(SwingConstants.CENTER);
                                            label20.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label20, CC.xy(3, 6));

                                            //---- label56 ----
                                            label56.setText("63x");
                                            label56.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label56.setHorizontalAlignment(SwingConstants.CENTER);
                                            label56.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label56, CC.xy(4, 6));

                                            //---- label30 ----
                                            label30.setText("3.49\u20ac");
                                            label30.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label30.setHorizontalAlignment(SwingConstants.CENTER);
                                            label30.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label30, CC.xy(5, 6));

                                            //---- kButton7 ----
                                            kButton7.setText("Objedna\u0165");
                                            kButton7.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            kButton7.setBorder(null);
                                            kButton7.setkStartColor(new Color(73, 196, 174));
                                            kButton7.setkEndColor(new Color(140, 219, 145));
                                            kButton7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            kButton7.setkHoverEndColor(new Color(73, 196, 174));
                                            kButton7.setkHoverStartColor(new Color(52, 188, 183));
                                            kButton7.setkHoverForeGround(Color.white);
                                            kButton7.setBackground(Color.white);
                                            kButton7.setBorderPainted(false);
                                            panelTableRanajky.add(kButton7, new CellConstraints(6, 6, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 0)));
                                            panelTableRanajky.add(label16, CC.xy(1, 8));
                                        }
                                        panelRanajky.add(panelTableRanajky, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelContentObjednat.add(panelRanajky, "ranajky");

                                    //======== panelObed ========
                                    {
                                        panelObed.setkBorderRadius(0);
                                        panelObed.setkEndColor(Color.white);
                                        panelObed.setkStartColor(Color.white);
                                        panelObed.setLayout(new GridBagLayout());

                                        //======== panelTableObed ========
                                        {
                                            panelTableObed.setkEndColor(Color.white);
                                            panelTableObed.setkStartColor(Color.white);
                                            panelTableObed.setBorder(null);
                                            panelTableObed.setkBorderRadius(0);
                                            panelTableObed.setBackground(new Color(255, 255, 255, 145));
                                            panelTableObed.setLayout(new FormLayout(
                                                "27px, 280px, 126px, 92px, 72px, 107px",
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
                                            label39.setText("Vo\u013en\u00e9");
                                            label39.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label39.setHorizontalAlignment(SwingConstants.CENTER);
                                            label39.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            label39.setBackground(Color.white);
                                            panelTableObed.add(label39, CC.xy(4, 1));

                                            //---- label40 ----
                                            label40.setText("Cena");
                                            label40.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label40.setHorizontalAlignment(SwingConstants.CENTER);
                                            label40.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label40, CC.xy(5, 1));

                                            //---- label41 ----
                                            label41.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
                                            panelTableObed.add(label41, CC.xy(6, 1));

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
                                            label52.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label52.setHorizontalAlignment(SwingConstants.CENTER);
                                            label52.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label52, CC.xy(3, 2));

                                            //---- label43 ----
                                            label43.setText("78x");
                                            label43.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label43.setHorizontalAlignment(SwingConstants.CENTER);
                                            label43.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label43, CC.xy(4, 2));

                                            //---- label44 ----
                                            label44.setText("3.87\u20ac");
                                            label44.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label44.setHorizontalAlignment(SwingConstants.CENTER);
                                            label44.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label44, CC.xy(5, 2));

                                            //---- kButton8 ----
                                            kButton8.setText("Objedna\u0165");
                                            kButton8.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            kButton8.setBorder(null);
                                            kButton8.setkStartColor(new Color(73, 196, 174));
                                            kButton8.setkEndColor(new Color(140, 219, 145));
                                            kButton8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            kButton8.setkHoverEndColor(new Color(73, 196, 174));
                                            kButton8.setkHoverStartColor(new Color(52, 188, 183));
                                            kButton8.setkHoverForeGround(Color.white);
                                            kButton8.setBackground(Color.white);
                                            kButton8.setBorderPainted(false);
                                            panelTableObed.add(kButton8, new CellConstraints(6, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 0)));

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
                                            label49.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label49.setHorizontalAlignment(SwingConstants.CENTER);
                                            label49.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label49, CC.xy(3, 3));

                                            //---- label50 ----
                                            label50.setText("417x");
                                            label50.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label50.setHorizontalAlignment(SwingConstants.CENTER);
                                            label50.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label50, CC.xy(4, 3));

                                            //---- label53 ----
                                            label53.setText("7.45\u20ac");
                                            label53.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label53.setHorizontalAlignment(SwingConstants.CENTER);
                                            label53.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label53, CC.xy(5, 3));

                                            //---- kButton9 ----
                                            kButton9.setText("Objedna\u0165");
                                            kButton9.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            kButton9.setBorder(null);
                                            kButton9.setkStartColor(new Color(73, 196, 174));
                                            kButton9.setkEndColor(new Color(140, 219, 145));
                                            kButton9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            kButton9.setkHoverEndColor(new Color(73, 196, 174));
                                            kButton9.setkHoverStartColor(new Color(52, 188, 183));
                                            kButton9.setkHoverForeGround(Color.white);
                                            kButton9.setBackground(Color.white);
                                            kButton9.setBorderPainted(false);
                                            panelTableObed.add(kButton9, new CellConstraints(6, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 0)));

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
                                            label57.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label57.setHorizontalAlignment(SwingConstants.CENTER);
                                            label57.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label57, CC.xy(3, 4));

                                            //---- label58 ----
                                            label58.setText("29x");
                                            label58.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label58.setHorizontalAlignment(SwingConstants.CENTER);
                                            label58.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label58, CC.xy(4, 4));

                                            //---- label59 ----
                                            label59.setText("2.21\u20ac");
                                            label59.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label59.setHorizontalAlignment(SwingConstants.CENTER);
                                            label59.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label59, CC.xy(5, 4));

                                            //---- kButton10 ----
                                            kButton10.setText("Objedna\u0165");
                                            kButton10.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            kButton10.setBorder(null);
                                            kButton10.setkStartColor(new Color(73, 196, 174));
                                            kButton10.setkEndColor(new Color(140, 219, 145));
                                            kButton10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            kButton10.setkHoverEndColor(new Color(73, 196, 174));
                                            kButton10.setkHoverStartColor(new Color(52, 188, 183));
                                            kButton10.setkHoverForeGround(Color.white);
                                            kButton10.setBackground(Color.white);
                                            kButton10.setBorderPainted(false);
                                            panelTableObed.add(kButton10, new CellConstraints(6, 4, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 0)));

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
                                            label62.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label62.setHorizontalAlignment(SwingConstants.CENTER);
                                            label62.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label62, CC.xy(3, 5));

                                            //---- label63 ----
                                            label63.setText("75x");
                                            label63.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label63.setHorizontalAlignment(SwingConstants.CENTER);
                                            label63.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label63, CC.xy(4, 5));

                                            //---- label64 ----
                                            label64.setText("4.25\u20ac");
                                            label64.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label64.setHorizontalAlignment(SwingConstants.CENTER);
                                            label64.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label64, CC.xy(5, 5));

                                            //---- kButton11 ----
                                            kButton11.setText("Objedna\u0165");
                                            kButton11.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            kButton11.setBorder(null);
                                            kButton11.setkStartColor(new Color(73, 196, 174));
                                            kButton11.setkEndColor(new Color(140, 219, 145));
                                            kButton11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            kButton11.setkHoverEndColor(new Color(73, 196, 174));
                                            kButton11.setkHoverStartColor(new Color(52, 188, 183));
                                            kButton11.setkHoverForeGround(Color.white);
                                            kButton11.setBackground(Color.white);
                                            kButton11.setBorderPainted(false);
                                            panelTableObed.add(kButton11, new CellConstraints(6, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 0)));

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
                                            label67.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label67.setHorizontalAlignment(SwingConstants.CENTER);
                                            label67.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label67, CC.xy(3, 6));

                                            //---- label68 ----
                                            label68.setText("0x");
                                            label68.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label68.setHorizontalAlignment(SwingConstants.CENTER);
                                            label68.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label68, CC.xy(4, 6));

                                            //---- label69 ----
                                            label69.setText("1.50\u20ac");
                                            label69.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label69.setHorizontalAlignment(SwingConstants.CENTER);
                                            label69.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label69, CC.xy(5, 6));

                                            //---- kButton12 ----
                                            kButton12.setText("Objedna\u0165");
                                            kButton12.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            kButton12.setBorder(null);
                                            kButton12.setkStartColor(new Color(73, 196, 174));
                                            kButton12.setkEndColor(new Color(140, 219, 145));
                                            kButton12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            kButton12.setkHoverEndColor(new Color(73, 196, 174));
                                            kButton12.setkHoverStartColor(new Color(52, 188, 183));
                                            kButton12.setkHoverForeGround(Color.white);
                                            kButton12.setBackground(Color.white);
                                            kButton12.setBorderPainted(false);
                                            panelTableObed.add(kButton12, new CellConstraints(6, 6, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 0)));
                                            panelTableObed.add(label70, CC.xy(1, 8));
                                        }
                                        panelObed.add(panelTableObed, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelContentObjednat.add(panelObed, "obed");
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
                                    .addComponent(splitPane3, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                            );
                        }
                        panelContent.add(panelObjednat, "objednat");

                        //======== panelMojeObjednavky ========
                        {
                            panelMojeObjednavky.setkEndColor(Color.white);
                            panelMojeObjednavky.setkStartColor(Color.white);
                            panelMojeObjednavky.setBorder(null);
                            panelMojeObjednavky.setkBorderRadius(0);
                            panelMojeObjednavky.setLayout(new GridBagLayout());

                            //======== panelTableRanajky2 ========
                            {
                                panelTableRanajky2.setkEndColor(Color.white);
                                panelTableRanajky2.setkStartColor(Color.white);
                                panelTableRanajky2.setBorder(null);
                                panelTableRanajky2.setkBorderRadius(0);
                                panelTableRanajky2.setBackground(new Color(255, 255, 255, 145));
                                panelTableRanajky2.setLayout(new FormLayout(
                                    "46dlu, 36dlu, 348px, 75px, 101px",
                                    "fill:49px, fill:52px"));

                                //---- label71 ----
                                label71.setText("D\u00e1tum");
                                label71.setHorizontalAlignment(SwingConstants.CENTER);
                                label71.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                label71.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                panelTableRanajky2.add(label71, CC.xy(1, 1));

                                //---- label73 ----
                                label73.setText("\u010cas");
                                label73.setHorizontalAlignment(SwingConstants.CENTER);
                                label73.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                label73.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                panelTableRanajky2.add(label73, CC.xy(2, 1));

                                //---- label2 ----
                                label2.setText("Obed");
                                label2.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                label2.setHorizontalAlignment(SwingConstants.CENTER);
                                label2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableRanajky2.add(label2, CC.xy(3, 1));

                                //---- label74 ----
                                label74.setText("Cena");
                                label74.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                label74.setHorizontalAlignment(SwingConstants.CENTER);
                                label74.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableRanajky2.add(label74, CC.xy(4, 1));

                                //---- label75 ----
                                label75.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                                panelTableRanajky2.add(label75, CC.xy(5, 1));

                                //---- label76 ----
                                label76.setText("14.12.2021");
                                label76.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                label76.setHorizontalAlignment(SwingConstants.CENTER);
                                panelTableRanajky2.add(label76, CC.xy(1, 2));

                                //---- label79 ----
                                label79.setText("14:59");
                                label79.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                label79.setHorizontalAlignment(SwingConstants.CENTER);
                                panelTableRanajky2.add(label79, CC.xy(2, 2));

                                //---- label77 ----
                                label77.setText("Parky s hor\u010dicou a chlebom (Takeaway)");
                                label77.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                label77.setHorizontalAlignment(SwingConstants.CENTER);
                                label77.setBorder(null);
                                panelTableRanajky2.add(label77, CC.xy(3, 2));

                                //---- label80 ----
                                label80.setText("4.87\u20ac");
                                label80.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                label80.setHorizontalAlignment(SwingConstants.CENTER);
                                label80.setBorder(null);
                                panelTableRanajky2.add(label80, CC.xy(4, 2));

                                //---- kButton13 ----
                                kButton13.setText("Do burzy");
                                kButton13.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                kButton13.setBorder(null);
                                kButton13.setkStartColor(new Color(73, 196, 174));
                                kButton13.setkEndColor(new Color(140, 219, 145));
                                kButton13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                kButton13.setkHoverEndColor(new Color(73, 196, 174));
                                kButton13.setkHoverStartColor(new Color(52, 188, 183));
                                kButton13.setkHoverForeGround(Color.white);
                                kButton13.setBackground(Color.white);
                                kButton13.setBorderPainted(false);
                                panelTableRanajky2.add(kButton13, new CellConstraints(5, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));
                            }
                            panelMojeObjednavky.add(panelTableRanajky2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
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
                                        .addContainerGap(324, Short.MAX_VALUE))
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
                                        .addContainerGap(219, Short.MAX_VALUE)
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
                                        .addContainerGap(267, Short.MAX_VALUE))
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
                                        .addContainerGap(254, Short.MAX_VALUE))
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
                                        .addContainerGap(265, Short.MAX_VALUE))
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
    private KButton btnRanajky;
    private KButton btnObed;
    private KGradientPanel panelContentObjednat;
    private KGradientPanel panelRanajky;
    private KGradientPanel panelTableRanajky;
    private JLabel label36;
    private JLabel label1;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label37;
    private JLabel label46;
    private JLabel label11;
    private JLabel label51;
    private JLabel label25;
    private JLabel label26;
    private KButton kButton3;
    private JLabel label32;
    private JLabel label12;
    private JLabel label17;
    private JLabel label31;
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
    private JLabel label56;
    private JLabel label30;
    private KButton kButton7;
    private JLabel label16;
    private KGradientPanel panelObed;
    private KGradientPanel panelTableObed;
    private JLabel label38;
    private JLabel label21;
    private JLabel label24;
    private JLabel label39;
    private JLabel label40;
    private JLabel label41;
    private JLabel label47;
    private JLabel label42;
    private JLabel label52;
    private JLabel label43;
    private JLabel label44;
    private KButton kButton8;
    private JLabel label45;
    private JLabel label48;
    private JLabel label49;
    private JLabel label50;
    private JLabel label53;
    private KButton kButton9;
    private JLabel label54;
    private JLabel label55;
    private JLabel label57;
    private JLabel label58;
    private JLabel label59;
    private KButton kButton10;
    private JLabel label60;
    private JLabel label61;
    private JLabel label62;
    private JLabel label63;
    private JLabel label64;
    private KButton kButton11;
    private JLabel label65;
    private JLabel label66;
    private JLabel label67;
    private JLabel label68;
    private JLabel label69;
    private KButton kButton12;
    private JLabel label70;
    private KGradientPanel panelMojeObjednavky;
    private KGradientPanel panelTableRanajky2;
    private JLabel label71;
    private JLabel label73;
    private JLabel label2;
    private JLabel label74;
    private JLabel label75;
    private JLabel label76;
    private JLabel label79;
    private JLabel label77;
    private JLabel label80;
    private KButton kButton13;
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
