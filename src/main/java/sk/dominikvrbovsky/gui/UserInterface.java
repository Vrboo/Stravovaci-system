/*
 * Created by JFormDesigner on Mon Apr 19 20:48:55 CEST 2021
 */

package sk.dominikvrbovsky.gui;

import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

import keeptoo.*;
import sk.dominikvrbovsky.Breakfast;
import sk.dominikvrbovsky.Lunch;
import sk.dominikvrbovsky.Meal;
import sk.dominikvrbovsky.User;
import sk.dominikvrbovsky.dao.impl.MealDao;
import sk.dominikvrbovsky.utilities.DateUtilities;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Dominik Vrbovsky
 */
public class UserInterface extends JFrame {
    private final User user;
    private final EntityManager entityManager;
    private final CardLayout cardLayout;
    private final CardLayout cardLayoutObjednat;
    private final CardLayout cardLayoutBurza;
    private final CardLayout cardLayoutUcet;
    private final MealDao mealDao;
    private List<Breakfast> breakfasts;
    private List<Lunch> lunches;

    public UserInterface(EntityManager entityManager, User user) {
        this.entityManager = entityManager;
        this.user = user;
        this.mealDao = new MealDao(entityManager);
        this.breakfasts = null;
        this.lunches = null;

        this.setPreferredSize(new Dimension(1000, 600));
        
        initComponents();
        
        this.cardLayout = (CardLayout)(panelContent.getLayout());
        this.cardLayoutObjednat = (CardLayout)(panelContentObjednat.getLayout());
        this.cardLayoutBurza = (CardLayout)(panelContentBurza.getLayout());
        this.cardLayoutUcet = (CardLayout)(panelContentUcet.getLayout());
        
        labelUsername.setText(user.getFullName());
        labelAccount.setText("Stav účtu: " + user.getAccountString() + "€");
        this.labelDatum.setText(DateUtilities.buildSlovakTimeString());


        passwordStareHeslo.setEchoChar((char)0);
        passwordNoveHeslo.setEchoChar((char)0);
        passwordNovHesloPotvrdenie.setEchoChar((char)0);
        passwordAdmin.setEchoChar((char)0);
        passwordHesloInside.setEchoChar((char)0);


        btnObjednat.setSelected(true);
        btnObjednat.setBorder(new MatteBorder(0,5,0,0, new Color(50, 187, 186)));


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

        btnBurzaRanajky.setBorder(new MatteBorder(0, 0, 4, 0, new Color(52, 188, 183)));
        btnBurzaRanajky.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnBurzaRanajky.isSelected()) {
                    btnBurzaRanajky.setBorder(new MatteBorder(0, 0, 4, 0, new Color(52, 188, 183)));
                } else {
                    btnBurzaRanajky.setBorder(null);
                }
            }
        });

        btnBurzaObed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnBurzaObed.isSelected()) {
                    btnBurzaObed.setBorder(new MatteBorder(0, 0, 4, 0, new Color(52, 188, 183)));
                } else {
                    btnBurzaObed.setBorder(null);
                }
            }
        });

        btnMenuDobitUcet.setBorder(new MatteBorder(0, 0, 4, 0, new Color(52, 188, 183)));
        btnMenuDobitUcet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnMenuDobitUcet.isSelected()) {
                    btnMenuDobitUcet.setBorder(new MatteBorder(0, 0, 4, 0, new Color(52, 188, 183)));
                } else {
                    btnMenuDobitUcet.setBorder(null);
                }
            }
        });

        btnMenuVybratZUctu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnMenuVybratZUctu.isSelected()) {
                    btnMenuVybratZUctu.setBorder(new MatteBorder(0, 0, 4, 0, new Color(52, 188, 183)));
                } else {
                    btnMenuVybratZUctu.setBorder(null);
                }
            }
        });

        btnMenuHistoriaTranskacii.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnMenuHistoriaTranskacii.isSelected()) {
                    btnMenuHistoriaTranskacii.setBorder(new MatteBorder(0, 0, 4, 0, new Color(52, 188, 183)));
                } else {
                    btnMenuHistoriaTranskacii.setBorder(null);
                }
            }
        });

        btnObjednatActionPerformed();
    }

    private void btnObjednatActionPerformed() {
        try {
            this.breakfasts = mealDao.getAllBreakfast();
            this.lunches = mealDao.getAllLunch();
        } catch (Exception e) {
            setLabelWariningError(labelObjednatRanajkyWarning, "Nepodarilo sa správne načítať menu");
            setLabelWariningError(labelObjednatObedWarning, "Nepodarilo sa správne načítať menu");
            return;
        }

        JLabel[][] labelsRanajky = getObjednatArray54(panelTableRanajky.getComponents());
        JLabel[][] labelsObed = getObjednatArray54(panelTableObed.getComponents());

        int index = 0;
        for (Breakfast breakfast : breakfasts) {
            labelsRanajky[index][0].setText(breakfast.getName());
            labelsRanajky[index][1].setText(breakfast.getDrink().getDrink());
            labelsRanajky[index][2].setText(breakfast.getCapacity() + "x");
            labelsRanajky[index][3].setText(breakfast.getPrice()+ "€");

            index++;
        }

        index = 0;
        for (Lunch lunch : lunches) {
            labelsObed[index][0].setText(lunch.getName());
            labelsObed[index][1].setText(lunch.isTakeaway() ? "Áno" : "Nie");
            labelsObed[index][2].setText(lunch.getCapacity() + "x");
            labelsObed[index][3].setText(lunch.getPrice() + "€");

            index++;
        }

        if (user.hasBreakfastOrder()) {
            disableAllButtons(panelTableRanajky.getComponents());
            highlightLine(getObjednatArray55(panelTableRanajky.getComponents()), user.getBreakfastOrder().getMeal().getName());
            setLabelWariningObjednane(labelObjednatRanajkyWarning);
        } else {
            activateAllButtons(panelTableRanajky.getComponents());
        }

        if (user.hasLunchOrder()) {
            disableAllButtons(panelTableObed.getComponents());
            highlightLine(getObjednatArray55(panelTableObed.getComponents()), user.getLunchOrder().getMeal().getName());
            setLabelWariningObjednane(labelObjednatObedWarning);
        } else {
            activateAllButtons(panelTableObed.getComponents());
        }

        cardLayout.show(panelContent,"objednat");
    }

    private void objednatRanajky(String nameOfMeal) {

        try {
            Optional<Breakfast> meal = this.breakfasts.stream().filter(breakfast -> breakfast.getName().equals(nameOfMeal)).findFirst();
            this.user.makeOrder(meal.orElse(null));
            labelAccount.setText("Stav účtu: " + user.getAccountString() + "€");
            btnObjednatActionPerformed();
        } catch (Exception e1) {
            setLabelWariningError(labelObjednatRanajkyWarning,e1.getMessage());
        }

    }

    private void objednatObed(String nameOfMeal) {

        try {
            Optional<Lunch> meal = this.lunches.stream().filter(lunch -> lunch.getName().equals(nameOfMeal)).findFirst();
            this.user.makeOrder(meal.orElse(null));
            labelAccount.setText("Stav účtu: " + user.getAccountString() + "€");
            btnObjednatActionPerformed();
        } catch (Exception e1) {
            setLabelWariningError(labelObjednatObedWarning,e1.getMessage());
        }

    }

    private void highlightLine(JLabel[][] labels, String nameOfMeal) {

        for (int i = 0; i < 5; i++) {
            if (labels[i][1].getText().equals(nameOfMeal)) {
                for (JLabel label : labels[i]) {
                    label.setForeground(new Color(0, 202, 197));
                    label.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                }
            }
        }

    }

    private JLabel[][] getObjednatArray54(Component[] labelsParam) {
        JLabel[][] labels = new JLabel[5][4];
        int index = 7;

        for (int i = 0; i < labels.length; i++) {
            for (int j = 0 ; j < labels[i].length; j++) {
                labels[i][j] = (JLabel) labelsParam[index];
                index++;
                if (labelsParam[index] instanceof JButton) index += 2;
            }
        }

        return labels;
    }

    private JLabel[][] getObjednatArray55(Component[] labelsParam) {
        JLabel[][] labels = new JLabel[5][5];
        int index = 6;

        for (int i = 0; i < labels.length; i++) {
            for (int j = 0 ; j < labels[i].length; j++) {
                labels[i][j] = (JLabel) labelsParam[index];
                index++;
                if (labelsParam[index] instanceof JButton) index++;
            }
        }

        return labels;
    }

    private void activateAllButtons(Component[] components) {
        for (Component c : components) {
            if (c instanceof KButton) {
                c.setEnabled(true);
                ((KButton)c).setkStartColor(new Color(73, 196, 174));
                ((KButton)c).setkEndColor(new Color(140, 219, 145));
                ((KButton)c).setkHoverStartColor(new Color(52, 188, 183));
                ((KButton)c).setkHoverEndColor(new Color(73, 196, 174));
            }
        }
    }

    private void disableAllButtons(Component[] components) {
        for (Component c : components) {
            if (c instanceof KButton) {
                c.setEnabled(false);
                ((KButton)c).setkStartColor(Color.LIGHT_GRAY);
                ((KButton)c).setkEndColor(Color.LIGHT_GRAY);
                ((KButton)c).setkHoverStartColor(Color.LIGHT_GRAY);
                ((KButton)c).setkHoverEndColor(Color.LIGHT_GRAY);
            }
        }
    }

    private void setLabelWariningError(JLabel label, String titul) {
        label.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
        label.setForeground(Color.red);
        label.setText(titul);
    }

    private void setLabelWariningObjednane(JLabel label) {
        label.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
        label.setForeground(new Color(0, 202, 197));
        label.setText("Objednané");
    }

    private void btnMojeObjedActionPerformed() {
        cardLayout.show(panelContent, "mojeObjednavky");
    }

    private void btnBurzaActionPerformed() {
        cardLayout.show(panelContent,"burza");
    }

    private void btnUcetActionPerformed() {
        cardLayout.show(panelContent,"ucet");
    }

    private void btnZmenitCisloActionPerformed() {
        cardLayout.show(panelContent,"zmenitHeslo");
    }

    private void btnOdhlasitSaActionPerformed() {
        cardLayout.show(panelContent,"odhlasitSa");
    }

    private void btnAdminActionPerformed() {
        cardLayout.show(panelContent,"admin");
    }
    
    private void labelXObjednatMouseEntered() {
        labelX.setIcon(
                new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_x_18px_6.png"));
    }

    private void labelXObjednatMouseExited() {
        labelX.setIcon(new 
                ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_x_18px.png"));
    }

    private void labelXObjednatMouseClicked() {
        entityManager.close();
        System.exit(0);
    }

    private void btnRanajkyActionPerformed() {
        cardLayoutObjednat.show(panelContentObjednat, "ranajky");
    }

    private void btnObedActionPerformed() {
        cardLayoutObjednat.show(panelContentObjednat, "obed");
    }

    private void btnBurzaRanajkyActionPerformed() {
        cardLayoutBurza.show(panelContentBurza, "burzaRanajky");
    }

    private void btnBurzaObedActionPerformed() {
        cardLayoutBurza.show(panelContentBurza, "burzaObed");
    }

    private void btnMenuDobitUcetActionPerformed() {
        cardLayoutUcet.show(panelContentUcet, "dobitUcet");
    }

    private void btnMenuVybratZUctuActionPerformed() {
        cardLayoutUcet.show(panelContentUcet, "vybratZUctu");
    }

    private void btnHistoriaTranskaciiActionPerformed() {
        cardLayoutUcet.show(panelContentUcet, "historiaTrans");
    }

    private void passwordStareHesloFocusGained() {
        String pass = String.valueOf(passwordStareHeslo.getPassword());

        if (pass.equals("Staré heslo")) {
            passwordStareHeslo.setEchoChar((char)0x2022);
            passwordStareHeslo.setForeground(Color.BLACK);
            passwordStareHeslo.setText("");
        }
    }

    private void passwordStareHesloFocusLost() {
        String pass = String.valueOf(passwordStareHeslo.getPassword());

        if (pass.equals("")) {
            passwordStareHeslo.setEchoChar((char)0);
            passwordStareHeslo.setForeground(new Color(192,192,192));
            passwordStareHeslo.setText("Staré heslo");
        }
    }

    private void passwordNoveHesloFocusGained() {
        String pass = String.valueOf(passwordNoveHeslo.getPassword());

        if (pass.equals("Nové heslo")) {
            passwordNoveHeslo.setEchoChar((char)0x2022);
            passwordNoveHeslo.setForeground(Color.BLACK);
            passwordNoveHeslo.setText("");
        }
    }

    private void passwordNoveHesloFocusLost() {
        String pass = String.valueOf(passwordNoveHeslo.getPassword());

        if (pass.equals("")) {
            passwordNoveHeslo.setEchoChar((char)0);
            passwordNoveHeslo.setForeground(new Color(192,192,192));
            passwordNoveHeslo.setText("Nové heslo");
        }
    }

    private void passwordNovHesloPotvrdenieFocusGained() {
        String pass = String.valueOf(passwordNovHesloPotvrdenie.getPassword());

        if (pass.equals("Potvrdenie hesla")) {
            passwordNovHesloPotvrdenie.setEchoChar((char)0x2022);
            passwordNovHesloPotvrdenie.setForeground(Color.BLACK);
            passwordNovHesloPotvrdenie.setText("");
        }
    }

    private void passwordNovHesloPotvrdenieFocusLost() {
        String pass = String.valueOf(passwordNovHesloPotvrdenie.getPassword());

        if (pass.equals("")) {
            passwordNovHesloPotvrdenie.setEchoChar((char)0);
            passwordNovHesloPotvrdenie.setForeground(new Color(192,192,192));
            passwordNovHesloPotvrdenie.setText("Potvrdenie hesla");
        }
    }

    private void passwordAdminFocusGained() {
        String pass = String.valueOf(passwordAdmin.getPassword());

        if (pass.equals("Prístupové heslo")) {
            passwordAdmin.setEchoChar((char)0x2022);
            passwordAdmin.setForeground(Color.BLACK);
            passwordAdmin.setText("");
        }
    }

    private void passwordAdminFocusLost() {
        String pass = String.valueOf(passwordAdmin.getPassword());

        if (pass.equals("")) {
            passwordAdmin.setEchoChar((char)0);
            passwordAdmin.setForeground(new Color(192,192,192));
            passwordAdmin.setText("Prístupové heslo");
        }
    }

    private void btnVybratZUctuActionPerformed() {
        cardLayoutUcet.show(panelContentUcet, "heslo");
    }

    private void passwordHesloInsideFocusGained() {
        String pass = String.valueOf(passwordHesloInside.getPassword());

        if (pass.equals("Heslo")) {
            passwordHesloInside.setEchoChar((char)0x2022);
            passwordHesloInside.setForeground(Color.BLACK);
            passwordHesloInside.setText("");
        }
    }

    private void passwordHesloInsideFocusLost() {
        String pass = String.valueOf(passwordHesloInside.getPassword());

        if (pass.equals("")) {
            passwordHesloInside.setEchoChar((char)0);
            passwordHesloInside.setForeground(new Color(192,192,192));
            passwordHesloInside.setText("Heslo");
        }
    }

    private void btnObjednatRanajky1ActionPerformed(ActionEvent e) {
        objednatRanajky(labelObjednatRanajkyNazov1.getText());
    }

    private void btnObjednatRanajky2ActionPerformed(ActionEvent e) {
        objednatRanajky(labelObjednatRanajkyNazov2.getText());
    }

    private void btnObjednatRanajky3ActionPerformed(ActionEvent e) {
        objednatRanajky(labelObjednatRanajkyNazov3.getText());
    }

    private void btnObjednatRanajky4ActionPerformed(ActionEvent e) {
        objednatRanajky(labelObjednatRanajkyNazov4.getText());
    }

    private void btnObjednatRanajky5ActionPerformed(ActionEvent e) {
        objednatRanajky(labelObjednatRanajkyNazov5.getText());
    }

    private void btnObjednatObed1ActionPerformed(ActionEvent e) {
        objednatObed(labelObjednatObedNazov1.getText());
    }

    private void btnObjednatObed2ActionPerformed(ActionEvent e) {
        objednatObed(labelObjednatObedNazov2.getText());
    }

    private void btnObjednatObed3ActionPerformed(ActionEvent e) {
        objednatObed(labelObjednatObedNazov3.getText());
    }

    private void btnObjednatObed4ActionPerformed(ActionEvent e) {
        objednatObed(labelObjednatObedNazov4.getText());
    }

    private void btnObjednatObed5ActionPerformed(ActionEvent e) {
        objednatObed(labelObjednatObedNazov5.getText());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik Vrbovský
        splitPane1 = new JSplitPane();
        panelMenu = new KGradientPanel();
        labelIcon = new JLabel();
        labelUsername = new JLabel();
        btnObjednat = new KButton();
        btnMojeObjed = new KButton();
        btnBurza = new KButton();
        btnUcet = new KButton();
        btnZmenitHeslo = new KButton();
        btnOdhlasitSa = new KButton();
        labelAccount = new JLabel();
        btnAdmin = new KButton();
        panelRightSide = new KGradientPanel();
        splitPane2 = new JSplitPane();
        panelStravovaciSystem = new KGradientPanel();
        labelStravovaciSystem = new JLabel();
        labelDatum = new JLabel();
        labelX = new JLabel();
        label4 = new JLabel();
        panelContent = new KGradientPanel();
        panelObjednat = new KGradientPanel();
        splitPane3 = new JSplitPane();
        panelMenuObjednat = new KGradientPanel();
        btnRanajky = new KButton();
        btnObed = new KButton();
        panelContentObjednat = new KGradientPanel();
        panelRanajky = new KGradientPanel();
        panelTableRanajky = new KGradientPanel();
        label36 = new JLabel();
        label1 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label37 = new JLabel();
        label46 = new JLabel();
        labelObjednatRanajkyNazov1 = new JLabel();
        labelObjednatRanajkyNapoj1 = new JLabel();
        labelObjednatRanajkyKapacita1 = new JLabel();
        labelObjednatRanajkyCena1 = new JLabel();
        btnObjednatRanajky1 = new KButton();
        label32 = new JLabel();
        labelObjednatRanajkyNazov2 = new JLabel();
        labelObjednatRanajkyNapoj2 = new JLabel();
        labelObjednatRanajkyKapacita2 = new JLabel();
        labelObjednatRanajkyCena2 = new JLabel();
        btnObjednatRanajky2 = new KButton();
        label33 = new JLabel();
        labelObjednatRanajkyNazov3 = new JLabel();
        labelObjednatRanajkyNapoj3 = new JLabel();
        labelObjednatRanajkyKapacita3 = new JLabel();
        labelObjednatRanajkyCena3 = new JLabel();
        btnObjednatRanajky3 = new KButton();
        label34 = new JLabel();
        labelObjednatRanajkyNazov4 = new JLabel();
        labelObjednatRanajkyNapoj4 = new JLabel();
        labelObjednatRanajkyKapacita4 = new JLabel();
        labelObjednatRanajkyCena4 = new JLabel();
        btnObjednatRanajky4 = new KButton();
        label35 = new JLabel();
        labelObjednatRanajkyNazov5 = new JLabel();
        labelObjednatRanajkyNapoj5 = new JLabel();
        labelObjednatRanajkyKapacita5 = new JLabel();
        labelObjednatRanajkyCena5 = new JLabel();
        btnObjednatRanajky5 = new KButton();
        labelObjednatRanajkyWarning = new JLabel();
        panelObed = new KGradientPanel();
        panelTableObed = new KGradientPanel();
        label38 = new JLabel();
        label21 = new JLabel();
        label24 = new JLabel();
        label39 = new JLabel();
        label40 = new JLabel();
        label41 = new JLabel();
        label47 = new JLabel();
        labelObjednatObedNazov1 = new JLabel();
        labelObjednatObedTakeaway1 = new JLabel();
        labelObjednatObedKapacita1 = new JLabel();
        labelObjednatObedCena1 = new JLabel();
        btnObjednatObed1 = new KButton();
        label45 = new JLabel();
        labelObjednatObedNazov2 = new JLabel();
        labelObjednatObedTakeaway2 = new JLabel();
        labelObjednatObedKapacita2 = new JLabel();
        labelObjednatObedCena2 = new JLabel();
        btnObjednatObed2 = new KButton();
        label54 = new JLabel();
        labelObjednatObedNazov3 = new JLabel();
        labelObjednatObedTakeaway3 = new JLabel();
        labelObjednatObedKapacita3 = new JLabel();
        labelObjednatObedCena3 = new JLabel();
        btnObjednatObed3 = new KButton();
        label60 = new JLabel();
        labelObjednatObedNazov4 = new JLabel();
        labelObjednatObedTakeaway4 = new JLabel();
        labelObjednatObedKapacita4 = new JLabel();
        labelObjednatObedCena4 = new JLabel();
        btnObjednatObed4 = new KButton();
        label65 = new JLabel();
        labelObjednatObedNazov5 = new JLabel();
        labelObjednatObedTakeaway5 = new JLabel();
        labelObjednatObedKapacita5 = new JLabel();
        labelObjednatObedCena5 = new JLabel();
        btnObjednatObed5 = new KButton();
        labelObjednatObedWarning = new JLabel();
        panelMojeObjednavky = new KGradientPanel();
        panelTableMojeObjRanajky = new KGradientPanel();
        label71 = new JLabel();
        label73 = new JLabel();
        label2 = new JLabel();
        label74 = new JLabel();
        label75 = new JLabel();
        label76 = new JLabel();
        label79 = new JLabel();
        label77 = new JLabel();
        label80 = new JLabel();
        btnDoBurzyObed = new KButton();
        panelTableMojeObjednavkyObed = new KGradientPanel();
        label72 = new JLabel();
        label78 = new JLabel();
        label81 = new JLabel();
        label82 = new JLabel();
        label83 = new JLabel();
        label84 = new JLabel();
        label85 = new JLabel();
        label86 = new JLabel();
        label87 = new JLabel();
        btnDoBurzyRanajky = new KButton();
        label88 = new JLabel();
        panelBurza = new KGradientPanel();
        splitPane4 = new JSplitPane();
        panelMenuBurza = new KGradientPanel();
        btnBurzaRanajky = new KButton();
        btnBurzaObed = new KButton();
        panelContentBurza = new KGradientPanel();
        panelBurzaRanajky = new KGradientPanel();
        panelTableBurzaRanajky = new KGradientPanel();
        label89 = new JLabel();
        label3 = new JLabel();
        label90 = new JLabel();
        label91 = new JLabel();
        label92 = new JLabel();
        label93 = new JLabel();
        label94 = new JLabel();
        label95 = new JLabel();
        label96 = new JLabel();
        label97 = new JLabel();
        label98 = new JLabel();
        btnBurzaRanajky1 = new KButton();
        label99 = new JLabel();
        label100 = new JLabel();
        label101 = new JLabel();
        label102 = new JLabel();
        label103 = new JLabel();
        btnBurzaRanajky2 = new KButton();
        label104 = new JLabel();
        label105 = new JLabel();
        label106 = new JLabel();
        label107 = new JLabel();
        label108 = new JLabel();
        btnBurzaRanajky3 = new KButton();
        label109 = new JLabel();
        label110 = new JLabel();
        label111 = new JLabel();
        label112 = new JLabel();
        label113 = new JLabel();
        btnBurzaRanajky4 = new KButton();
        label114 = new JLabel();
        label115 = new JLabel();
        label116 = new JLabel();
        label117 = new JLabel();
        label118 = new JLabel();
        btnBurzaRanajky5 = new KButton();
        label119 = new JLabel();
        panelBurzaObed = new KGradientPanel();
        panelTableBurzaObed = new KGradientPanel();
        label120 = new JLabel();
        label121 = new JLabel();
        label122 = new JLabel();
        label123 = new JLabel();
        label124 = new JLabel();
        label125 = new JLabel();
        label126 = new JLabel();
        label127 = new JLabel();
        label128 = new JLabel();
        label129 = new JLabel();
        label130 = new JLabel();
        btnBurzaObjednatObed1 = new KButton();
        label131 = new JLabel();
        label132 = new JLabel();
        label133 = new JLabel();
        label134 = new JLabel();
        label135 = new JLabel();
        btnBurzaObjednatObed2 = new KButton();
        label136 = new JLabel();
        label137 = new JLabel();
        label138 = new JLabel();
        label139 = new JLabel();
        label140 = new JLabel();
        btnBurzaObjednatObed3 = new KButton();
        label141 = new JLabel();
        label142 = new JLabel();
        label143 = new JLabel();
        label144 = new JLabel();
        label145 = new JLabel();
        btnBurzaObjednatObed4 = new KButton();
        label146 = new JLabel();
        label147 = new JLabel();
        label148 = new JLabel();
        label149 = new JLabel();
        label150 = new JLabel();
        btnBurzaObjednatObed5 = new KButton();
        label151 = new JLabel();
        panelUcet = new KGradientPanel();
        splitPane5 = new JSplitPane();
        panelUcetMenu = new KGradientPanel();
        btnMenuDobitUcet = new KButton();
        btnMenuVybratZUctu = new KButton();
        btnMenuHistoriaTranskacii = new KButton();
        panelContentUcet = new KGradientPanel();
        panelDobitUcet = new KGradientPanel();
        panelDobitUcetInside = new KGradientPanel();
        labelDobitieUctu = new JLabel();
        txtFieldDobitSuma = new JTextField();
        btnDobitUcet = new KButton();
        panelVybratZUctu = new KGradientPanel();
        panelVyberZUctuInside = new KGradientPanel();
        labelVyberZUctu = new JLabel();
        txtFieldVyberSuma = new JTextField();
        btnVybratZUctu = new KButton();
        panelHistoriaTrans = new KGradientPanel();
        panelHeslo = new KGradientPanel();
        panelHesloInside = new KGradientPanel();
        labelLockIcon = new JLabel();
        passwordHesloInside = new JPasswordField();
        btnPotvrditHesloInside = new KButton();
        panelZmenitHeslo = new KGradientPanel();
        PanelZmenitHesloInside = new KGradientPanel();
        labelZmenaHesla = new JLabel();
        passwordStareHeslo = new JPasswordField();
        passwordNoveHeslo = new JPasswordField();
        passwordNovHesloPotvrdenie = new JPasswordField();
        btnZmenitHesloInside = new KButton();
        panelOdhlasitSa = new KGradientPanel();
        panelOdhlasitSaInside = new KGradientPanel();
        labelNaozajSaChceteOdhlasit = new JLabel();
        btnOdhlasitSaInside = new KButton();
        panelAdmin = new KGradientPanel();
        panelAdminInside = new KGradientPanel();
        labelAdminIcon = new JLabel();
        passwordAdmin = new JPasswordField();
        btnPotvrditHesloAdmin = new KButton();

        //======== this ========
        setUndecorated(true);
        setResizable(false);
        setTitle("Stravovac\u00ed syst\u00e9m");
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
                panelMenu.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
                javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e",javax
                .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
                .awt.Font("D\u0069al\u006fg",java.awt.Font.BOLD,12),java.awt
                .Color.red),panelMenu. getBorder()));panelMenu. addPropertyChangeListener(new java.beans.
                PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062or\u0064er".
                equals(e.getPropertyName()))throw new RuntimeException();}});

                //---- labelIcon ----
                labelIcon.setHorizontalAlignment(SwingConstants.CENTER);
                labelIcon.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_checked_user_male_85px_1.png"));

                //---- labelUsername ----
                labelUsername.setHorizontalAlignment(SwingConstants.CENTER);
                labelUsername.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                labelUsername.setForeground(new Color(50, 187, 186));
                labelUsername.setText("Dominik Vrbovsk\u00fd");

                //---- btnObjednat ----
                btnObjednat.setText("Objedna\u0165");
                btnObjednat.setkBorderRadius(0);
                btnObjednat.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnObjednat.setkEndColor(new Color(55, 55, 55));
                btnObjednat.setkStartColor(new Color(55, 55, 55));
                btnObjednat.setBorder(null);
                btnObjednat.setkHoverEndColor(Color.gray);
                btnObjednat.setkHoverStartColor(new Color(55, 55, 55));
                btnObjednat.setkHoverForeGround(Color.white);
                btnObjednat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnObjednat.setkAllowTab(true);
                btnObjednat.setkSelectedColor(new Color(67, 67, 67));
                btnObjednat.setkIndicatorColor(new Color(50, 187, 186));
                btnObjednat.setkIndicatorThickness(5);
                btnObjednat.addActionListener(e -> btnObjednatActionPerformed());

                //---- btnMojeObjed ----
                btnMojeObjed.setText("Moje objedn\u00e1vky");
                btnMojeObjed.setkBorderRadius(0);
                btnMojeObjed.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnMojeObjed.setkEndColor(new Color(55, 55, 55));
                btnMojeObjed.setkStartColor(new Color(55, 55, 55));
                btnMojeObjed.setBorder(null);
                btnMojeObjed.setkHoverEndColor(Color.gray);
                btnMojeObjed.setkHoverStartColor(new Color(55, 55, 55));
                btnMojeObjed.setkHoverForeGround(Color.white);
                btnMojeObjed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnMojeObjed.setkAllowTab(true);
                btnMojeObjed.setkSelectedColor(new Color(67, 67, 67));
                btnMojeObjed.setkIndicatorColor(new Color(50, 187, 186));
                btnMojeObjed.setkIndicatorThickness(5);
                btnMojeObjed.addActionListener(e -> btnMojeObjedActionPerformed());

                //---- btnBurza ----
                btnBurza.setText("Burza");
                btnBurza.setkBorderRadius(0);
                btnBurza.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnBurza.setkEndColor(new Color(55, 55, 55));
                btnBurza.setkStartColor(new Color(55, 55, 55));
                btnBurza.setBorder(null);
                btnBurza.setkHoverEndColor(Color.gray);
                btnBurza.setkHoverStartColor(new Color(55, 55, 55));
                btnBurza.setkHoverForeGround(Color.white);
                btnBurza.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnBurza.setkAllowTab(true);
                btnBurza.setkSelectedColor(new Color(67, 67, 67));
                btnBurza.setkIndicatorColor(new Color(50, 187, 186));
                btnBurza.setkIndicatorThickness(5);
                btnBurza.addActionListener(e -> btnBurzaActionPerformed());

                //---- btnUcet ----
                btnUcet.setText("\u00da\u010det");
                btnUcet.setkBorderRadius(0);
                btnUcet.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnUcet.setkEndColor(new Color(55, 55, 55));
                btnUcet.setkStartColor(new Color(55, 55, 55));
                btnUcet.setBorder(null);
                btnUcet.setkHoverEndColor(Color.gray);
                btnUcet.setkHoverStartColor(new Color(55, 55, 55));
                btnUcet.setkHoverForeGround(Color.white);
                btnUcet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnUcet.setkAllowTab(true);
                btnUcet.setkSelectedColor(new Color(67, 67, 67));
                btnUcet.setkIndicatorColor(new Color(50, 187, 186));
                btnUcet.setkIndicatorThickness(5);
                btnUcet.addActionListener(e -> btnUcetActionPerformed());

                //---- btnZmenitHeslo ----
                btnZmenitHeslo.setText("Zmeni\u0165 heslo");
                btnZmenitHeslo.setkBorderRadius(0);
                btnZmenitHeslo.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnZmenitHeslo.setkEndColor(new Color(55, 55, 55));
                btnZmenitHeslo.setkStartColor(new Color(55, 55, 55));
                btnZmenitHeslo.setBorder(null);
                btnZmenitHeslo.setkHoverEndColor(Color.gray);
                btnZmenitHeslo.setkHoverStartColor(new Color(55, 55, 55));
                btnZmenitHeslo.setkHoverForeGround(Color.white);
                btnZmenitHeslo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnZmenitHeslo.setkAllowTab(true);
                btnZmenitHeslo.setkSelectedColor(new Color(67, 67, 67));
                btnZmenitHeslo.setkIndicatorColor(new Color(50, 187, 186));
                btnZmenitHeslo.setkIndicatorThickness(5);
                btnZmenitHeslo.addActionListener(e -> btnZmenitCisloActionPerformed());

                //---- btnOdhlasitSa ----
                btnOdhlasitSa.setText("Odhl\u00e1si\u0165 sa");
                btnOdhlasitSa.setkBorderRadius(0);
                btnOdhlasitSa.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnOdhlasitSa.setkEndColor(new Color(55, 55, 55));
                btnOdhlasitSa.setkStartColor(new Color(55, 55, 55));
                btnOdhlasitSa.setBorder(null);
                btnOdhlasitSa.setkHoverEndColor(Color.gray);
                btnOdhlasitSa.setkHoverStartColor(new Color(55, 55, 55));
                btnOdhlasitSa.setkHoverForeGround(Color.white);
                btnOdhlasitSa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnOdhlasitSa.setkAllowTab(true);
                btnOdhlasitSa.setkSelectedColor(new Color(67, 67, 67));
                btnOdhlasitSa.setkIndicatorColor(new Color(50, 187, 186));
                btnOdhlasitSa.setkIndicatorThickness(5);
                btnOdhlasitSa.addActionListener(e -> btnOdhlasitSaActionPerformed());

                //---- labelAccount ----
                labelAccount.setText("Stav \u00fa\u010dtu: 5.45\u20ac");
                labelAccount.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                labelAccount.setHorizontalAlignment(SwingConstants.CENTER);
                labelAccount.setForeground(new Color(50, 187, 186));
                labelAccount.setVerticalAlignment(SwingConstants.TOP);

                //---- btnAdmin ----
                btnAdmin.setText("Administr\u00e1tor");
                btnAdmin.setkBorderRadius(0);
                btnAdmin.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                btnAdmin.setkEndColor(new Color(55, 55, 55));
                btnAdmin.setkStartColor(new Color(55, 55, 55));
                btnAdmin.setBorder(null);
                btnAdmin.setkHoverEndColor(Color.gray);
                btnAdmin.setkHoverStartColor(new Color(55, 55, 55));
                btnAdmin.setkForeGround(Color.lightGray);
                btnAdmin.setkIndicatorThickness(5);
                btnAdmin.setkHoverForeGround(Color.red);
                btnAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnAdmin.setkSelectedColor(new Color(67, 67, 67));
                btnAdmin.setkAllowTab(true);
                btnAdmin.setkIndicatorColor(new Color(50, 187, 186));
                btnAdmin.addActionListener(e -> btnAdminActionPerformed());

                GroupLayout panelMenuLayout = new GroupLayout(panelMenu);
                panelMenu.setLayout(panelMenuLayout);
                panelMenuLayout.setHorizontalGroup(
                    panelMenuLayout.createParallelGroup()
                        .addComponent(btnObjednat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMojeObjed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBurza, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUcet, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnZmenitHeslo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOdhlasitSa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdmin, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelMenuLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelMenuLayout.createParallelGroup()
                                .addComponent(labelUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelAccount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panelMenuLayout.setVerticalGroup(
                    panelMenuLayout.createParallelGroup()
                        .addGroup(panelMenuLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(labelIcon)
                            .addGap(0, 0, 0)
                            .addComponent(labelUsername)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelAccount)
                            .addGap(34, 34, 34)
                            .addComponent(btnObjednat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btnMojeObjed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btnBurza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btnUcet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btnZmenitHeslo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btnOdhlasitSa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                            .addComponent(btnAdmin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(17, 17, 17))
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
                                labelXObjednatMouseClicked();
                            }
                            @Override
                            public void mouseEntered(MouseEvent e) {
                                labelXObjednatMouseEntered();
                            }
                            @Override
                            public void mouseExited(MouseEvent e) {
                                labelXObjednatMouseExited();
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
                                        .addComponent(labelStravovaciSystem, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelDatum, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelStravovaciSystemLayout.createParallelGroup()
                                        .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                            .addGap(0, 402, Short.MAX_VALUE)
                                            .addComponent(labelX, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 195, Short.MAX_VALUE))))
                        );
                        panelStravovaciSystemLayout.setVerticalGroup(
                            panelStravovaciSystemLayout.createParallelGroup()
                                .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                    .addComponent(labelX, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(panelStravovaciSystemLayout.createSequentialGroup()
                                    .addContainerGap(21, Short.MAX_VALUE)
                                    .addGroup(panelStravovaciSystemLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelStravovaciSystem)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(labelDatum)
                                    .addGap(32, 32, 32))
                        );
                    }
                    splitPane2.setTopComponent(panelStravovaciSystem);

                    //======== panelContent ========
                    {
                        panelContent.setLayout(new CardLayout());

                        //======== panelObjednat ========
                        {
                            panelObjednat.setkEndColor(Color.white);
                            panelObjednat.setkStartColor(Color.white);

                            //======== splitPane3 ========
                            {
                                splitPane3.setBorder(null);
                                splitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);
                                splitPane3.setDividerSize(0);
                                splitPane3.setDividerLocation(40);
                                splitPane3.setBackground(new Color(55, 55, 55));

                                //======== panelMenuObjednat ========
                                {
                                    panelMenuObjednat.setkStartColor(new Color(55, 55, 55));
                                    panelMenuObjednat.setkEndColor(new Color(55, 55, 55));
                                    panelMenuObjednat.setkBorderRadius(0);
                                    panelMenuObjednat.setBackground(new Color(55, 55, 55));
                                    panelMenuObjednat.setkGradientFocus(700);
                                    panelMenuObjednat.setForeground(new Color(55, 55, 55));
                                    panelMenuObjednat.setBorder(null);
                                    panelMenuObjednat.setLayout(new FormLayout(
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
                                    btnRanajky.addActionListener(e -> btnRanajkyActionPerformed());
                                    panelMenuObjednat.add(btnRanajky, CC.xy(1, 1));

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
                                    panelMenuObjednat.add(btnObed, CC.xy(3, 1));
                                }
                                splitPane3.setTopComponent(panelMenuObjednat);

                                //======== panelContentObjednat ========
                                {
                                    panelContentObjednat.setBackground(new Color(55, 55, 55));
                                    panelContentObjednat.setLayout(new CardLayout());

                                    //======== panelRanajky ========
                                    {
                                        panelRanajky.setkEndColor(new Color(38, 184, 190, 24));
                                        panelRanajky.setkStartColor(new Color(38, 184, 190, 24));
                                        panelRanajky.setkBorderRadius(0);
                                        panelRanajky.setkGradientFocus(600);
                                        panelRanajky.setBorder(null);
                                        panelRanajky.setBackground(Color.white);
                                        panelRanajky.setkFillBackground(false);
                                        panelRanajky.setLayout(new GridBagLayout());
                                        ((GridBagLayout)panelRanajky.getLayout()).rowHeights = new int[] {0, 30};

                                        //======== panelTableRanajky ========
                                        {
                                            panelTableRanajky.setkEndColor(Color.white);
                                            panelTableRanajky.setkStartColor(Color.white);
                                            panelTableRanajky.setBorder(null);
                                            panelTableRanajky.setkBorderRadius(0);
                                            panelTableRanajky.setBackground(new Color(255, 255, 255, 145));
                                            panelTableRanajky.setLayout(new FormLayout(
                                                "27px, 280px, 126px, 92px, 72px, 107px",
                                                "fill:49px, 5*(fill:52px)"));

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
                                            label9.setText("Vo\u013en\u00e9");
                                            label9.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label9.setHorizontalAlignment(SwingConstants.CENTER);
                                            label9.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            label9.setBackground(Color.white);
                                            panelTableRanajky.add(label9, CC.xy(4, 1));

                                            //---- label10 ----
                                            label10.setText("Cena");
                                            label10.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label10.setHorizontalAlignment(SwingConstants.CENTER);
                                            label10.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label10, CC.xy(5, 1));

                                            //---- label37 ----
                                            label37.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
                                            panelTableRanajky.add(label37, CC.xy(6, 1));

                                            //---- label46 ----
                                            label46.setText("1.");
                                            label46.setHorizontalAlignment(SwingConstants.CENTER);
                                            label46.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label46.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label46, CC.xy(1, 2));

                                            //---- labelObjednatRanajkyNazov1 ----
                                            labelObjednatRanajkyNazov1.setText("Parky s hor\u010dicou a chlebom");
                                            labelObjednatRanajkyNazov1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednatRanajkyNazov1.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyNazov1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyNazov1, CC.xy(2, 2));

                                            //---- labelObjednatRanajkyNapoj1 ----
                                            labelObjednatRanajkyNapoj1.setText("Miner\u00e1lna voda");
                                            labelObjednatRanajkyNapoj1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyNapoj1.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyNapoj1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyNapoj1, CC.xy(3, 2));

                                            //---- labelObjednatRanajkyKapacita1 ----
                                            labelObjednatRanajkyKapacita1.setText("78x");
                                            labelObjednatRanajkyKapacita1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyKapacita1.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyKapacita1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyKapacita1, CC.xy(4, 2));

                                            //---- labelObjednatRanajkyCena1 ----
                                            labelObjednatRanajkyCena1.setText("4.87\u20ac");
                                            labelObjednatRanajkyCena1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyCena1.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyCena1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyCena1, CC.xy(5, 2));

                                            //---- btnObjednatRanajky1 ----
                                            btnObjednatRanajky1.setText("Objedna\u0165");
                                            btnObjednatRanajky1.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnObjednatRanajky1.setBorder(null);
                                            btnObjednatRanajky1.setkStartColor(new Color(73, 196, 174));
                                            btnObjednatRanajky1.setkEndColor(new Color(140, 219, 145));
                                            btnObjednatRanajky1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnObjednatRanajky1.setkHoverEndColor(new Color(73, 196, 174));
                                            btnObjednatRanajky1.setkHoverStartColor(new Color(52, 188, 183));
                                            btnObjednatRanajky1.setkHoverForeGround(Color.white);
                                            btnObjednatRanajky1.setBackground(Color.white);
                                            btnObjednatRanajky1.setBorderPainted(false);
                                            btnObjednatRanajky1.addActionListener(e -> btnObjednatRanajky1ActionPerformed(e));
                                            panelTableRanajky.add(btnObjednatRanajky1, new CellConstraints(6, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label32 ----
                                            label32.setText("2.");
                                            label32.setHorizontalAlignment(SwingConstants.CENTER);
                                            label32.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label32.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label32, CC.xy(1, 3));

                                            //---- labelObjednatRanajkyNazov2 ----
                                            labelObjednatRanajkyNazov2.setText("Pra\u017eenica s ro\u017ekom");
                                            labelObjednatRanajkyNazov2.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednatRanajkyNazov2.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyNazov2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyNazov2, CC.xy(2, 3));

                                            //---- labelObjednatRanajkyNapoj2 ----
                                            labelObjednatRanajkyNapoj2.setText("Cola");
                                            labelObjednatRanajkyNapoj2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyNapoj2.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyNapoj2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyNapoj2, CC.xy(3, 3));

                                            //---- labelObjednatRanajkyKapacita2 ----
                                            labelObjednatRanajkyKapacita2.setText("45x");
                                            labelObjednatRanajkyKapacita2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyKapacita2.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyKapacita2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyKapacita2, CC.xy(4, 3));

                                            //---- labelObjednatRanajkyCena2 ----
                                            labelObjednatRanajkyCena2.setText("2.45\u20ac");
                                            labelObjednatRanajkyCena2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyCena2.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyCena2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyCena2, CC.xy(5, 3));

                                            //---- btnObjednatRanajky2 ----
                                            btnObjednatRanajky2.setText("Objedna\u0165");
                                            btnObjednatRanajky2.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnObjednatRanajky2.setBorder(null);
                                            btnObjednatRanajky2.setkStartColor(new Color(73, 196, 174));
                                            btnObjednatRanajky2.setkEndColor(new Color(140, 219, 145));
                                            btnObjednatRanajky2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnObjednatRanajky2.setkHoverEndColor(new Color(73, 196, 174));
                                            btnObjednatRanajky2.setkHoverStartColor(new Color(52, 188, 183));
                                            btnObjednatRanajky2.setkHoverForeGround(Color.white);
                                            btnObjednatRanajky2.setBackground(Color.white);
                                            btnObjednatRanajky2.setBorderPainted(false);
                                            btnObjednatRanajky2.addActionListener(e -> btnObjednatRanajky2ActionPerformed(e));
                                            panelTableRanajky.add(btnObjednatRanajky2, new CellConstraints(6, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label33 ----
                                            label33.setText("3.");
                                            label33.setHorizontalAlignment(SwingConstants.CENTER);
                                            label33.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label33.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label33, CC.xy(1, 4));

                                            //---- labelObjednatRanajkyNazov3 ----
                                            labelObjednatRanajkyNazov3.setText("Lievance s lekv\u00e1rom");
                                            labelObjednatRanajkyNazov3.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednatRanajkyNazov3.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyNazov3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyNazov3, CC.xy(2, 4));

                                            //---- labelObjednatRanajkyNapoj3 ----
                                            labelObjednatRanajkyNapoj3.setText("\u010caj");
                                            labelObjednatRanajkyNapoj3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyNapoj3.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyNapoj3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyNapoj3, CC.xy(3, 4));

                                            //---- labelObjednatRanajkyKapacita3 ----
                                            labelObjednatRanajkyKapacita3.setText("78x");
                                            labelObjednatRanajkyKapacita3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyKapacita3.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyKapacita3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyKapacita3, CC.xy(4, 4));

                                            //---- labelObjednatRanajkyCena3 ----
                                            labelObjednatRanajkyCena3.setText("3.72\u20ac");
                                            labelObjednatRanajkyCena3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyCena3.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyCena3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyCena3, CC.xy(5, 4));

                                            //---- btnObjednatRanajky3 ----
                                            btnObjednatRanajky3.setText("Objedna\u0165");
                                            btnObjednatRanajky3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnObjednatRanajky3.setBorder(null);
                                            btnObjednatRanajky3.setkStartColor(new Color(73, 196, 174));
                                            btnObjednatRanajky3.setkEndColor(new Color(140, 219, 145));
                                            btnObjednatRanajky3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnObjednatRanajky3.setkHoverEndColor(new Color(73, 196, 174));
                                            btnObjednatRanajky3.setkHoverStartColor(new Color(52, 188, 183));
                                            btnObjednatRanajky3.setkHoverForeGround(Color.white);
                                            btnObjednatRanajky3.setBackground(Color.white);
                                            btnObjednatRanajky3.setBorderPainted(false);
                                            btnObjednatRanajky3.addActionListener(e -> btnObjednatRanajky3ActionPerformed(e));
                                            panelTableRanajky.add(btnObjednatRanajky3, new CellConstraints(6, 4, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label34 ----
                                            label34.setText("4.");
                                            label34.setHorizontalAlignment(SwingConstants.CENTER);
                                            label34.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label34.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label34, CC.xy(1, 5));

                                            //---- labelObjednatRanajkyNazov4 ----
                                            labelObjednatRanajkyNazov4.setText("Volsk\u00e9 oko s ke\u010dup a chlebom");
                                            labelObjednatRanajkyNazov4.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednatRanajkyNazov4.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyNazov4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyNazov4, CC.xy(2, 5));

                                            //---- labelObjednatRanajkyNapoj4 ----
                                            labelObjednatRanajkyNapoj4.setText("Miner\u00e1lna voda");
                                            labelObjednatRanajkyNapoj4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyNapoj4.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyNapoj4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyNapoj4, CC.xy(3, 5));

                                            //---- labelObjednatRanajkyKapacita4 ----
                                            labelObjednatRanajkyKapacita4.setText("123x");
                                            labelObjednatRanajkyKapacita4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyKapacita4.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyKapacita4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyKapacita4, CC.xy(4, 5));

                                            //---- labelObjednatRanajkyCena4 ----
                                            labelObjednatRanajkyCena4.setText("7.00\u20ac");
                                            labelObjednatRanajkyCena4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyCena4.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyCena4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyCena4, CC.xy(5, 5));

                                            //---- btnObjednatRanajky4 ----
                                            btnObjednatRanajky4.setText("Objedna\u0165");
                                            btnObjednatRanajky4.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnObjednatRanajky4.setBorder(null);
                                            btnObjednatRanajky4.setkStartColor(new Color(73, 196, 174));
                                            btnObjednatRanajky4.setkEndColor(new Color(140, 219, 145));
                                            btnObjednatRanajky4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnObjednatRanajky4.setkHoverEndColor(new Color(73, 196, 174));
                                            btnObjednatRanajky4.setkHoverStartColor(new Color(52, 188, 183));
                                            btnObjednatRanajky4.setkHoverForeGround(Color.white);
                                            btnObjednatRanajky4.setBackground(Color.white);
                                            btnObjednatRanajky4.setBorderPainted(false);
                                            btnObjednatRanajky4.addActionListener(e -> btnObjednatRanajky4ActionPerformed(e));
                                            panelTableRanajky.add(btnObjednatRanajky4, new CellConstraints(6, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label35 ----
                                            label35.setText("5.");
                                            label35.setHorizontalAlignment(SwingConstants.CENTER);
                                            label35.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label35.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(label35, CC.xy(1, 6));

                                            //---- labelObjednatRanajkyNazov5 ----
                                            labelObjednatRanajkyNazov5.setText("\u0160unkov\u00e1 bageta");
                                            labelObjednatRanajkyNazov5.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednatRanajkyNazov5.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyNazov5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyNazov5, CC.xy(2, 6));

                                            //---- labelObjednatRanajkyNapoj5 ----
                                            labelObjednatRanajkyNapoj5.setText("\u010e\u017e\u00fas");
                                            labelObjednatRanajkyNapoj5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyNapoj5.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyNapoj5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyNapoj5, CC.xy(3, 6));

                                            //---- labelObjednatRanajkyKapacita5 ----
                                            labelObjednatRanajkyKapacita5.setText("63x");
                                            labelObjednatRanajkyKapacita5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyKapacita5.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyKapacita5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyKapacita5, CC.xy(4, 6));

                                            //---- labelObjednatRanajkyCena5 ----
                                            labelObjednatRanajkyCena5.setText("3.49\u20ac");
                                            labelObjednatRanajkyCena5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatRanajkyCena5.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatRanajkyCena5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableRanajky.add(labelObjednatRanajkyCena5, CC.xy(5, 6));

                                            //---- btnObjednatRanajky5 ----
                                            btnObjednatRanajky5.setText("Objedna\u0165");
                                            btnObjednatRanajky5.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnObjednatRanajky5.setBorder(null);
                                            btnObjednatRanajky5.setkStartColor(new Color(73, 196, 174));
                                            btnObjednatRanajky5.setkEndColor(new Color(140, 219, 145));
                                            btnObjednatRanajky5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnObjednatRanajky5.setkHoverEndColor(new Color(73, 196, 174));
                                            btnObjednatRanajky5.setkHoverStartColor(new Color(52, 188, 183));
                                            btnObjednatRanajky5.setkHoverForeGround(Color.white);
                                            btnObjednatRanajky5.setBackground(Color.white);
                                            btnObjednatRanajky5.setBorderPainted(false);
                                            btnObjednatRanajky5.addActionListener(e -> btnObjednatRanajky5ActionPerformed(e));
                                            panelTableRanajky.add(btnObjednatRanajky5, new CellConstraints(6, 6, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));
                                        }
                                        panelRanajky.add(panelTableRanajky, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 15, 0), 0, 0));

                                        //---- labelObjednatRanajkyWarning ----
                                        labelObjednatRanajkyWarning.setForeground(Color.red);
                                        labelObjednatRanajkyWarning.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
                                        labelObjednatRanajkyWarning.setHorizontalAlignment(SwingConstants.CENTER);
                                        panelRanajky.add(labelObjednatRanajkyWarning, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelContentObjednat.add(panelRanajky, "ranajky");

                                    //======== panelObed ========
                                    {
                                        panelObed.setkBorderRadius(0);
                                        panelObed.setkEndColor(Color.white);
                                        panelObed.setkStartColor(Color.white);
                                        panelObed.setLayout(new GridBagLayout());
                                        ((GridBagLayout)panelObed.getLayout()).rowHeights = new int[] {0, 30};

                                        //======== panelTableObed ========
                                        {
                                            panelTableObed.setkEndColor(Color.white);
                                            panelTableObed.setkStartColor(Color.white);
                                            panelTableObed.setBorder(null);
                                            panelTableObed.setkBorderRadius(0);
                                            panelTableObed.setBackground(new Color(255, 255, 255, 145));
                                            panelTableObed.setLayout(new FormLayout(
                                                "27px, 280px, 126px, 92px, 72px, 107px",
                                                "fill:49px, 5*(fill:52px)"));

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
                                            label39.setText("Vo\u013en\u00e9");
                                            label39.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label39.setHorizontalAlignment(SwingConstants.CENTER);
                                            label39.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            label39.setBackground(Color.white);
                                            panelTableObed.add(label39, CC.xy(4, 1));

                                            //---- label40 ----
                                            label40.setText("Cena");
                                            label40.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label40.setHorizontalAlignment(SwingConstants.CENTER);
                                            label40.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label40, CC.xy(5, 1));

                                            //---- label41 ----
                                            label41.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
                                            panelTableObed.add(label41, CC.xy(6, 1));

                                            //---- label47 ----
                                            label47.setText("1.");
                                            label47.setHorizontalAlignment(SwingConstants.CENTER);
                                            label47.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label47.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label47, CC.xy(1, 2));

                                            //---- labelObjednatObedNazov1 ----
                                            labelObjednatObedNazov1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednatObedNazov1.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedNazov1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            labelObjednatObedNazov1.setText("Kurac\u00ed reze\u0148 + zemiakov\u00e1 ka\u0161a");
                                            panelTableObed.add(labelObjednatObedNazov1, CC.xy(2, 2));

                                            //---- labelObjednatObedTakeaway1 ----
                                            labelObjednatObedTakeaway1.setText("\u00c1no");
                                            labelObjednatObedTakeaway1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedTakeaway1.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedTakeaway1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedTakeaway1, CC.xy(3, 2));

                                            //---- labelObjednatObedKapacita1 ----
                                            labelObjednatObedKapacita1.setText("78x");
                                            labelObjednatObedKapacita1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedKapacita1.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedKapacita1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedKapacita1, CC.xy(4, 2));

                                            //---- labelObjednatObedCena1 ----
                                            labelObjednatObedCena1.setText("3.87\u20ac");
                                            labelObjednatObedCena1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedCena1.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedCena1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedCena1, CC.xy(5, 2));

                                            //---- btnObjednatObed1 ----
                                            btnObjednatObed1.setText("Objedna\u0165");
                                            btnObjednatObed1.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnObjednatObed1.setBorder(null);
                                            btnObjednatObed1.setkStartColor(new Color(73, 196, 174));
                                            btnObjednatObed1.setkEndColor(new Color(140, 219, 145));
                                            btnObjednatObed1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnObjednatObed1.setkHoverEndColor(new Color(73, 196, 174));
                                            btnObjednatObed1.setkHoverStartColor(new Color(52, 188, 183));
                                            btnObjednatObed1.setkHoverForeGround(Color.white);
                                            btnObjednatObed1.setBackground(Color.white);
                                            btnObjednatObed1.setBorderPainted(false);
                                            btnObjednatObed1.addActionListener(e -> btnObjednatObed1ActionPerformed(e));
                                            panelTableObed.add(btnObjednatObed1, new CellConstraints(6, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label45 ----
                                            label45.setText("2.");
                                            label45.setHorizontalAlignment(SwingConstants.CENTER);
                                            label45.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label45.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label45, CC.xy(1, 3));

                                            //---- labelObjednatObedNazov2 ----
                                            labelObjednatObedNazov2.setText("Bryndzov\u00e9 halu\u0161ky");
                                            labelObjednatObedNazov2.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednatObedNazov2.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedNazov2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedNazov2, CC.xy(2, 3));

                                            //---- labelObjednatObedTakeaway2 ----
                                            labelObjednatObedTakeaway2.setText("Nie");
                                            labelObjednatObedTakeaway2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedTakeaway2.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedTakeaway2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedTakeaway2, CC.xy(3, 3));

                                            //---- labelObjednatObedKapacita2 ----
                                            labelObjednatObedKapacita2.setText("417x");
                                            labelObjednatObedKapacita2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedKapacita2.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedKapacita2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedKapacita2, CC.xy(4, 3));

                                            //---- labelObjednatObedCena2 ----
                                            labelObjednatObedCena2.setText("7.45\u20ac");
                                            labelObjednatObedCena2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedCena2.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedCena2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedCena2, CC.xy(5, 3));

                                            //---- btnObjednatObed2 ----
                                            btnObjednatObed2.setText("Objedna\u0165");
                                            btnObjednatObed2.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnObjednatObed2.setBorder(null);
                                            btnObjednatObed2.setkStartColor(new Color(73, 196, 174));
                                            btnObjednatObed2.setkEndColor(new Color(140, 219, 145));
                                            btnObjednatObed2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnObjednatObed2.setkHoverEndColor(new Color(73, 196, 174));
                                            btnObjednatObed2.setkHoverStartColor(new Color(52, 188, 183));
                                            btnObjednatObed2.setkHoverForeGround(Color.white);
                                            btnObjednatObed2.setBackground(Color.white);
                                            btnObjednatObed2.setBorderPainted(false);
                                            btnObjednatObed2.addActionListener(e -> btnObjednatObed2ActionPerformed(e));
                                            panelTableObed.add(btnObjednatObed2, new CellConstraints(6, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label54 ----
                                            label54.setText("3.");
                                            label54.setHorizontalAlignment(SwingConstants.CENTER);
                                            label54.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label54.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label54, CC.xy(1, 4));

                                            //---- labelObjednatObedNazov3 ----
                                            labelObjednatObedNazov3.setText("Palacinky s lekv\u00e1rom");
                                            labelObjednatObedNazov3.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednatObedNazov3.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedNazov3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedNazov3, CC.xy(2, 4));

                                            //---- labelObjednatObedTakeaway3 ----
                                            labelObjednatObedTakeaway3.setText("\u00c1no");
                                            labelObjednatObedTakeaway3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedTakeaway3.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedTakeaway3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedTakeaway3, CC.xy(3, 4));

                                            //---- labelObjednatObedKapacita3 ----
                                            labelObjednatObedKapacita3.setText("29x");
                                            labelObjednatObedKapacita3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedKapacita3.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedKapacita3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedKapacita3, CC.xy(4, 4));

                                            //---- labelObjednatObedCena3 ----
                                            labelObjednatObedCena3.setText("2.21\u20ac");
                                            labelObjednatObedCena3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedCena3.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedCena3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedCena3, CC.xy(5, 4));

                                            //---- btnObjednatObed3 ----
                                            btnObjednatObed3.setText("Objedna\u0165");
                                            btnObjednatObed3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnObjednatObed3.setBorder(null);
                                            btnObjednatObed3.setkStartColor(new Color(73, 196, 174));
                                            btnObjednatObed3.setkEndColor(new Color(140, 219, 145));
                                            btnObjednatObed3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnObjednatObed3.setkHoverEndColor(new Color(73, 196, 174));
                                            btnObjednatObed3.setkHoverStartColor(new Color(52, 188, 183));
                                            btnObjednatObed3.setkHoverForeGround(Color.white);
                                            btnObjednatObed3.setBackground(Color.white);
                                            btnObjednatObed3.setBorderPainted(false);
                                            btnObjednatObed3.addActionListener(e -> btnObjednatObed3ActionPerformed(e));
                                            panelTableObed.add(btnObjednatObed3, new CellConstraints(6, 4, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label60 ----
                                            label60.setText("4.");
                                            label60.setHorizontalAlignment(SwingConstants.CENTER);
                                            label60.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label60.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label60, CC.xy(1, 5));

                                            //---- labelObjednatObedNazov4 ----
                                            labelObjednatObedNazov4.setText("Pizza Hawai");
                                            labelObjednatObedNazov4.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednatObedNazov4.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedNazov4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedNazov4, CC.xy(2, 5));

                                            //---- labelObjednatObedTakeaway4 ----
                                            labelObjednatObedTakeaway4.setText("\u00c1no");
                                            labelObjednatObedTakeaway4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedTakeaway4.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedTakeaway4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedTakeaway4, CC.xy(3, 5));

                                            //---- labelObjednatObedKapacita4 ----
                                            labelObjednatObedKapacita4.setText("75x");
                                            labelObjednatObedKapacita4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedKapacita4.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedKapacita4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedKapacita4, CC.xy(4, 5));

                                            //---- labelObjednatObedCena4 ----
                                            labelObjednatObedCena4.setText("4.25\u20ac");
                                            labelObjednatObedCena4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedCena4.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedCena4.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedCena4, CC.xy(5, 5));

                                            //---- btnObjednatObed4 ----
                                            btnObjednatObed4.setText("Objedna\u0165");
                                            btnObjednatObed4.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnObjednatObed4.setBorder(null);
                                            btnObjednatObed4.setkStartColor(new Color(73, 196, 174));
                                            btnObjednatObed4.setkEndColor(new Color(140, 219, 145));
                                            btnObjednatObed4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnObjednatObed4.setkHoverEndColor(new Color(73, 196, 174));
                                            btnObjednatObed4.setkHoverStartColor(new Color(52, 188, 183));
                                            btnObjednatObed4.setkHoverForeGround(Color.white);
                                            btnObjednatObed4.setBackground(Color.white);
                                            btnObjednatObed4.setBorderPainted(false);
                                            btnObjednatObed4.addActionListener(e -> btnObjednatObed4ActionPerformed(e));
                                            panelTableObed.add(btnObjednatObed4, new CellConstraints(6, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label65 ----
                                            label65.setText("5.");
                                            label65.setHorizontalAlignment(SwingConstants.CENTER);
                                            label65.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label65.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(label65, CC.xy(1, 6));

                                            //---- labelObjednatObedNazov5 ----
                                            labelObjednatObedNazov5.setText("\u0160unkov\u00e1 bageta");
                                            labelObjednatObedNazov5.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            labelObjednatObedNazov5.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedNazov5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedNazov5, CC.xy(2, 6));

                                            //---- labelObjednatObedTakeaway5 ----
                                            labelObjednatObedTakeaway5.setText("Nie");
                                            labelObjednatObedTakeaway5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedTakeaway5.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedTakeaway5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedTakeaway5, CC.xy(3, 6));

                                            //---- labelObjednatObedKapacita5 ----
                                            labelObjednatObedKapacita5.setText("0x");
                                            labelObjednatObedKapacita5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedKapacita5.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedKapacita5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedKapacita5, CC.xy(4, 6));

                                            //---- labelObjednatObedCena5 ----
                                            labelObjednatObedCena5.setText("1.50\u20ac");
                                            labelObjednatObedCena5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            labelObjednatObedCena5.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelObjednatObedCena5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableObed.add(labelObjednatObedCena5, CC.xy(5, 6));

                                            //---- btnObjednatObed5 ----
                                            btnObjednatObed5.setText("Objedna\u0165");
                                            btnObjednatObed5.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnObjednatObed5.setBorder(null);
                                            btnObjednatObed5.setkStartColor(new Color(73, 196, 174));
                                            btnObjednatObed5.setkEndColor(new Color(140, 219, 145));
                                            btnObjednatObed5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnObjednatObed5.setkHoverEndColor(new Color(73, 196, 174));
                                            btnObjednatObed5.setkHoverStartColor(new Color(52, 188, 183));
                                            btnObjednatObed5.setkHoverForeGround(Color.white);
                                            btnObjednatObed5.setBackground(Color.white);
                                            btnObjednatObed5.setBorderPainted(false);
                                            btnObjednatObed5.addActionListener(e -> btnObjednatObed5ActionPerformed(e));
                                            panelTableObed.add(btnObjednatObed5, new CellConstraints(6, 6, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));
                                        }
                                        panelObed.add(panelTableObed, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 15, 0), 0, 0));

                                        //---- labelObjednatObedWarning ----
                                        labelObjednatObedWarning.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
                                        labelObjednatObedWarning.setForeground(Color.red);
                                        labelObjednatObedWarning.setHorizontalAlignment(SwingConstants.CENTER);
                                        panelObed.add(labelObjednatObedWarning, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelContentObjednat.add(panelObed, "obed");
                                }
                                splitPane3.setBottomComponent(panelContentObjednat);
                            }

                            GroupLayout panelObjednatLayout = new GroupLayout(panelObjednat);
                            panelObjednat.setLayout(panelObjednatLayout);
                            panelObjednatLayout.setHorizontalGroup(
                                panelObjednatLayout.createParallelGroup()
                                    .addComponent(splitPane3)
                            );
                            panelObjednatLayout.setVerticalGroup(
                                panelObjednatLayout.createParallelGroup()
                                    .addComponent(splitPane3, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                            );
                        }
                        panelContent.add(panelObjednat, "objednat");

                        //======== panelMojeObjednavky ========
                        {
                            panelMojeObjednavky.setkEndColor(Color.white);
                            panelMojeObjednavky.setkStartColor(Color.white);
                            panelMojeObjednavky.setBorder(null);
                            panelMojeObjednavky.setkBorderRadius(0);
                            panelMojeObjednavky.setLayout(new GridBagLayout());

                            //======== panelTableMojeObjRanajky ========
                            {
                                panelTableMojeObjRanajky.setkEndColor(Color.white);
                                panelTableMojeObjRanajky.setkStartColor(Color.white);
                                panelTableMojeObjRanajky.setBorder(null);
                                panelTableMojeObjRanajky.setkBorderRadius(0);
                                panelTableMojeObjRanajky.setBackground(new Color(255, 255, 255, 145));
                                panelTableMojeObjRanajky.setLayout(new FormLayout(
                                    "46dlu, 36dlu, 348px, 75px, 101px",
                                    "fill:49px, fill:52px"));

                                //---- label71 ----
                                label71.setText("D\u00e1tum");
                                label71.setHorizontalAlignment(SwingConstants.CENTER);
                                label71.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                label71.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableMojeObjRanajky.add(label71, CC.xy(1, 1));

                                //---- label73 ----
                                label73.setText("\u010cas");
                                label73.setHorizontalAlignment(SwingConstants.CENTER);
                                label73.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                label73.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableMojeObjRanajky.add(label73, CC.xy(2, 1));

                                //---- label2 ----
                                label2.setText("Ranajky");
                                label2.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                label2.setHorizontalAlignment(SwingConstants.CENTER);
                                label2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableMojeObjRanajky.add(label2, CC.xy(3, 1));

                                //---- label74 ----
                                label74.setText("Cena");
                                label74.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                label74.setHorizontalAlignment(SwingConstants.CENTER);
                                label74.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableMojeObjRanajky.add(label74, CC.xy(4, 1));

                                //---- label75 ----
                                label75.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableMojeObjRanajky.add(label75, CC.xy(5, 1));

                                //---- label76 ----
                                label76.setText("14.12.2021");
                                label76.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                label76.setHorizontalAlignment(SwingConstants.CENTER);
                                panelTableMojeObjRanajky.add(label76, CC.xy(1, 2));

                                //---- label79 ----
                                label79.setText("14:59");
                                label79.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                label79.setHorizontalAlignment(SwingConstants.CENTER);
                                panelTableMojeObjRanajky.add(label79, CC.xy(2, 2));

                                //---- label77 ----
                                label77.setText("Parky s hor\u010dicou a chlebom (Takeaway)");
                                label77.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                label77.setHorizontalAlignment(SwingConstants.CENTER);
                                label77.setBorder(null);
                                panelTableMojeObjRanajky.add(label77, CC.xy(3, 2));

                                //---- label80 ----
                                label80.setText("4.87\u20ac");
                                label80.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                label80.setHorizontalAlignment(SwingConstants.CENTER);
                                label80.setBorder(null);
                                panelTableMojeObjRanajky.add(label80, CC.xy(4, 2));

                                //---- btnDoBurzyObed ----
                                btnDoBurzyObed.setText("Do burzy");
                                btnDoBurzyObed.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                btnDoBurzyObed.setBorder(null);
                                btnDoBurzyObed.setkStartColor(new Color(73, 196, 174));
                                btnDoBurzyObed.setkEndColor(new Color(140, 219, 145));
                                btnDoBurzyObed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                btnDoBurzyObed.setkHoverEndColor(new Color(73, 196, 174));
                                btnDoBurzyObed.setkHoverStartColor(new Color(52, 188, 183));
                                btnDoBurzyObed.setkHoverForeGround(Color.white);
                                btnDoBurzyObed.setBackground(Color.white);
                                btnDoBurzyObed.setBorderPainted(false);
                                panelTableMojeObjRanajky.add(btnDoBurzyObed, new CellConstraints(5, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 11, 1)));
                            }
                            panelMojeObjednavky.add(panelTableMojeObjRanajky, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 70, 0), 0, 0));

                            //======== panelTableMojeObjednavkyObed ========
                            {
                                panelTableMojeObjednavkyObed.setkEndColor(Color.white);
                                panelTableMojeObjednavkyObed.setkStartColor(Color.white);
                                panelTableMojeObjednavkyObed.setBorder(null);
                                panelTableMojeObjednavkyObed.setkBorderRadius(0);
                                panelTableMojeObjednavkyObed.setBackground(new Color(255, 255, 255, 145));
                                panelTableMojeObjednavkyObed.setLayout(new FormLayout(
                                    "46dlu, 36dlu, 348px, 75px, 101px",
                                    "fill:49px, fill:52px, $lgap, 19dlu"));

                                //---- label72 ----
                                label72.setText("D\u00e1tum");
                                label72.setHorizontalAlignment(SwingConstants.CENTER);
                                label72.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                label72.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableMojeObjednavkyObed.add(label72, CC.xy(1, 1));

                                //---- label78 ----
                                label78.setText("\u010cas");
                                label78.setHorizontalAlignment(SwingConstants.CENTER);
                                label78.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                label78.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableMojeObjednavkyObed.add(label78, CC.xy(2, 1));

                                //---- label81 ----
                                label81.setText("Obed");
                                label81.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                label81.setHorizontalAlignment(SwingConstants.CENTER);
                                label81.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableMojeObjednavkyObed.add(label81, CC.xy(3, 1));

                                //---- label82 ----
                                label82.setText("Cena");
                                label82.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                label82.setHorizontalAlignment(SwingConstants.CENTER);
                                label82.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableMojeObjednavkyObed.add(label82, CC.xy(4, 1));

                                //---- label83 ----
                                label83.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                panelTableMojeObjednavkyObed.add(label83, CC.xy(5, 1));

                                //---- label84 ----
                                label84.setText("7.8.2021");
                                label84.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                label84.setHorizontalAlignment(SwingConstants.CENTER);
                                panelTableMojeObjednavkyObed.add(label84, CC.xy(1, 2));

                                //---- label85 ----
                                label85.setText("7:02");
                                label85.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                label85.setHorizontalAlignment(SwingConstants.CENTER);
                                panelTableMojeObjednavkyObed.add(label85, CC.xy(2, 2));

                                //---- label86 ----
                                label86.setText("Parky s hor\u010dicou a chlebom (Miner\u00e1lna voda)");
                                label86.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                label86.setHorizontalAlignment(SwingConstants.CENTER);
                                label86.setBorder(null);
                                panelTableMojeObjednavkyObed.add(label86, CC.xy(3, 2));

                                //---- label87 ----
                                label87.setText("2.05\u20ac");
                                label87.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                label87.setHorizontalAlignment(SwingConstants.CENTER);
                                label87.setBorder(null);
                                panelTableMojeObjednavkyObed.add(label87, CC.xy(4, 2));

                                //---- btnDoBurzyRanajky ----
                                btnDoBurzyRanajky.setText("Do burzy");
                                btnDoBurzyRanajky.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                btnDoBurzyRanajky.setBorder(null);
                                btnDoBurzyRanajky.setkStartColor(new Color(73, 196, 174));
                                btnDoBurzyRanajky.setkEndColor(new Color(140, 219, 145));
                                btnDoBurzyRanajky.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                btnDoBurzyRanajky.setkHoverEndColor(new Color(73, 196, 174));
                                btnDoBurzyRanajky.setkHoverStartColor(new Color(52, 188, 183));
                                btnDoBurzyRanajky.setkHoverForeGround(Color.white);
                                btnDoBurzyRanajky.setBackground(Color.white);
                                btnDoBurzyRanajky.setBorderPainted(false);
                                panelTableMojeObjednavkyObed.add(btnDoBurzyRanajky, new CellConstraints(5, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 10, 11, 1)));
                                panelTableMojeObjednavkyObed.add(label88, CC.xy(1, 4));
                            }
                            panelMojeObjednavky.add(panelTableMojeObjednavkyObed, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                        }
                        panelContent.add(panelMojeObjednavky, "mojeObjednavky");

                        //======== panelBurza ========
                        {
                            panelBurza.setkEndColor(Color.white);
                            panelBurza.setkStartColor(Color.white);

                            //======== splitPane4 ========
                            {
                                splitPane4.setBorder(null);
                                splitPane4.setDividerSize(0);
                                splitPane4.setOrientation(JSplitPane.VERTICAL_SPLIT);
                                splitPane4.setDividerLocation(40);

                                //======== panelMenuBurza ========
                                {
                                    panelMenuBurza.setkStartColor(new Color(55, 55, 55));
                                    panelMenuBurza.setkEndColor(new Color(55, 55, 55));
                                    panelMenuBurza.setkBorderRadius(0);
                                    panelMenuBurza.setBackground(new Color(55, 55, 55));
                                    panelMenuBurza.setkGradientFocus(700);
                                    panelMenuBurza.setForeground(new Color(55, 55, 55));
                                    panelMenuBurza.setLayout(new FormLayout(
                                        "default, $lcgap, default",
                                        "fill:default"));

                                    //---- btnBurzaRanajky ----
                                    btnBurzaRanajky.setText("Burza - ranajky");
                                    btnBurzaRanajky.setBorder(null);
                                    btnBurzaRanajky.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                    btnBurzaRanajky.setkStartColor(Color.darkGray);
                                    btnBurzaRanajky.setkEndColor(Color.darkGray);
                                    btnBurzaRanajky.setkBorderRadius(0);
                                    btnBurzaRanajky.setkAllowTab(true);
                                    btnBurzaRanajky.setkHoverEndColor(new Color(70, 70, 70));
                                    btnBurzaRanajky.setkHoverStartColor(new Color(70, 70, 70));
                                    btnBurzaRanajky.setkIndicatorColor(new Color(38, 184, 190));
                                    btnBurzaRanajky.setkIndicatorThickness(0);
                                    btnBurzaRanajky.setkBackGroundColor(Color.white);
                                    btnBurzaRanajky.setkSelectedColor(new Color(67, 67, 67));
                                    btnBurzaRanajky.setkHoverForeGround(Color.white);
                                    btnBurzaRanajky.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                    btnBurzaRanajky.setVerticalAlignment(SwingConstants.TOP);
                                    btnBurzaRanajky.addActionListener(e -> {
			btnRanajkyActionPerformed();
			btnBurzaRanajkyActionPerformed();
		});
                                    panelMenuBurza.add(btnBurzaRanajky, CC.xy(1, 1));

                                    //---- btnBurzaObed ----
                                    btnBurzaObed.setText("Burza - obed");
                                    btnBurzaObed.setBorder(null);
                                    btnBurzaObed.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                    btnBurzaObed.setkStartColor(Color.darkGray);
                                    btnBurzaObed.setkEndColor(Color.darkGray);
                                    btnBurzaObed.setkBorderRadius(0);
                                    btnBurzaObed.setkAllowTab(true);
                                    btnBurzaObed.setkHoverEndColor(new Color(70, 70, 70));
                                    btnBurzaObed.setkHoverStartColor(new Color(70, 70, 70));
                                    btnBurzaObed.setkIndicatorColor(new Color(38, 184, 190));
                                    btnBurzaObed.setkIndicatorThickness(0);
                                    btnBurzaObed.setkBackGroundColor(Color.white);
                                    btnBurzaObed.setkSelectedColor(new Color(67, 67, 67));
                                    btnBurzaObed.setkHoverForeGround(Color.white);
                                    btnBurzaObed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                    btnBurzaObed.setVerticalAlignment(SwingConstants.TOP);
                                    btnBurzaObed.addActionListener(e -> {
			btnObedActionPerformed();
			btnBurzaObedActionPerformed();
		});
                                    panelMenuBurza.add(btnBurzaObed, CC.xy(3, 1));
                                }
                                splitPane4.setTopComponent(panelMenuBurza);

                                //======== panelContentBurza ========
                                {
                                    panelContentBurza.setkStartColor(Color.white);
                                    panelContentBurza.setkEndColor(Color.white);
                                    panelContentBurza.setLayout(new CardLayout());

                                    //======== panelBurzaRanajky ========
                                    {
                                        panelBurzaRanajky.setkEndColor(new Color(38, 184, 190, 24));
                                        panelBurzaRanajky.setkStartColor(new Color(38, 184, 190, 24));
                                        panelBurzaRanajky.setkBorderRadius(0);
                                        panelBurzaRanajky.setkGradientFocus(600);
                                        panelBurzaRanajky.setBorder(null);
                                        panelBurzaRanajky.setBackground(Color.white);
                                        panelBurzaRanajky.setkFillBackground(false);
                                        panelBurzaRanajky.setLayout(new GridBagLayout());

                                        //======== panelTableBurzaRanajky ========
                                        {
                                            panelTableBurzaRanajky.setkEndColor(Color.white);
                                            panelTableBurzaRanajky.setkStartColor(Color.white);
                                            panelTableBurzaRanajky.setBorder(null);
                                            panelTableBurzaRanajky.setkBorderRadius(0);
                                            panelTableBurzaRanajky.setBackground(new Color(255, 255, 255, 145));
                                            panelTableBurzaRanajky.setLayout(new FormLayout(
                                                "27px, 280px, 126px, 92px, 72px, 107px",
                                                "fill:49px, 5*(fill:52px), $lgap, 11dlu"));

                                            //---- label89 ----
                                            label89.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label89, CC.xy(1, 1));

                                            //---- label3 ----
                                            label3.setText("Ra\u0148ajky");
                                            label3.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label3.setHorizontalAlignment(SwingConstants.CENTER);
                                            label3.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label3, CC.xy(2, 1));

                                            //---- label90 ----
                                            label90.setText("N\u00e1poj");
                                            label90.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label90.setHorizontalAlignment(SwingConstants.CENTER);
                                            label90.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label90, CC.xy(3, 1));

                                            //---- label91 ----
                                            label91.setText("Po\u010det");
                                            label91.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label91.setHorizontalAlignment(SwingConstants.CENTER);
                                            label91.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            label91.setBackground(Color.white);
                                            panelTableBurzaRanajky.add(label91, CC.xy(4, 1));

                                            //---- label92 ----
                                            label92.setText("Cena");
                                            label92.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label92.setHorizontalAlignment(SwingConstants.CENTER);
                                            label92.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label92, CC.xy(5, 1));

                                            //---- label93 ----
                                            label93.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
                                            panelTableBurzaRanajky.add(label93, CC.xy(6, 1));

                                            //---- label94 ----
                                            label94.setText("1.");
                                            label94.setHorizontalAlignment(SwingConstants.CENTER);
                                            label94.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label94.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label94, CC.xy(1, 2));

                                            //---- label95 ----
                                            label95.setText("Parky s hor\u010dicou a chlebom");
                                            label95.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label95.setHorizontalAlignment(SwingConstants.CENTER);
                                            label95.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label95, CC.xy(2, 2));

                                            //---- label96 ----
                                            label96.setText("Miner\u00e1lna voda");
                                            label96.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label96.setHorizontalAlignment(SwingConstants.CENTER);
                                            label96.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label96, CC.xy(3, 2));

                                            //---- label97 ----
                                            label97.setText("0x");
                                            label97.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label97.setHorizontalAlignment(SwingConstants.CENTER);
                                            label97.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label97, CC.xy(4, 2));

                                            //---- label98 ----
                                            label98.setText("4.87\u20ac");
                                            label98.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label98.setHorizontalAlignment(SwingConstants.CENTER);
                                            label98.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label98, CC.xy(5, 2));

                                            //---- btnBurzaRanajky1 ----
                                            btnBurzaRanajky1.setText("Objedna\u0165");
                                            btnBurzaRanajky1.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnBurzaRanajky1.setBorder(null);
                                            btnBurzaRanajky1.setkStartColor(new Color(73, 196, 174));
                                            btnBurzaRanajky1.setkEndColor(new Color(140, 219, 145));
                                            btnBurzaRanajky1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnBurzaRanajky1.setkHoverEndColor(new Color(73, 196, 174));
                                            btnBurzaRanajky1.setkHoverStartColor(new Color(52, 188, 183));
                                            btnBurzaRanajky1.setkHoverForeGround(Color.white);
                                            btnBurzaRanajky1.setBackground(Color.white);
                                            btnBurzaRanajky1.setBorderPainted(false);
                                            panelTableBurzaRanajky.add(btnBurzaRanajky1, new CellConstraints(6, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label99 ----
                                            label99.setText("2.");
                                            label99.setHorizontalAlignment(SwingConstants.CENTER);
                                            label99.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label99.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label99, CC.xy(1, 3));

                                            //---- label100 ----
                                            label100.setText("Pra\u017eenica s ro\u017ekom");
                                            label100.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label100.setHorizontalAlignment(SwingConstants.CENTER);
                                            label100.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label100, CC.xy(2, 3));

                                            //---- label101 ----
                                            label101.setText("Cola");
                                            label101.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label101.setHorizontalAlignment(SwingConstants.CENTER);
                                            label101.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label101, CC.xy(3, 3));

                                            //---- label102 ----
                                            label102.setText("5x");
                                            label102.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label102.setHorizontalAlignment(SwingConstants.CENTER);
                                            label102.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label102, CC.xy(4, 3));

                                            //---- label103 ----
                                            label103.setText("2.45\u20ac");
                                            label103.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label103.setHorizontalAlignment(SwingConstants.CENTER);
                                            label103.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label103, CC.xy(5, 3));

                                            //---- btnBurzaRanajky2 ----
                                            btnBurzaRanajky2.setText("Objedna\u0165");
                                            btnBurzaRanajky2.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnBurzaRanajky2.setBorder(null);
                                            btnBurzaRanajky2.setkStartColor(new Color(73, 196, 174));
                                            btnBurzaRanajky2.setkEndColor(new Color(140, 219, 145));
                                            btnBurzaRanajky2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnBurzaRanajky2.setkHoverEndColor(new Color(73, 196, 174));
                                            btnBurzaRanajky2.setkHoverStartColor(new Color(52, 188, 183));
                                            btnBurzaRanajky2.setkHoverForeGround(Color.white);
                                            btnBurzaRanajky2.setBackground(Color.white);
                                            btnBurzaRanajky2.setBorderPainted(false);
                                            panelTableBurzaRanajky.add(btnBurzaRanajky2, new CellConstraints(6, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label104 ----
                                            label104.setText("3.");
                                            label104.setHorizontalAlignment(SwingConstants.CENTER);
                                            label104.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label104.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label104, CC.xy(1, 4));

                                            //---- label105 ----
                                            label105.setText("Lievance s lekv\u00e1rom");
                                            label105.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label105.setHorizontalAlignment(SwingConstants.CENTER);
                                            label105.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label105, CC.xy(2, 4));

                                            //---- label106 ----
                                            label106.setText("\u010caj");
                                            label106.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label106.setHorizontalAlignment(SwingConstants.CENTER);
                                            label106.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label106, CC.xy(3, 4));

                                            //---- label107 ----
                                            label107.setText("12x");
                                            label107.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label107.setHorizontalAlignment(SwingConstants.CENTER);
                                            label107.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label107, CC.xy(4, 4));

                                            //---- label108 ----
                                            label108.setText("3.72\u20ac");
                                            label108.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label108.setHorizontalAlignment(SwingConstants.CENTER);
                                            label108.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label108, CC.xy(5, 4));

                                            //---- btnBurzaRanajky3 ----
                                            btnBurzaRanajky3.setText("Objedna\u0165");
                                            btnBurzaRanajky3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnBurzaRanajky3.setBorder(null);
                                            btnBurzaRanajky3.setkStartColor(new Color(73, 196, 174));
                                            btnBurzaRanajky3.setkEndColor(new Color(140, 219, 145));
                                            btnBurzaRanajky3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnBurzaRanajky3.setkHoverEndColor(new Color(73, 196, 174));
                                            btnBurzaRanajky3.setkHoverStartColor(new Color(52, 188, 183));
                                            btnBurzaRanajky3.setkHoverForeGround(Color.white);
                                            btnBurzaRanajky3.setBackground(Color.white);
                                            btnBurzaRanajky3.setBorderPainted(false);
                                            panelTableBurzaRanajky.add(btnBurzaRanajky3, new CellConstraints(6, 4, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label109 ----
                                            label109.setText("4.");
                                            label109.setHorizontalAlignment(SwingConstants.CENTER);
                                            label109.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label109.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label109, CC.xy(1, 5));

                                            //---- label110 ----
                                            label110.setText("Volsk\u00e9 oko s ke\u010dup a chlebom");
                                            label110.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label110.setHorizontalAlignment(SwingConstants.CENTER);
                                            label110.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label110, CC.xy(2, 5));

                                            //---- label111 ----
                                            label111.setText("Miner\u00e1lna voda");
                                            label111.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label111.setHorizontalAlignment(SwingConstants.CENTER);
                                            label111.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label111, CC.xy(3, 5));

                                            //---- label112 ----
                                            label112.setText("0x");
                                            label112.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label112.setHorizontalAlignment(SwingConstants.CENTER);
                                            label112.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label112, CC.xy(4, 5));

                                            //---- label113 ----
                                            label113.setText("7.00\u20ac");
                                            label113.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label113.setHorizontalAlignment(SwingConstants.CENTER);
                                            label113.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label113, CC.xy(5, 5));

                                            //---- btnBurzaRanajky4 ----
                                            btnBurzaRanajky4.setText("Objedna\u0165");
                                            btnBurzaRanajky4.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnBurzaRanajky4.setBorder(null);
                                            btnBurzaRanajky4.setkStartColor(new Color(73, 196, 174));
                                            btnBurzaRanajky4.setkEndColor(new Color(140, 219, 145));
                                            btnBurzaRanajky4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnBurzaRanajky4.setkHoverEndColor(new Color(73, 196, 174));
                                            btnBurzaRanajky4.setkHoverStartColor(new Color(52, 188, 183));
                                            btnBurzaRanajky4.setkHoverForeGround(Color.white);
                                            btnBurzaRanajky4.setBackground(Color.white);
                                            btnBurzaRanajky4.setBorderPainted(false);
                                            panelTableBurzaRanajky.add(btnBurzaRanajky4, new CellConstraints(6, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label114 ----
                                            label114.setText("5.");
                                            label114.setHorizontalAlignment(SwingConstants.CENTER);
                                            label114.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label114.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label114, CC.xy(1, 6));

                                            //---- label115 ----
                                            label115.setText("\u0160unkov\u00e1 bageta");
                                            label115.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label115.setHorizontalAlignment(SwingConstants.CENTER);
                                            label115.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label115, CC.xy(2, 6));

                                            //---- label116 ----
                                            label116.setText("\u010e\u017e\u00fas");
                                            label116.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label116.setHorizontalAlignment(SwingConstants.CENTER);
                                            label116.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label116, CC.xy(3, 6));

                                            //---- label117 ----
                                            label117.setText("28x");
                                            label117.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label117.setHorizontalAlignment(SwingConstants.CENTER);
                                            label117.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label117, CC.xy(4, 6));

                                            //---- label118 ----
                                            label118.setText("3.49\u20ac");
                                            label118.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label118.setHorizontalAlignment(SwingConstants.CENTER);
                                            label118.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaRanajky.add(label118, CC.xy(5, 6));

                                            //---- btnBurzaRanajky5 ----
                                            btnBurzaRanajky5.setText("Objedna\u0165");
                                            btnBurzaRanajky5.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnBurzaRanajky5.setBorder(null);
                                            btnBurzaRanajky5.setkStartColor(new Color(73, 196, 174));
                                            btnBurzaRanajky5.setkEndColor(new Color(140, 219, 145));
                                            btnBurzaRanajky5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnBurzaRanajky5.setkHoverEndColor(new Color(73, 196, 174));
                                            btnBurzaRanajky5.setkHoverStartColor(new Color(52, 188, 183));
                                            btnBurzaRanajky5.setkHoverForeGround(Color.white);
                                            btnBurzaRanajky5.setBackground(Color.white);
                                            btnBurzaRanajky5.setBorderPainted(false);
                                            panelTableBurzaRanajky.add(btnBurzaRanajky5, new CellConstraints(6, 6, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));
                                            panelTableBurzaRanajky.add(label119, CC.xy(1, 8));
                                        }
                                        panelBurzaRanajky.add(panelTableBurzaRanajky, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelContentBurza.add(panelBurzaRanajky, "burzaRanajky");

                                    //======== panelBurzaObed ========
                                    {
                                        panelBurzaObed.setkBorderRadius(0);
                                        panelBurzaObed.setkEndColor(Color.white);
                                        panelBurzaObed.setkStartColor(Color.white);
                                        panelBurzaObed.setLayout(new GridBagLayout());

                                        //======== panelTableBurzaObed ========
                                        {
                                            panelTableBurzaObed.setkEndColor(Color.white);
                                            panelTableBurzaObed.setkStartColor(Color.white);
                                            panelTableBurzaObed.setBorder(null);
                                            panelTableBurzaObed.setkBorderRadius(0);
                                            panelTableBurzaObed.setBackground(new Color(255, 255, 255, 145));
                                            panelTableBurzaObed.setLayout(new FormLayout(
                                                "27px, 280px, 126px, 92px, 72px, 107px",
                                                "fill:49px, 5*(fill:52px), $lgap, 11dlu"));

                                            //---- label120 ----
                                            label120.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label120, CC.xy(1, 1));

                                            //---- label121 ----
                                            label121.setText("Obed");
                                            label121.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label121.setHorizontalAlignment(SwingConstants.CENTER);
                                            label121.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label121, CC.xy(2, 1));

                                            //---- label122 ----
                                            label122.setText("Takeaway");
                                            label122.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label122.setHorizontalAlignment(SwingConstants.CENTER);
                                            label122.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label122, CC.xy(3, 1));

                                            //---- label123 ----
                                            label123.setText("Po\u010det");
                                            label123.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label123.setHorizontalAlignment(SwingConstants.CENTER);
                                            label123.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            label123.setBackground(Color.white);
                                            panelTableBurzaObed.add(label123, CC.xy(4, 1));

                                            //---- label124 ----
                                            label124.setText("Cena");
                                            label124.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            label124.setHorizontalAlignment(SwingConstants.CENTER);
                                            label124.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label124, CC.xy(5, 1));

                                            //---- label125 ----
                                            label125.setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
                                            panelTableBurzaObed.add(label125, CC.xy(6, 1));

                                            //---- label126 ----
                                            label126.setText("1.");
                                            label126.setHorizontalAlignment(SwingConstants.CENTER);
                                            label126.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label126.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label126, CC.xy(1, 2));

                                            //---- label127 ----
                                            label127.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label127.setHorizontalAlignment(SwingConstants.CENTER);
                                            label127.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            label127.setText("Kurac\u00ed reze\u0148 + zemiakov\u00e1 ka\u0161a");
                                            panelTableBurzaObed.add(label127, CC.xy(2, 2));

                                            //---- label128 ----
                                            label128.setText("\u00c1no");
                                            label128.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label128.setHorizontalAlignment(SwingConstants.CENTER);
                                            label128.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label128, CC.xy(3, 2));

                                            //---- label129 ----
                                            label129.setText("78x");
                                            label129.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label129.setHorizontalAlignment(SwingConstants.CENTER);
                                            label129.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label129, CC.xy(4, 2));

                                            //---- label130 ----
                                            label130.setText("3.87\u20ac");
                                            label130.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label130.setHorizontalAlignment(SwingConstants.CENTER);
                                            label130.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label130, CC.xy(5, 2));

                                            //---- btnBurzaObjednatObed1 ----
                                            btnBurzaObjednatObed1.setText("Objedna\u0165");
                                            btnBurzaObjednatObed1.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnBurzaObjednatObed1.setBorder(null);
                                            btnBurzaObjednatObed1.setkStartColor(new Color(73, 196, 174));
                                            btnBurzaObjednatObed1.setkEndColor(new Color(140, 219, 145));
                                            btnBurzaObjednatObed1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnBurzaObjednatObed1.setkHoverEndColor(new Color(73, 196, 174));
                                            btnBurzaObjednatObed1.setkHoverStartColor(new Color(52, 188, 183));
                                            btnBurzaObjednatObed1.setkHoverForeGround(Color.white);
                                            btnBurzaObjednatObed1.setBackground(Color.white);
                                            btnBurzaObjednatObed1.setBorderPainted(false);
                                            panelTableBurzaObed.add(btnBurzaObjednatObed1, new CellConstraints(6, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label131 ----
                                            label131.setText("2.");
                                            label131.setHorizontalAlignment(SwingConstants.CENTER);
                                            label131.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label131.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label131, CC.xy(1, 3));

                                            //---- label132 ----
                                            label132.setText("Bryndzov\u00e9 halu\u0161ky");
                                            label132.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label132.setHorizontalAlignment(SwingConstants.CENTER);
                                            label132.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label132, CC.xy(2, 3));

                                            //---- label133 ----
                                            label133.setText("Nie");
                                            label133.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label133.setHorizontalAlignment(SwingConstants.CENTER);
                                            label133.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label133, CC.xy(3, 3));

                                            //---- label134 ----
                                            label134.setText("417x");
                                            label134.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label134.setHorizontalAlignment(SwingConstants.CENTER);
                                            label134.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label134, CC.xy(4, 3));

                                            //---- label135 ----
                                            label135.setText("7.45\u20ac");
                                            label135.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label135.setHorizontalAlignment(SwingConstants.CENTER);
                                            label135.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label135, CC.xy(5, 3));

                                            //---- btnBurzaObjednatObed2 ----
                                            btnBurzaObjednatObed2.setText("Objedna\u0165");
                                            btnBurzaObjednatObed2.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnBurzaObjednatObed2.setBorder(null);
                                            btnBurzaObjednatObed2.setkStartColor(new Color(73, 196, 174));
                                            btnBurzaObjednatObed2.setkEndColor(new Color(140, 219, 145));
                                            btnBurzaObjednatObed2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnBurzaObjednatObed2.setkHoverEndColor(new Color(73, 196, 174));
                                            btnBurzaObjednatObed2.setkHoverStartColor(new Color(52, 188, 183));
                                            btnBurzaObjednatObed2.setkHoverForeGround(Color.white);
                                            btnBurzaObjednatObed2.setBackground(Color.white);
                                            btnBurzaObjednatObed2.setBorderPainted(false);
                                            panelTableBurzaObed.add(btnBurzaObjednatObed2, new CellConstraints(6, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label136 ----
                                            label136.setText("3.");
                                            label136.setHorizontalAlignment(SwingConstants.CENTER);
                                            label136.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label136.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label136, CC.xy(1, 4));

                                            //---- label137 ----
                                            label137.setText("Palacinky s lekv\u00e1rom");
                                            label137.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label137.setHorizontalAlignment(SwingConstants.CENTER);
                                            label137.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label137, CC.xy(2, 4));

                                            //---- label138 ----
                                            label138.setText("\u00c1no");
                                            label138.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label138.setHorizontalAlignment(SwingConstants.CENTER);
                                            label138.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label138, CC.xy(3, 4));

                                            //---- label139 ----
                                            label139.setText("29x");
                                            label139.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label139.setHorizontalAlignment(SwingConstants.CENTER);
                                            label139.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label139, CC.xy(4, 4));

                                            //---- label140 ----
                                            label140.setText("2.21\u20ac");
                                            label140.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label140.setHorizontalAlignment(SwingConstants.CENTER);
                                            label140.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label140, CC.xy(5, 4));

                                            //---- btnBurzaObjednatObed3 ----
                                            btnBurzaObjednatObed3.setText("Objedna\u0165");
                                            btnBurzaObjednatObed3.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnBurzaObjednatObed3.setBorder(null);
                                            btnBurzaObjednatObed3.setkStartColor(new Color(73, 196, 174));
                                            btnBurzaObjednatObed3.setkEndColor(new Color(140, 219, 145));
                                            btnBurzaObjednatObed3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnBurzaObjednatObed3.setkHoverEndColor(new Color(73, 196, 174));
                                            btnBurzaObjednatObed3.setkHoverStartColor(new Color(52, 188, 183));
                                            btnBurzaObjednatObed3.setkHoverForeGround(Color.white);
                                            btnBurzaObjednatObed3.setBackground(Color.white);
                                            btnBurzaObjednatObed3.setBorderPainted(false);
                                            panelTableBurzaObed.add(btnBurzaObjednatObed3, new CellConstraints(6, 4, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label141 ----
                                            label141.setText("4.");
                                            label141.setHorizontalAlignment(SwingConstants.CENTER);
                                            label141.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label141.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label141, CC.xy(1, 5));

                                            //---- label142 ----
                                            label142.setText("Pizza Hawai");
                                            label142.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label142.setHorizontalAlignment(SwingConstants.CENTER);
                                            label142.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label142, CC.xy(2, 5));

                                            //---- label143 ----
                                            label143.setText("\u00c1no");
                                            label143.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label143.setHorizontalAlignment(SwingConstants.CENTER);
                                            label143.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label143, CC.xy(3, 5));

                                            //---- label144 ----
                                            label144.setText("75x");
                                            label144.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label144.setHorizontalAlignment(SwingConstants.CENTER);
                                            label144.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label144, CC.xy(4, 5));

                                            //---- label145 ----
                                            label145.setText("4.25\u20ac");
                                            label145.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label145.setHorizontalAlignment(SwingConstants.CENTER);
                                            label145.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label145, CC.xy(5, 5));

                                            //---- btnBurzaObjednatObed4 ----
                                            btnBurzaObjednatObed4.setText("Objedna\u0165");
                                            btnBurzaObjednatObed4.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnBurzaObjednatObed4.setBorder(null);
                                            btnBurzaObjednatObed4.setkStartColor(new Color(73, 196, 174));
                                            btnBurzaObjednatObed4.setkEndColor(new Color(140, 219, 145));
                                            btnBurzaObjednatObed4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnBurzaObjednatObed4.setkHoverEndColor(new Color(73, 196, 174));
                                            btnBurzaObjednatObed4.setkHoverStartColor(new Color(52, 188, 183));
                                            btnBurzaObjednatObed4.setkHoverForeGround(Color.white);
                                            btnBurzaObjednatObed4.setBackground(Color.white);
                                            btnBurzaObjednatObed4.setBorderPainted(false);
                                            panelTableBurzaObed.add(btnBurzaObjednatObed4, new CellConstraints(6, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));

                                            //---- label146 ----
                                            label146.setText("5.");
                                            label146.setHorizontalAlignment(SwingConstants.CENTER);
                                            label146.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label146.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label146, CC.xy(1, 6));

                                            //---- label147 ----
                                            label147.setText("\u0160unkov\u00e1 bageta");
                                            label147.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            label147.setHorizontalAlignment(SwingConstants.CENTER);
                                            label147.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label147, CC.xy(2, 6));

                                            //---- label148 ----
                                            label148.setText("Nie");
                                            label148.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label148.setHorizontalAlignment(SwingConstants.CENTER);
                                            label148.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label148, CC.xy(3, 6));

                                            //---- label149 ----
                                            label149.setText("0x");
                                            label149.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                            label149.setHorizontalAlignment(SwingConstants.CENTER);
                                            label149.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label149, CC.xy(4, 6));

                                            //---- label150 ----
                                            label150.setText("1.50\u20ac");
                                            label150.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
                                            label150.setHorizontalAlignment(SwingConstants.CENTER);
                                            label150.setBorder(new MatteBorder(0, 0, 1, 0, new Color(55, 55, 55)));
                                            panelTableBurzaObed.add(label150, CC.xy(5, 6));

                                            //---- btnBurzaObjednatObed5 ----
                                            btnBurzaObjednatObed5.setText("Objedna\u0165");
                                            btnBurzaObjednatObed5.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
                                            btnBurzaObjednatObed5.setBorder(null);
                                            btnBurzaObjednatObed5.setkStartColor(new Color(73, 196, 174));
                                            btnBurzaObjednatObed5.setkEndColor(new Color(140, 219, 145));
                                            btnBurzaObjednatObed5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnBurzaObjednatObed5.setkHoverEndColor(new Color(73, 196, 174));
                                            btnBurzaObjednatObed5.setkHoverStartColor(new Color(52, 188, 183));
                                            btnBurzaObjednatObed5.setkHoverForeGround(Color.white);
                                            btnBurzaObjednatObed5.setBackground(Color.white);
                                            btnBurzaObjednatObed5.setBorderPainted(false);
                                            panelTableBurzaObed.add(btnBurzaObjednatObed5, new CellConstraints(6, 6, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 10, 10, 1)));
                                            panelTableBurzaObed.add(label151, CC.xy(1, 8));
                                        }
                                        panelBurzaObed.add(panelTableBurzaObed, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelContentBurza.add(panelBurzaObed, "burzaObed");
                                }
                                splitPane4.setBottomComponent(panelContentBurza);
                            }

                            GroupLayout panelBurzaLayout = new GroupLayout(panelBurza);
                            panelBurza.setLayout(panelBurzaLayout);
                            panelBurzaLayout.setHorizontalGroup(
                                panelBurzaLayout.createParallelGroup()
                                    .addComponent(splitPane4)
                            );
                            panelBurzaLayout.setVerticalGroup(
                                panelBurzaLayout.createParallelGroup()
                                    .addComponent(splitPane4, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                            );
                        }
                        panelContent.add(panelBurza, "burza");

                        //======== panelUcet ========
                        {
                            panelUcet.setkEndColor(Color.white);
                            panelUcet.setkStartColor(Color.white);

                            //======== splitPane5 ========
                            {
                                splitPane5.setBorder(null);
                                splitPane5.setDividerSize(0);
                                splitPane5.setOrientation(JSplitPane.VERTICAL_SPLIT);
                                splitPane5.setDividerLocation(40);

                                //======== panelUcetMenu ========
                                {
                                    panelUcetMenu.setkStartColor(new Color(55, 55, 55));
                                    panelUcetMenu.setkEndColor(new Color(55, 55, 55));
                                    panelUcetMenu.setkBorderRadius(0);
                                    panelUcetMenu.setBackground(new Color(55, 55, 55));
                                    panelUcetMenu.setkGradientFocus(700);
                                    panelUcetMenu.setForeground(new Color(55, 55, 55));
                                    panelUcetMenu.setLayout(new FormLayout(
                                        "2*(default, $lcgap), default",
                                        "fill:default"));

                                    //---- btnMenuDobitUcet ----
                                    btnMenuDobitUcet.setText("Dobi\u0165 \u00fa\u010det");
                                    btnMenuDobitUcet.setBorder(null);
                                    btnMenuDobitUcet.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                    btnMenuDobitUcet.setkStartColor(Color.darkGray);
                                    btnMenuDobitUcet.setkEndColor(Color.darkGray);
                                    btnMenuDobitUcet.setkBorderRadius(0);
                                    btnMenuDobitUcet.setkAllowTab(true);
                                    btnMenuDobitUcet.setkHoverEndColor(new Color(70, 70, 70));
                                    btnMenuDobitUcet.setkHoverStartColor(new Color(70, 70, 70));
                                    btnMenuDobitUcet.setkIndicatorColor(new Color(38, 184, 190));
                                    btnMenuDobitUcet.setkIndicatorThickness(0);
                                    btnMenuDobitUcet.setkBackGroundColor(Color.white);
                                    btnMenuDobitUcet.setkSelectedColor(new Color(67, 67, 67));
                                    btnMenuDobitUcet.setkHoverForeGround(Color.white);
                                    btnMenuDobitUcet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                    btnMenuDobitUcet.setVerticalAlignment(SwingConstants.TOP);
                                    btnMenuDobitUcet.addActionListener(e -> {
			btnRanajkyActionPerformed();
			btnBurzaRanajkyActionPerformed();
			btnMenuDobitUcetActionPerformed();
		});
                                    panelUcetMenu.add(btnMenuDobitUcet, CC.xy(1, 1));

                                    //---- btnMenuVybratZUctu ----
                                    btnMenuVybratZUctu.setText("Vybra\u0165 z \u00fa\u010dtu");
                                    btnMenuVybratZUctu.setBorder(null);
                                    btnMenuVybratZUctu.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                    btnMenuVybratZUctu.setkStartColor(Color.darkGray);
                                    btnMenuVybratZUctu.setkEndColor(Color.darkGray);
                                    btnMenuVybratZUctu.setkBorderRadius(0);
                                    btnMenuVybratZUctu.setkAllowTab(true);
                                    btnMenuVybratZUctu.setkHoverEndColor(new Color(70, 70, 70));
                                    btnMenuVybratZUctu.setkHoverStartColor(new Color(70, 70, 70));
                                    btnMenuVybratZUctu.setkIndicatorColor(new Color(38, 184, 190));
                                    btnMenuVybratZUctu.setkIndicatorThickness(0);
                                    btnMenuVybratZUctu.setkBackGroundColor(Color.white);
                                    btnMenuVybratZUctu.setkSelectedColor(new Color(67, 67, 67));
                                    btnMenuVybratZUctu.setkHoverForeGround(Color.white);
                                    btnMenuVybratZUctu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                    btnMenuVybratZUctu.setVerticalAlignment(SwingConstants.TOP);
                                    btnMenuVybratZUctu.addActionListener(e -> {
			btnObedActionPerformed();
			btnBurzaObedActionPerformed();
			btnMenuVybratZUctuActionPerformed();
		});
                                    panelUcetMenu.add(btnMenuVybratZUctu, CC.xy(3, 1));

                                    //---- btnMenuHistoriaTranskacii ----
                                    btnMenuHistoriaTranskacii.setText("Hist\u00f3ria transakci\u00ed");
                                    btnMenuHistoriaTranskacii.setBorder(null);
                                    btnMenuHistoriaTranskacii.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                    btnMenuHistoriaTranskacii.setkStartColor(Color.darkGray);
                                    btnMenuHistoriaTranskacii.setkEndColor(Color.darkGray);
                                    btnMenuHistoriaTranskacii.setkBorderRadius(0);
                                    btnMenuHistoriaTranskacii.setkAllowTab(true);
                                    btnMenuHistoriaTranskacii.setkHoverEndColor(new Color(70, 70, 70));
                                    btnMenuHistoriaTranskacii.setkHoverStartColor(new Color(70, 70, 70));
                                    btnMenuHistoriaTranskacii.setkIndicatorColor(new Color(38, 184, 190));
                                    btnMenuHistoriaTranskacii.setkIndicatorThickness(0);
                                    btnMenuHistoriaTranskacii.setkBackGroundColor(Color.white);
                                    btnMenuHistoriaTranskacii.setkSelectedColor(new Color(67, 67, 67));
                                    btnMenuHistoriaTranskacii.setkHoverForeGround(Color.white);
                                    btnMenuHistoriaTranskacii.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                    btnMenuHistoriaTranskacii.setVerticalAlignment(SwingConstants.TOP);
                                    btnMenuHistoriaTranskacii.addActionListener(e -> {
			btnObedActionPerformed();
			btnBurzaObedActionPerformed();
			btnHistoriaTranskaciiActionPerformed();
		});
                                    panelUcetMenu.add(btnMenuHistoriaTranskacii, CC.xy(5, 1));
                                }
                                splitPane5.setTopComponent(panelUcetMenu);

                                //======== panelContentUcet ========
                                {
                                    panelContentUcet.setkStartColor(Color.white);
                                    panelContentUcet.setkEndColor(Color.white);
                                    panelContentUcet.setLayout(new CardLayout());

                                    //======== panelDobitUcet ========
                                    {
                                        panelDobitUcet.setkEndColor(new Color(38, 184, 190, 24));
                                        panelDobitUcet.setkStartColor(new Color(38, 184, 190, 24));
                                        panelDobitUcet.setkBorderRadius(0);
                                        panelDobitUcet.setkGradientFocus(600);
                                        panelDobitUcet.setBorder(null);
                                        panelDobitUcet.setBackground(Color.white);
                                        panelDobitUcet.setkFillBackground(false);
                                        panelDobitUcet.setLayout(new GridBagLayout());
                                        ((GridBagLayout)panelDobitUcet.getLayout()).columnWidths = new int[] {315};

                                        //======== panelDobitUcetInside ========
                                        {
                                            panelDobitUcetInside.setkStartColor(Color.white);
                                            panelDobitUcetInside.setkEndColor(Color.white);
                                            panelDobitUcetInside.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));
                                            panelDobitUcetInside.setkBorderRadius(0);
                                            panelDobitUcetInside.setLayout(new FormLayout(
                                                "[319px,pref]",
                                                "fill:[58px,pref], fill:[56px,pref], fill:[55px,pref]"));

                                            //---- labelDobitieUctu ----
                                            labelDobitieUctu.setText("Dobitie \u00fa\u010dtu");
                                            labelDobitieUctu.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelDobitieUctu.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
                                            panelDobitUcetInside.add(labelDobitieUctu, new CellConstraints(1, 1, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(10, 0, 0, 0)));

                                            //---- txtFieldDobitSuma ----
                                            txtFieldDobitSuma.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                                            txtFieldDobitSuma.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                                            txtFieldDobitSuma.setHorizontalAlignment(SwingConstants.CENTER);
                                            txtFieldDobitSuma.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            txtFieldDobitSuma.setText("Suma ");
                                            txtFieldDobitSuma.setForeground(Color.lightGray);
                                            panelDobitUcetInside.add(txtFieldDobitSuma, new CellConstraints(1, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(2, 45, 15, 45)));

                                            //---- btnDobitUcet ----
                                            btnDobitUcet.setText("Dobi\u0165 \u00fa\u010det");
                                            btnDobitUcet.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            btnDobitUcet.setBorder(null);
                                            btnDobitUcet.setkStartColor(new Color(73, 196, 174));
                                            btnDobitUcet.setkEndColor(new Color(140, 219, 145));
                                            btnDobitUcet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnDobitUcet.setkHoverEndColor(new Color(73, 196, 174));
                                            btnDobitUcet.setkHoverStartColor(new Color(52, 188, 183));
                                            btnDobitUcet.setkHoverForeGround(Color.white);
                                            btnDobitUcet.setBackground(Color.white);
                                            btnDobitUcet.setBorderPainted(false);
                                            btnDobitUcet.setMaximumSize(new Dimension(97, 24));
                                            btnDobitUcet.setMinimumSize(new Dimension(97, 24));
                                            panelDobitUcetInside.add(btnDobitUcet, new CellConstraints(1, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 100, 15, 100)));
                                        }
                                        panelDobitUcet.add(panelDobitUcetInside, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelContentUcet.add(panelDobitUcet, "dobitUcet");

                                    //======== panelVybratZUctu ========
                                    {
                                        panelVybratZUctu.setkBorderRadius(0);
                                        panelVybratZUctu.setkEndColor(Color.white);
                                        panelVybratZUctu.setkStartColor(Color.white);
                                        panelVybratZUctu.setLayout(new GridBagLayout());

                                        //======== panelVyberZUctuInside ========
                                        {
                                            panelVyberZUctuInside.setkStartColor(Color.white);
                                            panelVyberZUctuInside.setkEndColor(Color.white);
                                            panelVyberZUctuInside.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));
                                            panelVyberZUctuInside.setkBorderRadius(0);
                                            panelVyberZUctuInside.setLayout(new FormLayout(
                                                "[319px,pref]",
                                                "fill:[58px,pref], fill:[56px,pref], fill:[55px,pref]"));

                                            //---- labelVyberZUctu ----
                                            labelVyberZUctu.setText("V\u00fdber z \u00fa\u010dtu");
                                            labelVyberZUctu.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelVyberZUctu.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
                                            panelVyberZUctuInside.add(labelVyberZUctu, new CellConstraints(1, 1, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(10, 0, 0, 0)));

                                            //---- txtFieldVyberSuma ----
                                            txtFieldVyberSuma.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                                            txtFieldVyberSuma.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                                            txtFieldVyberSuma.setHorizontalAlignment(SwingConstants.CENTER);
                                            txtFieldVyberSuma.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            txtFieldVyberSuma.setText("Suma ");
                                            txtFieldVyberSuma.setForeground(Color.lightGray);
                                            panelVyberZUctuInside.add(txtFieldVyberSuma, new CellConstraints(1, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(2, 45, 15, 45)));

                                            //---- btnVybratZUctu ----
                                            btnVybratZUctu.setText("Vybra\u0165 z \u00fa\u010dtu");
                                            btnVybratZUctu.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            btnVybratZUctu.setBorder(null);
                                            btnVybratZUctu.setkStartColor(new Color(73, 196, 174));
                                            btnVybratZUctu.setkEndColor(new Color(140, 219, 145));
                                            btnVybratZUctu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnVybratZUctu.setkHoverEndColor(new Color(73, 196, 174));
                                            btnVybratZUctu.setkHoverStartColor(new Color(52, 188, 183));
                                            btnVybratZUctu.setkHoverForeGround(Color.white);
                                            btnVybratZUctu.setBackground(Color.white);
                                            btnVybratZUctu.setBorderPainted(false);
                                            btnVybratZUctu.setMaximumSize(new Dimension(97, 24));
                                            btnVybratZUctu.setMinimumSize(new Dimension(97, 24));
                                            btnVybratZUctu.setHorizontalAlignment(SwingConstants.RIGHT);
                                            btnVybratZUctu.addActionListener(e -> btnVybratZUctuActionPerformed());
                                            panelVyberZUctuInside.add(btnVybratZUctu, new CellConstraints(1, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 95, 15, 95)));
                                        }
                                        panelVybratZUctu.add(panelVyberZUctuInside, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelContentUcet.add(panelVybratZUctu, "vybratZUctu");

                                    //======== panelHistoriaTrans ========
                                    {
                                        panelHistoriaTrans.setkEndColor(new Color(38, 184, 190, 24));
                                        panelHistoriaTrans.setkStartColor(new Color(38, 184, 190, 24));
                                        panelHistoriaTrans.setkBorderRadius(0);
                                        panelHistoriaTrans.setkGradientFocus(600);
                                        panelHistoriaTrans.setBorder(null);
                                        panelHistoriaTrans.setBackground(Color.white);
                                        panelHistoriaTrans.setkFillBackground(false);

                                        GroupLayout panelHistoriaTransLayout = new GroupLayout(panelHistoriaTrans);
                                        panelHistoriaTrans.setLayout(panelHistoriaTransLayout);
                                        panelHistoriaTransLayout.setHorizontalGroup(
                                            panelHistoriaTransLayout.createParallelGroup()
                                                .addGap(0, 833, Short.MAX_VALUE)
                                        );
                                        panelHistoriaTransLayout.setVerticalGroup(
                                            panelHistoriaTransLayout.createParallelGroup()
                                                .addGap(0, 455, Short.MAX_VALUE)
                                        );
                                    }
                                    panelContentUcet.add(panelHistoriaTrans, "historiaTrans");

                                    //======== panelHeslo ========
                                    {
                                        panelHeslo.setkEndColor(Color.white);
                                        panelHeslo.setkStartColor(Color.white);
                                        panelHeslo.setLayout(new GridBagLayout());

                                        //======== panelHesloInside ========
                                        {
                                            panelHesloInside.setkStartColor(Color.white);
                                            panelHesloInside.setkEndColor(Color.white);
                                            panelHesloInside.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));
                                            panelHesloInside.setkBorderRadius(0);
                                            panelHesloInside.setLayout(new FormLayout(
                                                "[319px,pref]",
                                                "fill:[108px,pref], fill:[56px,pref], fill:[55px,pref]"));

                                            //---- labelLockIcon ----
                                            labelLockIcon.setHorizontalAlignment(SwingConstants.CENTER);
                                            labelLockIcon.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
                                            labelLockIcon.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_lock_80px_2.png"));
                                            panelHesloInside.add(labelLockIcon, new CellConstraints(1, 1, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 0, 0, 0)));

                                            //---- passwordHesloInside ----
                                            passwordHesloInside.setHorizontalAlignment(SwingConstants.CENTER);
                                            passwordHesloInside.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                                            passwordHesloInside.setText("Heslo");
                                            passwordHesloInside.setForeground(Color.lightGray);
                                            passwordHesloInside.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                            passwordHesloInside.addFocusListener(new FocusAdapter() {
                                                @Override
                                                public void focusGained(FocusEvent e) {
                                                    passwordStareHesloFocusGained();
                                                    passwordAdminFocusGained();
                                                    passwordHesloInsideFocusGained();
                                                }
                                                @Override
                                                public void focusLost(FocusEvent e) {
                                                    passwordStareHesloFocusLost();
                                                    passwordAdminFocusLost();
                                                    passwordHesloInsideFocusLost();
                                                }
                                            });
                                            panelHesloInside.add(passwordHesloInside, new CellConstraints(1, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(2, 35, 15, 35)));

                                            //---- btnPotvrditHesloInside ----
                                            btnPotvrditHesloInside.setText("Potvrdi\u0165");
                                            btnPotvrditHesloInside.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                            btnPotvrditHesloInside.setBorder(null);
                                            btnPotvrditHesloInside.setkStartColor(new Color(73, 196, 174));
                                            btnPotvrditHesloInside.setkEndColor(new Color(140, 219, 145));
                                            btnPotvrditHesloInside.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                            btnPotvrditHesloInside.setkHoverEndColor(new Color(73, 196, 174));
                                            btnPotvrditHesloInside.setkHoverStartColor(new Color(52, 188, 183));
                                            btnPotvrditHesloInside.setkHoverForeGround(Color.white);
                                            btnPotvrditHesloInside.setBackground(Color.white);
                                            btnPotvrditHesloInside.setBorderPainted(false);
                                            btnPotvrditHesloInside.setMaximumSize(new Dimension(97, 24));
                                            btnPotvrditHesloInside.setMinimumSize(new Dimension(97, 24));
                                            btnPotvrditHesloInside.setHorizontalAlignment(SwingConstants.RIGHT);
                                            panelHesloInside.add(btnPotvrditHesloInside, new CellConstraints(1, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(4, 110, 20, 110)));
                                        }
                                        panelHeslo.add(panelHesloInside, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 0, 0));
                                    }
                                    panelContentUcet.add(panelHeslo, "heslo");
                                }
                                splitPane5.setBottomComponent(panelContentUcet);
                            }

                            GroupLayout panelUcetLayout = new GroupLayout(panelUcet);
                            panelUcet.setLayout(panelUcetLayout);
                            panelUcetLayout.setHorizontalGroup(
                                panelUcetLayout.createParallelGroup()
                                    .addComponent(splitPane5)
                            );
                            panelUcetLayout.setVerticalGroup(
                                panelUcetLayout.createParallelGroup()
                                    .addComponent(splitPane5, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                            );
                        }
                        panelContent.add(panelUcet, "ucet");

                        //======== panelZmenitHeslo ========
                        {
                            panelZmenitHeslo.setkEndColor(Color.white);
                            panelZmenitHeslo.setkStartColor(Color.white);
                            panelZmenitHeslo.setLayout(new GridBagLayout());

                            //======== PanelZmenitHesloInside ========
                            {
                                PanelZmenitHesloInside.setkStartColor(Color.white);
                                PanelZmenitHesloInside.setkEndColor(Color.white);
                                PanelZmenitHesloInside.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));
                                PanelZmenitHesloInside.setkBorderRadius(0);
                                PanelZmenitHesloInside.setLayout(new FormLayout(
                                    "[319px,pref]",
                                    "fill:38dlu, 4*(fill:60px)"));

                                //---- labelZmenaHesla ----
                                labelZmenaHesla.setText("Zmena hesla");
                                labelZmenaHesla.setHorizontalAlignment(SwingConstants.CENTER);
                                labelZmenaHesla.setFont(new Font("Yu Gothic UI", Font.BOLD, 26));
                                PanelZmenitHesloInside.add(labelZmenaHesla, new CellConstraints(1, 1, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(12, 0, 0, 0)));

                                //---- passwordStareHeslo ----
                                passwordStareHeslo.setHorizontalAlignment(SwingConstants.CENTER);
                                passwordStareHeslo.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                                passwordStareHeslo.setText("Star\u00e9 heslo");
                                passwordStareHeslo.setForeground(Color.lightGray);
                                passwordStareHeslo.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                passwordStareHeslo.addFocusListener(new FocusAdapter() {
                                    @Override
                                    public void focusGained(FocusEvent e) {
                                        passwordStareHesloFocusGained();
                                    }
                                    @Override
                                    public void focusLost(FocusEvent e) {
                                        passwordStareHesloFocusLost();
                                    }
                                });
                                PanelZmenitHesloInside.add(passwordStareHeslo, new CellConstraints(1, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(6, 35, 10, 35)));

                                //---- passwordNoveHeslo ----
                                passwordNoveHeslo.setHorizontalAlignment(SwingConstants.CENTER);
                                passwordNoveHeslo.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                                passwordNoveHeslo.setText("Nov\u00e9 heslo");
                                passwordNoveHeslo.setForeground(Color.lightGray);
                                passwordNoveHeslo.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                passwordNoveHeslo.addFocusListener(new FocusAdapter() {
                                    @Override
                                    public void focusGained(FocusEvent e) {
                                        passwordNoveHesloFocusGained();
                                    }
                                    @Override
                                    public void focusLost(FocusEvent e) {
                                        passwordNoveHesloFocusLost();
                                    }
                                });
                                PanelZmenitHesloInside.add(passwordNoveHeslo, new CellConstraints(1, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(6, 35, 10, 35)));

                                //---- passwordNovHesloPotvrdenie ----
                                passwordNovHesloPotvrdenie.setHorizontalAlignment(SwingConstants.CENTER);
                                passwordNovHesloPotvrdenie.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                                passwordNovHesloPotvrdenie.setText("Potvrdenie hesla");
                                passwordNovHesloPotvrdenie.setForeground(Color.lightGray);
                                passwordNovHesloPotvrdenie.setFont(new Font("Yu Gothic UI", Font.BOLD, 19));
                                passwordNovHesloPotvrdenie.addFocusListener(new FocusAdapter() {
                                    @Override
                                    public void focusGained(FocusEvent e) {
                                        passwordNovHesloPotvrdenieFocusGained();
                                    }
                                    @Override
                                    public void focusLost(FocusEvent e) {
                                        passwordNovHesloPotvrdenieFocusLost();
                                    }
                                });
                                PanelZmenitHesloInside.add(passwordNovHesloPotvrdenie, new CellConstraints(1, 4, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(6, 35, 10, 35)));

                                //---- btnZmenitHesloInside ----
                                btnZmenitHesloInside.setText("Zmeni\u0165 heslo");
                                btnZmenitHesloInside.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                btnZmenitHesloInside.setBorder(null);
                                btnZmenitHesloInside.setkStartColor(new Color(73, 196, 174));
                                btnZmenitHesloInside.setkEndColor(new Color(140, 219, 145));
                                btnZmenitHesloInside.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                btnZmenitHesloInside.setkHoverEndColor(new Color(73, 196, 174));
                                btnZmenitHesloInside.setkHoverStartColor(new Color(52, 188, 183));
                                btnZmenitHesloInside.setkHoverForeGround(Color.white);
                                btnZmenitHesloInside.setBackground(Color.white);
                                btnZmenitHesloInside.setBorderPainted(false);
                                btnZmenitHesloInside.setMaximumSize(new Dimension(97, 24));
                                btnZmenitHesloInside.setMinimumSize(new Dimension(97, 24));
                                PanelZmenitHesloInside.add(btnZmenitHesloInside, new CellConstraints(1, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(10, 99, 17, 98)));
                            }
                            panelZmenitHeslo.add(PanelZmenitHesloInside, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                        }
                        panelContent.add(panelZmenitHeslo, "zmenitHeslo");

                        //======== panelOdhlasitSa ========
                        {
                            panelOdhlasitSa.setkEndColor(Color.white);
                            panelOdhlasitSa.setkStartColor(Color.white);
                            panelOdhlasitSa.setLayout(new GridBagLayout());

                            //======== panelOdhlasitSaInside ========
                            {
                                panelOdhlasitSaInside.setkStartColor(Color.white);
                                panelOdhlasitSaInside.setkEndColor(Color.white);
                                panelOdhlasitSaInside.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));
                                panelOdhlasitSaInside.setkBorderRadius(0);
                                panelOdhlasitSaInside.setLayout(new FormLayout(
                                    "[369px,pref]",
                                    "fill:[58px,pref], fill:[55px,pref]"));

                                //---- labelNaozajSaChceteOdhlasit ----
                                labelNaozajSaChceteOdhlasit.setText("Naozaj sa chcete odhl\u00e1si\u0165?");
                                labelNaozajSaChceteOdhlasit.setHorizontalAlignment(SwingConstants.CENTER);
                                labelNaozajSaChceteOdhlasit.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
                                panelOdhlasitSaInside.add(labelNaozajSaChceteOdhlasit, CC.xy(1, 1));

                                //---- btnOdhlasitSaInside ----
                                btnOdhlasitSaInside.setText("Odhl\u00e1si\u0165 sa");
                                btnOdhlasitSaInside.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                btnOdhlasitSaInside.setBorder(null);
                                btnOdhlasitSaInside.setkStartColor(new Color(73, 196, 174));
                                btnOdhlasitSaInside.setkEndColor(new Color(140, 219, 145));
                                btnOdhlasitSaInside.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                btnOdhlasitSaInside.setkHoverEndColor(new Color(73, 196, 174));
                                btnOdhlasitSaInside.setkHoverStartColor(new Color(52, 188, 183));
                                btnOdhlasitSaInside.setkHoverForeGround(Color.white);
                                btnOdhlasitSaInside.setBackground(Color.white);
                                btnOdhlasitSaInside.setBorderPainted(false);
                                btnOdhlasitSaInside.setMaximumSize(new Dimension(97, 24));
                                btnOdhlasitSaInside.setMinimumSize(new Dimension(97, 24));
                                panelOdhlasitSaInside.add(btnOdhlasitSaInside, new CellConstraints(1, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(7, 127, 15, 127)));
                            }
                            panelOdhlasitSa.add(panelOdhlasitSaInside, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                        }
                        panelContent.add(panelOdhlasitSa, "odhlasitSa");

                        //======== panelAdmin ========
                        {
                            panelAdmin.setkEndColor(Color.white);
                            panelAdmin.setkStartColor(Color.white);
                            panelAdmin.setLayout(new GridBagLayout());

                            //======== panelAdminInside ========
                            {
                                panelAdminInside.setkStartColor(Color.white);
                                panelAdminInside.setkEndColor(Color.white);
                                panelAdminInside.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));
                                panelAdminInside.setkBorderRadius(0);
                                panelAdminInside.setLayout(new FormLayout(
                                    "[319px,pref]",
                                    "fill:[108px,pref], fill:[56px,pref], fill:[55px,pref]"));

                                //---- labelAdminIcon ----
                                labelAdminIcon.setHorizontalAlignment(SwingConstants.CENTER);
                                labelAdminIcon.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
                                labelAdminIcon.setIcon(new ImageIcon("C:\\Learn2Code\\MyApps\\stravovaci-system-2\\src\\main\\resources\\icons\\icons8_user_shield_85px_1.png"));
                                panelAdminInside.add(labelAdminIcon, new CellConstraints(1, 1, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(9, 0, 0, 0)));

                                //---- passwordAdmin ----
                                passwordAdmin.setHorizontalAlignment(SwingConstants.CENTER);
                                passwordAdmin.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
                                passwordAdmin.setText("Pr\u00edstupov\u00e9 heslo");
                                passwordAdmin.setForeground(Color.lightGray);
                                passwordAdmin.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                                passwordAdmin.addFocusListener(new FocusAdapter() {
                                    @Override
                                    public void focusGained(FocusEvent e) {
                                        passwordStareHesloFocusGained();
                                        passwordAdminFocusGained();
                                    }
                                    @Override
                                    public void focusLost(FocusEvent e) {
                                        passwordStareHesloFocusLost();
                                        passwordAdminFocusLost();
                                    }
                                });
                                panelAdminInside.add(passwordAdmin, new CellConstraints(1, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(2, 35, 15, 35)));

                                //---- btnPotvrditHesloAdmin ----
                                btnPotvrditHesloAdmin.setText("Potvrdi\u0165");
                                btnPotvrditHesloAdmin.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
                                btnPotvrditHesloAdmin.setBorder(null);
                                btnPotvrditHesloAdmin.setkStartColor(new Color(73, 196, 174));
                                btnPotvrditHesloAdmin.setkEndColor(new Color(140, 219, 145));
                                btnPotvrditHesloAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                btnPotvrditHesloAdmin.setkHoverEndColor(new Color(73, 196, 174));
                                btnPotvrditHesloAdmin.setkHoverStartColor(new Color(52, 188, 183));
                                btnPotvrditHesloAdmin.setkHoverForeGround(Color.white);
                                btnPotvrditHesloAdmin.setBackground(Color.white);
                                btnPotvrditHesloAdmin.setBorderPainted(false);
                                btnPotvrditHesloAdmin.setMaximumSize(new Dimension(97, 24));
                                btnPotvrditHesloAdmin.setMinimumSize(new Dimension(97, 24));
                                btnPotvrditHesloAdmin.setHorizontalAlignment(SwingConstants.RIGHT);
                                panelAdminInside.add(btnPotvrditHesloAdmin, new CellConstraints(1, 3, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(4, 110, 20, 110)));
                            }
                            panelAdmin.add(panelAdminInside, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                        }
                        panelContent.add(panelAdmin, "admin");
                    }
                    splitPane2.setBottomComponent(panelContent);
                }

                GroupLayout panelRightSideLayout = new GroupLayout(panelRightSide);
                panelRightSide.setLayout(panelRightSideLayout);
                panelRightSideLayout.setHorizontalGroup(
                    panelRightSideLayout.createParallelGroup()
                        .addComponent(splitPane2)
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
                .addComponent(splitPane1)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(splitPane1)
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik Vrbovský
    private JSplitPane splitPane1;
    private KGradientPanel panelMenu;
    private JLabel labelIcon;
    private JLabel labelUsername;
    private KButton btnObjednat;
    private KButton btnMojeObjed;
    private KButton btnBurza;
    private KButton btnUcet;
    private KButton btnZmenitHeslo;
    private KButton btnOdhlasitSa;
    private JLabel labelAccount;
    private KButton btnAdmin;
    private KGradientPanel panelRightSide;
    private JSplitPane splitPane2;
    private KGradientPanel panelStravovaciSystem;
    private JLabel labelStravovaciSystem;
    private JLabel labelDatum;
    private JLabel labelX;
    private JLabel label4;
    private KGradientPanel panelContent;
    private KGradientPanel panelObjednat;
    private JSplitPane splitPane3;
    private KGradientPanel panelMenuObjednat;
    private KButton btnRanajky;
    private KButton btnObed;
    private KGradientPanel panelContentObjednat;
    private KGradientPanel panelRanajky;
    private KGradientPanel panelTableRanajky;
    private JLabel label36;
    private JLabel label1;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label37;
    private JLabel label46;
    private JLabel labelObjednatRanajkyNazov1;
    private JLabel labelObjednatRanajkyNapoj1;
    private JLabel labelObjednatRanajkyKapacita1;
    private JLabel labelObjednatRanajkyCena1;
    private KButton btnObjednatRanajky1;
    private JLabel label32;
    private JLabel labelObjednatRanajkyNazov2;
    private JLabel labelObjednatRanajkyNapoj2;
    private JLabel labelObjednatRanajkyKapacita2;
    private JLabel labelObjednatRanajkyCena2;
    private KButton btnObjednatRanajky2;
    private JLabel label33;
    private JLabel labelObjednatRanajkyNazov3;
    private JLabel labelObjednatRanajkyNapoj3;
    private JLabel labelObjednatRanajkyKapacita3;
    private JLabel labelObjednatRanajkyCena3;
    private KButton btnObjednatRanajky3;
    private JLabel label34;
    private JLabel labelObjednatRanajkyNazov4;
    private JLabel labelObjednatRanajkyNapoj4;
    private JLabel labelObjednatRanajkyKapacita4;
    private JLabel labelObjednatRanajkyCena4;
    private KButton btnObjednatRanajky4;
    private JLabel label35;
    private JLabel labelObjednatRanajkyNazov5;
    private JLabel labelObjednatRanajkyNapoj5;
    private JLabel labelObjednatRanajkyKapacita5;
    private JLabel labelObjednatRanajkyCena5;
    private KButton btnObjednatRanajky5;
    private JLabel labelObjednatRanajkyWarning;
    private KGradientPanel panelObed;
    private KGradientPanel panelTableObed;
    private JLabel label38;
    private JLabel label21;
    private JLabel label24;
    private JLabel label39;
    private JLabel label40;
    private JLabel label41;
    private JLabel label47;
    private JLabel labelObjednatObedNazov1;
    private JLabel labelObjednatObedTakeaway1;
    private JLabel labelObjednatObedKapacita1;
    private JLabel labelObjednatObedCena1;
    private KButton btnObjednatObed1;
    private JLabel label45;
    private JLabel labelObjednatObedNazov2;
    private JLabel labelObjednatObedTakeaway2;
    private JLabel labelObjednatObedKapacita2;
    private JLabel labelObjednatObedCena2;
    private KButton btnObjednatObed2;
    private JLabel label54;
    private JLabel labelObjednatObedNazov3;
    private JLabel labelObjednatObedTakeaway3;
    private JLabel labelObjednatObedKapacita3;
    private JLabel labelObjednatObedCena3;
    private KButton btnObjednatObed3;
    private JLabel label60;
    private JLabel labelObjednatObedNazov4;
    private JLabel labelObjednatObedTakeaway4;
    private JLabel labelObjednatObedKapacita4;
    private JLabel labelObjednatObedCena4;
    private KButton btnObjednatObed4;
    private JLabel label65;
    private JLabel labelObjednatObedNazov5;
    private JLabel labelObjednatObedTakeaway5;
    private JLabel labelObjednatObedKapacita5;
    private JLabel labelObjednatObedCena5;
    private KButton btnObjednatObed5;
    private JLabel labelObjednatObedWarning;
    private KGradientPanel panelMojeObjednavky;
    private KGradientPanel panelTableMojeObjRanajky;
    private JLabel label71;
    private JLabel label73;
    private JLabel label2;
    private JLabel label74;
    private JLabel label75;
    private JLabel label76;
    private JLabel label79;
    private JLabel label77;
    private JLabel label80;
    private KButton btnDoBurzyObed;
    private KGradientPanel panelTableMojeObjednavkyObed;
    private JLabel label72;
    private JLabel label78;
    private JLabel label81;
    private JLabel label82;
    private JLabel label83;
    private JLabel label84;
    private JLabel label85;
    private JLabel label86;
    private JLabel label87;
    private KButton btnDoBurzyRanajky;
    private JLabel label88;
    private KGradientPanel panelBurza;
    private JSplitPane splitPane4;
    private KGradientPanel panelMenuBurza;
    private KButton btnBurzaRanajky;
    private KButton btnBurzaObed;
    private KGradientPanel panelContentBurza;
    private KGradientPanel panelBurzaRanajky;
    private KGradientPanel panelTableBurzaRanajky;
    private JLabel label89;
    private JLabel label3;
    private JLabel label90;
    private JLabel label91;
    private JLabel label92;
    private JLabel label93;
    private JLabel label94;
    private JLabel label95;
    private JLabel label96;
    private JLabel label97;
    private JLabel label98;
    private KButton btnBurzaRanajky1;
    private JLabel label99;
    private JLabel label100;
    private JLabel label101;
    private JLabel label102;
    private JLabel label103;
    private KButton btnBurzaRanajky2;
    private JLabel label104;
    private JLabel label105;
    private JLabel label106;
    private JLabel label107;
    private JLabel label108;
    private KButton btnBurzaRanajky3;
    private JLabel label109;
    private JLabel label110;
    private JLabel label111;
    private JLabel label112;
    private JLabel label113;
    private KButton btnBurzaRanajky4;
    private JLabel label114;
    private JLabel label115;
    private JLabel label116;
    private JLabel label117;
    private JLabel label118;
    private KButton btnBurzaRanajky5;
    private JLabel label119;
    private KGradientPanel panelBurzaObed;
    private KGradientPanel panelTableBurzaObed;
    private JLabel label120;
    private JLabel label121;
    private JLabel label122;
    private JLabel label123;
    private JLabel label124;
    private JLabel label125;
    private JLabel label126;
    private JLabel label127;
    private JLabel label128;
    private JLabel label129;
    private JLabel label130;
    private KButton btnBurzaObjednatObed1;
    private JLabel label131;
    private JLabel label132;
    private JLabel label133;
    private JLabel label134;
    private JLabel label135;
    private KButton btnBurzaObjednatObed2;
    private JLabel label136;
    private JLabel label137;
    private JLabel label138;
    private JLabel label139;
    private JLabel label140;
    private KButton btnBurzaObjednatObed3;
    private JLabel label141;
    private JLabel label142;
    private JLabel label143;
    private JLabel label144;
    private JLabel label145;
    private KButton btnBurzaObjednatObed4;
    private JLabel label146;
    private JLabel label147;
    private JLabel label148;
    private JLabel label149;
    private JLabel label150;
    private KButton btnBurzaObjednatObed5;
    private JLabel label151;
    private KGradientPanel panelUcet;
    private JSplitPane splitPane5;
    private KGradientPanel panelUcetMenu;
    private KButton btnMenuDobitUcet;
    private KButton btnMenuVybratZUctu;
    private KButton btnMenuHistoriaTranskacii;
    private KGradientPanel panelContentUcet;
    private KGradientPanel panelDobitUcet;
    private KGradientPanel panelDobitUcetInside;
    private JLabel labelDobitieUctu;
    private JTextField txtFieldDobitSuma;
    private KButton btnDobitUcet;
    private KGradientPanel panelVybratZUctu;
    private KGradientPanel panelVyberZUctuInside;
    private JLabel labelVyberZUctu;
    private JTextField txtFieldVyberSuma;
    private KButton btnVybratZUctu;
    private KGradientPanel panelHistoriaTrans;
    private KGradientPanel panelHeslo;
    private KGradientPanel panelHesloInside;
    private JLabel labelLockIcon;
    private JPasswordField passwordHesloInside;
    private KButton btnPotvrditHesloInside;
    private KGradientPanel panelZmenitHeslo;
    private KGradientPanel PanelZmenitHesloInside;
    private JLabel labelZmenaHesla;
    private JPasswordField passwordStareHeslo;
    private JPasswordField passwordNoveHeslo;
    private JPasswordField passwordNovHesloPotvrdenie;
    private KButton btnZmenitHesloInside;
    private KGradientPanel panelOdhlasitSa;
    private KGradientPanel panelOdhlasitSaInside;
    private JLabel labelNaozajSaChceteOdhlasit;
    private KButton btnOdhlasitSaInside;
    private KGradientPanel panelAdmin;
    private KGradientPanel panelAdminInside;
    private JLabel labelAdminIcon;
    private JPasswordField passwordAdmin;
    private KButton btnPotvrditHesloAdmin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
