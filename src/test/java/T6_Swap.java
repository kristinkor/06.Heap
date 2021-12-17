import com.jbbwebsolutions.datastructure.IHeap;
import edu.citytech.cst3650.ss23953296.heap.MaxHeap;
import edu.citytech.cst3650.ss23953296.heap.MinHeap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Get Parent Value")
public class T6_Swap {
    @Test
    @DisplayName("T01 swap 44 and 100")
    public void swap01() {
        IHeap maxHeap = new MaxHeap();
        maxHeap.insertBiConsumer((e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });
        maxHeap.inserts(44,100,35,200,150);
        System.out.println("test");
    }

    @Test
    @DisplayName("T01 swap 44 and 100")
    public void swap02() {
        IHeap minHeap = new MinHeap();
        minHeap.insertBiConsumer((e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });
        minHeap.inserts(44,100,200,150,35,17,222);
        System.out.println("test");
    }
    @Test
    @DisplayName("T01 swap 44 and 100")
    public void swap03() {
        IHeap maxHeap = new MaxHeap();
        maxHeap.insertBiConsumer((e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });
        maxHeap.inserts(5,12,64,1,37,90,91,97);
        System.out.println("test");
    }

    @Test
    @DisplayName("T01 swap 44 and 100")
    public void swap04() {
        IHeap minHeap = new MinHeap();
        minHeap.insertBiConsumer((e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });
        minHeap.inserts(5,12,64,1,37,90,91,97);
        System.out.println("test");
    }
}
