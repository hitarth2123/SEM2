import java.io.*;
public class FileWriterEx2 {
    public static void main(String[] args) {
        File f=new File("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/OutputFile.txt");
    try (FileWriter writer = new FileWriter(f, true)) {
        writer.write("\n ApPending one line");
        System.out.println("Data written successfully.");
        writer.close();
    } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
    }
    }
}

