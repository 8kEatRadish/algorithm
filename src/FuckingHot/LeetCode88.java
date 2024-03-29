package FuckingHot;

/**
 *
 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 */
public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m -1;
        int p2 = n - 1;

        int tail = n + m -1;
        int temp ;

        while(p1 >= 0 || p2 >= 0){
            if(p1 == -1){
                temp = nums2[p2--];
            }else if (p2 == -1){
                temp = nums1[p1--];
            }else if (nums1[p1] > nums2[p2]){
                temp = nums1[p1--];
            }else{
                temp = nums2[p2--];
            }

            nums1[tail--] = temp;

        }
    }
}
