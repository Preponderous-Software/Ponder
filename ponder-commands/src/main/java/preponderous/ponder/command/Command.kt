package preponderous.ponder.command

import preponderous.ponder.command.result.CommandResult

fun interface Command {
    
    suspend fun execute(sender: CommandSender, vararg args: String): CommandResult

}