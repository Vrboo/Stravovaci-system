/*
 * Created by JFormDesigner on Thu Apr 15 11:15:32 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import javax.swing.border.*;
import keeptoo.*;

/**
 * @author Dominik Vrbovsky
 */
public class Registration extends JFrame {
    public Registration() {
        setPreferredSize(new Dimension(1000,600));
        initComponents();
        password1.setEchoChar((char)0);
        password2.setEchoChar((char)0);

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

    private void textField1MouseMoved() {
        fieldPouzMeno.setFocusable(true);
    }

    private void textField2MouseMoved() {
        fielCeleMeno.setFocusable(true);
    }

    private void password1MouseMoved() {
        password1.setFocusable(true);
    }

    private void password2MouseMoved() {
        password2.setFocusable(true);
    }

    private void fieldPouzMenoFocusGained() {
        if (fieldPouzMeno.getText().equals("Používateľské meno")) {
            fieldPouzMeno.setForeground(Color.BLACK);
            fieldPouzMeno.setText("");
        }
    }

    private void fieldPouzMenoFocusLost() {
        if (fieldPouzMeno.getText().equals("")) {
            fieldPouzMeno.setForeground(new Color(192,192,192));
            fieldPouzMeno.setText("Používateľské meno");
        }
    }

    private void fielCeleMenoFocusGained() {
        if (fielCeleMeno.getText().equals("Celé meno")) {
            fielCeleMeno.setForeground(Color.BLACK);
            fielCeleMeno.setText("");
        }
    }

    private void password1FocusGained() {
        String pass = String.valueOf(password1.getPassword());

        if (pass.equals("Heslo")) {
            password1.setEchoChar((char)0x2022);
            password1.setForeground(Color.BLACK);
            password1.setText("");
        }
    }

    private void password1FocusLost() {
        String pass = String.valueOf(password1.getPassword());

        if (pass.equals("")) {
            password1.setEchoChar((char)0);
            password1.setForeground(new Color(192,192,192));
            password1.setText("Heslo");
        }
    }

    private void password2FocusGained() {
        String pass = String.valueOf(password2.getPassword());

        if (pass.equals("Potvrdenie hesla")) {
            password2.setEchoChar((char)0x2022);
            password2.setForeground(Color.BLACK);
            password2.setText("");
        } 
    }

    private void fielCeleMenoFocusLost() {
        if (fielCeleMeno.getText().equals("")) {
            fielCeleMeno.setForeground(new Color(192,192,192));
            fielCeleMeno.setText("Celé meno");
        }
    }

    private void password2FocusLost() {
        String pass = String.valueOf(password2.getPassword());

        if (pass.equals("")) {
            password2.setEchoChar((char)0);
            password2.setForeground(new Color(192,192,192));
            password2.setText("Potvrdenie hesla");
        }
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
        panelBackRegistration = new KGradientPanel();
        labelX = new JLabel();
        panelRegistration = new KGradientPanel();
        labelIcon = new JLabel();
        fieldPouzMeno = new JTextField();
        buttonPrihlasit = new KButton();
        fielCeleMeno = new JTextField();
        password1 = new JPasswordField();
        password2 = new JPasswordField();

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
            panelBackRegistration.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
            .swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing
            .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
            Font("Dialo\u0067",java.awt.Font.BOLD,12),java.awt.Color.red
            ),panelBackRegistration. getBorder()));panelBackRegistration. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
            public void propertyChange(java.beans.PropertyChangeEvent e){if("borde\u0072".equals(e.getPropertyName(
            )))throw new RuntimeException();}});

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

                //---- labelIcon ----
                labelIcon.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_add_user_male_100px.png"));

                //---- fieldPouzMeno ----
                fieldPouzMeno.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                fieldPouzMeno.setText("Pou\u017e\u00edvate\u013esk\u00e9 meno");
                fieldPouzMeno.setFocusable(false);
                fieldPouzMeno.setHorizontalAlignment(SwingConstants.CENTER);
                fieldPouzMeno.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                fieldPouzMeno.setForeground(Color.lightGray);
                fieldPouzMeno.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        textField1MouseMoved();
                    }
                });
                fieldPouzMeno.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        fieldPouzMenoFocusGained();
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        fieldPouzMenoFocusLost();
                    }
                });

                //---- buttonPrihlasit ----
                buttonPrihlasit.setText("Registrova\u0165");
                buttonPrihlasit.setBackground(Color.white);
                buttonPrihlasit.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                buttonPrihlasit.setkBorderRadius(30);
                buttonPrihlasit.setkAllowTab(true);
                buttonPrihlasit.setkStartColor(new Color(0, 164, 210));
                buttonPrihlasit.setkEndColor(new Color(121, 241, 164));
                buttonPrihlasit.setkPressedColor(Color.orange);
                buttonPrihlasit.setBorder(null);
                buttonPrihlasit.setkIndicatorThickness(0);
                buttonPrihlasit.setkHoverStartColor(new Color(121, 241, 164));
                buttonPrihlasit.setkHoverEndColor(new Color(0, 164, 210));
                buttonPrihlasit.setkHoverForeGround(Color.white);
                buttonPrihlasit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                buttonPrihlasit.setkSelectedColor(new Color(0, 164, 210));

                //---- fielCeleMeno ----
                fielCeleMeno.setText("Cel\u00e9 meno");
                fielCeleMeno.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                fielCeleMeno.setFocusable(false);
                fielCeleMeno.setHorizontalAlignment(SwingConstants.CENTER);
                fielCeleMeno.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                fielCeleMeno.setForeground(Color.lightGray);
                fielCeleMeno.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        textField1MouseMoved();
                        textField2MouseMoved();
                    }
                });
                fielCeleMeno.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        fielCeleMenoFocusGained();
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        fielCeleMenoFocusLost();
                    }
                });

                //---- password1 ----
                password1.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                password1.setText("Heslo");
                password1.setFocusable(false);
                password1.setHorizontalAlignment(SwingConstants.CENTER);
                password1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                password1.setForeground(Color.lightGray);
                password1.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        textField1MouseMoved();
                        password1MouseMoved();
                        password1MouseMoved();
                    }
                });
                password1.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        password1FocusGained();
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        password1FocusLost();
                    }
                });

                //---- password2 ----
                password2.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                password2.setText("Potvrdenie hesla");
                password2.setFocusable(false);
                password2.setHorizontalAlignment(SwingConstants.CENTER);
                password2.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                password2.setForeground(Color.lightGray);
                password2.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        textField1MouseMoved();
                        password2MouseMoved();
                    }
                });
                password2.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        password2FocusGained();
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        password2FocusLost();
                    }
                });

                GroupLayout panelRegistrationLayout = new GroupLayout(panelRegistration);
                panelRegistration.setLayout(panelRegistrationLayout);
                panelRegistrationLayout.setHorizontalGroup(
                    panelRegistrationLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panelRegistrationLayout.createSequentialGroup()
                            .addComponent(labelIcon)
                            .addGap(96, 96, 96))
                        .addGroup(panelRegistrationLayout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(panelRegistrationLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fieldPouzMeno, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                .addComponent(password1, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                .addComponent(password2, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                .addComponent(buttonPrihlasit, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                .addComponent(fielCeleMeno, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                            .addGap(30, 30, 30))
                );
                panelRegistrationLayout.setVerticalGroup(
                    panelRegistrationLayout.createParallelGroup()
                        .addGroup(panelRegistrationLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(labelIcon)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(fieldPouzMeno, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(fielCeleMeno, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(password1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(password2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(buttonPrihlasit, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(30, Short.MAX_VALUE))
                );
            }

            GroupLayout panelBackRegistrationLayout = new GroupLayout(panelBackRegistration);
            panelBackRegistration.setLayout(panelBackRegistrationLayout);
            panelBackRegistrationLayout.setHorizontalGroup(
                panelBackRegistrationLayout.createParallelGroup()
                    .addGroup(panelBackRegistrationLayout.createSequentialGroup()
                        .addContainerGap(760, Short.MAX_VALUE)
                        .addComponent(labelX))
                    .addGroup(GroupLayout.Alignment.TRAILING, panelBackRegistrationLayout.createSequentialGroup()
                        .addContainerGap(243, Short.MAX_VALUE)
                        .addComponent(panelRegistration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 243, Short.MAX_VALUE))
            );
            panelBackRegistrationLayout.setVerticalGroup(
                panelBackRegistrationLayout.createParallelGroup()
                    .addGroup(panelBackRegistrationLayout.createSequentialGroup()
                        .addComponent(labelX)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(panelRegistration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
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
    private JLabel labelIcon;
    private JTextField fieldPouzMeno;
    private KButton buttonPrihlasit;
    private JTextField fielCeleMeno;
    private JPasswordField password1;
    private JPasswordField password2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
