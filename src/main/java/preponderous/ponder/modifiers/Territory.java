package preponderous.ponder.modifiers;

public interface Territory {
    void setHolder(String newHolder);
    String getHolder();
    double[] getCoordinates();
}