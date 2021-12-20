package edu.citytech.cst3650.ss23953296.heap;

import com.jbbwebsolutions.datastructure.IGenericHeap;
import com.jbbwebsolutions.datastructure.IGenericHeapQuery;
import com.jbbwebsolutions.datastructure.IHeap;
import com.jbbwebsolutions.datastructure.Twin;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class MinGenericHeap <T extends Comparable<T>> implements IGenericHeap<T> , IGenericHeapQuery {

    private final Object[] items = new Object[10];

    @Override
    public List find(Predicate predicate, Comparable value, BiConsumer biConsumer) {
        return IGenericHeapQuery.super.find(predicate, value, biConsumer);
    }

    private int size = 0;
    private BiConsumer<Twin<Integer, T>, Twin<Integer, T>> biConsumer = (e1, e2) -> {
    };

    @Override
    public void inserts(T[] values) {
        for (var value : values) {
            this.insert(value);
        }
    }

    @Override
    public void insert(T value) {
        items[size++] = value;
        bubbleUp();
    }

    private void bubbleUp() {
        var index = size - 1;
        var currentValue = getItem(index);
        var parentValue = this.getParent(index);

        while (currentValue.compareTo(parentValue) < 0) {
            var parentIndex = IHeap.getParentIndex(index);
            swap(index, parentIndex);
            index = parentIndex;

            currentValue = getItem(index);
            parentValue = getParent(index);
        }
    }

    private void swap(int index, int parentIndex) {
        var temp = getItem(index);
        items[index] = items[parentIndex];
        items[parentIndex] = temp;

        Twin<Integer, T> pair1 = new Twin<>(index, getItem(index));
        Twin<Integer, T> pair2 = new Twin<>(parentIndex, getItem(parentIndex));

        biConsumer.accept(pair1, pair2);
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
        return getLeftChild(index).compareTo(getRightChild(index)) > 0
                ? IHeap.getLeftChildIndex(index)
                : IHeap.getRightChildIndex(index);
    }

    private boolean isInvalidParent(int index) {
        return getItem(index).compareTo(getLeftChild(index)) < 0
                && getItem(index).compareTo(getRightChild(index)) < 0;
    }

    @Override
    public T getParent(int index) {
        return getItem(IHeap.getParentIndex(index));
    }

    @Override
    public T getLeftChild(int parentIndex) {
        return getItem(IHeap.getLeftChildIndex(parentIndex));
    }

    @Override
    public T getRightChild(int parentIndex) {
        return getItem(IHeap.getRightChildIndex(parentIndex));
    }

    @Override
    public int getSize() {
        return size;
    }

    private T getItem(int index) {
        return (T) items[index];
    }

    @Override
    public void insertBiConsumer(BiConsumer<Twin<Integer, T>, Twin<Integer, T>> biConsumer) {
        this.biConsumer = biConsumer;
    }
}

