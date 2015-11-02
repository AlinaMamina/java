package ru.spbstu.app_math.mamina;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;

@RunWith(Parameterized.class)
public class TestHeapSort<T> {
    private Sort<T> sort;
    private T[] input;
    private Comparator<T> comparator;

    public TestHeapSort(Sort<T> sort, T[] input, Comparator<T> comparator) {
        this.sort = sort;
        this.input = input;
        this.comparator = comparator;
    }

    private static final HeapSort HEAP_SORT = new HeapSort();

    private static final Comparator<Double> DOUBLE_COMPARATOR1 = new Comparator<Double>() {
        public int compare(final Double value1, final Double value2) {
            return value1.compareTo(value2);
        }
    };
    private static final Comparator<Double> DOUBLE_COMPARATOR2 = new Comparator<Double>() {
        public int compare(final Double value1, final Double value2) {
            return value2.compareTo(value1);
        }
    };
    private static final Comparator<Person> PERSON_NAME_COMPARATOR = new Comparator<Person>() {
        public int compare(final Person name1, final Person name2) {
            return (name1.getName()).compareTo(name2.getName());
        }
    };
    private static final Comparator<Person> PERSON_AGE_COMPARATOR = new Comparator<Person>() {
        public int compare(final Person age1, final Person age2) {
            return (age1.getAge()).compareTo(age2.getAge());
        }
    };

    private static final Object[][] TEST_DATA = new Object[][]{
            {HEAP_SORT, randomDoubleArray(5), DOUBLE_COMPARATOR1},
            {HEAP_SORT, randomDoubleArray(13), DOUBLE_COMPARATOR1},
            {HEAP_SORT, new Double[]{}, DOUBLE_COMPARATOR1},
            {HEAP_SORT, new Double[]{1.0, 1.0, 1.0, 1.0}, DOUBLE_COMPARATOR1},
            {HEAP_SORT, randomDoubleArray(10), DOUBLE_COMPARATOR2},
            {HEAP_SORT, randomDoubleArray(8), DOUBLE_COMPARATOR2},
            {HEAP_SORT, new Double[]{1.0, 1.0, 2.0, 3.0, 5.0}, DOUBLE_COMPARATOR2},
            {HEAP_SORT, new Double[]{6.0, 3.0, 2.0, 2.0, 1.0}, DOUBLE_COMPARATOR2},
            {HEAP_SORT, new Person[]
                    {new Person("Alina", 20), new Person("Alina", 19)}, PERSON_NAME_COMPARATOR},
            {HEAP_SORT, new Person[]
                    {new Person("A", 20), new Person("B", 19), new Person("C", 0), new Person("D", 0)}, PERSON_NAME_COMPARATOR},
            {HEAP_SORT, new Person[]
                    {new Person("Merlin", 20), new Person("Genry", 19), new Person("Artur", 19), new Person("Emma", 19)}, PERSON_NAME_COMPARATOR},
            {HEAP_SORT, new Person[]{}, PERSON_NAME_COMPARATOR},
            {HEAP_SORT, new Person[]{}, PERSON_AGE_COMPARATOR},
            {HEAP_SORT, new Person[]
                    {new Person("P", 10), new Person("O", 10), new Person("N", 10), new Person("M", 10)}, PERSON_AGE_COMPARATOR},
            {HEAP_SORT, new Person[]
                    {new Person("Frodo", 10), new Person("Sauron", 9), new Person("Nice", 7), new Person("Mac", 6)}, PERSON_AGE_COMPARATOR},
            {HEAP_SORT, new Person[]
                    {new Person("Harry", 15), new Person("Ron", 9), new Person("Draco", 17), new Person("Rimus", 46)}, PERSON_AGE_COMPARATOR}
    };

    private static Double[] randomDoubleArray(final int size) {
        Random rand = new Random();
        Double[] array = new Double[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextDouble();
        }
        return array;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(TEST_DATA);
    }

    @Test
    public void test() {
        T[] result = sort.sort(input, comparator);

        Assert.assertTrue("The array is not sorted", testAscendingOrder(result, comparator));
        Assert.assertEquals("Result array length should be equal to original", input.length, result.length);
        Assert.assertTrue(hasEachElementOf(input, result, comparator));
    }

    private boolean testAscendingOrder(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            if (comparator.compare(array[i], array[i + 1]) > 0)
                return false;
        }
        return true;
    }

    private boolean hasEachElementOf(T[] input, T[] result, Comparator<T> comparator) {
        for (T element : input) {
            int count = 0;
            for (int j = 0; j < result.length; j++) {
                if (comparator.compare(result[j], element) == 0)
                    count++;
                if (comparator.compare(input[j], element) == 0)
                    count--;
            }
            if (count != 0)
                return false;
        }
        return true;
    }
}

