import java.io.*;
public class FileWriterEx1 {
    public static void main(String[] args) {
    String data = "This is the data in the output file";
    try (FileWriter writer = new FileWriter("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/OutputFile.txt")) {
        writer.write(data);
        System.out.println("Data written successfully.");
        writer.close();
    } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
    }
    }
}
