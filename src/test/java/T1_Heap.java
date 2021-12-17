import com.jbbwebsolutions.datastructure.IHeap;
import edu.citytech.cst3650.ss23953296.heap.MaxHeap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T1_Heap {
    @Test
    @DisplayName("T01 Insert 3 numbers")
    public void testConcatenate() {
        IHeap m = new MaxHeap();

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
        IHeap m = new MaxHeap();

        m.inserts(10, 20, 30);
        var actual = m.getSize();
        var expected = 3;
        assertEquals(expected, actual);
    }


}
