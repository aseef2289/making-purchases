/*
* File Name: Main.java
* Author: Aseef Ali Hasan
* Date: August 6, 2021
* Description:
* This is a program that calculates subtotal of purchase from Aseef's Fruit Farm
* Calculates tax value of purchase from Aseef's Fruit Farm
* Calculates grand total of purchase from Aseef's Fruit Farm
* Displays all information through a GUI
* Displays all calculations in dollars ($)
*/

//Import classes used for the GUI
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;

class Main {
  //Class variables
  //All the elements needed to build GUI 
  static JFrame frmMain;

  static JLabel lblTitle;

  static JLabel lblApples;
  static JLabel lblOranges;
  static JLabel lblPears;
  static JLabel lblMangoes;
  static JLabel lblAvocados;
  static JLabel lblLogo;
  static JLabel lblTaxes;
  static JLabel lblSubTotal;
  static JLabel lblGrandTotal;

  static ImageIcon imgLogo;

  static JTextField txtApples;
  static JTextField txtOranges;
  static JTextField txtPears;
  static JTextField txtMangoes;
  static JTextField txtAvocados;

  static JTextArea txtTaxes;
  static JTextArea txtSubTotal;
  static JTextArea txtGrandTotal;

  static JButton btnCalculate;

  //to store number apples purchased by user
  static int applesPurchased; 
  //to store number oranges purchased 
  static int orangesPurchased;
  //to store number of pears purchased by user
  static int pearsPurchased;
  //to store number of mangoes purchased by user
  static int mangoesPurchased;
  //to store number of avocados purchased by user
  static int avocadosPurchased;

  //to store the tax value calculated
  static double taxValue;
  //to store subtotal calculated
  static double subTotal;
  //to store grand total calculated
  static double grandTotal;

  //used for inserting stored calculations in GUI
  static String finalTax;
  static String finalSub;
  static String finalGrand;

  //constant values for product prices and tax rate
  static final double APPLE_PRICE = 1.29;
  static final double ORANGE_PRICE = 1.00;
  static final double PEAR_PRICE = 1.49;
  static final double MANGO_PRICE = 1.99;
  static final double AVOCADO_PRICE = 2.49;
  static final double TAX_RATE = 0.13;

