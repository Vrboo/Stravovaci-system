/*
 * Created by JFormDesigner on Wed Apr 14 09:01:37 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import java.awt.event.*;
import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import java.util.Optional;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

import keeptoo.*;
import sk.dominikvrbovsky.User;
import sk.dominikvrbovsky.dao.impl.UserDao;

/**
 * @author Dominik Vrbovsky
 */
public class Login extends JFrame {

    private final EntityManager entityManager;
    private final UserDao userDao;

    public Login(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.userDao = new UserDao(this.entityManager);
        setPreferredSize(new Dimension(1000, 650));
        initComponents();
        textPassword.setEchoChar((char)0);
    }

    private void textFieldUsernameFocusGained(FocusEvent e) {
        if (textFieldUsername.getText().equals("Používateľské meno")) {
            textFieldUsername.setText("");
            textFieldUsername.setForeground(Color.BLACK);
        }
    }

    private void textFieldUsernameMouseMoved() {
        textFieldUsername.setFocusable(true);
    }

    private void textPasswordMouseMoved() {
        textPassword.setFocusable(true);
    }

    private void textPasswordFocusGained() {
        String password = String.valueOf(textPassword.getPassword());
        if (password.equals("Heslo")) {
            textPassword.setEchoChar((char)0x2022);
            textPassword.setText("");
            textPassword.setForeground(Color.BLACK);
        }
    }

    private void textFieldUsernameFocusLost() {
        if (textFieldUsername.getText().equals("")) {
            textFieldUsername.setForeground(new Color(192,192,192));
            textFieldUsername.setText("Používateľské meno");
        }
    }

    private void textPasswordFocusLost() {
        String password = String.valueOf(textPassword.getPassword());
        
        if (password.equals("")) {
            textPassword.setEchoChar((char)0);
            textPassword.setForeground(new Color(192,192,192));
            textPassword.setText("Heslo");
        }
    }

    private void buttonPrihlasitActionPerformed() {
        String password = String.valueOf(textPassword.getPassword());

        if (textFieldUsername.getText().equals("Používateľské meno") && password.equals("Heslo")) {
            labelWarning.setText("Zadajte meno a heslo");
        } else if (textFieldUsername.getText().equals("Používateľské meno") && !password.equals("Heslo")) {
            labelWarning.setText("Zadajte používateľské meno");
        } else if (!textFieldUsername.getText().equals("Používateľské meno") && password.equals("Heslo")) {
            labelWarning.setText("Zadajte heslo");
        } else if (!textFieldUsername.getText().equals("Používateľské meno") && !password.equals("Heslo")) {
            Optional<User> user;
            try {
                user = userDao.getFromUsername(textFieldUsername.getText());
            } catch (Exception e) {
                labelWarning.setText("Prihlasovenie zlyhalo");
                return;
            }

            if (user.isPresent() && user.get().getPassword().equals(password)) {
                UserInterface userInterface = new UserInterface(entityManager, user.get());
                userInterface.setVisible(true);
                this.dispose();
            } else {
                labelWarning.setText("Nesprávne meno alebo heslo");
            }
        }

        buttonPrihlasit.setSelected(false);
    }

    private void labelXMouseClicked() {
        entityManager.close();
        System.exit(0);
    }

    private void labelXMouseEntered() {
        labelX.setIcon(new ImageIcon(
                "src\\\\main\\\\resources\\\\icons\\\\icons8_x_18px_6.png"));
    }

    private void labelXMouseExited() {
        labelX.setIcon(new ImageIcon(
                "src\\\\main\\\\resources\\\\icons\\\\icons8_x_18px.png"));
    }

