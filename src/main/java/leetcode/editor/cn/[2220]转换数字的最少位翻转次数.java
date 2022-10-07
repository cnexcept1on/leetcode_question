//一次 位翻转 定义为将数字 x 二进制中的一个位进行 翻转 操作，即将 0 变成 1 ，或者将 1 变成 0 。 
//
// 
// 比方说，x = 7 ，二进制表示为 111 ，我们可以选择任意一个位（包含没有显示的前导 0 ）并进行翻转。比方说我们可以翻转最右边一位得到 110 ，或
//者翻转右边起第二位得到 101 ，或者翻转右边起第五位（这一位是前导 0 ）得到 10111 等等。 
// 
//
// 给你两个整数 start 和 goal ，请你返回将 start 转变成 goal 的 最少位翻转 次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：start = 10, goal = 7
//输出：3
//解释：10 和 7 的二进制表示分别为 1010 和 0111 。我们可以通过 3 步将 10 转变成 7 ：
//- 翻转右边起第一位得到：1010 -> 1011 。
//- 翻转右边起第三位：1011 -> 1111 。
//- 翻转右边起第四位：1111 -> 0111 。
//我们无法在 3 步内将 10 转变成 7 。所以我们返回 3 。 
//
// 示例 2： 
//
// 
//输入：start = 3, goal = 4
//输出：3
//解释：3 和 4 的二进制表示分别为 011 和 100 。我们可以通过 3 步将 3 转变成 4 ：
//- 翻转右边起第一位：011 -> 010 。
//- 翻转右边起第二位：010 -> 000 。
//- 翻转右边起第三位：000 -> 100 。
//我们无法在 3 步内将 3 变成 4 。所以我们返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= start, goal <= 10⁹ 
// 
//
// Related Topics 位运算 👍 10 👎 0


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minBitFlips(int start, int goal) {
        int startEnd = start;
        int goalEnd = goal;
        List<Integer> startList = new LinkedList<>();
        List<Integer> goalList = new LinkedList<>();
        int res = 0;

        while (startEnd > 0) {
            startList.add(startEnd % 2);
            startEnd /= 2;
        }

        while (goalEnd > 0) {
            goalList.add(goalEnd % 2);
            goalEnd /= 2;
        }

        for (int i = 0; i < Math.max(startList.size(), goalList.size()); i++) {
            boolean condition1 = (i < startList.size() && i < goalList.size() && !startList.get(i).equals(goalList.get(i)));
            boolean condition2 = (i >= startList.size() && goalList.get(i).equals(1));
            boolean condition3 = (i >= goalList.size() && startList.get(i).equals(1));
            if (condition1 || condition2 || condition3) {
                res++;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
