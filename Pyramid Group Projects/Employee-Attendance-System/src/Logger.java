


import java.io.File;
import java.util.*;

public class Logger {
    Scanner scan = new Scanner(System.in);
    RecordRW rw;
    ArrayList<Stu> abc= new ArrayList<>();   // An Arraylist that will contain input of who's here and whos not.
    ArrayList<Stu> absent=new ArrayList<>();   // An Array List that will keep track of who's absent. this arraylist will also be us in the is late method
    ArrayList<Employee>emp = new ArrayList<>();   // Arraylist with a list of employees names (first and last names)

public Logger(RecordRW rw)    // constructor added to add contents within the logger class into the Records class in order to append to file writer
{
    this.rw=rw;
}
     class Stu {     // class created to use as a class within abc arraylist and absent arraylist,
        String name1;  // this name will be pulled from emp arraylist
        String choice; // "is here" or "is absent" will be displayed in the println statement
        int id;         // employee id
        Boolean here; // is here?
        Boolean late ; // is late?

        public Stu(String c,String m,int id, Boolean a, Boolean b) {
            this.name1 = c;
            this.choice = m;
            this.id=id;
            this.here = a;
            this.late = b;
        }
    }

    public void callAttendance(ArrayList<String> names) {
        for(File f:rw.files)              // will write to file writer "Employees.txt"
        {
            if(f.getName().equals("Employees.txt"))
            {
                emp=rw.read();
            }
        }


        boolean isHere;
        boolean isLate;
        int x=0;                   // x initiated to increment "id number" ie 101,102,103 .......

        for (String name : names) {      // traversing through emp arraylist
            System.out.println("Is " + name + " here?");
            // may have to add another string variable to coincide with first input
            String ans = "";
            while (!ans.toLowerCase().equals("yes") && (!ans.toLowerCase().equals("no"))) {
                ans = scan.next();

                if (ans.toLowerCase().equals("yes")) {
                    isHere = true;
                    isLate = false;


                    abc.add(new Stu (name,"is Here",emp.get(x).id, isHere,isLate));   // whoever is here is added to the arraylist of who's here and who's' not here

                } else if (ans.toLowerCase().equals("no")) {
                    isHere = false;
                    isLate = false;
                    absent.add(new Stu(name,"is Absent",emp.get(x).id,isHere,isLate));  // who ever is not here is added to the absent arraylist to use later in the is late method
                    abc.add(new Stu(name,"is Absent", emp.get(x).id,isHere, isLate));   // who ever is not here is added to the abc arraylist
                } else {
                    System.out.println("Invalid answer, enter yes or no.");
                    ans = scan.next();
                }
            }
x++;

        }

    }
    public  void latePerson(int index){
        for(File f:rw.files)                        // method to writ to file writer
        {
            if(f.getName().equals("Employees.txt"))
            {
                emp=rw.read();
            }
        }
        int x=0;           // this will increment the amount of absents???
        for(Stu s:abc){
            if(s.id==absent.get(index).id) {    //getting
                abc.set(x, new Stu(absent.get(index).name1, "is late", absent.get(index).id, true, true));
            }
            x++;
        }
        System.out.println(absent.get(index).name1 + " is marked late");
        absent.remove(index);




    }
}


