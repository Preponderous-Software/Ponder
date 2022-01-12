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
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     * @param z The z coordinate of the point.
     */
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    /**
     * @return The z coordinate of the point.
     */
    public double getZ() {
        return z;
    }

    /**
     * @param z The new z coordinate of the point.
     */
    public void setZ(double z) {
        this.z = z;
    }
}