package com.BackEnd;

/***
 *
 * Item to be ordered
 */
public class OrderLines {
    /***
     *
     * item to be ordered
     */
    private Item orderItem;

    /***
     *
     * constructor creates a new item to be ordered
     * @param itemToAdd the item to be added
     * @param orderQty quantity to be added
     */
    public OrderLines(Item itemToAdd, int orderQty){
        orderItem = new Item(itemToAdd.getId(), itemToAdd.getName(),
                orderQty, itemToAdd.getPrice(), itemToAdd.getSuppId());
    }

    /***
     * gets the order item
     * @return the item ordered
     */
    public Item getOrderItem() {
        return orderItem;
    }

    /***
     *
     * sets the orderitem
     * @param orderItem incoming argument to be placed into the orderItem object
     */
    public void setOrderItem(Item orderItem) {
        this.orderItem = orderItem;
    }

    /***
     *
     * Creates a String to be later displayed as an element of the order
     * @return The information about the orderItem
     */
    public String toString(){
        String s = orderItem.getId() + "  " + orderItem.getName() + "  " + orderItem.getQuantity()
                + "  " + orderItem.getPrice() + "  " + orderItem.getSuppId();
        return s;
    }
}

