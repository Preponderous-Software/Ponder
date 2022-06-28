package preponderous.ponder.minecraft.bukkit.plugin

import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin

fun Plugin.registerListeners(vararg listeners: Listener) =
    listeners.forEach { server.pluginManager.registerEvents(it, this) }