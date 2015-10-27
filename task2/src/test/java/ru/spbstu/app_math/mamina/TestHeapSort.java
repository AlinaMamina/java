package ru.spbstu.app_math.mamina;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

@RunWith(Parameterized.class)
public class TestHeapSort<T> {
    private static final HeapSort HEAP_SORT = new HeapSort();
    private static final Comparator<Double> DOUBLE_COMPARATOR = new Comparator<Double>() {
        public int compare(final Double value1, final Double value2) {
            return value1.compareTo(value2);
        }
    };
    private static final Comparator<Person> PERSON_NAME_COMPARATOR = new Comparator<Person>() {
        public int compare(Person name1, Person name2) {
            return (name1.getName()).compareTo(name2.getName());
        }
    };
    private static final Comparator<Person> PERSON_AGE_COMPARATOR = new Comparator<Person>() {
        public int compare(final Person age1, final Person age2) {
            return (age1.getAge()).compareTo(age2.getAge());
        }
    };

    private static final Object[][] TEST_DATA = {
            {HEAP_SORT, new Double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0}, DOUBLE_COMPARATOR},
            {HEAP_SORT, new Double[]{12.02, 83.09, 7182.93, 78.09}, DOUBLE_COMPARATOR},
            {HEAP_SORT, new Double[]{10.05, 9.05, 8.05}, DOUBLE_COMPARATOR},
            {HEAP_SORT, new Person[]
                    {new Person("Alina", 20), new Person("Veronika", 19)}, PERSON_NAME_COMPARATOR},
            {HEAP_SORT, new Person[]
                    {new Person("A", 2), new Person("B", 3), new Person("C", 5)}, PERSON_AGE_COMPARATOR},
            {HEAP_SORT, new Person[]
                    {new Person("P", 10), new Person("O", 10), new Person("N", 10), new Person("M", 10)}, PERSON_NAME_COMPARATOR}
    };


    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(TEST_DATA);
    }

    private Sort<T> sort;
    private T[] input;
    private Comparator<T> comparator;

    public TestHeapSort(Sort<T> sort, T[] input, Comparator<T> comparator) {
        this.sort = sort;
        this.input = input;
        this.comparator = comparator;
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
            for (int j = 0; j < result.length; j++) {
                if (result[j] == element)
                    break;
                if (j == result.length - 1)
                    return false;
            }
        }
        return true;
    }
}

