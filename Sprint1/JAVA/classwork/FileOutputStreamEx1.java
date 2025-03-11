import java.io.*;

public class FileOutputStreamEx1 {
   public static void main(String[] args) {
    try (FileInputStream fis = new FileInputStream("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/Try123.txt"); FileOutputStream fout = new FileOutputStream("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/Try1234.txt")){
        int b;
        while ((b = fis.read()) != -1) {
          fout.write(b);
        }
    } catch (IOException e) {
        System.out.println("Error in file handling"+e);
    }
   }
}
