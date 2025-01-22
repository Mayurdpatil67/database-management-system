//CDMS 
import java.lang.*;
import java.util.*;

// create table student(RID int, Name varchar(255), Salary int);
// Database table / schema
class Student
{
    public int RID;
    public String Name;
    public int Salary;

    private static int Generator;

    static
    {
        Generator = 0;
    }

    public Student(String str, int value)
    {
        this.RID = ++Generator;
        this.Name = str;
        this.Salary = value;
    }

    public void DisplayData()
    {
        System.out.println(this.RID + "\t" + this.Name + "\t" + this.Salary);
    }
}

class DBMS1
{
   public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList<>();
    }

    // Insert into student Piyush 1000;
    // select * from student
    public void StartDBMS()
    {
        Scanner scanobj = new Scanner(System.in);

        System.out.println("Mayur's customised DBMS started successfully....");
        String Query = "";

        while(true)
        {
            System.out.print("Mayur's DBMS console >");
            Query = scanobj.nextLine();

            String tokens[] = Query.split(" ");
            int QuerySize = tokens.length;

            if(QuerySize == 1)
            {
                if("Help".equals(tokens[0]))
                {
                    System.out.println("This application is used to demonstrate the customised DBMS");
                    System.out.println("Exit : Terminate DBMS");
                    System.out.println("Display all data : select * from student");
                    System.out.println("Insert data : Insert into student Name Salary");
                    System.out.println("Update data : Update student set Name='XYZ' where RID=1");
                    System.out.println("Update data : Update student set Salary=2000 where RID=1");
                }
                else if("Exit".equals(tokens[0]))
                {
                    System.out.println("Thank you for using Mayur's DBMS");
                    break;
                }
            }
            else if(QuerySize == 2)
            {

            }
            else if(QuerySize == 4)
            {
                if("select".equals(tokens[0]))
                {
                    if("*".equals(tokens[1]))
                    {
                        DisplayAll();
                    }
                }
            }
            else if(QuerySize == 5)
            {
                // Insert into student Piyush 1000;
                if("Insert".equals(tokens[0]))
                {
                     InsertData(tokens[3],Integer.parseInt(tokens[4]));
                }
            }
            else if(QuerySize == 8)
            {
                // Update student set Name='XYZ' where RID=1
                if("Update".equals(tokens[0]))
                {
                    if("Name".equals(tokens[3]))
                    {
                        int rid = Integer.parseInt(tokens[7]);
                        String newName = tokens[5].replace("'", "");
                        UpdateName(rid, newName);
                    }
                    else if("Salary".equals(tokens[3]))
                    {
                        int rid = Integer.parseInt(tokens[7]);
                        int newSalary = Integer.parseInt(tokens[5]);
                        UpdateSalary(rid, newSalary);
                    }
                }
            }

        }
    }

    // Insert into query
    public void InsertData(String str, int value)
    {
        Student sobj = new Student(str,value);
        lobj.add(sobj);
    }

    // Display all without condition
    public void DisplayAll()
    {
        for(Student sref : lobj)
        {
            sref.DisplayData();
        }
    }

    // Display by RID
    public void DisplaySpecific(int rid)
    {
         for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                sref.DisplayData();
                break;
            }
        }
    }

    // Display by name
    public void DisplaySpecific(String str)
    {
         for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                sref.DisplayData();
            }
        }
    }

    // Delete by RID
    public void DeleteSpecific(int rid)
    {
        int index = 0;

        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

    // Delete by Name
    public void DeleteSpecific(String str)
    {
        int index = 0;

        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

    // Update salary by RID
    public void UpdateSalary(int rid, int newSalary)
    {
        for (Student sref : lobj)
        {
            if (sref.RID == rid)
            {
                sref.Salary = newSalary;
                System.out.println("Record updated successfully.");
                return;
            }
        }
        System.out.println("Record not found.");
    }

    // Update name by RID
    public void UpdateName(int rid, String newName)
    {
        for (Student sref : lobj)
        {
            if (sref.RID == rid)
            {
                sref.Name = newName;
                System.out.println("Record updated successfully.");
                return;
            }
        }
        System.out.println("Record not found.");
    }

    public void AggregateMax()
    {
        int iMax = 0;
        Student temp = null;

        for(Student sref : lobj)
        {
            if(sref.Salary > iMax)
            {
                iMax = sref.Salary;
                temp = sref;
            }
        }

        System.out.println("Information of student having maximum salary : ");
        temp.DisplayData();
    }

    public void AggregateMin()
    {
        int iMin = (lobj.getFirst()).Salary;
        Student temp = lobj.getFirst();

        for(Student sref : lobj)
        {
            if(sref.Salary < iMin)
            {
                iMin = sref.Salary;
                temp = sref;
            }
        }

        System.out.println("Information of student having minimum salary : ");
        temp.DisplayData();
    }

    public void AggregateSum()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }

        System.out.println("Summation of salaries is : "+ iSum);
    }

    public void AggregateAvg()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }

        System.out.println("Average salary is : "+ iSum / (lobj.size()));
    }

    public void AggregateCount()
    {
         System.out.println("Count is : "+lobj.size());
    }
}

class DBMS
{
    public static void main(String arg[])
    {
        DBMS dobj = new DBMS();

        dobj.StartDBMS();

        /*dobj.InsertData("Piyush",1000);
        dobj.InsertData("Sakshi",3000);
        dobj.InsertData("Sachin",2000);
        dobj.InsertData("Suraj",10000);
        dobj.InsertData("Atharva",8000);
        dobj.InsertData("Supriya",9000);

        //dobj.DisplaySpecific(2);
        //dobj.DisplaySpecific("Piyush");

        //dobj.DeleteSpecific(2);
        //dobj.DeleteSpecific("Piyush");
        dobj.DisplayAll();

        dobj.AggregateMax();
        dobj.AggregateMin();

        dobj.AggregateSum();
        dobj.AggregateAvg();
        dobj.AggregateCount();*/

    }
}
