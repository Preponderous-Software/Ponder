package preponderous.ponder.command

import preponderous.ponder.command.result.CommandResult
import preponderous.ponder.command.result.IncorrectUsageFailure

class DelegatingCommand(subcommands: Map<String, Command>, private val usageMessage: String) : Command, CommandService {

    private val subcommands = mutableMapOf<String, Command>().apply { putAll(subcommands) }

    override suspend fun execute(sender: CommandSender, vararg args: String): CommandResult {
        if (args.isEmpty()) {
            sender.sendMessage(usageMessage)
            return IncorrectUsageFailure()
        }
        val subcommand = subcommands[args.first()]
        return if (subcommand != null) {
            subcommand.execute(sender, *args.dropFirst())
        } else {
            sender.sendMessage(usageMessage)
            IncorrectUsageFailure()
        }
    }

    override fun addCommand(name: String, command: Command) {
        subcommands[name] = command
    }

    override fun getCommand(name: String): Command? {
        return subcommands[name]
    }
}