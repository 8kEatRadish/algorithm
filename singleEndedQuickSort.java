import java.util.Arrays;

class singleEndedQuickSort {

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
     * 分治(单边循环法)
     * 
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */

    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int mark = startIndex;
        for(int i = startIndex + 1; i <= endIndex; i++){
            if(array[i] < pivot){
                mark ++;
                int p = array[mark];
                array[mark] = array[i];
                array[i] = p;
            }
        }

        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 8, 4, 3, 5, 10, 9, 11 };
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}