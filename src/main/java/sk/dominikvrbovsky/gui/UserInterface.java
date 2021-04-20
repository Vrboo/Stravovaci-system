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
    private final CardLayout cardLayoutObjednat;

    public UserInterface(EntityManager entityManager, User user) {
        this.entityManager = entityManager;
        this.user = user;
        String userAccount = String.format("%.2f", user.getAccount());

        this.setPreferredSize(new Dimension(1000, 600));
        
        initComponents();
        
        this.cardLayout = (CardLayout)(panelContent.getLayout());
        this.cardLayoutObjednat = (CardLayout)(panelObjednatContent.getLayout()); 
        
        //labelUsername.setText(user.getFullName());
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

    private void btnObedActionPerformed() {
        cardLayoutObjednat.show(panelObjednatContent, "obed");
    }

    private void btnRanajkyActionPerformed() {
        cardLayoutObjednat.show(panelObjednatContent, "ranajky");
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
        splitPane2 = new JSplitPane();
        panelObjednatMenu = new KGradientPanel();
        label1 = new JLabel();
        label8 = new JLabel();
        panelObjednatContent = new KGradientPanel();
        panelObjednatObed = new KGradientPanel();
        panelObjednatRanajky = new KGradientPanel();
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
                panelMenu.setkStartColor(new Color(55, 55, 55));
                panelMenu.setkEndColor(new Color(55, 55, 55));
                panelMenu.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border
                .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e" , javax. swing .border . TitledBorder. CENTER ,javax
                . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dialo\u0067", java .awt . Font. BOLD ,
                12 ) ,java . awt. Color .red ) ,panelMenu. getBorder () ) ); panelMenu. addPropertyChangeListener( new java. beans
                .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "borde\u0072" .equals ( e.
                getPropertyName () ) )throw new RuntimeException( ) ;} } );

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
                btnObjednat.setkHoverEndColor(new Color(50, 187, 186));
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
                btnMojeObjed.setkHoverEndColor(new Color(50, 187, 186));
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
                btnBurza.setkHoverEndColor(new Color(50, 187, 186));
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
                btnUcet.setkHoverEndColor(new Color(50, 187, 186));
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
                btnZmenitHeslo.setkHoverEndColor(new Color(50, 187, 186));
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
                btnOdhlasitSa.setkHoverEndColor(new Color(50, 187, 186));
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
                btnAdmin.setkHoverStartColor(new Color(37, 43, 43));
                btnAdmin.setkForeGround(new Color(137, 238, 202));
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
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addComponent(btnAdmin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(17, 17, 17))
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

                    //======== splitPane2 ========
                    {
                        splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
                        splitPane2.setDividerSize(0);
                        splitPane2.setDividerLocation(175);
                        splitPane2.setBorder(null);

                        //======== panelObjednatMenu ========
                        {
                            panelObjednatMenu.setBorder(null);
                            panelObjednatMenu.setkBorderRadius(0);
                            panelObjednatMenu.setkStartColor(new Color(38, 184, 190));
                            panelObjednatMenu.setkEndColor(new Color(150, 223, 141));
                            panelObjednatMenu.setkGradientFocus(600);

                            //---- label1 ----
                            label1.setText("Stravovac\u00ed syst\u00e9m");
                            label1.setFont(new Font("Yu Gothic UI", Font.BOLD, 45));
                            label1.setHorizontalAlignment(SwingConstants.LEFT);
                            label1.setForeground(new Color(70, 70, 70));

                            //---- label8 ----
                            label8.setText("20. janu\u00e1r 2021, utorok");
                            label8.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                            label8.setForeground(new Color(70, 70, 70));
                            label8.setHorizontalAlignment(SwingConstants.LEFT);

                            GroupLayout panelObjednatMenuLayout = new GroupLayout(panelObjednatMenu);
                            panelObjednatMenu.setLayout(panelObjednatMenuLayout);
                            panelObjednatMenuLayout.setHorizontalGroup(
                                panelObjednatMenuLayout.createParallelGroup()
                                    .addGroup(panelObjednatMenuLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(panelObjednatMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(194, Short.MAX_VALUE))
                            );
                            panelObjednatMenuLayout.setVerticalGroup(
                                panelObjednatMenuLayout.createParallelGroup()
                                    .addGroup(panelObjednatMenuLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(53, Short.MAX_VALUE))
                            );
                        }
                        splitPane2.setTopComponent(panelObjednatMenu);

                        //======== panelObjednatContent ========
                        {
                            panelObjednatContent.setLayout(new CardLayout());

                            //======== panelObjednatObed ========
                            {
                                panelObjednatObed.setkEndColor(Color.white);
                                panelObjednatObed.setkStartColor(Color.white);

                                GroupLayout panelObjednatObedLayout = new GroupLayout(panelObjednatObed);
                                panelObjednatObed.setLayout(panelObjednatObedLayout);
                                panelObjednatObedLayout.setHorizontalGroup(
                                    panelObjednatObedLayout.createParallelGroup()
                                        .addGap(0, 608, Short.MAX_VALUE)
                                );
                                panelObjednatObedLayout.setVerticalGroup(
                                    panelObjednatObedLayout.createParallelGroup()
                                        .addGap(0, 368, Short.MAX_VALUE)
                                );
                            }
                            panelObjednatContent.add(panelObjednatObed, "obed");

                            //======== panelObjednatRanajky ========
                            {
                                panelObjednatRanajky.setBorder(null);
                                panelObjednatRanajky.setkBorderRadius(0);
                                panelObjednatRanajky.setkEndColor(Color.white);
                                panelObjednatRanajky.setkStartColor(Color.white);

                                GroupLayout panelObjednatRanajkyLayout = new GroupLayout(panelObjednatRanajky);
                                panelObjednatRanajky.setLayout(panelObjednatRanajkyLayout);
                                panelObjednatRanajkyLayout.setHorizontalGroup(
                                    panelObjednatRanajkyLayout.createParallelGroup()
                                        .addGap(0, 608, Short.MAX_VALUE)
                                );
                                panelObjednatRanajkyLayout.setVerticalGroup(
                                    panelObjednatRanajkyLayout.createParallelGroup()
                                        .addGap(0, 368, Short.MAX_VALUE)
                                );
                            }
                            panelObjednatContent.add(panelObjednatRanajky, "ranajky");
                        }
                        splitPane2.setBottomComponent(panelObjednatContent);
                    }

                    GroupLayout panelObjednatLayout = new GroupLayout(panelObjednat);
                    panelObjednat.setLayout(panelObjednatLayout);
                    panelObjednatLayout.setHorizontalGroup(
                        panelObjednatLayout.createParallelGroup()
                            .addComponent(splitPane2)
                    );
                    panelObjednatLayout.setVerticalGroup(
                        panelObjednatLayout.createParallelGroup()
                            .addComponent(splitPane2, GroupLayout.Alignment.TRAILING)
                    );
                }
                panelContent.add(panelObjednat, "objednat");

                //======== panelMojeObejdnavky ========
                {
                    panelMojeObejdnavky.setkEndColor(Color.white);
                    panelMojeObejdnavky.setkStartColor(Color.white);

                    //---- label2 ----
                    label2.setText("Moje objednavky");

                    GroupLayout panelMojeObejdnavkyLayout = new GroupLayout(panelMojeObejdnavky);
                    panelMojeObejdnavky.setLayout(panelMojeObejdnavkyLayout);
                    panelMojeObejdnavkyLayout.setHorizontalGroup(
                        panelMojeObejdnavkyLayout.createParallelGroup()
                            .addGroup(panelMojeObejdnavkyLayout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(label2)
                                .addContainerGap(292, Short.MAX_VALUE))
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
                                .addContainerGap(296, Short.MAX_VALUE)
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
                                .addContainerGap(349, Short.MAX_VALUE))
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
                                .addContainerGap(323, Short.MAX_VALUE))
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
                                .addContainerGap(317, Short.MAX_VALUE))
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
                                .addContainerGap(331, Short.MAX_VALUE))
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
    private JSplitPane splitPane2;
    private KGradientPanel panelObjednatMenu;
    private JLabel label1;
    private JLabel label8;
    private KGradientPanel panelObjednatContent;
    private KGradientPanel panelObjednatObed;
    private KGradientPanel panelObjednatRanajky;
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
