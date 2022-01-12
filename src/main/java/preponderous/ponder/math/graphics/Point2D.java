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

    /**
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return The x coordinate of the point.
     */
    public double getX() {
        return x;
    }

    /**
     * @param x The new x coordinate of the point.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return The y coordinate of the point.
     */
    public double getY() {
        return y;
    }

    /**
     * @param y The new y coordinate of the point.
     */
    public void setY(double y) {
        this.y = y;
    }
}