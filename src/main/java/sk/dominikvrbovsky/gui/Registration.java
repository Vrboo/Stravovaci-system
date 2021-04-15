/*
 * Created by JFormDesigner on Thu Apr 15 11:15:32 CEST 2021
 */

package sk.dominikvrbovsky.gui;

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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
        panelRegistration = new KGradientPanel();

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
            panelRegistration.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
            . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing
            .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
            Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
            ) ,panelRegistration. getBorder () ) ); panelRegistration. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
            public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName (
            ) ) )throw new RuntimeException( ) ;} } );

            GroupLayout panelRegistrationLayout = new GroupLayout(panelRegistration);
            panelRegistration.setLayout(panelRegistrationLayout);
            panelRegistrationLayout.setHorizontalGroup(
                panelRegistrationLayout.createParallelGroup()
                    .addGap(0, 723, Short.MAX_VALUE)
            );
            panelRegistrationLayout.setVerticalGroup(
                panelRegistrationLayout.createParallelGroup()
                    .addGap(0, 428, Short.MAX_VALUE)
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
