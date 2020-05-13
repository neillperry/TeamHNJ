package com.mcdonalds.orderform;


import com.mcdonalds.user.User;
import com.mcdonalds.order.Order;
import com.mcdonalds.store.Store;
import com.mcdonalds.food.Size;

import com.mcdonalds.food.DessertType;
import com.mcdonalds.food.Dessert;
import com.mcdonalds.food.Entree;
import com.mcdonalds.food.EntreeType;
import com.mcdonalds.food.Side;
import com.mcdonalds.food.SideType;
import com.mcdonalds.food.Drink;
import com.mcdonalds.food.DrinkType;

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
import javax.swing.Timer;

public class OrderForm extends JFrame {
    private static final String newLine = "\n";
    private static final String space = " ";
    private static final String selectOption = "(select item)";
    private static final String itemAdded = "Item Added!";
    private static final String decimalFormat = "%.2f";
    private static final String dollarSign = "$";
    private static final String welcomeMessage = "Welcome to McDonalds!";
    private static String[] sizesArray;
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
    private static String[] burgerOptions;

    // Sides Panel
    private JPanel sides;
    private JButton addOrder2;
    private JLabel totalLabel2;
    private JLabel priceLabel2;
    private JLabel logoLabel2;
    private JComboBox sideSelBox;
    private JComboBox sideSizeBox;
    private JLabel feedbackLabel2;
    private static String[] sideOptions;

    // Dessert Panel
    private JPanel desserts;
    private JButton addOrder3;
    private JLabel totalLabel3;
    private JLabel priceLabel3;
    private JLabel logoLabel3;
    private JComboBox dessertSelBox;
    private JComboBox dessertSizeBox;
    private JLabel feedbackLabel3;
    private static String[] dessertOptions;

    // Drink Panel
    private JPanel drinks;
    private JButton addOrder4;
    private JLabel totalLabel4;
    private JLabel priceLabel4;
    private JLabel logoLabel4;
    private JComboBox drinkSelBox;
    private JComboBox drinkSizeBox;
    private JLabel feedbackLabel4;
    private static String[] drinkOptions;

    // Final Order Panel
    private JPanel finalOrder;
    private JButton orderButton5;
    private JLabel totalLabel5;
    private JLabel priceLabel5;
    private JLabel logoLabel5;
    private JTextArea orderReviewTextArea;
    private JLabel reviewOrderLabel;
    private JLabel feedbackLabel5;
    private JLabel timerLabel;
    private JLabel readyLabel;
    private int count = 120;
    private Timer timer;


    public static void main(String[] args) {
        // Creates the GUI interface
        OrderForm form = new OrderForm(welcomeMessage);
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

    // create UI Components of the Order Form
    private void createUIComponents() {
        createComboBoxes();
        createImageIcons();
        addOrderButtonListeners();
        addSizeBoxListeners();
        addSelBoxListeners();
        createTimer();
        createFeedbackLabels();
    }

    private void createImageIcons() {
        ImageIcon mcdonaldsImage = new ImageIcon(this.getClass().getResource("../resources/mcDonaldLogo.jpg"));
        ImageIcon archesImage = new ImageIcon(this.getClass().getResource("../resources/arches.png"));
        ImageIcon cheeseBurgerImage = new ImageIcon(this.getClass().getResource("../resources/cheeseburger.png"));
        logoLabel1.setIcon(mcdonaldsImage);
        logoLabel1.setVisible(true);

        logoLabel2.setIcon(mcdonaldsImage);
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
        createFinalPanel();
    }



    private void createFeedbackLabels() {
        feedbackLabel1.setVisible(false);
        feedbackLabel1.setForeground(Color.GREEN);
        feedbackLabel1.setBackground(Color.GREEN);

        feedbackLabel2.setVisible(false);
        feedbackLabel2.setForeground(Color.GREEN);

        feedbackLabel3.setVisible(false);
        feedbackLabel3.setForeground(Color.GREEN);

        feedbackLabel4.setVisible(false);
        feedbackLabel4.setForeground(Color.GREEN);

        feedbackLabel5.setVisible(false);
        reviewOrderLabel.setForeground(Color.BLUE);
    }

    private void createBurgerBox() {
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
        dessertSelBox.addItem(dessertOptions[0]);
        dessertSelBox.addItem(dessertOptions[1]);
        dessertSelBox.addItem(dessertOptions[2]);
        dessertSelBox.addItem(dessertOptions[3]);
        dessertSelBox.addItem(dessertOptions[4]);
        dessertSelBox.addItem(dessertOptions[5]);

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
        drinkSelBox.addItem(drinkOptions[0]);
        drinkSelBox.addItem(drinkOptions[1]);
        drinkSelBox.addItem(drinkOptions[2]);
        drinkSelBox.addItem(drinkOptions[3]);
        drinkSelBox.addItem(drinkOptions[4]);
        drinkSelBox.addItem(drinkOptions[5]);

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

    private void createFinalPanel() {
        timerLabel.setVisible(false);
        readyLabel.setVisible(false);
    }

    // Hide Feeedback Label when Size Box is set to != first element
    private void addSizeBoxListeners() {
        // ENTREES
        burgerSizeBox.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (burgerSizeBox.getSelectedIndex() != 0) {
                    feedbackLabel1.setVisible(false);
                }
            }
        });

