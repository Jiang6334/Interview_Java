package Future.Tech.leetcode;

public class MinimumDepthOfBinaryTree {
    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了55.65%的用户
     * 内存消耗：58.7 MB, 在所有 Java 提交中击败了64.24%的用户
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left == 0 || right == 0 ? 1 + left + right : 1 + Math.min(left, right);
    }

}
