/*
 * Created by JFormDesigner on Fri Apr 23 20:16:11 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import java.awt.*;
import java.awt.event.*;
import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import keeptoo.*;
import sk.dominikvrbovsky.User;
import sk.dominikvrbovsky.utilities.DateUtilities;

/**
 * @author Dominik Vrbovsky
 */
public class AdministratorInterface extends JFrame {
    private final EntityManager entityManager;
    private final User user;
    private final CardLayout cardLayout;
    private final CardLayout cardLayoutObjednavky;
    private final CardLayout cardLayoutJedalnyListok;
    
    
    public AdministratorInterface(EntityManager entityManager, User user) {
        this.entityManager = entityManager;
        this.user = user;

        this.setPreferredSize(new Dimension(1000, 600));
        
        initComponents();

        this.cardLayout = (CardLayout)(panelContent.getLayout());
        this.cardLayoutObjednavky = (CardLayout)(panelContentObjednavky.getLayout());
        this.cardLayoutJedalnyListok = (CardLayout)(panelJedalnyListok.getLayout());

        this.labelDatum.setText(DateUtilities.buildSlovakTimeString());

        btnObjednavky.setSelected(true);
        btnObjednavky.setBorder(new MatteBorder(0,5,0,0, new Color(50, 187, 186)));

        btnRanajky.setBorder(new MatteBorder(0, 0, 4, 0, new Color(52, 188, 183)));
        btnRanajky.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnRanajky.isSelected()) {
                    btnRanajky.setBorder(new MatteBorder(0, 0, 4, 0, new Color(52, 188, 183)));
                } else {
                    btnRanajky.setBorder(null);
                }
            }
        });

        btnObed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnObed.isSelected()) {
                    btnObed.setBorder(new MatteBorder(0, 0, 4, 0, new Color(52, 188, 183)));
                } else {
                    btnObed.setBorder(null);
                }
            }
        });
    }

    

    private void btnRanajkyActionPerformed() {
        cardLayoutObjednavky.show(panelContentObjednavky, "ranajky");
    }

    private void btnObedActionPerformed() {
        cardLayoutObjednavky.show(panelContentObjednavky, "obed");
    }

    private void btnObjednavkyActionPerformed() {
        cardLayout.show(panelContent, "objednavky");
    }

    private void btnJedalnyListokActionPerformed() {
        cardLayout.show(panelContent, "jedalnyListok");
    }

    private void labelXMouseClicked() {
        entityManager.close();
        System.exit(0);
    }

    private void labelXMouseEntered() {
        labelX.setIcon(
                new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_x_18px_6.png"));
    }

    private void labelXMouseExited() {
        labelX.setIcon(new
                ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_x_18px.png"));
    }

    private void btnTransakcieActionPerformed() {
        cardLayout.show(panelContent,"transakcie");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
        splitPane1 = new JSplitPane();
        panelMenu = new KGradientPanel();
        labelIcon = new JLabel();
        labelAdministrator = new JLabel();
        btnObjednavky = new KButton();
        btnJedalnyListok = new KButton();
        btnTransakcie = new KButton();
        btnPouzivatel = new KButton();
        panelRightSide = new KGradientPanel();
        splitPane2 = new JSplitPane();
        panelStravovaciSystem = new KGradientPanel();
        labelStravovaciSystem = new JLabel();
        labelDatum = new JLabel();
        labelX = new JLabel();
        label4 = new JLabel();
        panelContent = new KGradientPanel();
        panelObjednavky = new KGradientPanel();
        splitPane3 = new JSplitPane();
        panelMenuObjednavky = new KGradientPanel();
        btnRanajky = new KButton();
        btnObed = new KButton();
        panelContentObjednavky = new KGradientPanel();
        panelObjednavkyRanajky = new KGradientPanel();
        panelTableRanajky = new KGradientPanel();
        label36 = new JLabel();
        label1 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label46 = new JLabel();
        label11 = new JLabel();
        label51 = new JLabel();
        label25 = new JLabel();
        label32 = new JLabel();
        label12 = new JLabel();
        label17 = new JLabel();
        label31 = new JLabel();
        label33 = new JLabel();
        label13 = new JLabel();
        label18 = new JLabel();
        label23 = new JLabel();
        label34 = new JLabel();
        label15 = new JLabel();
        label19 = new JLabel();
        label22 = new JLabel();
        label35 = new JLabel();
        label14 = new JLabel();
        label20 = new JLabel();
        label56 = new JLabel();
        label16 = new JLabel();
        panelObjednavkyObed = new KGradientPanel();
        panelTableObed = new KGradientPanel();
        label38 = new JLabel();
        label21 = new JLabel();
        label24 = new JLabel();
        label39 = new JLabel();
        label47 = new JLabel();
        label42 = new JLabel();
        label52 = new JLabel();
        label43 = new JLabel();
        label45 = new JLabel();
        label48 = new JLabel();
        label49 = new JLabel();
        label50 = new JLabel();
        label54 = new JLabel();
        label55 = new JLabel();
        label57 = new JLabel();
        label58 = new JLabel();
        label60 = new JLabel();
        label61 = new JLabel();
        label62 = new JLabel();
        label63 = new JLabel();
        label65 = new JLabel();
        label66 = new JLabel();
        label67 = new JLabel();
        label68 = new JLabel();
        label70 = new JLabel();
        panelTransakcie = new KGradientPanel();
        panelJedalnyListok = new KGradientPanel();
        panelJedalnyListokRanajky = new KGradientPanel();
        label2 = new JLabel();
        panelJedalnyListokRanajkyInside = new KGradientPanel();
        label40 = new JLabel();
        label3 = new JLabel();
        label28 = new JLabel();
        label29 = new JLabel();
        label30 = new JLabel();
        label59 = new JLabel();
        textField6 = new JTextField();
        comboBox2 = new JComboBox<>();
        textField17 = new JTextField();
        textField18 = new JTextField();
        label44 = new JLabel();
        textField19 = new JTextField();
        comboBox3 = new JComboBox<>();
        textField20 = new JTextField();
        textField21 = new JTextField();
        label73 = new JLabel();
        textField22 = new JTextField();
        comboBox4 = new JComboBox<>();
        textField23 = new JTextField();
        textField24 = new JTextField();
        label78 = new JLabel();
        textField25 = new JTextField();
        comboBox5 = new JComboBox<>();
        textField26 = new JTextField();
        textField27 = new JTextField();
        label83 = new JLabel();
        textField28 = new JTextField();
        comboBox6 = new JComboBox<>();
        textField29 = new JTextField();
        textField30 = new JTextField();
        kButton3 = new KButton();
        panelJedalnyListokObed = new KGradientPanel();
        panelJedalnyListokObedInside = new KGradientPanel();
        label41 = new JLabel();
        label5 = new JLabel();
        label37 = new JLabel();
        label53 = new JLabel();
        label64 = new JLabel();
        label69 = new JLabel();
        textField7 = new JTextField();
        comboBox7 = new JComboBox<>();
        textField31 = new JTextField();
        textField32 = new JTextField();
        label71 = new JLabel();
        textField33 = new JTextField();
        comboBox8 = new JComboBox<>();
        textField34 = new JTextField();
        textField35 = new JTextField();
        label74 = new JLabel();
        textField36 = new JTextField();
        comboBox9 = new JComboBox<>();
        textField37 = new JTextField();
        textField38 = new JTextField();
        label79 = new JLabel();
        textField39 = new JTextField();
        comboBox10 = new JComboBox<>();
        textField40 = new JTextField();
        textField41 = new JTextField();
        label84 = new JLabel();
        textField42 = new JTextField();
        comboBox11 = new JComboBox<>();
        textField43 = new JTextField();
        textField44 = new JTextField();
        label89 = new JLabel();
        panelJedalnyListokVytvorit = new KGradientPanel();
        panelJedalnyListokInside = new KGradientPanel();
        labelJedalnyListokVytvoritInisde = new JLabel();
        btnJedalnyListokVytvoritInside = new KButton();

        //======== this ========
        setUndecorated(true);
        var contentPane = getContentPane();

        //======== splitPane1 ========
        {
            splitPane1.setDividerSize(0);
            splitPane1.setBorder(null);
            splitPane1.setDividerLocation(225);

            //======== panelMenu ========
            {
                panelMenu.setBorder(null);
                panelMenu.setkBorderRadius(0);
                panelMenu.setkStartColor(new Color(55, 55, 55));
                panelMenu.setkEndColor(new Color(55, 55, 55));
                panelMenu.setBackground(new Color(55, 55, 55));
                panelMenu.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
                new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion"
                , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
                , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 )
                , java. awt. Color. red) ,panelMenu. getBorder( )) ); panelMenu. addPropertyChangeListener (
                new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
                ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
                ; }} );

                //---- labelIcon ----
                labelIcon.setHorizontalAlignment(SwingConstants.CENTER);
                labelIcon.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_user_shield_85px_5.png"));

                //---- labelAdministrator ----
                labelAdministrator.setHorizontalAlignment(SwingConstants.CENTER);
                labelAdministrator.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                labelAdministrator.setForeground(new Color(50, 187, 186));
                labelAdministrator.setText("Administr\u00e1tor");

                //---- btnObjednavky ----
                btnObjednavky.setText("Po\u010det objedn\u00e1vok");
                btnObjednavky.setkBorderRadius(0);
                btnObjednavky.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnObjednavky.setkEndColor(new Color(55, 55, 55));
                btnObjednavky.setkStartColor(new Color(55, 55, 55));
                btnObjednavky.setBorder(null);
                btnObjednavky.setkHoverEndColor(Color.gray);
                btnObjednavky.setkHoverStartColor(new Color(55, 55, 55));
                btnObjednavky.setkHoverForeGround(Color.white);
                btnObjednavky.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnObjednavky.setkAllowTab(true);
                btnObjednavky.setkSelectedColor(new Color(67, 67, 67));
                btnObjednavky.setkIndicatorColor(new Color(50, 187, 186));
                btnObjednavky.setkIndicatorThickness(5);
                btnObjednavky.addActionListener(e -> btnObjednavkyActionPerformed());

                //---- btnJedalnyListok ----
                btnJedalnyListok.setText("Nov\u00fd jed\u00e1lny l\u00edstok");
                btnJedalnyListok.setkBorderRadius(0);
                btnJedalnyListok.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnJedalnyListok.setkEndColor(new Color(55, 55, 55));
                btnJedalnyListok.setkStartColor(new Color(55, 55, 55));
                btnJedalnyListok.setBorder(null);
                btnJedalnyListok.setkHoverEndColor(Color.gray);
                btnJedalnyListok.setkHoverStartColor(new Color(55, 55, 55));
                btnJedalnyListok.setkHoverForeGround(Color.white);
                btnJedalnyListok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnJedalnyListok.setkAllowTab(true);
                btnJedalnyListok.setkSelectedColor(new Color(67, 67, 67));
                btnJedalnyListok.setkIndicatorColor(new Color(50, 187, 186));
                btnJedalnyListok.setkIndicatorThickness(5);
                btnJedalnyListok.addActionListener(e -> btnJedalnyListokActionPerformed());

                //---- btnTransakcie ----
                btnTransakcie.setText("Transakcie");
                btnTransakcie.setkBorderRadius(0);
                btnTransakcie.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnTransakcie.setkEndColor(new Color(55, 55, 55));
                btnTransakcie.setkStartColor(new Color(55, 55, 55));
                btnTransakcie.setBorder(null);
                btnTransakcie.setkHoverEndColor(Color.gray);
                btnTransakcie.setkHoverStartColor(new Color(55, 55, 55));
                btnTransakcie.setkHoverForeGround(Color.white);
                btnTransakcie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnTransakcie.setkAllowTab(true);
                btnTransakcie.setkSelectedColor(new Color(67, 67, 67));
                btnTransakcie.setkIndicatorColor(new Color(50, 187, 186));
                btnTransakcie.setkIndicatorThickness(5);
                btnTransakcie.addActionListener(e -> btnTransakcieActionPerformed());

                //---- btnPouzivatel ----
                btnPouzivatel.setText("Pou\u017e\u00edvate\u013e");
                btnPouzivatel.setkBorderRadius(0);
                btnPouzivatel.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnPouzivatel.setkEndColor(new Color(55, 55, 55));
                btnPouzivatel.setkStartColor(new Color(55, 55, 55));
                btnPouzivatel.setBorder(null);
                btnPouzivatel.setkHoverEndColor(Color.gray);
                btnPouzivatel.setkHoverStartColor(new Color(55, 55, 55));
                btnPouzivatel.setkForeGround(Color.lightGray);
                btnPouzivatel.setkIndicatorThickness(5);
                btnPouzivatel.setkHoverForeGround(Color.red);
                btnPouzivatel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnPouzivatel.setkSelectedColor(new Color(67, 67, 67));
                btnPouzivatel.setkAllowTab(true);
                btnPouzivatel.setkIndicatorColor(new Color(50, 187, 186));

                GroupLayout panelMenuLayout = new GroupLayout(panelMenu);
                panelMenu.setLayout(panelMenuLayout);
                panelMenuLayout.setHorizontalGroup(
                    panelMenuLayout.createParallelGroup()
                        .addGroup(panelMenuLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelMenuLayout.createParallelGroup()
                                .addComponent(labelIcon, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelAdministrator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnTransakcie, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                .addComponent(btnObjednavky, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                .addComponent(btnJedalnyListok, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                .addComponent(btnPouzivatel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
                );
                panelMenuLayout.setVerticalGroup(
                    panelMenuLayout.createParallelGroup()
                        .addGroup(panelMenuLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(labelIcon)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelAdministrator)
                            .addGap(44, 44, 44)
                            .addComponent(btnJedalnyListok, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnObjednavky, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnTransakcie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                            .addComponent(btnPouzivatel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38))
                );
            }
            splitPane1.setLeftComponent(panelMenu);

            //======== panelRightSide ========
            {
                panelRightSide.setkEndColor(new Color(192, 248, 213));
                panelRightSide.setkStartColor(new Color(115, 224, 255));
                panelRightSide.setkBorderRadius(0);

                //======== splitPane2 ========
                {
                    splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
                    splitPane2.setBorder(null);
                    splitPane2.setDividerSize(0);
                    splitPane2.setDividerLocation(155);

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
                                    .addGap(32, 32, 32)
                                    .addGroup(panelStravovaciSystemLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelDatum, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelStravovaciSystem, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelStravovaciSystemLayout.createParallelGroup()
                                        .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                            .addGap(0, 362, Short.MAX_VALUE)
                                            .addComponent(labelX, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 155, Short.MAX_VALUE))))
                        );
                        panelStravovaciSystemLayout.setVerticalGroup(
                            panelStravovaciSystemLayout.createParallelGroup()
                                .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                    .addComponent(labelX, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                    .addContainerGap(19, Short.MAX_VALUE)
                                    .addGroup(panelStravovaciSystemLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelStravovaciSystem)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(labelDatum, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38))
                        );
                    }
                    splitPane2.setTopComponent(panelStravovaciSystem);

                    //======== panelContent ========
                    {
                        panelContent.setLayout(new CardLayout());

                        //======== panelObjednavky ========
                        {
                            panelObjednavky.setkEndColor(Color.white);
                            panelObjednavky.setkStartColor(Color.white);

                            //======== splitPane3 ========
                            {
                                splitPane3.setBorder(null);
                                splitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);
                                splitPane3.setDividerSize(0);
                                splitPane3.setDividerLocation(40);
                                splitPane3.setBackground(new Color(55, 55, 55));

                                //======== panelMenuObjednavky ========
                                {
                                    panelMenuObjednavky.setkStartColor(new Color(55, 55, 55));
                                    panelMenuObjednavky.setkEndColor(new Color(55, 55, 55));
                                    panelMenuObjednavky.setkBorderRadius(0);
                                    panelMenuObjednavky.setBackground(new Color(55, 55, 55));
                                    panelMenuObjednavky.setkGradientFocus(700);
                                    panelMenuObjednavky.setForeground(new Color(55, 55, 55));
                                    panelMenuObjednavky.setBorder(null);
                                    panelMenuObjednavky.setLayout(new FormLayout(
                                        "default, $lcgap, default",
                                        "fill:default"));

                                    //---- btnRanajky ----
                                    btnRanajky.setText("Ranajky");
                                    btnRanajky.setBorder(null);
                                    btnRanajky.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                    btnRanajky.setkStartColor(Color.darkGray);
                                    btnRanajky.setkEndColor(Color.darkGray);
                                    btnRanajky.setkBorderRadius(0);
                                    btnRanajky.setkAllowTab(true);
                                    btnRanajky.setkHoverEndColor(new Color(70, 70, 70));
                                    btnRanajky.setkHoverStartColor(new Color(70, 70, 70));
                                    btnRanajky.setkIndicatorColor(new Color(38, 184, 190));
                                    btnRanajky.setkIndicatorThickness(0);
                                    btnRanajky.setkBackGroundColor(Color.white);
                                    btnRanajky.setkSelectedColor(new Color(67, 67, 67));
                                    btnRanajky.setkHoverForeGround(Color.white);
                                    btnRanajky.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                    btnRanajky.setVerticalAlignment(SwingConstants.TOP);
                                    btnRanajky.addActionListener(e -> {
			btnRanajkyActionPerformed();
			btnRanajkyActionPerformed();
		});
                                    panelMenuObjednavky.add(btnRanajky, CC.xy(1, 1));

                                    //---- btnObed ----
                                    btnObed.setText("Obed");
                                    btnObed.setBorder(null);
                                    btnObed.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                    btnObed.setkStartColor(Color.darkGray);
                                    btnObed.setkEndColor(Color.darkGray);
                                    btnObed.setkBorderRadius(0);
                                    btnObed.setkAllowTab(true);
                                    btnObed.setkHoverEndColor(new Color(70, 70, 70));
                                    btnObed.setkHoverStartColor(new Color(70, 70, 70));
                                    btnObed.setkIndicatorColor(new Color(38, 184, 190));
                                    btnObed.setkIndicatorThickness(0);
                                    btnObed.setkBackGroundColor(Color.white);
                                    btnObed.setkSelectedColor(new Color(67, 67, 67));
                                    btnObed.setkHoverForeGround(Color.white);
                                    btnObed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                    btnObed.setVerticalAlignment(SwingConstants.TOP);
                                    btnObed.addActionListener(e -> btnObedActionPerformed());
                                    panelMenuObjednavky.add(btnObed, CC.xy(3, 1));
                                }
                                splitPane3.setTopComponent(panelMenuObjednavky);

                                //======== panelContentObjednavky ========
                                {
                                    panelContentObjednavky.setBackground(new Color(55, 55, 55));
                                    panelContentObjednavky.setLayout(new CardLayout());

                                    //======== panelObjednavkyRanajky ========
                                    {
                                        panelObjednavkyRanajky.setkEndColor(new Color(38, 184, 190, 24));
                                        panelObjednavkyRanajky.setkStartColor(new Color(38, 184, 190, 24));
                                        panelObjednavkyRanajky.setkBorderRadius(0);
                                        panelObjednavkyRanajky.setkGradientFocus(600);
                                        panelObjednavkyRanajky.setBorder(null);
                                        panelObjednavkyRanajky.setBackground(Color.white);
                                        panelObjednavkyRanajky.setkFillBackground(false);
                                        panelObjednavkyRanajky.setLayout(new GridBagLayout());

                                        //======== panelTableRanajky ========
                                        {
                                            panelTableRanajky.setkEndColor(Color.white);
                                            panelTableRanajky.setkStartColor(Color.white);
                                            panelTableRanajky.setBorder(null);
                                            panelTableRanajky.setkBorderRadius(0);
                                            panelTableRanajky.setBackground(new Color(255, 255, 255, 145));
                                            panelTableRanajky.setLayout(new FormLayout(
                                                "27px, 306px, 134px, 200px",
                                                "fill:49px, 5*(fill:52px), $lgap, 11dlu"));

                                            //---- label36 ----
                                            label36.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label36, CC.xy(1, 1));

                                            //---- label1 ----
                                            label1.setText("Ra\u0148ajky");
                                            label1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label1.setHorizontalAlignment(SwingConstants.CENTER);
                                            label1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label1, CC.xy(2, 1));

                                            //---- label8 ----
                                            label8.setText("N\u00e1poj");
                                            label8.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label8.setHorizontalAlignment(SwingConstants.CENTER);
                                            label8.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label8, CC.xy(3, 1));

                                            //---- label9 ----
                                            label9.setText("Po\u010det objedn\u00e1vok");
                                            label9.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label9.setHorizontalAlignment(SwingConstants.CENTER);
                                            label9.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            label9.setBackground(Color.white);
                                            panelTableRanajky.add(label9, CC.xy(4, 1));

                                            //---- label46 ----
                                            label46.setText("1.");
                                            label46.setHorizontalAlignment(SwingConstants.CENTER);
                                            label46.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label46.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label46, CC.xy(1, 2));

                                            //---- label11 ----
                                            label11.setText("Parky s hor\u010dicou a chlebom");
                                            label11.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label11.setHorizontalAlignment(SwingConstants.CENTER);
                                            label11.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label11, CC.xy(2, 2));

                                            //---- label51 ----
                                            label51.setText("Miner\u00e1lna voda");
                                            label51.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label51.setHorizontalAlignment(SwingConstants.CENTER);
                                            label51.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label51, CC.xy(3, 2));

                                            //---- label25 ----
                                            label25.setText("78x");
                                            label25.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label25.setHorizontalAlignment(SwingConstants.CENTER);
                                            label25.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label25, CC.xy(4, 2));

                                            //---- label32 ----
                                            label32.setText("2.");
                                            label32.setHorizontalAlignment(SwingConstants.CENTER);
                                            label32.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label32.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label32, CC.xy(1, 3));

                                            //---- label12 ----
                                            label12.setText("Pra\u017eenica s ro\u017ekom");
                                            label12.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label12.setHorizontalAlignment(SwingConstants.CENTER);
                                            label12.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label12, CC.xy(2, 3));

                                            //---- label17 ----
                                            label17.setText("Cola");
                                            label17.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label17.setHorizontalAlignment(SwingConstants.CENTER);
                                            label17.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label17, CC.xy(3, 3));

                                            //---- label31 ----
                                            label31.setText("45x");
                                            label31.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label31.setHorizontalAlignment(SwingConstants.CENTER);
                                            label31.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label31, CC.xy(4, 3));

                                            //---- label33 ----
                                            label33.setText("3.");
                                            label33.setHorizontalAlignment(SwingConstants.CENTER);
                                            label33.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label33.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label33, CC.xy(1, 4));

                                            //---- label13 ----
                                            label13.setText("Lievance s lekv\u00e1rom");
                                            label13.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label13.setHorizontalAlignment(SwingConstants.CENTER);
                                            label13.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label13, CC.xy(2, 4));

                                            //---- label18 ----
                                            label18.setText("\u010caj");
                                            label18.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label18.setHorizontalAlignment(SwingConstants.CENTER);
                                            label18.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label18, CC.xy(3, 4));

                                            //---- label23 ----
                                            label23.setText("78x");
                                            label23.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label23.setHorizontalAlignment(SwingConstants.CENTER);
                                            label23.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label23, CC.xy(4, 4));

                                            //---- label34 ----
                                            label34.setText("4.");
                                            label34.setHorizontalAlignment(SwingConstants.CENTER);
                                            label34.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label34.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label34, CC.xy(1, 5));

                                            //---- label15 ----
                                            label15.setText("Volsk\u00e9 oko s ke\u010dup a chlebom");
                                            label15.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label15.setHorizontalAlignment(SwingConstants.CENTER);
                                            label15.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label15, CC.xy(2, 5));

                                            //---- label19 ----
                                            label19.setText("Miner\u00e1lna voda");
                                            label19.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label19.setHorizontalAlignment(SwingConstants.CENTER);
                                            label19.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label19, CC.xy(3, 5));

                                            //---- label22 ----
                                            label22.setText("123x");
                                            label22.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label22.setHorizontalAlignment(SwingConstants.CENTER);
                                            label22.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label22, CC.xy(4, 5));

                                            //---- label35 ----
                                            label35.setText("5.");
                                            label35.setHorizontalAlignment(SwingConstants.CENTER);
                                            label35.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label35.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label35, CC.xy(1, 6));

                                            //---- label14 ----
                                            label14.setText("\u0160unkov\u00e1 bageta");
                                            label14.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label14.setHorizontalAlignment(SwingConstants.CENTER);
                                            label14.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label14, CC.xy(2, 6));

                                            //---- label20 ----
                                            label20.setText("\u010e\u017e\u00fas");
                                            label20.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label20.setHorizontalAlignment(SwingConstants.CENTER);
                                            label20.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label20, CC.xy(3, 6));

                                            //---- label56 ----
                                            label56.setText("63x");
                                            label56.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label56.setHorizontalAlignment(SwingConstants.CENTER);
                                            label56.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label56, CC.xy(4, 6));
                                            panelTableRanajky.add(label16, CC.xy(1, 8));
                                        }
                                        panelObjednavkyRanajky.add(panelTableRanajky, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelContentObjednavky.add(panelObjednavkyRanajky, "ranajky");

                                    //======== panelObjednavkyObed ========
                                    {
                                        panelObjednavkyObed.setkBorderRadius(0);
                                        panelObjednavkyObed.setkEndColor(Color.white);
                                        panelObjednavkyObed.setkStartColor(Color.white);
                                        panelObjednavkyObed.setLayout(new GridBagLayout());

                                        //======== panelTableObed ========
                                        {
                                            panelTableObed.setkEndColor(Color.white);
                                            panelTableObed.setkStartColor(Color.white);
                                            panelTableObed.setBorder(null);
                                            panelTableObed.setkBorderRadius(0);
                                            panelTableObed.setBackground(new Color(255, 255, 255, 145));
                                            panelTableObed.setLayout(new FormLayout(
                                                "27px, 306px, 134px, 200px",
                                                "fill:49px, 5*(fill:52px), $lgap, 11dlu"));

                                            //---- label38 ----
                                            label38.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label38, CC.xy(1, 1));

                                            //---- label21 ----
                                            label21.setText("Obed");
                                            label21.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label21.setHorizontalAlignment(SwingConstants.CENTER);
                                            label21.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label21, CC.xy(2, 1));

                                            //---- label24 ----
                                            label24.setText("Takeaway");
                                            label24.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label24.setHorizontalAlignment(SwingConstants.CENTER);
                                            label24.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label24, CC.xy(3, 1));

                                            //---- label39 ----
                                            label39.setText("Po\u010det objedn\u00e1vok ");
                                            label39.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label39.setHorizontalAlignment(SwingConstants.CENTER);
                                            label39.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            label39.setBackground(Color.white);
                                            panelTableObed.add(label39, CC.xy(4, 1));

                                            //---- label47 ----
                                            label47.setText("1.");
                                            label47.setHorizontalAlignment(SwingConstants.CENTER);
                                            label47.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label47.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label47, CC.xy(1, 2));

                                            //---- label42 ----
                                            label42.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label42.setHorizontalAlignment(SwingConstants.CENTER);
                                            label42.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            label42.setText("Kurac\u00ed reze\u0148 + zemiakov\u00e1 ka\u0161a");
                                            panelTableObed.add(label42, CC.xy(2, 2));

                                            //---- label52 ----
                                            label52.setText("\u00c1no");
                                            label52.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label52.setHorizontalAlignment(SwingConstants.CENTER);
                                            label52.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label52, CC.xy(3, 2));

                                            //---- label43 ----
                                            label43.setText("78x");
                                            label43.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label43.setHorizontalAlignment(SwingConstants.CENTER);
                                            label43.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label43, CC.xy(4, 2));

                                            //---- label45 ----
                                            label45.setText("2.");
                                            label45.setHorizontalAlignment(SwingConstants.CENTER);
                                            label45.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label45.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label45, CC.xy(1, 3));

                                            //---- label48 ----
                                            label48.setText("Bryndzov\u00e9 halu\u0161ky");
                                            label48.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label48.setHorizontalAlignment(SwingConstants.CENTER);
                                            label48.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label48, CC.xy(2, 3));

                                            //---- label49 ----
                                            label49.setText("Nie");
                                            label49.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label49.setHorizontalAlignment(SwingConstants.CENTER);
                                            label49.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label49, CC.xy(3, 3));

                                            //---- label50 ----
                                            label50.setText("417x");
                                            label50.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label50.setHorizontalAlignment(SwingConstants.CENTER);
                                            label50.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label50, CC.xy(4, 3));

                                            //---- label54 ----
                                            label54.setText("3.");
                                            label54.setHorizontalAlignment(SwingConstants.CENTER);
                                            label54.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label54.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label54, CC.xy(1, 4));

                                            //---- label55 ----
                                            label55.setText("Palacinky s lekv\u00e1rom");
                                            label55.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label55.setHorizontalAlignment(SwingConstants.CENTER);
                                            label55.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label55, CC.xy(2, 4));

                                            //---- label57 ----
                                            label57.setText("\u00c1no");
                                            label57.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label57.setHorizontalAlignment(SwingConstants.CENTER);
                                            label57.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label57, CC.xy(3, 4));

                                            //---- label58 ----
                                            label58.setText("29x");
                                            label58.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label58.setHorizontalAlignment(SwingConstants.CENTER);
                                            label58.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label58, CC.xy(4, 4));

                                            //---- label60 ----
                                            label60.setText("4.");
                                            label60.setHorizontalAlignment(SwingConstants.CENTER);
                                            label60.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label60.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label60, CC.xy(1, 5));

                                            //---- label61 ----
                                            label61.setText("Pizza Hawai");
                                            label61.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label61.setHorizontalAlignment(SwingConstants.CENTER);
                                            label61.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label61, CC.xy(2, 5));

                                            //---- label62 ----
                                            label62.setText("\u00c1no");
                                            label62.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label62.setHorizontalAlignment(SwingConstants.CENTER);
                                            label62.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label62, CC.xy(3, 5));

                                            //---- label63 ----
                                            label63.setText("75x");
                                            label63.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label63.setHorizontalAlignment(SwingConstants.CENTER);
                                            label63.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label63, CC.xy(4, 5));

                                            //---- label65 ----
                                            label65.setText("5.");
                                            label65.setHorizontalAlignment(SwingConstants.CENTER);
                                            label65.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label65.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label65, CC.xy(1, 6));

                                            //---- label66 ----
                                            label66.setText("\u0160unkov\u00e1 bageta");
                                            label66.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label66.setHorizontalAlignment(SwingConstants.CENTER);
                                            label66.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label66, CC.xy(2, 6));

                                            //---- label67 ----
                                            label67.setText("Nie");
                                            label67.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label67.setHorizontalAlignment(SwingConstants.CENTER);
                                            label67.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label67, CC.xy(3, 6));

                                            //---- label68 ----
                                            label68.setText("0x");
                                            label68.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label68.setHorizontalAlignment(SwingConstants.CENTER);
                                            label68.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label68, CC.xy(4, 6));
                                            panelTableObed.add(label70, CC.xy(1, 8));
                                        }
                                        panelObjednavkyObed.add(panelTableObed, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelContentObjednavky.add(panelObjednavkyObed, "obed");
                                }
                                splitPane3.setBottomComponent(panelContentObjednavky);
                            }

                            GroupLayout panelObjednavkyLayout = new GroupLayout(panelObjednavky);
                            panelObjednavky.setLayout(panelObjednavkyLayout);
                            panelObjednavkyLayout.setHorizontalGroup(
                                panelObjednavkyLayout.createParallelGroup()
                                    .addComponent(splitPane3)
                            );
                            panelObjednavkyLayout.setVerticalGroup(
                                panelObjednavkyLayout.createParallelGroup()
                                    .addComponent(splitPane3, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                            );
                        }
                        panelContent.add(panelObjednavky, "objednavky");

                        //======== panelTransakcie ========
                        {
                            panelTransakcie.setkEndColor(Color.white);
                            panelTransakcie.setkStartColor(Color.white);
                            panelTransakcie.setLayout(new GridBagLayout());
                        }
                        panelContent.add(panelTransakcie, "transakcie");

                        //======== panelJedalnyListok ========
                        {
                            panelJedalnyListok.setBackground(new Color(55, 55, 55));
                            panelJedalnyListok.setLayout(new CardLayout());

                            //======== panelJedalnyListokRanajky ========
                            {
                                panelJedalnyListokRanajky.setkEndColor(Color.white);
                                panelJedalnyListokRanajky.setkStartColor(Color.white);
                                panelJedalnyListokRanajky.setkBorderRadius(0);
                                panelJedalnyListokRanajky.setkGradientFocus(600);
                                panelJedalnyListokRanajky.setBorder(null);
                                panelJedalnyListokRanajky.setBackground(Color.white);
                                panelJedalnyListokRanajky.setkFillBackground(false);
                                panelJedalnyListokRanajky.setLayout(new GridBagLayout());
                                ((GridBagLayout)panelJedalnyListokRanajky.getLayout()).rowHeights = new int[] {33, 6, 0, 6, 36};

                                //---- label2 ----
                                label2.setText("Vytvorte ranajkov\u00e9 menu");
                                label2.setHorizontalAlignment(SwingConstants.CENTER);
                                label2.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                panelJedalnyListokRanajky.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                    new Insets(0, 0, 0, 0), 0, 0));

                                //======== panelJedalnyListokRanajkyInside ========
                                {
                                    panelJedalnyListokRanajkyInside.setkEndColor(Color.white);
                                    panelJedalnyListokRanajkyInside.setkStartColor(Color.white);
                                    panelJedalnyListokRanajkyInside.setBorder(null);
                                    panelJedalnyListokRanajkyInside.setkBorderRadius(0);
                                    panelJedalnyListokRanajkyInside.setBackground(new Color(255, 255, 255, 145));
                                    panelJedalnyListokRanajkyInside.setLayout(new FormLayout(
                                        "27px, 312px, 126px, 90px, 89px",
                                        "fill:49px, 5*(fill:52px)"));

                                    //---- label40 ----
                                    label40.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label40, CC.xy(1, 1));

                                    //---- label3 ----
                                    label3.setText("Ra\u0148ajky");
                                    label3.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label3.setHorizontalAlignment(SwingConstants.CENTER);
                                    label3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label3, CC.xy(2, 1));

                                    //---- label28 ----
                                    label28.setText("N\u00e1poj");
                                    label28.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label28.setHorizontalAlignment(SwingConstants.CENTER);
                                    label28.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label28, CC.xy(3, 1));

                                    //---- label29 ----
                                    label29.setText("Kapacita");
                                    label29.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label29.setHorizontalAlignment(SwingConstants.CENTER);
                                    label29.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    label29.setBackground(Color.white);
                                    panelJedalnyListokRanajkyInside.add(label29, CC.xy(4, 1));

                                    //---- label30 ----
                                    label30.setText("Cena");
                                    label30.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label30.setHorizontalAlignment(SwingConstants.CENTER);
                                    label30.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label30, CC.xy(5, 1));

                                    //---- label59 ----
                                    label59.setText("1.");
                                    label59.setHorizontalAlignment(SwingConstants.CENTER);
                                    label59.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label59.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label59, CC.xy(1, 2));

                                    //---- textField6 ----
                                    textField6.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField6.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField6.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField6, CC.xy(2, 2));

                                    //---- comboBox2 ----
                                    comboBox2.setBorder(null);
                                    comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "Cola",
                                        "Min. voda",
                                        "\u010caj",
                                        "D\u017e\u00fas"
                                    }));
                                    comboBox2.setBackground(Color.lightGray);
                                    comboBox2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox2.setSelectedIndex(-1);
                                    panelJedalnyListokRanajkyInside.add(comboBox2, new CellConstraints(3, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- textField17 ----
                                    textField17.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField17.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField17.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField17, CC.xy(4, 2));

                                    //---- textField18 ----
                                    textField18.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField18.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField18.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField18, CC.xy(5, 2));

                                    //---- label44 ----
                                    label44.setText("2.");
                                    label44.setHorizontalAlignment(SwingConstants.CENTER);
                                    label44.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label44.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label44, CC.xy(1, 3));

                                    //---- textField19 ----
                                    textField19.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField19.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField19.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField19, CC.xy(2, 3));

                                    //---- comboBox3 ----
                                    comboBox3.setBorder(null);
                                    comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "Cola",
                                        "Min. voda",
                                        "\u010caj",
                                        "D\u017e\u00fas"
                                    }));
                                    comboBox3.setBackground(Color.lightGray);
                                    comboBox3.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox3.setSelectedIndex(-1);
                                    panelJedalnyListokRanajkyInside.add(comboBox3, new CellConstraints(3, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- textField20 ----
                                    textField20.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField20.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField20.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField20, CC.xy(4, 3));

                                    //---- textField21 ----
                                    textField21.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField21.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField21.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField21, CC.xy(5, 3));

                                    //---- label73 ----
                                    label73.setText("3.");
                                    label73.setHorizontalAlignment(SwingConstants.CENTER);
                                    label73.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label73.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label73, CC.xy(1, 4));

                                    //---- textField22 ----
                                    textField22.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField22.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField22.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField22, CC.xy(2, 4));

                                    //---- comboBox4 ----
                                    comboBox4.setBorder(null);
                                    comboBox4.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "Cola",
                                        "Min. voda",
                                        "\u010caj",
                                        "D\u017e\u00fas"
                                    }));
                                    comboBox4.setBackground(Color.lightGray);
                                    comboBox4.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox4.setSelectedIndex(-1);
                                    panelJedalnyListokRanajkyInside.add(comboBox4, new CellConstraints(3, 4, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- textField23 ----
                                    textField23.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField23.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField23.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField23, CC.xy(4, 4));

                                    //---- textField24 ----
                                    textField24.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField24.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField24.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField24, CC.xy(5, 4));

                                    //---- label78 ----
                                    label78.setText("4.");
                                    label78.setHorizontalAlignment(SwingConstants.CENTER);
                                    label78.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label78.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label78, CC.xy(1, 5));

                                    //---- textField25 ----
                                    textField25.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField25.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField25.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField25, CC.xy(2, 5));

                                    //---- comboBox5 ----
                                    comboBox5.setBorder(null);
                                    comboBox5.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "Cola",
                                        "Min. voda",
                                        "\u010caj",
                                        "D\u017e\u00fas"
                                    }));
                                    comboBox5.setBackground(Color.lightGray);
                                    comboBox5.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox5.setSelectedIndex(-1);
                                    panelJedalnyListokRanajkyInside.add(comboBox5, new CellConstraints(3, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- textField26 ----
                                    textField26.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField26.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField26.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField26, CC.xy(4, 5));

                                    //---- textField27 ----
                                    textField27.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField27.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField27.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField27, CC.xy(5, 5));

                                    //---- label83 ----
                                    label83.setText("5.");
                                    label83.setHorizontalAlignment(SwingConstants.CENTER);
                                    label83.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label83.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokRanajkyInside.add(label83, CC.xy(1, 6));

                                    //---- textField28 ----
                                    textField28.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField28.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField28.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField28, CC.xy(2, 6));

                                    //---- comboBox6 ----
                                    comboBox6.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
                                    comboBox6.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "Cola",
                                        "Min. voda",
                                        "\u010caj",
                                        "D\u017e\u00fas"
                                    }));
                                    comboBox6.setBackground(Color.lightGray);
                                    comboBox6.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox6.setSelectedIndex(-1);
                                    panelJedalnyListokRanajkyInside.add(comboBox6, new CellConstraints(3, 6, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- textField29 ----
                                    textField29.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField29.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField29.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField29, CC.xy(4, 6));

                                    //---- textField30 ----
                                    textField30.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField30.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField30.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokRanajkyInside.add(textField30, CC.xy(5, 6));
                                }
                                panelJedalnyListokRanajky.add(panelJedalnyListokRanajkyInside, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                    new Insets(0, 0, 0, 0), 0, 0));

                                //---- kButton3 ----
                                kButton3.setText("Pokra\u010dova\u0165");
                                kButton3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                kButton3.setBorder(null);
                                kButton3.setkStartColor(new Color(73, 196, 174));
                                kButton3.setkEndColor(new Color(140, 219, 145));
                                kButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                kButton3.setkHoverEndColor(new Color(73, 196, 174));
                                kButton3.setkHoverStartColor(new Color(52, 188, 183));
                                kButton3.setkHoverForeGround(Color.white);
                                kButton3.setBackground(Color.white);
                                kButton3.setBorderPainted(false);
                                panelJedalnyListokRanajky.add(kButton3, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE,
                                    new Insets(0, 0, 0, 0), -50, -15));
                            }
                            panelJedalnyListok.add(panelJedalnyListokRanajky, "ranajky");

                            //======== panelJedalnyListokObed ========
                            {
                                panelJedalnyListokObed.setkBorderRadius(0);
                                panelJedalnyListokObed.setkEndColor(Color.white);
                                panelJedalnyListokObed.setkStartColor(Color.white);
                                panelJedalnyListokObed.setLayout(new GridBagLayout());

                                //======== panelJedalnyListokObedInside ========
                                {
                                    panelJedalnyListokObedInside.setkEndColor(Color.white);
                                    panelJedalnyListokObedInside.setkStartColor(Color.white);
                                    panelJedalnyListokObedInside.setBorder(null);
                                    panelJedalnyListokObedInside.setkBorderRadius(0);
                                    panelJedalnyListokObedInside.setBackground(new Color(255, 255, 255, 145));
                                    panelJedalnyListokObedInside.setLayout(new FormLayout(
                                        "27px, 312px, 126px, 90px, 89px",
                                        "fill:49px, 5*(fill:52px), $lgap, 11dlu"));

                                    //---- label41 ----
                                    label41.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label41, CC.xy(1, 1));

                                    //---- label5 ----
                                    label5.setText("Obed");
                                    label5.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label5.setHorizontalAlignment(SwingConstants.CENTER);
                                    label5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label5, CC.xy(2, 1));

                                    //---- label37 ----
                                    label37.setText("Takeaway");
                                    label37.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label37.setHorizontalAlignment(SwingConstants.CENTER);
                                    label37.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label37, CC.xy(3, 1));

                                    //---- label53 ----
                                    label53.setText("Kapacita");
                                    label53.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label53.setHorizontalAlignment(SwingConstants.CENTER);
                                    label53.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    label53.setBackground(Color.white);
                                    panelJedalnyListokObedInside.add(label53, CC.xy(4, 1));

                                    //---- label64 ----
                                    label64.setText("Cena");
                                    label64.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                    label64.setHorizontalAlignment(SwingConstants.CENTER);
                                    label64.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label64, CC.xy(5, 1));

                                    //---- label69 ----
                                    label69.setText("1.");
                                    label69.setHorizontalAlignment(SwingConstants.CENTER);
                                    label69.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label69.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label69, CC.xy(1, 2));

                                    //---- textField7 ----
                                    textField7.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField7.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField7.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField7, CC.xy(2, 2));

                                    //---- comboBox7 ----
                                    comboBox7.setBorder(null);
                                    comboBox7.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "\u00c1no",
                                        "Nie"
                                    }));
                                    comboBox7.setBackground(Color.lightGray);
                                    comboBox7.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox7.setSelectedIndex(-1);
                                    panelJedalnyListokObedInside.add(comboBox7, new CellConstraints(3, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- textField31 ----
                                    textField31.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField31.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField31.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField31, CC.xy(4, 2));

                                    //---- textField32 ----
                                    textField32.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField32.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField32.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField32, CC.xy(5, 2));

                                    //---- label71 ----
                                    label71.setText("2.");
                                    label71.setHorizontalAlignment(SwingConstants.CENTER);
                                    label71.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label71.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label71, CC.xy(1, 3));

                                    //---- textField33 ----
                                    textField33.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField33.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField33.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField33, CC.xy(2, 3));

                                    //---- comboBox8 ----
                                    comboBox8.setBorder(null);
                                    comboBox8.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "\u00c1no",
                                        "Nie"
                                    }));
                                    comboBox8.setBackground(Color.lightGray);
                                    comboBox8.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox8.setSelectedIndex(-1);
                                    panelJedalnyListokObedInside.add(comboBox8, new CellConstraints(3, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- textField34 ----
                                    textField34.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField34.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField34.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField34, CC.xy(4, 3));

                                    //---- textField35 ----
                                    textField35.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField35.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField35.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField35, CC.xy(5, 3));

                                    //---- label74 ----
                                    label74.setText("3.");
                                    label74.setHorizontalAlignment(SwingConstants.CENTER);
                                    label74.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label74.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label74, CC.xy(1, 4));

                                    //---- textField36 ----
                                    textField36.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField36.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField36.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField36, CC.xy(2, 4));

                                    //---- comboBox9 ----
                                    comboBox9.setBorder(null);
                                    comboBox9.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "\u00c1no",
                                        "Nie"
                                    }));
                                    comboBox9.setBackground(Color.lightGray);
                                    comboBox9.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox9.setSelectedIndex(-1);
                                    panelJedalnyListokObedInside.add(comboBox9, new CellConstraints(3, 4, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- textField37 ----
                                    textField37.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField37.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField37.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField37, CC.xy(4, 4));

                                    //---- textField38 ----
                                    textField38.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField38.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField38.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField38, CC.xy(5, 4));

                                    //---- label79 ----
                                    label79.setText("4.");
                                    label79.setHorizontalAlignment(SwingConstants.CENTER);
                                    label79.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label79.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label79, CC.xy(1, 5));

                                    //---- textField39 ----
                                    textField39.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField39.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField39.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField39, CC.xy(2, 5));

                                    //---- comboBox10 ----
                                    comboBox10.setBorder(null);
                                    comboBox10.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "\u00c1no",
                                        "Nie"
                                    }));
                                    comboBox10.setBackground(Color.lightGray);
                                    comboBox10.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox10.setSelectedIndex(-1);
                                    panelJedalnyListokObedInside.add(comboBox10, new CellConstraints(3, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- textField40 ----
                                    textField40.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField40.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField40.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField40, CC.xy(4, 5));

                                    //---- textField41 ----
                                    textField41.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField41.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField41.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField41, CC.xy(5, 5));

                                    //---- label84 ----
                                    label84.setText("5.");
                                    label84.setHorizontalAlignment(SwingConstants.CENTER);
                                    label84.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                    label84.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                    panelJedalnyListokObedInside.add(label84, CC.xy(1, 6));

                                    //---- textField42 ----
                                    textField42.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField42.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField42.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField42, CC.xy(2, 6));

                                    //---- comboBox11 ----
                                    comboBox11.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
                                    comboBox11.setModel(new DefaultComboBoxModel<>(new String[] {
                                        "\u00c1no",
                                        "Nie"
                                    }));
                                    comboBox11.setBackground(Color.lightGray);
                                    comboBox11.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
                                    comboBox11.setSelectedIndex(-1);
                                    panelJedalnyListokObedInside.add(comboBox11, new CellConstraints(3, 6, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 9, 10)));

                                    //---- textField43 ----
                                    textField43.setBorder(new MatteBorder(0, 1, 1, 1, Color.black));
                                    textField43.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField43.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField43, CC.xy(4, 6));

                                    //---- textField44 ----
                                    textField44.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                                    textField44.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                    textField44.setHorizontalAlignment(SwingConstants.CENTER);
                                    panelJedalnyListokObedInside.add(textField44, CC.xy(5, 6));
                                    panelJedalnyListokObedInside.add(label89, CC.xy(1, 8));
                                }
                                panelJedalnyListokObed.add(panelJedalnyListokObedInside, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                    new Insets(0, 0, 0, 0), 0, 0));
                            }
                            panelJedalnyListok.add(panelJedalnyListokObed, "obed");

                            //======== panelJedalnyListokVytvorit ========
                            {
                                panelJedalnyListokVytvorit.setkEndColor(Color.white);
                                panelJedalnyListokVytvorit.setkStartColor(Color.white);
                                panelJedalnyListokVytvorit.setLayout(new GridBagLayout());

                                //======== panelJedalnyListokInside ========
                                {
                                    panelJedalnyListokInside.setkStartColor(Color.white);
                                    panelJedalnyListokInside.setkEndColor(Color.white);
                                    panelJedalnyListokInside.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));
                                    panelJedalnyListokInside.setkBorderRadius(0);
                                    panelJedalnyListokInside.setLayout(new FormLayout(
                                        "[388px,pref]",
                                        "fill:[58px,pref], fill:[55px,pref]"));

                                    //---- labelJedalnyListokVytvoritInisde ----
                                    labelJedalnyListokVytvoritInisde.setText("Vytvori\u0165 nov\u00fd jed\u00e1lny l\u00edstok");
                                    labelJedalnyListokVytvoritInisde.setHorizontalAlignment(SwingConstants.CENTER);
                                    labelJedalnyListokVytvoritInisde.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
                                    panelJedalnyListokInside.add(labelJedalnyListokVytvoritInisde, CC.xy(1, 1));

                                    //---- btnJedalnyListokVytvoritInside ----
                                    btnJedalnyListokVytvoritInside.setText("Vytvori\u0165");
                                    btnJedalnyListokVytvoritInside.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                    btnJedalnyListokVytvoritInside.setBorder(null);
                                    btnJedalnyListokVytvoritInside.setkStartColor(new Color(73, 196, 174));
                                    btnJedalnyListokVytvoritInside.setkEndColor(new Color(140, 219, 145));
                                    btnJedalnyListokVytvoritInside.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                    btnJedalnyListokVytvoritInside.setkHoverEndColor(new Color(73, 196, 174));
                                    btnJedalnyListokVytvoritInside.setkHoverStartColor(new Color(52, 188, 183));
                                    btnJedalnyListokVytvoritInside.setkHoverForeGround(Color.white);
                                    btnJedalnyListokVytvoritInside.setBackground(Color.white);
                                    btnJedalnyListokVytvoritInside.setBorderPainted(false);
                                    btnJedalnyListokVytvoritInside.setMaximumSize(new Dimension(97, 24));
                                    btnJedalnyListokVytvoritInside.setMinimumSize(new Dimension(97, 24));
                                    panelJedalnyListokInside.add(btnJedalnyListokVytvoritInside, new CellConstraints(1, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 145, 15, 145)));
                                }
                                panelJedalnyListokVytvorit.add(panelJedalnyListokInside, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                    new Insets(0, 0, 0, 0), 0, 0));
                            }
                            panelJedalnyListok.add(panelJedalnyListokVytvorit, "vytvorit");
                        }
                        panelContent.add(panelJedalnyListok, "jedalnyListok");
                    }
                    splitPane2.setBottomComponent(panelContent);
                }

                GroupLayout panelRightSideLayout = new GroupLayout(panelRightSide);
                panelRightSide.setLayout(panelRightSideLayout);
                panelRightSideLayout.setHorizontalGroup(
                    panelRightSideLayout.createParallelGroup()
                        .addComponent(splitPane2, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                );
                panelRightSideLayout.setVerticalGroup(
                    panelRightSideLayout.createParallelGroup()
                        .addComponent(splitPane2)
                );
            }
            splitPane1.setRightComponent(panelRightSide);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addComponent(splitPane1, GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE))
                .addGap(0, 1018, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addComponent(splitPane1))
                .addGap(0, 600, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik Vrbovsky
    private JSplitPane splitPane1;
    private KGradientPanel panelMenu;
    private JLabel labelIcon;
    private JLabel labelAdministrator;
    private KButton btnObjednavky;
    private KButton btnJedalnyListok;
    private KButton btnTransakcie;
    private KButton btnPouzivatel;
    private KGradientPanel panelRightSide;
    private JSplitPane splitPane2;
    private KGradientPanel panelStravovaciSystem;
    private JLabel labelStravovaciSystem;
    private JLabel labelDatum;
    private JLabel labelX;
    private JLabel label4;
    private KGradientPanel panelContent;
    private KGradientPanel panelObjednavky;
    private JSplitPane splitPane3;
    private KGradientPanel panelMenuObjednavky;
    private KButton btnRanajky;
    private KButton btnObed;
    private KGradientPanel panelContentObjednavky;
    private KGradientPanel panelObjednavkyRanajky;
    private KGradientPanel panelTableRanajky;
    private JLabel label36;
    private JLabel label1;
    private JLabel label8;
    private JLabel label9;
    private JLabel label46;
    private JLabel label11;
    private JLabel label51;
    private JLabel label25;
    private JLabel label32;
    private JLabel label12;
    private JLabel label17;
    private JLabel label31;
    private JLabel label33;
    private JLabel label13;
    private JLabel label18;
    private JLabel label23;
    private JLabel label34;
    private JLabel label15;
    private JLabel label19;
    private JLabel label22;
    private JLabel label35;
    private JLabel label14;
    private JLabel label20;
    private JLabel label56;
    private JLabel label16;
    private KGradientPanel panelObjednavkyObed;
    private KGradientPanel panelTableObed;
    private JLabel label38;
    private JLabel label21;
    private JLabel label24;
    private JLabel label39;
    private JLabel label47;
    private JLabel label42;
    private JLabel label52;
    private JLabel label43;
    private JLabel label45;
    private JLabel label48;
    private JLabel label49;
    private JLabel label50;
    private JLabel label54;
    private JLabel label55;
    private JLabel label57;
    private JLabel label58;
    private JLabel label60;
    private JLabel label61;
    private JLabel label62;
    private JLabel label63;
    private JLabel label65;
    private JLabel label66;
    private JLabel label67;
    private JLabel label68;
    private JLabel label70;
    private KGradientPanel panelTransakcie;
    private KGradientPanel panelJedalnyListok;
    private KGradientPanel panelJedalnyListokRanajky;
    private JLabel label2;
    private KGradientPanel panelJedalnyListokRanajkyInside;
    private JLabel label40;
    private JLabel label3;
    private JLabel label28;
    private JLabel label29;
    private JLabel label30;
    private JLabel label59;
    private JTextField textField6;
    private JComboBox<String> comboBox2;
    private JTextField textField17;
    private JTextField textField18;
    private JLabel label44;
    private JTextField textField19;
    private JComboBox<String> comboBox3;
    private JTextField textField20;
    private JTextField textField21;
    private JLabel label73;
    private JTextField textField22;
    private JComboBox<String> comboBox4;
    private JTextField textField23;
    private JTextField textField24;
    private JLabel label78;
    private JTextField textField25;
    private JComboBox<String> comboBox5;
    private JTextField textField26;
    private JTextField textField27;
    private JLabel label83;
    private JTextField textField28;
    private JComboBox<String> comboBox6;
    private JTextField textField29;
    private JTextField textField30;
    private KButton kButton3;
    private KGradientPanel panelJedalnyListokObed;
    private KGradientPanel panelJedalnyListokObedInside;
    private JLabel label41;
    private JLabel label5;
    private JLabel label37;
    private JLabel label53;
    private JLabel label64;
    private JLabel label69;
    private JTextField textField7;
    private JComboBox<String> comboBox7;
    private JTextField textField31;
    private JTextField textField32;
    private JLabel label71;
    private JTextField textField33;
    private JComboBox<String> comboBox8;
    private JTextField textField34;
    private JTextField textField35;
    private JLabel label74;
    private JTextField textField36;
    private JComboBox<String> comboBox9;
    private JTextField textField37;
    private JTextField textField38;
    private JLabel label79;
    private JTextField textField39;
    private JComboBox<String> comboBox10;
    private JTextField textField40;
    private JTextField textField41;
    private JLabel label84;
    private JTextField textField42;
    private JComboBox<String> comboBox11;
    private JTextField textField43;
    private JTextField textField44;
    private JLabel label89;
    private KGradientPanel panelJedalnyListokVytvorit;
    private KGradientPanel panelJedalnyListokInside;
    private JLabel labelJedalnyListokVytvoritInisde;
    private KButton btnJedalnyListokVytvoritInside;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