        // SIDES
        sideSizeBox.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sideSizeBox.getSelectedIndex() != 0) {
                    feedbackLabel2.setVisible(false);
                }
            }
        });

        // DESSERTS
        dessertSizeBox.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dessertSizeBox.getSelectedIndex() != 0) {
                    feedbackLabel3.setVisible(false);
                }
            }
        });

        // DRINKS
        drinkSizeBox.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (drinkSizeBox.getSelectedIndex() != 0) {
                    feedbackLabel4.setVisible(false);
                }
            }
        });
    }

    // Hide Feeedback Label when Size Box is set to != first element
    private void addSelBoxListeners() {
        // ENTREES
        burgerSelBox.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (burgerSelBox.getSelectedIndex() != 0) {
                    feedbackLabel1.setVisible(false);
                }
            }
        });

        // SIDES
        sideSelBox.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sideSelBox.getSelectedIndex() != 0) {
                    feedbackLabel2.setVisible(false);
                }
            }
        });

        // DESSERTS
        dessertSelBox.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dessertSelBox.getSelectedIndex() != 0) {
                    feedbackLabel3.setVisible(false);
                }
            }
        });

        // DRINKS
        drinkSelBox.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (drinkSelBox.getSelectedIndex() != 0) {
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
                    // get the integer values of selected values
                    int selectedEntreeIndex = burgerSelBox.getSelectedIndex();
                    int selectedSizeIndex = burgerSizeBox.getSelectedIndex();
                    // convert to Enum values
                    EntreeType selectedEntree = EntreeType.fromString(burgerOptions[selectedEntreeIndex]);
                    Size selectedSize = Size.fromString(sizesArray[selectedSizeIndex]);
                    // create a new Entree
                    Entree newEntree = new Entree(selectedEntree, selectedSize);
                    // add Entree to order
                    order.addFoodItem(newEntree);
                    // update prices
                    updateAllPrices(newEntree.getPrice());

                    orderReviewTextArea.append(
                            newEntree.getSize().type() +
                                    space +
                                    newEntree.getType().type() +
                                    space +
                                    String.format(decimalFormat, newEntree.getPrice()) +
                                    newLine);

                    // reset the Size Boxes to Zero
                    burgerSizeBox.setSelectedIndex(0);
                    burgerSelBox.setSelectedIndex(0);
                    // update and UI
                    feedbackLabel1.setText(itemAdded);
                    feedbackLabel1.setVisible(true);
                    feedbackLabel5.setVisible(false);
                }
            }
        });

        // SIDES
        addOrder2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sideSelBox.getSelectedIndex() != 0 && sideSizeBox.getSelectedIndex() != 0) {
                    // get the integer values of selected values
                    int selectedSideIndex = sideSelBox.getSelectedIndex();
                    int selectedSizeIndex = sideSizeBox.getSelectedIndex();
                    // convert to Enum values
                    SideType selectedSide = SideType.fromString(sideOptions[selectedSideIndex]);
                    Size selectedSize = Size.fromString(sizesArray[selectedSizeIndex]);
                    // create a new Entree
                    Side newSide = new Side(selectedSide, selectedSize);
                    // add Entree to order
                    order.addFoodItem(newSide);
                    // update prices
                    updateAllPrices(newSide.getPrice());

                    orderReviewTextArea.append(
                            newSide.getSize().type() +
                                    space +
                                    newSide.getType().type() +
                                    space +
                                    String.format(decimalFormat, newSide.getPrice()) +
                            newLine);

                    // reset the Side box values to Zero
                    sideSizeBox.setSelectedIndex(0);
                    sideSelBox.setSelectedIndex(0);
                    //update UI
                    feedbackLabel2.setText(itemAdded);
                    feedbackLabel2.setVisible(true);
                    feedbackLabel5.setVisible(false);
                }
            }
        });

        // DESSERTS
        addOrder3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dessertSelBox.getSelectedIndex() != 0 && dessertSizeBox.getSelectedIndex() != 0) {
                    // get the integer values of selected values
                    int selectedDessertIndex = dessertSelBox.getSelectedIndex();
                    int selectedSizeIndex = dessertSizeBox.getSelectedIndex();
                    // convert to Enum values
                    DessertType selectedDessert = DessertType.fromString(dessertOptions[selectedDessertIndex]);
                    Size selectedSize = Size.fromString(sizesArray[selectedSizeIndex]);
                    // create a new Entree
                    Dessert newDessert = new Dessert(selectedDessert, selectedSize);
                    // add Entree to order
                    order.addFoodItem(newDessert);
                    // update prices
                    updateAllPrices(newDessert.getPrice());

                    orderReviewTextArea.append(
                            newDessert.getSize().type() +
                                    space +
                                    newDessert.getType().type() +
                                    space +
                                    String.format(decimalFormat, newDessert.getPrice()) +
                                    newLine);

                    // reset Size Box values to Zero
                    dessertSizeBox.setSelectedIndex(0);
                    dessertSelBox.setSelectedIndex(0);
                    // update UI
                    feedbackLabel3.setText(itemAdded);
                    feedbackLabel3.setVisible(true);
                    feedbackLabel5.setVisible(false);
                }
            }
        });

        // DRINKS
        addOrder4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (drinkSelBox.getSelectedIndex() != 0 && drinkSizeBox.getSelectedIndex() != 0) {
                    // get the integer values of selected values
                    int selectedDrinkIndex = drinkSelBox.getSelectedIndex();
                    int selectedSizeIndex = drinkSizeBox.getSelectedIndex();
                    // convert to Enum values
                    DrinkType selectedDrink = DrinkType.fromString(drinkOptions[selectedDrinkIndex]);
                    Size selectedSize = Size.fromString(sizesArray[selectedSizeIndex]);
                    // create a new Entree
                    Drink newDrink = new Drink(selectedDrink, selectedSize);
                    // add Entree to order
                    order.addFoodItem(newDrink);
                    // update prices
                    updateAllPrices(newDrink.getPrice());
                    orderReviewTextArea.append(
                            newDrink.getSize().type() +
                                    space +
                                    newDrink.getType().type() +
                                    space +
                                    String.format(decimalFormat, newDrink.getPrice()) +
                                    newLine);

                    // reset Side Box values to Zero
                    drinkSizeBox.setSelectedIndex(0);
                    drinkSelBox.setSelectedIndex(0);
                    // update UI
                    feedbackLabel4.setText(itemAdded);
                    feedbackLabel4.setVisible(true);
                    feedbackLabel5.setVisible(false);
                }
            }
        });

        // FINAL ORDER
        orderButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newStore.checkIfOrderProcessable(order)) {
                    newStore.processOrder(order);
                    orderReviewTextArea.append(createFinalPriceBreakdown(order));

                    feedbackLabel5.setText("ORDER PLACED!!!");
                    feedbackLabel5.setVisible(true);
                    readyLabel.setText("Your Order Will Be Ready Soon!");
                    readyLabel.setVisible(true);

                    timerLabel.setVisible(true);
                    timer.setInitialDelay(0);
                    timer.start();
                } else {
                    orderReviewTextArea.append(newLine + "ORDER CANCELLED" + newLine + "START A NEW ORDER" + newLine);
                    feedbackLabel5.setText("ERROR: Insufficient Inventory!!");
                    feedbackLabel5.setVisible(true);
                    readyLabel.setText("Please Order Less Food!");
                    readyLabel.setVisible(true);
                }
                createNewOrder();
            }
        });

    }

    private void updateAllPrices(double newPrice) {
        totalPrice += newPrice;
        String formattedPrice = dollarSign + space + String.format(decimalFormat, totalPrice);
        priceLabel1.setText(formattedPrice);
        priceLabel2.setText(formattedPrice);
        priceLabel3.setText(formattedPrice);
        priceLabel4.setText(formattedPrice);
        priceLabel5.setText(formattedPrice);
    }

    private void createBusinessVariables() {
        newStore = new Store();
        user = new User("Bob", 22);
        order = new Order(newStore, user);
        createArrays();
    }

    private void createNewOrder() {
        totalPrice = 0.0;
        updateAllPrices(totalPrice);
        order = new Order(newStore, user);
        orderReviewTextArea.append(newLine);
        hideFeedbackLabesl();
    }

    private void hideFeedbackLabesl() {
        feedbackLabel1.setVisible(false);
        feedbackLabel2.setVisible(false);
        feedbackLabel3.setVisible(false);
        feedbackLabel4.setVisible(false);
    }

    private void createTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                if (count > 0) {
                    int minutes = count / 60;
                    int seconds = count % 60;
                    timerLabel.setText(String.format("%d:%02d", minutes, seconds));
                } else {
                    ((Timer) (e.getSource())).stop();
                }
            }
        });
    }

    private String createFinalPriceBreakdown(Order order) {
        String returnString;
        returnString = newLine +
                "SUB TOTAL: " +
                dollarSign +
                space +
                String.format(decimalFormat, order.getSubTotalPrice()) +
                newLine +
                "TAXES: " +
                dollarSign +
                space +
                String.format(decimalFormat, order.getTax()) +
                newLine +
                "TOTAL PRICE: " +
                dollarSign +
                space +
                String.format(decimalFormat, order.getFinalPrice()) +
                newLine +
                "Order Number: " +
                "#" +
                space +
                String.valueOf(order.getOrderNumber()) +
                newLine;
        return returnString;
    }

    private void createArrays() {
        sizesArray = new String[] {
                "(select size)",
                Size.SMALL.type(),
                Size.REGULAR.type(),
                Size.LARGE.type()
        };
        burgerOptions = new String[] {
                selectOption,
                EntreeType.HAMBURGER.type(),
                EntreeType.CHEESEBURGER.type(),
                EntreeType.CHICKEN_SANDWICH.type(),
                EntreeType.CHICKEN_NUGGETS.type(),
                EntreeType.MYSTERY.type()
        };

        sideOptions = new String[] {
                selectOption,
                SideType.FRIES.type(),
                SideType.APPLE.type(),
                SideType.SALAD.type(),
                SideType.ONION_RINGS.type(),
                SideType.MOZZARELLA_STICKS.type(),
                SideType.MYSTERY.type()
        };

        dessertOptions = new String[] {
                selectOption,
                DessertType.APPLE_PIE.type(),
                DessertType.ICE_CREAM.type(),
                DessertType.COOKIE.type(),
                DessertType.BIRTHDAY_CAKE.type(),
                DessertType.FROSTED_TATER_TOTS.type()
        };

        drinkOptions = new String[] {
                selectOption,
                DrinkType.COKE.type(),
                DrinkType.DIET_COKE.type(),
                DrinkType.SPRITE.type(),
                DrinkType.WATER.type(),
                DrinkType.ADULT_BEVERAGE.type()
        };
    }
}

