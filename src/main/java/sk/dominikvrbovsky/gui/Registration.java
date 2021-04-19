/*
 * Created by JFormDesigner on Thu Apr 15 11:15:32 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import java.awt.event.*;
import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import java.util.Optional;
import javax.swing.border.*;
import keeptoo.*;
import sk.dominikvrbovsky.User;
import sk.dominikvrbovsky.dao.impl.UserDao;
import sk.dominikvrbovsky.utilities.Utilities;

/**
 * @author Dominik Vrbovsky
 */
public class Registration extends JFrame {

    private final EntityManager entityManager;

    public Registration(EntityManager entityManager) {
        this.entityManager = entityManager;
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
        entityManager.close();
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

        if (pass.equals("Heslo*")) {
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
            password1.setText("Heslo*");
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

    private void buttonPrihlasitActionPerformed() {
        UserDao userDao = new UserDao(entityManager);
        String password1string = String.valueOf(password1.getPassword());
        String password2string = String.valueOf(password2.getPassword());

        if (fieldPouzMeno.getText().equals("Používateľské meno") ||
                fielCeleMeno.getText().equals("Celé meno") ||
                password1string.equals("Heslo*") ||
                password2string.equals("Potvrdenie hesla")) {

            label1.setForeground(Color.RED);
            label1.setText("Vyplňte všetky položky, prosím.");
            return;
        }

        Optional<User> loginUser = userDao.getFromUsername(fieldPouzMeno.getText());
        if (loginUser.isPresent()) {
            label1.setForeground(Color.RED);
            label1.setText("Toto používateľské meno už je obsadené.");
            return;
        }

        if (!password1string.equals(password2string)) {
            label1.setForeground(Color.RED);
            label1.setText("Heslá sa nezhodujú.");
            return;
        }

        if (!Utilities.checkPassword(password1string)) {
            label1.setForeground(Color.RED);
            label1.setText("Heslo - min. 6 znakov, 1 číslicu, 1 veľké písmeno");
            return;
        }

        User user = new User(fieldPouzMeno.getText(),fielCeleMeno.getText(),password1string, 0.0);
        userDao.save(user);

        UserInterface userInterface = new UserInterface(user);
        userInterface.setVisible(true);
        this.dispose();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
        panelBackRegistration = new KGradientPanel();
        labelX = new JLabel();
        panelRegistration = new KGradientPanel();
        labelIcon = new JLabel();
        fieldPouzMeno = new JTextField();
        fielCeleMeno = new JTextField();
        password1 = new JPasswordField();
        password2 = new JPasswordField();
        buttonPrihlasit = new KButton();
        label1 = new JLabel();

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
            swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border
            . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg"
            ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,panelBackRegistration. getBorder
            ( )) ); panelBackRegistration. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
            .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException
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

                //---- labelIcon ----
                labelIcon.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_add_user_male_100px.png"));

                //---- fieldPouzMeno ----
                fieldPouzMeno.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                fieldPouzMeno.setText("Pou\u017e\u00edvate\u013esk\u00e9 meno");
                fieldPouzMeno.setFocusable(false);
                fieldPouzMeno.setHorizontalAlignment(SwingConstants.CENTER);
                fieldPouzMeno.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                fieldPouzMeno.setForeground(Color.lightGray);
                fieldPouzMeno.setPreferredSize(new Dimension(49, 29));
                fieldPouzMeno.setCaretPosition(15);
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
                        fieldPouzMenoFocusGained();
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        fieldPouzMenoFocusLost();
                    }
                });

                //---- fielCeleMeno ----
                fielCeleMeno.setText("Cel\u00e9 meno");
                fielCeleMeno.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                fielCeleMeno.setFocusable(false);
                fielCeleMeno.setHorizontalAlignment(SwingConstants.CENTER);
                fielCeleMeno.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                fielCeleMeno.setForeground(Color.lightGray);
                fielCeleMeno.setPreferredSize(new Dimension(49, 29));
                fielCeleMeno.setCaretPosition(9);
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
                password1.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                password1.setText("Heslo*");
                password1.setFocusable(false);
                password1.setHorizontalAlignment(SwingConstants.CENTER);
                password1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                password1.setForeground(Color.lightGray);
                password1.setCaretPosition(5);
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
                password2.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                password2.setText("Potvrdenie hesla");
                password2.setFocusable(false);
                password2.setHorizontalAlignment(SwingConstants.CENTER);
                password2.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                password2.setForeground(Color.lightGray);
                password2.setPreferredSize(new Dimension(49, 29));
                password2.setCaretPosition(16);
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
                buttonPrihlasit.setkHoverForeGround(Color.black);
                buttonPrihlasit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                buttonPrihlasit.setkSelectedColor(new Color(0, 164, 210));
                buttonPrihlasit.setkForeGround(Color.black);
                buttonPrihlasit.addActionListener(e -> buttonPrihlasitActionPerformed());

                GroupLayout panelRegistrationLayout = new GroupLayout(panelRegistration);
                panelRegistration.setLayout(panelRegistrationLayout);
                panelRegistrationLayout.setHorizontalGroup(
                    panelRegistrationLayout.createParallelGroup()
                        .addGroup(panelRegistrationLayout.createSequentialGroup()
                            .addGroup(panelRegistrationLayout.createParallelGroup()
                                .addGroup(panelRegistrationLayout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addGroup(panelRegistrationLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(password2, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(password1, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldPouzMeno, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fielCeleMeno, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonPrihlasit, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panelRegistrationLayout.createSequentialGroup()
                                    .addGap(95, 95, 95)
                                    .addComponent(labelIcon)))
                            .addContainerGap(20, Short.MAX_VALUE))
                );
                panelRegistrationLayout.setVerticalGroup(
                    panelRegistrationLayout.createParallelGroup()
                        .addGroup(panelRegistrationLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(labelIcon)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(fieldPouzMeno, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(fielCeleMeno, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                            .addComponent(password1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(password2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(buttonPrihlasit, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22))
                );
            }

            //---- label1 ----
            label1.setText("*min. 6 znakov, 1 \u010d\u00edslica, 1 ve\u013ek\u00e9 p\u00edsmeno");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
            label1.setForeground(Color.white);

            GroupLayout panelBackRegistrationLayout = new GroupLayout(panelBackRegistration);
            panelBackRegistration.setLayout(panelBackRegistrationLayout);
            panelBackRegistrationLayout.setHorizontalGroup(
                panelBackRegistrationLayout.createParallelGroup()
                    .addGroup(panelBackRegistrationLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelX))
                    .addGroup(panelBackRegistrationLayout.createSequentialGroup()
                        .addContainerGap(243, Short.MAX_VALUE)
                        .addGroup(panelBackRegistrationLayout.createParallelGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRegistration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(243, Short.MAX_VALUE))
            );
            panelBackRegistrationLayout.setVerticalGroup(
                panelBackRegistrationLayout.createParallelGroup()
                    .addGroup(panelBackRegistrationLayout.createSequentialGroup()
                        .addComponent(labelX)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRegistration, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label1)
                        .addContainerGap(14, Short.MAX_VALUE))
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
    private JTextField fielCeleMeno;
    private JPasswordField password1;
    private JPasswordField password2;
    private KButton buttonPrihlasit;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
