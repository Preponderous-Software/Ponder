package preponderous.ponder.command

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ArgsTests {

    @Test
    fun `dropFirst drops first argument`() {
        assertArrayEquals(arrayOf("def", "ghi", "jkl"), arrayOf("abc", "def", "ghi", "jkl").dropFirst())
    }

    @Test
    fun `unquote parses quoted args`() {
        assertArrayEquals(
            arrayOf("abc", "def ghi", "jkl", "mno pqr stu"),
            arrayOf("abc", "\"def", "ghi\"", "\"jkl\"", "\"mno", "pqr", "stu\"").unquote()
        )
    }

    @Test
    fun `nested quotes are left`() {
        assertArrayEquals(
            arrayOf("abc", "def \"ghi\"", "jkl", "\"mno pqr\" stu"),
            arrayOf("abc", "\"def", "\"ghi\"\"", "\"jkl\"", "\"\"mno", "pqr\"", "stu\"").unquote()
        )
    }
}