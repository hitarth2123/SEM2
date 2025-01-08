public class ShortCircuitOperators {
    public static void main(String[] args) {
        // Short-circuit AND (&&)
        System.out.println("Short-circuit AND (&&):");
        boolean a = true;
        boolean b = false;
        System.out.println(a + " && " + b + ": " + (a && b));

        a = false;
        b = true;
        System.out.println(a + " && " + b + ": " + (a && b));

        // Short-circuit OR (||)
        System.out.println("\nShort-circuit OR (||):");
        a = true;
        b = false;
        System.out.println(a + " || " + b + ": " + (a || b));

        a = false;
        b = true;
        System.out.println(a + " || " + b + ": " + (a || b));
    }
}