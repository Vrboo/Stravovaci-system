/*
 * Created by JFormDesigner on Thu Apr 15 11:15:32 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import keeptoo.*;

/**
 * @author Dominik Vrbovsky
 */
public class Registration extends JFrame {
    public Registration() {
        setPreferredSize(new Dimension(1000,600));
        initComponents();
    }

    private void labelXMouseEntered() {
        labelX.setIcon(new ImageIcon("src/main/resources/icons/icons8_x_18px_6.png"));
    }

    private void labelXMouseExited() {
        labelX.setIcon(new ImageIcon("src/main/resources/icons/icons8_x_18px.png"));
    }

    private void labelXMouseClicked() {
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
        panelBackRegistration = new KGradientPanel();
        labelX = new JLabel();
        panelRegistration = new KGradientPanel();

        //======== this ========
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panelBackRegistration ========
        {
            panelBackRegistration.setkStartColor(new Color(121, 241, 164));
            panelBackRegistration.setkEndColor(new Color(0, 164, 210));
            panelBackRegistration.setBorder(null);
            panelBackRegistration.setBackground(new Color(0, 164, 210));
            panelBackRegistration.setkBorderRadius(0);
            panelBackRegistration.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
            swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border
            . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog"
            ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,panelBackRegistration. getBorder
            ( )) ); panelBackRegistration. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
            .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException
            ( ); }} );

            //---- labelX ----
            labelX.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_x_18px.png")));
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

            //======== panelRegistration ========
            {
                panelRegistration.setkEndColor(Color.white);
                panelRegistration.setkStartColor(Color.white);
                panelRegistration.setBorder(null);
                panelRegistration.setBackground(Color.white);
                panelRegistration.setkBorderRadius(0);
                panelRegistration.setkFillBackground(false);

                GroupLayout panelRegistrationLayout = new GroupLayout(panelRegistration);
                panelRegistration.setLayout(panelRegistrationLayout);
                panelRegistrationLayout.setHorizontalGroup(
                    panelRegistrationLayout.createParallelGroup()
                        .addGap(0, 300, Short.MAX_VALUE)
                );
                panelRegistrationLayout.setVerticalGroup(
                    panelRegistrationLayout.createParallelGroup()
                        .addGap(0, 388, Short.MAX_VALUE)
                );
            }

            GroupLayout panelBackRegistrationLayout = new GroupLayout(panelBackRegistration);
            panelBackRegistration.setLayout(panelBackRegistrationLayout);
            panelBackRegistrationLayout.setHorizontalGroup(
                panelBackRegistrationLayout.createParallelGroup()
                    .addGroup(panelBackRegistrationLayout.createSequentialGroup()
                        .addContainerGap(240, Short.MAX_VALUE)
                        .addGroup(panelBackRegistrationLayout.createParallelGroup()
                            .addComponent(labelX, GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.TRAILING, panelBackRegistrationLayout.createSequentialGroup()
                                .addComponent(panelRegistration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(238, Short.MAX_VALUE))))
            );
            panelBackRegistrationLayout.setVerticalGroup(
                panelBackRegistrationLayout.createParallelGroup()
                    .addGroup(panelBackRegistrationLayout.createSequentialGroup()
                        .addComponent(labelX)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(panelRegistration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 49, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelBackRegistration, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelBackRegistration, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
    private KGradientPanel panelBackRegistration;
    private JLabel labelX;
    private KGradientPanel panelRegistration;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
