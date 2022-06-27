package preponderous.ponder.command

import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import preponderous.ponder.command.result.CommandSuccess

class DelegatingCommandTests {

    @Test
    fun `delegating command delegates to subcommand`() = runBlocking {
        val subcommand = mockk<Command> {
            coEvery { execute(any(), any()) } returns CommandSuccess
        }
        val sender = mockk<CommandSender> {
            every { sendMessage(any()) } just runs
        }
        val underTest = DelegatingCommand(
            mapOf(
                "test" to subcommand
            ),
            "Example usage message"
        )
        underTest.execute(sender, "test", "test2")
        coVerify { subcommand.execute(sender, "test2") }
    }

}