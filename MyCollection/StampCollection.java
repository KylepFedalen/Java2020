
/**
 * this is the class that defines the stamp collection and its operations
 *
 * @author Kyle Fedalen
 * @version 3/18/2020
 */
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections; 
public class StampCollection
{
    private static LinkedList<Stamp> stamps = new LinkedList<Stamp>();
    
    private static int tempID;
    private static String tempName;
    private static char tempRare;
    private static double tempVal;
    
    /**
     * default constructor
     */
    public StampCollection()
    {

        tempID = Stamp.genID(stamps);
        tempName = "Stamp" + Integer.toString(tempID);
        tempRare = 'u';
        tempVal = 0.00;
    }

    /**
     * this constructor populates the list with a number 
     * of elements with random ids and seprate names
     * it also sets default values for variables
     * @pram pop - how many test elements should be populated
     */
    public StampCollection(int populate)
    {
        populateRand(populate);
                
        tempID = Stamp.genID(stamps);
        tempName = "Stamp" + Integer.toString(tempID);
        tempRare = 'u';
        tempVal = 0.00;
    }

    /**
     * this method displays the collection list
     */
    public static void displayList(){
        System.out.printf("%35s\n\n","My Stamp Collection");
        System.out.printf("%8s %s     %-15s %-9s %s","","id#","Name","Rarity","Value");
        System.out.printf("\n%s\n","----------------------------------------------------------");
        for(int i = 0; i < getSize();i++){
            displayItem(i);
        }
        System.out.printf("%s\n","----------------------------------------------------------");
        System.out.printf("%s\n","Rarity Key: C - Common, R - Rare, E - Epic, L - Legendary");
        System.out.printf("%s","----------------------------------------------------------");
    }

    /**
     * this method displays an Item from the collection list
     * @pram index - the index of the item to display
     */
    public static void displayItem(int index){
        System.out.printf("%3d)   %s\n",index+1,stamps.get(index).toString());
    }  

    /**
     * this method is prompts the user to enter the information to
     * create a new stamp object then creates a new stamp object
     * @pram in - scanner object pass through
     * @throws Exception - if id grater than 999 or if id under 1, and if id is already used.
     * also throws exception if entered name is empty or rarity char is not valid. 
     */
    public static void addStamp(Scanner in) throws Exception
    {
        

        int loopcount = 0;
        boolean ok = false;

        switch(loopcount){
            case 0:
            //add option for user to skip steps
            System.out.printf("%s","Input item ID:(number between 1-999)");
            tempID = in.nextInt();
            if(tempID > 999){
                throw new Exception("the entered id is too high, enter a number between 1 and 999");
            }
            if (tempID < 1){
                throw new Exception("the entered id is too low, enter a number between 1 and 999");
            }

            if(Stamp.isIDUsed(stamps,tempID) == true){
                throw new Exception("id already in use, choose a difrent one");
            }

            loopcount++;

            case 1:
            in.nextLine();
            System.out.printf("%s","Input item Name: ");
            tempName = in.nextLine();
            if(tempName.isEmpty()){
                throw new Exception("Input String is empty" );
            }
            loopcount++;

            case 2:
            System.out.printf("%s","Input item Rarity(char): ");
            tempRare = in.next().charAt(0);
            if(!Character.toString(tempRare).matches("^[c-cC-C]*$")&&!Character.toString(tempRare).matches("^[r-rR-R]*$")&&!Character.toString(tempRare).matches("^[e-eE-E]*$")&&!Character.toString(tempRare).matches("^[l-lL-L]*$")){
                throw new Exception("charecter entered not a valid rarity\nRarity Key: C - Common, R - Rare, E - Epic, L - Legendary");
            }
            loopcount++;

            case 3:
            System.out.printf("%s","Input item Value: ");
            tempVal = in.nextDouble();
            loopcount++;

            case 4:
            System.out.println("creating Stamp object...");

            stamps.add(new Stamp(tempID,tempName,tempRare,tempVal));
            loopcount = 0;
        }
    }

