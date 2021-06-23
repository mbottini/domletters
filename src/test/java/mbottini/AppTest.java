package mbottini;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.After;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static final InputStream STDIN = System.in;
    private static final PrintStream STDOUT = System.out;

    // Stdout can be mocked the same way for all tests.
    // Stdin cannot, as its contents must be initialized.

    @After
    public void reformConsole() {
        System.setOut(STDOUT);
        System.setIn(STDIN);
    }

    void mockStdin(String s) {
        System.setIn(TestHelper.streamFromString(s));
    }

    @Test
    public void testAppTestSentence()
    {
        mockStdin("The bookkeeper and the beekeeper Giggled greatly. They were\nin unacrimonious union.");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        App.main(new String[]{"prog"});
        assertEquals("20\n", baos.toString());
    }

    @Test
    public void testAppTestSwift()
    {
        mockStdin("\"Did I fall?\" he asked. \"Bless my very existence, but did I tumble off\n" +
                  "the airship?\n\n" +
                  "\"No indeed,\" replied Tom, \"though you came pretty near it. How do you\n" +
                  "feel? Were you hurt?\"\n\n" +
                  "\"Oh, I'm all right now--just a trifle dizzy. But I thought sure I was a\n" +
                  "goner when I fell over the platform railing,\" and Mr. Damon could not\n" +
                  "repress a shudder. Mr. Sharp administered some more medicine and his\n" +
                  "patient was soon able to stand, and move about.\n");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        App.main(new String[]{"prog"});
        assertEquals("71\n", baos.toString());
    }
}
