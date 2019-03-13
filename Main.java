
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner ;

/**
 *
 * @author SHREE
*/
class information {
    
    String name ;
    double pointer ;
    int token ;
    information(String temp)
    {
        String[] info = new String[3];
        info = temp.split(" ");
        name = info[1];
        pointer = Double.parseDouble(info[2]);
        token = Integer.parseInt(info[3]);
    }
    information()
    {
        
    }
    
}
class Main { 
   public static void main(String args[]) throws IOException { 
        Scanner scan = new Scanner(System.in);
        
        int steps = scan.nextInt(); 
        InputStreamReader inpRead = new InputStreamReader (System.in);
        BufferedReader BuffRead = new BufferedReader (inpRead);
        
       
        ArrayList<information> problem = new ArrayList<information>();         
        for(int z=0 ; z<steps ; z++)
        {             
           
            String my = BuffRead.readLine();
        
         if(my.contains("ENTER"))
          {
              problem.add(new information(my));
              problem=sort(problem);
           
          }
          else
          {
            if(problem.size()!=0)  
            {
                problem.remove(0);
            }
          }
        }
        if(problem.size()!=0)
        { for(int i=0 ; i<problem.size() ; i++)
        {
            System.out.println(problem.get(i).name);
        }
        }
        else
        {
            System.out.println("EMPTY");
        }
 
   }
   static ArrayList<information> sort(ArrayList<information> problem)
    {
      
    for(int i=0 ; i<problem.size() ; i++)
           {
            for(int j=0 ; j<problem.size()-1;j++)
            {
                information temp_1 = problem.get(j);
                information temp_2 = problem.get(j+1);
                information temp = new information() ;
                
                if(temp_1.pointer==temp_2.pointer)
                {
                    if(temp_1.name.equals(temp_2.name))
                    {
                     if(temp_1.token>temp_2.token)
                     {
                        temp.pointer = temp_1.pointer;
                        temp.name = temp_1.name;
                        temp.token = temp_1.token;
                        temp_1.pointer = temp_2.pointer;
                        temp_1.name = temp_2.name;
                        temp_1.token = temp_2.token;
                        temp_2.pointer = temp.pointer;
                        temp_2.name = temp.name;
                        temp_2.token = temp.token;
                     }
                    }
                    else
                    {
                    int great = temp_1.name.compareTo(temp_2.name);
                    if(great>0)
                    {
                        temp.pointer = temp_1.pointer;
                        temp.name = temp_1.name;
                        temp.token = temp_1.token;
                        temp_1.pointer = temp_2.pointer;
                        temp_1.name = temp_2.name;
                        temp_1.token = temp_2.token;
                        temp_2.pointer = temp.pointer;
                        temp_2.name = temp.name;
                        temp_2.token = temp.token;
                    }
                    }
                }
                else
                {
                    if(temp_1.pointer<temp_2.pointer)
                    {
                       
                        temp.pointer = temp_1.pointer;
                        temp.name = temp_1.name;
                        temp.token = temp_1.token;
                        temp_1.pointer = temp_2.pointer;
                        temp_1.name = temp_2.name;
                        temp_1.token = temp_2.token;
                        temp_2.pointer = temp.pointer;
                        temp_2.name = temp.name;
                        temp_2.token = temp.token;
                        
                    }
                }
            }
           }   
       return problem ;
    }
} 




 