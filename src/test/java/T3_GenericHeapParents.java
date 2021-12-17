import com.jbbwebsolutions.datastructure.IGenericHeap;
import edu.citytech.cst3650.ss23953296.heap.MaxGenericHeap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T3_GenericHeapParents {
    static IGenericHeap<Integer> m = new MaxGenericHeap<>();

    @BeforeAll
    static void loadData() {
        m.inserts(100, 50, 75, 30, 20, 10, 15);
    }

    @Test
    @DisplayName("T01 get Parent for index 3")
    public void getParent1() {
        var expected = 50;
        var actual = m.getParent(3);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T02 get Parent for index 6")
    public void getParent2() {
        var expected = 75;
        var actual = m.getParent(6);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T03 get Parent for index 2")
    public void getParent3() {
        var expected = 100;
        var actual = m.getParent(2);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T01 get Parent for index 5")
    public void getParent4() {
        var expected = 75;
        var actual = m.getParent(5);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T02 get Parent for index 4")
    public void getParent5() {
        var expected = 50;
        var actual = m.getParent(4);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T03 get Parent for index 1")
    public void getParent6() {
        var expected = 100;
        var actual = m.getParent(1);
        assertEquals(expected, actual);
    }
}
