
/**
 * this program asks the user to input a string of numbers, 
 * then it converts the string into an integer via recursion,
 * the program continues to collect input from the user untill 
 * it recieves correct input telling it to stop
 * after it is done recieving input the program then gives the
 * sum and average of all the input numbers
 * user input is limited to 8 characters to prevent overflow
 *
 * @author Kyle Fedalen
 * @version 2/12/2020
 */

import java.util.Scanner;
import java.util.InputMismatchException;
public class Conversion
{
    /**
     * this is the main class for this program
     */
    public static void main()
    {
        System.out.printf("%s \n","Program Start...");
        Scanner in = new Scanner(System.in);
        int sum = 0;
        double average = 0.0;
        double avg[] = new double[0];
        
        boolean ok = false;
        do{
            System.out.printf("%s \n", "enter q to exit the program");
            System.out.printf("%s \n> ", "input a string of numbers:");
            
            
            try{
                String str = in.nextLine();
                if(str.equals("q")){
                    break;
                }
                isNumString(str);
                
                int num= stringToInt(str);
                avg = collectAverage(num, avg);
                average = getAverage(avg);
                sum += num;
                
            }catch(Exception e){
                System.out.println(e);
            }
        
        }while(!ok);
        
        System.out.printf("%s %d \n", "sum: ",sum);
        System.out.printf("%s %.1f \n", "avrage: ",average);
        
        System.out.printf("%s \n","Program End...");
    }
    /**
     * takes in int and array, coppys array and makes a new array + 1, 
     * then adds int(converted to a double)to the end of the new array 
     * then returns an array of doubles
     * @param x - the new number to add to the end of the array
     * @param a[] - the array that stores the entered numbers
     * @return avArr - returns the array at the new length
     */
    public static double[] collectAverage(int x,double a[]){
        double avArr[] = new double[a.length+1];
        for(int i = 0;i< a.length;i++){
            avArr[i] = a[i];
        }
        double newnum = (double)x;
        avArr[avArr.length-1] = newnum;
        return avArr;
    }
    /**
     * goes trough the given array of doubles to get the average
     * then returns the average 
     * @param a[] - the array that stores the entered data
     * @return average - the average of the numbers stored in the array
     */
    public static double getAverage(double a[]){
        double total = 0;
        for(int i = 0;i< a.length;i++){
            total += a[i];
        }
        double average = total / a.length;
        return average;
    }   
    /**
     * checks the input string for non number characters or 
     * whitespace if found throws exception.
     * also checks if the user input is over 8 characters long, if true throws exception.
     * @param s - the user input string to check
     * @throws Exception - throws exception when input string
     * has whitespace, non number characters or is too long
     */
    public static void isNumString(String s)throws Exception{
        for (int i = 0; i < s.length(); i++){
            if(s.length() > 8){
                System.out.printf("str len: %d \n",s.length());
                throw new Exception("Error: Input to long. Please enter a string 8 long or smaller.");
            }
            if(Character.isWhitespace(s.charAt(i))){
                throw new Exception("Error: No spaces are allowed");
            }
            else if(Character.isDigit(s.charAt(i))==false){
                throw new Exception("Error: Only numbers are allowed");
            }
        }
    }
    /**
     * this method uses recursion to go through a string of 
     * numbers to convert them into a single integer
     * @pram s - the string of numbers to convert
     * @return a - the int resulting from the string of numbers being converted
     */
    public static int stringToInt(String s)
    {   
        
        if (s.length() == 1){
            return (s.charAt(0) - '0');
        }
             
  
        double b = stringToInt(s.substring(1)); 
          
        double a = s.charAt(0) - '0'; 
  
        a = a * Math.pow(10, s.length() - 1) + b; 
        return (int)(a);
    }
    
}
