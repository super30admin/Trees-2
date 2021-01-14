/**
 * Time complexity - O(n)
 * Space complexity - O(h)
 */
class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        return count(root,0);
    }
    public int count(TreeNode root, int currsum) {
        if(root==null)
            return currsum;
        currsum = currsum*10+root.val;

        count(root.left,currsum);

        if(root.left==null&&root.right==null)
        {
            result+=currsum;
        }

        count(root.right,currsum);

        return result;
    }
}