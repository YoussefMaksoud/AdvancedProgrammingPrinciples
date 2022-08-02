package com.BackEnd;

/***
 *
 * class representing the items in the inventory
 */
public class Item {
    /***
     *
     * name of the item
     */
    private String name;
    /***
     *
     * item id
     */
    private int id;
    /***
     *
     * name of the supplier
     */
    private Supplier supp;
    /***
     *
     * stock quantity
     */
    private int quantity;
    /***
     *
     * item price
     */
    private float price;
    /***
     *
     * supplier id
     */
    private int suppId;

    /***
     *
     * default constructor
     */
    public Item(){

    }

    /***
     *
     * constructor sets the objects parameters
     * @param id item id
     * @param name item name
     * @param quantity stock quantity
     * @param price item orice
     * @param suppId item supplier id
     */
    public Item(int id, String name, int quantity, float price, int suppId){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.suppId = suppId;
    }

    /***
     *
     * decreases the item quantity (puchase)
     * @param qty the purchased amount
     */
    public void decreaseQuantity(int qty){
        if(qty > this.quantity){
            System.out.println("Not enough stock, would you like us to order some for you?");
        }
        else{
            System.out.println("Here is the current available quantity: " + this.quantity + "\n");
            this.quantity -= qty;
            System.out.println("Quantity remaining is: " + this.quantity + "\n");
        }
    }

    /***
     *
     * @returnreturns the supplier id
     */
    public int getSuppId() {
        return suppId;
    }

    /***
     *
     * @param suppId sets the supplier id
     */
    public void setSuppId(int suppId) {
        this.suppId = suppId;
    }

    /***
     *
     * @return gets the item price
     */
    public float getPrice() {
        return price;
    }

    /***
     *
     * @return gets the item quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /***
     *
     * sets the items price
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /***
     *
     * @param quantity sets the item quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /***
     *
     * @return gets the item id
     */
    public int getId() {
        return id;
    }

    /***
     *
     * @return gets the item name
     */
    public String getName() {
        return name;
    }

    /***
     *
     * @return gets the supplier id
     */
    public Supplier getSupp() {
        return supp;
    }

    /***
     *
     * @param id sets the supplier id
     */
    public void setId(int id) {
        this.id = id;
    }

    /***
     *
     * @param name sets the item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     *
     * @param supp sets the supplier
     */
    public void setSupp(Supplier supp) {
        this.supp = supp;
    }

    /***
     *
     * creates a string that will later be displayed as the list of items
     * @return returns the string containing the item info
     */
    @Override
    public String toString(){
        String s = this.id + "  " + this.name + "  " + this.quantity + "  " + this.price + "  " + this.suppId;
        return s;
    }
}
