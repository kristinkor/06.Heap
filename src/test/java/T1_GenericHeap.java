import com.jbbwebsolutions.datastructure.IGenericHeap;
import edu.citytech.cst3650.ss23953296.heap.MaxGenericHeap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T1_GenericHeap {
    @Test
    @DisplayName("T01 Insert 3 numbers")
    public void testConcatenate() {
        IGenericHeap<Integer> m = new MaxGenericHeap<>();

        m.insert(10);
        m.insert(20);
        m.insert(30);
        var actual = m.getSize();
        var expected = 3;
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("T02 Insert 3 numbers")
    public void inserTest() {
        IGenericHeap<Integer> m = new MaxGenericHeap<>();

        m.inserts(10, 20, 30);
        var actual = m.getSize();
        var expected = 3;
        assertEquals(expected, actual);
    }

}
