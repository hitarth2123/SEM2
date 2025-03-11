package democodes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileDemo {
 public static void main(String[] args) {
    // File f1=new  File("abc.txt");
    // try{
    //     f1.createNewFile();
    // }
    // catch(Exception e)
    // {
    //     System.out.println("Error in creating file ");
    // }

//     try{
//         FileWriter fw=new FileWriter("xyz.txt");
//         fw.write("Hello World");
//         fw.close();
//     }
//     catch(Exception e)
//     {
//         System.out.println("Error in writing to file ");
//     }


        File f3= new File("pop.txt");
        try{
            Scanner sc=new Scanner(f3);
            while(sc.hasNextLine())
            {
                String data=sc.nextLine();
                System.out.println(data);

            }
            sc.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error in reading file ");
        }
        File f4 =new File("abc.txt");
        f4.delete();


 }


}
