import com.jbbwebsolutions.datastructure.IHeap;
import edu.citytech.cst3650.ss23953296.heap.MaxHeap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T4_HeapLeftChild {

    static IHeap m = new MaxHeap();

    @BeforeAll
    static void loadData() {
        m.inserts(100, 50, 75, 30, 20, 10, 15);
    }

    @Test
    @DisplayName("T01 get LeftChild for index 0")
    public void getLeftChild1() {
        var expected = 50;
        var actual = m.getLeftChild(0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T02 get LeftChild for index 1")
    public void getLeftChild2() {
        var expected = 30;
        var actual = m.getLeftChild(1);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T02 get LeftChild for index 2")
    public void getLeftChild3() {
        var expected = 10;
        var actual = m.getLeftChild(2);
        assertEquals(expected, actual);
    }
}
