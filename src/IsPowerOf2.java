class IsPowerOf2 {
    public static boolean isPowerOf2(int num) {
        return (num & num - 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2(64));
        System.out.println(isPowerOf2(3));
        System.out.println(isPowerOf2(8));
        System.out.println(isPowerOf2(10));
    }
}