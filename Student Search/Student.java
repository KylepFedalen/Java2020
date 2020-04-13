
/**
 * this is the class for Student Objects
 *
 * @author Kyle Fedalen
 * @version 4/12/2020
 */
import java.util.Random;
public class Student implements Comparable<Student>
{
    // instance variables - replace the example below with your own
    private int id;//no dupes, must be greater than zero
    private String name;//cannot be blank or null
    private String major;//can only be 3 capital letters, accept lowercase and convert to upper

    /**
     * Default Constructor for objects of class Student
     */
    public Student()
    {
        // initialise instance variables
        id = 0;
        name = null;
        major = null;
    }

    /**
     * the full Constructor for objects of class Student
     * @pram myid - the new id to set
     * @pram myname - the new name to set
     * @pram mymajor - the new major to set
     */
    public Student(int myid, String myname, String mymajor)
    {
        id = myid;
        name = myname;
        major = mymajor;
    }

    /**
     * the partial Constructor for objects of class Student
     * used to compare in binary search tree
     * @pram myid - the new id to set
     */
    public Student(int myid)
    {
        id = myid;
        name = null;
        major = null;
    }

    /**
     * this method gets the student id
     * @returns id - gets the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * this method gets the student name
     * @returns name - gets the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * this method gets the student major
     * @returns major - gets the major
     */
    public String getMajor()
    {
        return major;
    }

    /**
     * this method sets the student id
     * @pram newid- the new id to be set
     * @pram bst - the givin binary search tree
     * @throws Exception - if id out of range 1-999
     * @throws Exception - if id is already used in binary search tree
     */
    public void setId(int newid,BinarySearchTree bst) throws Exception
    {
        Student test = new Student(newid);
        if(newid < 1 || newid >999){//check if id out of range or in use
            throw new Exception("id out of range please enter an id between 1 and 999");
        }else if(isIdUsed(test,bst)==true){
            throw new Exception("this id is already in use please choose another");
        }else{
            id = newid;
        }
    }

    /**
     * this method sets the student name 
     * @pram newname - the new name to be set
     * @throws Exception - if name is null or blank
     */
    public void setName(String newname) throws Exception
    {
        if(newname.isEmpty()||newname == null){//check if name is null or blank
            throw new Exception("name entered null or blank");
        }else{
            name = newname;
        }
    }

    /**
     * this method sets the student major, converts input major to uppercase
     * @pram newmajor - the new major to be set
     * @throws Exception - if newmajor is not 3 char long
     */
    public void setMajor(String newmajor) throws Exception
    {
        if(newmajor.length() !=3){//check if major is 3 characters long
            throw new Exception("major entered is in incorrect format plese enter 3 letters");
        }else{
            //convert to uppercase
            newmajor.toUpperCase();
            major = newmajor;
        }
    }

    /**
     * the toString method for the student object
     * @returns str - the formated string of student information
     */
    public String toString()
    {
        String str = "";
        str = String.format("%-3d    %-20s%3s",id,name,major);
        return str;
    }

    /**
     * this method generates a random id for a student within range(1-999)
     * @returns myID - the generated id
     */
    public static int genId()
    {
        Random rand = new Random();
        int myID = rand.nextInt(998)+1;

        return myID;
    }

    /**
     * this method generates a name for a student based 
     * on their id. name returned will be "GenStudent"+id
     * @pram thisid - the student id
     * @returns newname - the generated name
     */
    public static String genName(int thisid)
    {
        String newname = "GenStudent";
        newname = newname + Integer.toString(thisid);
        return newname;
    }

    /**
     * this method generates a major for a student picking randomly between 3 DPR,IMM,FRE
     * @returns maj - the generated major
     */
    public static String genMajor()
    {
        Random rand = new Random();
        int mymajor = rand.nextInt(3)+1;
        String maj = "";
        switch(mymajor){
            case 1:
            maj = "DPR";
            break;
            case 2:
            maj = "IMM";
            break;
            case 3:
            maj = "FRE";
            break;
        }
        return maj;
    }

    /**
     * this method checks if the given student id has already been used in the given tree
     * @pram st - student object to check if id has been used
     * @pram bst - the given binary search tree to check
     * @returns true if id is already used or false if id has not been used
     */
    public static boolean isIdUsed(Student st,BinarySearchTree bst){
        if(bst.find(st) == st){
            return true;
        }else{
            return false;
        }

    }

    /**
     * the comparable method
     */
    @Override
    public int compareTo(Student st){
        if(id < st.getId()){
            return -1;
        }else if(id == st.getId()){
            return 0;
        }else{
            return 1;
        }

    }
}
