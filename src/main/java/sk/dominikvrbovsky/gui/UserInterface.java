/*
 * Created by JFormDesigner on Mon Apr 19 20:48:55 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import keeptoo.*;
import sk.dominikvrbovsky.User;

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
    
    

//    private void btnObedActionPerformed() {
//        cardLayoutObjednat.show(panelObjedContent, "panelObed");
//    }

//    private void btnRanajkyActionPerformed() {
//        cardLayoutObjednat.show(panelObjedContent, "panelRanajky");
//    } 

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
        panelContent = new KGradientPanel();
        panelObjednat = new KGradientPanel();
        label8 = new JLabel();
        panelMojeObejdnavky = new KGradientPanel();
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
                panelMenu.setkStartColor(new Color(37, 43, 43));
                panelMenu.setkEndColor(new Color(37, 43, 43));
                panelMenu.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
                EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing
                .border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),
                java.awt.Color.red),panelMenu. getBorder()));panelMenu. addPropertyChangeListener(new java.beans.PropertyChangeListener()
                {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))
                throw new RuntimeException();}});

                //---- labelIcon ----
                labelIcon.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_checked_user_male_70px.png"));
                labelIcon.setHorizontalAlignment(SwingConstants.CENTER);

                //---- labelUsername ----
                labelUsername.setText("Dominik Vrbovsk\u00fd");
                labelUsername.setHorizontalAlignment(SwingConstants.CENTER);
                labelUsername.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                labelUsername.setForeground(Color.white);

                //---- btnObjednat ----
                btnObjednat.setText("Objedna\u0165");
                btnObjednat.setkBorderRadius(0);
                btnObjednat.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                btnObjednat.setkEndColor(new Color(37, 43, 43));
                btnObjednat.setkStartColor(new Color(37, 43, 43));
                btnObjednat.setBorder(null);
                btnObjednat.setkHoverEndColor(Color.gray);
                btnObjednat.setkHoverStartColor(new Color(37, 43, 43));
                btnObjednat.addActionListener(e -> btnObjednatActionPerformed());

                //---- btnMojeObjed ----
                btnMojeObjed.setText("Moje objedn\u00e1vky");
                btnMojeObjed.setkBorderRadius(0);
                btnMojeObjed.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                btnMojeObjed.setkEndColor(new Color(37, 43, 43));
                btnMojeObjed.setkStartColor(new Color(37, 43, 43));
                btnMojeObjed.setBorder(null);
                btnMojeObjed.setkHoverEndColor(Color.gray);
                btnMojeObjed.setkHoverStartColor(new Color(37, 43, 43));
                btnMojeObjed.addActionListener(e -> btnMojeObjedActionPerformed());

                //---- btnBurza ----
                btnBurza.setText("Burza");
                btnBurza.setkBorderRadius(0);
                btnBurza.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                btnBurza.setkEndColor(new Color(37, 43, 43));
                btnBurza.setkStartColor(new Color(37, 43, 43));
                btnBurza.setBorder(null);
                btnBurza.setkHoverEndColor(Color.gray);
                btnBurza.setkHoverStartColor(new Color(37, 43, 43));
                btnBurza.addActionListener(e -> btnBurzaActionPerformed());

                //---- btnUcet ----
                btnUcet.setText("\u00da\u010det");
                btnUcet.setkBorderRadius(0);
                btnUcet.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                btnUcet.setkEndColor(new Color(37, 43, 43));
                btnUcet.setkStartColor(new Color(37, 43, 43));
                btnUcet.setBorder(null);
                btnUcet.setkHoverEndColor(Color.gray);
                btnUcet.setkHoverStartColor(new Color(37, 43, 43));
                btnUcet.addActionListener(e -> btnUcetActionPerformed());

                //---- btnZmenitHeslo ----
                btnZmenitHeslo.setText("Zmeni\u0165 heslo");
                btnZmenitHeslo.setkBorderRadius(0);
                btnZmenitHeslo.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                btnZmenitHeslo.setkEndColor(new Color(37, 43, 43));
                btnZmenitHeslo.setkStartColor(new Color(37, 43, 43));
                btnZmenitHeslo.setBorder(null);
                btnZmenitHeslo.setkHoverEndColor(Color.gray);
                btnZmenitHeslo.setkHoverStartColor(new Color(37, 43, 43));
                btnZmenitHeslo.addActionListener(e -> btnZmenitCisloActionPerformed());

                //---- btnOdhlasitSa ----
                btnOdhlasitSa.setText("Odhl\u00e1si\u0165 sa");
                btnOdhlasitSa.setkBorderRadius(0);
                btnOdhlasitSa.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                btnOdhlasitSa.setkEndColor(new Color(37, 43, 43));
                btnOdhlasitSa.setkStartColor(new Color(37, 43, 43));
                btnOdhlasitSa.setBorder(null);
                btnOdhlasitSa.setkHoverEndColor(Color.gray);
                btnOdhlasitSa.setkHoverStartColor(new Color(37, 43, 43));
                btnOdhlasitSa.addActionListener(e -> btnOdhlasitSaActionPerformed());

                //---- labelAccount ----
                labelAccount.setText("Stav \u00fa\u010dtu: 5.45\u20ac");
                labelAccount.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                labelAccount.setHorizontalAlignment(SwingConstants.CENTER);
                labelAccount.setForeground(Color.white);
                labelAccount.setVerticalAlignment(SwingConstants.TOP);

                //---- btnAdmin ----
                btnAdmin.setText("Administr\u00e1tor");
                btnAdmin.setkBorderRadius(0);
                btnAdmin.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                btnAdmin.setkEndColor(new Color(37, 43, 43));
                btnAdmin.setkStartColor(new Color(37, 43, 43));
                btnAdmin.setBorder(null);
                btnAdmin.setkHoverEndColor(Color.gray);
                btnAdmin.setkHoverStartColor(new Color(37, 43, 43));
                btnAdmin.setkForeGround(new Color(137, 238, 202));
                btnAdmin.addActionListener(e -> btnAdminActionPerformed());

                GroupLayout panelMenuLayout = new GroupLayout(panelMenu);
                panelMenu.setLayout(panelMenuLayout);
                panelMenuLayout.setHorizontalGroup(
                    panelMenuLayout.createParallelGroup()
                        .addGroup(panelMenuLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelMenuLayout.createParallelGroup()
                                .addComponent(labelIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelAccount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                        .addComponent(btnObjednat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMojeObjed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBurza, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUcet, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnZmenitHeslo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOdhlasitSa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btnAdmin, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
                );
                panelMenuLayout.setVerticalGroup(
                    panelMenuLayout.createParallelGroup()
                        .addGroup(panelMenuLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(labelIcon)
                            .addGap(0, 0, 0)
                            .addComponent(labelUsername)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelAccount)
                            .addGap(41, 41, 41)
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
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                            .addComponent(btnAdmin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            splitPane1.setLeftComponent(panelMenu);

            //======== panelContent ========
            {
                panelContent.setkEndColor(new Color(192, 248, 213));
                panelContent.setkStartColor(new Color(115, 224, 255));
                panelContent.setkBorderRadius(0);
                panelContent.setLayout(new CardLayout());

                //======== panelObjednat ========
                {

                    //---- label8 ----
                    label8.setText("Objednat");

                    GroupLayout panelObjednatLayout = new GroupLayout(panelObjednat);
                    panelObjednat.setLayout(panelObjednatLayout);
                    panelObjednatLayout.setHorizontalGroup(
                        panelObjednatLayout.createParallelGroup()
                            .addGroup(panelObjednatLayout.createSequentialGroup()
                                .addGap(234, 234, 234)
                                .addComponent(label8)
                                .addContainerGap(244, Short.MAX_VALUE))
                    );
                    panelObjednatLayout.setVerticalGroup(
                        panelObjednatLayout.createParallelGroup()
                            .addGroup(panelObjednatLayout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(label8)
                                .addContainerGap(312, Short.MAX_VALUE))
                    );
                }
                panelContent.add(panelObjednat, "objednat");

                //======== panelMojeObejdnavky ========
                {

                    //---- label2 ----
                    label2.setText("Moje objednavky");

                    GroupLayout panelMojeObejdnavkyLayout = new GroupLayout(panelMojeObejdnavky);
                    panelMojeObejdnavky.setLayout(panelMojeObejdnavkyLayout);
                    panelMojeObejdnavkyLayout.setHorizontalGroup(
                        panelMojeObejdnavkyLayout.createParallelGroup()
                            .addGroup(panelMojeObejdnavkyLayout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(label2)
                                .addContainerGap(212, Short.MAX_VALUE))
                    );
                    panelMojeObejdnavkyLayout.setVerticalGroup(
                        panelMojeObejdnavkyLayout.createParallelGroup()
                            .addGroup(panelMojeObejdnavkyLayout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addComponent(label2)
                                .addContainerGap(302, Short.MAX_VALUE))
                    );
                }
                panelContent.add(panelMojeObejdnavky, "mojeObjednavky");

                //======== panelBurza ========
                {

                    //---- label3 ----
                    label3.setText("Burza");

                    GroupLayout panelBurzaLayout = new GroupLayout(panelBurza);
                    panelBurza.setLayout(panelBurzaLayout);
                    panelBurzaLayout.setHorizontalGroup(
                        panelBurzaLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panelBurzaLayout.createSequentialGroup()
                                .addContainerGap(216, Short.MAX_VALUE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                .addGap(198, 198, 198))
                    );
                    panelBurzaLayout.setVerticalGroup(
                        panelBurzaLayout.createParallelGroup()
                            .addGroup(panelBurzaLayout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(253, Short.MAX_VALUE))
                    );
                }
                panelContent.add(panelBurza, "burza");

                //======== panelUcet ========
                {

                    //---- label4 ----
                    label4.setText("Ucet");

                    GroupLayout panelUcetLayout = new GroupLayout(panelUcet);
                    panelUcet.setLayout(panelUcetLayout);
                    panelUcetLayout.setHorizontalGroup(
                        panelUcetLayout.createParallelGroup()
                            .addGroup(panelUcetLayout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(label4)
                                .addContainerGap(269, Short.MAX_VALUE))
                    );
                    panelUcetLayout.setVerticalGroup(
                        panelUcetLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panelUcetLayout.createSequentialGroup()
                                .addContainerGap(263, Short.MAX_VALUE)
                                .addComponent(label4)
                                .addGap(259, 259, 259))
                    );
                }
                panelContent.add(panelUcet, "ucet");

                //======== panelZmenitHeslo ========
                {

                    //---- label5 ----
                    label5.setText("Zmenit heslo");

                    GroupLayout panelZmenitHesloLayout = new GroupLayout(panelZmenitHeslo);
                    panelZmenitHeslo.setLayout(panelZmenitHesloLayout);
                    panelZmenitHesloLayout.setHorizontalGroup(
                        panelZmenitHesloLayout.createParallelGroup()
                            .addGroup(panelZmenitHesloLayout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(label5)
                                .addContainerGap(243, Short.MAX_VALUE))
                    );
                    panelZmenitHesloLayout.setVerticalGroup(
                        panelZmenitHesloLayout.createParallelGroup()
                            .addGroup(panelZmenitHesloLayout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addComponent(label5)
                                .addContainerGap(261, Short.MAX_VALUE))
                    );
                }
                panelContent.add(panelZmenitHeslo, "zmenitHeslo");

                //======== panelOdhlasitSa ========
                {

                    //---- label6 ----
                    label6.setText("Odhl\u00e1si\u0165 sa");

                    GroupLayout panelOdhlasitSaLayout = new GroupLayout(panelOdhlasitSa);
                    panelOdhlasitSa.setLayout(panelOdhlasitSaLayout);
                    panelOdhlasitSaLayout.setHorizontalGroup(
                        panelOdhlasitSaLayout.createParallelGroup()
                            .addGroup(panelOdhlasitSaLayout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(label6)
                                .addContainerGap(237, Short.MAX_VALUE))
                    );
                    panelOdhlasitSaLayout.setVerticalGroup(
                        panelOdhlasitSaLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panelOdhlasitSaLayout.createSequentialGroup()
                                .addContainerGap(270, Short.MAX_VALUE)
                                .addComponent(label6)
                                .addGap(252, 252, 252))
                    );
                }
                panelContent.add(panelOdhlasitSa, "odhlasitSa");

                //======== panelAdmin ========
                {

                    //---- label7 ----
                    label7.setText("Administrator");

                    GroupLayout panelAdminLayout = new GroupLayout(panelAdmin);
                    panelAdmin.setLayout(panelAdminLayout);
                    panelAdminLayout.setHorizontalGroup(
                        panelAdminLayout.createParallelGroup()
                            .addGroup(panelAdminLayout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(label7)
                                .addContainerGap(251, Short.MAX_VALUE))
                    );
                    panelAdminLayout.setVerticalGroup(
                        panelAdminLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                                .addContainerGap(270, Short.MAX_VALUE)
                                .addComponent(label7)
                                .addGap(252, 252, 252))
                    );
                }
                panelContent.add(panelAdmin, "admin");
            }
            splitPane1.setRightComponent(panelContent);
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
    private KGradientPanel panelContent;
    private KGradientPanel panelObjednat;
    private JLabel label8;
    private KGradientPanel panelMojeObejdnavky;
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
