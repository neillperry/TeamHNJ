package com.mcdonalds.orderform;

import com.mcdonalds.food.*;
import com.mcdonalds.store.Store;
import com.mcdonalds.user.User;
import com.mcdonalds.order.Order;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderForm extends JFrame {
    private static String selectOption = "(select item)";
    private static String[] sizesArray = new String[] {
            "Select a Size",
            Size.SMALL.type(),
            Size.REGULAR.type(),
            Size.LARGE.type()
    };

    private double totalPrice = 0.00;

    // Business Variables
    private Store newStore;
    private User user;
    private Order order;


    // Main Tabbed Panel
    private JTabbedPane tabbedPane;
    private JPanel mainPanel;

    // Burger Panel
    private JPanel burgers;
    private JButton addOrder1;
    private JLabel totalLabel1;
    private JLabel priceLabel1;
    private JLabel logoLabel1;
    private JComboBox burgerSelBox;
    private JComboBox burgerSizeBox;
    private JLabel feedbackLabel1;
    private static String[] burgerOptions = new String[] {
            selectOption,
            EntreeType.HAMBURGER.type(),
            EntreeType.CHEESEBURGER.type(),
            EntreeType.CHICKEN_SANDWICH.type(),
            EntreeType.CHICKEN_NUGGETS.type(),
            EntreeType.MYSTERY.type()
    };


    // Sides Panel
    private JPanel sides;
    private JButton addOrder2;
    private JLabel totalLabel2;
    private JLabel priceLabel2;
    private JLabel logoLabel2;
    private JComboBox sideSelBox;
    private JComboBox sideSizeBox;
    private JLabel feedbackLabel2;
    private static String[] sideOptions = new String[] {
            selectOption,
            SideType.FRIES.type(),
            SideType.APPLE.type(),
            SideType.SALAD.type(),
            SideType.ONION_RINGS.type(),
            SideType.MOZZARELLA_STICKS.type(),
            SideType.MYSTERY.type()
    };


    // Dessert Panel
    private JPanel desserts;
    private JButton addOrder3;
    private JLabel totalLabel3;
    private JLabel priceLabel3;
    private JLabel logoLabel3;
    private JComboBox dessertSelBox;
    private JComboBox dessertSizeBox;
    private JLabel feedbackLabel3;
    private static String[] dessertOptions = new String[] {
            selectOption,
            DessertType.APPLE_PIE.type(),
            DessertType.ICE_CREAM.type(),
            DessertType.COOKIE.type(),
            DessertType.BIRTHDAY_CAKE.type(),
            DessertType.FROSTED_TATER_TOTS.type()
    };


    // Drink Panel
    private JPanel drinks;
    private JButton addOrder4;
    private JLabel totalLabel4;
    private JLabel priceLabel4;
    private JLabel logoLabel4;
    private JComboBox drinkSelBox;
    private JComboBox drinkSizeBox;
    private JLabel feedbackLabel4;
    private static String[] drinkOptions = new String[] {
            selectOption,
            DrinkType.COKE.type(),
            DrinkType.DIET_COKE.type(),
            DrinkType.SPRITE.type(),
            DrinkType.WATER.type(),
            DrinkType.ADULT_BEVERAGE.type()
    };


    // Final Order Panel
    private JPanel finalOrder;
    private JButton orderButton5;
    private JLabel totalLabel5;
    private JLabel priceLabel5;
    private JLabel logoLabel5;
    private JTextArea orderReviewTextArea;
    private JLabel reviewOrderLabel;


    public static void main(String[] args) {
        // Creates the GUI interface
        OrderForm form = new OrderForm("Welcome to McDonald's!");
        form.setVisible(true);
    }


    // create Order Form
    public OrderForm(String title) {
        super(title);
        createBusinessVariables();
        createUIComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(tabbedPane);
        this.pack();
    }


    private void createUIComponents() {
        createComboBoxes();
        createImageIcons();
        addOrderButtonListeners();
        addSizeBoxListeners();
    }

    private void createImageIcons() {
        ImageIcon mcdonaldsImage = new ImageIcon(this.getClass().getResource("../resources/mcDonaldLogo.jpg"));
        ImageIcon archesImage = new ImageIcon(this.getClass().getResource("../resources/arches.png"));
        ImageIcon cheeseBurgerImage = new ImageIcon(this.getClass().getResource("../resources/cheeseburger.png"));
        logoLabel1.setIcon(cheeseBurgerImage);
        logoLabel1.setVisible(true);

        logoLabel2.setIcon(archesImage);
        logoLabel2.setVisible(true);

        logoLabel3.setIcon(mcdonaldsImage);
        logoLabel3.setVisible(true);

        logoLabel4.setIcon(mcdonaldsImage);
        logoLabel4.setVisible(true);
    }



    private void createComboBoxes(){
        createBurgerBox();
        createSideBox();
        createDessertBox();
        createDrinkBox();
    }


    private void createBurgerBox() {
        feedbackLabel1.setVisible(false);
        feedbackLabel1.setForeground(Color.GREEN);
        feedbackLabel1.setBackground(Color.GREEN);

        burgerSelBox.addItem(burgerOptions[0]);
        burgerSelBox.addItem(burgerOptions[1]);
        burgerSelBox.addItem(burgerOptions[2]);
        burgerSelBox.addItem(burgerOptions[3]);
        burgerSelBox.addItem(burgerOptions[4]);
        burgerSelBox.addItem(burgerOptions[5]);

        burgerSelBox.setSelectedIndex(0);
        burgerSelBox.setVisible(true);
        burgerSelBox.setEditable(false);

        burgerSizeBox.addItem(sizesArray[0]);
        burgerSizeBox.addItem(sizesArray[1]);
        burgerSizeBox.addItem(sizesArray[2]);
        burgerSizeBox.addItem(sizesArray[3]);

        burgerSizeBox.setSelectedIndex(0);
        burgerSizeBox.setVisible(true);
        burgerSizeBox.setEditable(false);
    }

    private void createSideBox() {
        feedbackLabel2.setVisible(false);
        feedbackLabel2.setForeground(Color.GREEN);

        sideSelBox.addItem(sideOptions[0]);
        sideSelBox.addItem(sideOptions[1]);
        sideSelBox.addItem(sideOptions[2]);
        sideSelBox.addItem(sideOptions[3]);
        sideSelBox.addItem(sideOptions[4]);
        sideSelBox.addItem(sideOptions[5]);
        sideSelBox.addItem(sideOptions[6]);

        sideSelBox.setSelectedIndex(0);
        sideSelBox.setVisible(true);
        sideSelBox.setEditable(false);

        sideSizeBox.addItem(sizesArray[0]);
        sideSizeBox.addItem(sizesArray[1]);
        sideSizeBox.addItem(sizesArray[2]);
        sideSizeBox.addItem(sizesArray[3]);

        sideSizeBox.setSelectedIndex(0);
        sideSizeBox.setVisible(true);
        sideSizeBox.setEditable(false);

    }

    private void createDessertBox() {
        feedbackLabel3.setVisible(false);
        feedbackLabel3.setForeground(Color.GREEN);

        dessertSelBox.addItem(dessertOptions[0]);
        dessertSelBox.addItem(dessertOptions[1]);
        dessertSelBox.addItem(dessertOptions[2]);
        dessertSelBox.addItem(dessertOptions[3]);
        dessertSelBox.addItem(dessertOptions[4]);

        dessertSelBox.setSelectedIndex(0);
        dessertSelBox.setVisible(true);
        dessertSelBox.setEditable(false);

        dessertSizeBox.addItem(sizesArray[0]);
        dessertSizeBox.addItem(sizesArray[1]);
        dessertSizeBox.addItem(sizesArray[2]);
        dessertSizeBox.addItem(sizesArray[3]);

        dessertSizeBox.setSelectedIndex(0);
        dessertSizeBox.setVisible(true);
        dessertSizeBox.setEditable(false);
    }


    private void createDrinkBox() {
        feedbackLabel4.setVisible(false);
        feedbackLabel4.setForeground(Color.GREEN);

        drinkSelBox.addItem(drinkOptions[0]);
        drinkSelBox.addItem(drinkOptions[1]);
        drinkSelBox.addItem(drinkOptions[2]);
        drinkSelBox.addItem(drinkOptions[3]);
        drinkSelBox.addItem(drinkOptions[4]);

        drinkSelBox.setSelectedIndex(0);
        drinkSelBox.setVisible(true);
        drinkSelBox.setEditable(false);

        drinkSizeBox.addItem(sizesArray[0]);
        drinkSizeBox.addItem(sizesArray[1]);
        drinkSizeBox.addItem(sizesArray[2]);
        drinkSizeBox.addItem(sizesArray[3]);

        drinkSizeBox.setSelectedIndex(0);
        drinkSizeBox.setVisible(true);
        drinkSizeBox.setEditable(false);
    }


    // Hide Feeedback Label when Size Box is set to != first element
    private void addSizeBoxListeners() {
        // ENTREES
        burgerSizeBox.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (burgerSelBox.getSelectedIndex() != 0 || burgerSizeBox.getSelectedIndex() != 0) {
                    feedbackLabel1.setVisible(false);
                }
            }
        });

        // SIDES
        sideSizeBox.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sideSelBox.getSelectedIndex() != 0 || sideSizeBox.getSelectedIndex() != 0) {
                    feedbackLabel2.setVisible(false);
                }
            }
        });

        // DESSERTS
        dessertSizeBox.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dessertSelBox.getSelectedIndex() != 0 || dessertSizeBox.getSelectedIndex() != 0) {
                    feedbackLabel3.setVisible(false);
                }
            }
        });

        // DRINKS
        drinkSizeBox.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (drinkSelBox.getSelectedIndex() != 0 || drinkSizeBox.getSelectedIndex() != 0) {
                    feedbackLabel4.setVisible(false);
                }
            }
        });
    }


    // Place Order Action Listeners
    private void addOrderButtonListeners() {
        //ENTREES
        addOrder1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (burgerSelBox.getSelectedIndex() != 0 && burgerSizeBox.getSelectedIndex() != 0) {
                    updateAllPrices(1.00);
                    burgerSizeBox.setSelectedIndex(0);
                    burgerSelBox.setSelectedIndex(0);
                    feedbackLabel1.setText("Order Placed!");
                    feedbackLabel1.setVisible(true);

                    int selectedIndex = burgerSelBox.getSelectedIndex();
                    EntreeType selectedEntree = EntreeType.valueOf(burgerOptions[selectedIndex]);


                    //Entree newEntree = new Entree(burgerSelBox)
                }
            }
        });

        // SIDES
        addOrder2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sideSelBox.getSelectedIndex() != 0 && sideSizeBox.getSelectedIndex() != 0) {
                    updateAllPrices(1.50);
                    sideSizeBox.setSelectedIndex(0);
                    sideSelBox.setSelectedIndex(0);
                    feedbackLabel2.setText("Order Placed!");
                    feedbackLabel2.setVisible(true);
                } else {

                }
            }
        });

        // DESSERTS
        addOrder3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dessertSelBox.getSelectedIndex() != 0 && dessertSizeBox.getSelectedIndex() != 0) {
                    updateAllPrices(0.75);
                    dessertSizeBox.setSelectedIndex(0);
                    dessertSelBox.setSelectedIndex(0);
                    feedbackLabel3.setText("Order Placed!");
                    feedbackLabel3.setVisible(true);
                } else {

                }
            }
        });

        // DRINKS
        addOrder4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (drinkSelBox.getSelectedIndex() != 0 && drinkSizeBox.getSelectedIndex() != 0) {
                    updateAllPrices(1.15);
                    drinkSizeBox.setSelectedIndex(0);
                    drinkSelBox.setSelectedIndex(0);
                    feedbackLabel4.setText("Order Placed!");
                    feedbackLabel4.setVisible(true);
                } else {

                }
            }
        });
    }


    private void updateAllPrices(double newPrice) {
        totalPrice += newPrice;
        priceLabel1.setText(String.valueOf(totalPrice));
        priceLabel2.setText(String.valueOf(totalPrice));
        priceLabel3.setText(String.valueOf(totalPrice));
        priceLabel4.setText(String.valueOf(totalPrice));
        priceLabel5.setText(String.valueOf(totalPrice));
    }

    private void createBusinessVariables() {
        newStore = new Store();
        user = new User("Bob", 22);
        order = new Order(newStore, user);
    }

}

