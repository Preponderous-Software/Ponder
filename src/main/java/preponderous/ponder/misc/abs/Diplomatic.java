/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.misc.abs;

import java.util.ArrayList;

/**
 * @author Daniel McCoy Stephenson
 */
public interface Diplomatic {

    /**
     * @param name The name of the new ally.
     */
    void addAlly(String name);

    /**
     * @param name The name of the ally to remove.
     */
    void removeAlly(String name);

    /**
     * @param name The name of the potential ally.
     * @return Whether the ally exists.
     */
    boolean isAlly(String name);

    /**
     * @return The list of allies.
     */
    ArrayList<String> getAllies();

    /**
     * @return Allies separated by comments.
     */
    String getAlliesSeparatedByCommas();

    /**
     * @param name The name of the future ally.
     */
    void requestAlly(String name);

    /**
     * @param name The potential requested ally.
     * @return Whether the name is in the list of requested allies.
     */
    boolean isRequestedAlly(String name);

    /**
     * @param name The name to remove from the list of requested allies.
     */
    void removeAllianceRequest(String name);

    /**
     * @param name The name to add to the list of enemies.
     */
    void addEnemy(String name);

    /**
     * @param name The name to remove from the list of enemies.
     */
    void removeEnemy(String name);

    /**
     * @param name The name to check.
     * @return Whether the name is in the list of enemies.
     */
    boolean isEnemy(String name);

    /**
     * @return The list of enemies.
     */
    ArrayList<String> getEnemies();

    /**
     * @return Enemies separated by comments.
     */
    String getEnemiesSeparatedByCommas();

    /**
     * @param name The name to add to the list of requested truces.
     */
    void requestTruce(String name);

    /**
     * @param name The name to check.
     * @return Whether a truce is requested with the entity associated with the passed name.
     */
    boolean isTruceRequested(String name);

    /**
     * @param name The name to remove from the list of requested truces
     */
    void removeRequestedTruce(String name);
}