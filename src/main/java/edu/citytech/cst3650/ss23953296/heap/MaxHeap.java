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

public class MaxHeap implements IHeap, IHeapQuery {
    private int[] items = new int[10];
    private int size = 0;
    private BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer = (e1, e2) -> {
    };


    public void inserts(int... values) {
        for (var value :
                values
        ) {
            this.insert(value);
        }
    }

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

    public void insert(int value) {
        items[size++] = value;

        bubbleUp();
    }

    private void bubbleUp() {
        var index = size - 1;
        var currentValue = items[index];
        var parentValue = this.getParent(index);

        while (currentValue > parentValue) {
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

        Twin<Integer, Integer> pair1 = new Twin<Integer, Integer>(index, items[index]);
        Twin<Integer, Integer> pair2 = new Twin<Integer, Integer>(parentIndex, items[parentIndex]);

        biConsumer.accept(pair1, pair2);
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
        return "MaxHeap{" +
                "items=" + Arrays.toString(items) +
                ", size=" + size +
                '}';
    }
    @Override
    public List<Integer> find(Predicate<EnumComparison> predicate, int value, BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer) {
        boolean greaterThan = predicate.test(EnumComparison.GREATER_THAN);
        boolean equalTo = predicate.test(EnumComparison.EQUAL);
        boolean lessThan = predicate.test(EnumComparison.LESS_THAN);
        boolean minElem = predicate.test(EnumComparison.MIN);
        boolean maxElem = predicate.test(EnumComparison.MAX);
        List<Integer> result = new ArrayList<>();


        if (greaterThan) {
            int index = 0;
            result.add(greaterThan(index, getParent(0), value, biConsumer));
            return result;
        }
        if (equalTo) {
            int index = 0;
            result.add(equalTo(index, getParent(0), value, biConsumer));
            return result;
        }
        if (lessThan) {
            int index = -1;
            result.add(lessThan(index, getParent(0), value, biConsumer));
            return result;
        }
        if (minElem) {
        }
        return result;
    }

    private int greaterThan(int index, int currentValue, int value, BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer) {

        if (currentValue < value) {

            return greaterThan(index, getRightChild(index), value, biConsumer);
        }
        if (currentValue > value) {

            return greaterThan(index, getLeftChild(index), value, biConsumer);
        }
        return 0;
    }

    private Integer equalTo(int index, int currentValue, int value, BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer) {
        Twin<Integer, Integer> pair1 = new Twin<Integer, Integer>(index, getParent(index));
        Twin<Integer, Integer> pair2 = new Twin<Integer, Integer>(index, items[index]);
        biConsumer.accept(pair1, pair2);
        index ++;
        System.out.println(index);
        System.out.println(currentValue);
        System.out.println("---------");
        if (currentValue == value) {
            return value;
        }
        if (value > currentValue) {
            return equalTo(index, getRightChild(index), value, biConsumer);
        }

        return equalTo(index, getLeftChild(index), value, biConsumer);
    }


    private int lessThan(int index, int currentValue, int value, BiConsumer<Twin<Integer, Integer>, Twin<Integer, Integer>> biConsumer) {
        if (currentValue == value) {
            return lessThan(index, getLeftChild(index), value, biConsumer);
        }
        return 0;

    }

}
