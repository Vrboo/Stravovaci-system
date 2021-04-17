/*
 * Created by JFormDesigner on Fri Apr 16 13:00:38 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import keeptoo.*;
import sk.dominikvrbovsky.User;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Dominik Vrbovsky
 */
public class UserInterface extends JFrame {
    private final User user;

    public UserInterface(User user) {
        initComponents();
        this.user = user;
        label1.setText(user.getFullName());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Nic");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(360, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(297, 297, 297))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addComponent(label1)
                    .addContainerGap(213, Short.MAX_VALUE))
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
