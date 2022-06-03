package nizovi;

public class Kompleks {
    int x;
    int y;
    public Kompleks(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return (x + "+" + y + "j");
    }
    
}
