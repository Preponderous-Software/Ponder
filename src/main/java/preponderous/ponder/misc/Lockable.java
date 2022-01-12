/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.misc;

import java.util.ArrayList;

/**
 * @author Daniel McCoy Stephenson
 */
public interface Lockable<T> {
    void setOwner(T s);
    T getOwner();
    void addToAccessList(T playerName);
    void removeFromAccessList(T playerName);
    boolean hasAccess(T playerName);
    ArrayList<T> getAccessList();
}