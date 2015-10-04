public class Sort {

    public static void sort(double[] arr, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            makeHeap(arr, i, size);
        }
        for (int j = size - 1; j > 0; j--) {
            swap(arr, 0, j);
            makeHeap(arr, 0, j);
        }
    }

    public static void makeHeap(double[] arr, int i, int size) {
        int child = 2 * i + 1;

        while (child < size) {
            if (child + 1 < size) {
                if (arr[child] < arr[child + 1]) {
                    child = 2 * i + 2;
                }
            }
            if (arr[i] < arr[child]) {
                swap(arr, child, i);
            } else {
                break;
            }
            i = child;
            child = 2 * i + 1;
        }
    }

    static void swap(double[] arr, int i, int j) {
        double tmp = arr[i];

        arr[i] = arr[j];
        arr[j] = tmp;
    }

     public static void main(String[] args) {
        double[] inArr = new double[args.length];

        for (int i = 0; i < args.length; ++i) {
            inArr[i] = Double.parseDouble(args[i]);
        }
        sort(inArr, args.length);
        for (int i = 0; i < args.length; ++i) {
            System.out.print(inArr[i] + " ");
        }
    }
}
