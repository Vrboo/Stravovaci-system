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
        this.user = user;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky

        //======== this ========
        var contentPane = getContentPane();

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 718, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 418, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
