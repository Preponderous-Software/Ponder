/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.math.graphics;

/**
 * @author Daniel McCoy Stephenson
 */
public class Point3D extends Point2D {
    private double z;

    /**
     * This constructor can be utilized to initialize the point.
     *
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     * @param z The z coordinate of the point.
     */
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    /**
     * This can be utilized to get the z coordinate of the point.
     * @return The z coordinate of the point.
     */
    public double getZ() {
        return z;
    }

    /**
     * Sets the z coordinate of the point.
     * @param z The new z coordinate of the point.
     */
    public void setZ(double z) {
        this.z = z;
    }
}