import com.jbbwebsolutions.datastructure.EnumComparison;
import edu.citytech.cst3650.ss23953296.heap.MaxHeap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Find Max Heap")
public class T8_FindMaxHeap {
    @Test
    @DisplayName("Equal to 30")
    void equalTo() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;

        //biConsumer
        var list = maxHeap.find(predicate, 75, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 1;

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Equal to 100")
    void equalTo1() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;

        //biConsumer
        var list = maxHeap.find(predicate, 100, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 1;

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Equal to 50")
    void equalTo2() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;

        //biConsumer
        var list = maxHeap.find(predicate, 50, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 1;

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Equal to 10")
    void equalTo3() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;

        //biConsumer
        var list = maxHeap.find(predicate, 10, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 1;

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Equal to 20")
    void equalTo4() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;

        //biConsumer
        var list = maxHeap.find(predicate, 20, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 1;

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Equal to 15")
    void equalTo5() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;

        //biConsumer
        var list = maxHeap.find(predicate, 15, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 1;

        assertEquals(expected, actual);
    }

//    @Test
//    @DisplayName("Equal to 0")
//    void equalTo6() {
//        MaxHeap maxHeap = new MaxHeap();
//        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
//        Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;
//
//        //biConsumer
//        var list = maxHeap.find( predicate,0, (e1, e2) -> {
//            System.out.println(e1 + " | " + e2);
//        });
//
//        System.out.println("List: " + list + " size: " + list.size());
//
//        var actual = list.size();
//        var expected = 1;
//
//        assertEquals(expected, actual);
//    }

    @Test
    @DisplayName("Less than to 30")
    void lessThan() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.LESS_THAN == e;

        //biConsumer
        var list = maxHeap.find(predicate, 30, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 3;

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Less than to 15")
    void lessThan1() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.LESS_THAN == e;

        //biConsumer
        var list = maxHeap.find(predicate, 15, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Less than to 100")
    void lessThan2() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.LESS_THAN == e;

        //biConsumer
        var list = maxHeap.find(predicate, 100, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 6;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Greater than 30")
    void greaterThan() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;

        //biConsumer
        var list = maxHeap.find(predicate, 30, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Greater than 30")
    void greaterThan1() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;

        //biConsumer
        var list = maxHeap.find(predicate, 0, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 7;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find Max 100")
    void max() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(100, 50, 75, 30, 20, 10, 15);
        Predicate<EnumComparison> predicate = e -> EnumComparison.MAX == e;

        //biConsumer
        var list = maxHeap.find(predicate, 0, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.get(0);
        var expected = 100;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find Max 200")
    void max1() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(5, 50, 75, 34, 20, 10, 200);
        Predicate<EnumComparison> predicate = e -> EnumComparison.MAX == e;

        //biConsumer
        var list = maxHeap.find(predicate, 0, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.get(0);
        var expected = 200;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find Min Value")
    void min() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(5, 50, 75, 34, 20, 10, 200);
        Predicate<EnumComparison> predicate = e -> EnumComparison.MIN == e;

        //biConsumer
        var list = maxHeap.find(predicate, 0, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.get(0);
        var expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find Min Value")
    void min1() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.inserts(250, 50, 75, 34, 20, 10, 200);
        Predicate<EnumComparison> predicate = e -> EnumComparison.MIN == e;

        //biConsumer
        var list = maxHeap.find(predicate, 0, (e1, e2) -> {
            System.out.println(e1 + " | " + e2);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.get(0);
        var expected = 10;

        assertEquals(expected, actual);
    }
}

