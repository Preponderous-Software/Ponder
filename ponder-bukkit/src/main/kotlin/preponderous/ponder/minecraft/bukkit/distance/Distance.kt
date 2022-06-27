package preponderous.ponder.minecraft.bukkit.distance

import org.bukkit.Location
import org.bukkit.entity.Player
import java.util.function.Predicate

@JvmInline
value class Distance(val value: Double) {
    val valueSquared
        get() = value * value
}

val Int.blocks
    get() = Distance(toDouble())

val Double.blocks
    get() = Distance(this)

infix fun Location.within(distance: Distance): Predicate<Location> =
    Predicate { other -> other.distanceSquared(this) <= distance.valueSquared }

infix fun Player.within(distance: Distance): Predicate<Player> =
    Predicate { other -> other.location within distance of location }

fun Player.findPlayersWithin(distance: Distance): List<Player> =
    world.players.filter { it within distance of this && it != this }

infix fun <T: Any> Predicate<T>.of(value: T) = test(value)