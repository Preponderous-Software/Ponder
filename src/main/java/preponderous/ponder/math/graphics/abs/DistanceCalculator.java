/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.math.graphics.abs;

import preponderous.ponder.math.graphics.Point2D;
import preponderous.ponder.math.graphics.Point3D;

/**
 * @author Daniel McCoy Stephenson
 */
public abstract class DistanceCalculator {

    /**
     * @param firstPoint The first two-dimensional point.
     * @param secondPoint The second two-dimensional point.
     * @return The distance between the two points as a double.
     */
    public abstract double getDistanceBetweenPoints(Point2D firstPoint, Point2D secondPoint);

    /**
     * @param firstPoint The first three-dimensional point.
     * @param secondPoint The second three-dimensional point.
     * @return The distance between the two points as a double.
     */
    public abstract double getDistanceBetweenPoints(Point3D firstPoint, Point3D secondPoint);
}