class Car {
        
    private String color;
    private int speed;

    public Car(String color, int speed) {
        this.color = color;
        this.speed = speed;
    }

    public void accelerate() {
        speed++;
    }

    public String getColor() {
        return color;
    }

}

