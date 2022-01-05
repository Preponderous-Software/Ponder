package preponderous.ponder.math.abs;

import preponderous.ponder.math.Point2D;

/**
 * @author Daniel Stephenson
 */
public abstract class DistanceCalculator {
    public abstract double getDistanceBetweenPoints(Point2D firstPoint, Point2D secondPoint);
}