import java.util.Scanner;

public class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public String toString() {
        return "Author[name=" + name + ",email=" + email + ",gender=" + gender + "]";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Author's Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Author's Email: ");
        String email = scanner.nextLine();

        System.out.println("Enter Author's Gender (m/f): ");
        char gender = scanner.next().charAt(0);

        Author author = new Author(name, email, gender);

        System.out.println(author.toString());

        System.out.println("Enter new Email: ");
        String newEmail = scanner.next();
        author.setEmail(newEmail);

        System.out.println("Updated Author's Information: ");
        System.out.println(author.toString());

        scanner.close();
    }
}



