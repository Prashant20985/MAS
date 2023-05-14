package Attribute;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerTest {

    private Computer computer;

    @Before
    public void setUp() throws Exception {
        computer = new Computer("Inspiron", 500, 16, 32);
    }

    @Test
    public void setRam() {
        computer.setRam(32);
        assertEquals(32, computer.getRam());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setInvalidRam() {
        computer.setRam(64);
    }
}