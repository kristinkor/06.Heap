import com.jbbwebsolutions.datastructure.EnumComparison;
import com.jbbwebsolutions.datastructure.IGenericHeap;
import com.jbbwebsolutions.datastructure.IGenericHeapQuery;
import edu.citytech.cst3650.ss23953296.heap.MaxGenericHeap;
import edu.citytech.cst3650.ss23953296.heap.MaxHeap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T8_FindMaxGenericHeap {

    static MaxGenericHeap<Integer> m = new MaxGenericHeap<>();
    static Integer[] nums ={100, 50, 75, 30, 20, 10, 15};
    @BeforeAll
    static void loadData() {
        m.inserts(nums);
    }

    @Test
    @DisplayName("Equal to 30")
    void equalTo() {
        m.insertBiConsumer((e1,e2)->{
            System.out.println(e1 + " | " +e2);
        });

        Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;

        //biConsumer
        var list = m.find( predicate,75, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 1;

        assertEquals(expected, actual);


    }
}

