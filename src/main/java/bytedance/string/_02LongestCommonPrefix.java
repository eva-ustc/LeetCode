package bytedance.string;

import java.util.HashSet;

/**
 * @author LRK
 * @date 2019/4/5 21:53
 * @project LeetCode
 * description:
 * God Bless, No Bug!
 * <p>
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class _02LongestCommonPrefix {

    public static void main(String[] args) {
        String[] data = {""};
        System.out.println(new _02LongestCommonPrefix().longestCommonPrefix(data));
    }

    /**
     * 大概有这五种思路, 一般都会采用第四种, 但是耗时太多
     *
     * 1、所求的最长公共前缀子串一定是每个字符串的前缀子串。
     *      所以随便选择一个字符串作为标准，把它的前缀串，与其他所有字符串进行判断，看是否是它们所有人的前缀子串。
     *      这里的时间性能是O(m*n*m)。
     *
     * 2、列出所有的字符串的前缀子串，将它们合并后排序，找出其中个数为n且最长的子串。时间性能为O(n*m+m*n*log(m*n))
     *
     * 3、纵向扫描：从下标0开始，判断每一个字符串的下标0，判断是否全部相同。直到遇到不全部相同的下标。时间性能为O(n*m)。
     *
     * 4、横向扫描：前两个字符串找公共子串，将其结果和第三个字符串找公共子串……直到最后一个串。时间性能为O(n*m)。
     *
     * 5、借助trie字典树。将这些字符串存储到trie树中。那么trie树的第一个分叉口之前的单分支树的就是所求。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = "", firstStr = strs[0];
        int index = 0;
        while (index < firstStr.length()) {
            prefix += firstStr.charAt(index);
            if (isAllStartWithPrefix(strs, prefix)) {
                index++;
            } else {
                break;
            }
        }
        return index != 0 ? firstStr.substring(0, index) : "";
    }

    public boolean isAllStartWithPrefix(String[] strs, String prefix) {
        for (String s : strs) {
            if (!s.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}
