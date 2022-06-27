package preponderous.ponder.command

class DefaultCommandService : CommandService {

    private val commands = mutableMapOf<String, Command>()

    override fun addCommand(name: String, command: Command) {
        commands[name] = command
    }

    override fun getCommand(name: String): Command? = commands[name]
    
}