
/**
 * this class is a stack object that is used to store and acces integers
 *
 * @author Kyle Fedalen
 * @version 3/287/2020
 */
import java.util.Arrays;

public class ArrayStack
{
    // instance variables 

    private int[] stack = new int[0];
   
    private int size;
    /**
     * Constructor for objects of class Stack
     */
    public ArrayStack()
    {
        size = 0;
    }
    /**
     * this method emptys a single element out of the stack 
     */
    public void empty()
    {
        size--;
        int[] newarr = Arrays.copyOf(stack,size);
        stack = newarr;
        
    }
    /**
     * this method emptys all elements from the stack
     */
    public void emptyStack()
    {
        size = 0;
        int[] newarr = Arrays.copyOf(stack,size);
        stack = newarr;
    }
    /**
     * this method pushes an element into the stack
     * the element is added to the back end of the stack
     * @pram num - the number to push into the stack
     */
    public void push(int num)
    {
        size++;
        int[] newarr = Arrays.copyOf(stack,size);
        for(int i =0;i<newarr.length-1;i++){
            int newnum = newarr[i+1];
            newarr[i+1] = newnum;
        
        }
        stack = newarr;
        stack[size-1] = num;
        
    }
    /**
     * this method removes the last element from the stack and returns the value
     * @returns nwenum - the number that has been removed and poped out of the stack
     */
    public int pop()
    {
        
        int newnum = stack[stack.length-1];
        size--;
        int[] newarr = Arrays.copyOf(stack,size);
        stack = newarr;
        
        return newnum;

    }
    /**
     * this method returns the size of the stack
     * @returns size - the size of the stack
     */
    public int size()
    {
        return size;
    }
    
    
    
    /**
     * this method returns the whole stack as a single string
     * @returns tempstr - all the stack emelents represented as a single string
     */
    @Override
    public String toString()
    {
        String tempstr = "";

        for(int i = stack.length; i > 0;i--){
            tempstr = tempstr + pop();
        }

        return tempstr;
    }

}
