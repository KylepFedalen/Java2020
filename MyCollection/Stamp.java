
/**
 * this is the class for the Stamp object
 *
 * @author Kyle Fedalen
 * @version 3/18/2020
 */
import java.util.Random;
import java.util.LinkedList; 
public class Stamp implements Comparable
{

    private int id;  
    private double value;
    private char rarity;
    private String name;

    /**
     * Default Constructor for objects of class Stamp
     */
    public Stamp()
    {
        // initialise instance variables
        id = genID();
        name = defaultname();
        rarity = 'u';
        value = 0.00;        
    }

    /**
     * Constructor for the stamp class
     * @pram int newid - the id to use when constructing a new Stamp
     * @pram String newname - the name to use when constructing a new Stamp
     * @pram char newrarity - the rarity symbol to use when constructing a new Stamp
     * @pram double newvalue - the value to use when constructing a new Stamp
     */    
    public Stamp(int newid, String newname,char newrarity, double newvalue)
    {
        // initialise instance variables

        id = newid;
        name = newname;
        rarity = newrarity;
        value = newvalue;

    }

    /**
     * this method generates a random id to use
     * @return theID - randomly generated id between 1 and 999
     */
    public static int genID(){
        Random rand = new Random();

        int theID = rand.nextInt(999)+1;

        return theID;

    }

    /**
     * this method looks through the stamp list for already 
     * used ids and generates a random unused id.
     * @pram stamps - takes in linked list of Stamp objects
     * @return theID - randomly generated id between 1 and 999
     */
    public static int genID(LinkedList<Stamp> stamps){
        Random rand = new Random();
        boolean ok = false;
        int theID = rand.nextInt(999)+1;
        do{

            if(Stamp.isIDUsed(stamps,theID) == true){
                theID = rand.nextInt(999)+1;

            }else{
                ok = true;
            }
        }while(!ok);

        return theID;
    }
    /**
     * this method returns true if entered id is used in the collection list
     * else it returns false
     * @pram id - the item id
     * @return boolean - returns true if entered id is in list, false if it is not.
     */
    public static boolean isIDUsed(LinkedList<Stamp> stamps,int id)
    {

        for(int i = 0; i < stamps.size();i++){
            if(stamps.get(i).getID() == id){
                return true;
            }
        }
        return false;
    }

    /**
     * this method creates a default name for the stamp
     * @return newname - a default name string using "String"+id
     */
    public String defaultname()
    {
        String newname = "Stamp"+Integer.toString(id);
        return newname;
    }

    /**
     * this method sets the rarity
     * @pram newrareity - the new rarity character for the object
     */
    public void setRarity(char newrareity)
    {
        rarity = newrareity;
    }

    /**
     * this method sets the value
     * @pram newvalue - the new value for the object
     */
    public void setValue(double newvalue){
        value = newvalue;
    }

    /**
     * this method sets the name
     * @pram newname - the new name for the object
     */
    public void setName(String newname){
        name = newname; 
    }

    /**
     * this method gets the rarity character of this object
     * @return rarity - the character representing the rarity of the object
     */
    public char getRarity(){
        return rarity;
    }

    /**
     * this method gets the value of this object
     * @return value - the double representing the value of the object
     */
    public double getValue(){
        return value;
    }

    /**
     * this method gets the id of this object
     * @return id - the int representing the id of the object
     */
    public int getID(){
        return id;
    }

    /**
     * this method gets the name of this object
     * @return name - the String representing the name of the object
     */
    public String getName(){
        return name;
    }

    /**
     * this method compares two stamp object id's and returns -1 if compared
     * object id is grater 0 if equal and 1 if it is less.
     * @pram otherobject - the other stamp object to compare
     */
    @Override
    public int compareTo(Object otherobject)
    {

        Stamp other = (Stamp) otherobject;
        if(id < other.getID())
            return -1;
        else if(id == other.getID())
            return 0;
        else
            return 1;
    }

    /**
     * this method is a toString method for this class
     * @return str - the string output for this object
     */
    @Override
    public String toString()
    {

        String str = String.format("%5d %-20s %2c %11.2f",id,name,rarity,value);

        return str;
    }

}
