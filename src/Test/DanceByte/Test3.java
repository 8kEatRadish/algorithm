package Test.DanceByte;

/**
 * 给你一个文件，并且该文件只能通过给定的 read4 方法来读取，请实现一个方法使其能够读取 n 个字符。注意：你的 read 方法可能会被调用多次。
 */
public class Test3 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private char[] fileBuf = new char[4];   // read4 读到的数据存到这里
    private int readOffset = 0; // 指向 fileBuf 尚未使用的开头索引
    private int bufSize = 0;    // 最近一次从 read4 读到的数据有多少个

    public int read(char[] buf, int n) {
        for (int i = 0; i < n; i++) {
            char nextChar = getNextCharFromFile();
            if (nextChar == 0) {
                return i;
            } else {
                buf[i] = nextChar;
            }
        }
        return n;
    }

    public char getNextCharFromFile() {
        // 比如最近一次 read4 读到的有效数据有 2 个，此时 readOffset == 2，说明 fileBuf 已经没有未使用的数据，需要重新 read4
        if (readOffset == bufSize) {
            bufSize = read4(fileBuf);
            readOffset = 0;
            if (bufSize == 0) {
                return 0;
            }
        }
        // readOffset 永远指向尚未读取的数据的最开头
        return fileBuf[readOffset++];
    }

    //假的
    private int read4(char[] fileBuf) {
        return 0;
    }
}
