import java.util.Arrays;

/**
 * @author sniperking
 */
public class HeapSort {

    /**
     * 下沉调整
     * 
     * @param array
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            if (temp > array[childIndex])
                break;
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 堆排序（首先构建最大堆，然后交换头尾，做下沉操作）
     * 
     * @param array
     */
    public static void heapSort(int[] array) {
        // 构建最大堆
        for (int i = array.length / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            downAdjust(array, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] { 8, 4, 3, 5, 10, 9, 11 };
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}