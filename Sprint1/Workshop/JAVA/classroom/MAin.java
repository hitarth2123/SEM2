class MAin {
    public static void main(String[] args) {
        Student s1= new Student();
        s1.id=1;
        s1.name="Raj";
        s1.age=12;

        System.out.println("STudent details are:");
        System.out.println("id : "+s1.id);
        System.out.println("name : "+ s1.name); 
        System.out.println("age : "+s1.age);
        System.out.println("class : "+Student.studentClass);
    }
}

class Student{
    int id ;
    String name ;
    static String studentClass="ITM";
    int age;

}