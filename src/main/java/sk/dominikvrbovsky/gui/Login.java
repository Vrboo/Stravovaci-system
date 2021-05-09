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

    public Login(EntityManager entityManager) {
        this.entityManager = entityManager;
        setPreferredSize(new Dimension(850, 600));
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

    private void label1MouseClicked() {
        entityManager.close();
        System.exit(0);
    }

    private void label1MouseEntered() {
        labelX.setIcon(new ImageIcon(
                "src\\\\main\\\\resources\\\\icons\\\\icons8_x_18px_6.png"));

    }

    private void label1MouseExited() {
        labelX.setIcon(new ImageIcon(
                "src\\\\main\\\\resources\\\\icons\\\\icons8_x_18px.png"));
    }

    private void buttonPrihlasitActionPerformed() {
        String password = String.valueOf(textPassword.getPassword());

        if (textFieldUsername.getText().equals("Používateľské meno") && password.equals("password")) {
            labelWarning.setText("Zadajte meno a heslo.");
        } else if (textFieldUsername.getText().equals("Používateľské meno") && !password.equals("password")) {
            labelWarning.setText("Zadajte používateľské meno.");
        } else if (!textFieldUsername.getText().equals("Používateľské meno") && password.equals("password")) {
            labelWarning.setText("Zadajte heslo.");
        } else if (!textFieldUsername.getText().equals("Používateľské meno") && !password.equals("password")) {

            UserDao userDao = new UserDao(this.entityManager);
            Optional<User> user = userDao.getFromUsername(textFieldUsername.getText());

            if (user.isPresent() && user.get().getPassword().equals(password)) {
                UserInterface userInterface = new UserInterface(entityManager, user.get());
                userInterface.setVisible(true);
                this.dispose();
            } else {
                labelWarning.setText("Zadali ste nesprávne meno alebo heslo.");
            }

        }

        buttonPrihlasit.setSelected(false);
    }

    private void buttonRegistrovatActionPerformed() {
        Registration registration = new Registration(entityManager);
        registration.setVisible(true);
        this.dispose();
    }

    private void labelXMouseClicked() {
        // TODO add your code here
    }

    private void labelXMouseEntered() {
        // TODO add your code here
    }

    private void labelXMouseExited() {
        // TODO add your code here
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
        labelDatum = new JLabel();
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
            myJPanelBackLogin.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
            ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
            .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
            . Color .red ) ,myJPanelBackLogin. getBorder () ) ); myJPanelBackLogin. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
            propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
            ;} } );
            myJPanelBackLogin.setLayout(new GridBagLayout());

            //======== panelPrihlasenie ========
            {
                panelPrihlasenie.setBackground(Color.white);
                panelPrihlasenie.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));
                panelPrihlasenie.setkFillBackground(false);
                panelPrihlasenie.setkEndColor(Color.white);
                panelPrihlasenie.setkStartColor(Color.white);
                panelPrihlasenie.setkBorderRadius(0);

                //---- labeluserIcon ----
                labeluserIcon.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_male_user_100px_1.png")));

                //---- textFieldUsername ----
                textFieldUsername.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                textFieldUsername.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                textFieldUsername.setHorizontalAlignment(SwingConstants.CENTER);
                textFieldUsername.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
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

                //---- textPassword ----
                textPassword.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                textPassword.setHorizontalAlignment(SwingConstants.CENTER);
                textPassword.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
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

                //---- buttonPrihlasit ----
                buttonPrihlasit.setText("Prihl\u00e1si\u0165");
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
                buttonPrihlasit.addActionListener(e -> buttonPrihlasitActionPerformed());

                //---- buttonRegistrovat ----
                buttonRegistrovat.setText("Registrova\u0165");
                buttonRegistrovat.setBackground(Color.white);
                buttonRegistrovat.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                buttonRegistrovat.setkBorderRadius(30);
                buttonRegistrovat.setkStartColor(Color.gray);
                buttonRegistrovat.setkEndColor(Color.lightGray);
                buttonRegistrovat.setkPressedColor(Color.white);
                buttonRegistrovat.setBorder(null);
                buttonRegistrovat.setkIndicatorThickness(0);
                buttonRegistrovat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                buttonRegistrovat.setkAllowTab(true);
                buttonRegistrovat.setkBackGroundColor(Color.lightGray);
                buttonRegistrovat.setkHoverEndColor(Color.gray);
                buttonRegistrovat.setkHoverStartColor(Color.lightGray);
                buttonRegistrovat.setkHoverForeGround(Color.black);
                buttonRegistrovat.setkForeGround(Color.black);
                buttonRegistrovat.setkSelectedColor(Color.darkGray);
                buttonRegistrovat.addActionListener(e -> buttonRegistrovatActionPerformed());

                //---- labelWarning ----
                labelWarning.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
                labelWarning.setForeground(Color.red);
                labelWarning.setHorizontalAlignment(SwingConstants.CENTER);
                labelWarning.setVerticalAlignment(SwingConstants.TOP);

                GroupLayout panelPrihlasenieLayout = new GroupLayout(panelPrihlasenie);
                panelPrihlasenie.setLayout(panelPrihlasenieLayout);
                panelPrihlasenieLayout.setHorizontalGroup(
                    panelPrihlasenieLayout.createParallelGroup()
                        .addGroup(panelPrihlasenieLayout.createSequentialGroup()
                            .addGroup(panelPrihlasenieLayout.createParallelGroup()
                                .addGroup(panelPrihlasenieLayout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addGroup(panelPrihlasenieLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(buttonRegistrovat, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                        .addComponent(buttonPrihlasit, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                        .addComponent(textPassword)
                                        .addComponent(textFieldUsername, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                                .addGroup(panelPrihlasenieLayout.createSequentialGroup()
                                    .addGap(95, 95, 95)
                                    .addComponent(labeluserIcon)))
                            .addContainerGap(30, Short.MAX_VALUE))
                        .addComponent(labelWarning, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                panelPrihlasenieLayout.setVerticalGroup(
                    panelPrihlasenieLayout.createParallelGroup()
                        .addGroup(panelPrihlasenieLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(labeluserIcon)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(textPassword, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(buttonPrihlasit, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonRegistrovat, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                            .addComponent(labelWarning, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                );
            }
            myJPanelBackLogin.add(panelPrihlasenie, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
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
            labelStravovaciSystem.setFont(new Font("Yu Gothic UI", Font.BOLD, 45));
            labelStravovaciSystem.setHorizontalAlignment(SwingConstants.LEFT);
            labelStravovaciSystem.setForeground(new Color(70, 70, 70));

            //---- labelDatum ----
            labelDatum.setText("Utorok, 20. apr\u00edl 2021");
            labelDatum.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
            labelDatum.setForeground(new Color(70, 70, 70));
            labelDatum.setHorizontalAlignment(SwingConstants.LEFT);

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
            label4.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 17));
            label4.setForeground(new Color(70, 70, 70));

            GroupLayout panelStravovaciSystemLayout = new GroupLayout(panelStravovaciSystem);
            panelStravovaciSystem.setLayout(panelStravovaciSystemLayout);
            panelStravovaciSystemLayout.setHorizontalGroup(
                panelStravovaciSystemLayout.createParallelGroup()
                    .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelStravovaciSystemLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(labelDatum, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelStravovaciSystem, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                        .addComponent(labelX, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
            );
            panelStravovaciSystemLayout.setVerticalGroup(
                panelStravovaciSystemLayout.createParallelGroup()
                    .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                        .addComponent(labelX, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelStravovaciSystemLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelStravovaciSystem))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDatum)
                        .addContainerGap(34, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panelStravovaciSystem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myJPanelBackLogin, GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addComponent(panelStravovaciSystem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(myJPanelBackLogin, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
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
    private JLabel labelDatum;
    private JLabel labelX;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
