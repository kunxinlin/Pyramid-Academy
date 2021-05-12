import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class RecordRW {
     HashSet<File> files = new HashSet<>();
     ArrayList<String> filenames=new ArrayList<>();
    String[] sentences;
    File currentFile;
    String currDir = System.getProperty("user.dir");
    Scanner in = new Scanner(System.in);
    File fileLookup = new File(System.getProperty("user.dir") + "\\src\\" + "files" + ".txt");
    File fileFull =new File(currDir + "\\src\\" + "Full files" + ".txt");
public RecordRW()
{
    fileFull=new File(currDir + "\\src\\" + "Full files" + ".txt");
    if(fileFull.exists())
    {
        getFile();
    }
    else
    {
        try {
            FileWriter fw=new FileWriter(fileFull);
            fw.write(" ");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    public void getFile()
    {


        FileWriter fw= null;

        try {
                Scanner scan = new Scanner(fileFull);
                while (scan.hasNextLine()) {
                    File a = new File(scan.nextLine());
                    files.add(a);
                }
            fw = new FileWriter(fileFull);
            for(File f:files)
            {
                if(!f.getName().equals(" ")){
                fw.append(f.getAbsolutePath()+"\n");
                fw.flush();}
            }

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public void readSaveFile(int index) {
        for (File a : files) {
            if (files.size() < index - 1) {
                System.out.println("Pick a number in the List");
                readSaveFile(in.nextInt() - 1);
            } else {
//                currentFile = files.get(index - 1);
            }
        }
        try {
            Scanner read = new Scanner(currentFile);
            while (read.hasNextLine())
                System.out.println(read.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeAttendance(ArrayList<Logger.Stu> list, String name) {
        try {
            File file = new File(currDir + "\\src\\" + name + ".txt");
            files.add(file);
            filenames.add(file.getName());
            boolean fvar = file.createNewFile();
            FileWriter fw;
            if (fvar) {
                fw = new FileWriter(file, false);
            } else {
                fw = new FileWriter(file, true);
            }


            LocalDate localDate = LocalDate.now();
            System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate));

            fw.append(DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate) + "\n");
            fw.append("\n");
            fw.append("Here: \n");
            for (Logger.Stu l : list) {
                if (l.choice.equals("is Here")) {
                    fw.append(l.name1 + "\n");
                }
            }
            fw.append("\n");
            fw.append("Absent: \n");
            for (Logger.Stu b : list) {
                if (b.choice.equals("is Absent")) {
                    fw.append(b.name1 + "\n");
                }
            }
            fw.append("\n");
            fw.append("Late: \n");
            for (Logger.Stu c : list) {
                if (c.choice.equals("is late")) {
                    fw.append(c.name1 + "\n");
                }
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write(String name, List<Employee> emp) throws IOException {

        int x = 0;
        File file = new File(currDir + "\\src\\" + name + ".txt");
        files.add(file);
        filenames.add(file.getName());
        FileOutputStream fos = new FileOutputStream(file);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));



        for(Employee a:emp){
            String line= String.format(a.firstName+","+a.lastName+","+a.email+","+a.phone+","+a.id+","+a.numOfTimesAbsent+"\n");
            bw.append(line);
            System.out.println();
        }
        bw.flush();
        bw.close();
    }

    public ArrayList<Employee> read() {
        ArrayList<Employee> de = new ArrayList<>();

        File file = new File(currDir + "\\src\\Employees.txt");
        try {
            Scanner readF=new Scanner(file);
            while(readF.hasNextLine())
            {
                String [] r=readF.nextLine().split(",");
                    Employee t = new Employee(r[0],r[1]);
                    t.email=r[2];
                    t.phone=r[3];
                    t.id=Integer.parseInt(r[4]);
                    t.numOfTimesAbsent=Integer.parseInt(r[5]);
                    de.add(t);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return de;
    }

    public void update(List<Employee> d) {
        File file = new File(currDir + "\\src\\Employees.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (Employee r : d) {
                bw.write(r.firstName + "," + r.lastName + "," + r.email + "," + r.phone +","+r.id+","+r.numOfTimesAbsent+"\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
