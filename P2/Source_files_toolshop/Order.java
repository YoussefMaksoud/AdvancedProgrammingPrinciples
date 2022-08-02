package com.BackEnd;
import java.util.ArrayList;

/***
 *
 * List of items to be ordered
 */
public class Order {

    /***
     *
     * current day's order
     */
    private ArrayList<OrderLines> order;

    /***
     *
     * constructor creates a new order list
     */
    Order(){
        order = new ArrayList<OrderLines>();
    }

    /***
     *
     * gets the order
     * @return the list of items to be ordered
     */
    public ArrayList<OrderLines> getOrder() {
        return order;
    }

    /***
     *
     * sets the order
     * @param order argument to be set to order
     */
    public void setOrder(ArrayList<OrderLines> order) {
        this.order = order;
    }

    /***
     *
     * adds an item to the overall order
     * @param orderItem
     * @param qty
     */
    public void addOrderLine(Item orderItem, int qty){
        order.add(new OrderLines(orderItem, qty));
    }

    /***
     *
     * displays the entire list of items to be ordered
     */
    public void displayOrder(){
        for(int i = 0; i < order.size(); i ++){
            System.out.println(order.get(i).toString());
            System.out.println("");
        }
    }


}
