/*
 * Created by JFormDesigner on Mon May 10 11:24:49 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import keeptoo.*;
import sk.dominikvrbovsky.User;
import sk.dominikvrbovsky.dao.impl.UserDao;
import sk.dominikvrbovsky.utilities.PasswordUtilities;

/**
 * @author Dominik Vrbovský
 */
public class Registration extends JFrame {
    private final EntityManager entityManager;
    private final UserDao userDao;
    
    public Registration(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.userDao = new UserDao(entityManager);
        setPreferredSize(new Dimension(1000,750));
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

    private void buttonRegistrovatActionPerformed() {
        String password1string = String.valueOf(password1.getPassword());
        String password2string = String.valueOf(password2.getPassword());

        if (fieldPouzMeno.getText().equals("Používateľské meno") ||
                fielCeleMeno.getText().equals("Celé meno") ||
                password1string.equals("Heslo*") ||
                password2string.equals("Potvrdenie hesla")) {

            labelWarning.setText("Vyplňte všetky položky, prosím");
            return;
        }

        Optional<User> loginUser;
        try {
            loginUser = userDao.getFromUsername(fieldPouzMeno.getText());
        } catch (Exception e) {
            labelWarning.setText("Registrácia zlyhala");
            return;
        }


        if (loginUser.isPresent()) {
            labelWarning.setText("Meno " + fieldPouzMeno.getText() + " už je obsadené");
            return;
        }

        if (!password1string.equals(password2string)) {
            labelWarning.setText("Heslá sa nezhodujú");
            return;
        }

        if (!PasswordUtilities.checkPassword(password1string)) {
            labelWarning.setText("Heslo má nesprávny formát");
            return;
        }

        User user = new User(fieldPouzMeno.getText(),fielCeleMeno.getText(),password1string);
        try {
            userDao.save(user);
        } catch (Exception e) {
            labelWarning.setText("Registrácia zlyhala");
            return;
        }

        UserInterface userInterface = new UserInterface(entityManager, user);
        userInterface.setVisible(true);
        this.dispose();
        buttonRegistrovat.setSelected(false);

    }

    private void buttonPrihlasitActionPerformed() {
        JFrame jFrame = new Login(entityManager);
        jFrame.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovský
        myJPanelBackLogin = new KGradientPanel();
        panelRegistration = new KGradientPanel();
        labelIcon = new JLabel();
        fieldPouzMeno = new JTextField();
        fielCeleMeno = new JTextField();
        password1 = new JPasswordField();
        password2 = new JPasswordField();
        buttonRegistrovat = new KButton();
        buttonPrihlasit = new KButton();
        label1 = new JLabel();
        labelWarning = new JLabel();
        panelStravovaciSystem = new KGradientPanel();
        labelStravovaciSystem = new JLabel();
        labelX = new JLabel();
        label4 = new JLabel();

        //======== this ========
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== myJPanelBackLogin ========
        {
            myJPanelBackLogin.setkStartColor(Color.white);
            myJPanelBackLogin.setkEndColor(Color.white);
            myJPanelBackLogin.setBorder(null);
            myJPanelBackLogin.setBackground(Color.white);
            myJPanelBackLogin.setkBorderRadius(0);
            myJPanelBackLogin.setkGradientFocus(750);
            myJPanelBackLogin.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
            swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border
            .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog"
            ,java.awt.Font.BOLD,12),java.awt.Color.red),myJPanelBackLogin. getBorder
            ()));myJPanelBackLogin. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
            .beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException
            ();}});
            myJPanelBackLogin.setLayout(new GridBagLayout());
            ((GridBagLayout)myJPanelBackLogin.getLayout()).rowHeights = new int[] {0, 19, 24};

            //======== panelRegistration ========
            {
                panelRegistration.setkEndColor(Color.white);
                panelRegistration.setkStartColor(Color.white);
                panelRegistration.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));
                panelRegistration.setBackground(Color.white);
                panelRegistration.setkBorderRadius(0);
                panelRegistration.setkFillBackground(false);
                panelRegistration.setLayout(new FormLayout(
                    "200dlu",
                    "fill:79dlu, 4*(4dlu, fill:30dlu), 10dlu, fill:30dlu, 0dlu, 30dlu, 0dlu, 9dlu"));

                //---- labelIcon ----
                labelIcon.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_add_user_male_100px.png"));
                labelIcon.setHorizontalAlignment(SwingConstants.CENTER);
                panelRegistration.add(labelIcon, new CellConstraints(1, 1, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(10, 0, 0, 0)));

                //---- fieldPouzMeno ----
                fieldPouzMeno.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                fieldPouzMeno.setText("Pou\u017e\u00edvate\u013esk\u00e9 meno");
                fieldPouzMeno.setFocusable(false);
                fieldPouzMeno.setHorizontalAlignment(SwingConstants.CENTER);
                fieldPouzMeno.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
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
                panelRegistration.add(fieldPouzMeno, new CellConstraints(1, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 30, 0, 30)));

                //---- fielCeleMeno ----
                fielCeleMeno.setText("Cel\u00e9 meno");
                fielCeleMeno.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                fielCeleMeno.setFocusable(false);
                fielCeleMeno.setHorizontalAlignment(SwingConstants.CENTER);
                fielCeleMeno.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
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
                panelRegistration.add(fielCeleMeno, new CellConstraints(1, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 30, 0, 30)));

                //---- password1 ----
                password1.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                password1.setText("Heslo*");
                password1.setFocusable(false);
                password1.setHorizontalAlignment(SwingConstants.CENTER);
                password1.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                password1.setForeground(Color.lightGray);
                password1.setCaretPosition(5);
                password1.setEchoChar('\u2022');
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
                panelRegistration.add(password1, new CellConstraints(1, 7, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 30, 0, 30)));

                //---- password2 ----
                password2.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                password2.setText("Potvrdenie hesla");
                password2.setFocusable(false);
                password2.setHorizontalAlignment(SwingConstants.CENTER);
                password2.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                password2.setForeground(Color.lightGray);
                password2.setPreferredSize(new Dimension(49, 29));
                password2.setCaretPosition(16);
                password2.setEchoChar('\u2022');
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
                panelRegistration.add(password2, new CellConstraints(1, 9, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 30, 0, 30)));

                //---- buttonRegistrovat ----
                buttonRegistrovat.setText("Registrova\u0165");
                buttonRegistrovat.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                buttonRegistrovat.setBorder(null);
                buttonRegistrovat.setkStartColor(new Color(73, 196, 174));
                buttonRegistrovat.setkEndColor(new Color(140, 219, 145));
                buttonRegistrovat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                buttonRegistrovat.setkHoverEndColor(new Color(73, 196, 174));
                buttonRegistrovat.setkHoverStartColor(new Color(140, 219, 145));
                buttonRegistrovat.setkHoverForeGround(Color.white);
                buttonRegistrovat.setBackground(Color.white);
                buttonRegistrovat.setBorderPainted(false);
                buttonRegistrovat.setMaximumSize(new Dimension(97, 24));
                buttonRegistrovat.setMinimumSize(new Dimension(97, 24));
                buttonRegistrovat.setkBorderRadius(20);
                buttonRegistrovat.addActionListener(e -> buttonRegistrovatActionPerformed());
                panelRegistration.add(buttonRegistrovat, new CellConstraints(1, 11, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(5, 30, 5, 30)));

                //---- buttonPrihlasit ----
                buttonPrihlasit.setText("Prihl\u00e1si\u0165");
                buttonPrihlasit.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                buttonPrihlasit.setBorder(null);
                buttonPrihlasit.setkStartColor(new Color(255, 161, 117));
                buttonPrihlasit.setkEndColor(new Color(255, 58, 58));
                buttonPrihlasit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                buttonPrihlasit.setkHoverStartColor(new Color(255, 84, 84));
                buttonPrihlasit.setkHoverForeGround(Color.white);
                buttonPrihlasit.setBackground(Color.white);
                buttonPrihlasit.setBorderPainted(false);
                buttonPrihlasit.setMaximumSize(new Dimension(97, 24));
                buttonPrihlasit.setMinimumSize(new Dimension(97, 24));
                buttonPrihlasit.setkBorderRadius(20);
                buttonPrihlasit.setkHoverEndColor(new Color(255, 161, 117));
                buttonPrihlasit.addActionListener(e -> buttonPrihlasitActionPerformed());
                panelRegistration.add(buttonPrihlasit, new CellConstraints(1, 13, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(5, 30, 5, 30)));
            }
            myJPanelBackLogin.add(panelRegistration, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label1 ----
            label1.setText("*min. 6 znakov, 1 \u010d\u00edslica, 1 ve\u013ek\u00e9 p\u00edsmeno");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
            myJPanelBackLogin.add(label1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- labelWarning ----
            labelWarning.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
            labelWarning.setForeground(Color.red);
            labelWarning.setHorizontalAlignment(SwingConstants.CENTER);
            labelWarning.setVerticalAlignment(SwingConstants.TOP);
            myJPanelBackLogin.add(labelWarning, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }

        //======== panelStravovaciSystem ========
        {
            panelStravovaciSystem.setBorder(null);
            panelStravovaciSystem.setkBorderRadius(0);
            panelStravovaciSystem.setkStartColor(new Color(38, 184, 190));
            panelStravovaciSystem.setkEndColor(new Color(150, 223, 141));
            panelStravovaciSystem.setkGradientFocus(600);
            panelStravovaciSystem.setBackground(new Color(107, 209, 158));

            //---- labelStravovaciSystem ----
            labelStravovaciSystem.setText("Stravovac\u00ed syst\u00e9m");
            labelStravovaciSystem.setFont(new Font("Yu Gothic UI", Font.BOLD, 50));
            labelStravovaciSystem.setHorizontalAlignment(SwingConstants.CENTER);
            labelStravovaciSystem.setForeground(new Color(70, 70, 70));

            //---- labelX ----
            labelX.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_x_18px.png"));
            labelX.setHorizontalAlignment(SwingConstants.CENTER);
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

            //---- label4 ----
            label4.setText("created by Dominik Vrbovsk\u00fd");
            label4.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
            label4.setForeground(new Color(70, 70, 70));
            label4.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout panelStravovaciSystemLayout = new GroupLayout(panelStravovaciSystem);
            panelStravovaciSystem.setLayout(panelStravovaciSystemLayout);
            panelStravovaciSystemLayout.setHorizontalGroup(
                panelStravovaciSystemLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panelStravovaciSystemLayout.createSequentialGroup()
                        .addContainerGap(251, Short.MAX_VALUE)
                        .addGroup(panelStravovaciSystemLayout.createParallelGroup()
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                .addComponent(labelStravovaciSystem, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                                .addComponent(labelX, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
            );
            panelStravovaciSystemLayout.setVerticalGroup(
                panelStravovaciSystemLayout.createParallelGroup()
                    .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                        .addComponent(labelX, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 122, Short.MAX_VALUE))
                    .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                        .addContainerGap(17, Short.MAX_VALUE)
                        .addComponent(labelStravovaciSystem)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(31, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(myJPanelBackLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelStravovaciSystem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addComponent(panelStravovaciSystem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(myJPanelBackLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik Vrbovský
    private KGradientPanel myJPanelBackLogin;
    private KGradientPanel panelRegistration;
    private JLabel labelIcon;
    private JTextField fieldPouzMeno;
    private JTextField fielCeleMeno;
    private JPasswordField password1;
    private JPasswordField password2;
    private KButton buttonRegistrovat;
    private KButton buttonPrihlasit;
    private JLabel label1;
    private JLabel labelWarning;
    private KGradientPanel panelStravovaciSystem;
    private JLabel labelStravovaciSystem;
    private JLabel labelX;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
