
/**
 * this is the main class of this program
 *
 * @author Kyle Fedalen
 * @version 3/28/2020
 */

import java.util.Scanner;
public class ConvertToBase
{
    /**
     * the main driver method for this program
     */
    public static void main()
    {
        System.out.printf("Program Start...\n");
        ArrayStack mystack = new ArrayStack();
        Scanner in = new Scanner(System.in);
        boolean ok = false;
        
        
        do{
            System.out.printf("Input base to convert to:\n>");
            int base = in.nextInt();
            System.out.printf("Input number to convert:\n>");
            int num = in.nextInt();
            System.out.printf("Input: %d Base:%s\n",num,base);
            System.out.printf("------------------------\n");
            convertToBase(num,base,mystack);
            System.out.printf("%d Converted to Base:%d is: %s\n\n",num,base,mystack.toString());
            mystack.emptyStack();
            
            System.out.printf("press enter to continue or q to quit\n");
            
            in.nextLine();
            String con = in.nextLine();
            if(con.equals("q")||con.equals("Q")){
                ok = true;
            }
            
        }while(!ok);

        System.out.printf("Program Ending...\n");

    }
    /**
     * this method converts an input base 10 number to a diffrent base 
     * that is also input by the user
     * 
     * uses stack to store the resulting values
     * 
     */
    public static void convertToBase(int num,int base,ArrayStack stack)
    {
        int quotient = num;
        int remainder = 0;

        do {
            remainder = quotient % base;
            quotient = quotient / base;

            stack.push(remainder);

        } while (quotient != 0);

        
    }

}