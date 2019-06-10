import java.util.Arrays;
class FindNextNumber {
    
    /**
     * 找到下一个全排列数
     */
    public static int[] findNearestNumber(int[] numbers){
        int index = findTransferPoint(numbers);
        if(index == 0){
            return null;
        }
        int[] numbersCopy = Arrays.copyOf(numbers,numbers.length);
        exchangeHead(numbersCopy, index);
        reverse(numbersCopy, index);
        return numbersCopy;
    }
    /**
     * 找到逆序边界
     */
    private static int findTransferPoint(int[] number){
        for(int i = number.length - 1; i > 0; i--){
            if(number[i] > number[i - 1]){
                return i;
            }
        }
        return 0;
    }
    /**
     * 把逆序区前一个数和逆序区比他大的最小数交换
     */
    private static int[] exchangeHead(int[] numbers, int index){
        int head = numbers[index - 1];
        for(int i = numbers.length - 1; i > 0; i--){
            if(head < numbers[i]){
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }
    /**
     * 把逆序调整成正序
     * 
     */
    private static int[] reverse(int[] num, int index){
        for(int i = index, j = num.length - 1; i < j; i++, j--){
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }
    /**
     * 输出全排列数
     */
    private static void outputNumber(int[] numbers){
        for(int i : numbers){
            System.out.print(i);
        }
        System.out.println();        
    }
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        //打印12345之后的10个全排列数
        for(int i = 0; i < 10; i++){
            numbers = findNearestNumber(numbers);
            outputNumber(numbers);
        }
    }
}