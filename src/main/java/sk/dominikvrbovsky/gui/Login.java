/*
 * Created by JFormDesigner on Wed Apr 14 09:01:37 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import javax.swing.border.*;

import keeptoo.*;

/**
 * @author Dominik Vrbovsky
 */
public class Login extends JFrame {
    public Login() {
        setPreferredSize(new Dimension(1000,600));
        initComponents();
        //myJPanelBackLogin.setLayout(new GridBagLayout());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
        myJPanelBackLogin = new KGradientPanel();
        kGradientPanel1 = new KGradientPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        kButton1 = new KButton();
        kButton2 = new KButton();

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
            myJPanelBackLogin.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
            . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing
            . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
            Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
            ) ,myJPanelBackLogin. getBorder( )) ); myJPanelBackLogin. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
            public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName (
            ) )) throw new RuntimeException( ); }} );

            //======== kGradientPanel1 ========
            {
                kGradientPanel1.setBackground(Color.white);
                kGradientPanel1.setBorder(null);
                kGradientPanel1.setkFillBackground(false);
                kGradientPanel1.setkEndColor(Color.white);
                kGradientPanel1.setkStartColor(Color.white);

                //---- label1 ----
                label1.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_male_user_127px_7.png"));

                //---- textField1 ----
                textField1.setBorder(new MatteBorder(0, 0, 3, 0, Color.black));
                textField1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                textField1.setHorizontalAlignment(SwingConstants.CENTER);
                textField1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
                textField1.setText("Pou\u017e\u00edvate\u013esk\u00e9 meno");
                textField1.setForeground(Color.lightGray);

                //---- passwordField1 ----
                passwordField1.setBorder(new MatteBorder(0, 0, 3, 0, Color.black));
                passwordField1.setHorizontalAlignment(SwingConstants.CENTER);
                passwordField1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
                passwordField1.setText("password");
                passwordField1.setForeground(Color.lightGray);
                passwordField1.setCaretPosition(8);

                //---- kButton1 ----
                kButton1.setText("Prihl\u00e1si\u0165");
                kButton1.setBackground(Color.white);
                kButton1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
                kButton1.setkBorderRadius(30);
                kButton1.setkForeGround(Color.black);
                kButton1.setkAllowTab(true);
                kButton1.setkStartColor(new Color(0, 164, 210));
                kButton1.setkEndColor(Color.white);
                kButton1.setkPressedColor(Color.orange);
                kButton1.setBorder(null);
                kButton1.setkIndicatorThickness(0);
                kButton1.setkHoverStartColor(new Color(121, 241, 164));
                kButton1.setkHoverEndColor(new Color(0, 164, 210));
                kButton1.setkHoverForeGround(Color.white);
                kButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                //---- kButton2 ----
                kButton2.setText("Registrova\u0165");
                kButton2.setBackground(Color.white);
                kButton2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
                kButton2.setkBorderRadius(30);
                kButton2.setkForeGround(Color.black);
                kButton2.setkAllowTab(true);
                kButton2.setkStartColor(Color.white);
                kButton2.setkEndColor(Color.white);
                kButton2.setkPressedColor(Color.white);
                kButton2.setBorder(null);
                kButton2.setkIndicatorThickness(0);
                kButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                GroupLayout kGradientPanel1Layout = new GroupLayout(kGradientPanel1);
                kGradientPanel1.setLayout(kGradientPanel1Layout);
                kGradientPanel1Layout.setHorizontalGroup(
                    kGradientPanel1Layout.createParallelGroup()
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                            .addGroup(kGradientPanel1Layout.createParallelGroup()
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(label1))
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                        .addComponent(passwordField1)
                                        .addComponent(kButton1, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                        .addComponent(kButton2, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))))
                            .addContainerGap(30, Short.MAX_VALUE))
                );
                kGradientPanel1Layout.setVerticalGroup(
                    kGradientPanel1Layout.createParallelGroup()
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(kButton1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(kButton2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(41, Short.MAX_VALUE))
                );
            }

            GroupLayout myJPanelBackLoginLayout = new GroupLayout(myJPanelBackLogin);
            myJPanelBackLogin.setLayout(myJPanelBackLoginLayout);
            myJPanelBackLoginLayout.setHorizontalGroup(
                myJPanelBackLoginLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, myJPanelBackLoginLayout.createSequentialGroup()
                        .addContainerGap(237, Short.MAX_VALUE)
                        .addComponent(kGradientPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(221, Short.MAX_VALUE))
            );
            myJPanelBackLoginLayout.setVerticalGroup(
                myJPanelBackLoginLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, myJPanelBackLoginLayout.createSequentialGroup()
                        .addContainerGap(47, Short.MAX_VALUE)
                        .addComponent(kGradientPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(myJPanelBackLogin, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(myJPanelBackLogin, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private JTextField textField1;
    private JPasswordField passwordField1;
    private KButton kButton1;
    private KButton kButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
