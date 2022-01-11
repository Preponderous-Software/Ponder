/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.minecraft.spigot.misc;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

/**
 * @author Daniel McCoy Stephenson
 */
public class Group {
    protected String name = "defaultName";
    protected String description = "defaultDescription";
    protected UUID owner = UUID.randomUUID();

    protected ArrayList<UUID> members = new ArrayList<>();
    protected ArrayList<UUID> officers = new ArrayList<>();

    private ArrayList<UUID> invited = new ArrayList<>();

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
     * @param UUID The new owner's UUID.
     */
    public void setOwner(UUID UUID) {
        owner = UUID;
    }

    /**
     * Checks if the passed UUID matches that of the owner.
     * @param UUID The UUID to check.
     * @return Whether the UUID matches.
     */
    public boolean isOwner(UUID UUID) {
        return owner.equals(UUID);
    }

    /**
     * This can be utilized to access the owner of the group.
     * @return The owner of the group.
     */
    public UUID getOwner() {
        return owner;
    }

    /**
     * Adds a member to the group.
     * @param UUID The UUID of the player to add.
     */
    public void addMember(UUID UUID) {
        members.add(UUID);
    }

    /**
     * Removes a player from the group.
     * @param UUID The UUID of the player to remove.
     */
    public void removeMember(UUID UUID) {
        members.remove(UUID);
    }

    /**
     * Checks if a player is a member of the group.
     * @param UUID The UUID of the player to check.
     * @return Whether the player is a member of the group.
     */
    public boolean isMember(UUID UUID) {
        return members.contains(UUID);
    }

    /**
     * This can be utilized to access the list of members.
     * @return The list of members.
     */
    public ArrayList<UUID> getMemberList() {
        return members;
    }

    /**
     * Adds an player to the list of officers.
     * @param newOfficer The UUID of the new officer.
     * @return Whether the player was added to the list.
     */
    public boolean addOfficer(UUID newOfficer) {
        if (!officers.contains(newOfficer)) {
            officers.add(newOfficer);
            return true;
        }
        return false;
    }

    /**
     * Removes a player from the list of officers.
     * @param officerToRemove The UUID of the officer to remove.
     * @return Whether the officer was removed.
     */
    public boolean removeOfficer(UUID officerToRemove) {
        return officers.remove(officerToRemove);
    }

    /**
     * Checks whether a player is an officer.
     * @param UUID The UUID of the player to check.
     * @return Whether the player is an officer of the group.
     */
    public boolean isOfficer(UUID UUID) {
        return officers.contains(UUID);
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
    public ArrayList<UUID> getOfficerList() {
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
     * Adds a player to the list of invited players.
     * @param UUID The UUID of the player to invite.
     */
    public void invite(UUID UUID) {
        Player player = getServer().getPlayer(UUID);
        if (player != null) {
            UUID playerUUID = player.getUniqueId();
            invited.add(playerUUID);
        }
    }

    /**
     * Removes a player from the list of invited players.
     * @param UUID The UUID of the player to uninvite.
     */
    public void uninvite(UUID UUID) {
        invited.remove(UUID);
    }

    /**
     * This can be utilized to check whether a player is invited to the group.
     * @param uuid The UUID of the player to check.
     * @return Whether the player is currently invited to the group.
     */
    public boolean isInvited(UUID uuid) {
        return invited.contains(uuid);
    }
}