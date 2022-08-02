package com.BackEnd;
import java.util.ArrayList;

/***
 *
 * manages the dedicated suppliers
 */
public class Supplier {
    /***
     *
     * supplier id
     */
    private int id;
    /***
     *
     * supplier name
     */
    private String name;
    /***
     *
     * name of the dedicated supplier
     */
    private String location;
    /***
     *
     * name of the representative
     */
    private String representative;
    /***
     *
     * list of the suppliers
     */
    private ArrayList<Item> suppItems;

    /***
     *
     * constructor sets the parameters of the object
     * @param id supplier id
     * @param name supplier name
     * @param location supplier location of operation
     * @param representative name of the representative
     */
    public Supplier(int id,String name, String location,String representative){
        this.id = id;
        this.name = name;
        this.location = location;
        this.representative = representative;
    }

    /***
     *
     * @return returns the id
     */
    public int getId() {
        return id;
    }

    /***
     *
     * @return returns the location of operation
     */
    public String getLocation() {
        return location;
    }

    /***
     *
     * @return returns the name of the representative
     */
    public String getRepresentative() {
        return representative;
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
     * @param location sets the location of operation
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /***
     *
     * @param representative sets the name of the representative
     */
    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    /***
     *
     * Creates a chain of Strings to later display the dedicated suppliers
     * @return A String of a  supplier with all its info
     */
    @Override
    public String toString(){
        String s = this.id + "  " + this.name + "  " + this.location + "  " + this.representative;
        return s;
    }
}
