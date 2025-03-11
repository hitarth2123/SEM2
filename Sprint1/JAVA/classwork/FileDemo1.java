import java.io.File;
import java.io.IOException;

class FileDemo1 {
    public static void main(String[] args) throws IOException {
        String path =System.getProperty(("user.dir"));
        System.out.println("Working Directory = "+path);

        File f1=new File("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/File1.txt");
        // File f1=new File("File1.txt");
        // File f1= new File ("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/Dir1");
        // File f1=new File ("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/File2.txt");
        System.out.println(f1.exists()? "f1 exists" : "F1 does not exists");
        if(f1.exists()){
            System.out.println("File Name : "+f1.getName());
            System.out.println("Path : "+f1.getPath());
            System.out.println("Absolute Path : "+f1.getAbsolutePath());
            System.out.println("Parent : "+f1.getParent());
            System.out.println("is"+((f1.isDirectory()? " ":"not")+"a directory"));
            System.out.println(f1.isFile()? "is File ":"is not a file ");
            System.out.println("File size :"+f1.length()+"Bytes");
            if(f1.isDirectory()){
                for(File subFile:f1.listFiles())
                    System.out.println(" "+subFile);
            }
        }

        File obj =new File ("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/Try123.txt");
        obj.createNewFile();
        // obj.delete();

        File obj1=new File ("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/try1/try11");
        System.out.println("mkdir "+obj1.mkdir());

        File obj2=new File ("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/try2/try22");
        System.out.println("mkdirs "+obj2.mkdirs());

        File fren1= new File ("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/DirR1");
        File fren2= new File ("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/DirR2");
        System.out.println("rename directory "+fren1.renameTo(fren2));

        File fren3= new File ("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/FileR1.txt");
        File fren4= new File ("/Users/hitarth/Desktop/ISU/SFT/SEM2/Sprint1/JAVA/classwork/FileR2.txt");
        System.out.println("rename file "+fren3.renameTo(fren4));
    }
}
