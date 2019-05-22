import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class stackQuickSort {

    /**
     * 快排（非递归）
     * 
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] array, int startIndex, int endIndex) {
        Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();
        Map rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);
        while (!quickSortStack.isEmpty()) {
            Map<String, Integer> param = quickSortStack.pop();
            int pivotIndex = partition(array, param.get("startIndex"), param.get("endIndex"));
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<String, Integer>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<String, Integer>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    /**
     * 分治
     * 
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int mark = startIndex;
        for (int i = startIndex; i <= endIndex; i++) {
            if (array[i] < pivot) {
                mark++;
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