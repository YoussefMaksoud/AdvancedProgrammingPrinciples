package com.BackEnd;
import java.util.Scanner;

/***
 *
 * Implements all front end functions of the toolshop.
 */
public class FrontEnd {

    /***
     *
     * the shop being managed
     */
    private Shop theShop;

    /***
     *
     * reads user input
     */
    private Scanner scan;

    /***
     *
     * class constructor creates a temporary file manager to read the input files
     */
    public FrontEnd(){
        scan = new Scanner(System.in);
        FileManager fileM = new FileManager();
        theShop = new Shop();
    }

    /***
     *
     * Prints all the possible menu options.
     */
    private void printMenuOptions(){
        System.out.println("Please Choose One of the following options:");
        System.out.println("1. LIST ALL TOOLS IN INVENTORY: ");
        System.out.println("2. SEARCH FOR TOOL BY NAME: ");
        System.out.println("3. SEARCH FOR TOOL BY ID :");
        System.out.println("4. CHECK ITEM QUANTITY :");
        System.out.println("5. PURCHASE: ");
        System.out.println("6. VIEW DEDICATED SUPPLIERS: ");
        System.out.println("7. GENERATE ORDER: ");
        System.out.println("8. PRINT TODAY'S ORDER: ");
        System.out.println("9. RECEIVE ORDER: ");
        System.out.println("10. QUIT:");
        System.out.println(" ");
        System.out.println("Please enter your selection: ");
    }

    /***
     *
     * Reads user input and calls required functions accordingly
     */
    public void Menu(){

        while(true) {

            printMenuOptions();

            int choice = scan.nextInt();
            scan.nextLine();

            switch(choice) {
                case 1:
                    inventoryDisplay();
                    break;
                case 2:
                    nameSearch();
                    break;
                case 3:
                    idSearch();
                    break;
                case 4:
                    checkQuantity();
                    break;
                case 5:
                    decreaseQuantity();
                    break;
                case 6:
                    displaySuppliers();
                    break;
                case 7:
                    generateOrder();
                    break;
                case 8:
                    displayOrder();
                    break;
                case 9:
                    receiveOrder();
                    break;
                case 10:
                    System.out.println("See you later!");
                    return;

                default:
            }
        }
    }

    /***
     *
     * Searches tools in inventory by id
     */
    public void idSearch(){

        System.out.println("Please enter tool id:");
        int id = scan.nextInt();
        if(id < 1000 || id > 1040) System.out.println("No item found with this id");
        else
            theShop.idSearch(id);
    }

    /***
     *
     * Searches tools in inventory by name
     */
    public void nameSearch(){
        System.out.println("Please enter product name:");
        String name = scan.nextLine();
        System.out.println(name.trim());
        theShop.nameSearch(name.trim());
    }

    /***
     *
     * Creates the inventory and supplier lists
     */
    public void createInvAndSupp(){
        theShop.createInv();
        theShop.createSuppList();
    }

    /***
     *
     * decreases the quantity of the item in the inventory
     */
    public void decreaseQuantity(){
        System.out.println("Please enter tool name:");
        String name = scan.nextLine();
        name.trim().toUpperCase();
        System.out.println("Please enter quantity you would like to purchase:");
        int qty = scan.nextInt();
        theShop.decreaseQuantity(name, qty);
    }

    /***
     *
     * Checks the current quantity of a tool in the inventory
     */
    public void checkQuantity(){
        System.out.println("Please enter tool name:");
        String name = scan.nextLine();
        name.trim().toUpperCase();
        theShop.checkQuantity(name);
    }

    /***
     *
     * Displays all tools in the inventory
     */
    public void inventoryDisplay(){
        System.out.println("ID:" + " " + "Product Name:" + " " + "Qty:" + " " +
                "Price:" + " " + "Supp ID");
        System.out.println(theShop.toString(1));
    }

    /***
     *
     * Displays all dedicated suppliers
     */
    public void displaySuppliers(){
        System.out.println("ID:" + "    " + "Supplier Name:" + "  " + "address:" + "            "
                + "Representative:");
        System.out.println(theShop.toString(0));
    }

    /***
     *
     * Displays order
     */
    public void displayOrder(){ theShop.displayOrder(); }

    /***
     *
     * generates an order based on the current stock of items in the inventory
     */
    public void generateOrder(){ theShop.generateOrder(); }

    /***
     *
     * Adds the ordered quantity of each item to the stock quantity
     */
    public void receiveOrder(){ theShop.receiveOrder(); }

    public static void main(String args[]){
        FrontEnd f = new FrontEnd();
        f.createInvAndSupp();
        f.Menu();
    }

}
