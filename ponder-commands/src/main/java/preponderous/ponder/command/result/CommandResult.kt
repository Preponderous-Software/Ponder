package preponderous.ponder.command.result

sealed interface CommandResult
object CommandSuccess : CommandResult
open class CommandFailure : CommandResult