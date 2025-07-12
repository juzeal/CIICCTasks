package twosum;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class Testers {
    @Test
    void testCheckSum() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,3));
        int target = 5;
        ArrayList<Integer> actual = twosum.checkSum(input, target);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,2,2,1));
        assertEquals(expected, actual);
    }
}
