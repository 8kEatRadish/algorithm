package Test.DanceByte;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(new Test1().convertToTitle(26));
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
