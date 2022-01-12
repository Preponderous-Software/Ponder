/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.misc.abs;

import java.util.ArrayList;

/**
 * @author Daniel McCoy Stephenson
 */
public interface Lockable<T> {
    void setOwner(T toSet);
    T getOwner();
    void addToAccessList(T toAdd);
    void removeFromAccessList(T toRemove);
    boolean hasAccess(T toCheck);
    ArrayList<T> getAccessList();
}