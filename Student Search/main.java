
/**
 * This is the main driver class for this program
 *
 * @author Kyle Fedalen
 * @version 4/12/2020
 */
import java.util.ArrayList;
import java.util.Scanner;
public class main
{

    /**
     * this method is the main method for this program
     */
    public static void main()
    {
        System.out.printf("%s\n\n\n","Starting program...");
        BinarySearchTree bst = new BinarySearchTree();
        Scanner in = new Scanner(System.in);

        int genstudents = 3;
        for(int i = 0; i < genstudents;i++){
            int tempid = Student.genId();
            Student st = new Student(tempid,Student.genName(tempid),Student.genMajor());
            bst.add(st);
            //System.out.printf("%b\n",Student.isIdUsed(st,bst));
        }

        bst.add(new Student(123, "John Smith", "DPR"));
        bst.add(new Student(124, "Kelly Jones", "IMM"));
        bst.add(new Student(125, "Fred Kingston", "FRE"));
        bst.add(new Student(225, "John Appleton", "IOU"));
        bst.add(new Student(226, "Wesley Crusher", "HAF"));
        bst.add(new Student(365, "Doug Geen", "TRE"));

        int spacing = 10;
        String space = "";
        for(int i = 0;i < spacing;i++){
            space = space + " ";
        }

        boolean ok = false;
        do{
            try{
                printMenu(bst,space);
                int ch = in.nextInt();
                choose(ch,bst,in,space);
            }catch(Exception e){
                in.reset();
                in.nextLine();
                System.out.print(e +"\n");
                System.out.print("Press Enter to continue...\n");
                in.nextLine();

            }

        }while(!ok);

        System.out.printf("%s\n","Ending program...");
        
    }

    /**
     * this method handles the user input and adding and removing data from the binary search tree
     * @pram ch - the users menu choice
     * @pram bst - the givin binary search tree
     * @pram in - the Scanner object
     * @pram spacing - the string spacing for the menu output
     */
    public static void choose(int ch,BinarySearchTree bst,Scanner in,String spacing) throws Exception
    {
        switch(ch){
            case 1:
            String myname = null;
            String mymajor = null;
            int myid = 0;
            System.out.printf("\f");
            System.out.printf("%s%s\n%s>",spacing,"Enter Id to Search",spacing);
            myid = in.nextInt();
            Student st = new Student();
            st.setId(myid,bst);
            Student found = search(bst,st);
            if(found == null){
                System.out.printf("%serror: student with ID:%d not found\n",spacing,myid);
                System.out.printf("%s%7s\n%s1)%s\n%s2)%s\n%s>",spacing,"Menu",spacing,"Add Student",spacing,"Back",spacing);
                int ch1 = in.nextInt();
                if(ch1 == 1){
                    int count = 1;
                    switch(count){
                        case 1:
                        in.nextLine();
                        System.out.printf("%sInput Student name:",spacing);
                        myname = in.nextLine(); 
                        st.setName(myname);
                        count++;
                        case 2:

                        System.out.printf("%sInput Student major",spacing);
                        mymajor = in.nextLine();
                        st.setMajor(mymajor);
                        count++;
                        case 3:
                        System.out.printf("%sCreating new Student...",spacing);
                        bst.add(st);
                        break;
                    }
                }else{
                    break;
                }
            }else{
                System.out.printf("%s%s\n%s%s\n",spacing,"Student Found",spacing,"-------------------------");
                System.out.printf("%s%s\n",spacing,found);
                System.out.printf("%s%7s\n%s1)%s\n%s2)%s\n%s>",spacing,"Menu",spacing,"Remove Student",spacing,"Back",spacing);
                int ch2 = in.nextInt();
                if(ch2 == 1){
                    System.out.printf("%sRemoving Student from list...",spacing);
                    bst.remove(st);
                }else{
                    break;
                }
            }
            break;

            case 2:

            Student mj = new Student();
            in.nextLine();
            System.out.printf("%sEnter Major to filter by:",spacing);
            String ch3 = in.nextLine();

            printFilteredList(ch3,bst,spacing);
            System.out.printf("%s%7s\n%s1)%s\n%s>",spacing,"Menu",spacing,"Back",spacing);
            in.nextLine();
            break;

            case 3:
            printList(bst,spacing);
            System.exit(0);

        }
    }

    /**
     * this method searches through the giving binary search tree for the given student
     * @pram bst - binary search tree to search through
     * @pram st - the student object(id only) to search through the tree for
     * @returns found - returns the full student object if found, returns null if not found
     */
    public static Student search(BinarySearchTree bst,Student st)
    {
        Student found = (Student)bst.find(st);
        return found;
    }

    /**
     * this method prints out all elements within a givin binary search tree
     * filtered by the given major
     * @pram majorf - the Major used as a filter
     * @pram bst - the binary search tree to print
     * @pram spacing - the string formating spacing
     */
    public static void printFilteredList(String majorf,BinarySearchTree bst,String spacing)
    {
        ArrayList<Object> students = bst.getList();
        System.out.printf("\f");
        System.out.printf("%s%25s\n%s%s%s\n",spacing,"Student Listings",spacing,"Filtered By:",majorf);
        System.out.printf("%s%s%14s %12s\n",spacing,"ID","Student Name","Major");
        System.out.printf("%s%s\n",spacing,"-----------------------------------");
        for(Object e:students){
            Student st = (Student)e;
            if(st.getMajor().equals(majorf)){
                System.out.print(spacing) ;
                System.out.print(e+"\n") ;
            }

        }
    }

    /**
     * this method prints out all elements within a givin binary search tree
     * @pram bst - the binary search tree to print
     * @pram spacing - the string formating spacing
     */
    public static void printList(BinarySearchTree bst,String spacing)
    {
        ArrayList<Object> students = bst.getList();
        System.out.printf("\f");
        System.out.printf("%s%25s\n",spacing,"Student Listings");
        System.out.printf("%s%s%14s %12s\n",spacing,"ID","Student Name","Major");
        System.out.printf("%s%s\n",spacing,"-----------------------------------");
        for(Object e:students){
            Student st = (Student)e;
            System.out.print(spacing) ;
            System.out.print(e+"\n") ;
        }
        System.out.printf("%s%s\n",spacing,"-----------------------------------");
    }

    
    /**
     * this method prints out the main menu for the program
     * @pram bst - the BinarySearchTree to print
     * @pram spacing - the string format spacing for the menu
     */
    public static void printMenu(BinarySearchTree bst,String spacing)
    {
        System.out.printf("\f");

        
        
        printList(bst,spacing);

        System.out.printf("%s%7s\n%s1)%s\n%s2)%s\n%s3)%s\n%s>",spacing,"Menu",spacing,"Search Listings",spacing,"Filter by Major",spacing,"Quit",spacing);
        
    }

    
}
