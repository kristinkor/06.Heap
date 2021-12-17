import com.jbbwebsolutions.datastructure.IGenericHeap;
import edu.citytech.cst3650.ss23953296.heap.MaxGenericHeap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T5_GenericHeapRightChild {

    static IGenericHeap<Integer> m = new MaxGenericHeap<>();

    @BeforeAll
    static void loadData() {
        m.inserts(100, 50, 75, 30, 20, 10, 15);
    }

    @Test
    @DisplayName("T01 get RightChild for index 0")
    public void getLeftChild1() {
        var expected = 75;
        var actual = m.getRightChild(0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T02 get RightChild for index 1")
    public void getLeftChild2() {
        var expected = 20;
        var actual = m.getRightChild(1);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T03 get RightChild for index 2")
    public void getLeftChild3() {
        var expected = 15;
        var actual = m.getRightChild(2);
        assertEquals(expected, actual);
    }
}
