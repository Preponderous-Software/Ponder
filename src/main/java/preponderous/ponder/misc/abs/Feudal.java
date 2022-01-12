/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.misc.abs;

import java.util.ArrayList;

/**
 * @author Daniel McCoy Stephenson
 */
public interface Feudal {
    boolean isVassal(String name);
    boolean isLiege();
    void setLiege(String newLiege);
    String getLiege();
    boolean hasLiege();
    boolean isLiege(String name);
    void addVassal(String name);
    void removeVassal(String name);
    void clearVassals();
    int getNumVassals();
    ArrayList<String> getVassals();
    String getVassalsSeparatedByCommas();
    void addAttemptedVassalization(String name);
    boolean hasBeenOfferedVassalization(String name);
    void removeAttemptedVassalization(String name);

}
