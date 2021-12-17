package edu.citytech.cst3650.ss23953296.heap;

import com.jbbwebsolutions.datastructure.IHeap;
import com.jbbwebsolutions.datastructure.Twin;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class MinHeap implements IHeap {
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

    public void insert(int value) {
        items[size] = value;
        ++size;
        bubbleUp();
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
}
