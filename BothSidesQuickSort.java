import java.util.Arrays;

class BothSidesQuickSort {

    /**
     * 快排
     * 
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(array, startIndex, endIndex);
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 分支(双边循环法)
     * 
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */

    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && array[right] > pivot) {
                right--;
            }
            while (left < right && array[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int p = array[left];
                array[left] = array[right];
                array[right] = p;
            }
        }

        array[startIndex] = array[left];
        array[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 8, 4, 3, 5, 10, 9, 11 };
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}