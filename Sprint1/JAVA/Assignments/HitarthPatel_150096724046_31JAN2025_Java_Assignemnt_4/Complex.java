import java.util.Scanner;

public class Complex {
    private double real;
    private double imag;

    public Complex() {
        this.real = 0;
        this.imag = 0;
    }

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex add(Complex n) {
        return new Complex(this.real + n.getReal(), this.imag + n.getImag());
    }

    public Complex subtract(Complex n) {
        return new Complex(this.real - n.getReal(), this.imag - n.getImag());
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public double getReal() {
        return this.real;
    }

    public double getImag() {
        return this.imag;
    }

    public String toString() {
        return this.real + " + " + this.imag + "i";
    }
}

class ComplexDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter real part of first complex number: ");
        double real1 = scanner.nextDouble();
        System.out.println("Enter imaginary part of first complex number: ");
        double imag1 = scanner.nextDouble();

        System.out.println("Enter real part of second complex number: ");
        double real2 = scanner.nextDouble();
        System.out.println("Enter imaginary part of second complex number: ");
        double imag2 = scanner.nextDouble();

        Complex c1 = new Complex(real1, imag1);
        Complex c2 = new Complex(real2, imag2);

        System.out.println("First complex number: " + c1.toString());
        System.out.println("Second complex number: " + c2.toString());

        Complex sum = c1.add(c2);
        System.out.println("Sum: " + sum.toString());

        Complex difference = c1.subtract(c2);
        System.out.println("Difference: " + difference.toString());

        scanner.close();
    }
}

