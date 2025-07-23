package tasks.task12;

class Point {
  private double x;
  private double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void print() {
    System.out.println("(" + x + ", " + y + ")");
  }

  // Your code goes here
  public void scale() {
      this.x = x / 2;
      this.y = y / 2;
  }
}

public class task12 {
  public static void main(String[] args) {
    Point p = new Point(8, 4);
    for (int i = 0; i < 5; i++) {
      p.scale();
      p.print();
    }
  }
}