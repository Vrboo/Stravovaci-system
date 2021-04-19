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
        
//        this.labelUserName.setText(user.getFullName());
//        this.labelUserAccount.setText("Stav účtu: " + userAccount + " €");

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
        splitPane1 = new JSplitPane();
        kGradientPanel1 = new KGradientPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        kButton1 = new KButton();
        kButton2 = new KButton();
        kButton3 = new KButton();
        kButton4 = new KButton();
        kButton5 = new KButton();
        kButton6 = new KButton();
        label3 = new JLabel();
        kButton7 = new KButton();
        kGradientPanel2 = new KGradientPanel();

        //======== this ========
        setUndecorated(true);
        setResizable(false);
        var contentPane = getContentPane();

        //======== splitPane1 ========
        {
            splitPane1.setDividerSize(0);
            splitPane1.setBorder(null);
            splitPane1.setDividerLocation(225);

            //======== kGradientPanel1 ========
            {
                kGradientPanel1.setBorder(null);
                kGradientPanel1.setkBorderRadius(0);
                kGradientPanel1.setkStartColor(new Color(37, 43, 43));
                kGradientPanel1.setkEndColor(new Color(37, 43, 43));
                kGradientPanel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
                swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border
                .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog"
                ,java.awt.Font.BOLD,12),java.awt.Color.red),kGradientPanel1. getBorder
                ()));kGradientPanel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
                .beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException
                ();}});

                //---- label1 ----
                label1.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_checked_user_male_70px.png"));
                label1.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label2 ----
                label2.setText("Dominik Vrbovsk\u00fd");
                label2.setHorizontalAlignment(SwingConstants.CENTER);
                label2.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                label2.setForeground(Color.white);

                //---- kButton1 ----
                kButton1.setText("Objedna\u0165");
                kButton1.setkBorderRadius(0);
                kButton1.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                kButton1.setkEndColor(new Color(37, 43, 43));
                kButton1.setkStartColor(new Color(37, 43, 43));
                kButton1.setBorder(null);
                kButton1.setkHoverEndColor(Color.gray);
                kButton1.setkHoverStartColor(Color.darkGray);

                //---- kButton2 ----
                kButton2.setText("Moje objedn\u00e1vky");
                kButton2.setkBorderRadius(0);
                kButton2.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                kButton2.setkEndColor(new Color(37, 43, 43));
                kButton2.setkStartColor(new Color(37, 43, 43));
                kButton2.setBorder(null);
                kButton2.setkHoverEndColor(Color.gray);
                kButton2.setkHoverStartColor(Color.darkGray);

                //---- kButton3 ----
                kButton3.setText("Burza");
                kButton3.setkBorderRadius(0);
                kButton3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                kButton3.setkEndColor(new Color(37, 43, 43));
                kButton3.setkStartColor(new Color(37, 43, 43));
                kButton3.setBorder(null);
                kButton3.setkHoverEndColor(Color.gray);
                kButton3.setkHoverStartColor(Color.darkGray);

                //---- kButton4 ----
                kButton4.setText("\u00da\u010det");
                kButton4.setkBorderRadius(0);
                kButton4.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                kButton4.setkEndColor(new Color(37, 43, 43));
                kButton4.setkStartColor(new Color(37, 43, 43));
                kButton4.setBorder(null);
                kButton4.setkHoverEndColor(Color.gray);
                kButton4.setkHoverStartColor(Color.darkGray);

                //---- kButton5 ----
                kButton5.setText("Zmeni\u0165 heslo");
                kButton5.setkBorderRadius(0);
                kButton5.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                kButton5.setkEndColor(new Color(37, 43, 43));
                kButton5.setkStartColor(new Color(37, 43, 43));
                kButton5.setBorder(null);
                kButton5.setkHoverEndColor(Color.gray);
                kButton5.setkHoverStartColor(Color.darkGray);

                //---- kButton6 ----
                kButton6.setText("Odhl\u00e1si\u0165 sa");
                kButton6.setkBorderRadius(0);
                kButton6.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                kButton6.setkEndColor(new Color(37, 43, 43));
                kButton6.setkStartColor(new Color(37, 43, 43));
                kButton6.setBorder(null);
                kButton6.setkHoverEndColor(Color.gray);
                kButton6.setkHoverStartColor(Color.darkGray);

                //---- label3 ----
                label3.setText("Stav \u00fa\u010dtu: 5.45\u20ac");
                label3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                label3.setHorizontalAlignment(SwingConstants.CENTER);
                label3.setForeground(Color.white);
                label3.setVerticalAlignment(SwingConstants.TOP);

                //---- kButton7 ----
                kButton7.setText("Administr\u00e1tor");
                kButton7.setkBorderRadius(0);
                kButton7.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                kButton7.setkEndColor(new Color(37, 43, 43));
                kButton7.setkStartColor(new Color(37, 43, 43));
                kButton7.setBorder(null);
                kButton7.setkHoverEndColor(Color.gray);
                kButton7.setkHoverStartColor(Color.darkGray);
                kButton7.setkForeGround(new Color(137, 238, 202));

                GroupLayout kGradientPanel1Layout = new GroupLayout(kGradientPanel1);
                kGradientPanel1.setLayout(kGradientPanel1Layout);
                kGradientPanel1Layout.setHorizontalGroup(
                    kGradientPanel1Layout.createParallelGroup()
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(kGradientPanel1Layout.createParallelGroup()
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                        .addComponent(kButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kButton4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kButton5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kButton6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(kButton7, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
                );
                kGradientPanel1Layout.setVerticalGroup(
                    kGradientPanel1Layout.createParallelGroup()
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(label1)
                            .addGap(0, 0, 0)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label3)
                            .addGap(41, 41, 41)
                            .addComponent(kButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(kButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(kButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(kButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(kButton5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(kButton6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                            .addComponent(kButton7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            splitPane1.setLeftComponent(kGradientPanel1);

            //======== kGradientPanel2 ========
            {
                kGradientPanel2.setkEndColor(new Color(192, 248, 213));
                kGradientPanel2.setkStartColor(new Color(115, 224, 255));
                kGradientPanel2.setkBorderRadius(0);

                GroupLayout kGradientPanel2Layout = new GroupLayout(kGradientPanel2);
                kGradientPanel2.setLayout(kGradientPanel2Layout);
                kGradientPanel2Layout.setHorizontalGroup(
                    kGradientPanel2Layout.createParallelGroup()
                        .addGap(0, 528, Short.MAX_VALUE)
                );
                kGradientPanel2Layout.setVerticalGroup(
                    kGradientPanel2Layout.createParallelGroup()
                        .addGap(0, 538, Short.MAX_VALUE)
                );
            }
            splitPane1.setRightComponent(kGradientPanel2);
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
    private KGradientPanel kGradientPanel1;
    private JLabel label1;
    private JLabel label2;
    private KButton kButton1;
    private KButton kButton2;
    private KButton kButton3;
    private KButton kButton4;
    private KButton kButton5;
    private KButton kButton6;
    private JLabel label3;
    private KButton kButton7;
    private KGradientPanel kGradientPanel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