    /**
     * this method displays the selected item that the user wants to change, then it prompts the user for which
     * item variable they want to change and allows the user to change it. the loop breaks when user
     * enters correct input.
     * @pram in - scanner object pass through
     * @pram id - the id of the seleted item that the user wants to change.
     * @throws Exception - if id is not already in use or if name entered is empty
     */
    public static void changeStamp(Scanner in,int id) throws Exception
    {
        int choice = 0;
        boolean ok = false;
        if(Stamp.isIDUsed(stamps, id)==false){
            throw new Exception("That ID is not in this list");
        }
        do{
            System.out.print("\f");
            System.out.printf("%35s","\nItem To Change\n");
            System.out.printf("%8s %s     %-15s %-9s %s\n","","id#","Name","Rarity","Value");
            displayItem(getStampIndex(id));
            System.out.printf("");
            System.out.printf("\n%s\n%s\n%s\n%s\n>","1)Change name","2)Change Rarity","3)Change Value","4)Back");
            choice = in.nextInt();
            switch(choice){
                case 1:
                in.nextLine();
                System.out.printf("%s\n","Input new item Name: ");
                tempName = in.nextLine();
                if(tempName.isEmpty()){
                    throw new Exception("Input String is empty");
                }
                stamps.get(getStampIndex(id)).setName(tempName);
                break;

                case 2:
                in.nextLine();
                System.out.printf("%s%s","Input new item Rarity: ","\nRarity Key: C - Common, R - Rare, E - Epic, L - Legendary");
                tempRare = in.next().charAt(0);
                stamps.get(getStampIndex(id)).setRarity(tempRare);
                break;

                case 3:
                System.out.printf("%s","Input new item Value: ");
                tempVal = in.nextDouble();
                stamps.get(getStampIndex(id)).setValue(tempVal);
                break;

                case 4:
                ok = true;
            }
        }while(!ok);

    }

    /**
     * this method displays the stamp that the user has indicated that they want to 
     * remove and asks for conformation before removing the selected stamp from the list.
     * @pram in - Scanner object pass through
     * @pram id - the id of the seleted item that the user wants to remove.
     * @throws Exception - when object with entered id is not in list
     */
    public static void removeStamp(Scanner in, int id) throws Exception
    {
        int choice = 0;
        boolean ok = false;
        if(Stamp.isIDUsed(stamps, id)==false){
            throw new Exception("That ID is not in this list");
        }
        do{
            System.out.print("\f");
            System.out.printf("\nAre you shure you want to delete this item?\n");
            System.out.printf("%8s %s     %-15s %-13s %s\n","","id#","Name","Rarity","Value");
            displayItem(getStampIndex(id));
            System.out.printf("\n%s\n%s\n>","1)Delte Item","2)Cancel & Back");
            choice = in.nextInt();
            switch(choice){
                case 1:
                stamps.remove(getStampIndex(id));
                ok = true;
                break;
                case 2:
                ok = true;
                break;
            }
        }while(!ok);
    }

    /**
     * this method executes a sort on the LinkedList using the Collections.sort()
     */
    public static void sortList()
    {
        Collections.sort(stamps);
    }


    /**
     * populates the LinkedList with a number of test elements
     * with random ids and diffrent sequential names
     * @pram howMany - how many stamp objcets should the method populate the list with
     */
    public static void populateRand(int howMany){
        //generate 5 StampObjects and add them to LinkedList<Stamp>
        for(int i = 1; i < howMany+1;i++){
            stamps.add(new Stamp(Stamp.genID(stamps),"Test"+Integer.toString(i),'C',5.00));
        }
    }

    /**
     * gets the size of the LinkedList
     * @returns stamps.size() - the length of the LinkedList
     */
    public static int getSize()
    {
        return stamps.size();
    }
    
    /**
     * returns the index of the stamp with the id entered
     * @pram id - the id to search for in the list
     * @return index - the list index of the item with the entered id
     */
    public static int getStampIndex(int id)
    {
        int index = 0;
        for(int i = 0; i < stamps.size();i++){
            if(stamps.get(i).getID() == id){
                index = i;
            }
        }

        return index;
    }
    /**
     * this method returns a string of the whole collection
     * overides toString() method
     * @return myColection - the string representing the whole collection
     */
    @Override
    public String toString()
    {
        String myColection = "          My Stamp Collection\n";
        myColection = myColection + "\n  id#     Name           Rarity     Value\n";
        myColection = myColection + "----------------------------------------------\n";        
        for(int i = 0; i < getSize();i++){
            myColection = myColection + stamps.get(i).toString() + "\n";
        }
        myColection = myColection + "----------------------------------------------\n";
        return myColection;
    }
}
