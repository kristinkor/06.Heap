import com.jbbwebsolutions.datastructure.IGenericHeap;
import com.jbbwebsolutions.datastructure.IHeap;
import edu.citytech.cst3650.ss23953296.heap.MaxGenericHeap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T2_GenericHeapParentsAndChildren {

    static IGenericHeap<Integer> m = new MaxGenericHeap<>();

    @BeforeAll
    static void loadData() {
        m.inserts(100, 50, 75, 30, 20, 10, 15);
    }

    @Test
    @DisplayName("T01 getLeftChild of index 0")
    public void getLeftChild1() {
        var expected = 1;
        var actual = IHeap.getLeftChildIndex(0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T02 getLeftChild of index 1")
    public void getLeftChild2() {
        var expected = 3;
        var actual = IHeap.getLeftChildIndex(1);
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("T03 getLeftChild of index 2")
    public void getLeftChild3() {
        var expected = 5;
        var actual = IHeap.getLeftChildIndex(2);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T04 getRightChild of index 0")
    public void getRightChild1() {
        var expected = 2;
        var actual = IHeap.getRightChildIndex(0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T05 getRightChild of index 1")
    public void getRightChild2() {
        var expected = 4;
        var actual = IHeap.getRightChildIndex(1);
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("T06 getRightChild of index 2")
    public void getRightChild3() {
        var expected = 6;
        var actual = IHeap.getRightChildIndex(2);
        assertEquals(expected, actual);
    }
}
