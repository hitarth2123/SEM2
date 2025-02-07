public class Time {
    private int hr;
    private int min;
    private int sec;

    public Time() {
        this.hr = 12;
        this.min = 0;
        this.sec = 0;
    }

    public Time(int hr, int min, int sec) {
        this.hr = hr;
        this.min = min;
        this.sec = sec;
    }

    public Time(int seconds) {
        this.hr = seconds / 3600;
        this.min = (seconds % 3600) / 60;
        this.sec = seconds % 60;
    }

    public void setClock(int seconds) {
        this.hr = seconds / 3600;
        this.min = (seconds % 3600) / 60;
        this.sec = seconds % 60;
    }

    public void tick() {
        this.sec++;
        if (this.sec == 60) {
            this.sec = 0;
            this.min++;
            if (this.min == 60) {
                this.min = 0;
                this.hr = (this.hr + 1) % 24;
            }
        }
    }

    public void tickDown() {
        this.sec--;
        if (this.sec == -1) {
            this.sec = 59;
            this.min--;
            if (this.min == -1) {
                this.min = 59;
                this.hr = (this.hr - 1 + 24) % 24;
            }
        }
    }

    public void displayTime() {
        System.out.printf("%02d:%02d:%02d\n", hr, min, sec);
    }

    public static void main(String[] args) {
        Time time = new Time();
        time.displayTime();
        time.tick();
        time.displayTime();
        time.tickDown();
        time.displayTime();
    }
}
