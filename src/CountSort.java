import java.util.Arrays;

class CountSort {
    /**
     * 计数排序
     * 
     * @param array
     * @return
     */
    public static int[] countSort(int[] array) {
        int max = array[0];
        int min = array[0];
        // 找到最大值与最小值，确定数组范围
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        // 创建计数数组，统计对应元素的个数
        int[] countArray = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }

        // 统计数组变形，后面元素等于前面元素之和
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        // 倒序遍历原始数组，从统计数组找到正确的位置，输出到结果数组
        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 8, 4, 3, 5, 10, 9, 11 };
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}