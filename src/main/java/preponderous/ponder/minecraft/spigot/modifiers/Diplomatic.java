/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.minecraft.spigot.modifiers;

import java.util.ArrayList;

/**
 * @author Daniel McCoy Stephenson
 */
public interface Diplomatic {

    /**
     * Adds an new ally to the list of allies.
     * @param name The name of the new ally.
     */
    void addAlly(String name);

    /**
     * Removes an ally from the list of allies.
     * @param name The name of the ally to remove.
     */
    void removeAlly(String name);

    /**
     * Checks whether an ally exists.
     * @param name The name of the potential ally.
     * @return Whether the ally exists.
     */
    boolean isAlly(String name);

    /**
     * This can be utilized to access the list of allies.
     * @return The list of allies.
     */
    ArrayList<String> getAllies();

    /**
     * This can be used to get all of the allies separated by comments in a string.
     * @return Allies separated by comments.
     */
    String getAlliesSeparatedByCommas();

    /**
     *  This can be used to add a name to the list of requested allies.
     * @param name The name of the future ally.
     */
    void requestAlly(String name);

    /**
     * Checks whether a name is in the list of requested allies.
     * @param name The potential requested ally.
     * @return Whether the name is in the list of requested allies.
     */
    boolean isRequestedAlly(String name);

    /**
     * Removes a name from the list of requested allies.
     * @param name The name to remove from the list of requested allies.
     */
    void removeAllianceRequest(String name);

    /**
     * Adds a name to the list of enemies.
     * @param name The name to add to the list of enemies.
     */
    void addEnemy(String name);

    /**
     * Removes a name from the list of enemies.
     * @param name The name to remove from the list of enemies.
     */
    void removeEnemy(String name);

    /**
     * Checks whether a name is in the list of enemies.
     * @param name The name to check.
     * @return Whether the name is in the list of enemies.
     */
    boolean isEnemy(String name);

    /**
     * This can be used to access the list of enemies.
     * @return The list of enemies.
     */
    ArrayList<String> getEnemies();

    /**
     * This can be used to get all of the enemies separated by comments in a string.
     * @return Enemies separated by comments.
     */
    String getEnemiesSeparatedByCommas();

    /**
     * Adds a name to the list of requested truces.
     * @param name The name to add to the list of requested truces.
     */
    void requestTruce(String name);

    /**
     * Checks whether a truce is requested.
     * @param name The name to check.
     * @return Whether a truce is requested with the entity associated with the passed name.
     */
    boolean isTruceRequested(String name);

    /**
     * Removes a name from the list of requested truces.
     * @param name The name to remove from the list of requested truces
     */
    void removeRequestedTruce(String name);
}