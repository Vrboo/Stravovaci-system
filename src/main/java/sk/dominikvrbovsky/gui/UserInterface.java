/*
 * Created by JFormDesigner on Fri Apr 16 13:00:38 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Dominik Vrbovsky
 */
public class UserInterface extends JFrame {
    public UserInterface() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Si prihl\u00e1seny");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(304, 304, 304)
                    .addComponent(label1)
                    .addContainerGap(364, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(label1)
                    .addContainerGap(209, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
