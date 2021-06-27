package mbottini;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

public class DomLetters {
    /// Returns true if every character in the string is ASCII alphabetical.
    public static boolean isAlphabetical(String s) {
        return !s.isEmpty() && s.chars().allMatch(c -> c < 128 && Character.isLetter(c));
    }

    /// Returns a String containing the words in a line.
    public static Stream<String> getWordsFromLine(String s) {
        return Arrays.stream(s.split("\\s+"))
            .filter(DomLetters::isAlphabetical);
    }

    /// Gets every line from an InputStream and applies GetWordsFromLine to them,
    /// concatenating the result into a single Stream.
    public static Stream<String> getWordsFromInputStream(InputStream in) {
        return new BufferedReader(new InputStreamReader(in)).lines()
            .flatMap(DomLetters::getWordsFromLine);
    }

    /// Obtains a frequency dictionary of the characters in a string.
    public static HashMap<Character, Integer> frequencyDict(String s) {
        HashMap<Character, Integer> result = new HashMap<>();
        s.chars().forEach(c -> {
            Character lc = Character.toLowerCase((char)c);
            result.put(lc, result.getOrDefault(lc, 0) + 1);
        });
        return result;
    }

    /// Returns the dominant character count of a string. Note that it's
    /// an Optional, in the strange case that we've found an empty string.
    public static Optional<Integer> getDominantCharacterCount(String s) {
        return frequencyDict(s).values().stream().max(Integer::compareTo);
    }

    public static Integer sumCounts(InputStream in) {
        return getWordsFromInputStream(in)
           .map(DomLetters::getDominantCharacterCount)
           .mapToInt(opt -> opt.orElse(0))
           .sum();
    }
}

