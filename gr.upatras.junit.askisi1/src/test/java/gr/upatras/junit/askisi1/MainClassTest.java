package gr.upatras.junit.askisi1;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.InputStream;

class MainClassTest {
    private InputStream sysInBackup;
    private ByteArrayInputStream inContent;

    @BeforeEach
    public void setUp() {
        sysInBackup = System.in; // Backup System.in to restore it later
    }

    @AfterEach
    public void tearDown() {
        System.setIn(sysInBackup); // Restore original System.in
    }

    @Test
    public void testSubtractWithPositiveNumbers() {
        String input = "10\n5\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        String result = MainClass.subtract();

        assertEquals("POSITIVE", result);
    }

    @Test
    public void testSubtractWithNegativeNumbers() {
        String input = "-10\n-5\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        String result = MainClass.subtract();

        assertEquals("NEGATIVE", result);
    }

    @Test
    public void testSubtractWithZero() {
        String input = "0\n0\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        String result = MainClass.subtract();

        assertEquals("POSITIVE", result);
    } 

    @Test
    public void testSubtractWithInvalidInput() {
        String input = "notint\ndnotint\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        assertThrows(NoSuchElementException.class, () -> {
            MainClass.subtract();
        });
    } 
}
