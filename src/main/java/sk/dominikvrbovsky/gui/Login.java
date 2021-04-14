/*
 * Created by JFormDesigner on Wed Apr 14 09:01:37 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;

import keeptoo.*;

/**
 * @author Dominik Vrbovsky
 */
public class Login extends JFrame {
    public Login() {
        setPreferredSize(new Dimension(1000,600));
        initComponents();
        myJPanelBackLogin.setLayout(new GridBagLayout());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
        myJPanelBackLogin = new KGradientPanel();
        kGradientPanel1 = new KGradientPanel();
        label1 = new JLabel();

        //======== this ========
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== myJPanelBackLogin ========
        {
            myJPanelBackLogin.setkStartColor(new Color(121, 241, 164));
            myJPanelBackLogin.setkEndColor(new Color(0, 164, 210));
            myJPanelBackLogin.setBorder(null);
            myJPanelBackLogin.setBackground(new Color(0, 164, 210));
            myJPanelBackLogin.setkBorderRadius(0);
            myJPanelBackLogin.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax .
            swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border
            . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog"
            , java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,myJPanelBackLogin. getBorder
            () ) ); myJPanelBackLogin. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java
            . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException
            ( ) ;} } );

            //======== kGradientPanel1 ========
            {
                kGradientPanel1.setBackground(Color.white);
                kGradientPanel1.setkStartColor(new Color(60, 202, 187));
                kGradientPanel1.setkEndColor(new Color(14, 173, 204));
                kGradientPanel1.setkBorderRadius(0);
                kGradientPanel1.setkFillBackground(false);

                //---- label1 ----
                label1.setIcon(new ImageIcon(getClass().getResource("/sk/dominikvrbovsky/icons/icons101.png")));

                GroupLayout kGradientPanel1Layout = new GroupLayout(kGradientPanel1);
                kGradientPanel1.setLayout(kGradientPanel1Layout);
                kGradientPanel1Layout.setHorizontalGroup(
                    kGradientPanel1Layout.createParallelGroup()
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                            .addGap(158, 158, 158)
                            .addComponent(label1)
                            .addContainerGap(165, Short.MAX_VALUE))
                );
                kGradientPanel1Layout.setVerticalGroup(
                    kGradientPanel1Layout.createParallelGroup()
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(label1)
                            .addContainerGap(266, Short.MAX_VALUE))
                );
            }

            GroupLayout myJPanelBackLoginLayout = new GroupLayout(myJPanelBackLogin);
            myJPanelBackLogin.setLayout(myJPanelBackLoginLayout);
            myJPanelBackLoginLayout.setHorizontalGroup(
                myJPanelBackLoginLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, myJPanelBackLoginLayout.createSequentialGroup()
                        .addContainerGap(217, Short.MAX_VALUE)
                        .addComponent(kGradientPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192))
            );
            myJPanelBackLoginLayout.setVerticalGroup(
                myJPanelBackLoginLayout.createParallelGroup()
                    .addGroup(myJPanelBackLoginLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(kGradientPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(myJPanelBackLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(myJPanelBackLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
    private KGradientPanel myJPanelBackLogin;
    private KGradientPanel kGradientPanel1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
