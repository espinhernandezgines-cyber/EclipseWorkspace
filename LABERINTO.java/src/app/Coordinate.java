package app;

public class Coordinate {
	
    private int i;
    private int j;
    
    private String direction;

    public Coordinate(int i, int j, String direction) {
        this.i = i;
        this.j = j;
        this.direction = direction;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public String getDirection() {
        return direction;
    }
    
    public String toString() {
        return "(" + i + ", " + j + ") - " + direction;
    }
}
