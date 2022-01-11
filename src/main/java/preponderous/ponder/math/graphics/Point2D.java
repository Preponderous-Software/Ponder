/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.math.graphics;

/**
 * @author Daniel McCoy Stephenson
 */
public class Point2D {
    private double x;
    private double y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}