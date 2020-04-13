
/**
 * this class is the driver class for this program
 *
 * @author Kyle Fedalen
 * @version 4/10/2020
 */
import java.util.Random;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
public class MainProgram
{
    /**
     * this is the main method for this program
     */
    public static void main()
    {
        int totalemployed = 10;
        Map<Integer,Employee>employees = new HashMap<Integer,Employee>();
        Set<Integer> keySet = employees.keySet();

        //generates a nonrandom employee for seccesful data retrevial later in program
        Employee stable = new Employee(545,"StableEmp",65000);
        employees.put(stable.getId(),stable);

        
        //generates totalemployed number of employees 
        for(int i = totalemployed;i > 0;i-- )
        {
            Employee n = createTestEmployee();
            // 232 is reserved for fail to find data retrevial later in program
            if(isUsed(n.getId(),employees,keySet) == false|| n.getId() == 232){
                employees.put(n.getId(),n); 
            }else{
                System.out.printf("%s\n","id used... generating another");
                totalemployed++;
            }
        }

        System.out.printf("%30s\n","Employee Database");
        System.out.printf("------------------------------------------\n");

        for(int key : keySet)
        {
            Employee emp = employees.get(key);
            System.out.printf("%4s%-3d%7s%-36s\n","Key:",key,"  -->  ",emp.toString());
        }

        
        //does 1 successfull data retrevial and 1 failed data retrevial.
        //throws Exception if data retrevial unsuccesfull
        try{
            System.out.printf("%s\n","---------------------------------------");
            System.out.printf("%sid:%d%s\n","searching for ",545," data...");
            dataGet(545,employees,keySet);
            System.out.printf("%s\n","---------------------------------------");
            System.out.printf("%sid:%d%s\n","searching for ",232," data...");
            dataGet(232,employees,keySet);
            System.out.printf("%s\n","---------------------------------------");
        }catch(Exception e){
            System.out.println(e);
            System.out.printf("%s\n","---------------------------------------");
        }

        //displays all employees with a salary over a threshold
        displayFilter(60000,employees,keySet);

    }
    
    public static void dataGet(int id, Map<Integer,Employee>employees,Set<Integer> keySet) throws Exception
    {
        Employee n = null;

        for(int key : keySet)
        {
            Employee emp = employees.get(key);
            if(key == id){
                n = emp;
                System.out.printf("%s%s%s\n","getting ",n.getName()," data...");
            }
        }
        if(n == null){
            throw new Exception("no data found for id:" + Integer.toString(id));
        }

        System.out.printf("%s\n",n.toString());

    }
    /**
     * this method prints out a list of employees who have a salary above the threashold
     * 
     * @pram threshold - the minimum salary for the program to print out
     * @pram employees - the pass through for the Map of Employee objects
     * @pram keySet - the pass through for the keyset
     */
    public static void displayFilter(double threshold, Map<Integer,Employee>employees,Set<Integer> keySet)
    {

        System.out.printf("%30s\n","Employee Database");
        System.out.printf("%10s$%,7.0f\n","Filtered threshold:",threshold);
        System.out.printf("------------------------------------------\n");
        for(int key : keySet)
        {
            Employee emp = employees.get(key);
            if(emp.getSalary() >= threshold){
                System.out.printf("%4s%-3d%7s%-36s\n","Key:",key,"  -->  ",emp.toString());
            }
        }
    }
    /**
     * this method returns if the id is already in use in the given Map
     * @pram id - the employee id to check if it has been used
     * @pram employees - the pass through for the Map of Employee objects
     * @pram keySet - the pass through for the keyset
     */
    public static boolean isUsed(int id, Map<Integer,Employee>employees,Set<Integer> keySet){

        for(int key : keySet)
        {
            Employee emp = employees.get(key);
            if(emp.getId() == id){
                return true;
            }
        }
        return false;
    }

    /**
     * this method generates an employee object with
     * a random id 1-999
     * a name that is TestEmp + id
     * a random salary $20,000 - $120,000
     * @return n - the generated employee object.
     */
    public static Employee createTestEmployee()
    {
        Random rand = new Random();
        int eid = rand.nextInt(1000)+1;
        double min = 20000;
        double max = 120000;
        double esal =  min + (max - min) * rand.nextDouble();

        Employee n = new Employee(eid,"TestEmp"+Integer.toString(eid),esal);
        return n;

    }
}
