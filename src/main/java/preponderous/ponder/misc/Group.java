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
    protected String name = "defaultName";
    protected String description = "defaultDescription";
    protected T owner;
    protected ArrayList<T> members = new ArrayList<>();
    protected ArrayList<T> officers = new ArrayList<>();

    public Group(String name, String description, T owner) {
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    private ArrayList<T> invited = new ArrayList<>();

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
     * Sets the owner of the group.
     * @param T The new owner's T.
     */
    public void setOwner(T T) {
        owner = T;
    }

    /**
     * Checks if the passed T matches that of the owner.
     * @param T The T to check.
     * @return Whether the T matches.
     */
    public boolean isOwner(T T) {
        return owner.equals(T);
    }

    /**
     * This can be utilized to access the owner of the group.
     * @return The owner of the group.
     */
    public T getOwner() {
        return owner;
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
     * Adds an member to the list of officers.
     * @param newOfficer The T of the new officer.
     * @return Whether the member was added to the list.
     */
    public boolean addOfficer(T newOfficer) {
        if (!officers.contains(newOfficer)) {
            officers.add(newOfficer);
            return true;
        }
        return false;
    }

    /**
     * Removes a member from the list of officers.
     * @param officerToRemove The T of the officer to remove.
     * @return Whether the officer was removed.
     */
    public boolean removeOfficer(T officerToRemove) {
        return officers.remove(officerToRemove);
    }

    /**
     * Checks whether a member is an officer.
     * @param T The T of the member to check.
     * @return Whether the member is an officer of the group.
     */
    public boolean isOfficer(T T) {
        return officers.contains(T);
    }

    /**
     * This can be used to get the number of officers in the group.
     * @return The number of officers in the group.
     */
    public int getNumOfficers() {
        return officers.size();
    }

    /**
     * This can be utilized to access the list of officers.
     * @return The list of officers.
     */
    public ArrayList<T> getOfficerList() {
        return officers;
    }

    /**
     * This can be used to get the number of members in the group.
     * @return The number of members in the group.
     */
    public int getPopulation() {
        return members.size();
    }

    /**
     * Adds a member to the list of invited members.
     * @param newMember The T of the member to invite.
     */
    public void invite(T newMember) {
        invited.add(newMember);
    }

    /**
     * Removes a member from the list of invited members.
     * @param member The member to uninvite.
     */
    public void uninvite(T member) {
        invited.remove(member);
    }

    /**
     * This can be utilized to check whether an entity is invited to the group.
     * @param uuid The member to check.
     * @return Whether the member is currently invited to the group.
     */
    public boolean isInvited(T uuid) {
        return invited.contains(uuid);
    }
}