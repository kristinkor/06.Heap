package edu.citytech.cst3650.ss23953296.heap;

import com.jbbwebsolutions.datastructure.EnumComparison;
import com.jbbwebsolutions.datastructure.IHeap;
import com.jbbwebsolutions.datastructure.IHeapQuery;
import com.jbbwebsolutions.datastructure.Twin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import static com.jbbwebsolutions.datastructure.ComparisonHelper.*;
import static com.jbbwebsolutions.datastructure.ComparisonHelper.isLessThan;

public class MinHeap  implements IHeap, IHeapQuery {
    private int[] items = new int[10];
    private int size = 0;
    private BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer = (e1, e2) -> {
    };

    @Override
    public int remove() {
        if (size == 0) {
            return 0;
        }

        items[0] = items[size - 1];
        items[size - 1] = -9999;
        size--;
        bubbleDown();
        return 1;
    }


    public void inserts(int... values) {
        for (var value :
                values
        ) {
            this.insert(value);
        }
    }

    public void insert(int value) {
        items[size] = value;
        ++size;
        bubbleUp();
    }

    private void bubbleDown() {
        int index = 0;
        while (isInvalidParent(index)) {
            int biggerIndex = this.getBiggerIndex(index);
            this.swap(index, biggerIndex);
            index = biggerIndex;
        }
    }

    private int getBiggerIndex(int index) {
        var biggerIndex = getLeftChild(index) > getRightChild(index) ?
                IHeap.getLeftChildIndex(index) : IHeap.getRightChildIndex(index);
        return biggerIndex;
    }

    private boolean isInvalidParent(int index) {
        var status = this.items[index] < this.getLeftChild(index)
                && this.items[index] < this.getRightChild(index);
        return status;
    }

    private void bubbleUp() {
        var index = size - 1;
        var currentValue = items[index];
        var parentValue = this.getParent(index);

        while (currentValue < parentValue) {
            var parentIndex = IHeap.getParentIndex(index);
            swap(index, parentIndex);
            index = parentIndex;

            currentValue = items[index];
            parentValue = getParent(index);
        }
    }


    private void swap(int index, int parentIndex) {
        var temp = items[index];
        items[index] = items[parentIndex];
        items[parentIndex] = temp;

        Twin<Integer, Integer> pair1= new Twin<Integer, Integer>(index, items[index]);
        Twin<Integer, Integer> pair2= new Twin<Integer, Integer>(parentIndex, items[parentIndex]);

        biConsumer.accept(pair1,pair2);
    }


    public int getParent(int index) {
        return items[IHeap.getParentIndex(index)];
    }

    /* T4_HeapLeftChild */
    public int getLeftChild(int parentIndex) {
        return items[IHeap.getLeftChildIndex(parentIndex)];

    }

    /* T5_HeapRightChild */
    public int getRightChild(int parentIndex) {
        return items[IHeap.getRightChildIndex(parentIndex)];

    }


    public int[] getItems() {
        return items;
    }

    public void setItems(int[] items) {
        this.items = items;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void insertBiConsumer(BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer) {
        this.biConsumer = biConsumer;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "MinHeap{" +
                "items=" + Arrays.toString(items) +
                ", size=" + size +
                '}';
    }


    @Override
    public List<Integer> find(Predicate<EnumComparison> predicate, int value, BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer) {
        List<Integer> result = new ArrayList<>();

        if (predicate.test(EnumComparison.GREATER_THAN)) {
            greaterThan( value, biConsumer, result);
            return result;
        }
        if (predicate.test(EnumComparison.EQUAL)) {
            result.add(equalTo(value, biConsumer));
            return result;
        }
        if (predicate.test(EnumComparison.LESS_THAN)) {
            lessThan( value, biConsumer, result);
            return result;
        }
        if (predicate.test(EnumComparison.MAX)) {
            result.add(getMax(getParent(0), biConsumer));
            return result;
        }
        if (predicate.test(EnumComparison.MIN)) {
            result.add(getParent(0));
            return result;
        }
        return result;
    }

    private int getMax(int value, BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer) {
        if (getParent(0) == -9999) {
            return value;
        }

        Twin<Integer, Integer> pair1 = new Twin<Integer, Integer>(0, getParent(0));
        Twin<Integer, Integer> pair2 = new Twin<Integer, Integer>(0, value);
        biConsumer.accept(pair1, pair2);

        if (isGreaterThan(getParent(0), value)) {
            value = getParent(0);

        }
        remove();
        return getMax(value, biConsumer);
    }

    private void greaterThan( int value, BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer, List<Integer> result) {
        if (getParent(0) == -9999) {
            return;
        }

        Twin<Integer, Integer> pair1 = new Twin<Integer, Integer>(value, getParent(0));
        Twin<Integer, Integer> pair2 = new Twin<Integer, Integer>(value, getParent(0));
        biConsumer.accept(pair1, pair2);

        if (isGreaterThan(getParent(0), value)) {
            result.add(getParent(0));

        }
        remove();
        greaterThan( value, biConsumer, result);

    }

    private Integer equalTo( int value, BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer) {
        Twin<Integer, Integer> pair1 = new Twin<Integer, Integer>(0, getParent(0));
        Twin<Integer, Integer> pair2 = new Twin<Integer, Integer>(0, value);
        biConsumer.accept(pair1, pair2);

        if (isEqual(getParent(0), value)) {
            return value;
        } else {
            if (getParent(0) == -9999) {
                return 0;
            }
            remove();
            return equalTo(value, biConsumer);
        }
    }


    private void lessThan( int value, BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer, List<Integer> result) {
        if (getParent(0) == -9999) {
            return;
        }
        Twin<Integer, Integer> pair1 = new Twin<Integer, Integer>(0, getParent(0));
        Twin<Integer, Integer> pair2 = new Twin<Integer, Integer>(0, value);
        biConsumer.accept(pair1, pair2);

        if (isLessThan(getParent(0), value)) {
            result.add(getParent(0));

        }
        remove();
        lessThan( value, biConsumer, result);

    }
}
