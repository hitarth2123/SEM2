class Box {
    int width, height, depth;
    Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    Box(Box ob) {
        this.width = ob.width;
        this.height = ob.height;
        this.depth = ob.depth;
    }
}

public class ConstructorOverloading {
    public static void main(String[] args) {
        Box box1 = new Box(10, 20, 30);
        Box box2 = new Box(box1);
        System.out.println("Height:"+box2.height);
        System.out.println("Width:"+box2.width);
        System.out.println("Depth:"+box2.depth);
    }
}
