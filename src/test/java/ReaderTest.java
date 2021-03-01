import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public final class ReaderTest {
    Reader reader = new Reader();
    PrintStream standardOut = System.out;
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testReadNoFile() {
        reader.read("");
        assertEquals("No prospects file found named:", outputStreamCaptor.toString().trim());
    }

    @After
    public void reset() {
        System.setOut(standardOut);
    }
}