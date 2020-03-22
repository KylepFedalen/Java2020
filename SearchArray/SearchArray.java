
/**
 * Write a description of class SearchArray here.
 *
 * @author Kyle Fedalen
 * @version 3/14/2020
 */
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class SearchArray
{
    /**
     * this is the main mathod for this class
     */
    public static void main(){
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        int[] myarray = new int[15];

        boolean ok = false;
        int svalue = 0;
        int sindex = 0;
        int emptyspace = 0;

        System.out.printf("program starting...\n");
        
        for(int i = 0; i < myarray.length;i++){
            if(i < 10){
                myarray[i] = rand.nextInt(999)+1;
            }else{
                emptyspace++;
                myarray[i] = 0;
            }
        }
        System.out.printf("\nunsorted array \n");
        displayArray(myarray,true);
        System.out.printf("\npress enter to continue...");
        in.nextLine();

        do{
            System.out.printf("\f");
            Arrays.sort(myarray);
            System.out.printf("\n\n%s\n","sorted array");
            displayArray(myarray,false);

            System.out.printf("\nempty space: %d\n", emptyspace);

            System.out.printf("\nenter value to search or enter -1 to quit\n>");
            svalue = in.nextInt();
            if(svalue == -1){
                break;
            }
            sindex = Arrays.binarySearch(myarray,svalue);
            int szindex = myarray.length-(myarray.length + sindex );
            int findex = ((myarray.length - emptyspace) - szindex)-myarray.length;
            int nfindex = szindex - emptyspace - 1;

            if(sindex < 0){
                System.out.printf("%d was not found in index\n",svalue);
                if(isFull(myarray) == false){
                    System.out.printf("insert %d into array at index %d? (Y or N?) or enter q to quit\n",svalue,nfindex);
                    char chIn = in.next().charAt(0);
                    if(isYorN(chIn)==true){
                        insert(myarray,szindex,svalue);
                        emptyspace--;
                    }else if(chIn == 'q'){
                        break;
                    }
                }
            }else{
                System.out.printf("%d was found at index %d\n",svalue,findex);
                System.out.printf("Remove %d from array?(Y or N?) or enter q to quit\n",svalue);
                char chRm = in.next().charAt(0);
                if(isYorN(chRm)==true){
                    remove(myarray,Arrays.binarySearch(myarray,svalue));
                    emptyspace++;
                    System.out.printf("%d removed...\n",svalue);
                }else if(chRm == 'q'){
                    break;
                }

            }

        }while(!ok);
        System.out.printf("\nprogram ending...");
    }
    /**
     * this method is a boolean check to see if givin array is full
     * @pram a - integer array 
     */
    public static boolean isFull(int[] a)
    {
        if(Arrays.binarySearch(a, 0)==-1){
            return true;
        }else
            return false;
    }
    /**
     * this method takes in a char and if that char equals y returns true or n == false
     * returns false if any othe char is entered
     * @pram c - character to check for y or n
     */
    public static boolean isYorN(char c)
    {
        
        if(c == 'Y'|| c == 'y'){
            return true;
        }else if(c == 'N'||c=='n'){
            return false;
        }else
            return false;
    }
    /**
     * this method displays the array and an array index 
     * if displayZeros is false the printout will not print 
     * any zeros that may exist in the list
     * @pram a - integer array
     * @pram displayZeros - boolean to determin wether to print zero elements
     */
    public static void displayArray(int[] a,boolean displayZeros){
        //uncomment to display index over the list
        int count = 0;
        for(int i = 0; i < a.length;i++){
            if(displayZeros == true){
                System.out.printf("%-3d, ",i);
            }
            else if(displayZeros == false && a[i] != 0){

                System.out.printf("%-3d, ",count);
                count++;
            }
        }

        System.out.printf("\n");
        for(int i = 0; i < a.length;i++){
            if(displayZeros == true){
                System.out.printf("%-3d, ",a[i]);
            }
            else if(displayZeros == false && a[i] != 0){
                System.out.printf("%-3d, ",a[i]);
            }

        }
    }

    /**
     * this method swaps two elements palces within a list.
     * @pram a - integer array
     * @pram index1 - first index, the element at this index will be swaped with index2 
     * @pram index2 - second index, the element at this index will be swaped with index1 
     */
    public static void swap(int[] a, int index1, int index2)
    {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
    /**
     * this method sets an element in an array to zero 
     * then swaps the new zero element untill it is 
     * ordered with the other empty[0] elements in the array
     * @pram a - integer array
     * @pram index - the index of the element to "remove"/ set to zero
     */
    public static void remove(int[] a, int index)
    {
        a[index] = 0;
        for(int i = index;i > 0;i--){
            swap(a,i-1,i);
        }
    }
    /**
     * this method inserts a new value within an array at the specified index
     * @pram a - integer array
     * @pram index - the index for the new element
     * @pram value - the new value to be inserted
     */
    public static void insert(int[] a, int index,int value)
    {

        a[0] = value;
        for(int i = 0;i < index;i++){
            swap(a,i,i+1);

        }

    }

}
