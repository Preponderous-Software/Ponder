package preponderous.ponder.command

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import preponderous.ponder.command.result.CommandSuccess

class CommandServiceTests {

    @Test
    fun `command can be added`() {
        val underTest: CommandService = DefaultCommandService()
        val command = Command { _, _ -> CommandSuccess }
        underTest.addCommand("test", command)
        assertEquals(command, underTest.getCommand("test"))
    }

}