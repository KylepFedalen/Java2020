
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Random;
public class Customer
{
    private String name;
    private int id;
    /**
     * Default constructor for objects of class Customer
     * defaults id to random id(1-99)
     * defaults name to TestCustomer + id
     */
    public Customer()
    {
        // initialise instance variables
        id = genID();
        name = genName();
    }
    /**
     * Construster that takes in and sets new name and id
     * @pram newname - the name for the Customer
     * @pram newid - the id for the Customer
     */
    public Customer(String newname,int newid)
    {
        name = newname;
        id = newid;
    }
    /**
     * this method generates a name for the Customer
     * @returns name - the generated name for the Customer, TestCustomer + id
     */
    public String genName()
    {
        return "TestCustomer" + Integer.toString(id);
    }
    /**
     * this method generates a name for the Customer
     * @returns id - the generated id for the Customer, an int from 1-99
     */
    public int genID()
    {
        Random rand = new Random();
        return rand.nextInt(99)+1;
    }
    public void setName(String newname)
    {
        name = newname;
    }
    public String getName()
    {
        return name;
    }
    public int getID()
    {
        return id;
    }
    public String toString()
    {
        return String.format("%4s:%-14s   %-3s:%2d","Name",name,"ID",id);
    }
}
