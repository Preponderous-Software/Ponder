/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.misc;

import java.util.ArrayList;

/**
 * @author Daniel McCoy Stephenson
 */
public class Group<T> {
    protected String name;
    protected String description;
    protected ArrayList<T> members = new ArrayList<>();

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Sets the name of the group.
     * @param newName The new name of the group.
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * This can utilized to access the name of the group.
     * @return The current name of the group.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the description of the group.
     * @param newDesc The new description of the group.
     */
    public void setDescription(String newDesc) {
        description = newDesc;
    }

    /**
     * This can be utilized to access the description of the group.
     * @return The description of the group.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Adds a member to the group.
     * @param T The T of the member to add.
     */
    public void addMember(T T) {
        members.add(T);
    }

    /**
     * Removes a member from the group.
     * @param T The T of the member to remove.
     */
    public void removeMember(T T) {
        members.remove(T);
    }

    /**
     * Checks if a member is a member of the group.
     * @param T The T of the member to check.
     * @return Whether the member is a member of the group.
     */
    public boolean isMember(T T) {
        return members.contains(T);
    }

    /**
     * This can be utilized to access the list of members.
     * @return The list of members.
     */
    public ArrayList<T> getMemberList() {
        return members;
    }

    /**
     * This can be used to get the number of members in the group.
     * @return The number of members in the group.
     */
    public int getPopulation() {
        return members.size();
    }
}