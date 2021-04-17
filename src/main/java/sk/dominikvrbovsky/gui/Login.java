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
import javax.swing.text.DefaultCaret;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

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
        setPreferredSize(new Dimension(1000, 600));
        initComponents();
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
        if (password.equals("password")) {
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
            textPassword.setForeground(new Color(192,192,192));
            textPassword.setText("password");
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
        UserDao userDao = new UserDao(this.entityManager);
        Optional<User> user = userDao.getFromUsername(textFieldUsername.getText());
        String password = String.valueOf(textPassword.getPassword());

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            UserInterface userInterface = new UserInterface(user.get());
            userInterface.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Nespravne meno alebo heslo");
        }
        //buttonPrihlasit.setSelected(false);
    }

    private void buttonRegistrovatActionPerformed() {
        Registration registration = new Registration();
        registration.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
        myJPanelBackLogin = new KGradientPanel();
        panelPrihlasenie = new KGradientPanel();
        labeluserIcon = new JLabel();
        textFieldUsername = new JTextField();
        textPassword = new JPasswordField();
        buttonPrihlasit = new KButton();
        buttonRegistrovat = new KButton();
        labelX = new JLabel();

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
            myJPanelBackLogin.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
            javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax
            . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
            . awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
            . Color .red ) ,myJPanelBackLogin. getBorder () ) ); myJPanelBackLogin. addPropertyChangeListener( new java. beans .
            PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .
            equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //======== panelPrihlasenie ========
            {
                panelPrihlasenie.setBackground(Color.white);
                panelPrihlasenie.setBorder(null);
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
                textPassword.setText("password");
                textPassword.setForeground(Color.lightGray);
                textPassword.setCaretPosition(8);
                textPassword.setFocusable(false);
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
                            .addContainerGap(29, Short.MAX_VALUE))
                );
            }

            //---- labelX ----
            labelX.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_x_18px.png")));
            labelX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            labelX.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label1MouseClicked();
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    label1MouseEntered();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    label1MouseExited();
                }
            });

            GroupLayout myJPanelBackLoginLayout = new GroupLayout(myJPanelBackLogin);
            myJPanelBackLogin.setLayout(myJPanelBackLoginLayout);
            myJPanelBackLoginLayout.setHorizontalGroup(
                myJPanelBackLoginLayout.createParallelGroup()
                    .addGroup(myJPanelBackLoginLayout.createSequentialGroup()
                        .addContainerGap(229, Short.MAX_VALUE)
                        .addComponent(panelPrihlasenie, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(229, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, myJPanelBackLoginLayout.createSequentialGroup()
                        .addGap(0, 730, Short.MAX_VALUE)
                        .addComponent(labelX))
            );
            myJPanelBackLoginLayout.setVerticalGroup(
                myJPanelBackLoginLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, myJPanelBackLoginLayout.createSequentialGroup()
                        .addComponent(labelX)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(panelPrihlasenie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(55, Short.MAX_VALUE))
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
    private KGradientPanel panelPrihlasenie;
    private JLabel labeluserIcon;
    private JTextField textFieldUsername;
    private JPasswordField textPassword;
    private KButton buttonPrihlasit;
    private KButton buttonRegistrovat;
    private JLabel labelX;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
