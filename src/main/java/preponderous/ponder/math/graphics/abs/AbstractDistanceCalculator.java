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
public abstract class AbstractDistanceCalculator {
    public abstract double getDistanceBetweenPoints(Point2D firstPoint, Point2D secondPoint);
    public abstract double getDistanceBetweenPoints(Point3D firstPoint, Point3D secondPoint);
}