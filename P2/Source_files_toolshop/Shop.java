package com.BackEnd;

import java.io.FileNotFoundException;

/***
 *
 * class contains the inventory and the suppliers list
 */
public class Shop {
    /***
     *
     * stock items, and items to be ordered
     */
    private Inventory inventory;
    /***
     *
     * list of dedicated suppliers
     */
    private SupplierList suppList;

    /***
     *
     * constructor creates a new inventory and supplier list
     */
    public Shop() {
        inventory = new Inventory();
        suppList = new SupplierList();
    }

    /***
     *
     * @return returns the shop inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /***
     *
     * @return returns the list of dedicated suppliers
     */
    public SupplierList getSuppList() {
        return suppList;
    }

    /***
     *
     * @param inventory sets the shops inventory
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /***
     *
     * @param suppList sets the shops supplier list
     */
    public void setSuppList(SupplierList suppList) { this.suppList = suppList; }

    /***
     *
     * searches inventory by item name
     * @param name name of item
     */
    public void nameSearch(String name) {
        inventory.nameSearch(name);
    }

    /***
     *
     * checks quantity of an item
     * @param name name of item
     */
    public void checkQuantity(String name){
        inventory.checkQuantity(name);
    }

    /***
     *
     * searches inventory by item id
     * @param id item id
     */
    public void idSearch(int id) {
        inventory.idSearch(id);
    }

    /***
     *
     * decreases the quantity of a specified item
     * @param name item name
     * @param qty quantity to be decreased
     */
    public void decreaseQuantity(String name, int qty) {
        inventory.decreaseQuantity(name, qty);
    }

    /***
     *
     * displays today's order
     */
    public void displayOrder() {
        inventory.displayOrder();
    }

    /***
     *
     * creates the shop's inventory
     */
    public void createInv(){
        FileManager tempFM = new FileManager();
        try {
            this.inventory.setItemList(tempFM.readItemList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /***
     *
     * creates the shop's list of dedicated suppliers
     */
    public void createSuppList(){
        FileManager tempFM = new FileManager();
        try {
            this.suppList.setSupps(tempFM.readSuppList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /***
     *
     * generates today's order based on the current stock of the items in the inventory
     */
    public void generateOrder(){
        inventory.generateOrder();
    }

    /***
     *
     * adds the ordered quantity to the existing quantity
     */
    public void receiveOrder(){
        inventory.receiveOrder();
    }

    /***
     *
     * creates a string to either display the item list or list of dedicated suppliers
     * @param n to return either the item list or the supplier list
     * @return returns the string composed of the information of the supplier or the item
     */
    public String toString(int n){
        String s = "";
        if(n == 1) {
            s = inventory.toString();
        }
        if(n == 0){
            s = suppList.toString();
        }
        return s;
    }

}
