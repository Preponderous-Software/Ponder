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
     * This constructor can be utilized to initialize the point.
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This can be utilized to get the x coordinate of the point.
     * @return The x coordinate of the point.
     */
    public double getX() {
        return x;
    }

    /**
     * Sets the x coordinate of the point.
     * @param x The new x coordinate of the point.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * This can be utilized to get the y coordinate of the point.
     * @return The y coordinate of the point.
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the y coordinate of the point.
     * @param y The new y coordinate of the point.
     */
    public void setY(double y) {
        this.y = y;
    }
}