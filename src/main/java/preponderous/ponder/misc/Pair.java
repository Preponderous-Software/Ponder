/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.misc;

// Source: https://stackoverflow.com/a/521235 from user Paul Brinkly and edited by Dave Jarvis
public class Pair<L,R> {

    private final L left;
    private final R right;

    public Pair(L left, R right) {
        assert left != null;
        assert right != null;

        this.left = left;
        this.right = right;
    }

    public L getLeft() { return left; }

    public R getRight() { return right; }

    public int hashCode() { return left.hashCode() ^ right.hashCode(); }

    public boolean equals(Object object) {
        if (!(object instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) object;
        return this.left.equals(pair.getLeft()) && this.right.equals(pair.getRight());
    }
}