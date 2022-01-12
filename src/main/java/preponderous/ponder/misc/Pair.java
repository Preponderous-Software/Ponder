/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.misc;

//

/**
 * @source https://stackoverflow.com/a/521235
 *
 * @author Pasarus
 * @author Daniel McCoy Stephenson
 *
 * @param <L> The type of the left object of the pair.
 * @param <R> The type of the right object of the pair.
 */
public class Pair<L,R> {
    private final L left;
    private final R right;

    public Pair(L left, R right) {
        assertLeftAndRightAreNotNull();
        this.left = left;
        this.right = right;
    }

    public L getLeft() { return left; }

    public R getRight() { return right; }

    public int hashCode() { return left.hashCode() ^ right.hashCode(); }

    public boolean equals(Object object) {
        if (objectIsNotAPair(object)) {
            return false;
        }
        Pair<L, R> pair = (Pair<L, R>) object;
        return contentsOfPairsAreEqual(pair);
    }

    private void assertLeftAndRightAreNotNull() {
        assert left != null;
        assert right != null;
    }

    private boolean contentsOfPairsAreEqual(Pair<L, R> pair) {
        return this.left.equals(pair.getLeft()) && this.right.equals(pair.getRight());
    }

    private boolean objectIsNotAPair(Object object) {
        return !(object instanceof Pair);
    }
}