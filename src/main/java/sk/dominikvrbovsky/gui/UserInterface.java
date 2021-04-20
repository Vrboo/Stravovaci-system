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

    public UserInterface(EntityManager entityManager, User user) {
        this.entityManager = entityManager;
        this.user = user;
        String userAccount = String.format("%.2f", user.getAccount());

        this.setPreferredSize(new Dimension(1000, 600));
        initComponents();
        
        labelUsername.setText(user.getFullName());
        labelAccount.setText("Stav účtu: " + userAccount + "€");

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
        btnZmenitCislo = new KButton();
        btnOdhlasitSa = new KButton();
        labelAccount = new JLabel();
        btnAdmin = new KButton();
        panelContent = new KGradientPanel();
        kGradientPanel1 = new KGradientPanel();

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
                panelMenu.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
                . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder
                . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .
                awt .Font .BOLD ,12 ), java. awt. Color. red) ,panelMenu. getBorder( )) )
                ; panelMenu. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
                ) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
                ;

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

                //---- btnMojeObjed ----
                btnMojeObjed.setText("Moje objedn\u00e1vky");
                btnMojeObjed.setkBorderRadius(0);
                btnMojeObjed.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                btnMojeObjed.setkEndColor(new Color(37, 43, 43));
                btnMojeObjed.setkStartColor(new Color(37, 43, 43));
                btnMojeObjed.setBorder(null);
                btnMojeObjed.setkHoverEndColor(Color.gray);
                btnMojeObjed.setkHoverStartColor(new Color(37, 43, 43));

                //---- btnBurza ----
                btnBurza.setText("Burza");
                btnBurza.setkBorderRadius(0);
                btnBurza.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                btnBurza.setkEndColor(new Color(37, 43, 43));
                btnBurza.setkStartColor(new Color(37, 43, 43));
                btnBurza.setBorder(null);
                btnBurza.setkHoverEndColor(Color.gray);
                btnBurza.setkHoverStartColor(new Color(37, 43, 43));

                //---- btnUcet ----
                btnUcet.setText("\u00da\u010det");
                btnUcet.setkBorderRadius(0);
                btnUcet.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                btnUcet.setkEndColor(new Color(37, 43, 43));
                btnUcet.setkStartColor(new Color(37, 43, 43));
                btnUcet.setBorder(null);
                btnUcet.setkHoverEndColor(Color.gray);
                btnUcet.setkHoverStartColor(new Color(37, 43, 43));

                //---- btnZmenitCislo ----
                btnZmenitCislo.setText("Zmeni\u0165 heslo");
                btnZmenitCislo.setkBorderRadius(0);
                btnZmenitCislo.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                btnZmenitCislo.setkEndColor(new Color(37, 43, 43));
                btnZmenitCislo.setkStartColor(new Color(37, 43, 43));
                btnZmenitCislo.setBorder(null);
                btnZmenitCislo.setkHoverEndColor(Color.gray);
                btnZmenitCislo.setkHoverStartColor(new Color(37, 43, 43));

                //---- btnOdhlasitSa ----
                btnOdhlasitSa.setText("Odhl\u00e1si\u0165 sa");
                btnOdhlasitSa.setkBorderRadius(0);
                btnOdhlasitSa.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                btnOdhlasitSa.setkEndColor(new Color(37, 43, 43));
                btnOdhlasitSa.setkStartColor(new Color(37, 43, 43));
                btnOdhlasitSa.setBorder(null);
                btnOdhlasitSa.setkHoverEndColor(Color.gray);
                btnOdhlasitSa.setkHoverStartColor(new Color(37, 43, 43));

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
                        .addComponent(btnZmenitCislo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addComponent(btnZmenitCislo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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

                //======== kGradientPanel1 ========
                {
                    kGradientPanel1.setkEndColor(Color.white);
                    kGradientPanel1.setkStartColor(Color.white);

                    GroupLayout kGradientPanel1Layout = new GroupLayout(kGradientPanel1);
                    kGradientPanel1.setLayout(kGradientPanel1Layout);
                    kGradientPanel1Layout.setHorizontalGroup(
                        kGradientPanel1Layout.createParallelGroup()
                            .addGap(0, 528, Short.MAX_VALUE)
                    );
                    kGradientPanel1Layout.setVerticalGroup(
                        kGradientPanel1Layout.createParallelGroup()
                            .addGap(0, 538, Short.MAX_VALUE)
                    );
                }
                panelContent.add(kGradientPanel1, "card1");
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
    private KButton btnZmenitCislo;
    private KButton btnOdhlasitSa;
    private JLabel labelAccount;
    private KButton btnAdmin;
    private KGradientPanel panelContent;
    private KGradientPanel kGradientPanel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
