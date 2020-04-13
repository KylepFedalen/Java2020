
/**
 * this is the class for the Employee object
 *
 * @author Kyle Fedalen
 * @version 4/10/2020
 */
import java.util.Random;
public class Employee
{
    private int id;
    private String name;
    private double salary;
    /**
     * this is the default constructor for this class
     */
    public Employee()
    {
        // initialise instance variables
        id = 0;
        name ="default";
        salary = 0;
    }
    /**
     * this constructor taken in and sets the Employee varables
     * @pram E_id - the Employee id variable, acts as key
     * @pram E_name - the Employee name variable
     * @pram E_sal - the Employee salary varable
     */
    public Employee(int E_id,String E_name, double E_sal)
    {
        id = E_id;
        name = E_name;
        salary = E_sal;
    }

    /**
     * this method gets the Employee id
     * @return id - the Employee id 
     */
    public int getId()
    {
        return id;
    }
    /**
     * this method gets the Employee name
     * @return name - the Employee name
     */
    public String getName()
    {
        return name;
    }
    /**
     * this method gets the Employee salary
     * @return salary - the Employee salary
     */
    public double getSalary()
    {
        return salary;
    }
    /**
     * this method sets the Employee id
     * @pram E_id - the new value for the id
     */
    public void setId(int E_id)
    {
        id = E_id;
    }
    /**
     * this method sets the Employee name
     * @pram E_name - the new value for the name
     */
    public void setName(String E_name)
    {
        name = E_name;
    }
    /**
     * this method sets the Employee salary
     * @pram E_sal - the new value for the salary
     */
    public void setSalary(double E_sal)
    {
        salary = E_sal;
    }
    /**
     * this method returns the Employee information formatted into a string
     * @return str - formated string of Employee data
     */
    @Override
    public String toString()
    {

        String str = String.format("%3s%-3d%6s%-10s%8s$%,7.0f","ID:",id," Name:",name," Salary:",salary);
        return str;
    }
}
