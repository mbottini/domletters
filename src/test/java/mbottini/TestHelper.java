package mbottini;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class TestHelper {
    public static InputStream streamFromString(String s) {
        return new ByteArrayInputStream(s.getBytes());
    }
}


