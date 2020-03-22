
/**
 * Write a description of class testprogram here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class testprogram
{
    public static void main()
    {
        Scanner in = new Scanner(System.in);
        Queue q = new Queue(6);
        
        System.out.printf("starting program...");
        
        System.out.printf("\n\n\n%s\n","MyQueue");
        System.out.printf("%s\n","Checkout line");
        System.out.printf("%s%d\n","line length: ",q.size());//demonstrating size() method
        System.out.print(q.toString()); //demonstrating toString() method
        System.out.printf("\n %s","press enter to continue...");
        in.nextLine();
        
        System.out.printf("\f");
        System.out.printf("%s","adding customer back of line...");
        q.add();
        System.out.printf("\n%s%s",q.getLast()," added to line");
        
        System.out.printf("\n\n%s\n","MyQueue");
        System.out.printf("%s\n","Checkout line");
        System.out.printf("%s%d\n","line length: ",q.size());
        System.out.print(q.toString());
        System.out.printf("\n %s","press enter to continue...");
        in.nextLine();
        
        System.out.printf("\f");
        System.out.printf("%s","removing customer from front of line...");
        String tempName = q.poll().toString(); //demonstrating poll() method
        System.out.printf("\n%s%s",tempName," removed from line");
        
        System.out.printf("\n\n%s\n","MyQueue");
        System.out.printf("%s\n","Checkout line");
        System.out.printf("%s%d\n","line length: ",q.size());
        System.out.print(q.toString());
        System.out.printf("\n %s","press enter to continue...");
        in.nextLine();
        
        
        boolean ok = false;
        try{
            
            
            
            do{
                System.out.printf("\f");
                System.out.printf("%s","polling full line...");
                if(q.isEmpty()){
                    throw new Exception("cant poll, line empty");
                }
                
                System.out.printf("\n%s%s",q.poll().toString()," removed from line");
        
                System.out.printf("\n\n%s\n","MyQueue");
                System.out.printf("%s\n","Checkout line");
                System.out.printf("%s%d\n","line length: ",q.size());
                System.out.print(q.toString());
                
                
                
                Thread.sleep(750);
            }while(!ok);
            
            
        }
        catch(Exception e){
            System.out.print("\n"+e);
        }
        System.out.printf("\n %s","press enter to continue...");
        in.nextLine();
        
        System.out.printf("\f");
        System.out.printf("%s","adding customers to line...");
        q.add("John Smith", 22);
        q.add("Karry Appleton", 33);
        q.add("Mark Burns", 44);
        System.out.printf("\n\n\n%s\n","MyQueue");
        System.out.printf("%s\n","Checkout line");
        System.out.printf("%s%d\n","line length: ",q.size());
        System.out.print(q.toString());
        
        System.out.printf("\n %s","press enter to end the program...");
        in.nextLine();
        System.out.printf("ending program...");
    }
}
