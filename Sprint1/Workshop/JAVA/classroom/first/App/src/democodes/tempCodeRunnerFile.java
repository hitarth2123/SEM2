package democodes;

import java.io.File;


class FileDemo {
 public static void main(String[] args) {
    File f1=new  File("abc.txt");
    try{
        f1.createNewFile();
    }
    catch(Exception e)
    {
        System.out.println("Error in creating file ");
    }
 }

}
