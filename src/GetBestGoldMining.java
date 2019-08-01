class GetBestGoldMining {
    /**
     * 
     * @param w 工人总数
     * @param p 每个金矿需要工人
     * @param g 每个金矿的总收益
     * @return 得到金子的最优解
     */
    public static int getBestGoldMining(int w, int[] p, int[] g) {
        int[] results = new int[w + 1];
        for (int i = 1; i <= g.length; i++) {
            for (int j = w; j >= 1; j--) {
                if (j >= p[i - 1]) {
                    results[j] = Math.max(results[j], results[j - p[i - 1]] + g[i - 1]);
                }
            }
        }
        return results[w];
    }

    public static void main(String[] args) {
        System.out.println("最优解为："
                + getBestGoldMining(10, new int[] { 5, 5, 3, 4, 3 }, new int[] { 400, 500, 200, 300, 350 }) + "kg");
    }
}