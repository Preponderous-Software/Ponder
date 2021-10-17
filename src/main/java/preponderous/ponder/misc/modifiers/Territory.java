package preponderous.ponder.misc.modifiers;

public interface Territory {
    void setHolder(String newHolder);
    String getHolder();
    double[] getCoordinates();
}