package mbottini;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Unit test for simple App.
 */
public class DomLettersTest 
{
    @Test
    public void testIsAlphabetical() {
        assertTrue(DomLetters.isAlphabetical("abc"));
        assertTrue(DomLetters.isAlphabetical("sPoNgEbOb"));
        assertTrue(DomLetters.isAlphabetical("def"));

        assertFalse(DomLetters.isAlphabetical(",abc"));
        assertFalse(DomLetters.isAlphabetical("hajs_jask"));
        assertFalse(DomLetters.isAlphabetical("{}"));

        assertFalse(DomLetters.isAlphabetical(""));
        assertFalse(DomLetters.isAlphabetical("Ћ"));
    }

    @Test
    public void testGetWordsFromLine() {
        assertEquals(Arrays.asList("This", "an", "Really"),
          DomLetters.getWordsFromLine("This isn't an \"incomplete sentence\". Really\n not.")
              .collect(Collectors.toList()));
    }

    @Test
    public void testGetWordsFromInputStream() {
        assertEquals(Arrays.asList("The", "quick", "brown", "fox"),
            DomLetters.getWordsFromInputStream(TestHelper.streamFromString("The ,quick\n\n quick br_wn\n brown fox. fox"))
               .collect(Collectors.toList()));
    }

    @Test
    public void testDominantCharacterCount() {
        assertEquals(Optional.of(1), DomLetters.getDominantCharacterCount("any"));
        assertEquals(Optional.of(2), DomLetters.getDominantCharacterCount("Arable"));
        assertEquals(Optional.of(3), DomLetters.getDominantCharacterCount("bookkeeper"));
    }
}
