package com.BackEnd;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/***
 *
 * class manages the input text files
 */
public class FileManager {

    /***
     *
     * temporary item list
     */
    ArrayList<Item> tempI;
    /***
     *
     * temporary supplier list
     */
    ArrayList<Supplier> tempS;

    /***
     *
     * default class constructor
     */
    public FileManager(){
    }

    /***
     *
     * reads the input file of all items in stock and saves into the class itemlist in inventory
     * @return the temporary array of items
     * @throws FileNotFoundException
     */
    public ArrayList<Item> readItemList() throws FileNotFoundException{
        tempI = new ArrayList<>();

        File file = new File("/Users/youssef/Desktop/ToolShop Implementation/src/com/BackEnd/items.txt");
        Scanner scan = new Scanner(file);
        String line;
        String tempArr[] = new String[4];
        while (scan.hasNext()) {
            line = scan.nextLine();
            tempArr = line.split(";");
            tempI.add(new Item(Integer.parseInt(tempArr[0]), tempArr[1], Integer.parseInt(tempArr[2]),
                    Float.parseFloat(tempArr[3]), Integer.parseInt(tempArr[4])));
        }
        return tempI;
    }

    /***
     *
     * reads the input file of all suppliers and saves into the class supplier list in Supplier
     * @return the temporary array to be saves in suppliers
     * @throws FileNotFoundException
     */
    public ArrayList<Supplier> readSuppList() throws FileNotFoundException{
        tempS = new ArrayList<>();

        File file = new File("/Users/youssef/Desktop/ToolShop Implementation/src/com/BackEnd/suppliers.txt");
        Scanner scan = new Scanner(file);
        String line;
        String tempArr[];
        while (scan.hasNext()) {
            line = scan.nextLine();
            tempArr = line.split(";");
            tempS.add(new Supplier(Integer.parseInt(tempArr[0]), tempArr[1], tempArr[2], tempArr[3]));
        }
        return tempS;
    }
}

