import java.util.Scanner;

public class InvoiceItem {
    private String id;
    private String description;
    private int quantity;
    private double unitPrice;

    public InvoiceItem(String id, String description, int quantity, double unitPrice) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public InvoiceItem() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return quantity * unitPrice;
    }

    public static void main(String[] args) {
        InvoiceItem item = new InvoiceItem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Invoice Item ID: ");
        item.setId(scanner.nextLine());

        System.out.println("Enter Invoice Item Description: ");
        item.setDescription(scanner.nextLine());

        System.out.println("Enter Invoice Item Quantity: ");
        item.setQuantity(scanner.nextInt());
        scanner.nextLine(); // Consume newline left-over

        System.out.println("Enter Invoice Item Unit Price: ");
        item.setUnitPrice(scanner.nextDouble());
        scanner.nextLine(); // Consume newline left-over

        System.out.println("ID: " + item.getId());
        System.out.println("Description: " + item.getDescription());
        System.out.println("Quantity: " + item.getQuantity());
        System.out.println("Unit Price: " + item.getUnitPrice());
        System.out.println("Total: " + item.getTotal());

        scanner.close();
    }
}
