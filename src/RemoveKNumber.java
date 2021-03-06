class RemoveKNumber {
    /**
     * 删除整数的k个数，获取到删除后的最小值
     * @param num
     * @param k
     * @return
     */
    public static String removeKDigits(String num, int k){
        String numNew = num;
        for(int i = 0; i < k; i++){
            boolean hasCut = false;
            for(int j = 0; j < numNew.length() - 1; j++){
                if(numNew.charAt(j) > numNew.charAt(j + 1)){
                    numNew = numNew.substring(0, j) + numNew.substring(j + 1, numNew.length());
                    hasCut = true;
                    break;
                }
            }
            if(!hasCut){
                numNew = numNew.substring(0, numNew.length() - 1);
            }
            numNew = removeZero(numNew);
        }
        if(numNew.length() == 0){
            return "0";
        }
        return numNew;
    }
    /**
     * 去掉左边的0
     * @param num
     * @return
     */
    private static String removeZero(String num){
        for(int i = 0; i < num.length() - 1; i++){
            if(num.charAt(0) != '0'){
                break;
            }
            num = num.substring(1, num.length());
        }
        return num;
    }
    public static void main(String[] args) {
        System.out.println(removeKDigits("1243567", 3));
        System.out.println(removeKDigits("30200", 1));
        System.out.println(removeKDigits("10", 2));
        System.out.println(removeKDigits("456372524", 3));
    }
}