/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.system.abs;

/**
 * @author Daniel McCoy Stephenson
 * @since January 5th, 2022
 */
public abstract class CommandSender {

    /**
     * Sends a message to the command sender.
     * @param message The message to send.
     */
    public abstract void sendMessage(String message);
}