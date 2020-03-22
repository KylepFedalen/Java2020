
/**
 * this is the driver program fo this project
 *
 * @author Kyle Fedalen
 * @version 3/18/2020
 */
import java.util.Scanner;
public class TestProgram
{

    /**
     * this the main method of the program
     */
    public static void main(){
        Scanner in = new Scanner(System.in);
        StampCollection stamps = new StampCollection(5);


        int choice = 0;
        boolean ok = false;
        
        do{
            
            try{
                menu(stamps);
                
                choice = in.nextInt();
                switch(choice){
                    case(1):
                    System.out.printf("Adding Item...\n");
                    stamps.addStamp(in);
                    break;
                    case(2):
                    System.out.printf("Changing Item...\n");
                    System.out.printf("Input the ID of the item you want to change:\n>");
                    int chindex = in.nextInt();
                    stamps.changeStamp(in,chindex);
                    break;
                    case(3):
                    System.out.printf("Removing Item...\n");
                    System.out.printf("Input the ID of the item you want to remove:\n>");
                    int rmindex = in.nextInt();
                    stamps.removeStamp(in,rmindex);
                    break;
                    case(4):
                    System.out.printf("Sorting List...");
                    stamps.sortList();
                    break;
                    case(5):
                    ok = true;
                    break;
                    

                }

            }catch(Exception e){
                in.nextLine();
                System.out.println(e+"\npress enter key to continue...");
                in.nextLine();
            }

        }while(!ok);
        System.out.print("\f");
        
        System.out.printf(stamps.toString());
        System.out.printf("\nStopping Program...\n");
        System.exit(0);
    }

    
    /**
     * this method displays the main menu of the program
     */
    public static void menu(StampCollection stamps){
        System.out.print("\f");
        stamps.displayList();
        System.out.printf("\n%s\n%s\n%s\n%s\n%s\n>","1)Add Item","2)Change Item","3)Remove Item","4)Sort Item List","5)Quit");
    }
    

}
