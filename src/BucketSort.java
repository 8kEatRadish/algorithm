import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

class BucketSort {
    /**
     * 桶排序
     * 
     * @param array
     * @return
     */
    public static double[] bucketSort(double[] array){
        //获取最大值和最小值，确认范围
        double max = array[0];
        double min = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        double d = max - min;
        //初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketList.add(new LinkedList<Double>());
        }
        //遍历原始数组，将每个元素放入桶中
        for(int i = 0; i < array.length; i++){
            int num = (int)((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }

        //对每个桶进行排序
        for(int i = 0; i < bucketList.size(); i++){
            Collections.sort(bucketList.get(i));
        }
        //输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for(LinkedList<Double> list : bucketList){
            for(double element : list){
                sortedArray[index] = element;
                index ++;
            }
        }
        return sortedArray;
    }
    public static void main(String[] args) {
        double[] array = new double[]{8.1, 4.1, 3.1, 5.1, 10.1, 9.1, 11.1};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}