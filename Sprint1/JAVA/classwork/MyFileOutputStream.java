import java.io.*;
public class MyFileOutputStream {
    public static void main(String[] args) {
    try (java.io.FileOutputStream fos = new java.io.FileOutputStream("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/WelcomeMessage.txt")) {
        String s = "Welcome to java learners ";
        byte[] b = s.getBytes();
        fos.write(b);
        System.out.println("File written successfully.");
    } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
    }
    }
    
}
