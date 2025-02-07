import java.util.Scanner;

class Box {
    protected double width;
    protected double height;
    protected double depth;

    public Box() {
        this.width = 0;
        this.height = 0;
        this.depth = 0;
    }

    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }
}

class BoxWt extends Box {
    protected double weight;

    public BoxWt() {
        super();
        this.weight = 0;
    }

    public BoxWt(double width, double height, double depth, double weight) {
        super(width, height, depth);
        this.weight = weight;
    }

    public BoxWt(BoxWt ob) {
        super(ob.getWidth(), ob.getHeight(), ob.getDepth());
        this.weight = ob.weight;
    }

    public void print_BoxWt() {
        System.out.println("Width: " + getWidth() + ", Height: " + getHeight() + ", Depth: " + getDepth() + ", Weight: " + weight);
    }
}

class BoxColor extends BoxWt {
    private String color;

    public BoxColor(double width, double height, double depth, double weight, String color) {
        super(width, height, depth, weight);
        this.color = color;
    }

    public void print_BoxColor() {
        System.out.println("Width: " + getWidth() + ", Height: " + getHeight() + ", Depth: " + getDepth() + ", Weight: " + weight + ", Color: " + color);
    }
}

public class Bx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter width for BoxWt: ");
        double widthWt = scanner.nextDouble();
        System.out.println("Enter height for BoxWt: ");
        double heightWt = scanner.nextDouble();
        System.out.println("Enter depth for BoxWt: ");
        double depthWt = scanner.nextDouble();
        System.out.println("Enter weight for BoxWt: ");
        double weightWt = scanner.nextDouble();

        BoxWt boxWt = new BoxWt(widthWt, heightWt, depthWt, weightWt);
        boxWt.print_BoxWt();

        System.out.println("Enter width for BoxColor: ");
        double widthColor = scanner.nextDouble();
        System.out.println("Enter height for BoxColor: ");
        double heightColor = scanner.nextDouble();
        System.out.println("Enter depth for BoxColor: ");
        double depthColor = scanner.nextDouble();
        System.out.println("Enter weight for BoxColor: ");
        double weightColor = scanner.nextDouble();
        System.out.println("Enter color for BoxColor: ");
        String color = scanner.next();

        BoxColor boxColor = new BoxColor(widthColor, heightColor, depthColor, weightColor, color);
        boxColor.print_BoxColor();

        scanner.close();
    }
}

