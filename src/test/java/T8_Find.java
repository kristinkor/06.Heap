import com.jbbwebsolutions.datastructure.EnumComparison;
import edu.citytech.cst3650.ss23953296.heap.MaxHeap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T8_Find {


    @Test
    @DisplayName("Equal to 30")
    void equalTo() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;

        //biConsumer
        var list = maxHeap.find( predicate,75, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 1;

        assertEquals(expected, actual);


    }
    @Test
    @DisplayName("Less than to 30")
    void lessThan() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.LESS_THAN == e;

        //biConsumer
        var list = maxHeap.find( predicate,30, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 3;

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Equal to 30")
    void greaterThan() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;

        //biConsumer
        var list = maxHeap.find( predicate,30, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 3;

        assertEquals(expected, actual);


    }
}

