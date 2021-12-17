import com.jbbwebsolutions.datastructure.IGenericHeap;
import edu.citytech.cst3650.ss23953296.heap.MaxGenericHeap;
import edu.citytech.cst3650.ss23953296.heap.MinGenericHeap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Generic swap")
public class T6_GenericSwap {
    @Test
    @DisplayName("T01 swap 44 and 100")
    public void swap01() {
        IGenericHeap<Integer> maxHeap = new MaxGenericHeap<>();
        maxHeap.insertBiConsumer((e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });
        maxHeap.inserts(44, 100, 35, 200, 150);
        var m = maxHeap;
        System.out.println(maxHeap.getParent(0));
        System.out.println(maxHeap.getLeftChild(0));
        System.out.println(maxHeap.getRightChild(0));
    }

    @Test
    @DisplayName("T01 swap 44 and 100")
    public void swap02() {
        IGenericHeap<Integer> minHeap = new MinGenericHeap<>();
        minHeap.insertBiConsumer((e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });
        minHeap.inserts(44, 100, 200, 150, 35);
        System.out.println(minHeap.getParent(0));
        System.out.println(minHeap.getLeftChild(0));
        System.out.println(minHeap.getRightChild(0));
    }

}
