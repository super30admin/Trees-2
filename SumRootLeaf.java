/**
// Time Complexity :O(n) go over all the nodes just once.
// Space Complexity : O(n) stack memory for all node recursion +
                      O(m) m = all root to leaf paths.
                      O(m+n)
// Did this code successfully run on Leetcode :yes

// Your code here along with comments explaining your approach
 */
class Solution {
    public int sumNumbers(TreeNode root) {

        int sum = 0;
        //list to get all root to leaf numbers.
        List<Integer> pathList = new ArrayList<>();
        helper(root, 0, pathList);

        //add all the numbers in list.
        for(int num : pathList)
            sum += num;
        return sum;
    }
    private void helper(TreeNode node, int num, List<Integer>pList){
        if(node == null)
            return ;

        //walk preorder , strt creating number.
        num = (num*10)+node.val;

        //number gets added to list only if leaf node.
        if(node.left == null && node.right == null){
            pList.add(num);
            return;
        }

        helper(node.left, num, pList);
        helper(node.right, num, pList);
    }
}
