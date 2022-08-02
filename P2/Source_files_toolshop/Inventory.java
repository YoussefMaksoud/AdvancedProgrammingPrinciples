package com.BackEnd;

import java.util.ArrayList;

/***
 *
 * class manages the stores inventory
 */
public class Inventory {

    /***
     *
     * list of stock
     */
    private ArrayList<Item> itemList;
    /***
     *
     * today's order
     */
    private Order order;

    /***
     *
     * class constructor
     * constructs a new order
     */
    public Inventory(){
        order = new Order();
    }

    /***
     *
     * generates the day's order based on the stock quantity in all items of the itemlist
     */
    public void generateOrder(){
        System.out.println("Order is Being Generated...\n");
        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getQuantity() <= 40){
                order.addOrderLine(itemList.get(i), 30);
            }
        }
        System.out.println("Items Added to Order!\n\n");
    }

    /***
     *
     * decreases the stock quantity of an item
     * @param name name of the item
     * @param qty quantity to decrease by (purchased quantity)
     */
    public void decreaseQuantity(String name, int qty){
        int i;
        for(i = 0; itemList.get(i).getName().toUpperCase().trim().compareTo(name.toUpperCase()) != 0; i++){}
        itemList.get(i).decreaseQuantity(qty);
        this.printContents(i);

        if(itemList.get(i).getQuantity() <= 40) {
            System.out.println("Adding Item to Today's Order");
            order.addOrderLine(itemList.get(i), 30);
        }
    }

    /***
     *
     * checks the current stock quantity of an item
     * @param name the name of the item who's quantity is to be checked
     */
    public void checkQuantity(String name){
        int i;
        for(i = 0; itemList.get(i).getName().toUpperCase().trim().compareTo(name.toUpperCase()) != 0; i++){}
        this.printContents(i);
        System.out.println("");
        System.out.println("The quantity remaining for "  + name + " is: " + itemList.get(i).getQuantity());
        System.out.println("");
    }

    /***
     *
     * @param itemList parameter to be set to the objects list of stock
     */
    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    /***
     *
     *
     * @param order parameter to be set to the list of today's order
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /***
     *
     * @return returns the list of stock
     */
    public ArrayList<Item> getItemList() {
        return itemList;
    }

    /***
     *
     * @return returns today's list of items to be ordered
     */
    public Order getOrder() {
        return order;
    }

    /***
     *
     * searches the inventory by item name
     * @param name name of the desired item
     */
    public void nameSearch(String name){
        int i;
        for(i = 0; itemList.get(i).getName().toUpperCase().trim().compareTo(name.toUpperCase()) != 0; i++){}
        this.printContents(i);
        }

    /***
     *
     * searches the inventory by id
     * @param id the id of the desired item
     */
    public void idSearch(int id){
        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getId() == (id)){
                this.printContents(i);
                break;
            }
        }
    }

    /***
     *
     * displays today's order
     */
    public void displayOrder(){
        order.displayOrder();
    }
    public void addItem(int id, String name, int quantity, float price, int suppId){
        itemList.add(new Item(id, name, quantity, price, suppId));
    }

    /***
     *
     * prints the information item searched for
     * @param index index of item in the arraylist
     */
    public void printContents(int index){
        Item item = new Item();
        item = itemList.get(index);
        System.out.println("ID:" + " " + "Product Name:" + " " + "Qty:" + " " +
                "Price:" + " " + "Supp ID");
        System.out.println(item.getId() + "   " + item.getName() + "   " + item.getQuantity() + "   " +
                "$" + item.getPrice() + "    " + item.getSuppId());
        System.out.println("");
    }

    /***
     *
     * adds the ordered quantity of an item to the stock quantity
     */
    public void receiveOrder(){
        for(int i = 0; i < itemList.size(); i++){
            for(int j = 0; j < order.getOrder().size(); j ++){
                if(itemList.get(i).getId() == order.getOrder().get(j).getOrderItem().getId()){
                    itemList.get(i).setQuantity((itemList.get(i).getQuantity() + order.getOrder().get(j).getOrderItem().getQuantity()));
                }
            }
        }
        order.getOrder().clear();
    }

    /***
     * creates a string composed of all the elements of the items in the inventory
     * @return the string to be displayed
     */
    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < itemList.size(); i ++){
            s = s + "\n" +  itemList.get(i).toString() + "\n";
        }
        return s;
    }
}
