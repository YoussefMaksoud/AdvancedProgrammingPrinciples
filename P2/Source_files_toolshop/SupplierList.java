package com.BackEnd;

import java.util.ArrayList;

/***
 *
 * manages the list of suppliers
 */
public class SupplierList {

    /***
     *
     * list of dedicated suppliers
     */
    private ArrayList<Supplier> supps;

    /***
     *
     * default class constructor
     */
    public SupplierList(){

    }

    /***
     *
     * adds a new supplier to the list
     * @param id supplier id
     * @param name supplier name
     * @param location location of operation
     * @param representative supplier representative
     */
    public void addSupplier(int id, String name, String location,String representative){
        supps.add(new Supplier(id, name, location, representative));
    }

    /***
     *
     * @param supps supplier list to be set
     */
    public void setSupps(ArrayList<Supplier> supps) {
        this.supps = supps;
    }

    /***
     *
     * @return returns the supplier list
     */
    public ArrayList<Supplier> getSupps() {
        return supps;
    }

    /***
     *
     * forms a string of all supplier information to be later displayed
     * @return returns the chained string
     */
    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < supps.size(); i ++){
            s = s + "\n" +  supps.get(i).toString() + "\n";
        }
        return s;
    }
}
