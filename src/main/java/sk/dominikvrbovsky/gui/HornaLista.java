/*
 * Created by JFormDesigner on Tue Apr 20 17:42:20 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import keeptoo.*;

/**
 * @author Dominik Vrbovsky
 */
public class HornaLista extends JPanel {
    public HornaLista() {
        initComponents();
    }

    private void labelXObjednatMouseEntered() {
        // TODO add your code here
    }

    private void labelXObjednatMouseExited() {
        // TODO add your code here
    }

    private void labelXObjednatMouseClicked() {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
        panelObjednatMenu = new KGradientPanel();
        labelStravovaciSystem = new JLabel();
        labelDatum = new JLabel();
        labelXObjednat = new JLabel();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
        . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder
        . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .
        awt . Font. BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) )
        ;  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
        ) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
        ;

        //======== panelObjednatMenu ========
        {
            panelObjednatMenu.setBorder(null);
            panelObjednatMenu.setkBorderRadius(0);
            panelObjednatMenu.setkStartColor(new Color(38, 184, 190));
            panelObjednatMenu.setkEndColor(new Color(150, 223, 141));
            panelObjednatMenu.setkGradientFocus(600);

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

            //---- labelXObjednat ----
            labelXObjednat.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_x_18px.png"));
            labelXObjednat.setHorizontalAlignment(SwingConstants.CENTER);
            labelXObjednat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            labelXObjednat.addMouseListener(new MouseAdapter() {
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

            GroupLayout panelObjednatMenuLayout = new GroupLayout(panelObjednatMenu);
            panelObjednatMenu.setLayout(panelObjednatMenuLayout);
            panelObjednatMenuLayout.setHorizontalGroup(
                panelObjednatMenuLayout.createParallelGroup()
                    .addGroup(panelObjednatMenuLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panelObjednatMenuLayout.createParallelGroup()
                            .addComponent(labelStravovaciSystem, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDatum, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelXObjednat, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
            );
            panelObjednatMenuLayout.setVerticalGroup(
                panelObjednatMenuLayout.createParallelGroup()
                    .addGroup(panelObjednatMenuLayout.createSequentialGroup()
                        .addComponent(labelXObjednat, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelObjednatMenuLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(labelStravovaciSystem, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(labelDatum, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(60, Short.MAX_VALUE))
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(panelObjednatMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(211, 211, 211))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(169, Short.MAX_VALUE)
                    .addComponent(panelObjednatMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(51, 51, 51))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
    private KGradientPanel panelObjednatMenu;
    private JLabel labelStravovaciSystem;
    private JLabel labelDatum;
    private JLabel labelXObjednat;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
