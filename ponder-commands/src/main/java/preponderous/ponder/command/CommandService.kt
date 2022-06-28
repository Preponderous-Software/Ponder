package preponderous.ponder.command

interface CommandService {

    fun addCommand(name: String, command: Command)
    fun getCommand(name: String): Command?

}