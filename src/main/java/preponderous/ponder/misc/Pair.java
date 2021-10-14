package preponderous.ponder.misc;

import preponderous.ponder.misc.specification.IPair;

// Source: https://stackoverflow.com/a/521235 from user Paul Brinkly and edited by Dave Jarvis
public class Pair<L,R> implements IPair<L, R> {

    private final L left;
    private final R right;

    public Pair(L left, R right) {
        assert left != null;
        assert right != null;

        this.left = left;
        this.right = right;
    }

    @Override
    public L getLeft() { return left; }

    @Override
    public R getRight() { return right; }

    @Override
    public int hashCode() { return left.hashCode() ^ right.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pairo = (Pair) o;
        return this.left.equals(pairo.getLeft()) &&
                this.right.equals(pairo.getRight());
    }
}