    private void btnRegistrovatActionPerformed() {
        Registration registration = new Registration(entityManager);
        registration.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovský
        myJPanelBackLogin = new KGradientPanel();
        panelPrihlasenie = new KGradientPanel();
        labeluserIcon = new JLabel();
        textFieldUsername = new JTextField();
        textPassword = new JPasswordField();
        buttonPrihlasit = new KButton();
        buttonRegistrovat = new KButton();
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
            myJPanelBackLogin.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
            EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing
            . border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ),
            java. awt. Color. red) ,myJPanelBackLogin. getBorder( )) ); myJPanelBackLogin. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
            { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () ))
            throw new RuntimeException( ); }} );
            myJPanelBackLogin.setLayout(new GridBagLayout());
            ((GridBagLayout)myJPanelBackLogin.getLayout()).rowHeights = new int[] {0, 24};

            //======== panelPrihlasenie ========
            {
                panelPrihlasenie.setBackground(Color.white);
                panelPrihlasenie.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));
                panelPrihlasenie.setkFillBackground(false);
                panelPrihlasenie.setkEndColor(Color.white);
                panelPrihlasenie.setkStartColor(Color.white);
                panelPrihlasenie.setkBorderRadius(0);
                panelPrihlasenie.setLayout(new FormLayout(
                    "201dlu",
                    "fill:79dlu, 2*($lgap, fill:30dlu), 10dlu, 2*(fill:30dlu, 0dlu), 9dlu"));

                //---- labeluserIcon ----
                labeluserIcon.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_male_user_100px_1.png")));
                labeluserIcon.setHorizontalAlignment(SwingConstants.CENTER);
                panelPrihlasenie.add(labeluserIcon, new CellConstraints(1, 1, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(10, 0, 0, 0)));

                //---- textFieldUsername ----
                textFieldUsername.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                textFieldUsername.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                textFieldUsername.setHorizontalAlignment(SwingConstants.CENTER);
                textFieldUsername.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                textFieldUsername.setText("Pou\u017e\u00edvate\u013esk\u00e9 meno");
                textFieldUsername.setForeground(Color.lightGray);
                textFieldUsername.setFocusable(false);
                textFieldUsername.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        textFieldUsernameFocusGained(e);
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        textFieldUsernameFocusLost();
                    }
                });
                textFieldUsername.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        textFieldUsernameMouseMoved();
                    }
                });
                panelPrihlasenie.add(textFieldUsername, new CellConstraints(1, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 30, 0, 30)));

                //---- textPassword ----
                textPassword.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                textPassword.setHorizontalAlignment(SwingConstants.CENTER);
                textPassword.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                textPassword.setText("Heslo");
                textPassword.setForeground(Color.lightGray);
                textPassword.setCaretPosition(5);
                textPassword.setFocusable(false);
                textPassword.setEchoChar('\u2022');
                textPassword.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        textPasswordMouseMoved();
                    }
                });
                textPassword.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        textPasswordFocusGained();
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        textPasswordFocusLost();
                    }
                });
                panelPrihlasenie.add(textPassword, new CellConstraints(1, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 30, 0, 30)));

                //---- buttonPrihlasit ----
                buttonPrihlasit.setText("Prihl\u00e1si\u0165");
                buttonPrihlasit.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                buttonPrihlasit.setBorder(null);
                buttonPrihlasit.setkStartColor(new Color(73, 196, 174));
                buttonPrihlasit.setkEndColor(new Color(140, 219, 145));
                buttonPrihlasit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                buttonPrihlasit.setkHoverEndColor(new Color(73, 196, 174));
                buttonPrihlasit.setkHoverStartColor(new Color(140, 219, 145));
                buttonPrihlasit.setkHoverForeGround(Color.white);
                buttonPrihlasit.setBackground(Color.white);
                buttonPrihlasit.setBorderPainted(false);
                buttonPrihlasit.setMaximumSize(new Dimension(97, 24));
                buttonPrihlasit.setMinimumSize(new Dimension(97, 24));
                buttonPrihlasit.setkBorderRadius(20);
                buttonPrihlasit.addActionListener(e -> buttonPrihlasitActionPerformed());
                panelPrihlasenie.add(buttonPrihlasit, new CellConstraints(1, 7, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(5, 30, 5, 30)));

                //---- buttonRegistrovat ----
                buttonRegistrovat.setText("Registrova\u0165");
                buttonRegistrovat.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                buttonRegistrovat.setBorder(null);
                buttonRegistrovat.setkStartColor(new Color(255, 161, 117));
                buttonRegistrovat.setkEndColor(new Color(255, 58, 58));
                buttonRegistrovat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                buttonRegistrovat.setkHoverStartColor(new Color(255, 84, 84));
                buttonRegistrovat.setkHoverForeGround(Color.white);
                buttonRegistrovat.setBackground(Color.white);
                buttonRegistrovat.setBorderPainted(false);
                buttonRegistrovat.setMaximumSize(new Dimension(97, 24));
                buttonRegistrovat.setMinimumSize(new Dimension(97, 24));
                buttonRegistrovat.setkBorderRadius(20);
                buttonRegistrovat.setkHoverEndColor(new Color(255, 161, 117));
                buttonRegistrovat.addActionListener(e -> btnRegistrovatActionPerformed());
                panelPrihlasenie.add(buttonRegistrovat, new CellConstraints(1, 9, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(5, 30, 5, 30)));
            }
            myJPanelBackLogin.add(panelPrihlasenie, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- labelWarning ----
            labelWarning.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
            labelWarning.setForeground(Color.red);
            labelWarning.setHorizontalAlignment(SwingConstants.CENTER);
            labelWarning.setVerticalAlignment(SwingConstants.TOP);
            myJPanelBackLogin.add(labelWarning, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
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
    private KGradientPanel panelPrihlasenie;
    private JLabel labeluserIcon;
    private JTextField textFieldUsername;
    private JPasswordField textPassword;
    private KButton buttonPrihlasit;
    private KButton buttonRegistrovat;
    private JLabel labelWarning;
    private KGradientPanel panelStravovaciSystem;
    private JLabel labelStravovaciSystem;
    private JLabel labelX;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
