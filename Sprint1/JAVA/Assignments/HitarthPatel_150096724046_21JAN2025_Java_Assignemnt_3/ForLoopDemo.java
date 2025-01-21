// Program to print even numbers between 1-10.
class ForLoopDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        System.out.println("Loop Ending");
    }
}
