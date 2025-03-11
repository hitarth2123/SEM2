import java.io.*;

public class FileInputStreamEx2 {
    public static void main(String[] args) {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/Try123.txt");
            int b;
            while ((b = fin.read()) != -1) {
                System.out.print((char) b);
            }
        }catch ( FileNotFoundException e){
            System.out.println("File not found exception");
        }catch (IOException e) {
            System.out.println("IO Error");;
        } 
    }
}
