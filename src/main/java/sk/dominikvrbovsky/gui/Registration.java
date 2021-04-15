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
        panelRegistration = new KGradientPanel();
        labelX = new JLabel();

        //======== this ========
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== panelRegistration ========
        {
            panelRegistration.setkStartColor(new Color(121, 241, 164));
            panelRegistration.setkEndColor(new Color(0, 164, 210));
            panelRegistration.setBorder(null);
            panelRegistration.setBackground(new Color(0, 164, 210));
            panelRegistration.setkBorderRadius(0);
            panelRegistration.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax .
            swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e" , javax. swing .border
            . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dialo\u0067"
            , java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,panelRegistration. getBorder
            () ) ); panelRegistration. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java
            . beans. PropertyChangeEvent e) { if( "borde\u0072" .equals ( e. getPropertyName () ) )throw new RuntimeException
            ( ) ;} } );

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

            GroupLayout panelRegistrationLayout = new GroupLayout(panelRegistration);
            panelRegistration.setLayout(panelRegistrationLayout);
            panelRegistrationLayout.setHorizontalGroup(
                panelRegistrationLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panelRegistrationLayout.createSequentialGroup()
                        .addGap(0, 705, Short.MAX_VALUE)
                        .addComponent(labelX))
            );
            panelRegistrationLayout.setVerticalGroup(
                panelRegistrationLayout.createParallelGroup()
                    .addGroup(panelRegistrationLayout.createSequentialGroup()
                        .addComponent(labelX)
                        .addGap(0, 410, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelRegistration, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelRegistration, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
    private KGradientPanel panelRegistration;
    private JLabel labelX;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
