
/**
 * Write a description of interface Queue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class Queue
{
    ArrayList<Customer> q = new ArrayList<Customer>();
    /**
     * default constructor for this class
     */
    public Queue()
    {
        
    }
    
    public Queue(int testCustomer)
    {
        for(int i = 0;i <testCustomer;i++){
            add();
        }
        
    }

    public void add()
    {
        q.add(new Customer());
    }
    
    public void add(String name,int id)
    {
        q.add(new Customer(name,id));
    } 
    /**
     * this method returns the element at the front of the container
     * @returns Customer - returns the Customer at the front of the line
     */
    public Customer peek()
    {
        return q.get(0);
    }
    /**
     * this method returns the element at the front of the container
     * and then removes the element
     * @returns custom - the Customer object at the front of the queue
     * 
     */
    public Customer poll()
    {
        Customer custom = q.get(0);
        q.remove(0);
        return custom;
    }
    public Customer getLast()
    {
        return q.get(size()-1);
    }
    /**
     * this method checks for wether the queue is empty and returns a boolean
     * @returns boolean - boolean for whether the queue is empty
     * 
     */
    public boolean isEmpty()
    {
        return q.isEmpty();
    }
    /**
     * this method returns the length of the queue
     * @returns size - the int value representing the length of the queue
     */
    public int size()
    {
        return q.size();
    }
    
    /**
     * 
     */
    public String toString()
    {
        String fulllist = "";
        for(int i = 0; i < q.size();i++){
            fulllist = fulllist +String.format("\n %d) %s",i+1, q.get(i).toString());
        }
        return fulllist;
    }
}