  public static void main(String[] args) {
    // Initialize and setup all elements of the GUI
    frmMain = new JFrame("Making Purchases");
    //next line will make sure to close the application
    //when the user clicks on the X corner
    frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    /* 
    *  Setup layout to null to be able to place elements
    *  to place them at a specific coordinate within the
    *  Frame
    */
    frmMain.setLayout(null);
    //Set the frame visible
    frmMain.setVisible(true);
     //set the size and the location
    frmMain.setBounds(10,10,450,500);

    //create, setup, and add the elements to the Frame
    lblTitle = new JLabel("<html>Aseef's Fruit Farm");
    /*
    * 10, 10 are the coordinates of the top right corner
    * 300 and 80 are location coordinates
    * 200 x 30 are width and height
    */
    lblTitle.setBounds(300,80,200,30);
    //adding label to frame
    frmMain.add(lblTitle);

    //Add the logo image as label
    //create an image
    imgLogo = new ImageIcon("small_fruits.jpg");
    //add image to label
    lblLogo = new JLabel(imgLogo);
    lblLogo.setBounds(40,5,250,200);
    //add it to the Frame
    frmMain.add(lblLogo);

    //add apple label and text field 
    lblApples = new JLabel("Apples ($1.29): ");
    lblApples.setBounds(10,200,150,30);
    frmMain.add(lblApples);
    txtApples = new JTextField("0");
    txtApples.setBounds(150,200,30,30);
    frmMain.add(txtApples);

    //add orange label and text field 
    lblOranges = new JLabel("Oranges ($1.00): ");
    lblOranges.setBounds(10,250,150,30);
    frmMain.add(lblOranges);
    txtOranges = new JTextField("0");
    txtOranges.setBounds(150,250,30,30);
    frmMain.add(txtOranges);

    //add pear label and text field 
    lblPears = new JLabel("Pears ($1.49): ");
    lblPears.setBounds(10,300,150,30);
    frmMain.add(lblPears);
    txtPears = new JTextField("0");
    txtPears.setBounds(150,300,30,30);
    frmMain.add(txtPears);

    //add mango label and text field
    lblMangoes = new JLabel("Mangoes ($1.99): ");
    lblMangoes.setBounds(10,350,150,30);
    frmMain.add(lblMangoes);
    txtMangoes = new JTextField("0");
    txtMangoes.setBounds(150,350,30,30);
    frmMain.add(txtMangoes);

    //add avocado label and text field
    lblAvocados = new JLabel("Avocados ($2.49): ");
    lblAvocados.setBounds(10,400,150,30);
    frmMain.add(lblAvocados);
    txtAvocados = new JTextField("0");
    txtAvocados.setBounds(150,400,30,30);
    frmMain.add(txtAvocados);

    //add tax label and text area
    lblTaxes = new JLabel("Taxes (13%): ");
    lblTaxes.setBounds(200,200,150,30);
    frmMain.add(lblTaxes);
    txtTaxes = new JTextArea("$0.00");
    txtTaxes.setBounds(300,200,60,30);
    txtTaxes.setEditable(false); //cannot be typed in
    frmMain.add(txtTaxes);

    //add subtotal label and text area
    lblSubTotal = new JLabel("Subtotal: ");
    lblSubTotal.setBounds(200,250,150,30);
    frmMain.add(lblSubTotal);
    txtSubTotal = new JTextArea("$0.00");
    txtSubTotal.setBounds(300,250,60,30);
    txtSubTotal.setEditable(false); //cannot be typed in
    frmMain.add(txtSubTotal);

    //add grand total label and text area
    lblGrandTotal = new JLabel("Grand Total: ");
    lblGrandTotal.setBounds(200,300,150,30);
    frmMain.add(lblGrandTotal);
    txtGrandTotal = new JTextArea("$0.00");
    txtGrandTotal.setBounds(300,300,60,30);
    txtGrandTotal.setEditable(false); //cannot be typed in 
    frmMain.add(txtGrandTotal);

    //add button that will perfrom calculations
    btnCalculate = new JButton("Calculate");
    btnCalculate.setBounds(200,350,160,20);
    frmMain.add(btnCalculate);

    //Add the ability of the button to perform action when clicked
    btnCalculate.addActionListener((ActionEvent e)-> {
      //Get user's data from the textboxes
      applesPurchased = Integer.parseInt(txtApples.getText());
      orangesPurchased = Integer.parseInt(txtOranges.getText());
      pearsPurchased = Integer.parseInt(txtPears.getText());
      mangoesPurchased = Integer.parseInt(txtMangoes.getText());
      avocadosPurchased = Integer.parseInt(txtAvocados.getText());

      //perfrom subtotal calculation
     subTotal = (applesPurchased * APPLE_PRICE) + (orangesPurchased * ORANGE_PRICE) + (pearsPurchased * PEAR_PRICE) + (mangoesPurchased * MANGO_PRICE) + (avocadosPurchased * AVOCADO_PRICE);
     //rounds answer to two decimal places
     subTotal = subTotal * 100;
     subTotal = Math.round(subTotal);
     subTotal = subTotal / 100;

      //perform tax value calculation
     taxValue = subTotal * TAX_RATE;
     //rounds answer to two decimal places
     taxValue = taxValue * 100;
     taxValue = Math.round(taxValue);
     taxValue = taxValue / 100;

      //perform grand total calculation
     grandTotal = taxValue + subTotal;
     //rounds answer to two decimal places
     grandTotal = grandTotal * 100;
     grandTotal = Math.round(grandTotal);
     grandTotal = grandTotal / 100;

      //turns calculated decimal into as strings
     finalTax = String.valueOf(taxValue);
     finalSub = String.valueOf(subTotal);
     finalGrand = String.valueOf(grandTotal);

      //turns on line wrap so text doesn't go out of the box
     txtTaxes.setLineWrap(true);
     txtSubTotal.setLineWrap(true);
     txtGrandTotal.setLineWrap(true);

      //puts calculated and converted strings into text areas
     txtTaxes.setText("$" + finalTax);
     txtSubTotal.setText("$" + finalSub);
     txtGrandTotal.setText("$" + finalGrand);

      //resets text fields to 0
     txtApples.setText("0");
     txtOranges.setText("0");
     txtPears.setText("0");
     txtMangoes.setText("0");
     txtAvocados.setText("0");
     }); //end of action listener for the button 
  } //end of main method
} //end of class method 