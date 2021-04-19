/*
 * Created by JFormDesigner on Fri Apr 16 13:00:38 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import java.awt.*;
import javax.swing.plaf.*;
import keeptoo.*;
import sk.dominikvrbovsky.User;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.GroupLayout;

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
        this.labelUserName.setText(user.getFullName());
        this.labelUserAccount.setText("Stav účtu: " + userAccount + " €");

    }

    private void kButton1ActionPerformed() {
        //
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
        splitPane1 = new JSplitPane();
        PanelMenu = new KGradientPanel();
        labelUserName = new JLabel();
        labelUserAccount = new JLabel();
        kButton7 = new KButton();
        kButton8 = new KButton();
        kButton9 = new KButton();
        kButton10 = new KButton();
        kButton11 = new KButton();
        kButton12 = new KButton();
        label3 = new JLabel();
        PanelContent = new KGradientPanel();
        kGradientPanel6 = new KGradientPanel();

        //======== this ========
        setUndecorated(true);
        setBackground(new Color(238, 238, 238));
        var contentPane = getContentPane();

        //======== splitPane1 ========
        {
            splitPane1.setBackground(Color.white);
            splitPane1.setBorder(null);
            splitPane1.setDividerSize(0);
            splitPane1.setDividerLocation(225);

            //======== PanelMenu ========
            {
                PanelMenu.setBorder(null);
                PanelMenu.setkBorderRadius(0);
                PanelMenu.setkStartColor(new Color(37, 43, 43));
                PanelMenu.setkEndColor(new Color(37, 43, 43));
                PanelMenu.setkGradientFocus(200);
                PanelMenu.setBackground(new Color(37, 43, 43));
                PanelMenu.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
                0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
                . BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
                red) ,PanelMenu. getBorder( )) ); PanelMenu. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
                beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

                //---- labelUserName ----
                labelUserName.setForeground(Color.white);
                labelUserName.setHorizontalAlignment(SwingConstants.CENTER);
                labelUserName.setText("Dominik Vrbovsk\u00fd");
                labelUserName.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));

                //---- labelUserAccount ----
                labelUserAccount.setText("5.26 \u20ac");
                labelUserAccount.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                labelUserAccount.setHorizontalAlignment(SwingConstants.CENTER);
                labelUserAccount.setForeground(Color.white);

                //---- kButton7 ----
                kButton7.setText("Objedna\u0165");
                kButton7.setkEndColor(new Color(37, 43, 43));
                kButton7.setkStartColor(new Color(37, 43, 43));
                kButton7.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                kButton7.setkIndicatorThickness(5);
                kButton7.setBorder(null);
                kButton7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                kButton7.setkSelectedColor(Color.darkGray);
                kButton7.setkHoverForeGround(Color.white);
                kButton7.setkHoverEndColor(Color.darkGray);
                kButton7.setkHoverStartColor(Color.darkGray);
                kButton7.setkBorderRadius(0);
                kButton7.setkIndicatorColor(Color.red);
                kButton7.addActionListener(e -> kButton1ActionPerformed());

                //---- kButton8 ----
                kButton8.setText("Moje objedn\u00e1vky");
                kButton8.setkEndColor(new Color(37, 43, 43));
                kButton8.setkStartColor(new Color(37, 43, 43));
                kButton8.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                kButton8.setkIndicatorThickness(0);
                kButton8.setBorder(null);
                kButton8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                kButton8.setkSelectedColor(Color.darkGray);
                kButton8.setkHoverForeGround(Color.white);
                kButton8.setkHoverEndColor(Color.darkGray);
                kButton8.setkHoverStartColor(Color.darkGray);
                kButton8.setkBorderRadius(0);

                //---- kButton9 ----
                kButton9.setText("Burza");
                kButton9.setkEndColor(new Color(37, 43, 43));
                kButton9.setkStartColor(new Color(37, 43, 43));
                kButton9.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                kButton9.setkIndicatorThickness(0);
                kButton9.setBorder(null);
                kButton9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                kButton9.setkSelectedColor(Color.darkGray);
                kButton9.setkHoverForeGround(Color.white);
                kButton9.setkHoverEndColor(Color.darkGray);
                kButton9.setkHoverStartColor(Color.darkGray);
                kButton9.setkBorderRadius(0);

                //---- kButton10 ----
                kButton10.setText("\u00da\u010det");
                kButton10.setkEndColor(new Color(37, 43, 43));
                kButton10.setkStartColor(new Color(37, 43, 43));
                kButton10.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                kButton10.setkIndicatorThickness(0);
                kButton10.setBorder(null);
                kButton10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                kButton10.setkSelectedColor(Color.darkGray);
                kButton10.setkHoverForeGround(Color.white);
                kButton10.setkHoverEndColor(Color.darkGray);
                kButton10.setkHoverStartColor(Color.darkGray);
                kButton10.setkBorderRadius(0);

                //---- kButton11 ----
                kButton11.setText("Zmeni\u0165 heslo");
                kButton11.setkEndColor(new Color(37, 43, 43));
                kButton11.setkStartColor(new Color(37, 43, 43));
                kButton11.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                kButton11.setkIndicatorThickness(0);
                kButton11.setBorder(null);
                kButton11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                kButton11.setkSelectedColor(Color.darkGray);
                kButton11.setkHoverForeGround(Color.white);
                kButton11.setkHoverEndColor(Color.darkGray);
                kButton11.setkHoverStartColor(Color.darkGray);
                kButton11.setkBorderRadius(0);

                //---- kButton12 ----
                kButton12.setText("Odhl\u00e1si\u0165 sa");
                kButton12.setkIndicatorThickness(0);
                kButton12.setkEndColor(new Color(37, 43, 43));
                kButton12.setkStartColor(new Color(37, 43, 43));
                kButton12.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                kButton12.setBorder(null);
                kButton12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                kButton12.setkSelectedColor(Color.darkGray);
                kButton12.setkHoverForeGround(Color.white);
                kButton12.setkHoverEndColor(Color.darkGray);
                kButton12.setkHoverStartColor(Color.darkGray);
                kButton12.setkBorderRadius(0);

                //---- label3 ----
                label3.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_checked_user_male_70px.png"));
                label3.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout PanelMenuLayout = new GroupLayout(PanelMenu);
                PanelMenu.setLayout(PanelMenuLayout);
                PanelMenuLayout.setHorizontalGroup(
                    PanelMenuLayout.createParallelGroup()
                        .addComponent(kButton8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kButton9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kButton10, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kButton11, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelMenuLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(PanelMenuLayout.createParallelGroup()
                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelMenuLayout.createSequentialGroup()
                                    .addGroup(PanelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelUserName, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                        .addComponent(labelUserAccount, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap())
                        .addGroup(PanelMenuLayout.createSequentialGroup()
                            .addGroup(PanelMenuLayout.createParallelGroup()
                                .addComponent(kButton7, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                                .addComponent(kButton12, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                );
                PanelMenuLayout.setVerticalGroup(
                    PanelMenuLayout.createParallelGroup()
                        .addGroup(PanelMenuLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelUserName)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelUserAccount, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(kButton7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(kButton8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(kButton9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(kButton10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(kButton11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(kButton12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(59, Short.MAX_VALUE))
                );
            }
            splitPane1.setLeftComponent(PanelMenu);

            //======== PanelContent ========
            {
                PanelContent.setBorder(null);
                PanelContent.setkBorderRadius(0);
                PanelContent.setkStartColor(Color.white);
                PanelContent.setkEndColor(Color.white);
                PanelContent.setkGradientFocus(780);
                PanelContent.setLayout(new CardLayout());

                //======== kGradientPanel6 ========
                {
                    kGradientPanel6.setFont(new Font("Segoe UI", Font.BOLD, 12));
                    kGradientPanel6.setkStartColor(new Color(115, 224, 255));
                    kGradientPanel6.setkEndColor(new Color(192, 248, 213));

                    GroupLayout kGradientPanel6Layout = new GroupLayout(kGradientPanel6);
                    kGradientPanel6.setLayout(kGradientPanel6Layout);
                    kGradientPanel6Layout.setHorizontalGroup(
                        kGradientPanel6Layout.createParallelGroup()
                            .addGap(0, 537, Short.MAX_VALUE)
                    );
                    kGradientPanel6Layout.setVerticalGroup(
                        kGradientPanel6Layout.createParallelGroup()
                            .addGap(0, 528, Short.MAX_VALUE)
                    );
                }
                PanelContent.add(kGradientPanel6, "card1");
            }
            splitPane1.setRightComponent(PanelContent);
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
    private KGradientPanel PanelMenu;
    private JLabel labelUserName;
    private JLabel labelUserAccount;
    private KButton kButton7;
    private KButton kButton8;
    private KButton kButton9;
    private KButton kButton10;
    private KButton kButton11;
    private KButton kButton12;
    private JLabel label3;
    private KGradientPanel PanelContent;
    private KGradientPanel kGradientPanel6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
