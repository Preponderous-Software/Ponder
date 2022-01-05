package preponderous.ponder.math.graphics.abs;

import preponderous.ponder.math.graphics.Point2D;

/**
 * @author Daniel Stephenson
 */
public abstract class DistanceCalculator {
    public abstract double getDistanceBetweenPoints(Point2D firstPoint, Point2D secondPoint);
}