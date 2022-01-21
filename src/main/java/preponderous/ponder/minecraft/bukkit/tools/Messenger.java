/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.minecraft.bukkit.tools;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

/**
 * @author Daniel McCoy Stephenson
 */
public class Messenger {

    /**
     * Method to message every online player.
     * @param message The message to send.
     */
    public void sendAllPlayersOnServerMessage(String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(message);
        }
    }

    /**
     * Method to send a message to players within a certain number of blocks from a player.
     * @param player The player that sent the message.
     * @param message The message to send.
     * @param distance The distance that any other players need to be within in order to receive the message.
     * @return The number of players who received the message.
     */
    public int sendMessageToPlayersWithinDistance(Player player, String message, int distance) {
        int numPlayersWhoHeard = 0;
        for (Player target : getServer().getOnlinePlayers()) {
            if (!playersAreInTheSameWorld(target, player) || !playersAreWithinDistance(target, player, distance)) {
                continue;
            }
            numPlayersWhoHeard++;
            target.sendMessage(message);
        }
        return numPlayersWhoHeard;
    }

    /**
     * @param target The target player whose location will be used as the origin.
     * @param player The player whose location will be used as the target.
     * @param distance The distance to check.
     * @return Whether the target player was within the specified distance.
     */
    private boolean playersAreWithinDistance(Player target, Player player, double distance) {
        Location targetLocation = target.getLocation();
        Location playerLocation = player.getLocation();
        return locationsAreWithinDistance(targetLocation, playerLocation, distance);
    }

    /**
     * @param targetLocation The location that will be used as the origin.
     * @param playerLocation The location that will be used as the target.
     * @param distance The distance to check.
     * @return Whether the two locations are within the specified distance of each other.
     */
    private boolean locationsAreWithinDistance(Location targetLocation, Location playerLocation, double distance) {
        return targetLocation.distance(playerLocation) < distance;
    }

    /**
     * @param firstPlayer The first player.
     * @param secondPlayer The second player.
     * @return Whether the two players are in the same world.
     */
    private boolean playersAreInTheSameWorld(Player firstPlayer, Player secondPlayer) {
        World firstWorld = firstPlayer.getWorld();
        World secondWorld = secondPlayer.getWorld();
        return areWorldsEqual(firstWorld, secondWorld);
    }

    /**
     * @param firstWorld The first world.
     * @param secondWorld The second world.
     * @return Whether the two world are equal.
     */
    private boolean areWorldsEqual(World firstWorld, World secondWorld) {
        String firstWorldName = firstWorld.getName();
        String secondWorldName = secondWorld.getName();
        return firstWorldName.equals(secondWorldName);
    }
}