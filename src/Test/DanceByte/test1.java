package Test.DanceByte;

public class test1 {
    public static void main(String[] args) {
        System.out.println(new test1().convertToTitle(26));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();

        while (columnNumber != 0) {
            columnNumber--;
            ans.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }

        return ans.reverse().toString();
    }
}
